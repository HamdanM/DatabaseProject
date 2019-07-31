

public class Review {
    
    protected int ReviewID;
    protected int Item_ItemID;
    protected int User_UserID;
    protected String Score;
    protected String ShortRemark;
    protected String Date;

 
    public Review() {
    }
 
    public Review(int ReviewID) {
        this.ReviewID = ReviewID;
    }
 
    public Review(int ReviewID, int Item_ItemID, int User_UserID, String Score, String ShortRemark, String Date) {
//        this(Reviewid, Reviewname, Password, FirstName, LastName, Email, Gender, age, level);
        this.ReviewID = ReviewID;   
        this.Item_ItemID = Item_ItemID;
        this.User_UserID = User_UserID;
        this.Score = Score;
        this.ShortRemark = ShortRemark;
        this.Date = Date ;
    
    }
 
    public int getReviewid() {
        return ReviewID;
    }
    
    public int getItemID() {
        return Item_ItemID;
    }
 
    public void setReviewid(int ReviewID) {
        this.ReviewID = ReviewID;
    }
 
    public int getUser_UserID() {
        return User_UserID;
    }
 
    public void setUser_UserID(int User_UserID) {
        this.User_UserID = User_UserID;
    }
 
    public String getScore() {
        return Score;
    }
 
    public void setScore(String Score) {
        this.Score = Score;
    }
 
    public String getDescription() {
        return ShortRemark;
    }
 
    public void setShortRemark(String ShortRemark) {
        this.ShortRemark = ShortRemark;
    }
    
    public String getDate() {
        return Date;
    }
 
    public void setDate(String Date) {
        this.Date = Date;
    }
    
  
 
 
   
    
   
}