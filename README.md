# 设计模式系列
## 单例（singleton）模式
## 工厂方法（factory method）模式
### 简单工厂模式
#### 模式定义
简单工厂模式又叫静态方法模式(因为工厂类定义了一个静态方法)

    现实生活中,工厂是负责生产产品的;同样在设计模式中
    简单工厂模式可以理解为负责生产对象的一个类,称为"工厂类".
    
#### 解决的问题
将"类实例化的操作"与"使用对象的操作"分开,让使用者不用知道具体参数就可以实例化出所需要的"产品"类,
从而避免了在客户端代码中显式指定,实现了解耦.

    即使用者可直接消费产品而不需要知道其生产的细节

#### 模式组成

    组成(角色)                  关系                      作用
    抽象产品                    具体产品的父类            描述产品的公共接口
    具体产品                    抽象产品的子类;
                                工厂类创建的目标类        描述生产的具体产品
    工厂                        被外界调用                根据传入不同参数从而创建不同的具体实例
 
#### 使用步骤

1.创建抽象产品类 & 定义具体产品的公共接口

2.创建具体产品类(继承抽象产品类) & 定义生产的具体产品

3.创建工厂类,通过创建静态方法根据传入不同参数从而创建不同具体产品类的实例

4.外界通过调用工厂类的静态方法,传入不同参数从而创建不同具体产品类的实例

#### 情景模拟
现有一个塑料生产厂,用来做塑料加工.目的:最近推出3个产品,希望使用简单工厂模式实现3款产品的生产

##### 操作步骤
###### Step1
```java
public abstract class Product{
    public abstract void method1();
}
```

###### Step2
```java
public class ProductA extends Product {
	@Override
	public void method1() {
    	System.out.println("生产出产品A");
	}
}

public class ProductB extends Product {

	@Override
	public void method1() {
		System.out.println("生产出产品B");
	}
}

public class ProductC extends Product {

	@Override
	public void method1() {
		System.out.println("生产出产品C");
	}
}

```
###### Step3
```java
public class Factory {

	public static Product Manufacture(String ProductName){
		//工厂类里用switch语句控制生产哪种商品;
		//使用者只需要调用工厂类的静态方法就可以实现产品类的实例化.
		switch (ProductName){
			case "A":
				return new ProductA();
			case "B":
				return new ProductB();
			case "C":
				return new ProductC();
			default:
				return null;
		}
	}
}
```
###### Step4
```java
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
```
##### 结果输出

    生产出产品A
    生产出产品B
    生产出产品C
    没有这一类产品

##### 优点
    
    将创建实例的工作与使用实例的工作分开,使用者不必关心类对象如何创建,实现了解耦
    把初始化实例时的工作放到工厂里进行,使代码更容易维护
    更符合面向对象的原则 & 面向接口编程 而不是面向实现编程.

##### 缺点

    工厂类集中了所有实例(产品)的创建逻辑,一旦这个工厂不能正常工作,整个系统都会受到影响
    违背 "开放-关闭"原则,一旦添加新产品就不得不修改工厂类的逻辑,这样就会造成工厂逻辑过于复杂
    简单工厂模式由于使用静态工厂方法,静态方法不能被继承和重写,造成工厂角色无法形成基于继承的等级结构
    
##### 应用场景
在了解优缺点后,我们知道了简单工厂模式的应用场景:

    客户如果只知道传入工厂类的参数,对于如何创建对象的逻辑不关心时;
    当工厂类负责创建的对象(具体产品)比较少时

### 工厂方模式
上述的简单工厂模式违背了 `开闭原则`,而"工厂方法模式"是对简单工厂模式进一步抽象化
其好处是可以使系统在不修改原来代码的情况下引进新的产品,即满足开闭原则.

#### 模式定义
定义一个用于创建对象的接口,让子类决定实例化哪一个类.Factory Method 使得一个类的实例化延迟到子类

#### 解决的问题
工厂一旦需要生产新的产品就需要修改工厂类的方法逻辑,违背了`开闭原则`

    即简单工厂模式的缺点
    之所以可以解决简单工厂的问题,是因为工厂方法模式把具体产品的创建推迟到工厂类的子类(具体工厂)中,
    此时工厂类不再负责所有产品的创建,而只是给出具体工厂必须实现的接口,
    这样工厂方法模式在添加新产品的时候就不修改工厂类逻辑而是添加新的工厂子类,
    符合开放封闭原则,克服了简单工厂模式中缺点.

#### 模式组成

    组成(角色)                  关系                      作用
    抽象产品                    具体产品的父类            描述产品的公共接口
    具体产品                    抽象产品的子类;
                                工厂类创建的目标类        描述生产的具体产品
    抽象工厂                    具体工厂的父类            描述具体工厂的公共接口
    具体工厂                    抽象工厂的子类            描述具体工厂;实现 Factory Method
                                被外界调用                工厂方法创建产品实例

