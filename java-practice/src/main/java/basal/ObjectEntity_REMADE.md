#JAVA对象

### 对象与类区别

* `对象:` 对象是类的实例，有状态和行为两种属性。状态影响行为，行为影响状态。

* 对象的三个主要特性：
 > 1. 对象的行为（behavior）：可以对对象施加哪些操作、方法；
 > 2. 对象的状态（state）：当施加那些方法时，对象是如何响应的？
 > 3. 对象标识（identity）：如何辨别具有相同行为、状态的不同对象。
      ps:同一个类的所有对象实例，由于支持相同的行为而具有家族式的相似性。对象的行为是用可调用的方法定义的。                 
* `类:` 类是一个模板，它用来描述对象的行为和状态。类是构造对象的模板或蓝图。
        由类构造（Contruct）对象过程为创建类的实例（instance）。
* 类之间的关系：依赖（use-a）、聚合（has-a）、继承（is-a）。
* 类包含的类型变量：

>* 局部变量：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
>* 方法会运用形参。调用的一方会传入实参。实参是传给方法的值，当它传入方法后就成为了形参。参数跟局部变量是一样的。它有类型与名称，可以在方法内使用。
>* 成员变量：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
>* 类变量：类变量也声明在类中，方法体之外，但必须声明为static类型。


```java
package basal.OOP.entity;

import java.io.Serializable;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:构造方法及关键字transient
 */
public class XuXianPerson implements Serializable {
	public static void main(String[] args) {
		System.out.println(String.format("%s/%s", "http://127.0.0.1:8070//openapi/v1", "apps/GATEWAY2/appnamespaces"));
		System.out.println("人鬼情未了篇....");
		new XuXianPerson("TOM", 426).tell();
	}

    private String name;
    private int age;
	/**
	 * 	java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，
	 * 	将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
	 */
//	transient int age;

	/**
	 * 构造方法
	 */
    public XuXianPerson() {
    }

	/**
	 * 构造方法
	 * @param name
	 */
	public XuXianPerson(String name) {
        this.name = name;
    }

	/**
	 * 构造方法
	 * @param name
	 * @param age
	 */
	public XuXianPerson(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
		if (age > 0 && age < 140) {
			this.age = age;
		} else {
			this.name = "你觉得我还是人吗？ 这位公子......";
			this.age = age;
		}
    }

	/**
	 * 许仙Tell
	 */
	public void tell() {
		System.out.println("工资芳龄：" + this.getAge());
		System.out.println("佳人贵姓：" + this.getName());
	}

}

```