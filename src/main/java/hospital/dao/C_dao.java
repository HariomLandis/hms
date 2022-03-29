package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.entity.consult;

public interface C_dao {
	public int create(consult c) throws ClassNotFoundException, SQLException;
	public int cancel(consult c) throws SQLException;
	public consult show(consult c) throws SQLException;
	public List<consult> showAll() throws SQLException;
	public int update(consult c) throws SQLException;
	
	
}
