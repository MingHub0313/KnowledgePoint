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
```text
#JDK
java.sql.Connection
java.sql.Driver

# mybatis
SqlSessionFactory
```         
```java
public interface Connection  extends Wrapper, AutoCloseable {
	 //返回普通的sql执行器
     Statement createStatement() throws SQLException;
     
     //返回具有参数化预编译功能的sql执行器
     PreparedStatement prepareStatement(String sql) throws SQLException;
     
     //返回可以执行存储过程的sql执行器
    CallableStatement prepareCall(String sql) throws SQLException;
}
/**
 * 这就是一个典型的抽象工厂接口,描述了不同的产品等级 Statement、PreparedStatement、CallableStatement
 * 它们都位于抽象接口Statement产品等级结构中.
 * 以mysql 可以找到Mysql对这个工厂接口的实现类 ConnectionImpl、ConnectionImpl 并不是直接实现了
 * java.sql.Connection,而是通过实现自己扩展的 MySQLConnection 接口,该接口也是间接继承了 Connection
 * 
 */


public interface SqlSessionFactory {

  SqlSession openSession();

  SqlSession openSession(boolean autoCommit);
  SqlSession openSession(Connection connection);
  SqlSession openSession(TransactionIsolationLevel level);

  SqlSession openSession(ExecutorType execType);
  SqlSession openSession(ExecutorType execType, boolean autoCommit);
  SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level);
  SqlSession openSession(ExecutorType execType, Connection connection);

  Configuration getConfiguration();

}

/**
 * SqlSessionFactory 也是抽象工厂接口,SqlSession 和 Configuration 都是在不同的产品等级上.
 * 在 jdbc 中,客户端通过 Connection 工厂 获取到 Statement 产品对象,然后通过该对象进行CURD,
 * 对于 mybatis 这种数据库框架而言(底层也是封装了 jdbc api) 有异曲同工,通过 SeqSessionFactory 工厂
 * 获取到 SqlSession 产品对象,然后进行 CURD操作.
 */

```                
## 建造者/构建器（builder）模式
### 模式定义
将一个复杂对象的创建与他的表示分离,使得同样的构建过程可以创建不同的表示.

    用户只需要给出指定复杂对象的类型和内容;
    构建者模式负责顺序创建复杂对象(把内部的构建过程和细节隐藏起来)

### 解决的问题
1.降低创建负责对象的复杂度 --- 方便用户创建复杂的对象(不需要知道实现过程)

2.隔离了创建对象的构建过程&表示 --- 提高代码复用性& 封装性

### 模式组成

    Director -->  Builder   <-- ConcreteBuilder --> Product
    1.指挥者(Director) 直接和 客户(Client) 进行需求沟通;
    2.沟通后指挥者将客户创建产品的需求划分为各个部件的构建请求(Builder);
    3.将各个部件的构建请求委派到具体的构建者(ConcreteBuilder);
    4.各个具体对的构建者负责进行产品部件的构建;
    5.最终构建成具体产品(Product).

### 场景模拟

- 背景 小明希望去中关村买一台组装的台式机
- 过程

1.中关村老板(Director)和小明(Client) 进行需求沟通(玩游戏?学习?...)

2.了解需求后,老板将小明需要的主机划分为各个部件(Builder) 的构建请求(CPU,主板...)

3.指挥店员(ConcreteBuilder) 去构建组件

4.将组件组装起来的电脑及是小明需要的电脑(Product)

#### 使用步骤

##### 1.Step
```java
//定义具体产品类(Product):电脑
public class Computer {

	/**
	 * 电脑组件的集合
	 */
	private List<String> parts = new ArrayList<String>();

	/**
	 * 用于将组件组装到电脑里
	 * @author: 900045
	 * @date: 2021-05-11 10:53:11
	 * @throws 
	 * @param part: 
	 * @return: void
	 **/
	public void Add(String part){
		parts.add(part);
	}

	/**
	 * 展示
	 * @author: 900045
	 * @date: 2021-05-11 10:53:25
	 * @throws 
	
	 * @return: void
	 **/
	public void Show(){
		for (int i = 0;i<parts.size();i++){
			System.out.println("组件" + parts.get(i) + "装好了");
		}
		System.out.println("电脑组装完成，请验收");
	}
}
```

