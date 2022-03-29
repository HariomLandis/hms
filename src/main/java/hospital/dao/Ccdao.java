package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.controller.C_consult;
import hospital.entity.consult;
import hospital.entity.doctor;

public class Ccdao implements C_dao{
	consult c;
	Connection con;
	PreparedStatement ps;
	public Ccdao() throws SQLException, ClassNotFoundException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		
	}
	public int create(consult c) throws ClassNotFoundException, SQLException {
		ps = con.prepareStatement("insert into consult values(?,?,?,?,?,?)");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		ps.setInt(1, c.getA_id());
		ps.setDouble(2, c.getCfee());
		ps.setString(3, c.getPmeds());
		ps.setString(4, c.getFdate());
		ps.setString(5,c.getFtime());
		ps.setInt(6,c.getA_id());

		
		return ps.executeUpdate();
	}

	public int cancel(consult c) throws SQLException {
		ps = con.prepareStatement("delete from consult where c_id=?");
		ps.setInt(1, c.getC_id());
		return ps.executeUpdate();
	}

	public consult show(consult c4) throws SQLException {
		List<consult> list = new ArrayList<consult>();
		ps = con.prepareStatement("select * from consult where c_id=?");
		ps.setInt(1, c4.getC_id());
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		consult c3 = new consult();
		c3.setA_id(rs.getInt(1));
		c3.setCfee(rs.getDouble(2));
		c3.setPmeds(rs.getString(3));
		c3.setFdate(rs.getString(4));
		c3.setFtime(rs.getString(5));
		c3.setA_id(rs.getInt(6));
		return c3;
	}
	public List<consult> showAll() throws SQLException{
		List<consult> list = new ArrayList<consult>();
		ps = con.prepareStatement("select * from consult");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			consult c3 = new consult();
			c3.setA_id(rs.getInt(1));
			c3.setCfee(rs.getDouble(2));
			c3.setPmeds(rs.getString(3));
			c3.setFdate(rs.getString(4));
			c3.setFtime(rs.getString(5));
			c3.setA_id(rs.getInt(6));
			list.add(c3);
		}
		return list;
	}
	public int update(consult c) throws SQLException {
		ps = con.prepareStatement("update consult set cfee=?,pmeds=?,fdate=?,ftime=?,a_id=? where c_id=?");
		ps.setInt(6, c.getC_id());
		ps.setDouble(1, c.getCfee());
		ps.setString(2, c.getPmeds());
		ps.setString(3, c.getFdate());
		ps.setString(4,c.getFtime());
		ps.setInt(5,c.getA_id());
		return ps.executeUpdate();
	}
}
