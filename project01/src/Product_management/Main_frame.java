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
		// ���� ������ ���� �ø��� ���̺� ����, ��ǰ���� �ڵ� ���� ����� ����ǰ� ����
		// �߰����� ������� ��ǰ�� �Է� �� ��ǰ �̹����� ������ ��µǴ� ��� ����
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
		
		// ���� �ּ�ȭ, Ȯ��, �ݱ� â�� ���ְ� �����ϰ� �ݱ� ��ư�� ����� �־��
		JLabel lblX = new 
				JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "���ø����̼��� �����Ͻðڽ��ϱ�?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
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
		lblMainLabel.setFont(new Font("���� ���", Font.BOLD, 45));
		lblMainLabel.setForeground(Color.WHITE);
		lblMainLabel.setBounds(12, 10, 1176, 107);
		contentPane.add(lblMainLabel);
		
		JLabel lblSearchProduct = new JLabel("\uC0C1\uD488 \uAC80\uC0C9");
		lblSearchProduct.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchProduct.setFont(new Font("���� ���", Font.BOLD, 30));
		lblSearchProduct.setForeground(Color.WHITE);
		lblSearchProduct.setBounds(195, 166, 131, 42);
		contentPane.add(lblSearchProduct);
		
		JLabel lblProduct_imageLabel = new JLabel("");
		lblProduct_imageLabel.setBounds(498, 286, 224, 267);
		contentPane.add(lblProduct_imageLabel);
		
		JLabel lblSearchResult = new JLabel("");
		lblSearchResult.setForeground(Color.WHITE);
		lblSearchResult.setFont(new Font("���� ���", Font.PLAIN, 14));
		lblSearchResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchResult.setBounds(195, 626, 841, 48);
		contentPane.add(lblSearchResult);
		
		// �˻���ư Ŭ���� �ƴ� enterŰ �Է����ε� ��� �����ϰ� ketPressed�߰�
		search_textField = new JTextField();
		search_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					String product_name = search_textField.getText();
					if (product_name.equals("")) {
						// ��ǰ�� �� �Է� �� ��µǴ� �޼��� (����Ű)
						lblSearchResult.setText("��ǰ���� �Է����ּ���.");
					} else if(new Search_with_product_name().info(product_name).equals("")) {
						// ��ǰ�� �߸� �Է� �� ��µǴ� �޼��� (����Ű)
						lblSearchResult.setText("�������� �ʴ� ��ǰ���Դϴ�.");
					} else {
						// ��ǰ���� ����� �ԷµǾ��� �� ��µǴ� �޼����� �̹��� (����Ű)
						lblProduct_imageLabel.setIcon(new ImageIcon(new ImageIcon(Main_frame.class.getResource("res/" + product_name + ".jpg")).getImage().getScaledInstance(224, 267, Image.SCALE_SMOOTH)));
						lblSearchResult.setText(new Search_with_product_name().info(product_name));
					}
				}
			}
		});
		search_textField.setBounds(338, 173, 161, 32);
		contentPane.add(search_textField);
		search_textField.setColumns(10);
		
		// �˻���ư Ŭ�� �� �ߵ��Ǵ� �׼� ������ �߰�
		JLabel lblSearchLabel = new JLabel("");
		lblSearchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String product_name = search_textField.getText();
				// ��ǰ�� �� �Է� �� ��µǴ� �޼��� (�˻���ư)
				if (product_name.equals("")) {
					lblSearchResult.setText("��ǰ���� �Է����ּ���.");
				} else if(new Search_with_product_name().info(product_name).equals("")) {
					// ��ǰ�� �߸� �Է� �� ��µǴ� �޼��� (����Ű)
					lblSearchResult.setText("�������� �ʴ� ��ǰ���Դϴ�.");
				} else {
					// ��ǰ���� ����� �ԷµǾ��� �� ��µǴ� �޼����� �̹��� (�˻���ư)
					lblProduct_imageLabel.setIcon(new ImageIcon(new ImageIcon(Main_frame.class.getResource("res/" + product_name + ".jpg")).getImage().getScaledInstance(224, 267, Image.SCALE_SMOOTH)));
					lblSearchResult.setText(new Search_with_product_name().info(product_name));
				}
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
		lblSearchLabel.setBounds(498, 173, 32, 32);
		contentPane.add(lblSearchLabel);
		lblSearchLabel.setIcon(new ImageIcon(search_icon1));
	}
}