##### 2.Step
```java
//定义组装的过程 (Builder):组装电脑的过程
public abstract class Builder {

	/**
	 * 第一步：装CPU 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:02
	 * @throws 
	 * @return: void
	 **/
	public abstract void  BuildCPU();
	
	/**
	 * 第二步：装主板 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:15
	 * @throws 
	 * @return: void
	 **/
	public abstract void BuildMainBoard();

	/**
	 * 第三步：装硬盘 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:28
	 * @throws 
	 * @return: void
	 **/
	public abstract void BuildHD();

	/**
	 * 返回产品的方法：获得组装好的电脑
	 * @author: 900045
	 * @date: 2021-05-11 10:55:39
	 * @throws 
	 * @return: com.zmm.design.mode.builder.Computer
	 **/
	public abstract Computer GetComputer();
}
```
##### 3.Step
```java
//中关村老板委派任务给装机人员(Director)
public class Director {

	/**
	 * 指挥装机人员组装电脑
	 * @author: 900045
	 * @date: 2021-05-11 10:57:16
	 * @throws 
	 * @param builder: 
	 * @return: void
	 **/
	public void Construct(Builder builder){
		builder. BuildCPU();
		builder.BuildMainBoard();
		builder.BuildHD();
	}
}
```
##### 4.Step
```java
// 创建具体的建造者 (ConcreteBuilder):装机人员
public class ConcreteBuilder extends Builder {

	/**
	 * 创建产品实例
	 */
	Computer computer = new Computer();
	
	
	@Override
	public void BuildCPU() {
		computer.Add("组装CPU");
	}

	@Override
	public void BuildMainBoard() {
		computer.Add("组装主板");
	}

	@Override
	public void BuildHD() {
		computer.Add("组装硬盘");
	}

	@Override
	public Computer GetComputer() {
		return computer;
	}
}

```
##### 5.Step
```java
// 客户端调用-小张到电脑城找老板买电脑
public class BuilderPattern {

  public static void main(String[] args) {

	  //逛了很久终于发现一家合适的电脑店
	  //找到该店的老板和装机人员
	  
	  Director director = new Director();
	  Builder builder = new ConcreteBuilder();

	  //沟通需求后，老板叫装机人员去装电脑
	  director.Construct(builder);

	  //装完后，组装人员搬来组装好的电脑
	  Computer computer = builder.GetComputer();
	  //组装人员展示电脑给小张看
	  computer.Show();
  }
}
```

#### 输出结果
```text
组件CPU装好了
组件主板装好了
组件硬盘装好了
电脑组装完成，请验收
```

#### 优点

    1.良好的封装性:构建者对客户端屏蔽了产品内部组成的细节,客户端不同关心每一个具体的产品内部是如何实现
    2.符合开闭原则
    3.便于控制细节风险:由于构建者是相互独立的,因此可以对构建过程逐步细化,而不对其他模块产生影响
    
    每一个具体构建者都有相对独立,而与其它的具体构建者无关,因此可以很方便地替换具体构建者或增加
    具体构建者,用户使用不同的具体构建者即可得到不同的产品对象.
    
#### 缺点

    1.构建者模式所创建的产品一般具有较多的共同点,其组成部分相似;如果产品之间的差异性很大,则不适合
    使用构建者,因此其使用范围受到一定的限制.
    2.如果产品的内部变化复杂,可能会导致需要定义很多具体构建者类来实现这种变化,导致系统变得很庞大.
    
### 应用场景
1.需要生成的对象具有复杂的内部结构

2.需要生产的对象内部属性本身相互依赖

3.与不可变对配合使用

### 与工厂方法模式的区别

    建造者模式最主要的功能是基本方法的调用顺序安排,基本方法已经实现,我们可以理解为零配件的装配
    顺序不通过产生的对象也不同;而工厂方法的注重点是创建,创建零件其主要职责,不关心组装顺序.
   
### 源码中的应用
```text
# jdk
java.lang.StringBuilder

# Spring源码
org.springframework.web.servlet.mvc.method.RequestMappingInfo
org.springframework.beans.factory.support.BeanDefinitionBuilder

```

### StringBuilder源码分析

    StringBuilder 类继承自 AbstractStringBuilder,而 AbstractStringBuilder 实现了 Appendable 接口.
    AbstractStringBuilder 虽然是一个抽象类,但是它实现了 Appendable 接口中的 append() 方法,因此在
    这里 Appendable 接口是一个抽象建造者,而 AbstractStringBuilder 是建造者,只是不能实例化.
    对于 StringBuilder 类,它即充当了指挥着角色,同时充当了具体的建造者,建造方法的具体实现是由
    AbstractStringBuilder 完成,StringBuilder 继承了 AbstractStringBuilder.
    
    
#### Appendable接口
```java
public interface Appendable {
    Appendable append(CharSequence csq) throws IOException;
    Appendable append(CharSequence csq, int start, int end) throws IOException;
    Appendable append(char c) throws IOException;
}
```