#### 使用步骤
1.创建抽象工厂类,定义具体工厂的公共接口;

2.创建抽象产品类,定义具体产品的公共接口;

3.建具体产品类(继承抽象产品类) & 定义生产的具体产品;

4.创建具体工厂类(继承抽象工厂类),定义创建对应具体产品实例的方法

5.界通过调用具体工厂类的方法,从而创建不同具体产品类的实例.

#### 情景模拟

-   背景:有一家塑料工厂(仅生产A类产品);随着客户需求的变化,客户需要生产B类产品

-   冲突:改变原有塑料工厂的配置和变化非常困难,假设下一次客户需求再次发生变化,又得工厂继续跟着变化

-   解决方案:置办塑料分厂B来生产B类产品;即工厂方法模式

##### 操作步骤
###### Step1
```java
public abstract class Factory{
    public abstract Product Manufacture();
}
```
###### Step2
```java
public abstract class Product {
    public abstract void method1();
}
```
###### Step3
```java
//具体产品A类
public class ProductA extends Product {
    @Override
    public void method1() {
        System.out.println("生产出了产品A");
    }
}

//具体产品B类
public class ProductB extends Product {

    @Override
    public void method1() {
        System.out.println("生产出了产品B");
    }
}
```
###### Step4
```java
//工厂A类 - 生产A类产品
public class FactoryA extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

//工厂B类 - 生产B类产品
public class FactoryB extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
```
###### Step5
```java
//生产工作流程
public class FactoryPattern {

    // 步骤5:外界通过调用具体工厂类的方法,从而创建不同具体产品类的实例
    public static void main(String[] args) {
        //客户要产品A
        FactoryA.Manufacture().method1();

        //客户要产品B
        FactoryB.Manufacture().method1();
    }

}
```
##### 结果输出
    
    生产出了产品A
    生产出了产品C
    
##### 优点
-   用户只需要知道具体工厂的名称就可得到所要的产品,无须知道产品的具体创建过程
-   灵活性增强,对于新产品的创建,只需多写一个相应的工厂类
-   典型的解耦框架.高层模块只需要知道产品的抽象类.
    无须关心其他实现类,满足迪米特法则、依赖倒置原则和里氏替换原则

##### 缺点
-   类的个数容易过多,增加复杂度
-   增加了系统的抽象性和理解难度
-   抽象产品只能生产一种产品,此弊端可使用抽象工厂模式解决

##### 应用场景
-   客户只知道创建产品的工厂名,而不知道具体的产品名.如 TCL 电视工厂、海信电视工厂等
-   创建对象的任务由多个具体子工厂中的某一个完成,而抽象工厂只提供创建产品的接口
-   客户不关心创建产品的细节,只关心产品的品牌

### 源码中的应用

    //java api
    // 静态工厂方法
    Calendar.getInstance()
    java.text.NumberFormat.getInstance()
    java.util.ResourceBundle.getBundle()
    
    // 工厂方法
    java.net.URLStreamHandlerFactory
    javax.xml.bind.JAXBContext.createMarshaller
    ......
    
## 抽象工厂（abstract factory）模式
### 前言
前面说完了工厂方法模式,我们发现工厂方法模式存在一个严重的问题:
 `一个具体工厂只能创建一类产品`,而实际过程中一个工厂往往需要生产多类产品.

### 模式定义
抽象工厂模式,即Abstract Factory Pattern,
提供一个创建一系列相关或相互依赖对象的接口,
而无须指定它们具体的类;具体的工厂负责实现具体的产品实例.

    抽象工厂模式是工厂方法模式的升级版本,工厂方法模式只生产一个等级的产品,
    而抽象工厂模式可以生成多个等级的产品.
    
### 解决的问题
    每个工厂只能创建一类产品,即工厂方法模式的缺点

### 模式组成

    组成(角色)                  关系                      作用
    抽象产品族                  抽象产品的父类            描述抽象产品的公共接口
    抽象产品                    具体产品的父类            描述具体产品的公共接口
    具体产品                    抽象产品的子类;           
                                工厂类创建的目标类        描述生产的具体产品
    抽象工厂                    具体工厂的父类            描述具体工厂的公共接口
    具体工厂                    抽象工厂的子类;           描述具体工厂;实现 Factory Method
                                    被外界调用                工厂方法创建产品实例
                                 

### 使用步骤
1.创建抽象工厂类,定义具体工厂的公共接口

2.创建抽象产品族类,定义抽象产品的公共接口

3.创建抽象产品类(继承抽象产品族类),定义具体产品的公共接口

4.创建具体产品类(继承抽象产品类),定义生产的具体产品

5.创建具体工厂类(继承抽象工厂类),定义创建对应具体产品实例的方法

