package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;

public class AddBills extends JFrame {
	private int numberOfDetailedBill = 0;
	private final String billId = "10000";
	private static float sumAllDetailedBill = 0;
	//GUI variables
	private JPanel mainPanel = new JPanel();
	
	private JTable customerTable;
	private DefaultTableModel customerModel;
	private JScrollPane scrollpaneCustomer;
	private JPanel contentPane;
	
	private JTextField tfProductID;
	private JLabel lblPhoneNumber;
	private JTextField tfPhoneNumber;
	private JLabel lblCustomerID;
	private JSeparator separator1;
	private JSeparator separator2;
	private static int id = 32523;
	private JLabel lblDateBill;
	private JSeparator separator3;
	private JLabel lblSelectedCustomerId;
	private JTextField tfTotal;
	private JButton btnAddBill;
	private JTextField tfSelectedCustomerID;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDetailedBill;
	private JLabel lblBillInformation;
	private JLabel lblProductId;
	private JButton btnScan;
	private JTextField textField;
	private JTextField tfProductName;
	private JLabel lblProductName;
	private JLabel lblQuantity;
	private JTextField tfQuantity;
	private JLabel lblDiscount;
	private JTextField tfDiscount;
	private JLabel lblPrice;
	private JTextField tfProductPrice;
	private JLabel lblTotalPrice;
	private JLabel lblTotalPayable;
	private JButton btnCalculate;
	private JSeparator separator1_1;
	private JButton btnAddDetailedBill_2;
	private JLabel lblThereAreDetailed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBills frame = new AddBills();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void displayCustomer() {
		customerModel = (DefaultTableModel)customerTable.getModel();
		Object[] columnCustomer = {"customerId", "firstname", "lastname", "dateOfBirth", "address", "phoneNumber"};
		final Object[] row_user = new Object[6];
		row_user[0] = String.valueOf(this.id);
		this.id += 1;
		row_user[1] = "Hello";
		row_user[2] = "World";
		row_user[3] = "01-01-1990";
		row_user[4] = "Hai Ba Trung";
		row_user[5] = "03252352332";
		customerModel.addRow(row_user);
		customerModel.setColumnIdentifiers(columnCustomer);
	}
	
