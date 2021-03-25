package login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;

import main.CreateBasket;
import main.MainFrame;
import main.ManagerFrame;
import signup.FrameSignup;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameLogin extends JFrame {

	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("res/logo.jpg")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.desktop));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(175, 172, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(SystemColor.menu);
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					String userId = txtUsername.getText();
					String encryptionPwd = new Encryption().encryptionPwd(txtPassword.getText());
					
					if (new CheckSuccessInput().check(userId, encryptionPwd) == "success") {
						lblLoginMessage.setText("");
						JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
						FrameLogin.this.dispose();
						if (userId.equals("admin")) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										ManagerFrame frame = new ManagerFrame();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MainFrame frame = new MainFrame(userId);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					} else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
							txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
						lblLoginMessage.setText("아이디, 비밀번호를 입력해주세요.");
					} else {
						lblLoginMessage.setText("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
					}
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.desktop));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(175, 223, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(SystemColor.menu);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");					
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					String userId = txtUsername.getText();
					String encryptionPwd = new Encryption().encryptionPwd(txtPassword.getText());
					
					if (new CheckSuccessInput().check(userId, encryptionPwd) == "success") {
						lblLoginMessage.setText("");
						JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
						Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(normalCursor);
						FrameLogin.this.dispose();
						if (userId.equals("admin")) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										ManagerFrame frame = new ManagerFrame();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MainFrame frame = new MainFrame(userId);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					} else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
							txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
						lblLoginMessage.setText("아이디, 비밀번호를 입력해주세요.");
						Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(normalCursor);
					} else {
						lblLoginMessage.setText("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
						Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(normalCursor);
					}
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 170, 20);
		panel_1.add(txtPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userId = txtUsername.getText();
				String encryptionPwd = new Encryption().encryptionPwd(txtPassword.getText());
				Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
				setCursor(cursor);
				
				if (new CheckSuccessInput().check(userId, encryptionPwd) == "success") {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
					Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(normalCursor);
					FrameLogin.this.dispose();
					if (userId.equals("admin")) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									ManagerFrame frame = new ManagerFrame();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									MainFrame frame = new MainFrame(userId);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				} else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
						txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
					lblLoginMessage.setText("아이디, 비밀번호를 입력해주세요.");
					Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(normalCursor);
				} else {
					lblLoginMessage.setText("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
					Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(normalCursor);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(164, 164, 164));
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(192, 192, 192));
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(192, 192, 192));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(164, 164, 164));
			}
		});
		pnlBtnLogin.setBackground(new Color(192, 192, 192));
		pnlBtnLogin.setBounds(175, 298, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOG IN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBounds(102, 10, 117, 28);
		pnlBtnLogin.add(lblLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "어플리케이션을 종료하시겠습니까?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
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
				lblX.setForeground(Color.BLACK);
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.setForeground(Color.GRAY);
			}
		});
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(175, 42, 250, 111);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setForeground(new Color(128, 0, 0));
		lblLoginMessage.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblLoginMessage.setBounds(175, 273, 250, 15);
		contentPane.add(lblLoginMessage);
		
		JLabel lblSignUp = new JLabel("sign up");
		lblSignUp.setForeground(new Color(0, 0, 0));
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FrameSignup frame = new FrameSignup();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setForeground(Color.GRAY);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setForeground(new Color(0, 0, 0));
				Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(normalCursor);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblSignUp.setForeground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblSignUp.setForeground(Color.GRAY);
			}
		});
		lblSignUp.setBounds(279, 358, 42, 15);
		contentPane.add(lblSignUp);
		setLocationRelativeTo(null);
	}
}