##### AbstractStringBuilder类
```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
 
    char[] value;//The value is used for character storage.
    int count;//The count is the number of characters used.

    AbstractStringBuilder() { }

    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }

    public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

    private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;
        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity));
        }
    }

    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
        if (srcBegin < 0) {
            throw new StringIndexOutOfBoundsException(srcBegin);
        }
        if (srcEnd > value.length) {
            throw new StringIndexOutOfBoundsException(srcEnd);
        }
        if (srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);
        }
        System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
    }
    // 此次省略......

}
```
#### StringBuilder类
```java
public final class StringBuilder extends AbstractStringBuilder implements java.io.Serializable, CharSequence {
 //虽说是重写 但还是调用的AbstractStringBuilder方法
   @Override
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }
}
```

## 适配器（adapter）模式
### 模式定义
将一个类的接口转换成客户端希望的另一个接口.Adapter 模式使得原本由于接口不兼容而不能一起工作
的那些类可以一起工作.

    适配器模式的形式分为: 类的适配器模式 & 对象的适配器模式

### 类的适配器模式
类的适配器模式是把适配的类的 API 转换成为目标类的 API

    Client ---> Target (operation())
    
    Adapter (operation()) .....> Target (operation())
    
    Adapter (operation()) ---> Adapted(speccificOperation())
    
    Adapter (operation()) ---> speccificOperation
    
    冲突: Target 期待调用 operation 方法,而 Adapted 并没有(这就所谓的不兼容)
    解决方案: 为使 Target 能够使用 Adapted 类里的 speccificOperation 方法,故提供一个中间环节
    Adapter类 (继承 Adapted & 实现 Target 接口 ),把 Adaptee 的 API 与 Target 的 API 衔接起来
    
    Adapter 与 Adapted 是继承关系 这决定了这个适配器模式是类的
    
#### 使用步骤
##### 1.Step 创建Target接口
```java
interface Target {
    //这是源类 Adapted 没有的方法
    void operation();
}
```

##### 2.创建源类(Adapted)
```java
class Adapted {
    public void SpecificOperation() {
    }
}
```

##### 3.Step 创建适配器类(Adapter)
```java
//适配器Adapter继承自 Adapted 同时又实现了目标(Target)接口 
class Adapter extends Adaptee implements Target {

    //目标接口要求调用operation()这个方法名 但源类 Adapted 没有方法operation()
    //因此适配器补充上这个方法名
    //但实际上operation()只是调用源类 Adapted 的SpecificOperation()方法的内容
    //所以适配器只是将 的SpecificOperation()方法作了一层封装 
    // 封装成Target可以调用的operation()而已
    @Override
    public void operation() {
        this.SpecificOperation();
    }

}
```

##### 4.Step
```java
//定义具体使用目标类 并通过Adapter类调用所需要的方法从而实现目标
public class AdapterPattern {

    public static void main(String[] args) {
        Target mAdapter = new Adapter();
        mAdapter.operation();
    }
}
```
### 对象的适配器模式
与类的适配器模式相同,对象的适配器模式也是把适配器的类的 API 转换 成为目标类的 API

    与其不同的是,对象适配器模式不是使用继承关系连接到 Adapted 类,而是使用委派关系
    
    Client ---> Target (operation())
    
    Adapter (operation()) .....> Target (operation())
    
    Adapter (operation()) ---> Adapted(speccificOperation())
    
     Adapter (operation()) ---> adapted.speccificOperation
     
     冲突:Target 期待调用 operation 方法,而Adapted并没有 (这就是所谓的不兼容了)
     解决方案:为使 Target 能够使用 Adapted 类里的 SpecificOperation 方法
     故提供一个中间环节 Adapter 类(包装了一个 Adapted 的实例)
     把 Adapted 的 API 与 Target 的 API 衔接起来(适配)
     
     Adapter 与 Adapted 是委派关系 ,这决定了适配器模式是对象的
#### 使用步骤
##### 1.创建Target接口
```java
interface Target {
    //这是源类 Adapted 没有的方法
    void operation();
}
```

##### 2.创建源类（Adapted）
```java
class Adapted {
    public void SpecificOperation(){
    }
}
```

##### 3.Step
```java
// 创建适配器类(Adapter)（不适用继承而是委派）
class Adapter implements Target{
    // 直接关联被适配类  
    private Adapted adapted;

    // 可以通过构造函数传入具体需要适配的被适配类对象  
    public Adapter (Adapted adapted) {
        this.adapted = adapted;
    }

    @Override
    public void operation() {
        // 这里是使用委托的方式完成特殊功能  
        this.adapted.SpecificOpertaion();
    }
}  
```

