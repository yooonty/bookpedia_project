package 화면DB연결;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import 자바DB연결.BookDAO;
import 자바DB연결.BookVO;
import 자바DB연결.InfoDAO;
import 자바DB연결.InfoVO;

public class RankUI {
	static int index = 1;

	public static void main(String[] args) {
		JFrame f = new JFrame("메인페이지");
		f.setSize(1000, 800);
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(204, 229, 255));

		JLabel l1 = new JLabel("책 순위 및 평가 사이트");
		l1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setBounds(0, 10, 1000, 100);

		JButton b1 = new JButton();
		b1.setBounds(150, 150, 200, 300);

		JButton b2 = new JButton();
		b2.setBounds(400, 150, 200, 300);

		JButton b3 = new JButton();
		b3.setBounds(650, 150, 200, 300);

		JLabel t1 = new JLabel("제목");
		t1.setFont(font);
		t1.setBounds(150, 430, 300, 100);

		JLabel t2 = new JLabel("제목");
		t2.setFont(font);
		t2.setBounds(400, 430, 300, 100);

		JLabel t3 = new JLabel("제목");
		t3.setFont(font);
		t3.setBounds(650, 430, 300, 100);

		JButton b4 = new JButton("책 등록하기");
		b4.setBackground(Color.yellow);
		b4.setFont(font);
		b4.setHorizontalAlignment(JButton.CENTER);
		b4.setBounds(400, 550, 200, 80);

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				책등록UI add = new 책등록UI();
				add.open();
			}
		});

		JLabel r1 = new JLabel("순위");
		r1.setFont(font);
		r1.setForeground(Color.red);
		r1.setBounds(150, 100, 50, 50);

		JLabel r2 = new JLabel("순위");
		r2.setFont(font);
		r2.setForeground(Color.red);
		r2.setBounds(400, 100, 50, 50);

		JLabel r3 = new JLabel("순위");
		r3.setFont(font);
		r3.setForeground(Color.red);
		r3.setBounds(650, 100, 50, 50);

		InfoDAO dao = new InfoDAO();
		InfoVO bag = null;

		// 첫번째
		bag = dao.one(index);
		if (bag != null) {
			ImageIcon icon = new ImageIcon(bag.getImg());
			b1.setIcon(icon);
			t1.setText(bag.getTitle());
			r1.setText(bag.getRank() + "");
		} else {
			System.out.println("불가");
		}
		// 두번째
		bag = dao.one(index + 1);
		if (bag != null) {
			ImageIcon icon = new ImageIcon(bag.getImg());
			b2.setIcon(icon);
			t2.setText(bag.getTitle());
			r2.setText(bag.getRank() + "");
		} else {
			System.out.println("불가");
		}
		// 세번째
		bag = dao.one(index + 2);
		if (bag != null) {
			ImageIcon icon = new ImageIcon(bag.getImg());
			b3.setIcon(icon);
			t3.setText(bag.getTitle());
			r3.setText(bag.getRank() + "");
		} else {
			System.out.println("불가");
		}

		JButton left = new JButton("<");
		left.setFont(font);
		left.setBounds(50, 300, 50, 50);
		left.setBorder(null);
		left.setBackground(Color.lightGray);
		left.addActionListener(new ActionListener() {
			InfoDAO dao = new InfoDAO();
			InfoVO bag = null;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 1) {
					index = index - 3;
					// 첫번째
					bag = dao.one(index);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b1.setIcon(icon);
						t1.setText(bag.getTitle());
						r1.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
					}
					// 두번째
					bag = dao.one(index + 1);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b2.setIcon(icon);
						t2.setText(bag.getTitle());
						r2.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
					}
					// 세번째
					bag = dao.one(index + 2);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b3.setIcon(icon);
						t3.setText(bag.getTitle());
						r3.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
					}
				}

			}
		});

		JButton right = new JButton(">");
		right.setFont(font);
		right.setBounds(890, 300, 50, 50);
		right.setBorder(null);
		right.setBackground(Color.lightGray);
		right.addActionListener(new ActionListener() {
			InfoDAO dao = new InfoDAO();
			InfoVO bag = null;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (index < 7) {
					index = index + 3;
					// 첫번째
					bag = dao.one(index);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b1.setIcon(icon);
						t1.setText(bag.getTitle());
						r1.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
					}
					// 두번째
					bag = dao.one(index + 1);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b2.setIcon(icon);
						t2.setText(bag.getTitle());
						r2.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
						b2.setIcon(null);
						t2.setText("");
						r2.setText("");
					}
					// 세번째
					bag = dao.one(index + 2);
					if (bag != null) {
						ImageIcon icon = new ImageIcon(bag.getImg());
						b3.setIcon(icon);
						t3.setText(bag.getTitle());
						r3.setText(bag.getRank() + "");
					} else {
						System.out.println("불가");
						b3.setIcon(null);
						t3.setText("");
						r3.setText("");
					}
				}

			}
		});
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				InfoUI info = new InfoUI();
				BookVO bag = dao.one(index);
				info.open(bag);
			}
		});

		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				InfoUI info = new InfoUI();
				BookVO bag = dao.one(index + 1);
				info.open(bag);
			}
		});

		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				InfoUI info = new InfoUI();
				BookVO bag = dao.one(index + 2);
				info.open(bag);
			}
		});

		f.add(l1);
		f.add(r1);
		f.add(r2);
		f.add(r3);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(left);
		f.add(right);
		f.add(b4);

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
