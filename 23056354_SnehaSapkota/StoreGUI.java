import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;


public class StoreGUI extends JFrame implements ActionListener{
    
    private JFrame frame;
    
    private JPanel panel1, panel2;
    
    private Border border1, border2;
    
    private Color c1, c2, c3;
    
    private JLabel department,retailer, storeId, storeName, location, openingHour, totalSales, totalDiscount, productName,
    markedPrice,  vat, purchasedYear, loyaltyPoint;
    
    private JLabel storeId_retailer, storeName_retailer, location_retailer, openingHour_retailer, totalDiscount_retailer,totalSales_retailer; 
    
    private JTextField t1storeId, t2storeName, t3location, t4openingHour, t5totalSales, t6totalDiscount, t7productName, t8markedPrice,
    t10vat, t11loyaltyPoint;
    
    private JTextField t1storeId_retailer,t2storeName_retailer, t3location_retailer, t4openingHour_retailer, t6totalDiscount_retailer, t5totalSales_retailer;
    
    private JButton addadepartment, calculatediscount, dispaly, clear, addaretailer, display, setloyaltypoint, removeproduct;
    
    private JButton display_retailer, clear_retailer;
    
    private JCheckBox IsInSalesCheckB, isPaymentonlinecheck;
    
    private JComboBox  year;
    //private JLabel background1, background2;
    private ArrayList<Store> arraystore = new ArrayList<Store>();
    
    public StoreGUI(){
        
        frame = new JFrame ("storegui");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //FOR DEPARTMENT 
        panel1 = new JPanel();
        panel1.setBounds(10,5, 625, 700);
        c1 = new Color(245,247,255);
        panel1.setBackground(c1);
        panel1.setLayout(null);
        
        /*ImageIcon img1 = new ImageIcon("amarillo.jpeg");
        background1 = new JLabel(img1);
        background1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
        panel1.add(background1);*/
        
        
        c3 = new Color(0,0,0);
        border1 = BorderFactory.createLineBorder(c3,3);
        panel1.setBorder(border1);
        
        department = new JLabel ("DEPARTMENT");
        department.setBounds(250, 10, 170, 30);
        department.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        department.setForeground(Color.RED);
        panel1.add(department);
        
        storeId = new JLabel ("Store ID:");
        storeId.setBounds(10, 75, 75, 30);
        panel1.add(storeId);
              
        t1storeId = new JTextField ();
        t1storeId.setBounds(70, 80, 120,25 );
        panel1.add(t1storeId);
        
        location = new JLabel ("Location:");
        location.setBounds(400, 130, 75, 30);
        panel1.add(location);
        
        t3location = new JTextField ();
        t3location.setBounds(480, 135, 120, 25);
        panel1.add(t3location);
        
        storeName = new JLabel ("StoreName:");
        storeName.setBounds(10, 130, 75, 30);
        panel1.add(storeName);
        
        t2storeName = new JTextField ();
        t2storeName.setBounds(90, 135, 130, 25);
        panel1.add(t2storeName);
        
        openingHour = new JLabel ("Opening Hour:");
        openingHour.setBounds(10, 200, 100, 30);
        panel1.add(openingHour);
        
        t4openingHour = new JTextField ();
        t4openingHour.setBounds(100, 205, 130, 25);
        panel1.add(t4openingHour);
        
        productName = new JLabel ("Product Name:");
        productName.setBounds(400, 200, 100, 30);
        panel1.add(productName);
        
        t7productName = new JTextField ();
        t7productName.setBounds(500, 205, 120, 25);
        panel1.add(t7productName);
        
        totalSales = new JLabel ("Total Sales:");
        totalSales.setBounds(10, 270, 75, 30);
        panel1.add(totalSales);
              
        t5totalSales = new JTextField ();
        t5totalSales.setBounds(90, 275, 130,25 );
        panel1.add(t5totalSales);
        
        totalDiscount = new JLabel ("Total Discount:");
        totalDiscount.setBounds(400, 270, 110, 30);
        panel1.add(totalDiscount);
              
        t6totalDiscount = new JTextField ();
        t6totalDiscount.setBounds(500, 275, 110,25 );
        panel1.add(t6totalDiscount);
        
        markedPrice = new JLabel ("Marked Price:");
        markedPrice.setBounds(10, 340, 100, 30);
        panel1.add(markedPrice);
              
        t8markedPrice = new JTextField ();
        t8markedPrice.setBounds(100, 345, 110,25 );
        panel1.add(t8markedPrice);
        //ADD A DEPARTMENT BUTTON
        addadepartment = new JButton("Add a Department");
        addadepartment.setBounds(230, 390, 200, 30);
        panel1.add(addadepartment);
        addadepartment.addActionListener(this);
    
        
       
        //IS IN SALES BUTTON
        IsInSalesCheckB = new JCheckBox("Is In Sales:");
        IsInSalesCheckB.setBounds(90, 520, 180, 30);
        IsInSalesCheckB.setBackground(c1);
        panel1.add(IsInSalesCheckB);
        
        
        
        
        calculatediscount = new JButton("Calculate Discount Price");
        calculatediscount.setBounds(410, 520, 200, 30);
        panel1.add(calculatediscount);
        
        calculatediscount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int storeId = Integer.parseInt(t1storeId.getText());
                    boolean isInSales = IsInSalesCheckB.isSelected();
                    //double markedPrice = Double.parseDouble(t8markedPrice.getText());
                    for (Store storeyyy : arraystore){
                        if (storeyyy instanceof Department && storeyyy.getStoreId() == storeId){
                            Department department = (Department) storeyyy; //downcasting
                            //double markedPrice = department.getmarked_Price();
                            department.calculateDiscountPrice(isInSales,department.getmarked_Price());
                            JOptionPane.showMessageDialog(null, "Discount Price calculated","",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Store ID not found","", JOptionPane.WARNING_MESSAGE);
                }
                catch (NumberFormatException nf){
                    JOptionPane.showMessageDialog(null, "Enter valid Store ID", "Invalid ID", JOptionPane.WARNING_MESSAGE);
                }
                }
            });
        
        
        