##### 5.Step
```java
public class AdapterPattern {
	//定义具体使用目标类 并通过 Adapter 类调用所需要的方法从而实现目标
    public static void main(String[] args) {
        // 步骤4：定义具体使用目标类 并通过Adapter类调用所需要的方法从而实现目标
        //需要先创建一个被适配类的对象作为参数  
        Target mAdapter = new Adapter(new Adaptee());
        mAdapter.operation();
    }
}
```
### 两种适配器比较
- 对象适配器:使用组合的方式,不仅能适配一个被适配者的类,还可以适配它的任何一个子类

- 类适配器:只能适配一个特定的类,但是它不需要重新实现整个被适配者的功能.而且它还可以重写被适配者的行为
- 对象适配器:使用的是组合而不是继承,通过多写几行代码把事情委托给了被适配者

- 类适配器:需要一个适配器和一个被适配者,只需要一个类就行

- 对象适配器:对适配器添加的任何行为对被适配者和它的子类都其作用

### 解决的问题

    从模式的定义中,我们看到适配器模式就是用来转换接口,解决不兼容问题的.
    手机充电器,也就是电源适配器,它把家用交流强电转换为手机用的直流弱电.
    其中交流电就是被适配者,充电器就是适配器,手机是用户.
    
    原本由于接口不兼容而不能一起工作的那些类可以在一起工作.

### 模式组成

    客户只能调用目标接口功能,不能直接使用被适配器,但是可以通过适配器的接口
    转换间接使用被适配器.
    目标接口(Target):客户看到的接口,适配器必须实现该接口才能被客户使用.
    适配器(Adapter):适配器把被适配者接口转换为目标接口,提供客户使用.
    被适配者(Adapted):与目标接口不兼容,需要适配器转换成目标接口子类,才能被客户使用
    
### 场景模拟
- 背景:小明买了一个进口的电视机
- 冲突:进口电视机要求电压(110V)与国内插头标准输出电压(220V)不兼容
- 解决方案:设置一个适配器将插头输出的220V 转换成 110V

#### 使用步骤
##### 1.Step
```java
//创建Target接口 (期待得到的插头) : 能输出110V(将220V转换成110V)

 interface Target {

    //将220V转换输出110V (原有插头(Adapted)没有的)
    void convert_110v();
}
```

##### 2.Step
```java
// 创建源类 (原有的插头)
class PowerPort220V{
	
    //原有插头只能输出220V
    public void output_220v(){
    }
}
```

##### 3.Step
```java
// 创建适配器类(Adapter)
class Adapter220V extends PowerPort220V implements Target{
    //期待的插头要求调用convert_110v() 但原有插头没有
    //因此适配器补充上这个方法名
    //但实际上convert_110v()只是调用原有插头的output_220v()方法的内容
    //所以适配器只是将output_220v()作了一层封装，封装成Target可以调用的convert_110v()而已

    @Override
    public void convert_110v(){
        this.output_220v();
    }
}
```

##### 4.Step
```java
//定义具体使用目标类 并通过Adapter类调用所需要的方法从而实现目标(不需要通过原有插头)

//进口电视类
class ImportedMachine {

    @Override
    public void Work() {
        System.out.println("进口电视正常运行");
    }
}
//通过Adapter类从而调用所需要的方法
public class AdapterPattern {

    public static void main(String[] args) {
        Target mAdapter220V = new Adapter220V();
        ImportedMachine mImportedMachine = new ImportedMachine();

        //用户拿着进口电视插上适配器（调用Convert_110v()方法）
        //再将适配器插上原有插头（Convert_110v()方法内部调用Output_220v()方法输出220V）
        //适配器只是个外壳，对外提供110V，但本质还是220V进行供电
        mAdapter220V.convert_110v();
        mImportedMachine.Work();
    }
}
```

#### 输出结果
```text
进口电视正常运行
```

#### 优点
    
    1.转换接口,适配器让不兼容的接口变成兼容;
    2.让客户和实现的接口解耦.有了适配器,客户端每次调用不兼容的接口时,不同修改自己的代码
    只要调用合适的适配器就可以了;
    3.使用了对象组合设计原则:以组合的方式包装被适配者,被适配者的任何子类都
    可以搭配着同一个适配器使用;
    4.体现了开闭原则:适配器模式把客户和接口绑定起来,而不是个具体实现绑定,我们可以使用
    多个适配器来转换多个后台类,也可以很容易地增加新的适配器.
    
#### 缺点

    1.每个被适配者都需要一个适配器,当适配器过多时增加系统的复杂度,降低运行时的性能
    2.实现一个适配器可能需要下一番工夫,增加开发的难度.
    
