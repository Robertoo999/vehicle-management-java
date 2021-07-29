import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//PACKAGE DETAILS
import pDealer.Dealer;
import pCustomer.Customer;
import pVehicle.Vehicle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Project {

	private JFrame frmVehicleManagementSystem;
	private JTextField AUsernameField;
	private JPasswordField APasswordField;
	private JTextField DUsernameField;
	private JPasswordField DPasswordField;
	private JTextField DNUsernameField;
	private JPasswordField DNPasswordField;
	private JTextField txtDNName;
	private JTextField txtDNPhone;
	private JTextField txtDNEmail;
	private JTable table;
	private JTextField modelField;
	private JTextField priceField;
	private JTextField colorField;
	private JTextField CUsernameField;
	private JPasswordField CPasswordField;
	private JTextField CNUsernameField;
	private JPasswordField CNPasswordField;
	private JTextField CNNameField;
	private JTextField CNPhoneField;
	private JTextField CNEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Project window = new Project();
					window.frmVehicleManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Set up page classes
		Dealer d=new Dealer();
		Vehicle vh=new Vehicle();
		Customer cs=new Customer();
		
		//default accounts
		d.addDealer("admin","admin","Mario","Palghar","1234567890","mario@gmail.com");
		d.loginDealer("admin", "admin", vh);
		vh.addVehicle("admin",400, "Volkswagen", "Polo", "Hatchback", "2011", "Red", "Petrol", "14,00,000");
		vh.addVehicle("admin",400, "Toyota", "Corolla", "Sedan", "2004", "White", "Petrol", "10,00,000");
		cs.addCustomer("admin","admin","Mario","Palghar","1234567890","mario@gmail.com");
		cs.loginCustomer("admin", "admin", vh);
		vh.buyVehicle(101, "admin", 300);
		
		
		//MAIN PAGE
		frmVehicleManagementSystem = new JFrame();
		frmVehicleManagementSystem.setResizable(false);
		frmVehicleManagementSystem.setTitle("Vehicle Management System");
		frmVehicleManagementSystem.setBounds(100, 100, 700, 430);
		frmVehicleManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVehicleManagementSystem.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel mainmenupanel = new JPanel();
		frmVehicleManagementSystem.getContentPane().add(mainmenupanel, "name_2605759473900");
		mainmenupanel.setLayout(null);
		
		//setting up panels
		JPanel adminloginpanel = new JPanel();
		JPanel dealerloginpanel = new JPanel();
		JPanel dealernewpanel = new JPanel();
		JPanel customernewpanel = new JPanel();
		JPanel customerloginpanel = new JPanel();

		
		//MAIN MENU SCREEN
		JLabel lblVehicleManagementSystem = new JLabel("VEHICLE MANAGEMENT SYSTEM");
		lblVehicleManagementSystem.setBackground(Color.PINK);
		lblVehicleManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVehicleManagementSystem.setForeground(Color.RED);
		lblVehicleManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleManagementSystem.setBounds(10, 11, 674, 100);
		mainmenupanel.add(lblVehicleManagementSystem);
		
		//Main Menu buttons
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainmenupanel.setVisible(false);
				adminloginpanel.setVisible(true);
			}
		});
		btnAdmin.setBounds(38, 122, 145, 50);
		mainmenupanel.add(btnAdmin);
		
		JButton btnDealer = new JButton("DEALER");
		btnDealer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainmenupanel.setVisible(false);
				dealerloginpanel.setVisible(true);
			}
		});
		btnDealer.setBounds(193, 122, 145, 50);
		mainmenupanel.add(btnDealer);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainmenupanel.setVisible(false);
				customerloginpanel.setVisible(true);
			}
		});
		btnCustomer.setBounds(348, 122, 145, 50);
		mainmenupanel.add(btnCustomer);
		
		JButton btnVehicles = new JButton("VEHICLES");
		btnVehicles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainmenupanel.setVisible(false);
				
				//VIEW VEHICLE PANEL
				JPanel viewvehiclespanel = new JPanel();
				viewvehiclespanel.setLayout(null);
				frmVehicleManagementSystem.getContentPane().add(viewvehiclespanel, "name_35127525940900");
				
				JLabel lblVehicleList = new JLabel("Vehicle List");
				lblVehicleList.setHorizontalAlignment(SwingConstants.CENTER);
				lblVehicleList.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblVehicleList.setBounds(262, 11, 160, 50);
				viewvehiclespanel.add(lblVehicleList);
				
				JButton button_6 = new JButton("Back");
				button_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						viewvehiclespanel.setVisible(false);
						mainmenupanel.setVisible(true);
					}
				});
				button_6.setToolTipText("Go Back");
				button_6.setBounds(595, 11, 89, 23);
				viewvehiclespanel.add(button_6);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 72, 674, 245);
				viewvehiclespanel.add(scrollPane_1);
				
				
				//TABLE SETUP FIRST TIME
				vh.displayAllVehicles();
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setDefaultEditor(Object.class, null);
				String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
				table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
						
				//ADDING ENTRIES IN TABLE
				for(int i=0;i<vh.Vid.size();i++) {
					table.setValueAt(vh.Did.get(i), i, 0);
					table.setValueAt(vh.Dname.get(i), i, 1);
					table.setValueAt(vh.Vid.get(i), i, 2);
					table.setValueAt(vh.Vbrand.get(i), i, 3);
					table.setValueAt(vh.Vmodel.get(i), i, 4);
					table.setValueAt(vh.Vtype.get(i), i, 5);
					table.setValueAt(vh.Vcolor.get(i), i, 6);
					table.setValueAt(vh.Vyear.get(i), i, 7);
					table.setValueAt(vh.Vfuel.get(i), i, 8);
					table.setValueAt(vh.Vprice.get(i), i, 9);
					table.setValueAt(vh.Vstatus.get(i), i, 10);
				}
				vh.clearall();
						
				scrollPane_1.setViewportView(table);
				
				//TOGGLE BUTTONS
				JButton btnDisplayVehicles = new JButton("Display Vehicles");
				JButton btnDisplayDealers = new JButton("Display Dealers");
				
				
				btnDisplayDealers.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//DISPLAY DEALERS WITH INFO	
						
						d.displayAllDealers();
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames= {"Dealer ID","Username","Name","Region","Phone","Email"};
						table.setModel(new DefaultTableModel(columnNames,d.Did.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<d.Did.size();i++) {
							table.setValueAt(d.Did.get(i), i, 0);
							table.setValueAt(d.Duname.get(i), i, 1);
							table.setValueAt(d.Dname.get(i), i, 2);
							table.setValueAt(d.Dregion.get(i), i, 3);
							table.setValueAt(d.Dphone.get(i), i, 4);
							table.setValueAt(d.Demail.get(i), i, 5);
						}
						d.clearall();
								
						scrollPane_1.setViewportView(table);
						
						btnDisplayVehicles.setVisible(true);
						btnDisplayDealers.setVisible(false);
					}
				});
				btnDisplayDealers.setBounds(524, 328, 160, 50);
				viewvehiclespanel.add(btnDisplayDealers);
				
				btnDisplayVehicles.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//DISPLAY VEHICLES AGAIN 
						vh.displayAllVehicles();
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
						table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<vh.Vid.size();i++) {
							table.setValueAt(vh.Did.get(i), i, 0);
							table.setValueAt(vh.Dname.get(i), i, 1);
							table.setValueAt(vh.Vid.get(i), i, 2);
							table.setValueAt(vh.Vbrand.get(i), i, 3);
							table.setValueAt(vh.Vmodel.get(i), i, 4);
							table.setValueAt(vh.Vtype.get(i), i, 5);
							table.setValueAt(vh.Vcolor.get(i), i, 6);
							table.setValueAt(vh.Vyear.get(i), i, 7);
							table.setValueAt(vh.Vfuel.get(i), i, 8);
							table.setValueAt(vh.Vprice.get(i), i, 9);
							table.setValueAt(vh.Vstatus.get(i), i, 10);
						}
						vh.clearall();
								
						scrollPane_1.setViewportView(table);
						btnDisplayVehicles.setVisible(false);
						btnDisplayDealers.setVisible(true);
					}
				});
				btnDisplayVehicles.setBounds(524, 328, 160, 50);
				viewvehiclespanel.add(btnDisplayVehicles);
				
				//COMBO BOXES FOR SORTING
				JComboBox<String> BrandcomboBox = new JComboBox<String>();
				JComboBox<String> TypecomboBox = new JComboBox<String>();
				JComboBox<String> FuelcomboBox = new JComboBox<String>();
				JComboBox<String> DealercomboBox = new JComboBox<String>();
				
				
				BrandcomboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//SORTING ADD TO EVERY COMBO BOX
						vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
						
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
						table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<vh.Vid.size();i++) {
							table.setValueAt(vh.Did.get(i), i, 0);
							table.setValueAt(vh.Dname.get(i), i, 1);
							table.setValueAt(vh.Vid.get(i), i, 2);
							table.setValueAt(vh.Vbrand.get(i), i, 3);
							table.setValueAt(vh.Vmodel.get(i), i, 4);
							table.setValueAt(vh.Vtype.get(i), i, 5);
							table.setValueAt(vh.Vcolor.get(i), i, 6);
							table.setValueAt(vh.Vyear.get(i), i, 7);
							table.setValueAt(vh.Vfuel.get(i), i, 8);
							table.setValueAt(vh.Vprice.get(i), i, 9);
							table.setValueAt(vh.Vstatus.get(i), i, 10);
						}
						vh.clearall();
								
						scrollPane_1.setViewportView(table);
						
						btnDisplayVehicles.setVisible(false);
						btnDisplayDealers.setVisible(true);
					}
				});
				BrandcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Toyota", "Honda", "Ford", "Volkswagen", "Nissan", "Chevrolet", "Hyundai", "Renault", "Skoda", "Fiat", "Tata", "Jeep", "Ferrari", "Lamborghini", "Bugatti", "BMW", "Maruti", "Tesla"}));
				BrandcomboBox.setBounds(78, 358, 100, 20);
				viewvehiclespanel.add(BrandcomboBox);
				
				TypecomboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//SORTING ADD TO EVERY COMBO BOX
						vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
						
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
						table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<vh.Vid.size();i++) {
							table.setValueAt(vh.Did.get(i), i, 0);
							table.setValueAt(vh.Dname.get(i), i, 1);
							table.setValueAt(vh.Vid.get(i), i, 2);
							table.setValueAt(vh.Vbrand.get(i), i, 3);
							table.setValueAt(vh.Vmodel.get(i), i, 4);
							table.setValueAt(vh.Vtype.get(i), i, 5);
							table.setValueAt(vh.Vcolor.get(i), i, 6);
							table.setValueAt(vh.Vyear.get(i), i, 7);
							table.setValueAt(vh.Vfuel.get(i), i, 8);
							table.setValueAt(vh.Vprice.get(i), i, 9);
							table.setValueAt(vh.Vstatus.get(i), i, 10);
						}
						vh.clearall();
								
						scrollPane_1.setViewportView(table);
						
						btnDisplayVehicles.setVisible(false);
						btnDisplayDealers.setVisible(true);
					}
				});
				TypecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Hatchback", "Sedan", "MPV", "SUV", "Convertible", "Pickup", "Coupe"}));
				TypecomboBox.setBounds(244, 328, 100, 20);
				viewvehiclespanel.add(TypecomboBox);
				
				FuelcomboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//SORTING ADD TO EVERY COMBO BOX
						vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
						
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
						table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<vh.Vid.size();i++) {
							table.setValueAt(vh.Did.get(i), i, 0);
							table.setValueAt(vh.Dname.get(i), i, 1);
							table.setValueAt(vh.Vid.get(i), i, 2);
							table.setValueAt(vh.Vbrand.get(i), i, 3);
							table.setValueAt(vh.Vmodel.get(i), i, 4);
							table.setValueAt(vh.Vtype.get(i), i, 5);
							table.setValueAt(vh.Vcolor.get(i), i, 6);
							table.setValueAt(vh.Vyear.get(i), i, 7);
							table.setValueAt(vh.Vfuel.get(i), i, 8);
							table.setValueAt(vh.Vprice.get(i), i, 9);
							table.setValueAt(vh.Vstatus.get(i), i, 10);
						}
						vh.clearall();
								
						scrollPane_1.setViewportView(table);
						
						btnDisplayVehicles.setVisible(false);
						btnDisplayDealers.setVisible(true);
					}
				});
				FuelcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Petrol", "Diesel", "Petrol/Diesel", "CNG", "Electric"}));
				FuelcomboBox.setBounds(244, 358, 100, 20);
				viewvehiclespanel.add(FuelcomboBox);
			
				DealercomboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//SORTING ADD TO EVERY COMBO BOX
						vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
						
						table.removeAll();
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setDefaultEditor(Object.class, null);
						String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
						table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
								
						//ADDING ENTRIES IN TABLE
						for(int i=0;i<vh.Vid.size();i++) {
							table.setValueAt(vh.Did.get(i), i, 0);
							table.setValueAt(vh.Dname.get(i), i, 1);
							table.setValueAt(vh.Vid.get(i), i, 2);
							table.setValueAt(vh.Vbrand.get(i), i, 3);
							table.setValueAt(vh.Vmodel.get(i), i, 4);
							table.setValueAt(vh.Vtype.get(i), i, 5);
							table.setValueAt(vh.Vcolor.get(i), i, 6);
							table.setValueAt(vh.Vyear.get(i), i, 7);
							table.setValueAt(vh.Vfuel.get(i), i, 8);
							table.setValueAt(vh.Vprice.get(i), i, 9);
							table.setValueAt(vh.Vstatus.get(i), i, 10);
						}
						vh.clearall();
								
						scrollPane_1.setViewportView(table);
						
						btnDisplayVehicles.setVisible(false);
						btnDisplayDealers.setVisible(true);
					}
				});
				DealercomboBox.setModel(new DefaultComboBoxModel<String>(d.DealerList()));
				DealercomboBox.setBounds(78, 327, 100, 20);
				viewvehiclespanel.add(DealercomboBox);
				
				
				JLabel lblDealer = new JLabel("Dealer :");
				lblDealer.setHorizontalAlignment(SwingConstants.CENTER);
				lblDealer.setBounds(20, 330, 46, 14);
				viewvehiclespanel.add(lblDealer);
				
				JLabel lblBrand_1 = new JLabel("Brand :");
				lblBrand_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblBrand_1.setBounds(22, 361, 46, 14);
				viewvehiclespanel.add(lblBrand_1);
				
				JLabel lblNewLabel_6 = new JLabel("Type :");
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_6.setBounds(188, 331, 46, 14);
				viewvehiclespanel.add(lblNewLabel_6);
				
				JLabel lblFuel = new JLabel("Fuel :");
				lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
				lblFuel.setBounds(188, 362, 46, 14);
				viewvehiclespanel.add(lblFuel);
				
				//DISPLAY DEALER INFO BUTTON
				JButton btnDealerInfo = new JButton("Dealer Info");
				btnDealerInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow() != -1) {
						
							d.findDealer((String) table.getValueAt(table.getSelectedRow(), 1));
							
							JPanel dealerinfopanel = new JPanel();
							dealerinfopanel.setLayout(null);
							frmVehicleManagementSystem.getContentPane().add(dealerinfopanel, "name_66305818664800");
							
							JLabel lblCustomerDetails = new JLabel("Dealer Details");
							lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
							lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
							lblCustomerDetails.setBounds(234, 11, 223, 50);
							dealerinfopanel.add(lblCustomerDetails);
							
							JLabel label_2 = new JLabel("Username :");
							label_2.setHorizontalAlignment(SwingConstants.CENTER);
							label_2.setBounds(188, 116, 97, 14);
							dealerinfopanel.add(label_2);
							
							JButton button = new JButton("Back");
							button.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									dealerinfopanel.setVisible(false);
									viewvehiclespanel.setVisible(true);
								}
							});
							button.setToolTipText("Go Back");
							button.setBounds(595, 11, 89, 23);
							dealerinfopanel.add(button);
							
							JLabel label_7 = new JLabel("Name :");
							label_7.setHorizontalAlignment(SwingConstants.CENTER);
							label_7.setBounds(188, 141, 97, 14);
							dealerinfopanel.add(label_7);
							
							JLabel label_8 = new JLabel(" Region :");
							label_8.setHorizontalAlignment(SwingConstants.CENTER);
							label_8.setBounds(188, 166, 97, 14);
							dealerinfopanel.add(label_8);
							
							JLabel label_9 = new JLabel("Phone No :");
							label_9.setHorizontalAlignment(SwingConstants.CENTER);
							label_9.setBounds(188, 191, 97, 14);
							dealerinfopanel.add(label_9);
							
							JLabel label_10 = new JLabel("Email :");
							label_10.setHorizontalAlignment(SwingConstants.CENTER);
							label_10.setBounds(188, 216, 97, 14);
							dealerinfopanel.add(label_10);
							
							JLabel label_11 = new JLabel(d.DealerDetails(0));
							label_11.setBounds(295, 116, 162, 14);
							dealerinfopanel.add(label_11);
							
							JLabel label_12 = new JLabel(d.DealerDetails(1));
							label_12.setBounds(295, 141, 162, 14);
							dealerinfopanel.add(label_12);
							
							JLabel label_13 = new JLabel(d.DealerDetails(2));
							label_13.setBounds(295, 166, 162, 14);
							dealerinfopanel.add(label_13);
							
							JLabel label_14 = new JLabel(d.DealerDetails(3));
							label_14.setBounds(295, 191, 162, 14);
							dealerinfopanel.add(label_14);
							
							JLabel label_15 = new JLabel(d.DealerDetails(4));
							label_15.setBounds(295, 216, 162, 14);
							dealerinfopanel.add(label_15);
							
							JLabel lblCustomerId = new JLabel("Dealer ID :");
							lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
							lblCustomerId.setBounds(188, 91, 97, 14);
							dealerinfopanel.add(lblCustomerId);
							
							JLabel label_17 = new JLabel(d.DealerDetails(5));
							label_17.setBounds(295, 91, 162, 14);
							dealerinfopanel.add(label_17);
							
							dealerinfopanel.setVisible(true);
							viewvehiclespanel.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Select Dealer from Table.", "No Dealer Selected", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnDealerInfo.setBounds(354, 328, 160, 50);
				viewvehiclespanel.add(btnDealerInfo);
				
				BrandcomboBox .setSelectedIndex(0);
				TypecomboBox.setSelectedIndex(0);
				FuelcomboBox.setSelectedIndex(0);
				DealercomboBox.setSelectedIndex(0);
				
				viewvehiclespanel.setVisible(true);
			}
		});
		btnVehicles.setBounds(503, 122, 145, 50);
		mainmenupanel.add(btnVehicles);
		
		//ADMIN LOGIN SCREEN
		frmVehicleManagementSystem.getContentPane().add(adminloginpanel, "name_2540431319500");
		adminloginpanel.setLayout(null);
		
		JLabel lblAdmLogin = new JLabel("Admin Login");
		lblAdmLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmLogin.setBounds(277, 11, 150, 50);
		adminloginpanel.add(lblAdmLogin);
		
		AUsernameField = new JTextField();
		AUsernameField.setToolTipText("Enter username");
		AUsernameField.setBounds(295, 85, 117, 20);
		adminloginpanel.add(AUsernameField);
		AUsernameField.setColumns(10);
		
		APasswordField = new JPasswordField();
		APasswordField.setToolTipText("Enter password");
		APasswordField.setBounds(295, 143, 117, 20);
		adminloginpanel.add(APasswordField);
		APasswordField.setColumns(10);
		
		JLabel lblAUsername = new JLabel("Username :");
		lblAUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblAUsername.setBounds(188, 88, 97, 14);
		adminloginpanel.add(lblAUsername);
		
		JLabel lblAPassword = new JLabel("Password :");
		lblAPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblAPassword.setBounds(188, 146, 97, 14);
		adminloginpanel.add(lblAPassword);
		
		JButton btnAdminLogin = new JButton("Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=AUsernameField.getText();
				String pass= new String(APasswordField.getPassword());
				
				if(uname.equals("admin") && pass.equals("admin")) {
					JOptionPane.showMessageDialog(null, "Successfully Logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
					adminloginpanel.setVisible(false);
					
					//SHIFT HERE ADMIN CONTROL PANEL
					//ADMIN CONTROL PANEL
					JPanel controlpanel = new JPanel();
					controlpanel.setLayout(null);
					frmVehicleManagementSystem.getContentPane().add(controlpanel, "name_5499278845900");
					
					JLabel lblAdminControlPanel = new JLabel("Admin Control Panel");
					lblAdminControlPanel.setHorizontalAlignment(SwingConstants.CENTER);
					lblAdminControlPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblAdminControlPanel.setBounds(188, 11, 320, 50);
					controlpanel.add(lblAdminControlPanel);
					
					JButton btnLogout = new JButton("Logout");
					btnLogout.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							controlpanel.setVisible(false);
							controlpanel.removeAll();
							adminloginpanel.setVisible(true);
						}
					});
					btnLogout.setToolTipText("Go Back");
					btnLogout.setBounds(595, 11, 89, 23);
					controlpanel.add(btnLogout);
					
					JPanel displaypanel = new JPanel();
					displaypanel.setBounds(10, 72, 674, 318);
					controlpanel.add(displaypanel);
					displaypanel.setLayout(null);
					displaypanel.setVisible(false);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 11, 654, 250);
					displaypanel.add(scrollPane);
					
					//INITIALIZE BUTTONS
					table = new JTable();
					JButton Dealerbtn = new JButton("DELETE DEALER");
					Dealerbtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
										
							if(table.getSelectedRow() != -1) {
								//DELETE DEALER ACCOUNT
								int option= JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Dealer", JOptionPane.YES_NO_OPTION);
								if(option==JOptionPane.YES_OPTION) {
												
									d.deleteDealer((String) table.getValueAt(table.getSelectedRow(), 1), vh);
												
									d.displayAllDealers();
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames= {"Dealer ID","Username","Name","Region","Phone","Email"};
									table.setModel(new DefaultTableModel(columnNames,d.Did.size()));
														
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<d.Did.size();i++) {
										table.setValueAt(d.Did.get(i), i, 0);
										table.setValueAt(d.Duname.get(i), i, 1);
										table.setValueAt(d.Dname.get(i), i, 2);
										table.setValueAt(d.Dregion.get(i), i, 3);
										table.setValueAt(d.Dphone.get(i), i, 4);
										table.setValueAt(d.Demail.get(i), i, 5);
									}
									d.clearall();
														
									scrollPane.setViewportView(table);
												
									JOptionPane.showMessageDialog(null, "Dealer Deleted", "Delete Dealer", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "No Dealer Selected", "Delete Dealer", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					});
					Dealerbtn.setBounds(260, 272, 149, 35);
					displaypanel.add(Dealerbtn);
								
					JButton Customerbtn = new JButton("DELETE CUSTOMER");
					Customerbtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
										
							if(table.getSelectedRow() != -1) {
								//DELETE DEALER ACCOUNT
								int option= JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Customer", JOptionPane.YES_NO_OPTION);
								if(option==JOptionPane.YES_OPTION) {
												
									cs.deleteCustomer((String) table.getValueAt(table.getSelectedRow(), 1), vh);
												
									cs.displayAllCustomers();
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames= {"Customer ID","Username","Name","Region","Phone","Email"};
									table.setModel(new DefaultTableModel(columnNames,d.Did.size()));
														
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<cs.Cid.size();i++) {
										table.setValueAt(cs.Cid.get(i), i, 0);
										table.setValueAt(cs.Cuname.get(i), i, 1);
										table.setValueAt(cs.Cname.get(i), i, 2);
										table.setValueAt(cs.Cregion.get(i), i, 3);
										table.setValueAt(cs.Cphone.get(i), i, 4);
										table.setValueAt(cs.Cemail.get(i), i, 5);
									}
									cs.clearall();
														
									scrollPane.setViewportView(table);
												
									JOptionPane.showMessageDialog(null, "Customer Deleted", "Delete Customer", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "No Customer Selected", "Delete Customer", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					});
					Customerbtn.setBounds(260, 272, 149, 35);
					displaypanel.add(Customerbtn);

					JButton Vehiclebtn = new JButton("DELETE VEHICLE");
					Vehiclebtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
										
							if (table.getSelectedRow() != -1) {
								if(JOptionPane.showConfirmDialog(null, "Delete selected vehicle?", "Delete Vehicle", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
									vh.removeVehicle((String)table.getValueAt(table.getSelectedRow(), 0));
												
												
									vh.displayAllVehicles();
									table.removeAll();
									table = new JTable();
									table.setDefaultEditor(Object.class, null);
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									String[] columnNames= {"ID","Brand","Model","Type","Colour","Year","Fuel Type","Price(Rs.)","Status"};
									table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
												
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Vid.get(i), i, 0);
										table.setValueAt(vh.Vbrand.get(i), i, 1);
										table.setValueAt(vh.Vmodel.get(i), i, 2);
										table.setValueAt(vh.Vtype.get(i), i, 3);
										table.setValueAt(vh.Vcolor.get(i), i, 4);
										table.setValueAt(vh.Vyear.get(i), i, 5);
										table.setValueAt(vh.Vfuel.get(i), i, 6);
										table.setValueAt(vh.Vprice.get(i), i, 7);
										table.setValueAt(vh.Vstatus.get(i), i, 8);
									}
									vh.clearall();
												
									scrollPane.setViewportView(table);
									JOptionPane.showMessageDialog(null, "Vehicle deleted.", "Vehicle Deleted", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Select Vehicle from Table", "No Vehicle Selected", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					});
					Vehiclebtn.setBounds(260, 272, 149, 35);
					displaypanel.add(Vehiclebtn);

					Dealerbtn.setVisible(false);
					Customerbtn.setVisible(false);
					Vehiclebtn.setVisible(false);
					
					JComboBox<String> comboBox = new JComboBox<String>();
					comboBox.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(comboBox.getSelectedItem().equals("Dealer")) {
								
								//DISPLAY DEALERS WITH INFO	
								table.removeAll();
								d.displayAllDealers();
								table = new JTable();
								table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								table.setDefaultEditor(Object.class, null);
								String[] columnNames= {"Dealer ID","Username","Name","Region","Phone","Email"};
								table.setModel(new DefaultTableModel(columnNames,d.Did.size()));
										
								//ADDING ENTRIES IN TABLE
								for(int i=0;i<d.Did.size();i++) {
									table.setValueAt(d.Did.get(i), i, 0);
									table.setValueAt(d.Duname.get(i), i, 1);
									table.setValueAt(d.Dname.get(i), i, 2);
									table.setValueAt(d.Dregion.get(i), i, 3);
									table.setValueAt(d.Dphone.get(i), i, 4);
									table.setValueAt(d.Demail.get(i), i, 5);
								}
								d.clearall();
										
								scrollPane.setViewportView(table);
								
								Dealerbtn.setVisible(true);
								Customerbtn.setVisible(false);
								Vehiclebtn.setVisible(false);
								displaypanel.setVisible(true);
								
								
							}
							else if (comboBox.getSelectedItem().equals("Customer")) {
								
								//DISPLAY CUSTOMERS WITH INFO	
								table.removeAll();
								cs.displayAllCustomers();
								table = new JTable();
								table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								table.setDefaultEditor(Object.class, null);
								String[] columnNames= {"Customer ID","Username","Name","Region","Phone","Email"};
								table.setModel(new DefaultTableModel(columnNames,cs.Cid.size()));
										
								//ADDING ENTRIES IN TABLE
								for(int i=0;i<cs.Cid.size();i++) {
									table.setValueAt(cs.Cid.get(i), i, 0);
									table.setValueAt(cs.Cuname.get(i), i, 1);
									table.setValueAt(cs.Cname.get(i), i, 2);
									table.setValueAt(cs.Cregion.get(i), i, 3);
									table.setValueAt(cs.Cphone.get(i), i, 4);
									table.setValueAt(cs.Cemail.get(i), i, 5);
								}
								cs.clearall();
										
								scrollPane.setViewportView(table);
								
								Dealerbtn.setVisible(false);
								Customerbtn.setVisible(true);
								Vehiclebtn.setVisible(false);
								
								
								displaypanel.setVisible(true);
								
							}
							else if (comboBox.getSelectedItem().equals("Vehicle")) {
								
								//DISPLAY VEHICLES WITH INFO	
								table.removeAll();
								//TABLE SETUP FIRST TIME
								vh.displayAllVehicles();
								
								table = new JTable();
								table.setDefaultEditor(Object.class, null);
								table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								String[] columnNames= {"ID","Brand","Model","Type","Colour","Year","Fuel Type","Price(Rs.)","Status"};
								table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
								
								//ADDING ENTRIES IN TABLE
								for(int i=0;i<vh.Vid.size();i++) {
									table.setValueAt(vh.Vid.get(i), i, 0);
									table.setValueAt(vh.Vbrand.get(i), i, 1);
									table.setValueAt(vh.Vmodel.get(i), i, 2);
									table.setValueAt(vh.Vtype.get(i), i, 3);
									table.setValueAt(vh.Vcolor.get(i), i, 4);
									table.setValueAt(vh.Vyear.get(i), i, 5);
									table.setValueAt(vh.Vfuel.get(i), i, 6);
									table.setValueAt(vh.Vprice.get(i), i, 7);
									table.setValueAt(vh.Vstatus.get(i), i, 8);
								}
								vh.clearall();
								
								scrollPane.setViewportView(table);

								Dealerbtn.setVisible(false);
								Customerbtn.setVisible(false);
								Vehiclebtn.setVisible(true);
								
								//DELETE VEHICLE BUTTON
								
								displaypanel.setVisible(true);
							}
							else {
								displaypanel.setVisible(false);
							}
							
						}
					});
					comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Dealer", "Customer", "Vehicle"}));
					comboBox.setBounds(10, 42, 100, 20);
					controlpanel.add(comboBox);
					
					JLabel lblDisplay = new JLabel("DISPLAY");
					lblDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
					lblDisplay.setBounds(10, 15, 100, 29);
					controlpanel.add(lblDisplay);
					
					controlpanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username/Password.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				AUsernameField.setText("");
				APasswordField.setText("");
			}
		});
		btnAdminLogin.setBounds(295, 190, 117, 40);
		adminloginpanel.add(btnAdminLogin);
		
		JButton btnABack = new JButton("Back");
		btnABack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminloginpanel.setVisible(false);
				mainmenupanel.setVisible(true);
			}
		});
		btnABack.setToolTipText("Go Back");
		btnABack.setBounds(595, 11, 89, 23);
		adminloginpanel.add(btnABack);
		
		//DEALER MAIN MENU
		JPanel dealermenupanel = new JPanel();
		
		
		//DEALER LOGIN SCREEN
		dealerloginpanel.setLayout(null);
		frmVehicleManagementSystem.getContentPane().add(dealerloginpanel, "name_5094147174700");
		
		JLabel lblDealerLogin = new JLabel("Dealer Login");
		lblDealerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDealerLogin.setBounds(262, 11, 150, 50);
		dealerloginpanel.add(lblDealerLogin);
		
		DUsernameField = new JTextField();
		DUsernameField.setToolTipText("Enter username");
		DUsernameField.setColumns(10);
		DUsernameField.setBounds(295, 85, 117, 20);
		dealerloginpanel.add(DUsernameField);
		
		DPasswordField = new JPasswordField();
		DPasswordField.setToolTipText("Enter password");
		DPasswordField.setColumns(10);
		DPasswordField.setBounds(295, 143, 117, 20);
		dealerloginpanel.add(DPasswordField);
		
		JLabel lblDUsername = new JLabel("Username :");
		lblDUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblDUsername.setBounds(188, 88, 97, 14);
		dealerloginpanel.add(lblDUsername);
		
		JLabel lblDPassword = new JLabel("Password :");
		lblDPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblDPassword.setBounds(188, 146, 97, 14);
		dealerloginpanel.add(lblDPassword);
		
		JButton btnDLogin = new JButton("Login");
		btnDLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=DUsernameField.getText();
				String pass= new String(DPasswordField.getPassword());
				
				if(d.loginDealer(uname,pass,vh)) {
					JOptionPane.showMessageDialog(null, "Successfully Logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
					dealerloginpanel.setVisible(false);
					
					//---SHIFT IT HERE--- 411
					//DEALER MENU PANEL  ---SHIFT THIS LATER
					JPanel dealeraccountpanel = new JPanel();
					
					frmVehicleManagementSystem.getContentPane().add(dealermenupanel, "name_541275826900");
					dealermenupanel.setLayout(null);
					
					JLabel lblWelcomeDealer = new JLabel("DEALER MANAGEMENT");
					lblWelcomeDealer.setBounds(10, 11, 674, 100);
					lblWelcomeDealer.setHorizontalAlignment(SwingConstants.CENTER);
					lblWelcomeDealer.setForeground(Color.RED);
					lblWelcomeDealer.setFont(new Font("Tahoma", Font.BOLD, 30));
					lblWelcomeDealer.setBackground(Color.PINK);
					dealermenupanel.add(lblWelcomeDealer);
					
					JButton btnManageVehicles = new JButton("MANAGE VEHICLES");
					btnManageVehicles.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							//---INSERT VEHICLE PANEL HERE line 553
							//--SHIFT THIS---
							//VEHICLE MANAGE PAGE
							JPanel dealervehiclepanel = new JPanel();

							JPanel addvehiclepanel = new JPanel();

							frmVehicleManagementSystem.getContentPane().add(dealervehiclepanel, "name_5776815001600");
							dealervehiclepanel.setLayout(null);
							
							JLabel lblMyVehicles = new JLabel("My Vehicles");
							lblMyVehicles.setBounds(262, 11, 160, 50);
							lblMyVehicles.setHorizontalAlignment(SwingConstants.CENTER);
							lblMyVehicles.setFont(new Font("Tahoma", Font.BOLD, 20));
							dealervehiclepanel.add(lblMyVehicles);
							
							JButton button_2 = new JButton("Back");
							button_2.setBounds(595, 11, 89, 23);
							button_2.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									dealervehiclepanel.setVisible(false);
									dealervehiclepanel.removeAll();
									dealermenupanel.setVisible(true);
								}
							});
							button_2.setToolTipText("Go Back");
							dealervehiclepanel.add(button_2);
							
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(10, 72, 674, 245);
							dealervehiclepanel.add(scrollPane);
							
							//TABLE SETUP FIRST TIME
							vh.vehicleDetails(d.DealerDetails(0));
							table = new JTable();
							table.setDefaultEditor(Object.class, null);
							table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							String[] columnNames= {"ID","Brand","Model","Type","Colour","Year","Fuel Type","Price(Rs.)","Status"};
							table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
							
							//ADDING ENTRIES IN TABLE
							for(int i=0;i<vh.Vid.size();i++) {
								table.setValueAt(vh.Vid.get(i), i, 0);
								table.setValueAt(vh.Vbrand.get(i), i, 1);
								table.setValueAt(vh.Vmodel.get(i), i, 2);
								table.setValueAt(vh.Vtype.get(i), i, 3);
								table.setValueAt(vh.Vcolor.get(i), i, 4);
								table.setValueAt(vh.Vyear.get(i), i, 5);
								table.setValueAt(vh.Vfuel.get(i), i, 6);
								table.setValueAt(vh.Vprice.get(i), i, 7);
								table.setValueAt(vh.Vstatus.get(i), i, 8);
							}
							vh.clearall();
							
							scrollPane.setViewportView(table);
							
							
							JButton btnNewButton_1 = new JButton("Add Vehicle");
							btnNewButton_1.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									dealervehiclepanel.setVisible(false);
									addvehiclepanel.setVisible(true);
								}
							});
							btnNewButton_1.setBounds(147, 328, 150, 36);
							dealervehiclepanel.add(btnNewButton_1);
							
							//DELETE VEHICLE BUTTON
							JButton btnDeleteVehicle = new JButton("Delete Vehicle");
							btnDeleteVehicle.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									if (table.getSelectedRow() != -1) {
										if(JOptionPane.showConfirmDialog(null, "Delete selected vehicle?", "Delete Vehicle", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
											vh.removeVehicle((String)table.getValueAt(table.getSelectedRow(), 0));
											JOptionPane.showMessageDialog(null, "Vehicle deleted.", "Vehicle Deleted", JOptionPane.INFORMATION_MESSAGE);
				
											
											vh.vehicleDetails(d.DealerDetails(0));
											table.removeAll();
											table = new JTable();
											table.setDefaultEditor(Object.class, null);
											table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											String[] columnNames= {"ID","Brand","Model","Type","Colour","Year","Fuel Type","Price(Rs.)","Status"};
											table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
											
											//ADDING ENTRIES IN TABLE
											for(int i=0;i<vh.Vid.size();i++) {
												table.setValueAt(vh.Vid.get(i), i, 0);
												table.setValueAt(vh.Vbrand.get(i), i, 1);
												table.setValueAt(vh.Vmodel.get(i), i, 2);
												table.setValueAt(vh.Vtype.get(i), i, 3);
												table.setValueAt(vh.Vcolor.get(i), i, 4);
												table.setValueAt(vh.Vyear.get(i), i, 5);
												table.setValueAt(vh.Vfuel.get(i), i, 6);
												table.setValueAt(vh.Vprice.get(i), i, 7);
												table.setValueAt(vh.Vstatus.get(i), i, 8);
											}
											vh.clearall();
											
											scrollPane.setViewportView(table);
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Select Vehicle from Table", "No Vehicle Selected", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnDeleteVehicle.setBounds(395, 328, 150, 36);
							dealervehiclepanel.add(btnDeleteVehicle);
							
							//ADD VEHICLE PANEL
							addvehiclepanel.setLayout(null);
							frmVehicleManagementSystem.getContentPane().add(addvehiclepanel, "name_3262598030600");
							
							JLabel lblAddVehicle = new JLabel("Add Vehicle");
							lblAddVehicle.setHorizontalAlignment(SwingConstants.CENTER);
							lblAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 20));
							lblAddVehicle.setBounds(262, 11, 163, 50);
							addvehiclepanel.add(lblAddVehicle);
							
							modelField = new JTextField();
							modelField.setToolTipText("");
							modelField.setColumns(10);
							modelField.setBounds(295, 116, 117, 20);
							addvehiclepanel.add(modelField);
							
							JLabel lblBrand = new JLabel("Brand :");
							lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
							lblBrand.setBounds(188, 88, 97, 14);
							addvehiclepanel.add(lblBrand);
							
							JLabel lblModel = new JLabel("Model :");
							lblModel.setHorizontalAlignment(SwingConstants.CENTER);
							lblModel.setBounds(188, 119, 97, 14);
							addvehiclepanel.add(lblModel);
							
							JLabel lblType = new JLabel("Type :");
							lblType.setHorizontalAlignment(SwingConstants.CENTER);
							lblType.setBounds(188, 150, 97, 14);
							addvehiclepanel.add(lblType);
							
							JLabel lblColour = new JLabel("Colour :");
							lblColour.setHorizontalAlignment(SwingConstants.CENTER);
							lblColour.setBounds(188, 182, 97, 14);
							addvehiclepanel.add(lblColour);
							
							JLabel lblYear = new JLabel("Year :");
							lblYear.setHorizontalAlignment(SwingConstants.CENTER);
							lblYear.setBounds(188, 214, 97, 14);
							addvehiclepanel.add(lblYear);
							
							JLabel lblFuelType = new JLabel("Fuel Type :");
							lblFuelType.setHorizontalAlignment(SwingConstants.CENTER);
							lblFuelType.setBounds(188, 245, 97, 14);
							addvehiclepanel.add(lblFuelType);
							
							JComboBox<String> yearcomboBox = new JComboBox<String>();
							yearcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"}));
							yearcomboBox.setToolTipText("");
							yearcomboBox.setBounds(295, 211, 117, 22);
							addvehiclepanel.add(yearcomboBox);
							
							JComboBox<String> fuelcomboBox = new JComboBox<String>();
							fuelcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Petrol", "Diesel", "Petrol/Diesel", "CNG", "Electric"}));
							fuelcomboBox.setToolTipText("");
							fuelcomboBox.setBounds(295, 245, 117, 22);
							addvehiclepanel.add(fuelcomboBox);
							
							JComboBox<String> brandcomboBox = new JComboBox<String>();
							brandcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Toyota", "Honda", "Ford", "Volkswagen", "Nissan", "Chevrolet", "Hyundai", "Renault", "Skoda", "Fiat", "Tata", "Jeep", "Ferrari", "Lamborghini", "Bugatti", "BMW", "Maruti", "Tesla"}));
							brandcomboBox.setToolTipText("");
							brandcomboBox.setBounds(295, 84, 117, 22);
							addvehiclepanel.add(brandcomboBox);
							
							JComboBox<String> typecomboBox = new JComboBox<String>();
							typecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Hatchback", "Sedan", "MPV", "SUV", "Convertible", "Pickup", "Coupe"}));
							typecomboBox.setToolTipText("");
							typecomboBox.setBounds(295, 147, 117, 22);
							addvehiclepanel.add(typecomboBox);
							
							JLabel lblPrice = new JLabel("Price :");
							lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
							lblPrice.setBounds(188, 281, 97, 14);
							addvehiclepanel.add(lblPrice);
							
							priceField = new JTextField();
							priceField.setToolTipText("");
							priceField.setColumns(10);
							priceField.setBounds(295, 278, 117, 20);
							addvehiclepanel.add(priceField);
							
							colorField = new JTextField();
							colorField.setToolTipText("");
							colorField.setColumns(10);
							colorField.setBounds(295, 179, 117, 20);
							addvehiclepanel.add(colorField);
							
							//ADD NEW VEHICLE BUTTON
							JButton btnAdd = new JButton("Add");
							btnAdd.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									String brand=(String) brandcomboBox.getSelectedItem();
									String model= modelField.getText();
									String type= (String) typecomboBox.getSelectedItem();
									String color = colorField.getText();
									String year = (String) yearcomboBox.getSelectedItem();
									String fuel = (String) fuelcomboBox.getSelectedItem();
									String price = priceField.getText();
									if(brand=="" || model=="" || type=="" || color=="" || year=="" || fuel=="" || price=="" ) {
										JOptionPane.showMessageDialog(null, "Fill All Details.", "Failure", JOptionPane.INFORMATION_MESSAGE);
									}
									else {
										vh.addVehicle(d.DealerDetails(0), Integer.valueOf(d.DealerDetails(5)), brand, model, type, year, color, fuel, price);
										JOptionPane.showMessageDialog(null, "Vehicle Added.", "Success", JOptionPane.INFORMATION_MESSAGE);
										modelField.setText("");
										colorField.setText("");
										priceField.setText("");
										brandcomboBox.setSelectedIndex(0);
										typecomboBox.setSelectedIndex(0);
										yearcomboBox.setSelectedIndex(0);
										fuelcomboBox.setSelectedIndex(0);
										addvehiclepanel.setVisible(false);
										dealervehiclepanel.setVisible(true);
										
										
										vh.vehicleDetails(d.DealerDetails(0));
										table.removeAll();
										table = new JTable();
										table.setDefaultEditor(Object.class, null);
										table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										String[] columnNames= {"ID","Brand","Model","Type","Colour","Year","Fuel Type","Price(Rs.)","Status"};
										table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
										
										//ADDING ENTRIES IN TABLE
										for(int i=0;i<vh.Vid.size();i++) {
											table.setValueAt(vh.Vid.get(i), i, 0);
											table.setValueAt(vh.Vbrand.get(i), i, 1);
											table.setValueAt(vh.Vmodel.get(i), i, 2);
											table.setValueAt(vh.Vtype.get(i), i, 3);
											table.setValueAt(vh.Vcolor.get(i), i, 4);
											table.setValueAt(vh.Vyear.get(i), i, 5);
											table.setValueAt(vh.Vfuel.get(i), i, 6);
											table.setValueAt(vh.Vprice.get(i), i, 7);
											table.setValueAt(vh.Vstatus.get(i), i, 8);
										}
										vh.clearall();
										
										scrollPane.setViewportView(table);
									}
								}
							});
							btnAdd.setToolTipText("");
							btnAdd.setBounds(295, 315, 117, 40);
							addvehiclepanel.add(btnAdd);
							
							JButton button_3 = new JButton("Back");
							button_3.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									addvehiclepanel.setVisible(false);
									dealervehiclepanel.setVisible(true);
								}
							});
							button_3.setToolTipText("Go Back");
							button_3.setBounds(595, 11, 89, 23);
							addvehiclepanel.add(button_3);
							dealervehiclepanel.setVisible(true);
							dealermenupanel.setVisible(false);
						}
					});
					btnManageVehicles.setBounds(38, 122, 200, 50);
					dealermenupanel.add(btnManageVehicles);
					
					JButton btnCustomerRequests = new JButton("CUSTOMER REQUESTS");
					btnCustomerRequests.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							//CUSTOMER REQUESTS SCREEN
							JPanel dealercustomerpanel = new JPanel();

							JPanel addvehiclepanel = new JPanel();

							frmVehicleManagementSystem.getContentPane().add(dealercustomerpanel, "name_5776815001600");
							dealercustomerpanel.setLayout(null);
							
							JLabel lblMyCustomers = new JLabel("My Customers");
							lblMyCustomers.setBounds(262, 11, 160, 50);
							lblMyCustomers.setHorizontalAlignment(SwingConstants.CENTER);
							lblMyCustomers.setFont(new Font("Tahoma", Font.BOLD, 20));
							dealercustomerpanel.add(lblMyCustomers);
							
							JButton button_2 = new JButton("Back");
							button_2.setBounds(595, 11, 89, 23);
							button_2.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									dealercustomerpanel.setVisible(false);
									dealermenupanel.setVisible(true);
								}
							});
							button_2.setToolTipText("Go Back");
							dealercustomerpanel.add(button_2);
							
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(10, 72, 674, 245);
							dealercustomerpanel.add(scrollPane);
							
							//TABLE SETUP FIRST TIME
							vh.requestDetails(d.DealerDetails(0));
							table = new JTable();
							table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							table.setDefaultEditor(Object.class, null);
							String[] columnNames= {"Customer ID","Customer Username","Vehicle ID","Vehicle Brand","Vehicle Model","Price","Status"};
							table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
							
							//ADDING ENTRIES IN TABLE
							for(int i=0;i<vh.Vid.size();i++) {
								table.setValueAt(vh.Cid.get(i), i, 0);
								table.setValueAt(vh.Cname.get(i), i, 1);
								table.setValueAt(vh.Vid.get(i), i, 2);
								table.setValueAt(vh.Vbrand.get(i), i, 3);
								table.setValueAt(vh.Vmodel.get(i), i, 4);
								table.setValueAt(vh.Vprice.get(i), i, 5);
								table.setValueAt(vh.Vstatus.get(i), i, 6);
							}
							vh.clearall();
							
							scrollPane.setViewportView(table);
							
							//DISPLAY CUSTOMER INFO BUTTON
							JButton btnNewButton_1 = new JButton("Customer Info");
							btnNewButton_1.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (table.getSelectedRow() != -1) {
									
										cs.findCustomer((String) table.getValueAt(table.getSelectedRow(), 1));
											
										JPanel customerinfopanel = new JPanel();
										customerinfopanel.setLayout(null);
										frmVehicleManagementSystem.getContentPane().add(customerinfopanel, "name_66305818664800");
										
										JLabel lblCustomerDetails = new JLabel("Customer Details");
										lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
										lblCustomerDetails.setBounds(234, 11, 223, 50);
										customerinfopanel.add(lblCustomerDetails);
										
										JLabel label_2 = new JLabel("Username :");
										label_2.setHorizontalAlignment(SwingConstants.CENTER);
										label_2.setBounds(188, 116, 97, 14);
										customerinfopanel.add(label_2);
										
										JButton button = new JButton("Back");
										button.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												customerinfopanel.setVisible(false);
												dealercustomerpanel.setVisible(true);
											}
										});
										button.setToolTipText("Go Back");
										button.setBounds(595, 11, 89, 23);
										customerinfopanel.add(button);
										
										JLabel label_7 = new JLabel("Name :");
										label_7.setHorizontalAlignment(SwingConstants.CENTER);
										label_7.setBounds(188, 141, 97, 14);
										customerinfopanel.add(label_7);
										
										JLabel label_8 = new JLabel(" Region :");
										label_8.setHorizontalAlignment(SwingConstants.CENTER);
										label_8.setBounds(188, 166, 97, 14);
										customerinfopanel.add(label_8);
										
										JLabel label_9 = new JLabel("Phone No :");
										label_9.setHorizontalAlignment(SwingConstants.CENTER);
										label_9.setBounds(188, 191, 97, 14);
										customerinfopanel.add(label_9);
										
										JLabel label_10 = new JLabel("Email :");
										label_10.setHorizontalAlignment(SwingConstants.CENTER);
										label_10.setBounds(188, 216, 97, 14);
										customerinfopanel.add(label_10);
										
										JLabel label_11 = new JLabel(cs.CustomerDetails(0));
										label_11.setBounds(295, 116, 162, 14);
										customerinfopanel.add(label_11);
										
										JLabel label_12 = new JLabel(cs.CustomerDetails(1));
										label_12.setBounds(295, 141, 162, 14);
										customerinfopanel.add(label_12);
										
										JLabel label_13 = new JLabel(cs.CustomerDetails(2));
										label_13.setBounds(295, 166, 162, 14);
										customerinfopanel.add(label_13);
										
										JLabel label_14 = new JLabel(cs.CustomerDetails(3));
										label_14.setBounds(295, 191, 162, 14);
										customerinfopanel.add(label_14);
										
										JLabel label_15 = new JLabel(cs.CustomerDetails(4));
										label_15.setBounds(295, 216, 162, 14);
										customerinfopanel.add(label_15);
										
										JLabel lblCustomerId = new JLabel("Customer ID :");
										lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerId.setBounds(188, 91, 97, 14);
										customerinfopanel.add(lblCustomerId);
										
										JLabel label_17 = new JLabel(cs.CustomerDetails(5));
										label_17.setBounds(295, 91, 162, 14);
										customerinfopanel.add(label_17);
										
										customerinfopanel.setVisible(true);
										dealercustomerpanel.setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(null, "Select Customer from Table.", "No Customer Selected", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnNewButton_1.setBounds(147, 328, 150, 36);
							dealercustomerpanel.add(btnNewButton_1);
							
							//ACCEPT DENY BUTTON
							JButton btnAcceptRequest = new JButton("Accept/Deny");
							btnAcceptRequest.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (table.getSelectedRow() != -1 && table.getValueAt(table.getSelectedRow(), 6).equals("Pending")) {
										int option= JOptionPane.showConfirmDialog(null, "Accept Offer?", "Manage Requests", JOptionPane.YES_NO_CANCEL_OPTION);
										if(option==JOptionPane.YES_OPTION) {
											String ID = (String) table.getValueAt(table.getSelectedRow(), 2);
											
											vh.acceptRequest(d.DealerDetails(0), Integer.parseInt(ID));
											vh.requestDetails(d.DealerDetails(0));
											table.removeAll();
											table = new JTable();
											table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											table.setDefaultEditor(Object.class, null);
											String[] columnNames= {"Customer ID","Customer Username","Vehicle ID","Vehicle Brand","Vehicle Model","Price","Status"};
											table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
											
											//ADDING ENTRIES IN TABLE
											for(int i=0;i<vh.Vid.size();i++) {
												table.setValueAt(vh.Cid.get(i), i, 0);
												table.setValueAt(vh.Cname.get(i), i, 1);
												table.setValueAt(vh.Vid.get(i), i, 2);
												table.setValueAt(vh.Vbrand.get(i), i, 3);
												table.setValueAt(vh.Vmodel.get(i), i, 4);
												table.setValueAt(vh.Vprice.get(i), i, 5);
												table.setValueAt(vh.Vstatus.get(i), i, 6);
											}
											vh.clearall();
											
											
											scrollPane.setViewportView(table);
											JOptionPane.showMessageDialog(null, "Offer Accepted.", "Accepted", JOptionPane.INFORMATION_MESSAGE);
										}

										else if(option==JOptionPane.NO_OPTION){
											
											vh.denyRequest(d.DealerDetails(0), Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 2)));
											vh.requestDetails(d.DealerDetails(0));
											table.removeAll();
											table = new JTable();
											table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											table.setDefaultEditor(Object.class, null);
											String[] columnNames= {"Customer ID","Customer Username","Vehicle ID","Vehicle Brand","Vehicle Model","Price","Status"};
											table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
											
											//ADDING ENTRIES IN TABLE
											for(int i=0;i<vh.Vid.size();i++) {
												table.setValueAt(vh.Cid.get(i), i, 0);
												table.setValueAt(vh.Cname.get(i), i, 1);
												table.setValueAt(vh.Vid.get(i), i, 2);
												table.setValueAt(vh.Vbrand.get(i), i, 3);
												table.setValueAt(vh.Vmodel.get(i), i, 4);
												table.setValueAt(vh.Vprice.get(i), i, 5);
												table.setValueAt(vh.Vstatus.get(i), i, 6);
											}
											vh.clearall();
											
											
											scrollPane.setViewportView(table);
											
											JOptionPane.showMessageDialog(null, "Offer Rejected.", "Denied", JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else if(table.getSelectedRow() == -1) {
										JOptionPane.showMessageDialog(null, "Select Request from Table.", "No Request Selected", JOptionPane.INFORMATION_MESSAGE);
									}
									else {
										JOptionPane.showMessageDialog(null, "Request already Accepted/Denied.", "Already Done", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnAcceptRequest.setBounds(395, 328, 150, 36);
							dealercustomerpanel.add(btnAcceptRequest);
							
							JButton button_3 = new JButton("Back");
							button_3.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									addvehiclepanel.setVisible(false);
									dealercustomerpanel.setVisible(true);
								}
							});
							button_3.setToolTipText("Go Back");
							button_3.setBounds(595, 11, 89, 23);
							addvehiclepanel.add(button_3);
							
							dealercustomerpanel.setVisible(true);
							dealermenupanel.setVisible(false);
							
						}
					});
					btnCustomerRequests.setBounds(248, 122, 200, 50);
					dealermenupanel.add(btnCustomerRequests);
					
					JButton btnMyAccount = new JButton("MY ACCOUNT");
					btnMyAccount.setBounds(458, 122, 200, 50);
					btnMyAccount.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dealermenupanel.setVisible(false);
							dealeraccountpanel.setVisible(true);
						}
					});
					dealermenupanel.add(btnMyAccount);
					
					JLabel lblNewLabel = new JLabel("Welcome, "+d.DealerDetails(0));
					lblNewLabel.setBounds(536, 359, 148, 31);
					lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
					dealermenupanel.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("Logout");
					btnNewButton.setBounds(595, 11, 89, 23);
					btnNewButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dealermenupanel.setVisible(false);
							dealermenupanel.removeAll();
							dealerloginpanel.setVisible(true);
						}
					});
					dealermenupanel.add(btnNewButton);
					
					//ACCOUNT DETAILS PAGE
					dealeraccountpanel.setLayout(null);
					frmVehicleManagementSystem.getContentPane().add(dealeraccountpanel, "name_2190897499400");
					
					JLabel lblAccountDetails = new JLabel("Account Details");
					lblAccountDetails.setHorizontalAlignment(SwingConstants.CENTER);
					lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblAccountDetails.setBounds(234, 11, 223, 50);
					dealeraccountpanel.add(lblAccountDetails);
					
					JLabel label_1 = new JLabel("Username :");
					label_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_1.setBounds(188, 116, 97, 14);
					dealeraccountpanel.add(label_1);
					
					JButton button_1 = new JButton("Back");
					button_1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dealeraccountpanel.setVisible(false);
							dealermenupanel.setVisible(true);
						}
					});
					button_1.setToolTipText("Go Back");
					button_1.setBounds(595, 11, 89, 23);
					dealeraccountpanel.add(button_1);
					
					JButton btnDeleteAccount = new JButton("Delete Account");
					btnDeleteAccount.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							//DELETE DEALER ACCOUNT
							int option= JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Account", JOptionPane.YES_NO_OPTION);
							if(option==JOptionPane.YES_OPTION) {
								
								d.deleteDealer(d.DealerDetails(0), vh);
								
								JOptionPane.showMessageDialog(null, "Account Deleted", "Delete Account", JOptionPane.INFORMATION_MESSAGE);
								dealeraccountpanel.setVisible(false);
								dealeraccountpanel.removeAll();
								dealerloginpanel.setVisible(true);
							}
						}
					});
					btnDeleteAccount.setToolTipText("");
					btnDeleteAccount.setBounds(521, 356, 150, 23);
					dealeraccountpanel.add(btnDeleteAccount);
					
					JLabel label_3 = new JLabel("Name :");
					label_3.setHorizontalAlignment(SwingConstants.CENTER);
					label_3.setBounds(188, 141, 97, 14);
					dealeraccountpanel.add(label_3);
					
					JLabel label_4 = new JLabel(" Region :");
					label_4.setHorizontalAlignment(SwingConstants.CENTER);
					label_4.setBounds(188, 166, 97, 14);
					dealeraccountpanel.add(label_4);
					
					JLabel label_5 = new JLabel("Phone No :");
					label_5.setHorizontalAlignment(SwingConstants.CENTER);
					label_5.setBounds(188, 191, 97, 14);
					dealeraccountpanel.add(label_5);
					
					JLabel label_6 = new JLabel("Email :");
					label_6.setHorizontalAlignment(SwingConstants.CENTER);
					label_6.setBounds(188, 216, 97, 14);
					dealeraccountpanel.add(label_6);
					
					JLabel lblUsername = new JLabel(d.DealerDetails(0));
					lblUsername.setBounds(295, 116, 162, 14);
					dealeraccountpanel.add(lblUsername);
					
					JLabel lblNewLabel_1 = new JLabel(d.DealerDetails(1));
					lblNewLabel_1.setBounds(295, 141, 162, 14);
					dealeraccountpanel.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel(d.DealerDetails(2));
					lblNewLabel_2.setBounds(295, 166, 162, 14);
					dealeraccountpanel.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel(d.DealerDetails(3));
					lblNewLabel_3.setBounds(295, 191, 162, 14);
					dealeraccountpanel.add(lblNewLabel_3);
					
					JLabel lblNewLabel_4 = new JLabel(d.DealerDetails(4));
					lblNewLabel_4.setBounds(295, 216, 162, 14);
					dealeraccountpanel.add(lblNewLabel_4);
					
					JLabel lblDealerId = new JLabel("Dealer ID :");
					lblDealerId.setHorizontalAlignment(SwingConstants.CENTER);
					lblDealerId.setBounds(188, 91, 97, 14);
					dealeraccountpanel.add(lblDealerId);
					
					JLabel lblNewLabel_5 = new JLabel(d.DealerDetails(5));
					lblNewLabel_5.setBounds(295, 91, 162, 14);
					dealeraccountpanel.add(lblNewLabel_5);
					
					
					
					dealermenupanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username/Password.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				DUsernameField.setText("");
				DPasswordField.setText("");
			}
		});
		btnDLogin.setBounds(295, 190, 117, 40);
		dealerloginpanel.add(btnDLogin);
		
		JButton btnDBack = new JButton("Back");
		btnDBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dealerloginpanel.setVisible(false);
				mainmenupanel.setVisible(true);
			}
		});
		btnDBack.setToolTipText("Go Back");
		btnDBack.setBounds(595, 11, 89, 23);
		dealerloginpanel.add(btnDBack);
		
		JButton btnDSignUp = new JButton("New User?");
		btnDSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dealernewpanel.setVisible(true);
				dealerloginpanel.setVisible(false);
			}
		});
		btnDSignUp.setToolTipText("Sign Up");
		btnDSignUp.setBounds(295, 252, 117, 23);
		dealerloginpanel.add(btnDSignUp);
		
		//DEALER SIGN UP SCREEN
		dealernewpanel.setLayout(null);
		
		frmVehicleManagementSystem.getContentPane().add(dealernewpanel, "name_3822038150400");
		
		JComboBox<String> comboBoxDNRegion = new JComboBox<String>();
		comboBoxDNRegion.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Mumbai City", "Mumbai Suburban", "Thane", "Palghar", "Raigad", "Ratnagiri", "Sindhudurg", "Kolhapur", "Pune", "Sangli", "Satara", "Solapur"}));
		comboBoxDNRegion.setToolTipText("Select Region");
		comboBoxDNRegion.setBounds(295, 178, 117, 22);
		dealernewpanel.add(comboBoxDNRegion);
		
		JLabel lblDealerSignUp = new JLabel("Dealer Sign Up");
		lblDealerSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerSignUp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDealerSignUp.setBounds(262, 11, 163, 50);
		dealernewpanel.add(lblDealerSignUp);
		
		DNUsernameField = new JTextField();
		DNUsernameField.setToolTipText("Enter username");
		DNUsernameField.setColumns(10);
		DNUsernameField.setBounds(295, 85, 117, 20);
		dealernewpanel.add(DNUsernameField);
		
		DNPasswordField = new JPasswordField();
		DNPasswordField.setToolTipText("Enter password");
		DNPasswordField.setColumns(10);
		DNPasswordField.setBounds(295, 116, 117, 20);
		dealernewpanel.add(DNPasswordField);
		
		JLabel lblDNUsername = new JLabel("Username :");
		lblDNUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNUsername.setBounds(188, 88, 97, 14);
		dealernewpanel.add(lblDNUsername);
		
		JLabel lblDNPassword = new JLabel("Password :");
		lblDNPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNPassword.setBounds(188, 119, 97, 14);
		dealernewpanel.add(lblDNPassword);
		
		JButton btnDNRegister = new JButton("Register");
		btnDNRegister.setToolTipText("Create Account");
		btnDNRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=DNUsernameField.getText();
				String pass= new String(DNPasswordField.getPassword());
				String name=txtDNName.getText();
				String region =(String) comboBoxDNRegion.getSelectedItem();
				String phone = txtDNPhone.getText();
				String email = txtDNEmail.getText();
				if(uname.equals("") || pass.equals("") || name.equals("") || region.equals("") || phone.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill All Entries.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(d.checkDUsername(uname)) {
					JOptionPane.showMessageDialog(null, "Username Already Taken.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					d.addDealer(uname, pass, name, region, phone, email);
					JOptionPane.showMessageDialog(null, "New Account Created.", "Success", JOptionPane.INFORMATION_MESSAGE);
					DNUsernameField.setText("");
					DNPasswordField.setText("");
					txtDNName.setText("");
					comboBoxDNRegion.setSelectedIndex(0);
					txtDNPhone.setText("");
					txtDNEmail.setText("");
					dealernewpanel.setVisible(false);
					dealerloginpanel.setVisible(true);
				}
			}
		});
		btnDNRegister.setBounds(295, 273, 117, 40);
		dealernewpanel.add(btnDNRegister);
		
		JButton DNBack = new JButton("Back");
		DNBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dealernewpanel.setVisible(false);
				dealerloginpanel.setVisible(true);
			}
		});
		DNBack.setToolTipText("Go Back");
		DNBack.setBounds(595, 11, 89, 23);
		dealernewpanel.add(DNBack);
		
		JButton btnDNLogin = new JButton("Login");
		btnDNLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dealernewpanel.setVisible(false);
				dealerloginpanel.setVisible(true);
			}
		});
		btnDNLogin.setToolTipText("Login");
		btnDNLogin.setBounds(295, 324, 117, 23);
		dealernewpanel.add(btnDNLogin);
		
		txtDNName = new JTextField();
		txtDNName.setToolTipText("Enter name");
		txtDNName.setColumns(10);
		txtDNName.setBounds(295, 147, 117, 20);
		dealernewpanel.add(txtDNName);
		
		txtDNPhone = new JTextField();
		txtDNPhone.setToolTipText("Enter phone number");
		txtDNPhone.setColumns(10);
		txtDNPhone.setBounds(295, 211, 117, 20);
		dealernewpanel.add(txtDNPhone);
		
		txtDNEmail = new JTextField();
		txtDNEmail.setToolTipText("Enter email");
		txtDNEmail.setColumns(10);
		txtDNEmail.setBounds(295, 242, 117, 20);
		dealernewpanel.add(txtDNEmail);
		
		JLabel lblDNName = new JLabel("Name :");
		lblDNName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNName.setBounds(188, 150, 97, 14);
		dealernewpanel.add(lblDNName);
		
		JLabel lblDNRegion = new JLabel(" Region :");
		lblDNRegion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNRegion.setBounds(188, 182, 97, 14);
		dealernewpanel.add(lblDNRegion);
		
		JLabel lblDNPhoneNo = new JLabel("Phone No :");
		lblDNPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNPhoneNo.setBounds(188, 214, 97, 14);
		dealernewpanel.add(lblDNPhoneNo);
		
		JLabel lblDNEmail = new JLabel("Email :");
		lblDNEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNEmail.setBounds(188, 245, 97, 14);
		dealernewpanel.add(lblDNEmail);
		
		
		//CUSTOMER LOGIN PANEL
		customerloginpanel.setLayout(null);
		frmVehicleManagementSystem.getContentPane().add(customerloginpanel, "name_72365974148100");
		
		JLabel lblCustomerLogin = new JLabel("Customer Login");
		lblCustomerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerLogin.setBounds(245, 11, 206, 50);
		customerloginpanel.add(lblCustomerLogin);
		
		CUsernameField = new JTextField();
		CUsernameField.setToolTipText("Enter username");
		CUsernameField.setColumns(10);
		CUsernameField.setBounds(295, 85, 117, 20);
		customerloginpanel.add(CUsernameField);
		
		CPasswordField = new JPasswordField();
		CPasswordField.setToolTipText("Enter password");
		CPasswordField.setColumns(10);
		CPasswordField.setBounds(295, 143, 117, 20);
		customerloginpanel.add(CPasswordField);
		
		JLabel label_1 = new JLabel("Username :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(188, 88, 97, 14);
		customerloginpanel.add(label_1);
		
		JLabel label_2 = new JLabel("Password :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(188, 146, 97, 14);
		customerloginpanel.add(label_2);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=CUsernameField.getText();
				String pass=new String(CPasswordField.getPassword());
				
				if(cs.loginCustomer(uname,pass,vh)) {
					JOptionPane.showMessageDialog(null, "Successfully Logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
					customerloginpanel.setVisible(false);
					
					//---SHIFT HERE LATER--- line 1301
					//SHIFT THIS LATER---
					JPanel customeraccountpanel = new JPanel();
					JPanel customermenupanel= new JPanel();
					
					
					frmVehicleManagementSystem.getContentPane().add(customermenupanel, "name_74230302929200");
					customermenupanel.setLayout(null);
					
					
					//CUSTOMER MAIN MENU

					JLabel lblWelcomeCustomer = new JLabel("CUSTOMER MANAGEMENT");
					lblWelcomeCustomer.setBounds(10, 11, 674, 100);
					lblWelcomeCustomer.setHorizontalAlignment(SwingConstants.CENTER);
					lblWelcomeCustomer.setForeground(Color.GREEN);
					lblWelcomeCustomer.setFont(new Font("Tahoma", Font.BOLD, 30));
					lblWelcomeCustomer.setBackground(Color.PINK);
					customermenupanel.add(lblWelcomeCustomer);
					
					JButton btnViewVehicles = new JButton("VIEW VEHICLES");
					btnViewVehicles.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							customermenupanel.setVisible(false);
							
							//VIEW VEHICLE PANEL
							JPanel viewvehiclespanel = new JPanel();
							viewvehiclespanel.setLayout(null);
							frmVehicleManagementSystem.getContentPane().add(viewvehiclespanel, "name_35127525940900");
							
							JLabel lblVehicleList = new JLabel("Vehicle List");
							lblVehicleList.setHorizontalAlignment(SwingConstants.CENTER);
							lblVehicleList.setFont(new Font("Tahoma", Font.BOLD, 20));
							lblVehicleList.setBounds(262, 11, 160, 50);
							viewvehiclespanel.add(lblVehicleList);
							
							JButton button_6 = new JButton("Back");
							button_6.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									viewvehiclespanel.setVisible(false);
									customermenupanel.setVisible(true);
								}
							});
							button_6.setToolTipText("Go Back");
							button_6.setBounds(595, 11, 89, 23);
							viewvehiclespanel.add(button_6);
							
							JScrollPane scrollPane_1 = new JScrollPane();
							scrollPane_1.setBounds(10, 72, 674, 245);
							viewvehiclespanel.add(scrollPane_1);
							
							
							//TABLE SETUP FIRST TIME
							vh.displayAllVehicles();
							table = new JTable();
							table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							table.setDefaultEditor(Object.class, null);
							String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
							table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
									
							//ADDING ENTRIES IN TABLE
							for(int i=0;i<vh.Vid.size();i++) {
								table.setValueAt(vh.Did.get(i), i, 0);
								table.setValueAt(vh.Dname.get(i), i, 1);
								table.setValueAt(vh.Vid.get(i), i, 2);
								table.setValueAt(vh.Vbrand.get(i), i, 3);
								table.setValueAt(vh.Vmodel.get(i), i, 4);
								table.setValueAt(vh.Vtype.get(i), i, 5);
								table.setValueAt(vh.Vcolor.get(i), i, 6);
								table.setValueAt(vh.Vyear.get(i), i, 7);
								table.setValueAt(vh.Vfuel.get(i), i, 8);
								table.setValueAt(vh.Vprice.get(i), i, 9);
								table.setValueAt(vh.Vstatus.get(i), i, 10);
							}
							vh.clearall();
									
							scrollPane_1.setViewportView(table);
							
							//TOGGLE BUTTONS
							JButton btnDisplayVehicles = new JButton("Display Vehicles");
							JButton btnDisplayDealers = new JButton("Display Dealers");
							
							
							btnDisplayDealers.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//DISPLAY DEALERS WITH INFO	
									
									d.displayAllDealers();
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames= {"Dealer ID","Username","Name","Region","Phone","Email"};
									table.setModel(new DefaultTableModel(columnNames,d.Did.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<d.Did.size();i++) {
										table.setValueAt(d.Did.get(i), i, 0);
										table.setValueAt(d.Duname.get(i), i, 1);
										table.setValueAt(d.Dname.get(i), i, 2);
										table.setValueAt(d.Dregion.get(i), i, 3);
										table.setValueAt(d.Dphone.get(i), i, 4);
										table.setValueAt(d.Demail.get(i), i, 5);
									}
									d.clearall();
											
									scrollPane_1.setViewportView(table);
									
									btnDisplayVehicles.setVisible(true);
									btnDisplayDealers.setVisible(false);
								}
							});
							btnDisplayDealers.setBounds(524, 328, 160, 50);
							viewvehiclespanel.add(btnDisplayDealers);
							
							btnDisplayVehicles.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//DISPLAY VEHICLES AGAIN 
									vh.displayAllVehicles();
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
									table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Did.get(i), i, 0);
										table.setValueAt(vh.Dname.get(i), i, 1);
										table.setValueAt(vh.Vid.get(i), i, 2);
										table.setValueAt(vh.Vbrand.get(i), i, 3);
										table.setValueAt(vh.Vmodel.get(i), i, 4);
										table.setValueAt(vh.Vtype.get(i), i, 5);
										table.setValueAt(vh.Vcolor.get(i), i, 6);
										table.setValueAt(vh.Vyear.get(i), i, 7);
										table.setValueAt(vh.Vfuel.get(i), i, 8);
										table.setValueAt(vh.Vprice.get(i), i, 9);
										table.setValueAt(vh.Vstatus.get(i), i, 10);
									}
									vh.clearall();
											
									scrollPane_1.setViewportView(table);
									btnDisplayVehicles.setVisible(false);
									btnDisplayDealers.setVisible(true);
								}
							});
							btnDisplayVehicles.setBounds(524, 328, 160, 50);
							viewvehiclespanel.add(btnDisplayVehicles);
							
							//COMBO BOXES FOR SORTING
							JComboBox<String> BrandcomboBox = new JComboBox<String>();
							JComboBox<String> TypecomboBox = new JComboBox<String>();
							JComboBox<String> FuelcomboBox = new JComboBox<String>();
							JComboBox<String> DealercomboBox = new JComboBox<String>();
							
							
							BrandcomboBox.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//SORTING ADD TO EVERY COMBO BOX
									vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
									
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
									table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Did.get(i), i, 0);
										table.setValueAt(vh.Dname.get(i), i, 1);
										table.setValueAt(vh.Vid.get(i), i, 2);
										table.setValueAt(vh.Vbrand.get(i), i, 3);
										table.setValueAt(vh.Vmodel.get(i), i, 4);
										table.setValueAt(vh.Vtype.get(i), i, 5);
										table.setValueAt(vh.Vcolor.get(i), i, 6);
										table.setValueAt(vh.Vyear.get(i), i, 7);
										table.setValueAt(vh.Vfuel.get(i), i, 8);
										table.setValueAt(vh.Vprice.get(i), i, 9);
										table.setValueAt(vh.Vstatus.get(i), i, 10);
									}
									vh.clearall();
											
									scrollPane_1.setViewportView(table);
									
									btnDisplayVehicles.setVisible(false);
									btnDisplayDealers.setVisible(true);
								}
							});
							BrandcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Toyota", "Honda", "Ford", "Volkswagen", "Nissan", "Chevrolet", "Hyundai", "Renault", "Skoda", "Fiat", "Tata", "Jeep", "Ferrari", "Lamborghini", "Bugatti", "BMW", "Maruti", "Tesla"}));
							BrandcomboBox.setBounds(78, 358, 100, 20);
							viewvehiclespanel.add(BrandcomboBox);
							
							TypecomboBox.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//SORTING ADD TO EVERY COMBO BOX
									vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
									
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
									table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Did.get(i), i, 0);
										table.setValueAt(vh.Dname.get(i), i, 1);
										table.setValueAt(vh.Vid.get(i), i, 2);
										table.setValueAt(vh.Vbrand.get(i), i, 3);
										table.setValueAt(vh.Vmodel.get(i), i, 4);
										table.setValueAt(vh.Vtype.get(i), i, 5);
										table.setValueAt(vh.Vcolor.get(i), i, 6);
										table.setValueAt(vh.Vyear.get(i), i, 7);
										table.setValueAt(vh.Vfuel.get(i), i, 8);
										table.setValueAt(vh.Vprice.get(i), i, 9);
										table.setValueAt(vh.Vstatus.get(i), i, 10);
									}
									vh.clearall();
											
									scrollPane_1.setViewportView(table);
									
									btnDisplayVehicles.setVisible(false);
									btnDisplayDealers.setVisible(true);
								}
							});
							TypecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Hatchback", "Sedan", "MPV", "SUV", "Convertible", "Pickup", "Coupe"}));
							TypecomboBox.setBounds(244, 328, 100, 20);
							viewvehiclespanel.add(TypecomboBox);
							
							FuelcomboBox.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//SORTING ADD TO EVERY COMBO BOX
									vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
									
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
									table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Did.get(i), i, 0);
										table.setValueAt(vh.Dname.get(i), i, 1);
										table.setValueAt(vh.Vid.get(i), i, 2);
										table.setValueAt(vh.Vbrand.get(i), i, 3);
										table.setValueAt(vh.Vmodel.get(i), i, 4);
										table.setValueAt(vh.Vtype.get(i), i, 5);
										table.setValueAt(vh.Vcolor.get(i), i, 6);
										table.setValueAt(vh.Vyear.get(i), i, 7);
										table.setValueAt(vh.Vfuel.get(i), i, 8);
										table.setValueAt(vh.Vprice.get(i), i, 9);
										table.setValueAt(vh.Vstatus.get(i), i, 10);
									}
									vh.clearall();
											
									scrollPane_1.setViewportView(table);
									
									btnDisplayVehicles.setVisible(false);
									btnDisplayDealers.setVisible(true);
								}
							});
							FuelcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Petrol", "Diesel", "Petrol/Diesel", "CNG", "Electric"}));
							FuelcomboBox.setBounds(244, 358, 100, 20);
							viewvehiclespanel.add(FuelcomboBox);
						
							DealercomboBox.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									//SORTING ADD TO EVERY COMBO BOX
									vh.displaySortedVehicles((String) DealercomboBox.getSelectedItem(), (String) BrandcomboBox.getSelectedItem(), (String) TypecomboBox.getSelectedItem(), (String) FuelcomboBox.getSelectedItem());
									
									table.removeAll();
									table = new JTable();
									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									table.setDefaultEditor(Object.class, null);
									String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
									table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
											
									//ADDING ENTRIES IN TABLE
									for(int i=0;i<vh.Vid.size();i++) {
										table.setValueAt(vh.Did.get(i), i, 0);
										table.setValueAt(vh.Dname.get(i), i, 1);
										table.setValueAt(vh.Vid.get(i), i, 2);
										table.setValueAt(vh.Vbrand.get(i), i, 3);
										table.setValueAt(vh.Vmodel.get(i), i, 4);
										table.setValueAt(vh.Vtype.get(i), i, 5);
										table.setValueAt(vh.Vcolor.get(i), i, 6);
										table.setValueAt(vh.Vyear.get(i), i, 7);
										table.setValueAt(vh.Vfuel.get(i), i, 8);
										table.setValueAt(vh.Vprice.get(i), i, 9);
										table.setValueAt(vh.Vstatus.get(i), i, 10);
									}
									vh.clearall();
											
									scrollPane_1.setViewportView(table);
									
									btnDisplayVehicles.setVisible(false);
									btnDisplayDealers.setVisible(true);
								}
							});
							DealercomboBox.setModel(new DefaultComboBoxModel<String>(d.DealerList()));
							DealercomboBox.setBounds(78, 327, 100, 20);
							viewvehiclespanel.add(DealercomboBox);
							
							
							
							JLabel lblDealer = new JLabel("Dealer :");
							lblDealer.setHorizontalAlignment(SwingConstants.CENTER);
							lblDealer.setBounds(20, 330, 46, 14);
							viewvehiclespanel.add(lblDealer);
							
							JLabel lblBrand_1 = new JLabel("Brand :");
							lblBrand_1.setHorizontalAlignment(SwingConstants.CENTER);
							lblBrand_1.setBounds(22, 361, 46, 14);
							viewvehiclespanel.add(lblBrand_1);
							
							JLabel lblNewLabel_6 = new JLabel("Type :");
							lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_6.setBounds(188, 331, 46, 14);
							viewvehiclespanel.add(lblNewLabel_6);
							
							JLabel lblFuel = new JLabel("Fuel :");
							lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
							lblFuel.setBounds(188, 362, 46, 14);
							viewvehiclespanel.add(lblFuel);
							
							JButton btnNewButton_2 = new JButton("ORDER VEHICLE");
							btnNewButton_2.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if(table.getSelectedRow() != -1) {
										try 
								        { 
								            // checking valid integer using parseInt() method 
								            Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 2)); 
								            
								            if(JOptionPane.showConfirmDialog(null, "Place Order?", "Order", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
									            vh.buyVehicle(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 2)), cs.CustomerDetails(0), Integer.parseInt(cs.CustomerDetails(5)));
												vh.displayAllVehicles();
												
												table.removeAll();
												table = new JTable();
												table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
												table.setDefaultEditor(Object.class, null);
												String[] columnNames1= {"Dealer ID","Username","Vehicle ID","Brand","Model","Type","Colour","Year","Fuel Type","Price","Status"};
												table.setModel(new DefaultTableModel(columnNames1,vh.Vid.size()));
														
												//ADDING ENTRIES IN TABLE
												for(int i=0;i<vh.Vid.size();i++) {
													table.setValueAt(vh.Did.get(i), i, 0);
													table.setValueAt(vh.Dname.get(i), i, 1);
													table.setValueAt(vh.Vid.get(i), i, 2);
													table.setValueAt(vh.Vbrand.get(i), i, 3);
													table.setValueAt(vh.Vmodel.get(i), i, 4);
													table.setValueAt(vh.Vtype.get(i), i, 5);
													table.setValueAt(vh.Vcolor.get(i), i, 6);
													table.setValueAt(vh.Vyear.get(i), i, 7);
													table.setValueAt(vh.Vfuel.get(i), i, 8);
													table.setValueAt(vh.Vprice.get(i), i, 9);
													table.setValueAt(vh.Vstatus.get(i), i, 10);
												}
												vh.clearall();
														
												scrollPane_1.setViewportView(table);
												JOptionPane.showMessageDialog(null, "Order Placed.", "Incorrect Table", JOptionPane.INFORMATION_MESSAGE);
								            }
											
								        }  
								        catch (NumberFormatException e1)  
								        { 
								        	JOptionPane.showMessageDialog(null, "Switch to Vehicle Table.", "Incorrect Table", JOptionPane.INFORMATION_MESSAGE);
								        } 
										
									}
									else {
										JOptionPane.showMessageDialog(null, "Select Vehicle from Table.", "No Vehicle Selected", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnNewButton_2.setBounds(10, 11, 150, 50);
							viewvehiclespanel.add(btnNewButton_2);
							
							
							//DISPLAY DEALER INFO BUTTON
							JButton btnDealerInfo = new JButton("Dealer Info");
							btnDealerInfo.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (table.getSelectedRow() != -1) {
									
										d.findDealer((String) table.getValueAt(table.getSelectedRow(), 1));
										
										JPanel dealerinfopanel = new JPanel();
										dealerinfopanel.setLayout(null);
										frmVehicleManagementSystem.getContentPane().add(dealerinfopanel, "name_66305818664800");
										
										JLabel lblCustomerDetails = new JLabel("Dealer Details");
										lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
										lblCustomerDetails.setBounds(234, 11, 223, 50);
										dealerinfopanel.add(lblCustomerDetails);
										
										JLabel label_2 = new JLabel("Username :");
										label_2.setHorizontalAlignment(SwingConstants.CENTER);
										label_2.setBounds(188, 116, 97, 14);
										dealerinfopanel.add(label_2);
										
										JButton button = new JButton("Back");
										button.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												dealerinfopanel.setVisible(false);
												viewvehiclespanel.setVisible(true);
											}
										});
										button.setToolTipText("Go Back");
										button.setBounds(595, 11, 89, 23);
										dealerinfopanel.add(button);
										
										JLabel label_7 = new JLabel("Name :");
										label_7.setHorizontalAlignment(SwingConstants.CENTER);
										label_7.setBounds(188, 141, 97, 14);
										dealerinfopanel.add(label_7);
										
										JLabel label_8 = new JLabel(" Region :");
										label_8.setHorizontalAlignment(SwingConstants.CENTER);
										label_8.setBounds(188, 166, 97, 14);
										dealerinfopanel.add(label_8);
										
										JLabel label_9 = new JLabel("Phone No :");
										label_9.setHorizontalAlignment(SwingConstants.CENTER);
										label_9.setBounds(188, 191, 97, 14);
										dealerinfopanel.add(label_9);
										
										JLabel label_10 = new JLabel("Email :");
										label_10.setHorizontalAlignment(SwingConstants.CENTER);
										label_10.setBounds(188, 216, 97, 14);
										dealerinfopanel.add(label_10);
										
										JLabel label_11 = new JLabel(d.DealerDetails(0));
										label_11.setBounds(295, 116, 162, 14);
										dealerinfopanel.add(label_11);
										
										JLabel label_12 = new JLabel(d.DealerDetails(1));
										label_12.setBounds(295, 141, 162, 14);
										dealerinfopanel.add(label_12);
										
										JLabel label_13 = new JLabel(d.DealerDetails(2));
										label_13.setBounds(295, 166, 162, 14);
										dealerinfopanel.add(label_13);
										
										JLabel label_14 = new JLabel(d.DealerDetails(3));
										label_14.setBounds(295, 191, 162, 14);
										dealerinfopanel.add(label_14);
										
										JLabel label_15 = new JLabel(d.DealerDetails(4));
										label_15.setBounds(295, 216, 162, 14);
										dealerinfopanel.add(label_15);
										
										JLabel lblCustomerId = new JLabel("Dealer ID :");
										lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerId.setBounds(188, 91, 97, 14);
										dealerinfopanel.add(lblCustomerId);
										
										JLabel label_17 = new JLabel(d.DealerDetails(5));
										label_17.setBounds(295, 91, 162, 14);
										dealerinfopanel.add(label_17);
										
										dealerinfopanel.setVisible(true);
										viewvehiclespanel.setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(null, "Select Dealer from Table.", "No Dealer Selected", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnDealerInfo.setBounds(354, 328, 160, 50);
							viewvehiclespanel.add(btnDealerInfo);
							
							BrandcomboBox .setSelectedIndex(0);
							TypecomboBox.setSelectedIndex(0);
							FuelcomboBox.setSelectedIndex(0);
							DealercomboBox.setSelectedIndex(0);
							
							viewvehiclespanel.setVisible(true);
						}
					});
					btnViewVehicles.setBounds(38, 122, 200, 50);
					customermenupanel.add(btnViewVehicles);
					
					JButton btnOrders = new JButton("MY ORDERS");
					btnOrders.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							customermenupanel.setVisible(false);
							
							//ADD HERE 
							JPanel customerorderspanel = new JPanel();
							customerorderspanel.setLayout(null);
							frmVehicleManagementSystem.getContentPane().add(customerorderspanel, "name_33174534613000");
							
							JLabel lblMyOrders = new JLabel("My Orders");
							lblMyOrders.setBounds(262, 11, 160, 50);
							lblMyOrders.setHorizontalAlignment(SwingConstants.CENTER);
							lblMyOrders.setFont(new Font("Tahoma", Font.BOLD, 20));
							customerorderspanel.add(lblMyOrders);
							
							JButton COBackBtn = new JButton("Back");
							COBackBtn.setBounds(595, 11, 89, 23);
							COBackBtn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									customerorderspanel.setVisible(false);
									customermenupanel.setVisible(true);
								}
							});
							COBackBtn.setToolTipText("Go Back");
							customerorderspanel.add(COBackBtn);
							
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(10, 72, 674, 245);
							customerorderspanel.add(scrollPane);
							
							//TABLE SETUP FIRST TIME
							vh.orderDetails(cs.CustomerDetails(0));
							table = new JTable();
							table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							table.setDefaultEditor(Object.class, null);
							String[] columnNames= {"Dealer ID","Dealer Username","Vehicle ID","Vehicle Brand","Vehicle Model","Price","Status"};
							table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
							
							//ADDING ENTRIES IN TABLE
							for(int i=0;i<vh.Vid.size();i++) {
								table.setValueAt(vh.Did.get(i), i, 0);
								table.setValueAt(vh.Dname.get(i), i, 1);
								table.setValueAt(vh.Vid.get(i), i, 2);
								table.setValueAt(vh.Vbrand.get(i), i, 3);
								table.setValueAt(vh.Vmodel.get(i), i, 4);
								table.setValueAt(vh.Vprice.get(i), i, 5);
								table.setValueAt(vh.Vstatus.get(i), i, 6);
							}
							vh.clearall();
							
							scrollPane.setViewportView(table);
							
							
							//CANCEL ORDER BUTTON
							JButton cancelbtn = new JButton("Cancel Order");
							cancelbtn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (table.getSelectedRow() != -1 && ((String)table.getValueAt(table.getSelectedRow(), 6)).equals("Pending")) {
										int option= JOptionPane.showConfirmDialog(null, "Cancel Order?", "Manage Orders", JOptionPane.YES_NO_OPTION);
										if(option==JOptionPane.YES_OPTION) {
											String ID = (String) table.getValueAt(table.getSelectedRow(), 2);
											
											vh.cancelOrder(cs.CustomerDetails(0), Integer.parseInt(ID));
											vh.orderDetails(cs.CustomerDetails(0));
											table.removeAll();
											table = new JTable();
											table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											table.setDefaultEditor(Object.class, null);
											String[] columnNames= {"Dealer ID","Dealer Username","Vehicle ID","Vehicle Brand","Vehicle Model","Price","Status"};
											table.setModel(new DefaultTableModel(columnNames,vh.Vid.size()));
											
											//ADDING ENTRIES IN TABLE
											for(int i=0;i<vh.Vid.size();i++) {
												table.setValueAt(vh.Did.get(i), i, 0);
												table.setValueAt(vh.Dname.get(i), i, 1);
												table.setValueAt(vh.Vid.get(i), i, 2);
												table.setValueAt(vh.Vbrand.get(i), i, 3);
												table.setValueAt(vh.Vmodel.get(i), i, 4);
												table.setValueAt(vh.Vprice.get(i), i, 5);
												table.setValueAt(vh.Vstatus.get(i), i, 6);
											}
											vh.clearall();
											
											scrollPane.setViewportView(table);
											JOptionPane.showMessageDialog(null, "Order Cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else if(table.getSelectedRow() == -1) {
										JOptionPane.showMessageDialog(null, "Select Order from Table.", "No Order Selected", JOptionPane.INFORMATION_MESSAGE);
									}
									else {
										JOptionPane.showMessageDialog(null, "Order already Placed", "Already Done", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							cancelbtn.setBounds(388, 328, 200, 50);
							customerorderspanel.add(cancelbtn);
							
							JButton btnDealerInfo_1 = new JButton("Dealer Info");
							btnDealerInfo_1.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (table.getSelectedRow() != -1) {
									
										d.findDealer((String) table.getValueAt(table.getSelectedRow(), 1));
										
										JPanel dealerinfopanel = new JPanel();
										dealerinfopanel.setLayout(null);
										frmVehicleManagementSystem.getContentPane().add(dealerinfopanel, "name_66305818664800");
										
										JLabel lblCustomerDetails = new JLabel("Dealer Details");
										lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
										lblCustomerDetails.setBounds(234, 11, 223, 50);
										dealerinfopanel.add(lblCustomerDetails);
										
										JLabel label_2 = new JLabel("Username :");
										label_2.setHorizontalAlignment(SwingConstants.CENTER);
										label_2.setBounds(188, 116, 97, 14);
										dealerinfopanel.add(label_2);
										
										JButton button = new JButton("Back");
										button.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												dealerinfopanel.setVisible(false);
												customerorderspanel.setVisible(true);
											}
										});
										button.setToolTipText("Go Back");
										button.setBounds(595, 11, 89, 23);
										dealerinfopanel.add(button);
										
										JLabel label_7 = new JLabel("Name :");
										label_7.setHorizontalAlignment(SwingConstants.CENTER);
										label_7.setBounds(188, 141, 97, 14);
										dealerinfopanel.add(label_7);
										
										JLabel label_8 = new JLabel(" Region :");
										label_8.setHorizontalAlignment(SwingConstants.CENTER);
										label_8.setBounds(188, 166, 97, 14);
										dealerinfopanel.add(label_8);
										
										JLabel label_9 = new JLabel("Phone No :");
										label_9.setHorizontalAlignment(SwingConstants.CENTER);
										label_9.setBounds(188, 191, 97, 14);
										dealerinfopanel.add(label_9);
										
										JLabel label_10 = new JLabel("Email :");
										label_10.setHorizontalAlignment(SwingConstants.CENTER);
										label_10.setBounds(188, 216, 97, 14);
										dealerinfopanel.add(label_10);
										
										JLabel label_11 = new JLabel(d.DealerDetails(0));
										label_11.setBounds(295, 116, 162, 14);
										dealerinfopanel.add(label_11);
										
										JLabel label_12 = new JLabel(d.DealerDetails(1));
										label_12.setBounds(295, 141, 162, 14);
										dealerinfopanel.add(label_12);
										
										JLabel label_13 = new JLabel(d.DealerDetails(2));
										label_13.setBounds(295, 166, 162, 14);
										dealerinfopanel.add(label_13);
										
										JLabel label_14 = new JLabel(d.DealerDetails(3));
										label_14.setBounds(295, 191, 162, 14);
										dealerinfopanel.add(label_14);
										
										JLabel label_15 = new JLabel(d.DealerDetails(4));
										label_15.setBounds(295, 216, 162, 14);
										dealerinfopanel.add(label_15);
										
										JLabel lblCustomerId = new JLabel("Dealer ID :");
										lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
										lblCustomerId.setBounds(188, 91, 97, 14);
										dealerinfopanel.add(lblCustomerId);
										
										JLabel label_17 = new JLabel(d.DealerDetails(5));
										label_17.setBounds(295, 91, 162, 14);
										dealerinfopanel.add(label_17);
										
										dealerinfopanel.setVisible(true);
										customerorderspanel.setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(null, "Select Dealer from Table.", "No Dealer Selected", JOptionPane.INFORMATION_MESSAGE);
									}
								}
							});
							btnDealerInfo_1.setBounds(103, 328, 200, 50);
							customerorderspanel.add(btnDealerInfo_1);
							
							customerorderspanel.setVisible(true);
							
						}
					});
					btnOrders.setBounds(248, 122, 200, 50);
					customermenupanel.add(btnOrders);
					
					JButton btnMyAccount = new JButton("MY ACCOUNT");
					btnMyAccount.setBounds(458, 122, 200, 50);
					btnMyAccount.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							customermenupanel.setVisible(false);
							customeraccountpanel.setVisible(true);
						}
					});
					customermenupanel.add(btnMyAccount);
					
					JLabel lblNewLabel = new JLabel("Welcome, "+cs.CustomerDetails(0));
					lblNewLabel.setBounds(536, 359, 148, 31);
					lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
					customermenupanel.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("Logout");
					btnNewButton.setBounds(595, 11, 89, 23);
					btnNewButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							customermenupanel.setVisible(false);
							customermenupanel.removeAll();
							customerloginpanel.setVisible(true);
						}
					});
					customermenupanel.add(btnNewButton);
					
					//ACCOUNT DETAILS PAGE
					customeraccountpanel.setLayout(null);
					frmVehicleManagementSystem.getContentPane().add(customeraccountpanel, "name_2190897499400");
					
					JLabel lblAccountDetails = new JLabel("Account Details");
					lblAccountDetails.setHorizontalAlignment(SwingConstants.CENTER);
					lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblAccountDetails.setBounds(234, 11, 223, 50);
					customeraccountpanel.add(lblAccountDetails);
					
					JLabel labelCUsername = new JLabel("Username :");
					labelCUsername.setHorizontalAlignment(SwingConstants.CENTER);
					labelCUsername.setBounds(188, 116, 97, 14);
					customeraccountpanel.add(labelCUsername);
					
					JButton button_11 = new JButton("Back");
					button_11.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							customeraccountpanel.setVisible(false);
							customermenupanel.setVisible(true);
						}
					});
					button_11.setToolTipText("Go Back");
					button_11.setBounds(595, 11, 89, 23);
					customeraccountpanel.add(button_11);
					
					JButton btnDeleteAccount = new JButton("Delete Account");
					btnDeleteAccount.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							//DELETE CUSTOMER ACCOUNT
							int option= JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Account", JOptionPane.YES_NO_OPTION);
							if(option==JOptionPane.YES_OPTION) {
								
								cs.deleteCustomer(cs.CustomerDetails(0), vh);
								
								JOptionPane.showMessageDialog(null, "Account Deleted", "Delete Account", JOptionPane.INFORMATION_MESSAGE);
								customeraccountpanel.setVisible(false);
								customeraccountpanel.removeAll();
								customerloginpanel.setVisible(true);
							}
						}
					});
					btnDeleteAccount.setToolTipText("");
					btnDeleteAccount.setBounds(521, 356, 150, 23);
					customeraccountpanel.add(btnDeleteAccount);
					
					JLabel labelCName = new JLabel("Name :");
					labelCName.setHorizontalAlignment(SwingConstants.CENTER);
					labelCName.setBounds(188, 141, 97, 14);
					customeraccountpanel.add(labelCName);
					
					JLabel labelCRegion = new JLabel(" Region :");
					labelCRegion.setHorizontalAlignment(SwingConstants.CENTER);
					labelCRegion.setBounds(188, 166, 97, 14);
					customeraccountpanel.add(labelCRegion);
					
					JLabel labelCPhone = new JLabel("Phone No :");
					labelCPhone.setHorizontalAlignment(SwingConstants.CENTER);
					labelCPhone.setBounds(188, 191, 97, 14);
					customeraccountpanel.add(labelCPhone);
					
					JLabel labelCEmail = new JLabel("Email :");
					labelCEmail.setHorizontalAlignment(SwingConstants.CENTER);
					labelCEmail.setBounds(188, 216, 97, 14);
					customeraccountpanel.add(labelCEmail);
					
					JLabel lblUsername = new JLabel(cs.CustomerDetails(0));
					lblUsername.setBounds(295, 116, 162, 14);
					customeraccountpanel.add(lblUsername);
					
					JLabel lblNewLabel_1 = new JLabel(cs.CustomerDetails(1));
					lblNewLabel_1.setBounds(295, 141, 162, 14);
					customeraccountpanel.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel(cs.CustomerDetails(2));
					lblNewLabel_2.setBounds(295, 166, 162, 14);
					customeraccountpanel.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel(cs.CustomerDetails(3));
					lblNewLabel_3.setBounds(295, 191, 162, 14);
					customeraccountpanel.add(lblNewLabel_3);
					
					JLabel lblNewLabel_4 = new JLabel(cs.CustomerDetails(4));
					lblNewLabel_4.setBounds(295, 216, 162, 14);
					customeraccountpanel.add(lblNewLabel_4);
					
					JLabel lblDealerId = new JLabel("Customer ID :");
					lblDealerId.setHorizontalAlignment(SwingConstants.CENTER);
					lblDealerId.setBounds(188, 91, 97, 14);
					customeraccountpanel.add(lblDealerId);
					
					JLabel lblNewLabel_5 = new JLabel(cs.CustomerDetails(5));
					lblNewLabel_5.setBounds(295, 91, 162, 14);
					customeraccountpanel.add(lblNewLabel_5);
					
					customermenupanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username/Password.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				CUsernameField.setText("");
				CPasswordField.setText("");
			}
		});
		button.setBounds(295, 190, 117, 40);
		customerloginpanel.add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerloginpanel.setVisible(false);
				mainmenupanel.setVisible(true);
			}
		});
		button_1.setToolTipText("Go Back");
		button_1.setBounds(595, 11, 89, 23);
		customerloginpanel.add(button_1);
		
		JButton button_2 = new JButton("New User?");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerloginpanel.setVisible(false);
				customernewpanel.setVisible(true);
			}
		});
		button_2.setToolTipText("Sign Up");
		button_2.setBounds(295, 252, 117, 23);
		customerloginpanel.add(button_2);
		
		
		//CUSTOMER SIGN UP PANEL
		
		customernewpanel.setLayout(null);
		frmVehicleManagementSystem.getContentPane().add(customernewpanel, "name_72367856387900");
		
		JComboBox<String> CNRegioncomboBox = new JComboBox<String>();
		CNRegioncomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Mumbai City", "Mumbai Suburban", "Thane", "Palghar", "Raigad", "Ratnagiri", "Sindhudurg", "Kolhapur", "Pune", "Sangli", "Satara", "Solapur"}));
		CNRegioncomboBox.setToolTipText("Select Region");
		CNRegioncomboBox.setBounds(295, 178, 117, 22);
		customernewpanel.add(CNRegioncomboBox);
		
		JLabel lblCustomerSignUp = new JLabel("Customer Sign Up");
		lblCustomerSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerSignUp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerSignUp.setBounds(240, 11, 227, 50);
		customernewpanel.add(lblCustomerSignUp);
		
		CNUsernameField = new JTextField();
		CNUsernameField.setToolTipText("Enter username");
		CNUsernameField.setColumns(10);
		CNUsernameField.setBounds(295, 85, 117, 20);
		customernewpanel.add(CNUsernameField);
		
		CNPasswordField = new JPasswordField();
		CNPasswordField.setToolTipText("Enter password");
		CNPasswordField.setColumns(10);
		CNPasswordField.setBounds(295, 116, 117, 20);
		customernewpanel.add(CNPasswordField);
		
		JLabel label_4 = new JLabel("Username :");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(188, 88, 97, 14);
		customernewpanel.add(label_4);
		
		JLabel label_5 = new JLabel("Password :");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(188, 119, 97, 14);
		customernewpanel.add(label_5);
		
		JButton button_3 = new JButton("Register");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=CNUsernameField.getText();
				String pass= new String(CNPasswordField.getPassword());
				String name=CNNameField.getText();
				String region =(String) CNRegioncomboBox.getSelectedItem();
				String phone = CNPhoneField.getText();
				String email = CNEmailField.getText();
				if(uname.equals("") || pass.equals("") || name.equals("") || region.equals("") || phone.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill All Entries.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(cs.checkCUsername(uname)) {
					JOptionPane.showMessageDialog(null, "Username Already Taken.", "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					cs.addCustomer(uname, pass, name, region, phone, email);
					JOptionPane.showMessageDialog(null, "New Account Created.", "Success", JOptionPane.INFORMATION_MESSAGE);
					CNUsernameField.setText("");
					CNPasswordField.setText("");
					CNNameField.setText("");
					CNRegioncomboBox.setSelectedIndex(0);
					CNPhoneField.setText("");
					CNEmailField.setText("");
					customernewpanel.setVisible(false);
					customerloginpanel.setVisible(true);
				}
				
			}
		});
		button_3.setToolTipText("Create Account");
		button_3.setBounds(295, 273, 117, 40);
		customernewpanel.add(button_3);
		
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customernewpanel.setVisible(false);
				customerloginpanel.setVisible(true);
			}
		});
		button_4.setToolTipText("Go Back");
		button_4.setBounds(595, 11, 89, 23);
		customernewpanel.add(button_4);
		
		JButton button_5 = new JButton("Login");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customernewpanel.setVisible(false);
				customerloginpanel.setVisible(true);
			}
		});
		button_5.setToolTipText("Login");
		button_5.setBounds(295, 324, 117, 23);
		customernewpanel.add(button_5);
		
		CNNameField = new JTextField();
		CNNameField.setToolTipText("Enter name");
		CNNameField.setColumns(10);
		CNNameField.setBounds(295, 147, 117, 20);
		customernewpanel.add(CNNameField);
		
		CNPhoneField = new JTextField();
		CNPhoneField.setToolTipText("Enter phone number");
		CNPhoneField.setColumns(10);
		CNPhoneField.setBounds(295, 211, 117, 20);
		customernewpanel.add(CNPhoneField);
		
		CNEmailField = new JTextField();
		CNEmailField.setToolTipText("Enter email");
		CNEmailField.setColumns(10);
		CNEmailField.setBounds(295, 242, 117, 20);
		customernewpanel.add(CNEmailField);
		
		JLabel label_6 = new JLabel("Name :");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(188, 150, 97, 14);
		customernewpanel.add(label_6);
		
		JLabel label_7 = new JLabel(" Region :");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(188, 182, 97, 14);
		customernewpanel.add(label_7);
		
		JLabel label_8 = new JLabel("Phone No :");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(188, 214, 97, 14);
		customernewpanel.add(label_8);
		
		JLabel label_9 = new JLabel("Email :");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(188, 245, 97, 14);
		customernewpanel.add(label_9);
		
	}
}