	public AddBills() {
		//Default frame initialization
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mainPanel.setBackground(new Color(147, 112, 219));
		mainPanel.setBounds(20, 75, 766, 578);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		//Search button
		JButton btnSearchCustomer = new JButton("Search");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCustomer();
			}
		});
		btnSearchCustomer.setForeground(new Color(25, 25, 112));
		btnSearchCustomer.setBackground(new Color(230, 230, 250));
		btnSearchCustomer.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchCustomer.setBounds(579, 48, 177, 28);
		mainPanel.add(btnSearchCustomer);
		//Scroll pane loading customer by searching
		scrollpaneCustomer = new JScrollPane();
		scrollpaneCustomer.setBounds(10, 89, 746, 52);
		mainPanel.add(scrollpaneCustomer);
		//Initialize model
		customerModel = new DefaultTableModel();
		Object[] columnCustomer = {"customerId", "firstname", "lastname", "dateOfBirth", "address", "phoneNumber"};
		final Object[] rowCustomer = new Object[6];
		customerModel.setColumnIdentifiers(columnCustomer);
		
		//
		Font font = new Font("Cambria", Font.PLAIN, 16);
		//Loading data
		customerTable = new JTable();
		customerTable.setFont(font);
		scrollpaneCustomer.setFont(new Font("Cambria", Font.BOLD, 16));
		scrollpaneCustomer.setViewportView(customerTable);
		customerTable.setBorder(new LineBorder(new Color(72, 209, 204), 1, true));
		customerTable.setModel(customerModel);
		scrollpaneCustomer.setViewportView(customerTable);
		
		customerTable.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	Object[] options = {"Cancel", "Accept",};
	        	int n = JOptionPane.showOptionDialog(AddBills.this, "Do you want to select this customer?","Confirm message box",
	        	JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
	        	String id = String.valueOf(customerTable.getValueAt(customerTable.getSelectedRow(), 0));
	        	//System.out.println(id);
	        }
	    });
		
		
		//Label phone number
		lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPhoneNumber.setBounds(295, 48, 121, 28);
		mainPanel.add(lblPhoneNumber);
		//Label customer Id
		lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCustomerID.setBounds(10, 51, 121, 28);
		mainPanel.add(lblCustomerID);
		//Text field phone number
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBounds(419, 48, 138, 28);
		mainPanel.add(tfPhoneNumber);
		//Text field customer Id
		tfProductID = new JTextField();
		tfProductID.setBackground(SystemColor.scrollbar);
		tfProductID.setEditable(false);
		tfProductID.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfProductID.setBounds(130, 260, 66, 28);
		mainPanel.add(tfProductID);
		tfProductID.setColumns(10);
		
		separator1 = new JSeparator();
		separator1.setBackground(new Color(75, 0, 130));
		separator1.setForeground(new Color(75, 0, 130));
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setBounds(283, 48, 2, 31);
		mainPanel.add(separator1);
		
		separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(new Color(75, 0, 130));
		separator2.setBackground(new Color(75, 0, 130));
		separator2.setBounds(567, 48, 2, 31);
		mainPanel.add(separator2);
		
		lblDateBill = new JLabel("Bill issue date:");
		lblDateBill.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDateBill.setBounds(10, 443, 121, 28);
		mainPanel.add(lblDateBill);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTotal.setBounds(443, 499, 51, 28);
		mainPanel.add(lblTotal);
		
		separator3 = new JSeparator();
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setForeground(new Color(75, 0, 130));
		separator3.setBackground(new Color(75, 0, 130));
		separator3.setBounds(430, 456, 3, 112);
		mainPanel.add(separator3);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 467, 412, 92);
		mainPanel.add(calendar);
		
		lblSelectedCustomerId = new JLabel("Selected customer ID:");
		lblSelectedCustomerId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSelectedCustomerId.setBounds(10, 154, 186, 28);
		mainPanel.add(lblSelectedCustomerId);
		
		tfTotal = new JTextField();
		tfTotal.setBackground(SystemColor.scrollbar);
		tfTotal.setEditable(false);
		tfTotal.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfTotal.setColumns(10);
		tfTotal.setBounds(491, 496, 265, 28);
		mainPanel.add(tfTotal);
		
		btnAddBill = new JButton("Add Bill");
		btnAddBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//query to add a bill to database
			}
		});
		btnAddBill.setForeground(new Color(25, 25, 112));
		btnAddBill.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAddBill.setBackground(new Color(230, 230, 250));
		btnAddBill.setBounds(591, 540, 165, 28);
		mainPanel.add(btnAddBill);
		
		tfSelectedCustomerID = new JTextField();
		tfSelectedCustomerID.setEditable(false);
		tfSelectedCustomerID.setBackground(SystemColor.scrollbar);
		tfSelectedCustomerID.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfSelectedCustomerID.setColumns(10);
		tfSelectedCustomerID.setBounds(183, 151, 138, 28);
		mainPanel.add(tfSelectedCustomerID);
		
		lblNewLabel = new JLabel("- Customer:");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 10, 591, 31);
		mainPanel.add(lblNewLabel);
		
		lblDetailedBill = new JLabel("- Detailed Bill:");
		lblDetailedBill.setForeground(new Color(75, 0, 130));
		lblDetailedBill.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblDetailedBill.setBounds(10, 196, 149, 31);
		mainPanel.add(lblDetailedBill);
		
		lblBillInformation = new JLabel("- Bill Information:");
		lblBillInformation.setForeground(new Color(75, 0, 130));
		lblBillInformation.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblBillInformation.setBounds(10, 416, 186, 31);
		mainPanel.add(lblBillInformation);
		
		lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblProductId.setBounds(10, 263, 121, 28);
		mainPanel.add(lblProductId);
		
		btnScan = new JButton("Scan barcode");
		btnScan.setForeground(new Color(25, 25, 112));
		btnScan.setFont(new Font("Calibri", Font.BOLD, 18));
		btnScan.setBackground(new Color(230, 230, 250));
		btnScan.setBounds(206, 260, 135, 28);
		mainPanel.add(btnScan);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(114, 48, 159, 28);
		mainPanel.add(textField);
		
		tfProductName = new JTextField();
		tfProductName.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfProductName.setEditable(false);
		tfProductName.setColumns(10);
		tfProductName.setBackground(SystemColor.scrollbar);
		tfProductName.setBounds(491, 263, 265, 28);
		mainPanel.add(tfProductName);
		
		lblProductName = new JLabel("Product name:");
		lblProductName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblProductName.setBounds(363, 263, 121, 28);
		mainPanel.add(lblProductName);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Calibri", Font.BOLD, 18));
		lblQuantity.setBounds(363, 302, 72, 28);
		mainPanel.add(lblQuantity);
		
		tfQuantity = new JTextField();
		tfQuantity.setText("8");
		tfQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		tfQuantity.setFont(new Font("Calibri", Font.PLAIN, 18));
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(491, 302, 66, 28);
		mainPanel.add(tfQuantity);
		
		lblDiscount = new JLabel("Discount price:");
		lblDiscount.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDiscount.setBounds(10, 341, 123, 28);
		mainPanel.add(lblDiscount);
		
		tfDiscount = new JTextField();
		tfDiscount.setText("14000");
		tfDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		tfDiscount.setFont(new Font("Calibri", Font.PLAIN, 18));
		tfDiscount.setColumns(10);
		tfDiscount.setBounds(130, 340, 211, 28);
		mainPanel.add(tfDiscount);
		
		lblPrice = new JLabel("Product price:");
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPrice.setBounds(10, 302, 121, 28);
		mainPanel.add(lblPrice);
		
		tfProductPrice = new JTextField();
		tfProductPrice.setText("63000");
		tfProductPrice.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfProductPrice.setEditable(false);
		tfProductPrice.setColumns(10);
		tfProductPrice.setBackground(SystemColor.scrollbar);
		tfProductPrice.setBounds(130, 299, 211, 28);
		mainPanel.add(tfProductPrice);
		
		lblTotalPrice = new JLabel("Total payable:");
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTotalPrice.setBounds(363, 340, 121, 31);
		mainPanel.add(lblTotalPrice);
		
		lblTotalPayable = new JLabel("0 vnd");
		lblTotalPayable.setForeground(new Color(75, 0, 130));
		lblTotalPayable.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTotalPayable.setBounds(491, 340, 150, 31);
		mainPanel.add(lblTotalPayable);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float totalPayable = (Float.parseFloat(tfProductPrice.getText()) - Float.parseFloat(tfDiscount.getText()))* Float.parseFloat(tfQuantity.getText());
				lblTotalPayable.setText(String.valueOf(totalPayable) + " VND");
			}
		});
		btnCalculate.setForeground(new Color(25, 25, 112));
		btnCalculate.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCalculate.setBackground(new Color(230, 230, 250));
		btnCalculate.setBounds(651, 341, 105, 28);
		mainPanel.add(btnCalculate);
		
		separator1_1 = new JSeparator();
		separator1_1.setOrientation(SwingConstants.VERTICAL);
		separator1_1.setForeground(new Color(75, 0, 130));
		separator1_1.setBackground(new Color(75, 0, 130));
		separator1_1.setBounds(351, 257, 2, 114);
		mainPanel.add(separator1_1);
		
		btnAddDetailedBill_2 = new JButton("Add detailed bill");
		btnAddDetailedBill_2.setForeground(new Color(25, 25, 112));
		btnAddDetailedBill_2.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAddDetailedBill_2.setBackground(new Color(230, 230, 250));
		btnAddDetailedBill_2.setBounds(236, 381, 225, 28);
		mainPanel.add(btnAddDetailedBill_2);
		
		lblThereAreDetailed = new JLabel("There are " + numberOfDetailedBill + " detailed bill(s) that has been added. Click on \"Scan barcode\" to add a new detailed bill.");
		lblThereAreDetailed.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblThereAreDetailed.setBounds(10, 221, 746, 28);
		mainPanel.add(lblThereAreDetailed);
		
		lblNewLabel_1 = new JLabel("Add Bills");
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 20, 169, 45);
		contentPane.add(lblNewLabel_1);
		
	}
}
