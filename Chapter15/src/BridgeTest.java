
public class BridgeTest {
	public static void main(String[] args) {
		System.out.println("�ùķ��̼��� �����Ѵ�.");
		Bridge bridge = new Bridge();
		
		new Knight(bridge, "ȫ�浿", "ȫõ").start();
		new Knight(bridge, "�Ӳ���", "�ӽ�").start();
		new Knight(bridge, "������", "�ϻ�").start();
		new Knight(bridge, "�庸��", "����").start();
		new Knight(bridge, "�̼���", "��õ").start();
	}
}
