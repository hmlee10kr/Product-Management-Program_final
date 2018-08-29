package 상품관리프로그램;

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
	JPanel p1 = new JPanel(); // p1 패널 선언
	JLabel[] n1 = new JLabel[4]; // p1에 나타날 라벨들 선언(관리번호, 상품명, 단가, 재조사)
	JLabel m1 = new JLabel("##메세지: 상품 정보를 가져왔습니다!");// 맨위의 메세지 출력부

	JPanel p2 = new JPanel();// p2 패널 선언
	JComboBox cb = new JComboBox();// p2에 들어갈 콤보박스 선언
	JTextField tf[] = new JTextField[3];// p2에 들어갈 textField 선언

	JScrollPane sp = new JScrollPane();// 스크롤
	JTextArea ta = new JTextArea();// 전체 목록 출력부

	JPanel p3 = new JPanel();// p3(버튼 메뉴부) 패널 선언
	JButton[] btn = new JButton[3];// 버튼 3개 선언

	public AppMain() {
		setSize(800, 500);// 전체 사이즈 설정
		startUI();// UI 디스플레이 함수 시작
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void startUI() {
		m1.setPreferredSize(new Dimension(800, 50));
		this.getContentPane().add(BorderLayout.NORTH, m1);// m1(메세지 출력부) 사이즈 지정 후 맨 위로 배치

		p1.setPreferredSize(new Dimension(100, 300));
		p1.setSize(100, 400);
		p1.setLayout(new GridLayout(4, 1));// p1 사이즈 지정 후 라벨이 들어갈 그리드 설정

		// 라벨 설정
		n1[0] = new JLabel("관리번호");
		n1[1] = new JLabel("상품명");
		n1[2] = new JLabel("단가");
		n1[3] = new JLabel("재조사");
		for (int i = 0; i < 4; i++) {// p1에 라벨 추가
			p1.add(n1[i]);
		}
		this.getContentPane().add(BorderLayout.WEST, p1);// p1을 맨 왼쪽에 배치

		p2.setPreferredSize(new Dimension(100, 300));
		p2.setLayout(new GridLayout(4, 1));// p2 사이즈 설정 후 그리드 설정
		cb = new JComboBox();
		p2.add(cb);// p2에 콤보박스 추가
		tf[0] = new JTextField(15);// 텍스트 필드 크기 선언
		tf[1] = new JTextField(15);
		tf[2] = new JTextField(15);

		for (int i = 0; i < 3; i++) {// p2에 텍스트 필드 추가
			p2.add(tf[i]);
		}
		p2.setSize(100, 400);
		this.getContentPane().add(BorderLayout.CENTER, p2);// p2 중앙으로 배치

		ta.setEditable(false);// 사용자가 바꾸지 못하도록
		sp.setPreferredSize(new Dimension(500, 400));
		sp.setViewportView(ta);
		// 가로 세로 스크롤바 항상 나타나도록
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setSize(new Dimension(500, 400));
		this.getContentPane().add(BorderLayout.EAST, sp);// 스크롤바에 텍스트 필드가 오른쪽에 나타나도록

		p3.setLayout(null);

		p3.setPreferredSize(new Dimension(800, 50));// p3(버튼 메뉴부) 사이즈 설정
		// 버튼 이름, 사이즈, 배치 설정
		btn[0] = new JButton("등록");
		btn[0].setBounds(250, 15, 100, 20);
		btn[1] = new JButton("조회");
		btn[1].setBounds(360, 15, 100, 20);
		btn[2] = new JButton("삭제");
		btn[2].setBounds(470, 15, 100, 20);

		for (int i = 0; i < 3; i++) {// 버튼 추가
			p3.add(btn[i]);
		}
		this.getContentPane().add(BorderLayout.SOUTH, p3);// p3 맨 아래에 배치

	}

	public static void main(String[] args) {// 메인에서 실행
		new AppMain();
	}
}
