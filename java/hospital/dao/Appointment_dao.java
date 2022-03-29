package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.entity.appointment;
import hospital.entity.doctor;
import hospital.entity.join;

public class Appointment_dao implements A_interface{
	doctor d;
	appointment apo;
	Connection con;
	PreparedStatement ps;
	public Appointment_dao() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
	}
	
	public int capp(appointment ap) throws SQLException, ClassNotFoundException {
		ps = con.prepareStatement("insert into appointment values(?,?,?,?,?,?)");
		int i = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		ps.setInt(1, ap.getA_id());
		ps.setString(2, ap.getA_date());
		ps.setString(3, ap.getA_time());
		ps.setInt(4, ap.getPat_id());
		ps.setInt(5,ap.getDoc_id());
		ps.setString(6, ap.getDep_name());
		
		i = ps.executeUpdate();
		return i;
	}
	public int cancel(int id) throws SQLException {
		ps = con.prepareStatement("delete from appointment where a_id=?");
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	public int update(appointment a) throws SQLException {
		ps = con.prepareStatement("update appointment set a_date=?,a_time=?,doc_id=?,dept_name=? where a_id=?");
		ps.setString(1, a.getA_date());
		ps.setString(2, a.getA_time());
		ps.setInt(3, a.getDoc_id());
		ps.setString(4, a.getDep_name());
		ps.setInt(5, a.getA_id());
		return ps.executeUpdate();
	}

	public appointment seeOne(int id) throws SQLException {
		apo=new appointment();
		ps = con.prepareStatement("select * from appointment where a_id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		apo.setA_id(rs.getInt(1));
		apo.setA_date(rs.getString(2));
		apo.setA_time(rs.getString(3));
		apo.setPat_id(rs.getInt(4));
		apo.setDoc_id(rs.getInt(5));
		apo.setDep_name(rs.getString(6));
		return apo;
	}

	public List<appointment> seeAll() throws SQLException {
		List<appointment> list=new ArrayList<appointment>();
		ps = con.prepareStatement("select * from appointment");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			appointment pt=new appointment();
			pt.setA_id(rs.getInt(1));
			pt.setA_date(rs.getString(2));
			pt.setA_time(rs.getString(3));
			pt.setPat_id(rs.getInt(4));
			pt.setDoc_id(rs.getInt(5));
			pt.setDep_name(rs.getString(6));
			list.add(pt);
		}
		
		return list;
	}
	public List<join> show_pat_doc_det(appointment a) throws SQLException {
		ps = con.prepareStatement("select d.d_name, p.p_name, a.a_date,a_time from appointment a join patient p on a.p_id =p.p_id  join doctor d on a.doc_id=d.doc_id and a.a_id=?");
		ps.setInt(1, a.getA_id());
		ResultSet rs=ps.executeQuery();
		List<join> list=new ArrayList<join>();
		while(rs.next()) {
			join j=new join();
			j.setDoc_name(rs.getString(1));
			j.setPat_name(rs.getString(2));
			j.setA_date(rs.getString(3));
			j.setA_time(rs.getString(4));
			list.add(j);
		}
		return list;
	}
}
