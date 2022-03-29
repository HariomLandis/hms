package hospital.entity;

public class patient {
	private int pat_id ;              
	private String pat_name ;
	private String pat_address ;
	private int pat_age   ;
	private String pat_phone   ;
	private String pat_problem  ;
	private String pat_gender  ;
	private String pat_emer_contact  ;
	private String active;
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String toString() {
		return this.pat_id+" "+this.pat_name+" "+this.pat_address+" "+this.pat_age+" "+this.pat_phone+" "+this.pat_problem+" "+this.pat_gender+" "+this.pat_emer_contact;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getPat_address() {
		return pat_address;
	}
	public void setPat_address(String pat_address) {
		this.pat_address = pat_address;
	}
	public int getPat_age() {
		return pat_age;
	}
	public void setPat_age(int pat_age) {
		this.pat_age = pat_age;
	}
	public String getPat_phone() {
		return pat_phone;
	}
	public void setPat_phone(String pat_phone) {
		this.pat_phone = pat_phone;
	}
	public String getPat_problem() {
		return pat_problem;
	}
	public void setPat_problem(String pat_problem) {
		this.pat_problem = pat_problem;
	}
	public String getPat_gender() {
		return pat_gender;
	}
	public void setPat_gender(String pat_gender) {
		this.pat_gender = pat_gender;
	}
	public String getPat_emer_contact() {
		return pat_emer_contact;
	}
	public void setPat_emer_contact(String pat_emer_contact) {
		this.pat_emer_contact = pat_emer_contact;
	}
}
