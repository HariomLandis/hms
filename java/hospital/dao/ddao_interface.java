package hospital.dao;

import java.sql.SQLException;
import java.util.List;
import hospital.entity.doctor;
import hospital.entity.patient;

public interface ddao_interface {
	public int create_doc(doctor p) throws Exception;
	public int delete_doc(doctor p) throws SQLException;
	public doctor show_doc_detail(doctor p)throws SQLException;
	public List<doctor> showall() throws SQLException;
	public int update_doc(doctor p) throws SQLException;
	public List<doctor> findbyprob_dao(patient p)throws SQLException;
}
