package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.controller.Cpatient;
import hospital.entity.patient;

public class pdao implements pdao_interface{
	patient p;
	Connection con;
	PreparedStatement ps;
	public pdao() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");

	}
	
	public int create_pat(patient p) throws Exception {
		ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?)");
		int i = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ps.setInt(1, p.getPat_id());
		ps.setString(2, p.getPat_name());
		ps.setString(3, p.getPat_address());
		ps.setInt(4, p.getPat_age());
		ps.setString(5, p.getPat_phone());
		ps.setString(6, p.getPat_problem());
		ps.setString(7, p.getPat_gender());
		ps.setString(8, p.getPat_emer_contact());
		ps.setString(9, p.getActive());
		i = ps.executeUpdate();
		return i;
	}
	
	public int delete_pat(patient p) throws SQLException {
		ps = con.prepareStatement("delete from patient where p_id=?");
		ps.setInt(1, p.getPat_id());
		int i=ps.executeUpdate();
		return i;
	}
	public patient show_pat_detail(patient pa) throws SQLException{
		p=new patient();
		ps=con.prepareStatement("select * from patient where p_name=? and p_phone=?");
		ps.setString(1,pa.getPat_name());
		ps.setString(2, pa.getPat_phone());
		ResultSet rs=ps.executeQuery();
		rs.next();
		p.setPat_id(rs.getInt(1));
		p.setPat_name(rs.getString(2));
		p.setPat_address(rs.getString(3));
		p.setPat_age(rs.getInt(4));
		p.setPat_phone(rs.getString(5));
		p.setPat_problem(rs.getString(6));
		p.setPat_gender(rs.getString(7));
		p.setPat_emer_contact(rs.getString(8));
		
		return p;
	}

	/*
	 * public patient show_byId(patient pa) throws SQLException{ p=new patient();
	 * ps=con.prepareStatement("select * from patient where p_id=?");
	 * ps.setInt(1,pa.getPat_id());
	 * 
	 * ResultSet rs=ps.executeQuery(); rs.next(); p.setPat_id(rs.getInt(1));
	 * p.setPat_name(rs.getString(2)); p.setPat_address(rs.getString(3));
	 * p.setPat_age(rs.getInt(4)); p.setPat_phone(rs.getString(5));
	 * p.setPat_problem(rs.getString(6)); p.setPat_gender(rs.getString(7));
	 * p.setPat_emer_contact(rs.getString(8));
	 * 
	 * return p; }
	 */
	public List<patient> showall() throws SQLException{
		patient pat;
		ps=con.prepareStatement("select * from patient");
		ResultSet rs=ps.executeQuery();
		List<patient> res=new ArrayList<patient>();
		while(rs.next()) {
			pat=new patient();
			pat.setPat_id(rs.getInt(1));
			pat.setPat_name(rs.getString(2));
			pat.setPat_address(rs.getString(3));
			pat.setPat_age(rs.getInt(4));
			pat.setPat_phone(rs.getString(5));
			pat.setPat_problem(rs.getString(6));
			pat.setPat_gender(rs.getString(7));
			pat.setPat_emer_contact(rs.getString(8));
			res.add(pat);
		}
		return res;
	}
	public int update_pat(patient p) throws SQLException {
		ps=con.prepareStatement("update patient set p_address=?,p_age=?,p_phone=?,p_problem=?,p_gender=?,p_emer_contact=? where p_id=?");
		
		ps.setInt(7, p.getPat_id());
		ps.setString(1, p.getPat_address());
		ps.setInt(2, p.getPat_age());
		ps.setString(3, p.getPat_phone());
		ps.setString(4, p.getPat_problem());
		ps.setString(5, p.getPat_gender());
		ps.setString(6, p.getPat_emer_contact());
		int i=ps.executeUpdate();
		return i;
	}
	public int status_dao(patient p)throws SQLException{
		ps=con.prepareStatement("update patient set status=? where p_name=? and p_phone=?");
		ps.setString(1, p.getActive());
		ps.setString(2, p.getPat_name());
		ps.setString(3, p.getPat_phone());
		int i=ps.executeUpdate();
		return 0;
	}
}
