import java.awt.AWTException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Robot;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import java.awt.AWTException;

public class GloveMouse3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GloveMouse3 window = new GloveMouse3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public GloveMouse3() {
		initialize();
	}
	
	public static void click(int x, int y) {
		Robot robot = null;
		try {
			robot = new Robot ();
		} catch (AWTException e) {
			System.out.println("New Robot Didn't work :( ");
			e.printStackTrace();
		}
		robot.mouseMove(x, y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 457, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(103, 163, 205, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			int x = 0;
			int y = 0;
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Yo bro");
				click(x, y);
				//JOptionPane.showMessageDialog(null, String.format("yea boi"));
				
				x+=100;
				y+=100;
			};
		});
		btnNewButton.setBounds(167, 199, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
