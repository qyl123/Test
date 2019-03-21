/*【例3-9】  同一类中，类方法可直接调用类方法和访问类变量，
 * 要通过实例才能调用实例方法和访问实例变量：在不同类中，
 * 可通过某个类的类名或实例来调用其类方法。类方法在内存中
 * 只有一个副本，被其所有实例共享。
 */
//程序清单3-9:  ClassMethodDemo.java
public class ClassMethodDemo {// 主类
	public static void main(String[] args) {
		ClassMethod cm1 = new ClassMethod();// 实例化cm1
		// 方法一:类名.类方法
		ClassMethod.printIDName(cm1);
		// 不能用:类名.实例方法
		// ClassMethod.SetIDName(100, "李四");
		cm1.SetIDName(100, "李四");
		// 方法二:实例.类方法
		cm1.printIDName(cm1);
		ClassMethod cm2 = new ClassMethod();// 实例化cm2
		cm2.SetIDName(108, "王五");
		// 方法一:类名.类方法
		ClassMethod.getIDName(cm2);
	}
}

class ClassMethod {// 类ClassMethod
	static int ID;// 类变量

	String name;// 实例变量

	// 实例方法可以访问类变量和实例变量
	void SetIDName(int ID, String name) {
		this.ID = ID;// 访问类变量
		this.name = name;// 访问实例变量
	}

	// 类方法可直接访问的是类变量
	static void getIDName(ClassMethod im) {
		System.out.print("ID = " + ID);
		// 类方法不可直接访问实例变量
		// System.out.print("Name = " + name);
		// 类方法中不能使用this
		// System.out.print("Name = " + this.name);
		System.out.print("\nName = " + im.name + "\n");
	}

	static void printIDName(ClassMethod im) {
		// 类方法可直接调用类方法
		getIDName(im);
		// 类方法不能直接调用实例方法
		// SetIDName(1000, "张三");
	}
}
