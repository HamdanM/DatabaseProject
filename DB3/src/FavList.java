

public class FavList {

    protected String ItemID;
    protected String User_UserID;
    protected String Title;
    protected String Friend;


 
    public FavList() {
    }
 
    public FavList(String User_UserID, String Friend, String hello) {
    	this.User_UserID = User_UserID;
    	this.Friend = Friend;
    }
    
    public FavList(String ItemID) {
        this.ItemID = ItemID;
    }
//    public FavList(String ItemID,String Title) {
//
//    	this.ItemID = ItemID;    
//        this.Title = Title;
//       
//    
//    }
    
    public FavList(String ItemID, String User_UserID) {
//        this(Itemid, Itemname, Password, FirstName, LastName, Email, Gender, age, level);
        this.ItemID = ItemID;    
        this.User_UserID = User_UserID;
     
    
    }
 
    public String getItemid() {
        return ItemID;
    }
 
    public void setItemid(String ItemID) {
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
 
    
    public String getFriend() {
        return Friend;
    }
 
    public void setFriend(String Friend) {
        this.Friend = Friend;
    }
 
    
 
   
    
   
}