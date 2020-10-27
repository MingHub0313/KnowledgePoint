package com.zmm.day0714;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Name RedPackets1
 * @Author 900045
 * @Created by 2020/7/16 0016
 */
public class RedPackets1 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			methodTwo();
		}
	}

	private static void methodTwo(){
		List<Integer> accountList = divide(BigDecimal.valueOf(0.2), 20);
		BigDecimal count = new BigDecimal(0);
		for (Integer amount : accountList) {
			//将抢到的金额再除以100进行还原
			BigDecimal bigDecimal = new BigDecimal(amount).divide(new BigDecimal(100));
			count = count.add(bigDecimal);
			System.out.print(bigDecimal + "元    ");
		}
		System.out.print(" 总额：" + count +"元 ");
		System.out.println();
	}

	/**
	 * 拆分金额
	 * @param totalAmount
	 * @param totalPersonNumber
	 * @return
	 */
	private static List<Integer> divide(BigDecimal totalAmount, Integer totalPersonNumber) {
		//验证参数合理校验
		//为了使用random.nextInt(Integer)方法不得不先把红包金额放大100倍，最后在main函数里面再除以100
		//这样就可以保证每个人抢到的金额都可以精确到小数点后两位
		int fen = totalAmount.multiply(BigDecimal.valueOf(100)).intValue();
		if (fen < totalPersonNumber || totalPersonNumber < 1) {
			System.out.println("红包个数必须大于0，并且最小红包不少于1分");
		}
		List<Integer> boards = new ArrayList<>();
		boards.add(0);
		boards.add(fen);
		//红包个数和板砖个数的关系
		while (boards.size() <= totalPersonNumber) {
			int index = new Random().nextInt(fen - 1) + 1;
			if (boards.contains(index)) {
				//保证板子的位置不相同
				continue;
			}
			boards.add(index);
		}

		//计算每个红包的金额，将两个板子之间的钱加起来
		Collections.sort(boards);

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < boards.size() - 1; i++) {
			Integer e = boards.get(i + 1) - boards.get(i);
			list.add(e);
		}

		Collections.sort(list,Collections.reverseOrder());
		return list;

	}
}
