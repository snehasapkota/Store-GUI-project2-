public class Retailer extends Store
{
    private int VAT_inclusive_price;
    private int Loyalty_point;
    private boolean isPaymentOnline;
    private String purchasedYear;
    
    //using constructor method
    public Retailer (int storeId, String storeName, String location, String openingHour,
    double totalSales, double totalDiscount,int VAT_inclusive_price, boolean isPaymentOnline,
    String purchasedYear){
        
       super(storeId, storeName, location, openingHour);
       super.setTotalDiscount(totalDiscount);
       super.setTotalSales(totalSales);
       
       this.VAT_inclusive_price = VAT_inclusive_price;
       this.isPaymentOnline = isPaymentOnline;
       this. purchasedYear = purchasedYear;
       this.Loyalty_point = 0;
    }
    //using accessor method (getter method)
    public int getVAT_inclusive_price(){
        return this.VAT_inclusive_price;
    }
    public int getloyalty_point(){
        return this.Loyalty_point;
    }
    public boolean getIsPaymentOnline(){
        return this.isPaymentOnline;
    }
    public String getPurchasedYear(){
        return this.purchasedYear;
    }
    //using mutator method for isPaymentOnline (setter method)
    public void setIsPaymentOnline(boolean isPaymentOnline){
        this.isPaymentOnline = isPaymentOnline;
    }
    public void setLoyalty_point(boolean isPaymentOnline, int VAT_inclusive_price){
        this.isPaymentOnline = isPaymentOnline;
        this.VAT_inclusive_price = VAT_inclusive_price;
        if(isPaymentOnline){
            Loyalty_point = VAT_inclusive_price/100;
        }
        else{
            Loyalty_point = 0;
            
        }
        
    }
   public void removeProduct(int Loyalty_point, String purchasedYear){
        if(Loyalty_point == 0 || (purchasedYear == "2020" || purchasedYear ==  "2021" || purchasedYear == "2022")){
        this.VAT_inclusive_price = 0;
        this.Loyalty_point = 0;
        this.isPaymentOnline = false;
    } 
}
public void display(){
        super.display(); //calling parent class
        if(Loyalty_point != 0 || !(purchasedYear == "2020" || purchasedYear ==  "2021" || purchasedYear == "2022")){
            System.out.println("VAT inclusive price:" +VAT_inclusive_price);
            System.out.println("Loyalty point:" +Loyalty_point);
            System.out.println("Purchased Year:" +purchasedYear);
        }
            else{
                System.out.println("The product has been removed");
            }
            
        }
    }