### 应用场景
- 当要使用的两个类所做的事情相同或者相似,但是具有不同的接口时考虑使用适配器模式
- 当需要统一客户端调用接口的代码,而所调用的接口具有不兼容问题时使用适配器模式

建议尽量使用对象的适配器模式,多用合成/聚合、少用继承

### 源码中的应用
```text
#JDK
java.util.Arrays#asList()
java.util.Collections#list()
java.util.Collections#enumeration()
java.io.InputStreamReader(InputStream) (returns a Reader)
java.io.OutputStreamWriter(OutputStream) (returns a Writer)
java.util.collections#enumeration(),从Iterator到Enumeration的适配。

#Spring
org.springframework.context.event.GenericApplicationListenerAdapter
```

#### Arrays.asList()

    使用工具类 Arrays.asList() 把数组转换成集合时,不能使用其修改集合相关的方法
    它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常.
    
    说明:asList 的返回对象是一个 Arrays 内部类.并没有实现集合的修改方法.
    Arrays.asList 体现的是适配器模式 只是转换接口 后台的数据仍是数组.
    
#### GenericApplicationListenerAdapter

    spring架构体系中的事件模型,面向事件编程可以使你的应用扩展性更好,
    设计更优美,更有设计感,也是解耦最常用的方式.
    
    ApplicationListener 事件监听器接口 基于观察者模式实现
    
    ApplicationListener 事件监听器接口 基于观察者模式实现
    boolean supportsEventType(ResolvableType eventType);
    是SmartApplicationListener的改良版本
    
    SmartApplicationListener 基于事件的监听器接口 如下
    boolean supportsEventType(Class<? extends ApplicationEvent> eventType);
    
    ApplicationListenerMethodAdapter GenericApplicationListener适配器实现 如下
    
    public class ApplicationListenerMethodAdapter implements GenericApplicationListener
    
    可以看到是通过实现接口这种方式的适配器模式实现
    GenericApplicationListenerAdapter GenericApplicationListener适配器模式实现
    
    为什么实现接口这种方式比继承类这种实现扩展性更好,
    java是单继承,用实现接口这种方式可以间接的实现的多继承,扩展性更好.
    
    SourceFilteringListener 基于GenericApplicationListener,SmartApplicationListener
    的装饰器模式实现,从指定的事件源筛选事件,调用它的委托侦听器来匹配应用程序事件对象.
    
## 装饰（decorator）模式
### 模式定义
在不改变原有对象的基础上,将功能附加到对象上

    动态的给一个对象添加一些额外的职责.就增加功能来说,装饰模式相比生成子类更为灵活
    
### 解决的问题
扩展一个类的功能或给一个类添加附加职责

### 模式组成

    组成                  作用
    抽象构件(Component)   给出一个抽象接口,以规范准备接收附加责任的对象
    具体构件(ConcreteComponent)              定义一个将要接收附加责任的类
    装饰角色(Decorator)   持有一个构件对象的实例,并定义一个与抽象构件接口一致的接口
    具体装饰角色(ConcreteDecorator)          负责给构件对象贴上附加的责任

### 场景模拟
- 背景:小明创业准备开发一款视频软件
- 冲突:调研市场发现有的用户需要自动添加美颜,有的需要自动添加滤镜
- 解决方案:用过使用装饰者模式在视频的基础上,能根据不同用户喜好添加相应功能

#### 使用步骤
##### 1.Step
```java
// 定义Component抽象构件 也就是定义视频软件基础接口
// Component是一个接口或者是抽象类,它定义了最核心的对象,也就是最原始的对象
abstract class Component {
    //抽象的方法
    public abstract void operation();
}
```

##### 2.Step
```java
// 定义ConcreteComponent具体构件,也就是实现一个视频软件的基本功能
// ConcreteComponent是最核心 最原始、最基本的接口或抽象类的实现,是我们要装饰的对象
class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("视频软件直播.");
    }
}
```

##### 3.Step
```java
// 定义Decorator装饰角色,是抽象类，聚合了Component接口
abstract class Decorator extends Component {
    private Component component=null;

    //通过构造函数传递被修饰者
    public Decorator(Component component){
        this.component=component;
    }

    //委托给被修饰者执行
    @Override
    public void operation() {
        this.component.operation();
    }
}
```

##### 4.Step
```java
// 具体装饰角色,A用户需要添加美颜功能
class ConcreteDecoratorA extends Decorator {

    //定义被修饰者
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void decorator(){
        System.out.println("添加美颜.");
    }

    @Override
    public void operation() {
        this.decorator();
        super.operation();
    }
}
```

