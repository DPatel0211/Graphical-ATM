package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JPasswordField pinField;
	private JTextField dobField;
	private JTextField phoneField;				
	private JTextField fnameField;			
	private JTextField lnameField;			
	private JTextField addressField;		
	private JTextField cityField;				
	private JTextField stateField;			
	private JTextField zipField;
	
	
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
		label.setBounds(100, 50, 500, 35);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		this.add(label);
	}
	
	private void initPinField() {
		JLabel label = new JLabel("PIN", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(205, 100, 200, 35);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initDobField() {
		JLabel label = new JLabel("DoB", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(dobField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		dobField = new JTextField(40);
		dobField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(dobField);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone #", SwingConstants.RIGHT);
		label.setBounds(100, 180, 95, 35);
		label.setLabelFor(phoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneField = new JTextField(40);
		phoneField.setBounds(205, 180, 200, 35);
		
		this.add(label);
		this.add(phoneField);
	}
	
	private void initFnameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(100, 220, 95, 35);
		label.setLabelFor(fnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		fnameField = new JTextField(40);
		fnameField.setBounds(205, 220, 200, 35);
		
		this.add(label);
		this.add(fnameField);
	}
	
	private void initLnameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(100, 260, 95, 35);
		label.setLabelFor(lnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lnameField = new JTextField(40);
		lnameField.setBounds(205, 260, 200, 35);
		
		this.add(label);
		this.add(lnameField);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address", SwingConstants.RIGHT);
		label.setBounds(100, 300, 95, 35);
		label.setLabelFor(addressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		addressField = new JTextField(40);
		addressField.setBounds(205, 300, 200, 35);
		
		this.add(label);
		this.add(addressField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(100, 340, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(40);
		cityField.setBounds(205, 340, 200, 35);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("Address", SwingConstants.RIGHT);
		label.setBounds(100, 380, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateField = new JTextField(40);
		stateField.setBounds(205, 380, 200, 35);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initZIPField() {
		JLabel label = new JLabel("ZIP Code", SwingConstants.RIGHT);
		label.setBounds(100, 420, 95, 35);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(40);
		zipField.setBounds(205, 420, 200, 35);
		
		this.add(label);
		this.add(zipField);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}