package main.manual;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import login.FrameLogin;
import main.UpdateBasket;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManualFrame extends JFrame {
	
	private JPanel contentPane;

	String tem = "Hot";
	
	public ManualFrame(String menu_name, Image menu, String menuName, String explanation, String id) {
		if (menu_name.equals("espresso_roast") || menu_name.equals("guatemala_antigua")) {
			setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(675, 150, 550, 800
					);
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			
			JLabel lblX = new JLabel("X");
			lblX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						ManualFrame.this.dispose();
					}
				}
			});
			
			
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ManualFrame.this.dispose();
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
			lblX.setBounds(530, 0, 20, 20);
			contentPane.add(lblX);
			
			JLabel lblMenuImg = new JLabel();
			lblMenuImg.setBounds(91, 96, 360, 376);
			contentPane.add(lblMenuImg);
			lblMenuImg.setIcon(new ImageIcon(menu));
			
			JTextPane txtMenuName = new JTextPane();
			txtMenuName.setText(menuName);
			txtMenuName.setBackground(Color.BLACK);
			txtMenuName.setForeground(Color.WHITE);
			txtMenuName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			txtMenuName.setBounds(91, 548, 360, 37);
			contentPane.add(txtMenuName);
			
			JTextPane txtExplanation = new JTextPane();
			txtExplanation.setText(explanation);
			txtExplanation.setForeground(Color.WHITE);
			txtExplanation.setBackground(Color.BLACK);
			txtExplanation.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			txtExplanation.setBounds(91, 600, 360, 107);
			contentPane.add(txtExplanation);
		
		} else {
			if (menu_name.contains("tea") || menu_name.contains("pink") || menu_name.contains("cool")) {
				setUndecorated(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(675, 150, 550, 800
						);
				contentPane = new JPanel();
				contentPane.setBackground(Color.BLACK);
				contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				
				JLabel lblX = new JLabel("X");
				lblX.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						int key = e.getKeyCode();
						if (key == KeyEvent.VK_ENTER) {
							ManualFrame.this.dispose();
						}
					}
				});
				
				
				lblX.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ManualFrame.this.dispose();
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
					
				});
				lblX.setForeground(Color.WHITE);
				lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.setBounds(530, 0, 20, 20);
				contentPane.add(lblX);
				
				JLabel lblMenuImg = new JLabel();
				lblMenuImg.setBounds(91, 50, 360, 376);
				contentPane.add(lblMenuImg);
				lblMenuImg.setIcon(new ImageIcon(menu));
				
				JTextPane txtMenuName = new JTextPane();
				txtMenuName.setText(menuName);
				txtMenuName.setBackground(Color.BLACK);
				txtMenuName.setForeground(Color.WHITE);
				txtMenuName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
				txtMenuName.setBounds(91, 424, 360, 37);
				contentPane.add(txtMenuName);
				
				JTextPane txtExplanation = new JTextPane();
				txtExplanation.setText(explanation);
				txtExplanation.setForeground(Color.WHITE);
				txtExplanation.setBackground(Color.BLACK);
				txtExplanation.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
				txtExplanation.setBounds(91, 459, 360, 107);
				contentPane.add(txtExplanation);
				
				JRadioButton rdbtnIceOrHot = new JRadioButton("\uC544\uC774\uC2A4");
				rdbtnIceOrHot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnIceOrHot.isSelected()) {
							tem = "Ice";
						}
					}
				});
				rdbtnIceOrHot.setBackground(Color.BLACK);
				rdbtnIceOrHot.setForeground(Color.WHITE);
				rdbtnIceOrHot.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				rdbtnIceOrHot.setBounds(415, 576, 68, 25);
				contentPane.add(rdbtnIceOrHot);
				
				Object a = rdbtnIceOrHot.getSelectedObjects();
				
				JSpinner quantity = new JSpinner();
				quantity.setBounds(415, 609, 68, 25);
				contentPane.add(quantity);
				
				String[] sizes = {"Tall", "Grande", "Venti"};
				JComboBox size = new JComboBox(sizes);
				size.setFont(new Font("Arial", Font.PLAIN, 12));
				size.setBounds(415, 642, 68, 23);
				contentPane.add(size);
				
				JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uC2A4 or \uD56B (\uBBF8\uC120\uD0DD \uC2DC HOT)");
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(91, 579, 191, 15);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_2_1 = new JLabel("\uC218\uB7C9");
				lblNewLabel_2_1.setForeground(Color.WHITE);
				lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2_1.setBounds(91, 612, 131, 15);
				contentPane.add(lblNewLabel_2_1);
				
				JPanel panel = new JPanel();
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int quan = Integer.parseInt(quantity.getValue().toString());
						String s = size.getSelectedItem().toString();
						String size_name = size.getSelectedItem().toString() + "_price";
						String order = String.format("%s(%s, %s) x %d\n", menu_name, s, tem, quan);
						int price = new GetPrice().price(size_name, menu_name);
						int total_price = price * quan;	
						
						if (quan > 0) {
							JOptionPane.showMessageDialog(null, "Àå¹Ù±¸´Ï¿¡ Ãß°¡ ¿Ï·á");
							new UpdateBasket(order, total_price);
							ManualFrame.this.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "¼ö·®À» ¼±ÅÃÇØÁÖ¼¼¿ä.");
						}
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						panel.setBackground(new Color(164, 164, 164));
						Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
						setCursor(cursor);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel.setBackground(new Color(192, 192, 192));
						Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(normalCursor);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						panel.setBackground(new Color(192, 192, 192));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						panel.setBackground(new Color(164, 164, 164));
					}
				});
				panel.setBackground(new Color(192, 192, 192));
				panel.setBounds(212, 724, 130, 30);
				contentPane.add(panel);
				
				JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8\uC5D0 \uCD94\uAC00");
				lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_2_1_1 = new JLabel("\uC0AC\uC774\uC988");
				lblNewLabel_2_1_1.setForeground(Color.WHITE);
				lblNewLabel_2_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2_1_1.setBounds(91, 646, 131, 15);
				contentPane.add(lblNewLabel_2_1_1);

			} else {
				setUndecorated(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(675, 150, 550, 800
						);
				contentPane = new JPanel();
				contentPane.setBackground(Color.BLACK);
				contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				
				JLabel lblX = new JLabel("X");
				lblX.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						int key = e.getKeyCode();
						if (key == KeyEvent.VK_ENTER) {
							ManualFrame.this.dispose();
						}
					}
				});
				
				
				lblX.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ManualFrame.this.dispose();
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
				lblX.setBounds(530, 0, 20, 20);
				contentPane.add(lblX);
				
				JLabel lblMenuImg = new JLabel();
				lblMenuImg.setBounds(91, 50, 360, 376);
				contentPane.add(lblMenuImg);
				lblMenuImg.setIcon(new ImageIcon(menu));
				
				JTextPane txtMenuName = new JTextPane();
				txtMenuName.setText(menuName);
				txtMenuName.setBackground(Color.BLACK);
				txtMenuName.setForeground(Color.WHITE);
				txtMenuName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
				txtMenuName.setBounds(91, 424, 360, 37);
				contentPane.add(txtMenuName);
				
				JTextPane txtExplanation = new JTextPane();
				txtExplanation.setText(explanation);
				txtExplanation.setForeground(Color.WHITE);
				txtExplanation.setBackground(Color.BLACK);
				txtExplanation.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
				txtExplanation.setBounds(91, 459, 360, 107);
				contentPane.add(txtExplanation);
				
				JRadioButton rdbtnIceOrHot = new JRadioButton("\uC544\uC774\uC2A4");
				rdbtnIceOrHot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnIceOrHot.isSelected()) {
							tem = "Ice";
						}
					}
				});
				rdbtnIceOrHot.setBackground(Color.BLACK);
				rdbtnIceOrHot.setForeground(Color.WHITE);
				rdbtnIceOrHot.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				rdbtnIceOrHot.setBounds(415, 576, 68, 25);
				contentPane.add(rdbtnIceOrHot);
				
				Object a = rdbtnIceOrHot.getSelectedObjects();
				
				JSpinner quantity = new JSpinner();
				quantity.setBounds(415, 609, 68, 25);
				contentPane.add(quantity);
				
				String[] sizes = {"Tall", "Grande", "Venti"};
				JComboBox size = new JComboBox(sizes);
				size.setFont(new Font("Arial", Font.PLAIN, 12));
				size.setBounds(415, 642, 68, 23);
				contentPane.add(size);
				
				String[] beans = {"¿¡½ºÇÁ·¹¼Ò ·Î½ºÆ®", "°úÅ×¸»¶ó ¾ÈÆ¼±¸¾Æ"};
				JComboBox bean = new JComboBox(beans);
				bean.setBounds(355, 674, 128, 23);
				contentPane.add(bean);
				
				JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uC2A4 or \uD56B (\uBBF8\uC120\uD0DD \uC2DC HOT)");
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(91, 579, 191, 15);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_2_1 = new JLabel("\uC218\uB7C9");
				lblNewLabel_2_1.setForeground(Color.WHITE);
				lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2_1.setBounds(91, 612, 131, 15);
				contentPane.add(lblNewLabel_2_1);
				
				JPanel panel = new JPanel();
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int quan = Integer.parseInt(quantity.getValue().toString());
						String s = size.getSelectedItem().toString();
						String size_name = size.getSelectedItem().toString() + "_price";
						String b = bean.getSelectedItem().toString();
						String order = String.format("%s(%s, %s, %s) x %d\n", menu_name, s, tem, b, quan);
						int price = new GetPrice().price(size_name, menu_name);
						
						if (quan > 0) {
							JOptionPane.showMessageDialog(null, "Àå¹Ù±¸´Ï¿¡ Ãß°¡ ¿Ï·á");
							if (b.contains("¿¡½ºÇÁ·¹¼Ò")) {
								int total_price = price * quan;
								new UpdateBasket(order, total_price);
							} else {
								int total_price = (price + 300) * quan;
								new UpdateBasket(order, total_price);
							}
							ManualFrame.this.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "¼ö·®À» ¼±ÅÃÇØÁÖ¼¼¿ä.");
						}
						
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						panel.setBackground(new Color(164, 164, 164));
						Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
						setCursor(cursor);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel.setBackground(new Color(192, 192, 192));
						Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(normalCursor);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						panel.setBackground(new Color(192, 192, 192));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						panel.setBackground(new Color(164, 164, 164));
					}
				});
				panel.setBackground(new Color(192, 192, 192));
				panel.setBounds(212, 724, 130, 30);
				contentPane.add(panel);
				
				JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8\uC5D0 \uCD94\uAC00");
				lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_2_1_1 = new JLabel("\uC0AC\uC774\uC988");
				lblNewLabel_2_1_1.setForeground(Color.WHITE);
				lblNewLabel_2_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2_1_1.setBounds(91, 646, 131, 15);
				contentPane.add(lblNewLabel_2_1_1);
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC6D0\uB450 (\uCEE4\uD53C, \uC5D0\uC2A4\uD504\uB808\uC18C \uC8FC\uBB38 \uC2DC \uC120\uD0DD)");
				lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
				lblNewLabel_2_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
				lblNewLabel_2_1_1_1.setBounds(91, 678, 232, 15);
				contentPane.add(lblNewLabel_2_1_1_1);
			}
		}	
		
	}
}
