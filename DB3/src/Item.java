

public class Item {

    protected int ItemID;
    protected String User_UserID;
    protected String Title;
    protected String Description;
    protected String Date;
    protected String Tags;

 
    public Item() {
    }
 
    public Item(int ItemID) {
        this.ItemID = ItemID;
    }
 
    public Item(int ItemID, String User_UserID, String Title, String Description, String Date,
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
 
    public String getUser_UserID() {
        return User_UserID;
    }
 
    public void setUser_UserID(String User_UserID) {
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
 
 
   
    
   
}