package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.MemberDAO;
import 자바DB연결.MemberVO;

public class MemberUI {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 회원가입 화면");
		f.setSize(500, 550);

		JLabel l1 = new JLabel("<<회원가입화면>>");
		JLabel l2 = new JLabel("아이디");
		JLabel l3 = new JLabel("패스워드");
		JLabel l4 = new JLabel("이름");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);

		JButton b1 = new JButton("회원가입처리");

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입처리");
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(f, "아이디는 필수항목 입니다.");
				}
				
				MemberDAO dao = new MemberDAO();
				//가방 만들기
				MemberVO bag = new MemberVO();
				//가방에 값 넣기
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				
				//값이 들어간 가방을 전달하자.
				
				int result = dao.insert(bag);
				if (result==1) {
					JOptionPane.showMessageDialog(f, "회원가입 성공");
				} else {
					JOptionPane.showMessageDialog(f, "중복된 아이디입니다.");
				}
			}// action
		});// b1
		
		FlowLayout flow = new FlowLayout();
		Font font = new Font("궁서", Font.BOLD, 45);

		f.setLayout(flow);

		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(b1);

		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);

		b1.setFont(font);

		f.getContentPane().setBackground(new Color(204, 229, 255));

		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);

		t1.setBackground(Color.white);
		t1.setForeground(Color.black);

		t2.setBackground(Color.white);
		t2.setForeground(Color.black);

		t3.setBackground(Color.white);
		t3.setForeground(Color.black);

		b1.setBackground(Color.white);

		b1.setForeground(Color.black);

		f.setVisible(true);
	}

}
