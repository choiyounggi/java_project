package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class OrderFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(OrderFrame.class.getResource("res/logo3.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	public OrderFrame(String id) {
		LookupPoint lp = new LookupPoint();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 150, 600, 800
				);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new 
				JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Á¾·áÇÏ½Ã°Ú½À´Ï±î?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					OrderFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
			
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(200, 10, 200, 100);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JTextPane textOrderHistory = new JTextPane();
		textOrderHistory.setBackground(Color.BLACK);
		textOrderHistory.setForeground(Color.WHITE);
		textOrderHistory.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		textOrderHistory.setBounds(100, 176, 400, 369);
		textOrderHistory.setText(new GetUserOrder().order());
		contentPane.add(textOrderHistory);
		
		JLabel lblTitle = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblTitle.setBounds(100, 134, 400, 32);
		contentPane.add(lblTitle);
		
		JLabel lblTotalPrice = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561 : ");
		lblTotalPrice.setForeground(Color.WHITE);
		lblTotalPrice.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblTotalPrice.setBounds(100, 611, 400, 32);
		lblTotalPrice.setText(String.format("ÃÑ °áÁ¦ ±Ý¾× : %d¿ø", new GetTotalPrice().totalPrice()));
		contentPane.add(lblTotalPrice);
		
		JLabel lblPayment = new JLabel("\uACB0\uC81C\uD558\uAE30");
		lblPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPayment.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPayment.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblPayment.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblPayment.setForeground(Color.GRAY);
			}
		});
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblPayment.setBounds(200, 682, 200, 20);
		contentPane.add(lblPayment);
		
		int point = new LookupPoint().point(id);
		
		JLabel lblPoint = new JLabel("\uC0AC\uC6A9 \uAC00\uB2A5\uD55C \uD3EC\uC778\uD2B8 : 0\uC6D0");
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblPoint.setBounds(100, 569, 355, 32);
		if (point > 5000) {
			lblPoint.setText(String.format("»ç¿ë °¡´ÉÇÑ Æ÷ÀÎÆ® : %d¿ø", point));
		}
		contentPane.add(lblPoint);
		
		JLabel lblUsePoint = new JLabel("\uC0AC\uC6A9\uD558\uAE30");
		lblUsePoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new GetTotalPrice().totalPrice() < point) {
					lblTotalPrice.setText("ÃÑ °áÁ¦ ±Ý¾× : 0¿ø");
				} else {
					lblTotalPrice.setText(String.format("ÃÑ °áÁ¦ ±Ý¾× : %d¿ø", new GetTotalPrice().totalPrice() - point));
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUsePoint.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUsePoint.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblUsePoint.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblUsePoint.setForeground(Color.GRAY);
			}
		});
		lblUsePoint.setForeground(Color.WHITE);
		lblUsePoint.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblUsePoint.setBounds(467, 576, 60, 20);
		contentPane.add(lblUsePoint);
	}
}
