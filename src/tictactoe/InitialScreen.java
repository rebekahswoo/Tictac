package tictactoe;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javafx.scene.AccessibleRole;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Scanner;

//inherits the Game class
public class InitialScreen implements ActionListener{
    
	private String xName, oName;
	static String summery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonReplay;
    private javax.swing.JLabel jLabelMSG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private FileWriter writer;
    
	JFrame window;
	Container con;
	JPanel titlePanel, introPanel, startButtonPanel, textFieldPanel;
	JLabel titleLabel, introLabel, nameLabel;
	Font titleFont = new Font("Times New Roman", Font.ITALIC, 30);
	JButton startButton = new JButton("START");
	JTextArea introText;
	JTextField PlayerXName;
	JTextField PlayerOName;
	
	//utilizes jPanel and JFrame
	//introductory screen with title, author, and instructions
	public InitialScreen() {
	
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		Font titleFont = new Font("Times New Roman", Font.ITALIC, 90);
		Font normalFont = new Font("Times New Roman", Font.ITALIC, 30);
		Font smallFont = new Font("Times New Roman", Font.ITALIC, 15);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.black);
		
		titleLabel = new JLabel("TIC TAC TOE");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		
		nameLabel = new JLabel("By Rebekah Woo");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(normalFont);
		
		introPanel = new JPanel();
		introPanel.setBounds(100, 270, 600, 50);
		introPanel.setBackground(Color.black);
		
		introLabel = new JLabel("enter both players' names below and press start to begin!");
		introLabel.setForeground(Color.white);
		introLabel.setFont(smallFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton.setBackground(Color.white);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					createGameScreen(evt);
				} catch(IOException ex) {
					Logger.getLogger(InitialScreen.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		textFieldPanel = new JPanel();
		textFieldPanel.setBounds(100, 350, 600, 50);
		textFieldPanel.setBackground(Color.black);
		
		PlayerXName = new JTextField();
		PlayerXName.setText("player X name");
		
		PlayerOName = new JTextField();
		PlayerOName.setText("player O name");
		
		xName = PlayerXName.getText();
		oName = PlayerOName.getText();
		
		titlePanel.add(titleLabel);
		titlePanel.add(nameLabel);
		introPanel.add(introLabel);
		startButtonPanel.add(startButton);
		con.add(titlePanel);
		con.add(introPanel);
		con.add(startButtonPanel);
		textFieldPanel.add(PlayerXName);
		textFieldPanel.add(PlayerOName);
		con.add(textFieldPanel);;
		
		window.setVisible(true);
		
	}
	
	public void createGameScreen(ActionEvent evt) throws IOException {
		xName = PlayerXName.getText().trim();
		oName = PlayerOName.getText().trim();
		
		summery = ("Player X Name" + xName + "vs")+ (oName);
		
		FileWriter fileWriter = new FileWriter("src/tictactoe/playerNames");
		fileWriter.write(summery);
		fileWriter.close();
		
		window.setVisible(false);
		//new Game().setVisible(true);
		Game game = new Game();
		game.setVisible(true);
		
		window.dispose();
		
	}
	
	//https://www.youtube.com/watch?v=RcvABhflOkI
	public static void main(String[] args) {
			new InitialScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

