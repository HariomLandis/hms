package hospital.entity;

public class doctor {
	private int d_id ;
	private String d_name ;
	private String d_address ;
	private int d_age  ;
	private String d_phone ;
	private String d_dept ;
	private String d_gender  ;
	private String d_specialist ;
	private int d_fee;
	
	public int getD_fee() {
		return d_fee;
	}
	public void setD_fee(int d_fee) {
		this.d_fee = d_fee;
	}
	public String toString() {
		return this.d_id+" "+this.d_name+" "+this.d_address+" "+this.d_age+" "+this.d_phone+" "+this.d_dept+" "+this.d_gender+" "+this.d_specialist+" "+this.d_fee;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int doc_id) {
		this.d_id = doc_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_address() {
		return d_address;
	}
	public void setD_address(String d_address) {
		this.d_address = d_address;
	}
	public int getD_age() {
		return d_age;
	}
	public void setD_age(int d_age) {
		this.d_age = d_age;
	}
	public String getD_phone() {
		return d_phone;
	}
	public void setD_phone(String d_phone) {
		this.d_phone = d_phone;
	}
	public String getD_dept() {
		return d_dept;
	}
	public void setD_dept(String d_dept) {
		this.d_dept = d_dept;
	}
	public String getD_gender() {
		return d_gender;
	}
	public void setD_gender(String gender) {
		this.d_gender = gender;
	}
	public String getD_specialist() {
		return d_specialist;
	}
	public void setD_specialist(String d_specialist) {
		this.d_specialist = d_specialist;
	}
	
}
