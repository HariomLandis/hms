package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.entity.appointment;
import hospital.entity.join;

public interface A_interface {
	//to create the appointment
	public int capp(appointment ap) throws SQLException, ClassNotFoundException ;
	//to cancel the appointment
	public int cancel(int id) throws SQLException;
	//to update the appointment
	public int update(appointment a) throws SQLException;
	//to search and view the appointment
	public appointment seeOne(int id) throws SQLException;
	//to see all the appointments
	public List<appointment> seeAll() throws SQLException;
	//to see patient and assigned doctors name 
	public List<join> show_pat_doc_det(appointment a) throws SQLException ;
}
