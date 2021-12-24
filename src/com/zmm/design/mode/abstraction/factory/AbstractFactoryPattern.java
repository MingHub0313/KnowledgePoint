package com.zmm.design.mode.abstraction.factory;

/**
 * @author 900045
 * @description:
 * @name AbstractFactoryPattern
 * @date By 2021-05-07 16:46:34
 */
public class AbstractFactoryPattern {

  public static void main(String[] args) {
	  FactoryA mFactoryA = new FactoryA();
	  FactoryB mFactoryB = new FactoryB();
	  //A厂当地客户需要容器产品A
	  mFactoryA.manufactureContainer().method1();
	  //A厂当地客户需要模具产品A
	  mFactoryA.manufactureMould().method1();

	  //B厂当地客户需要容器产品B
	  mFactoryB.manufactureContainer().method1();
	  //B厂当地客户需要模具产品B
	  mFactoryB.manufactureMould().method1();
  }
}
