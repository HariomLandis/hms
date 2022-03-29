package hospital.entity;

public class consult {
	
	private int c_id;
	private double cfee;
	private String pmeds;
	private String fdate;
	private String ftime;
	private int a_id;
	public String toString() {
		return c_id+" "+cfee+" "+pmeds+" "+fdate+" "+ftime+" "+a_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public double getCfee() {
		return cfee;
	}
	public void setCfee(double cfee) {
		this.cfee = cfee;
	}
	public String getPmeds() {
		return pmeds;
	}
	public void setPmeds(String pmeds) {
		this.pmeds = pmeds;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	
}