6.客户端通过实例化具体的工厂类,并调用其创建不同的目标产品的方法创建不同的具体产品类的实例

### 场景模拟

-   背景:现有两间塑料加工厂(A 仅生产容器类产品 B 仅生产模具类产品);
随着客户需求的变化,A 厂所在地的客户也需要模具类产品,B 厂所在地也需要容器类产品

-   冲突:没有资源(租金+场地) 在当地分别开设多家工厂

-   解决方案:在原有的两家塑料厂里增设生产需求的功能,即A 厂能生产容器+ 模具产品
B 厂也是同样

### 操作步骤
#### Step 1
```java
// 创建抽象工厂类 定义具体工厂的公共接口
public abstract class Factory {

	/**
	 * 定义具体工厂的公共接口
	 * @return
	 */
	
	public abstract AbstractProduct manufactureContainer();

	/**
	 * 模具的
	 * @return
	 */
	public abstract AbstractProduct manufactureMould();
	
}
```

#### Step2
```java
// 创建抽象产品族类 定义具体产品的公共接口
public abstract class AbstractProduct {

	/**
	 * 定义具体产品的公共接口
	 */
	public abstract void method1();
}
```
#### Step3
```java
// 创建抽象产品类 定义具体产品的公共接口
public abstract class ContainerProduct extends AbstractProduct {

	/**
	 * 	容器产品定义方法
	 * @author: 900045
	 * @date: 2021-05-07 16:49:39
	 * @throws 
	 * @return: void
	 **/
	@Override
	public abstract void method1();
}

public abstract class MouldProduct extends AbstractProduct {


	/**
	 *  模具产品 方法
	 * @author: 900045
	 * @date: 2021-05-07 16:49:13
	 * @throws 
	 * @return: void
	 **/
	@Override
	public abstract void method1();
	
}
```
#### Step4
```java
// 创建具体产品类 (继承抽象产品类)  定义生产的具体产品
public class ContainerProductA extends ContainerProduct {

	@Override
	public void method1() {
		System.out.println("生产出了容器产品A");
	}
}

public class ContainerProductB extends ContainerProduct {

	@Override
	public void method1() {
		System.out.println("生产出了容器产品B");
	}
}

public class MouldProductA extends MouldProduct {

	@Override
	public void method1() {
		System.out.println("生产出了模具产品A");
	}
}

public class MouldProductB extends MouldProduct {

	@Override
	public void method1() {
		System.out.println("生产出了模具产品B");
	}
}
```
#### Step5
```java
// 创建具体工厂类(继承抽象工厂类)定义创建对应具体产品实例的方法
public class FactoryA extends Factory {

	@Override
	public AbstractProduct manufactureContainer() {
		return new ContainerProductA();
	}

	@Override
	public AbstractProduct manufactureMould() {
		return new MouldProductA();
	}
}

public class FactoryB extends Factory {

	@Override
	public AbstractProduct manufactureContainer() {
		return new ContainerProductB();
	}

	@Override
	public AbstractProduct manufactureMould() {
		return new MouldProductB();
	}
}
```
#### Step6
```java
// 客户端通过实例化具体的工厂类
// 并调用其创建不同目标产品的方法创建不同具体产品类的实例
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
```

### 输出结果

    生产出了容器产品A
    生产出了模具产品A
    生产出了容器产品B
    生产出了模具产品B
    
### 优点

    1.可以在类的内部对产品族中相关联的多等级产品共同管理,
    而不必专门引入多个新的类来进行管理
    2.当需要产品族时,抽象工厂可以保证客户端始终只使用同一个产品的产品组
    3.抽象工厂增强了程序的可扩展性,当增加一个新的产品族时,不需要修改原代码
    满足开闭原则
### 缺点

    当产品族中需要增加一个新产品时,所有工厂类都需要进行修改.
    增加系统的抽象性和理解难度
    这是因为抽象工厂接口中已经确定了可以被创建的产品集合,
    如果需要添加新产品,此时就必须去修改抽象工厂的接口,
    这样就涉及到抽象工厂类的以及所有子类的改变,
    这样也就违背了"开发——封闭"原则.
    
    对于新的产品族符合开-闭原则;
    对于新的产品种类不符合开-闭原则,这一特性称为开-闭原则的倾斜性
### 应用场景
#### 源码中的应用
                                        
## 建造者/构建器（builder）模式
## 适配器（adapter）模式
## 装饰（decorator）模式
## 代理（proxy）模式
## 原型（prototype）模式
## 享元（flyweight）模式
## 外观（facade）模式
## 装饰（decorator）模式
## 观察者（observer）模式
## 策略（strategy）模式
## 桥接（bridge）模式
## 模版方法（template method）模式
## 责任链（chain of responsibility）模式
## 组合（composite）模式
## 备忘录（memento）模式
## 命令（command）模式
