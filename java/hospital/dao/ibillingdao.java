package hospital.dao;

import java.sql.SQLException;

import hospital.entity.billing;

public interface ibillingdao {
	public int create(billing b) throws SQLException;
	public int bill(int b) throws SQLException;
}
