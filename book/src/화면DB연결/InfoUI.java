package 화면DB연결;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import 자바DB연결.BookVO;

public class InfoUI {

	public void open(BookVO bag) {
		System.out.println(bag);
		// public static void main(String[] args) {
		JFrame f = new JFrame();
		// FlowLayout flow = new FlowLayout();

		f.setTitle("책정보 화면");
		f.setSize(900, 750);
		f.setLayout(null);

		JLabel l1 = new JLabel();
		l1.setBounds(150, 120, 200, 300);
		JLabel l2 = new JLabel("<책 제목>");
		l2.setBounds(450, 50, 200, 80);
		JLabel l3 = new JLabel();
		l3.setBounds(450, 100, 200, 80);
		JLabel l4 = new JLabel("<저자>");
		l4.setBounds(450, 150, 200, 80);
		JLabel l5 = new JLabel();
		l5.setBounds(450, 200, 200, 80);
		JLabel l6 = new JLabel("<목차>");
		l6.setBounds(450, 250, 200, 80);
		JLabel l7 = new JLabel();
		l7.setBounds(450, 300, 300, 80);
		JLabel l8 = new JLabel("<기본정보>");
		l8.setBounds(450, 350, 200, 80);
		JTextArea l9 = new JTextArea();
		l9.setBounds(450, 420, 400, 100);
		l9.setLineWrap(true);
		l9.setEditable(false);
		JLabel l10 = new JLabel("<출판사 제공 책 소개>");
		l10.setBounds(450, 510, 300, 80);
		JTextArea l11 = new JTextArea();
		l11.setBounds(450, 570, 400, 80);
		l11.setLineWrap(true);
		l11.setEditable(false);

		JButton b1 = new JButton("책정보 수정");
		b1.setBounds(150, 450, 200, 50);
		JButton b2 = new JButton("평가하기");
		b2.setBounds(150, 520, 200, 50);

		// 책정보 수정클릭
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				책수정UI update = new 책수정UI();
				update.open(bag);
			}
		});

		// 평가하기 클릭
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StarUI star = new StarUI();
				star.open(bag);
			}
		});
		ImageIcon icon = new ImageIcon(bag.getImg());
		Font font = new Font("궁서", Font.BOLD, 25);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);

		l1.setIcon(icon);
		l3.setText(bag.getTitle());
		l5.setText(bag.getWriter());
		l7.setText(bag.getContent());
		l9.setText(bag.getInfo());
		l11.setText(bag.getPublisher());

		l2.setFont(font);
		l3.setFont(font2);
		l4.setFont(font);
		l5.setFont(font2);
		l6.setFont(font);
		l7.setFont(font2);
		l8.setFont(font);
		l9.setFont(font2);
		l10.setFont(font);
		l11.setFont(font2);
		b1.setFont(font);
		b2.setFont(font);

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		f.add(l9);
		f.add(l10);
		f.add(l11);
		f.add(b1);
		f.add(b2);

		f.getContentPane().setBackground(new Color(204, 229, 255));
		b1.setBackground(Color.pink); // 배경색
		b2.setBackground(Color.pink);

		f.setVisible(true);

	}

}
