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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import login.FrameLogin;

public class ManagerFrame extends JFrame {

	private Image img_logo = new ImageIcon(MainFrame.class.getResource("res/logo3.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;

	public ManagerFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 150, 1200, 800
				);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new 
				JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¾îÇÃ¸®ÄÉÀÌ¼ÇÀ» Á¾·áÇÏ½Ã°Ú½À´Ï±î?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ManagerFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.setForeground(Color.GRAY);
			}
			
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(1180, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(500, 30, 200, 100);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblLookupOrder = new JLabel("\uC8FC\uBB38 \uC870\uD68C");
		lblLookupOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLookupOrder.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLookupOrder.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
		});
		lblLookupOrder.setBounds(176, 448, 139, 43);
		contentPane.add(lblLookupOrder);
		lblLookupOrder.setForeground(Color.WHITE);
		lblLookupOrder.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		
		JLabel lblLookupUsers = new JLabel("\uACE0\uAC1D \uC870\uD68C");
		lblLookupUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLookupUsers.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLookupUsers.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
		});
		lblLookupUsers.setForeground(Color.WHITE);
		lblLookupUsers.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblLookupUsers.setBounds(176, 566, 139, 43);
		contentPane.add(lblLookupUsers);
		
		JLabel lblLookupSales = new JLabel("\uB9E4\uCD9C \uC870\uD68C");
		lblLookupSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLookupSales.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLookupSales.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
		});
		lblLookupSales.setForeground(Color.WHITE);
		lblLookupSales.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblLookupSales.setBounds(176, 320, 139, 43);
		contentPane.add(lblLookupSales);
		
		JLabel lblLookup = new JLabel("\uC870\uD68C \uAE30\uB2A5");
		lblLookup.setBounds(176, 186, 154, 49);
		contentPane.add(lblLookup);
		lblLookup.setForeground(new Color(0, 102, 0));
		lblLookup.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		
		JLabel lblNewLabel_6_3 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3.setBounds(176, 228, 144, 15);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblModify = new JLabel("\uC218\uC815 \uAE30\uB2A5");
		lblModify.setForeground(new Color(0, 102, 0));
		lblModify.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		lblModify.setBounds(526, 186, 154, 49);
		contentPane.add(lblModify);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3_1.setBounds(526, 228, 144, 15);
		contentPane.add(lblNewLabel_6_3_1);
		
		JLabel lblModifyPoint = new JLabel("\uD3EC\uC778\uD2B8 \uC218\uC815");
		lblModifyPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblModifyPoint.setForeground(Color.WHITE);
		lblModifyPoint.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblModifyPoint.setBounds(516, 320, 174, 43);
		contentPane.add(lblModifyPoint);
		
		JLabel lblModifyUserInfo = new JLabel("\uACE0\uAC1D \uC815\uBCF4 \uC218\uC815");
		lblModifyUserInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblModifyUserInfo.setForeground(Color.WHITE);
		lblModifyUserInfo.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblModifyUserInfo.setBounds(497, 448, 214, 43);
		contentPane.add(lblModifyUserInfo);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC870\uD68C \uAE30\uB2A5");
		lblNewLabel_2_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		lblNewLabel_2_2.setBounds(891, 186, 154, 49);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_6_3_2 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3_2.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3_2.setBounds(891, 228, 144, 15);
		contentPane.add(lblNewLabel_6_3_2);
		
		JLabel lblSales_2 = new JLabel("\uB9E4\uCD9C \uC870\uD68C");
		lblSales_2.setForeground(Color.WHITE);
		lblSales_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblSales_2.setBounds(891, 320, 139, 43);
		contentPane.add(lblSales_2);
		
		JLabel lblOrder_2 = new JLabel("\uC8FC\uBB38 \uC870\uD68C");
		lblOrder_2.setForeground(Color.WHITE);
		lblOrder_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblOrder_2.setBounds(891, 448, 139, 43);
		contentPane.add(lblOrder_2);
		
		JLabel lblUsers_2 = new JLabel("\uACE0\uAC1D \uC870\uD68C");
		lblUsers_2.setForeground(Color.WHITE);
		lblUsers_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblUsers_2.setBounds(891, 566, 139, 43);
		contentPane.add(lblUsers_2);
		
		JLabel lblLogout = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "·Î±×¾Æ¿ô ÇÏ½Ã°Ú½À´Ï±î?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ManagerFrame.this.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								FrameLogin frame = new FrameLogin();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblLogout.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblLogout.setForeground(Color.GRAY);
			}
		});
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		lblLogout.setBounds(919, 58, 96, 27);
		contentPane.add(lblLogout);
	}
}
