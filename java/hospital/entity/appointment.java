package hospital.entity;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class appointment {
	private int a_id;
	private String a_date;
	private String a_time;
	private int pat_id;
	private int doc_id;
	private String dep_name;
	public String toString() {
		return "id is "+this.a_id+" date is "+this.a_date+" time is "+this.a_time+" patient id is "+this.pat_id+" doctor id is "+this.doc_id+" department name is "+this.dep_name;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
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
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	
}
