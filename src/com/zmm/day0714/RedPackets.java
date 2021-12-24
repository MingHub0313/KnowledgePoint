package com.zmm.day0714;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Name RedPackets
 * @Author 900045
 * @Created by 2020/7/15 0015
 */
public class RedPackets {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            methodTwo();
        }

    }

    private static void methodTwo() {
        int totalPersonNumber = 20;
        BigDecimal b = new BigDecimal(0);
        Double totalMoney = 0.2;
        List<BigDecimal> redPacketList = new ArrayList<>(totalPersonNumber);

        BigDecimal leftMoney = new BigDecimal(totalMoney);

        RedPacketConfig config = configMake(totalMoney, totalPersonNumber);

        for (int i = 1; i <= totalPersonNumber; i++) {
            BigDecimal redPacketMoney = fx(i, config);
            leftMoney = leftMoney.subtract(redPacketMoney);
            redPacketList.add(redPacketMoney);
        }
        repairData(leftMoney, redPacketList, config);
        // 随机打乱每人获得金额
        Collections.shuffle(redPacketList);
        Collections.sort(redPacketList, Collections.reverseOrder());
        for (BigDecimal bigDecimal : redPacketList) {
            System.out.print(bigDecimal + "元    ");
            b = b.add(bigDecimal);
        }
        System.out.print("   总额：" + b + "元 ");
        System.out.println();
    }

    private static RedPacketConfig configMake(Double redPacketMoney, Integer redPacketNum) {
        RedPacketConfig config = new RedPacketConfig();
        Double avg = redPacketMoney * 1.00 / redPacketNum;
        config.setTotalMoney(redPacketMoney);
        config.setNumber(redPacketNum);
        config.setMaxMoney(makeMaxRedPacket(avg));
        config.setMinMoney(makeMinRedPacket(avg));
        config.setFormatType(RedPacketFormatTypeEnum.NO_LEFT);
        return config;
    }

    private static void repairData(BigDecimal leftMoney, List<BigDecimal> redPacketList, RedPacketConfig config) {

        int getFormatType = 1;

        // 剩余红包为零，不需要修复数据
        if (leftMoney.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }

        // 数组为空
        if (redPacketList.size() < 1) {
            return;
        }

        if (getFormatType == RedPacketFormatTypeEnum.CAN_LEFT.code && leftMoney.compareTo(BigDecimal.ZERO) > 0) {
            return;
        }

        // 如果还有钱，则尝试添加到小红包里面去，如果加不进去，则尝试下一个
        BigDecimal increment = new BigDecimal("0.01");
        DecimalFormat df = new DecimalFormat("0.00");
        while (leftMoney.compareTo(BigDecimal.ZERO) > 0) {
            int found = 0;
            for (int i = 0; i < redPacketList.size(); i++) {
                // 当余额不足时，跳出循环
                BigDecimal redPacket = redPacketList.get(i);
                if (leftMoney.compareTo(BigDecimal.ZERO) <= 0) {
                    break;
                }

                // 预判
                BigDecimal afterLeftMoney = leftMoney.subtract(increment);
                BigDecimal afterVal = redPacket.add(increment);
                if (afterLeftMoney.compareTo(BigDecimal.ZERO) >= 0 && afterVal.doubleValue() <= config.getMaxMoney()) {
                    found = 1;
                    redPacketList.set(i, new BigDecimal(df.format(afterVal)));
                    leftMoney = afterLeftMoney;
                }
            }
            //如果没有可以加的红包，需要结束,否则死循环
            //也就是会出现每个红包不分钱的情况，比如红包都已经最大值。这时必须在分的时候给予标志，防止死循环。
            if (found == 0) {
                break;
            }
        }

        //如果leftMoney < 0 ,说明生成的红包超过预算了，需要减少部分红包金额
        while (leftMoney.compareTo(BigDecimal.ZERO) < 0) {
            int found = 0;
            for (int i = 0; i < redPacketList.size(); i++) {
                BigDecimal redPacket = redPacketList.get(i);
                if (leftMoney.compareTo(BigDecimal.ZERO) >= 0) {
                    break;
                }

                // 预判
                BigDecimal afterLeftMoney = leftMoney.add(increment);
                BigDecimal afterVal = redPacket.subtract(increment);
                if (afterLeftMoney.compareTo(BigDecimal.ZERO) <= 0 && afterVal.doubleValue() >= config.getMinMoney()) {
                    found = 1;
                    redPacketList.set(i, new BigDecimal(df.format(afterVal)));
                    leftMoney = afterLeftMoney;
                }
            }

            //如果一个减少的红包都没有的话，需要结束，否则死循环
            if (found == 0) {
                break;
            }
        }
    }

    /**
     * 计算红包最大值
     *
     * @param avg
     * @return java.lang.Double
     * @author 000
     * @Description makeMaxRedPacket
     * @Date 16:35 2019/10/29 0029
     */
    private static Double makeMaxRedPacket(Double avg) {
        return 1.00 * avg * 2 - 0.01;
    }


    /**
     * 计算红包最小值
     *
     * @param avg
     * @return java.lang.Double
     * @author 000
     * @Description makeMinRedPacket
     * @Date 16:35 2019/10/29 0029
     */
    private static Double makeMinRedPacket(Double avg) {
        double min = 1.00 * avg / 2;
        if (0.01 == min) {
            return min;
        }
        return min - 0.01;
    }

    /**
     * 随机红包生成函数。三角函数。[(1,0.01),(num/2,avgMoney),(num,0.01)]
     *
     * @param x, config
     * @return java.math.BigDecimal
     * @author 000
     * @Description fx
     * @Date 16:08 2019/10/28 0028
     */
    private static BigDecimal fx(int x, RedPacketConfig config) {

        if (x < 1) {
            return BigDecimal.ZERO;
        }

        // 起始点
        int x1 = 1;
        Double y1 = config.getMinMoney();

        // 中间点计算
        Double x2 = Math.ceil(config.getNumber() / 1.0 / 2);
        // 峰值
        Double y2 = config.getMaxMoney();

        // 最后点
        int x3 = config.getNumber();
        Double y3 = config.getMinMoney();

        // 当x1,x2,x3都是1的时候（竖线）
        if (x1 == x2 && x2 == x3) {
            return new BigDecimal(y2.toString());
        }


        DecimalFormat df = new DecimalFormat("0.00");
        BigDecimal bigDecimalX = new BigDecimal(x);
        BigDecimal bigDecimalX1 = new BigDecimal(x1);
        BigDecimal bigDecimalX2 = new BigDecimal(x2);
        BigDecimal bigDecimalX3 = new BigDecimal(x3);

        BigDecimal bigDecimalY1 = new BigDecimal(y1.toString());
        BigDecimal bigDecimalY2 = new BigDecimal(y2.toString());
        BigDecimal bigDecimalY3 = new BigDecimal(y3.toString());


        /**
         * 等腰三角形线性方程
         * 第一条腰部分
         * x：当前红包位置；x1：系数；x2：中间点
         * y1：红包最小值；y2：红包最大值
         */
        if (x1 != x2 && x >= x1 && x <= x2) {
            // 算法：y = 1.0 * (x - x1) / (x2 - x1) * (y2 -y1) + y1;
            BigDecimal num1 = bigDecimalX.subtract(bigDecimalX1);
            BigDecimal num2 = bigDecimalX2.subtract(bigDecimalX1);
            BigDecimal num3 = bigDecimalY2.subtract(bigDecimalY1);
            BigDecimal y = num1.divide(num2, 2, RoundingMode.HALF_UP).multiply(num3).add(bigDecimalY1);
            return new BigDecimal(df.format(y));
        }

        /**
         * 第二条腰部分
         */
        if (x2 != x3 && x >= x2 && x <= x3) {
            // 算法：y = 1.0 * (x - x2) / (x3 - x2) * (y3 - y2) + y2;
            BigDecimal num4 = bigDecimalX.subtract(bigDecimalX2);
            BigDecimal num5 = bigDecimalX3.subtract(bigDecimalX2);
            BigDecimal num6 = bigDecimalY3.subtract(bigDecimalY2);
            BigDecimal y = num4.divide(num5, 2, RoundingMode.HALF_UP).multiply(num6).add(bigDecimalY2);
            return new BigDecimal(df.format(y));
        }

        return BigDecimal.ZERO;
    }
}
