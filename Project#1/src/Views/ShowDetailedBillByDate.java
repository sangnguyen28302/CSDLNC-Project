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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowDetailedBillByDate extends JFrame {
	private boolean isSearchByDate = false;
	private boolean isSearchByCustomer = false;
	private boolean isSearchByProduct = false;
	//
	private JPanel mainPanel = new JPanel();
	private JTable customerTable;
	private DefaultTableModel customerModel;
	private JScrollPane scrollpaneCustomer;
	private JPanel contentPane;
	private JLabel lblBillDate;
	private static int id = 32523;
	private JLabel lblNewLabel;
	private JLabel lblTitle;
	private JLabel lblCustomerName;
	private JTextField tfCustomerName;
	private Checkbox cbSearchByCustomer;
	private JLabel lblProductCode;
	private JTextField tfProductCode;
	private Checkbox cbSearchByProductCode;
	private JButton btnClear;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDetailedBillByDate frame = new ShowDetailedBillByDate();
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
	
	public ShowDetailedBillByDate() {
		//Default frame initialization
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mainPanel.setBackground(new Color(147, 112, 219));
		mainPanel.setBounds(10, 75, 786, 538);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		//Search button
		JButton btnSearchAll = new JButton("Search");
		btnSearchAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCustomer();
			}
		});
		btnSearchAll.setForeground(new Color(25, 25, 112));
		btnSearchAll.setBackground(new Color(230, 230, 250));
		btnSearchAll.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchAll.setBounds(597, 182, 132, 28);
		mainPanel.add(btnSearchAll);
		//Scroll pane loading customer by searching
		scrollpaneCustomer = new JScrollPane();
		scrollpaneCustomer.setBounds(10, 220, 766, 269);
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
	        	int n = JOptionPane.showOptionDialog(ShowDetailedBillByDate.this, "Do you want to select this customer?","Confirm message box",
	        	JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
	        	String id = String.valueOf(customerTable.getValueAt(customerTable.getSelectedRow(), 0));
	        	//System.out.println(id);
	        }
	    });
		//Label customer Id
		lblBillDate = new JLabel("Bill issue date:");
		lblBillDate.setFont(new Font("Calibri", Font.BOLD, 18));
		lblBillDate.setBounds(10, 51, 121, 28);
		mainPanel.add(lblBillDate);
		
		lblNewLabel = new JLabel("Search a customer by ID or phone number:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 21, 396, 20);
		mainPanel.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(149, 48, 237, 28);
		mainPanel.add(dateChooser);
		
		Checkbox cbSearchByDate = new Checkbox("");
		cbSearchByDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {                 
				 isSearchByDate = !isSearchByDate;
				 System.out.println(isSearchByDate);
			}
		});
		cbSearchByDate.setBounds(402, 51, 19, 21);
		mainPanel.add(cbSearchByDate);
		
		cbSearchByCustomer = new Checkbox("");
		Checkbox cbSearchByCustomer = new Checkbox("");
		cbSearchByCustomer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {                 
				 isSearchByCustomer = !isSearchByCustomer;
				 System.out.println(isSearchByCustomer);
			}
		});
		cbSearchByCustomer.setBounds(402, 88, 19, 21);
		mainPanel.add(cbSearchByCustomer);
		
		cbSearchByProductCode = new Checkbox("");
		cbSearchByProductCode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {                 
				 isSearchByProduct = !isSearchByProduct;
				 System.out.println(isSearchByProduct);
			}
		});
		cbSearchByProductCode.setBounds(402, 129, 19, 21);
		mainPanel.add(cbSearchByProductCode);
		
		lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCustomerName.setBounds(10, 87, 137, 28);
		mainPanel.add(lblCustomerName);
		
		tfCustomerName = new JTextField();
		tfCustomerName.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfCustomerName.setColumns(10);
		tfCustomerName.setBounds(149, 84, 237, 28);
		mainPanel.add(tfCustomerName);
		
		lblProductCode = new JLabel("Product code:");
		lblProductCode.setFont(new Font("Calibri", Font.BOLD, 18));
		lblProductCode.setBounds(10, 122, 137, 28);
		mainPanel.add(lblProductCode);
		
		tfProductCode = new JTextField();
		tfProductCode.setFont(new Font("Cambria", Font.PLAIN, 16));
		tfProductCode.setColumns(10);
		tfProductCode.setBounds(149, 122, 237, 28);
		mainPanel.add(tfProductCode);
	
		btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(25, 25, 112));
		btnClear.setFont(new Font("Calibri", Font.BOLD, 18));
		btnClear.setBackground(new Color(230, 230, 250));
		btnClear.setBounds(455, 182, 132, 28);
		mainPanel.add(btnClear);
		
		lblTitle = new JLabel("Detailed Bill By Date");
		lblTitle.setForeground(new Color(230, 230, 250));
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 40));
		lblTitle.setBounds(10, 20, 542, 45);
		contentPane.add(lblTitle);
		
	}
}