        display = new JButton("Display");
        display.setBounds(150, 650, 120, 30);
        panel1.add(display);
        
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            try{
                int StoreID = Integer.parseInt(t1storeId.getText());
                for (Store storeyyy : arraystore){
                    if(storeyyy instanceof Retailer && storeyyy.getStoreId() == StoreID){
                       Department department = (Department) storeyyy;
                       department.display();
                       JOptionPane.showMessageDialog (null, "Displayed", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            catch(NumberFormatException nf){
                JOptionPane.showMessageDialog (null, "Please enter valid number","Error", JOptionPane.WARNING_MESSAGE);
            }
                
            }
        });
        
        
        
        clear = new JButton("Clear");
        clear.setBounds(350, 650, 120, 30);
        panel1.add(clear);
        
        clear.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
             t1storeId.setText("");
             t2storeName.setText("");
             t3location.setText("");
             t4openingHour.setText("");
             t5totalSales.setText("");
             t6totalDiscount.setText("");
             t7productName.setText("");
             t8markedPrice.setText("");
         }
        });
        
        
        
        //RETAILER GUI
    
        panel2 = new JPanel();
        panel2.setBounds(645, 5, 625, 700);
        c2 = new Color(245,247,255);
        panel2.setBackground(c2);
        panel2.setLayout(null);
        
        c3 = new Color(0,0,0);
        border1 = BorderFactory.createLineBorder(c3,3);
        panel2.setBorder(border1);
        
        
        retailer = new JLabel ("RETAILER");
        retailer.setBounds(270, 10, 170, 30);
        retailer.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        retailer.setForeground(Color.RED);
        panel2.add(retailer);
        
        storeId_retailer = new JLabel ("Store ID:");
        storeId_retailer.setBounds(10, 75, 75, 30);
        panel2.add(storeId_retailer);
              
        t1storeId_retailer = new JTextField ();
        t1storeId_retailer.setBounds(75, 80, 130,25 );
        panel2.add(t1storeId_retailer);
        
        location_retailer = new JLabel ("Location:");
        location_retailer.setBounds(390, 130, 75, 30);
        panel2.add(location_retailer);
        
        t3location_retailer = new JTextField ();
        t3location_retailer.setBounds(480, 135, 130, 25);
        panel2.add(t3location_retailer);
        
        storeName_retailer = new JLabel ("Store Name:");
        storeName_retailer.setBounds(10, 130, 75, 30);
        panel2.add(storeName_retailer);
        
        t2storeName_retailer = new JTextField ();
        t2storeName_retailer.setBounds(100, 135, 130, 25);
        panel2.add(t2storeName_retailer);
        
        openingHour_retailer = new JLabel ("Opening Hour:");
        openingHour_retailer.setBounds(10, 180, 100, 30);
        panel2.add(openingHour_retailer);
        
        t4openingHour_retailer = new JTextField ();
        t4openingHour_retailer.setBounds(100, 185, 130, 25);
        panel2.add(t4openingHour_retailer);
        
        totalSales_retailer = new JLabel ("Total Sales:");
        totalSales_retailer.setBounds(390, 180, 150, 30);
        panel2.add(totalSales_retailer);
        
        t5totalSales_retailer = new JTextField ();
        t5totalSales_retailer.setBounds(480, 185, 130, 25);
        panel2.add(t5totalSales_retailer);
        
        vat = new JLabel ("VAT inclusive price:");
        vat.setBounds(10, 240, 160, 30);
        panel2.add(vat);
              
        t10vat= new JTextField ();
        t10vat.setBounds(135, 245, 130,25 );
        panel2.add(t10vat);
        
        totalDiscount_retailer = new JLabel ("Total Discount:");
        totalDiscount_retailer.setBounds(390, 240, 110, 30);
        panel2.add(totalDiscount_retailer);
              
        t6totalDiscount_retailer = new JTextField ();
        t6totalDiscount_retailer.setBounds(495, 245, 120,25 );
        panel2.add(t6totalDiscount_retailer);
        
        
        isPaymentonlinecheck = new JCheckBox("Is Payment Online");
        isPaymentonlinecheck.setBounds(10, 310, 170, 30);
        isPaymentonlinecheck.setBackground(c2);
        panel2.add(isPaymentonlinecheck);
        
        
        
        purchasedYear = new JLabel("Purchased Year:");
        purchasedYear.setBounds(390, 310, 120,30);
        panel2.add(purchasedYear);
        
        year = new JComboBox();
        year.addItem(" ");
        year.addItem("2020 AD");
        year.addItem("2021 AD");
        year.addItem("2022 AD");
        year.setBounds(490, 310, 120, 30);
        panel2.add(year);
        
        addaretailer = new JButton("Add a Retailer");
        addaretailer.setBounds(240, 380, 200, 30);
        panel2.add(addaretailer);
        addaretailer.addActionListener(this);
        
        //for set Loyalty point and remove product
        
        loyaltyPoint = new JLabel ("Loyalty Point:");
        loyaltyPoint.setBounds(350, 480, 180, 30);
        panel2.add(loyaltyPoint);
              
        t11loyaltyPoint = new JTextField ();
        t11loyaltyPoint.setBounds(450, 485, 120,25 );
        panel2.add(t11loyaltyPoint);
        
        setloyaltypoint = new JButton("Set the Loyalty Point");
        setloyaltypoint.setBounds(30, 560, 180, 30);
        panel2.add(setloyaltypoint);
        
        setloyaltypoint.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                try{
                    int StoreID = Integer.parseInt(t1storeId_retailer.getText());
                    boolean IsPaymentOnline = isPaymentonlinecheck.isSelected();
                    for( Store storeyyy : arraystore){
                        if (storeyyy instanceof Retailer && storeyyy.getStoreId() == StoreID){
                            Retailer retailer = (Retailer) storeyyy;
                            retailer.setLoyalty_point(IsPaymentOnline, retailer.getVAT_inclusive_price());
                            JOptionPane.showMessageDialog(null, "Set Loyalty point calculated","",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Store ID not found", "", JOptionPane.WARNING_MESSAGE);
                }
                catch(NumberFormatException nf){
                    JOptionPane.showMessageDialog(null, "Enter valid Store ID", "Invalid ID", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        removeproduct = new JButton("Remove the product");
        removeproduct.setBounds(400, 560, 180, 30);
        panel2.add(removeproduct);
        
        removeproduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
            try{
            int StoreID = Integer.parseInt(t1storeId_retailer.getText());
            //String Years = (String) year.getSelectedItem();
            //int Loyaltypoint = Integer.parseInt(t11loyaltyPoint.getText());
            for(Store storeyyy : arraystore){
                if (storeyyy instanceof Retailer && storeyyy.getStoreId() == StoreID){
                    Retailer retailer = (Retailer) storeyyy; //downcasting
                    //int Loyaltypoint = retailer.getloyalty_point();
                    retailer.removeProduct(retailer.getloyalty_point(),retailer.getPurchasedYear());
                    JOptionPane.showMessageDialog(null, "The product has been removed", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Store ID not found", "", JOptionPane.WARNING_MESSAGE);
        }catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(null, "Enter valid Store ID", "Invalid ID", JOptionPane.WARNING_MESSAGE);
        }
     }
    });
        
        display_retailer = new JButton("Display");
        display_retailer.setBounds(150, 650, 120, 30);
        panel2.add(display_retailer);
        
        clear_retailer = new JButton("Clear");
        clear_retailer.setBounds(350, 650, 120, 30);
        panel2.add(clear_retailer);
        //Event handling for clear button
        clear_retailer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                t1storeId_retailer.setText("");
                t2storeName_retailer.setText("");
                t3location_retailer.setText("");
                t4openingHour_retailer.setText("");
                t5totalSales_retailer.setText("");
                t6totalDiscount_retailer.setText("");
                t10vat.setText("");
                t11loyaltyPoint.setText("");
                year.setSelectedIndex(0);
                isPaymentonlinecheck.setSelected(false);
            }
            
        });
        
        frame.setLayout(null);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
        
        
        
        
        
    }
    public  void actionPerformed(ActionEvent aevent){
        if(aevent.getSource()== addadepartment){
            if(t1storeId.getText().isEmpty() || t2storeName.getText().isEmpty() || t3location.getText().isEmpty() || t4openingHour.getText().isEmpty()
               || t5totalSales.getText().isEmpty() || t6totalDiscount.getText().isEmpty() || t7productName.getText().isEmpty()
               || t8markedPrice.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null,"Please fill all the forms","Error",JOptionPane.WARNING_MESSAGE);
               }
            String StoreName = t2storeName.getText();
            String Location = t3location.getText();
            String OpeningHour = t4openingHour.getText();
            String ProductName = t7productName.getText();
            int StoreID;
            double TotalDiscount,TotalSales,MarkedPrice;

        try{
            StoreID = Integer.parseInt(t1storeId.getText());
            TotalDiscount = Double.parseDouble(t6totalDiscount.getText());
            TotalSales = Double.parseDouble(t5totalSales.getText());
            MarkedPrice = Double.parseDouble(t8markedPrice.getText());
            
            boolean isalreadyexist = false;
            for(Store storeyyy : arraystore){
             if(storeyyy instanceof Department && storeyyy.getStoreId() == StoreID){
                 isalreadyexist = true;
                 break;
            }
        }
            if(isalreadyexist == true){
                JOptionPane.showMessageDialog(frame,"This storeID " + StoreID + " already exist");
            }else{
                Department Depart = new Department(StoreName,StoreID,Location,OpeningHour,TotalSales,TotalDiscount,ProductName,MarkedPrice);
                arraystore.add(Depart);
                JOptionPane.showMessageDialog(frame,"Successfully added to department","Successfull",JOptionPane.INFORMATION_MESSAGE);
            }
        
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null,"please add number on number textField","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        }
        
        //Event handling for add a Retailer button
        else if (aevent.getSource() == addaretailer){
            if(t1storeId_retailer.getText().isEmpty() || t2storeName_retailer.getText().isEmpty() || t3location_retailer.getText().isEmpty()  
               || t4openingHour_retailer.getText().isEmpty()
               || t5totalSales_retailer.getText().isEmpty() || t6totalDiscount_retailer.getText().isEmpty() || t10vat.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null,"Please fill all the forms","Error",JOptionPane.WARNING_MESSAGE);
               }
            String StoreName = t2storeName_retailer.getText();
            String Location = t3location_retailer.getText();
            String OpeningHour = t4openingHour_retailer.getText();
            boolean IsPaymentOnline = isPaymentonlinecheck.isSelected();
            String Years = (String) year.getSelectedItem();
            int StoreID, VAT ;
            double TotalDiscount,TotalSales;
        try{
            StoreID = Integer.parseInt(t1storeId_retailer.getText());
            TotalDiscount = Double.parseDouble(t6totalDiscount_retailer.getText());
            TotalSales = Double.parseDouble(t5totalSales_retailer.getText());
            VAT = Integer.parseInt(t10vat.getText());
            
            boolean isalreadyexist = false;
            for (Store storeyyy : arraystore){
             if (storeyyy instanceof Retailer && storeyyy.getStoreId() == StoreID){
                  isalreadyexist = true;
                  break;
                        
            }
            }
             if(isalreadyexist == true){
                    
                 JOptionPane.showMessageDialog(frame,"This storeID " + StoreID + " already exist");
            }else{
               Retailer retailer = new Retailer(StoreID,StoreName,Location,OpeningHour,TotalSales,TotalDiscount,VAT,IsPaymentOnline, Years );
               arraystore.add(retailer);
               JOptionPane.showMessageDialog(frame,"Successfully added to Retailer","Successfull",JOptionPane.INFORMATION_MESSAGE);
            }
            }
        catch(NumberFormatException nf){
           JOptionPane.showMessageDialog(null, "Add number on text filed", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        }
        else{
            
        }
        }
    public static void main(String[] args){
        new StoreGUI();
        }
}
    

