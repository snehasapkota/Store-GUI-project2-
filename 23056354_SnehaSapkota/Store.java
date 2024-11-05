public class Store
{
    //Attributes of Store
    private int storeId;
    private String storeName;
    private String location;
    private String openingHour;
    private double totalSales;
    private double totalDiscount;
    
    //using constructor method
    public Store(int storeId, String storeName, String location, String openingHour){
        this. storeId = storeId;
        this. storeName = storeName;
        this. location = location;
        this. openingHour = openingHour;
        this. totalSales = 0.0; //intializing to zero
        this. totalDiscount = 0.0; //intializing to zero
    }
    //using acceror method also called getter method to return value
    public int getStoreId(){
        return this.storeId;
    }
    public String getStoreName(){
        return this.storeName;
    }
    public String getLocation(){
        return this.location;
    }
    public String getOpeningHour(){
        return this.openingHour;
    }
    public double getTotalDiscount (){
        return this.totalDiscount;
    }
    public double getTotalSales(){
        return this.totalSales;
    }
    //using mutator method also called setter method for totalSales and totalDsicount
    public void setTotalSales (double totalSales){
        this.totalSales += totalSales;
    }
    public void setTotalDiscount(double totalDiscount){
        this.totalDiscount += totalDiscount;
    }
    //using display method
    public void display(){
        if(this.totalSales==0 && this.totalDiscount==0)
    {
        System.out.println("Total Sales or Total Discount is 0");
    
    }

    System.out.println("Store ID is:" +storeId);
    System.out.println("Store Name is:" +storeName);
    System.out.println("Location is:" +location);
    System.out.println("Opening Hour is:" +openingHour);
    System.out.println("Total Sales is:" +totalSales);
    System.out.println("Total Discount:" +totalDiscount);
    
    
    
    
    
}
}