package main;

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


public class MainFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(MainFrame.class.getResource("res/logo3.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

	private Image black_tea_lemonade = new ImageIcon(ManualFrame.class.getResource("menu/black_tea_lemonade.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image cool_lime = new ImageIcon(ManualFrame.class.getResource("menu/cool_lime.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image passion_tango_tea_lemonade = new ImageIcon(ManualFrame.class.getResource("menu/passion_tango.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image pink_grapefruit = new ImageIcon(ManualFrame.class.getResource("menu/pink_grapefruit.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image lime_passion_tea = new ImageIcon(ManualFrame.class.getResource("menu/lime_passion_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image mint_blend_tea = new ImageIcon(ManualFrame.class.getResource("menu/mint_blend_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image earl_grey_tea = new ImageIcon(ManualFrame.class.getResource("menu/earl_grey_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image chamomile_blend_tea = new ImageIcon(ManualFrame.class.getResource("menu/chamomile_blend_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image hibiscus_blend_tea = new ImageIcon(ManualFrame.class.getResource("menu/hibiscus_blend_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image passion_fruit_tea = new ImageIcon(ManualFrame.class.getResource("menu/passion_fruit_tea.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image coffee = new ImageIcon(ManualFrame.class.getResource("menu/coffee.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image brewed_coffee = new ImageIcon(ManualFrame.class.getResource("menu/brewed_coffee.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image caramel_macchiato = new ImageIcon(ManualFrame.class.getResource("menu/caramel_macchiato.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image caffe_latte = new ImageIcon(ManualFrame.class.getResource("menu/caffe_latte.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image caffe_americano = new ImageIcon(ManualFrame.class.getResource("menu/caffe_americano.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image caffe_mocha = new ImageIcon(ManualFrame.class.getResource("menu/caffe_mocha.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image cold_brew = new ImageIcon(ManualFrame.class.getResource("menu/cold_brew.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image dolce_cold_brew = new ImageIcon(ManualFrame.class.getResource("menu/dolce_cold_brew.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image espresso_roast = new ImageIcon(ManualFrame.class.getResource("menu/espresso_roast.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);
	private Image guatemala_antigua = new ImageIcon(ManualFrame.class.getResource("menu/guatemala_antigua.jpg")).getImage().getScaledInstance(360, 376, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	private int total = 0;

	public MainFrame(String id) {
		new CreateBasket(id);
		
		LookupPoint lp = new LookupPoint();
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
					new DeleteBasket();
					MainFrame.this.dispose();
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
		
		JLabel lblNewLabel = new JLabel("\uC2A4\uD0C0\uBC85\uC2A4 \uD53C\uC9C0\uC624");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setBounds(127, 151, 193, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD2F0(\uD2F0\uBC14\uB098)");
		lblNewLabel_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel_1.setBounds(127, 397, 193, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uCEE4\uD53C & \uC5D0\uC2A4\uD504\uB808\uC18C");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(709, 151, 193, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Starbucks Fizzio\u2122");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2.setBounds(301, 163, 166, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tea(Teavana)");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(265, 409, 166, 20);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Coffee & Espresso");
		lblNewLabel_2_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(914, 163, 166, 20);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uD0C4\uC0B0 \uAC15\uB3C4\uB294 Light/Medium/Extra \uC911 \uC120\uD0DD \uAC00\uB2A5 \uD569\uB2C8\uB2E4.");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(127, 189, 304, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uB2E4\uC591\uD55C \uCC3B\uC78E\uACFC \uD5A5\uC2E0\uB8CC \uB4F1 \uAC1C\uC131 \uC788\uB294 \uC7AC\uB8CC\uB97C");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_3_1.setBounds(127, 439, 304, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\uD63C\uD569\uD558\uC5EC \uC0C8\uB85C\uC6B4 \uB9DB\uACFC \uD5A5\uC758 \uD2F0\uB97C \uC120\uBCF4\uC785\uB2C8\uB2E4.");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_3_1_1.setBounds(127, 458, 304, 15);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("\uC5D0\uC2A4\uD504\uB808\uC18C \uC74C\uB8CC \uC8FC\uBB38 \uC2DC, \uB450 \uAC00\uC9C0 \uC6D0\uB450 \uC911 \uC120\uD0DD\uD558\uC5EC \uC990\uAE30\uC2E4 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_3_1_2.setBounds(709, 189, 424, 15);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("(\uACFC\uD14C\uB9D0\uB77C \uC120\uD0DD \uC2DC, 300\uC6D0 \uCD94\uAC00)");
		lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_3_1_2_1.setBounds(709, 201, 424, 15);
		contentPane.add(lblNewLabel_3_1_2_1);
		
		JLabel Fizzio1 = new JLabel("\uBE14\uB799 \uD2F0 \uB808\uBAA8\uB124\uC774\uB4DC");
		Fizzio1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("black_tea_lemonade", black_tea_lemonade, "ºí·¢ Æ¼ ·¹¸ð³×ÀÌµå", "ÁøÇÏ°Ô ¿ì¸° ºí·¢ Æ¼¿Í »óÅ­ÇÑ ·¹¸ð³×ÀÌµå¸¦ ´õÇÑ Ã»·®°¨ ÀÖ´Â À½·áÀÔ´Ï´Ù.\r\n"
									+ "¸ñ ³Ñ±èÀÌ ÁÁÀº °¡º­¿î Åº»êÀÌ Ã·°¡µÇ¾î ±ò²ûÇÏ°Ô Áñ±æ ¼ö ÀÖ½À´Ï´Ù.", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Fizzio1.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Fizzio1.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Fizzio1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Fizzio1.setForeground(Color.GRAY);
			}
		});
		Fizzio1.setForeground(Color.WHITE);
		Fizzio1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Fizzio1.setBounds(127, 248, 106, 15);
		contentPane.add(Fizzio1);
		
		JLabel lblNewLabel_5 = new JLabel("Black Tea Lemonade");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(127, 260, 106, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Passion Tango Tea Lemonade");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_1.setBounds(127, 297, 174, 15);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel Fizzio2 = new JLabel("\uD328\uC158 \uD0F1\uACE0 \uD2F0 \uB808\uBAA8\uB124\uC774\uB4DC");
		Fizzio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("passion_tango_tea_lemonade", passion_tango_tea_lemonade, "ÆÐ¼Ç ÅÊ°í Æ¼ ·¹¸ð³×ÀÌµå", "²É Çâ±â¿Í ´ÞÄÞÇÏ°í »óÅ­ÇÑ ½ÃÆ®·¯½º ÇâÀ» Åº»ê°ú ÇÔ²² ´õ¿í Ç³ºÎÇÏ°Ô ´À³¢°í ½ÍÀ¸½Ã´Ù¸é ÆÐ¼Ç Æ¼ ·¹¸ð³×ÀÌµå ÇÇÁö¿À¸¦ ¼±ÅÃÇØ º¸¼¼¿ä! ¾ðÁ¦ Ã£¾Æµµ ±âºÐÀÌ ÁÁ¾ÆÁö´Â ÈÇ¸¢ÇÑ À½·áÀÔ´Ï´Ù.", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Fizzio2.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Fizzio2.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Fizzio2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Fizzio2.setForeground(Color.GRAY);
			}
		});
		Fizzio2.setForeground(Color.WHITE);
		Fizzio2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Fizzio2.setBounds(127, 285, 132, 15);
		contentPane.add(Fizzio2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Pink Grapefruit");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_2.setBounds(127, 334, 174, 15);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel Fizzio3 = new JLabel("\uD551\uD06C \uC790\uBABD");
		Fizzio3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("pink_grapefruit", pink_grapefruit, "ÇÎÅ© ÀÚ¸ù", "½Å¼±ÇÏ°Ô ÂøÁóÇÑ ÀÚ¸ùÀÌ ½ºÅ¸¹÷½º ¸¸ÀÇ ¼öÁ¦ Åº»êÀ½·á·Î ¼±º¸ÀÔ´Ï´Ù.\r\n"
									+ "ÇÎÅ©ºûÀÇ »ýÀÚ¸ùÀ¸·Î ¾Æ¸§´Ù¿î ºñÁÖ¾ó°ú ½Å¼±ÇÔÀ» ´À²¸ º¸¼¼¿ä.", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Fizzio3.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Fizzio3.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Fizzio3.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Fizzio3.setForeground(Color.GRAY);
			}
		});
		Fizzio3.setForeground(Color.WHITE);
		Fizzio3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Fizzio3.setBounds(127, 322, 52, 15);
		contentPane.add(Fizzio3);
		
		JLabel lblNewLabel_5_3 = new JLabel("Cool Lime");
		lblNewLabel_5_3.setForeground(Color.WHITE);
		lblNewLabel_5_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3.setBounds(127, 371, 174, 15);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel Fizzio4 = new JLabel("\uCFE8 \uB77C\uC784");
		Fizzio4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("cool_lime", cool_lime, "Äð ¶óÀÓ", "±×¸° ºó ÃßÃâ¾×ÀÌ µé¾î°£ ¶óÀÓ º£ÀÌ½º¿¡ °ÇÁ¶µÈ ¶óÀÓ ½½¶óÀÌ½º¸¦ ³Ö°í ½ºÆÄÅ¬¸µÇÑ ½Ã¿øÇÏ°í Ã»·®°¨ ÀÖ´Â À½·áÀÔ´Ï´Ù. (Ä«ÆäÀÎÀÌ ÇÔÀ¯µÈ Åº»êÀ½·áÀÔ´Ï´Ù)", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Fizzio4.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Fizzio4.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Fizzio4.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Fizzio4.setForeground(Color.GRAY);
			}
		});
		Fizzio4.setForeground(Color.WHITE);
		Fizzio4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Fizzio4.setBounds(127, 359, 40, 15);
		contentPane.add(Fizzio4);
		
		JLabel T1 = new JLabel("\uB77C\uC784 \uD328\uC158 \uD2F0");
		T1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("lime_passion_tea", lime_passion_tea, "¶óÀÓ ÆÐ¼Ç Æ¼", "»õÄÞ´ÞÄÞÇÑ È÷ºñ½ºÄ¿½º¿Í ¶óÀÓÀÇ ÀÌ±¹ÀûÀÎ Á¶È­°¡ ¸Å·ÂÀûÀÎ ¶óÀÓ ÆÐ¼Ç Æ¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T1.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T1.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T1.setForeground(Color.GRAY);
			}	
		});
		T1.setForeground(Color.WHITE);
		T1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T1.setBounds(127, 498, 68, 15);
		contentPane.add(T1);
		
		JLabel lblNewLabel_5_3_1_1 = new JLabel("Lime Passion Tea");
		lblNewLabel_5_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_1.setBounds(127, 510, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_1);
		
		JLabel T2 = new JLabel("\uBBFC\uD2B8 \uBE14\uB80C\uB4DC \uD2F0");
		T2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("mint_blend_tea", mint_blend_tea, "¹ÎÆ® ºí·»µå Æ¼", "½ºÇÇ¾î¹ÎÆ®, ÆäÆÛ¹ÎÆ®, ·¹¸ó¸ÓÆ²ÀÌ ºí·»µùµÈ »óÄèÇÑ Çãºê Æ¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T2.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T2.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T2.setForeground(Color.GRAY);
			}
		});
		T2.setForeground(Color.WHITE);
		T2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T2.setBounds(127, 535, 85, 15);
		contentPane.add(T2);
		
		JLabel lblNewLabel_5_3_1_2 = new JLabel("Mint Blend Brewed Tea");
		lblNewLabel_5_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_2.setBounds(127, 547, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_2);
		
		JLabel T3 = new JLabel("\uC5BC \uADF8\uB808\uC774 \uD2F0");
		T3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("earl_grey_tea", earl_grey_tea, "¾ó ±×·¹ÀÌ Æ¼", "²ÉÇâ °¡µæÇÑ ¶óº¥´õ¿Í º£¸£°¡¸ø ÇâÀÌ ÁøÇÑ È«Â÷¿Í ºí·»µùµÈ Çâ±ßÇÑ ºí·¢ Æ¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T3.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T3.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T3.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T3.setForeground(Color.GRAY);
			}
		});
		T3.setForeground(Color.WHITE);
		T3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T3.setBounds(127, 572, 68, 15);
		contentPane.add(T3);
		
		JLabel lblNewLabel_5_3_1_3 = new JLabel("Earl Grey Brewed Tea");
		lblNewLabel_5_3_1_3.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_3.setBounds(127, 584, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_3);
		
		JLabel T4 = new JLabel("\uCE90\uBAA8\uB9C8\uC77C \uBE14\uB80C\uB4DC \uD2F0");
		T4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("chamomile_blend_tea", chamomile_blend_tea, "Ä³¸ð¸¶ÀÏ ºí·»µå Æ¼", "Ä³¸ð¸¶ÀÏ°ú ·¹¸ó ±×¶ó½º, ·¹¸ó¹ã, È÷ºñ½ºÄ¿½º µî ºí·»µùµÇ¾î\r\n"
									+ "ÀºÀºÇÏ°í Â÷ºÐÇÑ ÇâÀÌ ±âºÐÀ» ÁÁ°ÔÇÏ´Â Çãºê Æ¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T4.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T4.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T4.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T4.setForeground(Color.GRAY);
			}
		});
		T4.setForeground(Color.WHITE);
		T4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T4.setBounds(127, 609, 106, 15);
		contentPane.add(T4);
		
		JLabel T5 = new JLabel("\uD788\uBE44\uC2A4\uCEE4\uC2A4 \uBE14\uB80C\uB4DC \uD2F0");
		T5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("hibiscus_blend_tea", hibiscus_blend_tea, "È÷ºñ½ºÄ¿½º ºí·»µå Æ¼", "È÷ºñ½ºÄ¿½º, »ç°ú, ÆÄÆÄ¾ß, ¸Á°í, ·¹¸ó±×¶ó½º µîÀÌ ºí·»µùµÈ »óÅ­ÇÑ Çãºê Æ¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T5.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T5.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T5.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T5.setForeground(Color.GRAY);
			}
		});
		T5.setForeground(Color.WHITE);
		T5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T5.setBounds(127, 646, 116, 15);
		contentPane.add(T5);
		
		JLabel T6 = new JLabel("\uD328\uC158 \uD478\uB974\uD2B8 \uD2F0");
		T6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("passion_fruit_tea", passion_fruit_tea, "ÆÐ¼Ç Çª¸£Æ® Æ¼", "ÆÐ¼Ç Çª¸£Æ®¸¦ µû¶æÇÑ Æ¼·Î Áñ±â´Â\r\n"
									+ "´ÞÄÞ »õÄÞÇÑ Á¶È­°¡ µ¸º¸ÀÌ´Â Æ¼·Î\r\n"
									+ "ÆÐ¼Ç Çª¸£Æ® ¾¾¾ÑÀ¸·Î ¾Ã´Â Àç¹Ì±îÁö ¼±»ç", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				T6.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				T6.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				T6.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				T6.setForeground(Color.GRAY);
			}
		});
		T6.setForeground(Color.WHITE);
		T6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		T6.setBounds(127, 683, 85, 15);
		contentPane.add(T6);
		
		JLabel lblNewLabel_4_4 = new JLabel("6,1   6,6   7,1");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4.setBounds(361, 248, 106, 27);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("6,1   6,6   7,1");
		lblNewLabel_4_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_1.setBounds(361, 285, 106, 27);
		contentPane.add(lblNewLabel_4_4_1);
		
		JLabel lblNewLabel_4_4_2 = new JLabel("6,1   6,6   7,1");
		lblNewLabel_4_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_2.setBounds(361, 322, 106, 27);
		contentPane.add(lblNewLabel_4_4_2);
		
		JLabel lblNewLabel_4_4_3 = new JLabel("5,9   6,4   6,9");
		lblNewLabel_4_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_4_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_3.setBounds(361, 360, 106, 27);
		contentPane.add(lblNewLabel_4_4_3);
		
		JLabel lblNewLabel_4_4_4 = new JLabel("Tall     Grande  Venti");
		lblNewLabel_4_4_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4.setBounds(361, 201, 138, 27);
		contentPane.add(lblNewLabel_4_4_4);
		
		JLabel lblNewLabel_4_4_4_1 = new JLabel("355 ml 473 ml  591 ml");
		lblNewLabel_4_4_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_4_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4_1.setBounds(361, 214, 138, 27);
		contentPane.add(lblNewLabel_4_4_4_1);
		
		JLabel lblNewLabel_4_4_4_2 = new JLabel("Tall     Grande  Venti");
		lblNewLabel_4_4_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_4_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4_2.setBounds(361, 439, 138, 27);
		contentPane.add(lblNewLabel_4_4_4_2);
		
		JLabel lblNewLabel_4_4_4_1_1 = new JLabel("355 ml 473 ml  591 ml");
		lblNewLabel_4_4_4_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_4_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4_1_1.setBounds(361, 452, 138, 27);
		contentPane.add(lblNewLabel_4_4_4_1_1);
		
		JLabel lblNewLabel_4_4_3_3 = new JLabel("5,3   5,8   6,3");
		lblNewLabel_4_4_3_3.setForeground(Color.WHITE);
		lblNewLabel_4_4_3_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_3_3.setBounds(361, 572, 106, 27);
		contentPane.add(lblNewLabel_4_4_3_3);
		
		JLabel lblNewLabel_4_4_2_1 = new JLabel("5,9   6,4   6,9");
		lblNewLabel_4_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_2_1.setBounds(361, 534, 106, 27);
		contentPane.add(lblNewLabel_4_4_2_1);
		
		JLabel lblNewLabel_4_4_1_1 = new JLabel("5,9   6,4   6,9");
		lblNewLabel_4_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_1_1.setBounds(361, 497, 106, 27);
		contentPane.add(lblNewLabel_4_4_1_1);
		
		JLabel Beans1 = new JLabel("\uC5D0\uC2A4\uD504\uB808\uC18C \uB85C\uC2A4\uD2B8");
		Beans1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("espresso_roast", espresso_roast, "¿¡½ºÇÁ·¹¼Ò ·Î½ºÆ®", "Ç³ºÎÇÏ°í Á¶È­·Î¿î ´À³¦À¸·Î ½ºÅ¸¹÷½º ¿¡½ºÇÁ·¹¼Ò À½·áÀÇ ±âº»ÀÌ µÇ´Â Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Beans1.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Beans1.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Beans1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Beans1.setForeground(Color.GRAY);
			}
		});
		Beans1.setForeground(Color.WHITE);
		Beans1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Beans1.setBounds(742, 226, 100, 15);
		contentPane.add(Beans1);
		
		JLabel lblNewLabel_5_4 = new JLabel("(Espresso Roast)");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4.setForeground(Color.WHITE);
		lblNewLabel_5_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_4.setBounds(742, 238, 106, 15);
		contentPane.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("(Guatemala Antigua)");
		lblNewLabel_5_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4_1.setForeground(Color.WHITE);
		lblNewLabel_5_4_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_4_1.setBounds(931, 238, 106, 15);
		contentPane.add(lblNewLabel_5_4_1);
		
		JLabel Beans2 = new JLabel("\uACFC\uD14C\uB9D0\uB77C \uC548\uD2F0\uAD6C\uC544");
		Beans2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("guatemala_antigua", guatemala_antigua, "°úÅ×¸»¶ó ¾ÈÆ¼±¸¾Æ", "¾Æ¸§´Ù¿î »ó»óÀ» ´õÇØÁÖ´Â ¿ì¾ÆÇÏ°í ±íÀº ¸ÀÀ» °¡Áø Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Beans2.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Beans2.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Beans2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Beans2.setForeground(Color.GRAY);
			}
		});
		Beans2.setForeground(Color.WHITE);
		Beans2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		Beans2.setBounds(931, 226, 100, 15);
		contentPane.add(Beans2);
		
		JLabel lblNewLabel_6_2 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_2.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_2.setBounds(709, 176, 372, 15);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_3.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_3.setBounds(127, 176, 372, 15);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_4.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_4.setBounds(127, 422, 372, 15);
		contentPane.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_4_5_2 = new JLabel("\uBB35\uC9C1\uD558\uACE0 \uAC15\uB825\uD55C \uD48D\uBBF8 Bold & Roasty");
		lblNewLabel_4_5_2.setForeground(Color.WHITE);
		lblNewLabel_4_5_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_4_5_2.setBounds(709, 251, 174, 15);
		contentPane.add(lblNewLabel_4_5_2);
		
		JLabel lblNewLabel_4_5_2_1 = new JLabel("\uBD80\uB4DC\uB7FD\uACE0 \uD48D\uBD80\uD55C \uD48D\uBBF8 Smooth & Rich");
		lblNewLabel_4_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_5_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_4_5_2_1.setBounds(897, 251, 174, 15);
		contentPane.add(lblNewLabel_4_5_2_1);
		
		JLabel CE1 = new JLabel("\uCEE4\uD53C");
		CE1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("coffee", coffee, "Ä¿ÇÇ", "±ò²ûÇÏ°í »óÅ­ÇÔÀÌ Æ¯Â¡ÀÎ Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE1.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE1.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE1.setForeground(Color.GRAY);
			}
		});
		CE1.setForeground(Color.WHITE);
		CE1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE1.setBounds(709, 294, 24, 15);
		contentPane.add(CE1);
		
		JLabel lblNewLabel_5_5 = new JLabel("coffee");
		lblNewLabel_5_5.setForeground(Color.WHITE);
		lblNewLabel_5_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5.setBounds(709, 306, 174, 15);
		contentPane.add(lblNewLabel_5_5);
		
		JLabel CE2 = new JLabel("\uC624\uB298\uC758 \uCEE4\uD53C");
		CE2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("brewed_coffee", brewed_coffee, "¿À´ÃÀÇ Ä¿ÇÇ", "½Å¼±ÇÏ°Ô ºê·çµå(Brewed)µÇ¾î ¿øµÎÀÇ ´Ù¾çÇÔÀÌ »ì¾ÆÀÖ´Â Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE2.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE2.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE2.setForeground(Color.GRAY);
			}
		});
		CE2.setForeground(Color.WHITE);
		CE2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE2.setBounds(709, 331, 68, 15);
		contentPane.add(CE2);
		
		JLabel lblNewLabel_5_5_1 = new JLabel("Brewed Coffe");
		lblNewLabel_5_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_5_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_1.setBounds(709, 343, 174, 15);
		contentPane.add(lblNewLabel_5_5_1);
		
		JLabel CE3 = new JLabel("\uCE74\uB77C\uBA5C \uB9C8\uD0A4\uC544\uB610");
		CE3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("caramel_macchiato", caramel_macchiato, "Ä«¶ó¸á ¸¶Å°¾Æ¶Ç", "Çâ±ßÇÑ ¹Ù´Ò¶ó ½Ã·´°ú µû¶æÇÑ ½ºÆÀ ¹ÐÅ© À§¿¡ Ç³¼ºÇÑ ¿ìÀ¯ °ÅÇ°À» ¾ñ°í Á¡À» ÂïµíÀÌ ¿¡½ºÇÁ·¹¼Ò¸¦ ºÎÀº ÈÄ ¹úÁý ¸ð¾çÀ¸·Î Ä«¶ó¸á µå¸®ÁñÀ» ¿Ã¸° ´ÞÄÞÇÑ Ä¿ÇÇ À½·á", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE3.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE3.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE3.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE3.setForeground(Color.GRAY);
			}
		});
		CE3.setForeground(Color.WHITE);
		CE3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE3.setBounds(709, 384, 88, 15);
		contentPane.add(CE3);
		
		JLabel lblNewLabel_5_5_2 = new JLabel("Caramel Macchiato");
		lblNewLabel_5_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_5_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2.setBounds(709, 396, 174, 15);
		contentPane.add(lblNewLabel_5_5_2);
		
		JLabel lblNewLabel_6_5 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_5.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_5.setBounds(709, 361, 372, 15);
		contentPane.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_5_5_2_1 = new JLabel("Caffe Latte");
		lblNewLabel_5_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_5_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2_1.setBounds(709, 430, 174, 15);
		contentPane.add(lblNewLabel_5_5_2_1);
		
		JLabel CE4 = new JLabel("\uCE74\uD398 \uB77C\uB5BC");
		CE4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("caffe_latte", caffe_latte, "Ä«Æä ¶ó¶¼", "Ç³ºÎÇÏ°í ÁøÇÑ ¿¡½ºÇÁ·¹¼Ò°¡ ½Å¼±ÇÑ ½ºÆÀ ¹ÐÅ©¸¦ ¸¸³ª ºÎµå·¯¿öÁø Ä¿ÇÇ À§¿¡ ¿ìÀ¯ °ÅÇ°À» »ìÂ¦ ¾ñÀº ´ëÇ¥ÀûÀÎ Ä¿ÇÇ ¶ó¶¼", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE4.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE4.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE4.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE4.setForeground(Color.GRAY);
			}
		});
		CE4.setForeground(Color.WHITE);
		CE4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE4.setBounds(709, 418, 52, 15);
		contentPane.add(CE4);
		
		JLabel lblNewLabel_5_5_2_1_1 = new JLabel("Caffe Americano");
		lblNewLabel_5_5_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_5_2_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2_1_1.setBounds(709, 463, 174, 15);
		contentPane.add(lblNewLabel_5_5_2_1_1);
		
		JLabel CE5 = new JLabel("\uCE74\uD398 \uC544\uBA54\uB9AC\uCE74\uB178");
		CE5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("caffe_americano", caffe_americano, "Ä«Æä ¾Æ¸Þ¸®Ä«³ë", "ÁøÇÑ ¿¡½ºÇÁ·¹¼Ò¿Í ¶ß°Å¿î ¹°À» ¼¯¾î ½ºÅ¸¹÷½ºÀÇ ±ò²ûÇÏ°í °­·ÄÇÑ ¿¡½ºÇÁ·¹¼Ò¸¦ °¡Àå ºÎµå·´°Ô Àß ´À³¥ ¼ö ÀÖ´Â Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE5.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE5.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE5.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE5.setForeground(Color.GRAY);
			}
		});
		CE5.setForeground(Color.WHITE);
		CE5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE5.setBounds(709, 451, 88, 15);
		contentPane.add(CE5);
		
		JLabel lblNewLabel_6_5_1 = new JLabel("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_6_5_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_6_5_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6_5_1.setBounds(708, 513, 372, 15);
		contentPane.add(lblNewLabel_6_5_1);
		
		JLabel lblNewLabel_5_5_2_1_2 = new JLabel("Cold Brew");
		lblNewLabel_5_5_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_5_5_2_1_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2_1_2.setBounds(708, 545, 174, 15);
		contentPane.add(lblNewLabel_5_5_2_1_2);
		
		JLabel CE7 = new JLabel("\uCF5C\uB4DC \uBE0C\uB8E8");
		CE7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("cold_brew", cold_brew, "ÄÝµå ºê·ç", "½ºÅ¸¹÷½º ¹Ù¸®½ºÅ¸ÀÇ Á¤¼ºÀ¸·Î Åº»ýÇÑ ÄÝµå ºê·ç!\r\n"
									+ "\r\n"
									+ "ÄÝµå ºê·ç Àü¿ë ¿øµÎ¸¦ Â÷°¡¿î ¹°·Î 14½Ã°£ µ¿¾È ÃßÃâÇÏ¿© ÇÑÁ¤µÈ ¾ç¸¸ Á¦°øµË´Ï´Ù.\r\n"
									+ "±íÀº Ç³¹ÌÀÇ »õ·Î¿î Ä¿ÇÇ °æÇèÀ» Áñ°Üº¸¼¼¿ä.", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE7.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE7.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE7.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE7.setForeground(Color.GRAY);
			}
		});
		CE7.setForeground(Color.WHITE);
		CE7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE7.setBounds(708, 533, 52, 15);
		contentPane.add(CE7);
		
		JLabel lblNewLabel_5_5_2_1_2_1 = new JLabel("Dolce Cold Brew");
		lblNewLabel_5_5_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_5_2_1_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2_1_2_1.setBounds(708, 582, 174, 15);
		contentPane.add(lblNewLabel_5_5_2_1_2_1);
		
		JLabel CE8 = new JLabel("\uB3CC\uCCB4 \uCF5C\uB4DC \uBE0C\uB8E8");
		CE8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("dolce_cold_brew", dolce_cold_brew, "µ¹Ã¼ ÄÝµå ºê·ç", "¹«´õ¿î ¿©¸§Ã¶,\r\n"
									+ "µ¿³²¾Æ ÈÞ°¡Áö¿¡¼­ Áñ±â´Â Ä¿ÇÇ¸¦ ¶°¿À¸£°Ô ÇÏ´Â\r\n"
									+ "½ºÅ¸¹÷½º À½·áÀÇ º£½ºÆ® x º£½ºÆ® Á¶ÇÕÀÎ\r\n"
									+ "µ¹Ã¼ ÄÝµå ºê·ç¸¦ ¸¸³ªº¸¼¼¿ä!", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE8.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE8.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE8.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE8.setForeground(Color.GRAY);
			}
		});
		CE8.setForeground(Color.WHITE);
		CE8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE8.setBounds(708, 570, 85, 15);
		contentPane.add(CE8);
		
		JLabel lblNewLabel_4_4_4_3 = new JLabel("Tall     Grande  Venti");
		lblNewLabel_4_4_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_4_4_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4_3.setBounds(942, 263, 138, 27);
		contentPane.add(lblNewLabel_4_4_4_3);
		
		JLabel lblNewLabel_4_4_4_1_2 = new JLabel("355 ml 473 ml  591 ml");
		lblNewLabel_4_4_4_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_4_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_4_1_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_4_4_4_1_2.setBounds(942, 276, 138, 27);
		contentPane.add(lblNewLabel_4_4_4_1_2);
		
		JLabel lblNewLabel_4_4_5 = new JLabel("5,8   6,3   6,8");
		lblNewLabel_4_4_5.setForeground(Color.WHITE);
		lblNewLabel_4_4_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5.setBounds(942, 296, 106, 27);
		contentPane.add(lblNewLabel_4_4_5);
		
		JLabel lblNewLabel_4_4_5_2 = new JLabel("5,8   6,3   6,8");
		lblNewLabel_4_4_5_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_2.setBounds(942, 381, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_2);
		
		JLabel lblNewLabel_4_4_5_3 = new JLabel("4,6   5,1   5,6");
		lblNewLabel_4_4_5_3.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_3.setBounds(942, 420, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_3);
		
		JLabel lblNewLabel_4_4_5_4 = new JLabel("4,1   4,6   5,1");
		lblNewLabel_4_4_5_4.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_4.setBounds(942, 453, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_4);
		
		JLabel lblNewLabel_4_4_5_5 = new JLabel("3,8   4,3   4,8");
		lblNewLabel_4_4_5_5.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_5.setBounds(941, 536, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_5);
		
		JLabel lblId = new JLabel("");
		lblId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setBounds(127, 42, 75, 15);
		lblId.setText(id);
		contentPane.add(lblId);
		
		JLabel lblIdMessage = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblIdMessage.setForeground(new Color(255, 255, 255));
		lblIdMessage.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblIdMessage.setBounds(203, 42, 79, 15);
		contentPane.add(lblIdMessage);
		
		JLabel lblPoint = new JLabel("New label");
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblPoint.setBounds(374, 42, 166, 15);
		lblPoint.setText(String.format("%d¿ø ÀÔ´Ï´Ù.", lp.point(id)));
		contentPane.add(lblPoint);
		
		JLabel lblPointMessage = new JLabel("\uC794\uC5EC \uD3EC\uC778\uD2B8 : ");
		lblPointMessage.setForeground(Color.WHITE);
		lblPointMessage.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblPointMessage.setBounds(296, 42, 75, 15);
		contentPane.add(lblPointMessage);
		
		JLabel lblOrder = new JLabel("\uC8FC\uBB38\uD558\uAE30");
		lblOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (new GetTotalPrice().totalPrice() == 0) {
					JOptionPane.showMessageDialog(null, "¼±ÅÃµÈ ¸Þ´º°¡ ¾ø½À´Ï´Ù.");
				} else {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								OrderFrame frame = new OrderFrame(id);
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
				lblOrder.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblOrder.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblOrder.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblOrder.setForeground(Color.GRAY);
			}
		});
		lblOrder.setForeground(new Color(255, 255, 255));
		lblOrder.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		lblOrder.setBounds(1001, 42, 79, 27);
		contentPane.add(lblOrder);
		
		
		
		JLabel lblNewLabel_5_3_1_3_1 = new JLabel("Chamomile Blend Brewed Tea");
		lblNewLabel_5_3_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_3_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_3_1.setBounds(127, 621, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_3_1);
		
		JLabel lblNewLabel_4_4_3_3_1 = new JLabel("5,3   5,8   6,3");
		lblNewLabel_4_4_3_3_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_3_3_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_3_3_1.setBounds(361, 609, 106, 27);
		contentPane.add(lblNewLabel_4_4_3_3_1);
		
		JLabel lblNewLabel_5_3_1_3_2 = new JLabel("Hibiscus Blend Brewed Tea");
		lblNewLabel_5_3_1_3_2.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_3_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_3_2.setBounds(127, 658, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_3_2);
		
		JLabel lblNewLabel_4_4_3_3_2 = new JLabel("5,3   5,8   6,3");
		lblNewLabel_4_4_3_3_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_3_3_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_3_3_2.setBounds(361, 646, 106, 27);
		contentPane.add(lblNewLabel_4_4_3_3_2);
		
		JLabel lblNewLabel_5_3_1_3_3 = new JLabel("Passion Fruit Tea");
		lblNewLabel_5_3_1_3_3.setForeground(Color.WHITE);
		lblNewLabel_5_3_1_3_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_3_1_3_3.setBounds(127, 695, 174, 15);
		contentPane.add(lblNewLabel_5_3_1_3_3);
		
		JLabel lblNewLabel_4_4_3_3_3 = new JLabel("5,3   5,8   6,3");
		lblNewLabel_4_4_3_3_3.setForeground(Color.WHITE);
		lblNewLabel_4_4_3_3_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_3_3_3.setBounds(361, 683, 106, 27);
		contentPane.add(lblNewLabel_4_4_3_3_3);
		
		JLabel lblNewLabel_4_4_5_5_1 = new JLabel("3,8   4,3   4,8");
		lblNewLabel_4_4_5_5_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_5_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_5_1.setBounds(942, 334, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_5_1);
		
		JLabel lblNewLabel_4_4_5_5_2 = new JLabel("3,8   4,3   4,8");
		lblNewLabel_4_4_5_5_2.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_5_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_5_2.setBounds(941, 572, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_5_2);
		
		JLabel lblNewLabel_5_5_2_1_1_1 = new JLabel("Caffe Mocha");
		lblNewLabel_5_5_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_5_2_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		lblNewLabel_5_5_2_1_1_1.setBounds(709, 496, 174, 15);
		contentPane.add(lblNewLabel_5_5_2_1_1_1);
		
		JLabel CE6 = new JLabel("\uCE74\uD398 \uBAA8\uCE74");
		CE6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManualFrame frame = new ManualFrame("caffe_mocha", caffe_mocha, "Ä«Æä ¸ðÄ«", "ÁøÇÑ ÃÊÄÝ¸´ ¸ðÄ« ½Ã·´°ú Ç³ºÎÇÑ ¿¡½ºÇÁ·¹¼Ò¸¦ ½ºÆÀ ¹ÐÅ©¿Í ¼¯¾î ÈÖÇÎÅ©¸²À¸·Î ¸¶¹«¸®ÇÑ À½·á·Î ÁøÇÑ ¿¡½ºÇÁ·¹¼Ò¿Í ÃÊÄÝ¸´ ¸ÀÀÌ ¾î¿ì·¯Áø Ä¿ÇÇ", id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CE6.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CE6.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				CE6.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				CE6.setForeground(Color.GRAY);
			}
		});
		CE6.setForeground(Color.WHITE);
		CE6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		CE6.setBounds(709, 484, 52, 15);
		contentPane.add(CE6);
		
		JLabel lblNewLabel_4_4_5_4_1 = new JLabel("4,1   4,6   5,1");
		lblNewLabel_4_4_5_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_5_4_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblNewLabel_4_4_5_4_1.setBounds(942, 486, 106, 27);
		contentPane.add(lblNewLabel_4_4_5_4_1);
		
		JLabel lblTotalPriceMessage = new JLabel("\uCD1D \uAE08\uC561 : ");
		lblTotalPriceMessage.setForeground(Color.WHITE);
		lblTotalPriceMessage.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblTotalPriceMessage.setBounds(712, 42, 52, 15);
		contentPane.add(lblTotalPriceMessage);
		
		JLabel lblTotalPrice = new JLabel("0\uC6D0");
		lblTotalPrice.setForeground(Color.WHITE);
		lblTotalPrice.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblTotalPrice.setBounds(762, 42, 152, 15);
		lblTotalPrice.setText(String.format("%d¿ø ÀÔ´Ï´Ù.", new GetTotalPrice().totalPrice()));
		contentPane.add(lblTotalPrice);
		
		JLabel lblRefresh = new JLabel();
		lblRefresh.setText("\uC0C8\uB85C\uACE0\uCE68");
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTotalPrice.setText(String.format("%d¿ø ÀÔ´Ï´Ù.", new GetTotalPrice().totalPrice()));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRefresh.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRefresh.setForeground(Color.WHITE);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblRefresh.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblRefresh.setForeground(Color.GRAY);
			}
		});
		lblRefresh.setForeground(Color.WHITE);
		lblRefresh.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblRefresh.setBounds(914, 42, 48, 15);
		contentPane.add(lblRefresh);
	}
}
