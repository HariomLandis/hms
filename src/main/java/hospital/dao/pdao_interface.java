package hospital.dao;

import java.sql.*;
import java.util.List;

import hospital.entity.patient;

public interface pdao_interface {
	public int create_pat(patient p) throws Exception;
	public int delete_pat(patient p) throws SQLException;
	public patient show_pat_detail(patient p)throws SQLException;
	public List<patient> showall() throws SQLException;
	public int update_pat(patient p) throws SQLException;
	public int status_dao(patient p)throws SQLException;
	//public patient show_byId(patient pa) throws SQLException;
}
