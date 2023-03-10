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

import 자바DB연결.InfoDAO;
import 자바DB연결.InfoVO;

public class 책등록UI {

	//public static void main(String[] args) {
	public void open() {
		JFrame f = new JFrame("책 등록");
		f.setSize(700, 500);
		f.setLayout(new FlowLayout());
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		f.getContentPane().setBackground(new Color(204, 229, 255));
		
		JLabel l1 = new JLabel("제목");
		l1.setFont(font);
		JTextField t1 = new JTextField(10);
		t1.setFont(font);
		
		JLabel l2 = new JLabel(" 저자");
		l2.setFont(font);
		JTextField t2 = new JTextField(10);
		t2.setFont(font);
		
		JLabel l3 = new JLabel("고유넘버");
		l3.setFont(font);
		JTextField t3 = new JTextField(2);
		t3.setFont(font);
		
		JLabel l4 = new JLabel(" 대표이미지");
		l4.setFont(font);
		JTextField t4 = new JTextField(6);
		t4.setFont(font);
		
		JLabel l5 = new JLabel(" 장르");
		l5.setFont(font);
		JTextField t5 = new JTextField(6);
		t5.setFont(font);

		JLabel l6 = new JLabel("목차");
		l6.setFont(font);
		JTextField t6 = new JTextField(25);
		t6.setFont(font);
		
		JLabel l7 = new JLabel("기본정보");
		l7.setFont(font);
		JTextArea t7 = new JTextArea(5, 25);
		t7.setFont(font);

		JLabel l8 = new JLabel(" 순위");
		l8.setFont(font);
		JTextField t8 = new JTextField(2);
		t8.setText("0");
		t8.setFont(font);
		
		JLabel l9 = new JLabel(" 출판사");
		l9.setFont(font);
		JTextField t9 = new JTextField(18);
		t9.setFont(font);
		
		JButton b1 = new JButton("등록하기");
		b1.setFont(font);
		b1.setBackground(Color.yellow);
		
		JButton b2 = new JButton("삭제하기");
		b2.setFont(font);
		b2.setBackground(Color.yellow);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = t1.getText();
				String writer = t2.getText();
				String no = t3.getText();
				String img = t4.getText();
				String genre = t5.getText();
				String content = t6.getText();
				String info = t7.getText();
				String rank = t8.getText();
				String publisher = t9.getText();
				
				if (no.equals("")) {
					JOptionPane.showMessageDialog(f, "no를 입력하세요");
				} else {
					InfoDAO dao = new InfoDAO();
					InfoVO bag = new InfoVO();
					
					int no2 = Integer.parseInt(no);
					int rank2 = Integer.parseInt(rank);
					
					bag.setTitle(title);
					bag.setWriter(writer);
					bag.setNo(no2);
					bag.setImg(img);
					bag.setGenre(genre);
					bag.setContent(content);
					bag.setInfo(info);
					bag.setRank(rank2);
					bag.setPublisher(publisher);
					
					int result = dao.insert(bag);
					
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "책 등록 성공");
					} else {
						JOptionPane.showMessageDialog(f, "책 등록 실패");
					}
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String no = t3.getText();
				int no2 = Integer.parseInt(no);
				
				InfoDAO dao = new InfoDAO();
				int result = dao.delete(no2);
				
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "책 삭제 성공");
				} else {
					JOptionPane.showMessageDialog(f, "책 삭제 실패");
				}
			}
		});
		
		f.add(l1); f.add(t1);
		f.add(l2); f.add(t2);
		f.add(l3); f.add(t3);
		f.add(l4); f.add(t4);
		f.add(l5); f.add(t5);
		f.add(l8); f.add(t8);
		f.add(l9); f.add(t9);
		f.add(l6); f.add(t6);
		f.add(l7); f.add(t7);
		f.add(b1); f.add(b2);
		
		f.setVisible(true);
	}

}