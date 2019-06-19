import java.sql.Date;

public class User {
	//| id | UserID  | Password | FirstName | LastName | Email  | Gender | Age  |
	protected int id;
	protected String userid;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected int gender;
	protected int age;
 
    public User() {
    }
 
    public User(int id) {
        this.id = id;
    }
 
    
    public User(String userid, String password, String firstname, String lastname, String email,int gender, int age) {
        this.userid = userid;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getuserid() {
        return userid;
    }
 
    public void setUserid(String userid) {
        this.userid = userid;
    }
 
    public String getpassword() {
        return password;
    }
 
    public void setpassword(String password) {
        this.password = password;
    }
 
    public String getfirstname() {
        return firstname;
    }
 
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getlastname() {
        return lastname;
    }
 
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
    public String getemail() {
        return email;
    }
 
    public void setemail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }
 
    public void setGender(int gender) {
        this.gender = gender;
    }
    
    public int getage() {
        return age;
    }
 
    public void setage(int age) {
        this.age = age;
    }
    
    
 
}
