package com.zmm.design.mode.factory;

/**
 * @author 900045
 * @description:
 * @name SimpleFactoryPattern
 * @date By 2021-04-30 17:16:23
 */
public class SimpleFactoryPattern {

  public static void main(String[] args) {
	  //客户要产品A
	  try {
		  //调用工厂类的静态方法 & 传入不同参数从而创建产品实例
		  Factory.Manufacture("A").method1();
	  }catch (NullPointerException e){
		  System.out.println("没有这一类产品");
	  }
	  //客户要产品B
	  try {
		  Factory.Manufacture("B").method1();
	  }catch (NullPointerException e){
		  System.out.println("没有这一类产品");
	  }
	  //客户要产品C
	  try {
		  Factory.Manufacture("C").method1();
	  }catch (NullPointerException e){
		  System.out.println("没有这一类产品");
	  }
	  //客户要产品D
	  try {
		  Factory.Manufacture("D").method1();
	  }catch (NullPointerException e){
		  System.out.println("没有这一类产品");
	  }
  }
}