##### 5.Step
```java
// 具体装饰角色,B用户需要添加滤镜功能
class ConcreteDecoratorB extends Decorator {

    //定义被修饰者
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void decorator(){
        System.out.println("添加滤镜.");
    }

    @Override
    public void operation() {
        this.decorator();
        super.operation();
    }
}
```

##### 6.Step
```java
// 给不同的用户在视频直播的时候添加不同的功能
public class DecoratorPattern {

    public static void main(String[] args) {
        // 添加美颜
        Component componentA  = new ConcreteDecoratorA(new ConcreteComponent());
        componentA.operation();

        System.out.println();

        // 添加滤镜
        Component componentB  = new ConcreteDecoratorB(new ConcreteComponent());
        componentB.operation();

        System.out.println();

        // 添加美颜和滤镜
        Component component  = new ConcreteDecoratorA
                    (new ConcreteDecoratorB(new ConcreteComponent()));
        component.operation();
    }

}
```

#### 输出结果
```text

添加美颜.
视频软件直播.

添加滤镜.
视频软件直播.

添加美颜.
添加滤镜.
视频软件直播.

```

#### 优点

    1.不改变原有对象的情况下给一个对象扩展功能;
    2.使用不同的组合可以实现不同的效果;
    3.符合开闭原则
    
#### 缺点
    
    多层的装饰会使系统比较复杂
    即一个实现类的功能若用多个装饰类进行装饰,则会增加该实现类的耦合度
    
### 应用场景
扩展一个类的功能或给一个类添加附加职责

### 源码中的应用
```text
# JDK
FilterInputStream

#Servlet Api:
javax.servlet.http.HttpServletRequestWrapper
javax.servlet.http.HttpServletResponseWrapper
```
#### FilterInputStream IO源码分析

    InputStream: 相当于我们装饰者模式中的 Component
    FileInputStream: 继承自 InputStream,相当于ConcreteComponent角色
    FilterInputStream: 继承自 InputStream,相当于Decorator角色
    DataInputStream: 继承自 FilterInputStream ,相当于 ConcreteDecorator 角色
    
##### FilterInputStream(装饰类)
```java
public class FilterInputStream extends InputStream {
    //持有的被装饰者对象
    protected volatile InputStream in;
    //初始化的时候就指定被装饰者
    protected FilterInputStream(InputStream in) {
        this.in = in;
    }
    //被装饰者方法的调用
    public int read() throws IOException {
        return in.read();
    }
 }

```
##### DataInputStream(具体的装饰类)
```java
public class DataInputStream extends FilterInputStream implements DataInput {

    //构造器：指定被修饰者
    public DataInputStream(InputStream in) {
        super(in);
    }
 
    //扩展的功能，即修饰
    public final void readFully(byte b[], int off, int len) throws IOException {
        if (len < 0)
            throw new IndexOutOfBoundsException();
        int n = 0;
        while (n < len) {
            int count = in.read(b, off + n, len - n);
            if (count < 0)
                throw new EOFException();
            n += count;
        }
    }
    
    public final char readChar() throws IOException {
        int ch1 = in.read();
        int ch2 = in.read();
        if ((ch1 | ch2) < 0)
            throw new EOFException();
        return (char)((ch1 << 8) + (ch2 << 0));
    }
}
```
##### 方法中的调用
```text
DataInputStream dis = new DataInputStream(new FileInputStream("/usr/local/temps/1.txt"));
```
## 代理（proxy）模式
### 模式定义
由于某些原因需要给某对象提供一个代理以控制对该对象的访问.
访问对象不合适或者不能直接引用目标对象,代理对象作为访问对象和目标对象之间的中介.

    代理模式的结构比较简单,主要是通过定义一个继承抽象主题的代理来包含真实主题,
    从而实现对真实主题的访问.
    
    在代码中,一般代理会被理解为代码增强,实际上就是在原代码逻辑前后增加一些代码逻辑
    而使用者无感知.代理模式分为:静态代理和动态代理
    
    静态:由程序员创建代理类或者特定工具自动生成源代码再对其编译,
    在程序运行前代理类的.class就已经存在
    动态:在程序运行时,运用反射机制动态创建而成.
    
### 解决的问题

    在直接访问对象时带来的问题:比如说:要访问的对象在远程的机器上.在面向对象系统中,
    有些对象由于某些原因(比如对象创建开销很大,或者某些操作需要安全控制,或者需要进程外的访问)
    直接访问会给使用者或者系统结构带来很多麻烦,
    我们可以在访问此对象时加上一个对此对象的访问层

### 模式组成

    组成              作用
    抽象主题类        通过接口或者抽象类声明真实主题和代理对象实现的业务方法
    真实主题类        实现抽象主题中的具体业务,是代理对象所代表的真实对象,最终引用的对象
    代理类            提供与真实主题相同的接口,其内部含有对真实主题的引用,它可以访问,控制
                      或者扩展真实主题的功能
                      
