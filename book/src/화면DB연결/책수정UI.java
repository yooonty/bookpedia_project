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
import javax.swing.JTextArea;
import javax.swing.JTextField;


import 자바DB연결.BookDAO;
import 자바DB연결.BookVO;

public class 책수정UI {

	public void open(BookVO bag) {
		JFrame f = new JFrame("책 수정");
		f.setSize(700, 500);
		f.setLayout(new FlowLayout());
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		f.getContentPane().setBackground(new Color(204, 229, 255));

		JLabel l1 = new JLabel("제목");
		l1.setFont(font);
		JTextField t1 = new JTextField(10);
		t1.setText(bag.getTitle());
		t1.setFont(font);

		JLabel l2 = new JLabel(" 저자");
		l2.setFont(font);
		JTextField t2 = new JTextField(10);
		t2.setText(bag.getWriter());
		t2.setFont(font);
		t2.setBackground(Color.pink);
		t2.setEditable(false);

		JLabel l3 = new JLabel("고유넘버");
		l3.setFont(font);
		JTextField t3 = new JTextField(2);
		t3.setText(bag.getNo() + "");
		t3.setFont(font);
		t3.setBackground(Color.pink);
		t3.setEditable(false);

		JLabel l4 = new JLabel(" 대표이미지");
		l4.setFont(font);
		JTextField t4 = new JTextField(6);
		t4.setText(bag.getImg());
		t4.setFont(font);

		JLabel l5 = new JLabel(" 장르");
		l5.setFont(font);
		JTextField t5 = new JTextField(6);
		t5.setText(bag.getGenre());
		t5.setFont(font);
		t5.setBackground(Color.pink);
		t5.setEditable(false);

		JLabel l6 = new JLabel("목차");
		l6.setFont(font);
		JTextField t6 = new JTextField(25);
		t6.setText(bag.getContent());
		t6.setFont(font);
		t6.setBackground(Color.pink);
		t6.setEditable(false);

		JLabel l7 = new JLabel("기본정보");
		l7.setFont(font);
		JTextArea t7 = new JTextArea(5, 25);
		t7.setText(bag.getInfo());
		t7.setFont(font);
		t7.setLineWrap(true);

		JButton b1 = new JButton("수정하기");
		b1.setFont(font);
		b1.setBackground(Color.yellow);

		// 수정하기
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = bag.getNo();
				String title = t1.getText();
				String img = t4.getText();
				String info = t7.getText();

				BookDAO dao = new BookDAO();
				BookVO bag2 = new BookVO();
				bag2.setNo(no);
				bag2.setTitle(title);
				bag2.setImg(img);
				bag2.setInfo(info);

				int result = dao.update(bag2);
				if (result >= 1) {
					JOptionPane.showMessageDialog(f, "정보수정 성공!");
				} else {
					JOptionPane.showMessageDialog(f, "정보수정 실패!");
				}
			}
		});

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);
		f.add(l6);
		f.add(t6);
		f.add(l7);
		f.add(t7);
		f.add(b1);

		f.setVisible(true);
	}

}
