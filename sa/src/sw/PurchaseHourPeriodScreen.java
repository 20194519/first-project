package sw;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : IT독서실예약시스템
//  @ File Name : PurchaseHourPeriodScreen.java
//  @ Date : 2021-12-10
//  @ Author : 장윤서
//
//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTextField;


/**
 * IT독서실 예약 시스템의 시간/정기권 구매화면에 해당한다
 * 구매 화면에서 사용자가 원하는 시간/정기권을 선택하여 
 * 금액을 확인할 수 있다
 * 
 * @author 장윤서
 *
 */
public class PurchaseHourPeriodScreen extends JFrame {
	int index;
	static protected String hour; // 이용 시간
	static protected String price; // 이용 금액
	String[] hour_price ={"<html> 2시간<br>  3000원</html>", "<html> 4시간<br>  5000원</html>", "<html> 6시간<br>  7000원</html>",
			"<html> 8시간<br>  9000원</html>", "<html>10시간<br> 11000원</html>", "<html>12시간<br> 13000원</html>",
			"<html> 1일권<br> 20000원</html>", "<html> 7일권<br> 45000원</html>", "<html>15일권<br> 70000원</html>",
			"<html>30일권<br> 120000원</html>", "<html>60일권<br> 220000원</html>", "<html>90일권<br>300000원</html>" }; 
	JButton[] jbtn = new JButton[12];
	
	PurchaseHourPeriodScreen() { 
	
	setTitle("서성 독서실"); 
	setSize(500, 500);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	Container c=getContentPane();
	JPanel pn=new JPanel(); // 구매화면 상단의 Panel
	JPanel ps=new JPanel(); // 구매화면 하단의 Panel
	JPanel pc=new JPanel(); // 구매화면 중간의 Panel
	
	pn.setBackground(new Color(93,162,229)); // 상단 panel 색 설정
	pc.setLayout(new GridLayout(4,4,15,15)); // 중간 panel 레이아웃 배치
	
	
	c.add(pc);
	c.add(pn, BorderLayout.NORTH);
	c.add(ps, BorderLayout.SOUTH);
	
	JLabel l1=new JLabel("시간/정기권 구매"); // 상단의 label "시간/정기권 구매" 추가
	l1.setForeground(Color.WHITE);
	
	pn.add(l1);
	
	
	JButton jb = new JButton(); 
	jb.setText("좌석 결제"); // 하단의 "좌석 결제" 버튼 추가
	
	
	ps.add(jb);
	jb.setForeground(Color.WHITE);
	jb.setBackground(new Color(93,162,229));
	
/**
 * 사용자가 이용하고 싶은 시간/정기권을 선택하기 위한 12개의 버튼 설정
 * 이용 시간/기간과 금액이 보인다
 */
	for(int i=0; i<hour_price.length; i++) { 
		
		jbtn[i] = new JButton();
		pc.add(jbtn[i]);
		jbtn[i].setText(hour_price[i]);
		jbtn[i].setBackground(new Color(230,245,250));
		jbtn[i].setForeground(new Color(1,85,154));
		jbtn[i].addActionListener(new MyActionListener());
		} 
	
	setVisible(true);
	
	}
	/**
	 * 사용자가 원하는 시간/정기권을 마우스로 클릭하였을 시,
	 * 알맞은 시간/기간과 금액인지 보여주는 액션리스너 설정
	 * @author 이태희
	 *
	 */
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			JButton j = (JButton)e.getSource();
			for(int i=0;i<hour_price.length;i++) {
				if(j.getText() == hour_price[i]) {
					hour = hour_price[i].substring(6, 10); // 사용자가 선택한 시간/기간을 저장
					price= hour_price[i].substring(14, 21); // 사용자가 선택한 시간/기간의 금액을 저장
					index= i;
					JOptionPane.showMessageDialog(null, "선택하신 이용기간과 금액\n"+ hour_price[i], "구매 확인창", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else
					continue;
			}
			
		}

	}

	public static void main(String[] args) { 
		new PurchaseHourPeriodScreen(); // 실행 화면 보이기
		
		}
	
}