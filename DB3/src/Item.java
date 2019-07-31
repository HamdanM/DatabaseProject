

public class Item {

    protected int ItemID;
    protected int User_UserID;
    protected String Title;
    protected String Description;
    protected String Date;
    protected String Tags;
    protected int Price;
    protected String User;
    public Item() {
    }
 
    public Item(int ItemID) {
        this.ItemID = ItemID;
    }
    public Item(int ItemID,String Title, String Description, String Date,
    		String Tags, int price, String user) {

    	this.ItemID = ItemID;    
        this.Title = Title;
        this.Description = Description;
        this.Date = Date ;
        this.Tags = Tags;
        this.Price = price;
        this.User = user;
        
    }
    
    public Item(int ItemID, int User_UserID, String Title, String Description, String Date,
    		String Tags) {
//        this(Itemid, Itemname, Password, FirstName, LastName, Email, Gender, age, level);
        this.ItemID = ItemID;    
        this.User_UserID = User_UserID;
        this.Title = Title;
        this.Description = Description;
        this.Date = Date ;
        this.Tags = Tags;
    
    }
 
    public int getItemid() {
        return ItemID;
    }
 
    public void setItemid(int ItemID) {
        this.ItemID = ItemID;
    }
 
    public int getUser_UserID() {
        return User_UserID;
    }
 public String getUser() {
	 return User;
 }
    public void setUser_UserID(int User_UserID) {
        this.User_UserID = User_UserID;
    }
 
    public String getTitle() {
        return Title;
    }
 
    public void setTitle(String Title) {
        this.Title = Title;
    }
 
    public String getDescription() {
        return Description;
    }
 
    public void setDescription(String Description) {
        this.Description = Description;
    }
    

 
    public void setUser(String User) {
        this.Description = User;
    }
    
    public String getDate() {
        return Date;
    }
 
    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public String getTags() {
        return Tags;
    }
 
    public void setTags(String Tags) {
        this.Tags = Tags;
    }
    
    public int getPrice() {
        return Price;
    }
 
    public void setPrice(int price) {
        this.Price = price;
    }
 
 
   
    
   
}