### 静态代理
#### 使用步骤
##### 1.Step
```java
//定义抽象主题类
interface Subject {
    void request();
}
```

##### 2.Step
```java
//定义真实主题类
class RealSubject implements Subject {
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}
```

##### 3.Step
```java
//定义代理类
class Proxy implements Subject {
    private RealSubject realSubject;

    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
```

##### 4.Step
```java
public class ProxyPattern {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
```

#### 输出结果
```text
访问真实主题之前的预处理。
访问真实主题方法...
访问真实主题之后的后续处理。
```

#### 静态代理优点

    使得真实主题处理的业务更加纯粹,不再去关注一些公共的事情,
    公共的业务由代理来完成,实现业务的分工,公共业务发生扩展时变得更加集中和方便
   
#### 静态代理缺点
    
    这种实现方式很直观也很简单,但其缺点是代理类必须提前写好,
    如果主题接口发生了变化,代理类的代码也要随着变化,有着高昂的维护成本
    
    针对静态代理的缺点,是否有一种方式弥补?
    能够不需要为每一个接口写上一个代理方法,那就动态代理.
    
### 动态代理
动态代理,在java代码里动态代理类使用字节码动态生成加载技术,在运行时生成加载类.
生成动态代理类的方法很多,比如：JDK 自带的动态处理、CGLIB、Javassist、ASM 库

- JDK 的动态代理使用简单,它内置在 JDK 中,因此不需要引入第三方 Jar 包,但相对功能比较弱.
- CGLIB 和 Javassist 都是高级的字节码生成库,总体性能比 JDK 自带的动态代理好,而且功能十分强大

#### JDK动态代理
Java提供了一个Proxy类,使用Proxy类的newInstance方法可以生成某个对象的代理对象.

该方法需要三个参数:
- 类装载器【一般我们使用的是被代理类的装载器】
- 指定接口【指定要被代理类的接口】
- 理对象的方法里干什么事【实现handler接口】

##### 使用步骤
###### 1.Step
```java
//定义抽象主题类
interface Subject {
    void request();
}
```
###### 2.Step
```java
//定义真实主题类
class RealSubject implements Subject {
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}
```
###### 3.Step
```java
// 使用Proxy.newProxyInstance生成代理对象
class ProxyHandler implements InvocationHandler {

    private Subject subject; // 定义主题接口

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果是第一次调用，生成真实主题
        if (subject == null) {
            subject = new RealSubject();
        }

        if ("request".equalsIgnoreCase(method.getName())) {
            System.out.println("访问真实主题之前的预处理。");
            Object result = method.invoke(subject, args);
            System.out.println("访问真实主题之后的后续处理。");
            return result;
        } else {
            // 如果不是调用request方法，返回真实主题完成实际操作
            return method.invoke(subject, args);
        }
    }

    // 使用Proxy.newProxyInstance生成代理对象
    static Subject createProxy() {
        Subject proxy = (Subject) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), // 当前类的类加载器
                new Class[]{Subject.class}, //被代理的主题接口
                new ProxyHandler() // 代理对象,这里是当前对象
        );
        return proxy;
    }
}
```
###### 4.Step
```java
// 测试输出
public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject = ProxyHandler.createProxy();
        subject.request();
    }
}
```
##### 输出结果
```text
访问真实主题之前的预处理。
访问真实主题方法...
访问真实主题之后的后续处理。



用debug的方式启动,可以看到方法被代理到代理类中实现,
在代理类中执行真实主题的方法前后可以进行很多操作.

虽然这种方法实现看起来很方便,但是细心的同学应该也已经观察到了,
JDK动态代理技术的实现是必须要一个接口才行的,所以JDK动态代理的优缺点也非常明显.

```

##### JDK动态代理优点

    1.不需要为真实主题写一个形式上完全一样的封装类,减少维护成本
    2.可以在运行时制定代理类的执行逻辑,提升系统的灵活性
##### JDK动态代理缺点

    JDK动态代理,真实主题必须实现的主题接口.如果真实主题没有实现主题接口,
    或者没有主题接口,则不能生成代理对象
    
    由于必须要有接口才能使用JDK的动态代理,
    那是否有一种方式可以没有接口只有真实主题实现类也可以使用动态代理呢?
    这就是第二种动态代理：CGLIB

