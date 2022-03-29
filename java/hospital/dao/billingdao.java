package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hospital.entity.billing;

public class billingdao implements ibillingdao{
	Connection con;
	PreparedStatement ps;
	public billingdao() throws SQLException, ClassNotFoundException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		
	}
	public int create(billing b) throws SQLException {
		int i=0;
		ps=con.prepareStatement("insert into billing values(?,?)");
		ps.setInt(1, b.getB_id());
		ps.setInt(2, b.getD_id());
		i= ps.executeUpdate();
		return i;
	}

	public int bill(int b_id) throws SQLException {
		ps=con.prepareStatement("select d.d_fee from billing b join doctor d where b.doc_id=d.doc_id and b.b_id=?");
		ps.setInt(1, b_id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		return i;
	}
}
