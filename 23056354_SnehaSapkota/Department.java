public class Department extends Store
{
    private String Product_name;
    private double Marked_price;
    private double Selling_price;
    private boolean isInSales;
    //using construction method
 Department(String storeName, int storeId, String location,String opeaningHour, double totalSales, double totalDiscount, 
 String Product_name, double Marked_price){
    
    super(storeId, storeName, location, opeaningHour);
    super.setTotalDiscount(totalDiscount);
    super.setTotalSales(totalSales);
    
    this.Product_name = Product_name;
    this.Marked_price = Marked_price;
    this.Selling_price = 0.0;
    this.isInSales = true;
    
}
//using assescor method (get method)
 public String getproduct_name(){
        return this.Product_name;
    }
    public double getmarked_Price(){
        return this.Marked_price;
    }
    public double getselling_price(){
        return this.Selling_price;
    }
    public boolean getIsInSales(){
        return this.isInSales;
    }
    //mutator method for marked price(set method)
    public void setmarked_price(double newMarked_price){
        this.Marked_price = newMarked_price;
    }
    void calculateDiscountPrice(boolean isInSales, double Marked_price){
        if (isInSales){
            double discount = 0.0;
            if(Marked_price >= 5000){
                discount = 0.20; 
            }
            else if(Marked_price >= 3000 && Marked_price < 5000){
                discount = 0.10; //10%
            }
            else if (Marked_price >= 1000 && Marked_price < 3000){
                discount = 0.05;
            }
            else if(Marked_price < 1000){
                discount = 0.0;
            }
            //formula
            setmarked_price(Marked_price);
            this.Selling_price = Marked_price - (Marked_price * discount);
            setTotalDiscount(getTotalDiscount()+ (Marked_price * discount));
            this.isInSales = false;

        }
        }
        public void display(){
           super.display();//calling parent display
           if(isInSales){
               System.out.println("Product Name:" +Product_name);
               System.out.println("Marked Price:" +Marked_price);
           }
           else{
               System.out.println("Product Name:" +Product_name);
               System.out.println("Selling price:" +Selling_price);
           }
        }
        public static void main(String[] args){
            Department dpt = new Department( "SaraMart", 2,"kalanki", "7Am",22.0, 33.0, "Sneha", 33.00);
            dpt.display();
        }
    }
