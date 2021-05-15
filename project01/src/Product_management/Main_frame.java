package Product_management;

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
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main_frame extends JFrame {

	private Image search_icon1 = new ImageIcon(Main_frame.class.getResource("res/search_icon1.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	private Image search_icon2 = new ImageIcon(Main_frame.class.getResource("res/search_icon2.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField search_textField;
	private JTextField AddP_name;
	private JTextField AddC_price;
	private JTextField AddManufacturer;
	private JTextField AddN_info;
	private JTextField DP_name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main_frame() {
		// 메인 프레임 실행 시마다 테이블 생성, 상품정보 자동 관리 기능이 실행되게 구현
		// 추가적인 기능으로 상품명 입력 시 상품 이미지와 정보가 출력되는 기능 구현
		new Create_tables();
		new Outo_management();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 150, 1200, 800
				);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 기존 최소화, 확대, 닫기 창을 없애고 심플하게 닫기 버튼만 만들어 넣어놈
		JLabel lblX = new 
				JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "어플리케이션을 종료하시겠습니까?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Main_frame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.DARK_GRAY);
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
				lblX.setForeground(Color.DARK_GRAY);
			}
			
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(1180, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblMainLabel = new JLabel("\uC0C1\uD488\uAD00\uB9AC");
		lblMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
		lblMainLabel.setForeground(Color.WHITE);
		lblMainLabel.setBounds(12, 10, 1176, 107);
		contentPane.add(lblMainLabel);
		
		JLabel lblSearchProduct = new JLabel("\uC0C1\uD488 \uAC80\uC0C9");
		lblSearchProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchProduct.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblSearchProduct.setForeground(Color.WHITE);
		lblSearchProduct.setBounds(113, 164, 131, 42);
		contentPane.add(lblSearchProduct);
		
		JLabel lblProduct_imageLabel = new JLabel("");
		lblProduct_imageLabel.setBounds(171, 223, 224, 267);
		contentPane.add(lblProduct_imageLabel);
		
		JLabel lblProduct_nameResult = new JLabel("");
		lblProduct_nameResult.setForeground(Color.WHITE);
		lblProduct_nameResult.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblProduct_nameResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduct_nameResult.setBounds(98, 510, 379, 48);
		contentPane.add(lblProduct_nameResult);
		
		JLabel lblCommodity_priceResult = new JLabel("");
		lblCommodity_priceResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblCommodity_priceResult.setForeground(Color.WHITE);
		lblCommodity_priceResult.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblCommodity_priceResult.setBounds(98, 580, 379, 48);
		contentPane.add(lblCommodity_priceResult);
		
		JLabel lblManufacturerResult = new JLabel("");
		lblManufacturerResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblManufacturerResult.setForeground(Color.WHITE);
		lblManufacturerResult.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblManufacturerResult.setBounds(98, 650, 379, 48);
		contentPane.add(lblManufacturerResult);
		
		JLabel lblNutrition_informationResult = new JLabel("");
		lblNutrition_informationResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblNutrition_informationResult.setForeground(Color.WHITE);
		lblNutrition_informationResult.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNutrition_informationResult.setBounds(98, 720, 379, 48);
		contentPane.add(lblNutrition_informationResult);
		
		// 검색버튼 클릭이 아닌 enter키 입력으로도 사용 가능하게 ketPressed추가
		search_textField = new JTextField();
		search_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					String product_name = search_textField.getText();
					if (product_name.equals("")) {
						// 상품명 미 입력 시 출력되는 메세지 (엔터키)
						lblProduct_nameResult.setText("상품명을 입력해주세요.");
					} else if(new Search_with_product_name().product_name(product_name).equals("")) {
						// 상품명 잘못 입력 시 출력되는 메세지 (엔터키)
						lblProduct_nameResult.setText("존재하지 않는 상품명입니다.");
					} else {
						// 상품명이 제대로 입력되었을 시 출력되는 메세지와 이미지 (엔터키)
						lblProduct_imageLabel.setIcon(new ImageIcon(new ImageIcon(Main_frame.class.getResource("res/" + product_name + ".jpg")).getImage().getScaledInstance(224, 267, Image.SCALE_SMOOTH)));
						lblProduct_nameResult.setText(new Search_with_product_name().product_name(product_name));
						lblCommodity_priceResult.setText(new Search_with_product_name().commodity_price(product_name));
						lblManufacturerResult.setText(new Search_with_product_name().manufacturer(product_name));
						lblNutrition_informationResult.setText(new Search_with_product_name().nutrition_information(product_name));
					}
					search_textField.setText("");
				} 
				
			}
		});
		search_textField.setBounds(256, 171, 161, 32);
		contentPane.add(search_textField);
		search_textField.setColumns(10);
		
		// 검색버튼 클릭 시 발동되는 액션 리스너 추가
		JLabel lblSearchLabel = new JLabel("");
		lblSearchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String product_name = search_textField.getText();
				// 상품명 미 입력 시 출력되는 메세지 (검색버튼)
				if (product_name.equals("")) {
					// 상품명 미 입력 시 출력되는 메세지 (엔터키)
					lblProduct_nameResult.setText("상품명을 입력해주세요.");
				} else if(new Search_with_product_name().product_name(product_name).equals("")) {
					// 상품명 잘못 입력 시 출력되는 메세지 (엔터키)
					lblProduct_nameResult.setText("존재하지 않는 상품명입니다.");
				} else {
					// 상품명이 제대로 입력되었을 시 출력되는 메세지와 이미지 (엔터키)
					lblProduct_imageLabel.setIcon(new ImageIcon(new ImageIcon(Main_frame.class.getResource("res/" + product_name + ".jpg")).getImage().getScaledInstance(224, 267, Image.SCALE_SMOOTH)));
					lblProduct_nameResult.setText(new Search_with_product_name().product_name(product_name));
					lblCommodity_priceResult.setText(new Search_with_product_name().commodity_price(product_name));
					lblManufacturerResult.setText(new Search_with_product_name().manufacturer(product_name));
					lblNutrition_informationResult.setText(new Search_with_product_name().nutrition_information(product_name));
				}
				search_textField.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
				lblSearchLabel.setIcon(new ImageIcon(search_icon2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
				lblSearchLabel.setIcon(new ImageIcon(search_icon1));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblSearchLabel.setIcon(new ImageIcon(search_icon1));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblSearchLabel.setIcon(new ImageIcon(search_icon2));
			}
		});
		lblSearchLabel.setBounds(416, 171, 32, 32);
		contentPane.add(lblSearchLabel);
		lblSearchLabel.setIcon(new ImageIcon(search_icon1));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(590, 127, 10, 673);
		contentPane.add(panel);
		
		JLabel lblAddProduct = new JLabel("\uC0C1\uD488 \uCD94\uAC00");
		lblAddProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddProduct.setForeground(Color.WHITE);
		lblAddProduct.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblAddProduct.setBounds(844, 164, 131, 42);
		contentPane.add(lblAddProduct);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setBounds(0, 123, 1200, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(0, 0, 1200, 125);
		contentPane.add(panel_2);
		
		JLabel lblDeleteProduct = new JLabel("\uC0C1\uD488 \uC0AD\uC81C");
		lblDeleteProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeleteProduct.setForeground(Color.WHITE);
		lblDeleteProduct.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblDeleteProduct.setBounds(844, 532, 131, 42);
		contentPane.add(lblDeleteProduct);
		
		JLabel lblAddPName = new JLabel("\uC0C1\uD488\uBA85");
		lblAddPName.setForeground(new Color(255, 255, 255));
		lblAddPName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddPName.setBounds(723, 234, 60, 32);
		contentPane.add(lblAddPName);
		
		JLabel lblAddC_price = new JLabel("\uC0C1\uD488\uAC00\uACA9");
		lblAddC_price.setForeground(Color.WHITE);
		lblAddC_price.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddC_price.setBounds(723, 294, 86, 32);
		contentPane.add(lblAddC_price);
		
		JLabel lblAddManufacturer = new JLabel("\uC81C\uC870\uC0AC");
		lblAddManufacturer.setForeground(Color.WHITE);
		lblAddManufacturer.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddManufacturer.setBounds(723, 354, 60, 32);
		contentPane.add(lblAddManufacturer);
		
		JLabel lblAddN_info = new JLabel("\uC601\uC591\uC815\uBCF4");
		lblAddN_info.setForeground(Color.WHITE);
		lblAddN_info.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAddN_info.setBounds(723, 414, 86, 32);
		contentPane.add(lblAddN_info);
		
		AddP_name = new JTextField();
		AddP_name.setBounds(821, 241, 216, 21);
		contentPane.add(AddP_name);
		AddP_name.setColumns(10);
		
		AddC_price = new JTextField();
		AddC_price.setColumns(10);
		AddC_price.setBounds(821, 301, 216, 21);
		contentPane.add(AddC_price);
		
		AddManufacturer = new JTextField();
		AddManufacturer.setColumns(10);
		AddManufacturer.setBounds(821, 360, 216, 21);
		contentPane.add(AddManufacturer);
		
		AddN_info = new JTextField();
		AddN_info.setColumns(10);
		AddN_info.setBounds(821, 420, 216, 21);
		contentPane.add(AddN_info);
		
		JLabel lblAddBtn = new JLabel("\uCD94\uAC00");
		lblAddBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new Add_product().Add(AddP_name.getText(), Integer.parseInt(AddC_price.getText()), AddManufacturer.getText(), AddN_info.getText()).equals("s")) {
					// 새로 sus_01에 정보가 추가되었기때문에 자동화 작업 필요
					new Outo_management();
					// 상품 추가에 성공
					JOptionPane.showMessageDialog(null, "[" + AddP_name.getText() + "] 상품을 성공적으로 추가했습니다.");
				} else {
					// 상품 추가에 실패
					JOptionPane.showMessageDialog(null, "[" + AddP_name.getText() + "] 상품 추가에 실패했습니다.");
				}
				AddP_name.setText("");
				AddC_price.setText("");
				AddManufacturer.setText("");
				AddN_info.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
				lblAddBtn.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
				lblAddBtn.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblAddBtn.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAddBtn.setForeground(Color.DARK_GRAY);
			}
		});
		lblAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblAddBtn.setForeground(new Color(255, 255, 255));
		lblAddBtn.setBounds(887, 458, 50, 32);
		contentPane.add(lblAddBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(601, 512, 599, 10);
		contentPane.add(panel_3);
		
		JLabel lblD_p_name = new JLabel("\uC0C1\uD488\uBA85");
		lblD_p_name.setForeground(Color.WHITE);
		lblD_p_name.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblD_p_name.setBounds(723, 596, 60, 32);
		contentPane.add(lblD_p_name);
		
		DP_name = new JTextField();
		DP_name.setColumns(10);
		DP_name.setBounds(821, 603, 216, 21);
		contentPane.add(DP_name);
		
		JLabel lblDeleteBtn = new JLabel("\uC0AD\uC81C");
		lblDeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new Delete_product().Delete(DP_name.getText()).equals("s")) {
					// 새로 sus_01에 정보가 삭제되었기때문에 자동화 작업 필요
					new Outo_management();
					// 상품 삭제에 성공
					JOptionPane.showMessageDialog(null, "[" + DP_name.getText() + "] 상품을 성공적으로 삭제했습니다.");
				} else {
					// 상품 삭제에 실패
					JOptionPane.showMessageDialog(null, "[" + DP_name.getText() + "] 상품 추가에 실패했습니다.");
				}
				DP_name.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
				lblDeleteBtn.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
				lblDeleteBtn.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblDeleteBtn.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblDeleteBtn.setForeground(Color.DARK_GRAY);
			}
		});
		lblDeleteBtn.setForeground(Color.WHITE);
		lblDeleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblDeleteBtn.setBounds(887, 709, 50, 32);
		contentPane.add(lblDeleteBtn);
	}
}
