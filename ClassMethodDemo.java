/*����3-9��  ͬһ���У��෽����ֱ�ӵ����෽���ͷ����������
 * Ҫͨ��ʵ�����ܵ���ʵ�������ͷ���ʵ���������ڲ�ͬ���У�
 * ��ͨ��ĳ�����������ʵ�����������෽�����෽�����ڴ���
 * ֻ��һ����������������ʵ������
 */
//�����嵥3-9:  ClassMethodDemo.java
public class ClassMethodDemo {// ����
	public static void main(String[] args) {
		ClassMethod cm1 = new ClassMethod();// ʵ����cm1
		// ����һ:����.�෽��
		ClassMethod.printIDName(cm1);
		// ������:����.ʵ������
		// ClassMethod.SetIDName(100, "����");
		cm1.SetIDName(100, "����");
		// ������:ʵ��.�෽��
		cm1.printIDName(cm1);
		ClassMethod cm2 = new ClassMethod();// ʵ����cm2
		cm2.SetIDName(108, "����");
		// ����һ:����.�෽��
		ClassMethod.getIDName(cm2);
	}
}

class ClassMethod {// ��ClassMethod
	static int ID;// �����

	String name;// ʵ������

	// ʵ���������Է����������ʵ������
	void SetIDName(int ID, String name) {
		this.ID = ID;// ���������
		this.name = name;// ����ʵ������
	}

	// �෽����ֱ�ӷ��ʵ��������
	static void getIDName(ClassMethod im) {
		System.out.print("ID = " + ID);
		// �෽������ֱ�ӷ���ʵ������
		// System.out.print("Name = " + name);
		// �෽���в���ʹ��this
		// System.out.print("Name = " + this.name);
		System.out.print("\nName = " + im.name + "\n");
	}

	static void printIDName(ClassMethod im) {
		// �෽����ֱ�ӵ����෽��
		getIDName(im);
		// �෽������ֱ�ӵ���ʵ������
		// SetIDName(1000, "����");
	}
}
