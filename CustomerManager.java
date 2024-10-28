package labs.lab9;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

/**
 * This program displays the growth of an investment.
 */
public class CustomerManager extends JFrame {
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 400;
	
	private JButton deleteButton, saveCustomer, newCustomer;
	private JPanel customer, email, amount, pets, location, notes, buttons, delete, customerList;
	private JTextField name, emailText, amountText;
	private JCheckBox dog, cat, bird, fish, other;
	private JComboBox box;
	private JTextArea text;
	private JList<String> customerNames;
	private static Map<String, Customer> customerMap = new HashMap<>();
	private DefaultListModel<String> myList;
	private ArrayList<String> nameArray = new ArrayList();
	private String stringInfo;
	private Customer customerInfo;
	
	public CustomerManager() {
		
		createCustomerList();
		createDelete();
		createName();
		createEmail();
		createPets();
		createAmountSpent();
		createLocation();
		createNotes();
		createButtons();
		createLeftPanel();
		createRightPanel();	
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 8));

		setLayout(new GridLayout(1,2));
	}
	
	private void createCustomerList() {
		customerList = new JPanel(new BorderLayout());
		
		myList = new DefaultListModel<>(); 
		customerNames = new JList<>(myList);
		
		JScrollPane pane = new JScrollPane(customerNames);

		customerList.setPreferredSize(new Dimension(30,30));
		
		customerList.add(pane, BorderLayout.CENTER);

		customerNames.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {  
		        stringInfo = customerNames.getSelectedValue();
		        customerInfo = customerMap.get(stringInfo);
		        
		        name.setText(customerInfo.getName());
				emailText.setText(customerInfo.getEmail());
				
				dog.setSelected(customerInfo.getDog());
				cat.setSelected(customerInfo.getCat());
				bird.setSelected(customerInfo.getBird());
				fish.setSelected(customerInfo.getFish());
				other.setSelected(customerInfo.getOther());
				
				amountText.setText(customerInfo.getAmount());
				box.setSelectedItem(customerInfo.getLocation());
				text.setText(customerInfo.getNotes());
		    }  
		});
	}
	
	private void createDelete() {
		delete = new JPanel();
		deleteButton = new JButton("Delete");
		delete.add(deleteButton);
		
		customerList.add(delete, BorderLayout.SOUTH);
		
		ActionListener delListener = new deleteListener();
		deleteButton.addActionListener(delListener);
	}
	
	class deleteListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			int index = nameArray.indexOf(stringInfo);
			nameArray.remove(stringInfo);
			customerMap.remove(stringInfo);
			myList.remove(index);
			
			name.setText("");
			emailText.setText("");
			
			dog.setSelected(false);
			cat.setSelected(false);
			bird.setSelected(false);
			fish.setSelected(false);
			other.setSelected(false);
			
			amountText.setText("0.0");
			
			box.setSelectedItem("Irvine");
			
			text.setText("");
		}
	}
	
	private void createName() {
		customer = new JPanel();
		
		JLabel label = new JLabel("Name:");
		name = new JTextField(20);
		name.setText("");
		
		customer.add(label);
		customer.add(name);
	}
	
	private void createEmail() {
		email = new JPanel();
		
		JLabel label = new JLabel("Email:");
		emailText = new JTextField(20);
		emailText.setText("");
		
		email.add(label);
		email.add(emailText);
	}
	
	private void createPets() {
		pets = new JPanel();
		
		JLabel label = new JLabel("Pets:");
		
		dog = new JCheckBox("Dog(s)");
		cat = new JCheckBox("Cat(s)");
		bird = new JCheckBox("Bird(s)");
		fish = new JCheckBox("Fish");
		other = new JCheckBox("Other");
		
		pets.add(label);
		pets.add(dog);
		pets.add(cat);
		pets.add(bird);
		pets.add(fish);
		pets.add(other);
	}
	
	private void createAmountSpent() {
		amount = new JPanel();
		
		JLabel label = new JLabel("Total Amount Spent:");
		amountText = new JTextField(10);
		amountText.setText("0.0");
		
		amount.add(label);
		amount.add(amountText);
	}
	
	private void createLocation() {
		location = new JPanel();
		
		JLabel label = new JLabel("Home Store Location:");
		box = new JComboBox();
		box.addItem("Irvine");
		box.addItem("Los Angeles");
		box.addItem("Paris");
		box.addItem("Shanghai");
		box.addItem("New York");
		box.addItem("London");
		
		location.add(label);
		location.add(box);
	}
	
	private void createNotes() {
		notes = new JPanel();
		
		JLabel label = new JLabel("Notes:");
		text = new JTextArea(4, 30);
		text.setLineWrap(true);
		text.setEditable(true);
		
		JScrollPane pane = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setPreferredSize(new Dimension(350,70));
		
		notes.add(label);
		notes.add(pane);
	}
	
	private void createButtons() {
		buttons = new JPanel();
		saveCustomer = new JButton("Save Customer");
		newCustomer = new JButton("New Customer");
		
		buttons.add(saveCustomer);
		buttons.add(newCustomer);
		
		ActionListener newListener = new newListener();
		newCustomer.addActionListener(newListener);
		
		ActionListener saveListener = new saveListener();
		saveCustomer.addActionListener(saveListener);
	}
	
	class saveListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			
			String amountSpent = "0.0";
			
			String nameInfo = name.getText();
			String emailInfo = emailText.getText();

			if (nameInfo.length() == 0 || emailInfo.length() == 0) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid Input!"); 
			}
			
			else if (myList.contains(nameInfo) && customerNames.isSelectionEmpty()) {
				JFrame f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Invalid Input!"); 
			}
			
			else if (!myList.contains(nameInfo)){
				Boolean d = dog.isSelected();
				Boolean c = cat.isSelected();
				Boolean b = bird.isSelected();
				Boolean f = fish.isSelected();
				Boolean o = other.isSelected();
				
				if (!isDouble(amountText.getText())) {
					JFrame idk =new JFrame(); 
					JOptionPane.showMessageDialog(idk,"Invalid Input!");
					
				}
				else {
					amountSpent = amountText.getText();
					String loc = (String) box.getSelectedItem();
					String n = text.getText();
					
					Customer cust = new Customer(nameInfo, emailInfo, d, c, b, f, o, amountSpent, loc, n);
					customerMap.put(nameInfo,cust);
					
					nameArray.add(nameInfo);
					Collections.sort(nameArray);
					
					myList.clear();
					for(String string: nameArray) {
						myList.addElement(string);
					}
					
					JFrame s = new JFrame();  
				    JOptionPane.showMessageDialog(s,"Customer saved!");
				}
			}
			
			else if (!customerNames.isSelectionEmpty()) {
				if (!(customerInfo.getName().equals(nameInfo))){
					JFrame idk = new JFrame(); 
					JOptionPane.showMessageDialog(idk,"Invalid Input!");
				}
				else if (customerInfo.getName().equals(nameInfo)) {
					if (!isDouble(amountText.getText())) {
						JFrame idk =new JFrame(); 
						JOptionPane.showMessageDialog(idk,"Invalid Input!");
						
					}
					else {
						customerInfo.setEmail(emailText.getText());
						customerInfo.setDog(dog.isSelected());
						customerInfo.setCat(cat.isSelected());
						customerInfo.setBird(bird.isSelected());
						customerInfo.setFish(fish.isSelected());
						customerInfo.setOther(other.isSelected());
						customerInfo.setAmount(amountText.getText());
						customerInfo.setLocation((String) box.getSelectedItem());
						customerInfo.setNotes(text.getText());
						
						JFrame s =new JFrame();  
					    JOptionPane.showMessageDialog(s,"Customer saved!");
					}	
				}
			}
		}
	}
	
	private boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	class newListener implements ActionListener {  
		public void actionPerformed (ActionEvent event) {
			name.setText("");
			emailText.setText("");
			
			dog.setSelected(false);
			cat.setSelected(false);
			bird.setSelected(false);
			fish.setSelected(false);
			other.setSelected(false);
			
			amountText.setText("0.0");
			box.setSelectedItem("Irvine");
			text.setText("");
		}
	}
	
	private void createLeftPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		add(customerList, BorderLayout.WEST);
	}
	
	private void createRightPanel() {
		JPanel panel = new JPanel();
		panel.add(customer);
		panel.add(email);
		panel.add(pets);
		panel.add(amount);
		panel.add(location);
		panel.add(notes);
		panel.add(buttons);
		add(panel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new CustomerManager();
			
			frame.setTitle("Sugeily Angulo-Limon - 44198962");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
        });
	}
}