#### CGLIB动态代理
使用 CGLIB 生成动态代理,首先需要生成 Enhancer 类实例,并指定用于处理代理业务的回调类.
在 Enhancer.create() 方法中,会使用DefaultGeneratorStrategy.Generate() 
方法生成动态代理类的字节码,并保存在 byte 数组中.接着使用 ReflectUtils.defineClass() 方法
通过反射，调用 ClassLoader.defineClass() 方法,将字节码装载到 ClassLoader 中,完成类的加载.
最后使用 ReflectUtils.newInstance() 方法,通过反射,生成动态类的实例,并返回该实例.
基本流程是根据指定的回调类生成 Class 字节码—通过 defineClass() 
将字节码定义为类—使用反射机制生成该类的实例.

##### 使用步骤
###### 1.Step
```java
// 定义真实主题
class WorkImpl {

    void addWorkExperience() {
        System.out.println("增加工作经验的普通方法...");
    }
}
```
###### 2.Step
```java
// 创建代理类
class WorkImplProxyLib implements MethodInterceptor {

    // 创建代理对象
    Object getWorkProxyImplInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(WorkImpl.class);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始...");
        methodProxy.invokeSuper(obj, args);
        System.out.println("结束...");
        return null;
    }
}
```
###### 3.Step
```java
// 测试输出
public class CglibProxy {

    public static void main(String[] args) {
        WorkImplProxyLib cglib = new WorkImplProxyLib();
        WorkImpl workCglib = (WorkImpl) cglib.getWorkProxyImplInstance();
        workCglib.addWorkExperience();
    }
}
```
##### 输出结果
```text
开始...
增加工作经验的普通方法...
结束...
```

##### CGLIB动态代理优点
    
    CGLIB通过继承的方式进行代理、无论目标对象没有没实现接口都可以代理,
    弥补了JDK动态代理的缺陷.
    
##### CGLIB动态代理缺点

    1.CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少,
    但是CGLib在创建代理对象时所花费的时间却比JDK多得多,所以对于单例的对象,
    因为无需频繁创建对象,用CGLib合适,反之,使用JDK方式要更为合适一些.
    2.于CGLib由于是采用动态创建子类的方法,对于final方法,无法进行代理
    
#### 应用场景
当无法或不想直接引用某个对象或访问,某个对象存在困难时,可以通过代理对象来间接访问.

使用代理模式主要有两个目的:一是保护目标对象 二是增强目标对象

##### 1.远程代理
    
    也就是为一个对象在不同的地址空间提供局部代表,
    这样可以隐藏一个对象存在于不同地址空间的事实.比如说 WebService,
    当我们在应用程序的项目中加入一个 Web 引用引用一个 WebService,
    此时会在项目中声称一个 WebReference 的文件夹和一些文件,
    这个就是起代理作用的,这样可以让那个客户端程序调用代理解决远程访问的问题
##### 2.虚拟代理

    是根据需要创建开销很大的对象,通过它来存放实例化需要很长时间的真实对象
    .这样就可以达到性能的最优化,比如打开一个网页,这个网页里面包含了大量的文字和图片,
    但我们可以很快看到文字,但是图片却是一张一张地下载后才能看到,那些未打开的图片框,
    就是通过虚拟代理来替换了真实的图片,此时代理存储了真实图片的路径和尺寸
##### 3.安全代理

    用来控制真实对象访问时的权限.一般用于对象应该有不同的访问权限的时候
##### 4.指针引用

    是指当调用真实的对象时,代理处理另外一些事.
    比如计算真实对象的引用次数,这样当该对象没有引用时,可以自动释放它,
    或当第一次引用一个持久对象时,将它装入内存,或是在访问一个实际对象前,
    检查是否已经释放它,以确保其他对象不能改变它
##### 5.延迟加载

    用代理模式实现延迟加载的一个经典应用就在 Hibernate 框架里面.
    Hibernate 加载实体 bean 时,并不会一次性将数据库所有的数据都装载.
    默认情况下,它会采取延迟加载的机制,以提高系统的性能.

#### 其它代理模式
- 防火墙代理:内网通过代理穿透防火墙,实现对公网的访问
- 缓存代理:当请求图片文件资源时,先到缓存代理取,如果取不到资源再到公网或者数据库取,然后缓存
- 远程代理:远程对象的本地代表,通过它可以把远程对象来调用,远程代理通过网络和真正的远程对象沟通
- 同步代理:主要用在多线程编程中,完成多线程间同步工作
## 原型（prototype）模式
## 享元（flyweight）模式
## 外观（facade）模式
## 观察者（observer）模式
## 策略（strategy）模式
## 桥接（bridge）模式
## 模版方法（template method）模式
## 责任链（chain of responsibility）模式
## 组合（composite）模式
## 备忘录（memento）模式
## 命令（command）模式
