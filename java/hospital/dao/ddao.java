package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import hospital.entity.doctor;
import hospital.entity.patient;

public class ddao implements ddao_interface{
	doctor d;
	Connection con;
	PreparedStatement ps;
	public ddao() throws SQLException, ClassNotFoundException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		//Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public int create_doc(doctor d) throws Exception {
		ps = con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?,?)");
		int i = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ps.setInt(1, d.getD_id());
		ps.setString(2, d.getD_name());
		ps.setString(3, d.getD_address());
		ps.setInt(4, d.getD_age());
		ps.setString(5,d.getD_phone());
		ps.setString(6, d.getD_dept());
		ps.setString(7, d.getD_gender());
		ps.setString(8,d.getD_specialist());
		ps.setInt(9, d.getD_fee());
		
		i = ps.executeUpdate();
		return i;
	}

	public int delete_doc(doctor d) throws SQLException {
		int i=0;
		try {
		ps = con.prepareStatement("delete from doctor where d_name=? and d_phone=?");
		ps.setString(1,d.getD_name());
		ps.setString(2, d.getD_phone());
		i=ps.executeUpdate();
		
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("doctor still has some appointments left to attend,so can't accept the resignation.");
		}
		return i;
	}

	public doctor show_doc_detail(doctor di) throws SQLException {
		d=new doctor();
		ps=con.prepareStatement("select * from doctor where d_name=? and d_phone=?");
		ps.setString(1,di.getD_name());
		ps.setString(2, di.getD_phone());
		ResultSet rs=ps.executeQuery();
		rs.next();
		d.setD_id(rs.getInt(1));
		d.setD_name(rs.getString(2));
		d.setD_address(rs.getString(3));
		d.setD_age(rs.getInt(4));
		d.setD_phone(rs.getString(5));
		d.setD_dept(rs.getString(6));
		d.setD_gender(rs.getString(7));
		d.setD_specialist(rs.getString(8));
		d.setD_fee(rs.getInt(9));
		return d;
	}

	public List<doctor> showall() throws SQLException {
		doctor doc;
		ps=con.prepareStatement("select * from doctor");
		ResultSet rs=ps.executeQuery();
		List<doctor> res=new ArrayList<doctor>();
		while(rs.next()) {
			doc=new doctor();
			doc.setD_id(rs.getInt(1));
			doc.setD_name(rs.getString(2));
			doc.setD_address(rs.getString(3));
			doc.setD_age(rs.getInt(4));
			doc.setD_phone(rs.getString(5));
			doc.setD_dept(rs.getString(6));
			doc.setD_gender(rs.getString(7));
			doc.setD_specialist(rs.getString(8));
			doc.setD_fee(rs.getInt(9));
			res.add(doc);
		}
		return res;
	}
	public List<doctor> findbyprob_dao(patient p) throws SQLException {
		doctor doc;
		ps=con.prepareStatement("select * from doctor where d_specialist=?");
		ps.setString(1, p.getPat_problem());
		ResultSet rs=ps.executeQuery();
		List<doctor> res=new ArrayList<doctor>();
		while(rs.next()) {
			doc=new doctor();
			doc.setD_id(rs.getInt(1));
			doc.setD_name(rs.getString(2));
			doc.setD_address(rs.getString(3));
			doc.setD_age(rs.getInt(4));
			doc.setD_phone(rs.getString(5));
			doc.setD_dept(rs.getString(6));
			doc.setD_gender(rs.getString(7));
			doc.setD_specialist(rs.getString(8));
			doc.setD_fee(rs.getInt(9));
			res.add(doc);
		}
		return res;
	}
	public doctor dshow_byId(doctor pa) throws SQLException{
		d=new doctor();
		ps=con.prepareStatement("select * from patient where d_id=?");
		ps.setInt(1,pa.getD_id());
		
		ResultSet rs=ps.executeQuery();
		rs.next();
		d.setD_id(rs.getInt(1));
		d.setD_name(rs.getString(2));
		d.setD_address(rs.getString(3));
		d.setD_age(rs.getInt(4));
		d.setD_phone(rs.getString(5));
		d.setD_dept(rs.getString(6));
		d.setD_gender(rs.getString(7));
		d.setD_specialist(rs.getString(8));
		d.setD_fee(rs.getInt(9));
		
		return d;
	}

	public int update_doc(doctor d) throws SQLException {
		ps=con.prepareStatement("update doctor set d_address=?,d_age=?,d_phone=?,d_dept=?,d_gender=?,d_specialist=?, d_fee=? where doc_id=?");
		
		ps.setInt(8, d.getD_id());
		ps.setString(1, d.getD_address());
		ps.setInt(2, d.getD_age());
		ps.setString(3, d.getD_phone());
		ps.setString(4, d.getD_dept());
		ps.setString(5, d.getD_gender());
		ps.setString(6, d.getD_specialist());
		ps.setInt(7, d.getD_fee());
		int i=ps.executeUpdate();
		return i;
	}
	/*public static void main(String args[]) throws SQLException, ClassNotFoundException {
		ddao d=new ddao();
		patient d1=new patient();
		d1.setPat_problem("human");
		List<doctor> ls=d.findbyprob_dao(d1);
		for(doctor d2:ls)
			System.out.println(d2);
	}*/
}
