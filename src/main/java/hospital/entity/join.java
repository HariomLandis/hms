package hospital.entity;

public class join {
	String doc_name;
	String pat_name;
	String a_date;
	String a_time;
	public String toString() {
		return "doctors name is "+this.doc_name+" patients name is "+this.pat_name+" appointment date is "+this.a_date+" appointment time is "+this.a_time;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String a_time) {
		this.a_time = a_time;
	}
	
}
