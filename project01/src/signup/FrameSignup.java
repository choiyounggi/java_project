package signup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import login.Encryption;
import login.FrameLogin;
import main.ManualFrame;
import main.OrderFrame;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class FrameSignup extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField recommender;
	
	int overlapIdResult = 0;
	int correctPwd = 0;
	int correctRId = 0;

	private JLabel lblPwdMessage = new JLabel("");
	private JPasswordField pwd;
	private JPasswordField pwd2;

	public FrameSignup() {
		
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
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setBounds(130, 23, 69, 25);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(110, 72, 107, 25);
		id.setColumns(10);
		panel.add(id);
		
		pwd = new JPasswordField();
		pwd.setEchoChar('*');
		pwd.setBounds(110, 124, 107, 23);
		panel.add(pwd);
		
		pwd2 = new JPasswordField();
		pwd2.setEchoChar('*');
		pwd2.setBounds(110, 217, 107, 23);
		panel.add(pwd2);
		
		recommender = new JTextField();
		recommender.setBounds(110, 275, 107, 25);
		recommender.setColumns(10);
		panel.add(recommender);
		
		JLabel lblNewLabel_1 = new JLabel("* \uC544\uC774\uB514");
		lblNewLabel_1.setBounds(41, 72, 57, 25);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1.setBounds(12, 124, 86, 25);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("* \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_1_2.setBounds(12, 215, 86, 25);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("* \uCD94\uCC9C\uC778 ID");
		lblNewLabel_1_3.setBounds(12, 275, 86, 25);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblCheckIdMessage = new JLabel("");
		lblCheckIdMessage.setForeground(new Color(0, 0, 0));
		lblCheckIdMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblCheckIdMessage.setBounds(110, 103, 169, 15);
		panel.add(lblCheckIdMessage);
		
		JLabel lblCheckPwdMessage = new JLabel("");
		lblCheckPwdMessage.setForeground(Color.BLACK);
		lblCheckPwdMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblCheckPwdMessage.setBounds(110, 250, 202, 15);
		panel.add(lblCheckPwdMessage);
		
		JLabel lblCheckRIdMessage = new JLabel("");
		lblCheckRIdMessage.setForeground(Color.BLACK);
		lblCheckRIdMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblCheckRIdMessage.setBounds(110, 310, 169, 15);
		panel.add(lblCheckRIdMessage);
		
		JPanel checkOverlap = new JPanel();
		checkOverlap.setBackground(Color.LIGHT_GRAY);
		checkOverlap.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckOverlapId check = new CheckOverlapId();

				if (check.checkOverlap(id.getText()) == null) {
					lblCheckIdMessage.setForeground(new Color(0, 0, 0));
					lblCheckIdMessage.setText("사용 가능한 아이디 입니다.");
					overlapIdResult = 1;
				}
				
				if (id.getText().equals("")) {
					lblCheckIdMessage.setForeground(Color.RED);
					lblCheckIdMessage.setText("아이디를 입력해주세요.");
					overlapIdResult = 0;
				} else if (check.checkOverlap(id.getText()).equals(id.getText())) {
					lblCheckIdMessage.setForeground(Color.RED);
					lblCheckIdMessage.setText("중복된 아이디입니다.");
					overlapIdResult = 0;
				} 
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				checkOverlap.setBackground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkOverlap.setBackground(Color.LIGHT_GRAY);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				checkOverlap.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				checkOverlap.setBackground(Color.GRAY);
			}
		});
		checkOverlap.setBounds(224, 72, 55, 25);
		panel.add(checkOverlap);
		
		JLabel lblNewLabel_2 = new JLabel("\uC911\uBCF5\uD655\uC778");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		checkOverlap.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("굴림", Font.PLAIN, 11));
		textPane.setText("\uBE44\uBC00\uBC88\uD638\uB294 6\uC790\uB9AC \uC774\uC0C1\uC774\uC5B4\uC57C\uD558\uBA70 \uC601\uBB38\uACFC \uC22B\uC790\uB97C \uBC18\uB4DC\uC2DC \uD3EC\uD568\uD574\uC57C \uD569\uB2C8\uB2E4.");
		textPane.setBounds(106, 147, 169, 60);
		panel.add(textPane);
		
		lblPwdMessage.setForeground(Color.BLACK);
		lblPwdMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblPwdMessage.setBounds(110, 254, 169, 15);
		panel.add(lblPwdMessage);
		
		JPanel signupComplete = new JPanel();
		signupComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckContain check = new CheckContain();
				if (pwd.getText().length() < 6) {
					lblCheckPwdMessage.setForeground(Color.RED);
					lblCheckPwdMessage.setText("6자리 이상이어야합니다.");
					correctPwd = 0;
				} else if (check.CheckContainAlpha(pwd.getText()) == 0 || check.CheckContainNum(pwd.getText()) == 0) {
					lblCheckPwdMessage.setForeground(Color.RED);
					lblCheckPwdMessage.setText("영문과 숫자를 반드시 포함해야합니다.");
					correctPwd = 0;
				}
				
				if (pwd.getText().equals("")) {
					lblCheckPwdMessage.setForeground(Color.RED);
					lblCheckPwdMessage.setText("원하시는 비밀번호를 입력해주세요.");
					correctPwd = 0;
				} else if (pwd2.getText().equals("")) {
					lblCheckPwdMessage.setForeground(Color.RED);
					lblCheckPwdMessage.setText("비밀번호 확인을 입력해주세요.");
					correctPwd = 0;
				} else if (!pwd.getText().equals(pwd2.getText())) {
					lblCheckPwdMessage.setForeground(Color.RED);
					lblCheckPwdMessage.setText("비밀번호가 일치하지 않습니다.");
					correctPwd = 0;
				}
				
				if (
						pwd.getText().length() >= 6 && 
						((check.CheckContainAlpha(pwd.getText()) + check.CheckContainNum(pwd.getText())) == 2) &&
						!pwd.getText().equals("") &&
						pwd.getText().equals(pwd2.getText())
					) {
					correctPwd = 1;
				}
				
				if (!recommender.getText().equals("")) {
					CheckOverlapId c = new CheckOverlapId();
					if (recommender.getText().equals(c.checkOverlap(recommender.getText()))) {
						correctRId = 1;	
					} else {
						lblCheckRIdMessage.setForeground(Color.RED);
						lblCheckRIdMessage.setText("추천인 ID를 제대로 입력해주세요.");
						correctRId = 0;
					}
				} else {
					correctRId = 1;
				}
				
				if ((overlapIdResult + correctPwd + correctRId) == 3) {
					new Recommender(recommender.getText());
					login.Encryption encry = new Encryption();
					String password = encry.encryptionPwd(pwd.getText());
					new MemberRegistration(id.getText(), password);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					FrameSignup.this.dispose();
				} else if (overlapIdResult == 0) {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
				} else {
					JOptionPane.showMessageDialog(null, "정보를 제대로 입력해주세요.");
				}
		
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				signupComplete.setBackground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signupComplete.setBackground(Color.LIGHT_GRAY);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				signupComplete.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				signupComplete.setBackground(Color.GRAY);
			}
		});
		signupComplete.setBackground(Color.LIGHT_GRAY);
		signupComplete.setBounds(120, 335, 81, 25);
		panel.add(signupComplete);
		
		JLabel lblNewLabel_3 = new JLabel("\uC644\uB8CC");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		signupComplete.add(lblNewLabel_3);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameSignup.this.dispose();
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
		
		
		

	}
}
