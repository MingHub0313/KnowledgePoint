package com.zmm.day0714;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Name CalculateTest
 * @Author 900045
 * @Created by 2020/7/14 0014
 */
public class CalculateTest {

    @Test
    public void redPacket() {
        //distributeRedPacket(new BigDecimal(20),10);
        for (int i = 0; i < 10; i++) {
            methodTwo();
        }
        //methodTwo();
        //createBonusList(20, 10);
    }


    private int getRandomVal(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 随机分配第n个红包
     *
     * @param totalBonus  总红包量
     * @param totalNum    总份数
     * @param sendedBonus 已发送红包量
     * @param sendedNum   已发送份数
     * @param rdMin       随机下限
     * @param rdMax       随机上限
     * @return
     */
    private Integer randomBonusWithSpecifyBound(Integer totalBonus, Integer totalNum, Integer sendedBonus,
                                                Integer sendedNum, Integer rdMin, Integer rdMax) {

        Integer boundMin = Math.max((totalBonus - sendedBonus - (totalNum - sendedNum - 1) * rdMax), rdMin);
        Integer boundMax = Math.min((totalBonus - sendedBonus - (totalNum - sendedNum - 1) * rdMin), rdMax);
        return getRandomVal(boundMin, boundMax);
    }

    /**
     * 生成红包一次分配结果
     *
     * @param totalBonus 总红包量
     * @param totalNum   总份数
     * @return
     */
    public List<Integer> createBonusList(Integer totalBonus, Integer totalNum) {
        Integer sendedBonus = 0;
        Integer sendedNum = 0;
        Integer rdMin = (int) (totalBonus / totalNum * 0.1);
        Integer rdMax = (int) (totalBonus / totalNum * 1.9);
        List<Integer> bonusList = new ArrayList<>();
        while (sendedNum < totalNum) {
            Integer bonus = randomBonusWithSpecifyBound(totalBonus, totalNum, sendedBonus, sendedNum, rdMin, rdMax);
            bonusList.add(bonus);
            sendedNum++;
            sendedBonus += bonus;
        }
        System.out.println(bonusList);
        return bonusList;
    }

    private void methodTwo() {
        List<BigDecimal> moneys = math(BigDecimal.valueOf(0.21), 20);
        if (moneys != null) {
            BigDecimal b = new BigDecimal(0);
            for (BigDecimal bigDecimal : moneys) {
                System.out.print(bigDecimal + "元    ");
                b = b.add(bigDecimal);
            }
            System.out.print("   总额：" + b + "元 ");
            System.out.println();
        }
    }

    private Map<Long, Double> distribution(Double totalMoney, Integer totalPersonNumber) {
        Map<Long, Double> map = new HashMap<>();
        double v = (totalMoney / totalPersonNumber) * 2;
        return map;
    }

    private List<BigDecimal> math(BigDecimal totalAmount, int number) {

        if (totalAmount.doubleValue() < number * 0.01) {
            return null;
        }
        Random random = new Random();
        // 金钱，按 分 计算 10块等于 1000分

        int money = totalAmount.multiply(BigDecimal.valueOf(100)).intValue();

        // 随机数总额
        double count = 0;

        // 每人获得随机点数

        double[] arrRandom = new double[number];
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 每人获得钱数
        List<BigDecimal> arrMoney = new ArrayList<BigDecimal>(number);

        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            if (i < arrRandom.length - 1) {
                arrMoney.add(new BigDecimal(m).divide(new BigDecimal(100)));
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                arrMoney.add(new BigDecimal(money - c + m).divide(new BigDecimal(100)));
            }
        }
        repairData(totalAmount, arrMoney);
        // 随机打乱每人获得金额
        Collections.shuffle(arrMoney);
        Collections.sort(arrMoney, Collections.reverseOrder());
        return arrMoney;
    }

    private void repairData(BigDecimal leftMoney, List<BigDecimal> redPacketList) {

    }


    private boolean repetition(double[] arrRandom, int x) {
        for (double random : arrRandom) {
            if (random == x) {
                return true;
            }
        }
        return false;
    }

    public void distributeRedPacket(BigDecimal totalAmount, int num) {
        int amount = totalAmount.multiply(new BigDecimal("100")).intValue();
        Set<Integer> points = new TreeSet<>();

        Random random = new Random();

        while (points.size() < num - 1) {
            points.add(random.nextInt(amount - 1) + 1);
        }

        points.add(amount);
        double beforeAmount = 0.00;
        int before = 0;
        for (int point : points) {
            double result = (double) (point - before) / 100;
            System.out.println(result);
            before = point;
            beforeAmount += result;
        }
        System.out.println("结果:" + beforeAmount);
    }
}
