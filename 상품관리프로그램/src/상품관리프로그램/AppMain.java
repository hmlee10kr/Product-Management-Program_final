package ��ǰ�������α׷�;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//public class AppMain extends JFrame implements ItemListener, ActionListener
public class AppMain extends JFrame {
	JPanel p1 = new JPanel(); // p1 �г� ����
	JLabel[] n1 = new JLabel[4]; // p1�� ��Ÿ�� �󺧵� ����(������ȣ, ��ǰ��, �ܰ�, ������)
	JLabel m1 = new JLabel("##�޼���: ��ǰ ������ �����Խ��ϴ�!");// ������ �޼��� ��º�

	JPanel p2 = new JPanel();// p2 �г� ����
	JComboBox cb = new JComboBox();// p2�� �� �޺��ڽ� ����
	JTextField tf[] = new JTextField[3];// p2�� �� textField ����

	JScrollPane sp = new JScrollPane();// ��ũ��
	JTextArea ta = new JTextArea();// ��ü ��� ��º�

	JPanel p3 = new JPanel();// p3(��ư �޴���) �г� ����
	JButton[] btn = new JButton[3];// ��ư 3�� ����

	public AppMain() {
		setSize(800, 500);// ��ü ������ ����
		startUI();// UI ���÷��� �Լ� ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void startUI() {
		m1.setPreferredSize(new Dimension(800, 50));
		this.getContentPane().add(BorderLayout.NORTH, m1);// m1(�޼��� ��º�) ������ ���� �� �� ���� ��ġ

		p1.setPreferredSize(new Dimension(100, 300));
		p1.setSize(100, 400);
		p1.setLayout(new GridLayout(4, 1));// p1 ������ ���� �� ���� �� �׸��� ����

		// �� ����
		n1[0] = new JLabel("������ȣ");
		n1[1] = new JLabel("��ǰ��");
		n1[2] = new JLabel("�ܰ�");
		n1[3] = new JLabel("������");
		for (int i = 0; i < 4; i++) {// p1�� �� �߰�
			p1.add(n1[i]);
		}
		this.getContentPane().add(BorderLayout.WEST, p1);// p1�� �� ���ʿ� ��ġ

		p2.setPreferredSize(new Dimension(100, 300));
		p2.setLayout(new GridLayout(4, 1));// p2 ������ ���� �� �׸��� ����
		cb = new JComboBox();
		p2.add(cb);// p2�� �޺��ڽ� �߰�
		tf[0] = new JTextField(15);// �ؽ�Ʈ �ʵ� ũ�� ����
		tf[1] = new JTextField(15);
		tf[2] = new JTextField(15);

		for (int i = 0; i < 3; i++) {// p2�� �ؽ�Ʈ �ʵ� �߰�
			p2.add(tf[i]);
		}
		p2.setSize(100, 400);
		this.getContentPane().add(BorderLayout.CENTER, p2);// p2 �߾����� ��ġ

		ta.setEditable(false);// ����ڰ� �ٲ��� ���ϵ���
		sp.setPreferredSize(new Dimension(500, 400));
		sp.setViewportView(ta);
		// ���� ���� ��ũ�ѹ� �׻� ��Ÿ������
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setSize(new Dimension(500, 400));
		this.getContentPane().add(BorderLayout.EAST, sp);// ��ũ�ѹٿ� �ؽ�Ʈ �ʵ尡 �����ʿ� ��Ÿ������

		p3.setLayout(null);

		p3.setPreferredSize(new Dimension(800, 50));// p3(��ư �޴���) ������ ����
		// ��ư �̸�, ������, ��ġ ����
		btn[0] = new JButton("���");
		btn[0].setBounds(250, 15, 100, 20);
		btn[1] = new JButton("��ȸ");
		btn[1].setBounds(360, 15, 100, 20);
		btn[2] = new JButton("����");
		btn[2].setBounds(470, 15, 100, 20);

		for (int i = 0; i < 3; i++) {// ��ư �߰�
			p3.add(btn[i]);
		}
		this.getContentPane().add(BorderLayout.SOUTH, p3);// p3 �� �Ʒ��� ��ġ

	}

	public static void main(String[] args) {// ���ο��� ����
		new AppMain();
	}
}
