package main.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;


public class Modify_point_frame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify_point_frame frame = new Modify_point_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modify_point_frame() {
		setUndecorated(true);
		setBounds(800, 321, 330, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD3EC\uC778\uD2B8 \uC218\uC815");
		lblNewLabel.setBounds(121, 37, 86, 25);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Modify_point_frame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
		});
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(310, 0, 18, 15);
		panel.add(lblX);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblId.setBounds(46, 130, 57, 15);
		panel.add(lblId);
		
		id = new JTextField();
		id.setBounds(152, 129, 116, 21);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblPlusPoint = new JLabel("\uD3EC\uC778\uD2B8");
		lblPlusPoint.setBounds(46, 224, 57, 15);
		panel.add(lblPlusPoint);
		
		point = new JTextField();
		point.setColumns(10);
		point.setBounds(152, 221, 116, 21);
		panel.add(point);
		
		JPanel plus_panel = new JPanel();
		plus_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user_id = id.getText();
				String overlap = new signup.CheckOverlapId().checkOverlap(user_id);
				if (user_id.equals("")) {
					JOptionPane.showMessageDialog(null, "수정을 원하는 ID를 입력해주세요.");
				} else if (overlap == null) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 사용자입니다.");
				} else if (point.getText().equals("") || Integer.parseInt(point.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "포인트를 정확히 입력해주세요.");
				} else {
					new Modify_point(user_id, Integer.parseInt(point.getText()));
					JOptionPane.showMessageDialog(null, "포인트 수정이 완료되었습니다.");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				plus_panel.setBackground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				plus_panel.setBackground(Color.LIGHT_GRAY);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				plus_panel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				plus_panel.setBackground(Color.GRAY);
			}
		});
		plus_panel.setBackground(Color.LIGHT_GRAY);
		plus_panel.setBounds(46, 311, 86, 30);
		panel.add(plus_panel);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD94\uAC00");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		plus_panel.add(lblNewLabel_2);
		
		JPanel minus_panel = new JPanel();
		minus_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user_id = id.getText();
				String overlap = new signup.CheckOverlapId().checkOverlap(user_id);
				if (user_id.equals("")) {
					JOptionPane.showMessageDialog(null, "수정을 원하는 ID를 입력해주세요.");
				}
				else if (overlap == null) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 사용자입니다.");
				} else if (point.getText().equals("") || Integer.parseInt(point.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "포인트를 정확히 입력해주세요.");
				}else {
					new Modify_point(user_id, (Integer.parseInt(point.getText()) * -1));
					JOptionPane.showMessageDialog(null, "포인트 수정이 완료되었습니다.");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				minus_panel.setBackground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minus_panel.setBackground(Color.LIGHT_GRAY);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				minus_panel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				minus_panel.setBackground(Color.GRAY);
			}
		});
		minus_panel.setBackground(Color.LIGHT_GRAY);
		minus_panel.setBounds(193, 311, 86, 30);
		panel.add(minus_panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uCC28\uAC10");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		minus_panel.add(lblNewLabel_2_1);
		
	}
}
