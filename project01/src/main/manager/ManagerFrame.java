package main.manager;

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
import main.MainFrame;

public class ManagerFrame extends JFrame {

	private Image img_logo = new ImageIcon(MainFrame.class.getResource("res/logo3.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;

	public ManagerFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 150, 1200, 800);
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
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Order_list_frame frame = new Order_list_frame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
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
		lblLookupOrder.setBounds(350, 447, 139, 43);
		contentPane.add(lblLookupOrder);
		lblLookupOrder.setForeground(Color.WHITE);
		lblLookupOrder.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		
		JLabel lblLookupSales = new JLabel("\uB9E4\uCD9C \uC870\uD68C");
		lblLookupSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
				JOptionPane.showMessageDialog(null, new get_total_sales().result());
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
		lblLookupSales.setBounds(350, 319, 139, 43);
		contentPane.add(lblLookupSales);
		
		JLabel lblLookup = new JLabel("\uC870\uD68C \uAE30\uB2A5");
		lblLookup.setBounds(350, 185, 154, 49);
		contentPane.add(lblLookup);
		lblLookup.setForeground(new Color(0, 102, 0));
		lblLookup.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		
		JLabel lblNewLabel_6_3 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3.setBounds(350, 227, 144, 15);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblModify = new JLabel("\uC218\uC815 \uAE30\uB2A5");
		lblModify.setForeground(new Color(0, 102, 0));
		lblModify.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		lblModify.setBounds(700, 185, 154, 49);
		contentPane.add(lblModify);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3_1.setBounds(700, 227, 144, 15);
		contentPane.add(lblNewLabel_6_3_1);
		
		JLabel lblModifyPoint = new JLabel("\uD3EC\uC778\uD2B8 \uC218\uC815");
		lblModifyPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblModifyPoint.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblModifyPoint.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
		});
		lblModifyPoint.setForeground(Color.WHITE);
		lblModifyPoint.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblModifyPoint.setBounds(690, 319, 174, 43);
		contentPane.add(lblModifyPoint);
		
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
