
import java.sql.Date;

public class Item {
	protected int id;
	protected String title;
	protected String description;
	protected Date date;
	protected int price;
	protected String category;
  
 
    public Item() {
    }
 
    public Item(int id) {
        this.id = id;
    }
 
    public Item(int id, String title, String description, Date date, int price, String category) {
        this(title, description, date,price,category);
        this.id = id;
    }
    
    public Item(String title, String description, Date date, int price, String category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
        this.category = category;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDesciption(String description) {
        this.description = description;
    }
 
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return description;
    }
 
    public void getCategory(String category) {
        this.category = category;
    }
    
}