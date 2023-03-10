package 화면DB연결;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import 자바DB연결.MemDAO;
import 자바DB연결.MemVO;

public class 닉네임UI {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(new FlowLayout());
		f.setSize(300, 400);

		JLabel l1 = new JLabel("닉네임");
		JTextField t1 = new JTextField(10);
		JLabel l2 = new JLabel("소개글");
		JTextField t2 = new JTextField(10);
		JLabel l3 = new JLabel("아이디");
		JTextField id = new JTextField(10);
		JButton b1 = new JButton("정보 가져오기");

		Font font = new Font("궁서", Font.BOLD, 30);

		l1.setFont(font);
		t1.setFont(font);
		l2.setFont(font);
		t2.setFont(font);
		l3.setFont(font);
		id.setFont(font);
		b1.setFont(font);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = id.getText();
				MemDAO dao = new MemDAO();
				MemVO bag = dao.one(txt);

				t1.setText(bag.getNickName());
				t2.setText(bag.getLet());
			}
		});

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(id);
		f.add(b1);

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
