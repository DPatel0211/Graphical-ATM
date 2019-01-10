package view;

import java.awt.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.User;
import model.BankAccount;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JPasswordField pinField;
	private JComboBox<String> dayField;
	private JComboBox<String> monthField;
	private JComboBox<String> yearField;
	private JTextField phoneFieldone;	
	private JTextField phoneFieldtwo;
	private JTextField phoneFieldthree;
	private JTextField fnameField;			
	private JTextField lnameField;			
	private JTextField addressField;		
	private JTextField cityField;				
	private JComboBox<String> stateField;			
	private JTextField zipField;
	private JLabel errorMessageLabel;
	private JButton backButton;
	private JButton powerButton;
	private JButton createButton;
	
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	} 
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		
		EnterInfo();
		initPinField();
		initDobField();
		initPhoneField();
		initFnameField();
		initLnameField();
		initAddressField();
		initCityField();
		initStateField();
		initZIPField();
		initBackButton();
		initPowerButton();
		initCreateButton();
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		// TODO
		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	private void EnterInfo() {
		JLabel label = new JLabel("Enter the following to create an account:", SwingConstants.LEFT);
		label.setBounds(100, 15, 500, 35);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		this.add(label);
	}
	
	private void initPinField() {
		JLabel label = new JLabel("PIN:", SwingConstants.RIGHT);
		label.setBounds(100, 50, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(205, 50, 200, 35);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initDobField() {
		JLabel label = new JLabel("DoB:", SwingConstants.RIGHT);
		label.setBounds(100, 90, 95, 35);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		JComboBox<String> month = new JComboBox<String>(months);
		month.setBounds(205, 90, 85, 30);

		int x = 0;
		Integer[] days = new Integer[31];
		for (int i = 1; i <= 31; i++) {
			days[x] = i;
			x++;
		}
		JComboBox<Integer> day = new JComboBox<Integer>(days);
		day.setBounds(300, 90, 85, 30);
		int m = 0;
		Integer[] years = new Integer[119];
		for (int i = 1900; i <= 2018; i++) {
			years[m] = i; 
			m++;
		}

		JComboBox<Integer> year = new JComboBox<Integer>(years);
		year.setBounds(400, 90, 85, 30);

		this.add(label);
		this.add(month);
		this.add(day);
		this.add(year);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone #:", SwingConstants.RIGHT);
		label.setBounds(100, 130, 95, 35);
		label.setLabelFor(phoneFieldone);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		
		phoneFieldone = new JTextField(3);
		phoneFieldtwo = new JTextField(3);
		phoneFieldthree = new JTextField(4);
		phoneFieldone.setBounds(205, 130, 40, 30);
		phoneFieldtwo.setBounds(255, 130, 40, 30);
		phoneFieldthree.setBounds(305, 130, 40, 30);
		
		
		
		this.add(label);
		this.add(phoneFieldone);
		this.add(phoneFieldtwo);
		this.add(phoneFieldthree);
	}
	
	private void initFnameField() {
		JLabel label = new JLabel("First Name:", SwingConstants.RIGHT);
		label.setBounds(100, 170, 95, 35);
		label.setLabelFor(fnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		fnameField = new JTextField(40);
		fnameField.setBounds(205, 170, 200, 35);
		
		this.add(label);
		this.add(fnameField);
	}
	
	private void initLnameField() {
		JLabel label = new JLabel("Last Name:", SwingConstants.RIGHT);
		label.setBounds(100, 210, 95, 35);
		label.setLabelFor(lnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lnameField = new JTextField(40);
		lnameField.setBounds(205, 210, 200, 35);
		
		this.add(label);
		this.add(lnameField);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address:", SwingConstants.RIGHT);
		label.setBounds(100, 250, 95, 35);
		label.setLabelFor(addressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		addressField = new JTextField(40);
		addressField.setBounds(205, 250, 200, 35);
		
		this.add(label);
		this.add(addressField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City:", SwingConstants.RIGHT);
		label.setBounds(100, 290, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(40);
		cityField.setBounds(205, 290, 200, 35);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State:", SwingConstants.RIGHT);
		label.setBounds(100, 330, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN",
				"KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM",
				"NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
				"WY" };
		
		JComboBox<String> state = new JComboBox<String>(states);
		state.setBounds(205, 330, 200, 35);
		
		this.add(label);
		this.add(state);
	}
	
	private void initZIPField() {
		JLabel label = new JLabel("ZIP Code:", SwingConstants.RIGHT);
		label.setBounds(100, 370, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(40);
		zipField.setBounds(205, 370, 200, 35);
		
		this.add(label);
		this.add(zipField);	
	}

	private void initBackButton() {
		backButton = new JButton();
		backButton.setBounds(5, 5, 50, 50);
		backButton.addActionListener(this);
		
		try {
			Image image = ImageIO.read(new File("images/back-button.png"));
			backButton.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			backButton.setText("Back");
		}
		
		this.add(backButton);
	}
	
	private void initPowerButton() {
		powerButton = new JButton();
		powerButton.setBounds(5, 70, 50, 50);
		powerButton.addActionListener(this);
		
		try {
			Image image = ImageIO.read(new File("images/power-off.png"));
			powerButton.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			powerButton.setText("OFF");
		}
		
		this.add(powerButton);
	}
	
	private void initCreateButton() {
		
		
		createButton = new JButton("Create your account");
		createButton.setBounds(150, 425, 200, 35);
		createButton.addActionListener(this);
	
		this.add(createButton);
	}
	

	@Override 
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(backButton)) {
			manager.switchTo(ATM.LOGIN_VIEW);
		}  else if (source.equals(powerButton)) {
			manager.shutdown();
		} else if (source.equals(createButton)) {
			boolean create = true;

			String first = fnameField.getText();
			String last = fnameField.getText();
			if (first.equals(null) || last.equals(null) || first.length() > 20 || last.length() > 20) {
				errorMessageLabel.setText("ERROR: Name Formatted Incorrectly - If your first/last name is greater than 15 characters, then only enter the first 15 characters.");
				create = false;
			} 
			
			int dob = 0;
			if (yearField.getSelectedIndex() != 0 || dayField.getSelectedIndex() != 0 || monthField.getSelectedIndex() != 0) {
				dob = Integer.parseInt((""+(yearField.getSelectedIndex()+1899)+(monthField.getSelectedIndex()+0)+(dayField.getSelectedIndex())));
			} else {
				errorMessageLabel.setText("ERROR: Missing Birthday - Make sure to fill in all fields.");
				create = false;

			}
			long phone = 0;
			if( !phoneFieldone.getText().matches("\\d{3}") || !phoneFieldtwo.getText().matches("\\d{3}") || !phoneFieldthree.getText().matches("\\d{4}")) {
				errorMessageLabel.setText("ERROR: Phone Number Formatted Incorrectly - Make sure to fill in the correct numbers in each appropriate field.");
				create = false;
			} else {
				phone = Long.parseLong((phoneFieldone.getText()+phoneFieldtwo.getText()+phoneFieldthree.getText()));
			}
			
			
			String address = addressField.getText();
			String city = cityField.getText();
			String state = stateField.getItemAt(stateField.getSelectedIndex());
			String zip = zipField.getText();
			//TODO -- check if postal is numeric
			if(address.equals(null) || city.equals(null) || state.equals("") || !zip.matches("\\d{5}") || address.length() > 30 || city.length() > 30 || zip.length() != 5) {
				errorMessageLabel.setText("Residency Formatted Incorrectly");
				create = false;
			}
			
			//TODO check if the length is 4
			char[] pinChars = null;
			if(!pinField.getPassword().equals(null)) {
				pinChars= pinField.getPassword();
				for( char digit : pinChars) {
					if (!Character.isDigit(digit)) {
						errorMessageLabel.setText("PIN Formatted Incorrectly");
						create = false;
					}
				}
			}
			
			long num = 0;
			try {
				num = manager.maxAccountNumber()+1;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(create) {
				String pinString = "";
				for (char ch : pinChars) {
					pinString += ch;
				}
				int pin = Integer.parseInt(pinString); 
				User user = new User(pin, dob, phone, first, last, address, city, state, zip);
				BankAccount acc = new BankAccount('Y',num,0,user);
				manager.insertAccount_wrapp(acc);
				manager.login(String.valueOf(num), pinChars);
				this.removeAll();
				initialize();
				manager.switchTo(ATM.HOME_VIEW);
			}
		}
		
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}