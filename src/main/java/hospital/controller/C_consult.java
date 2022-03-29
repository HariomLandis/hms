package hospital.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import hospital.dao.C_dao;
import hospital.dao.Ccdao;
import hospital.entity.consult;

public class C_consult {
	Scanner sc=new Scanner(System.in);
	consult c;
	C_dao cd;
	public C_consult() throws ClassNotFoundException, SQLException {
		cd=new Ccdao();
	}
	
	public void Cregister() throws ClassNotFoundException, SQLException {
		try {
		System.out.println("enter the consultation id");
		int id=sc.nextInt();
		System.out.println("enter the consultant fee: ");
		double fee=sc.nextDouble();
		System.out.println("enter the prescribed medicines: ");
		String pmeds=sc.next();
		
		System.out.println("enter the follow up date: ");
		System.out.println("year");
		int year=sc.nextInt();
		System.out.println("month");
		int month=sc.nextInt();
		System.out.println("date");
		int date=sc.nextInt();
		LocalDate dt1=LocalDate.of(year, month, date);
		String fdate=dt1.toString();
		System.out.println("enter the follow up time in HH:MM :-");
		String ftime=sc.next();
		System.out.println("enter the appointment id: ");
		int a_id=sc.nextInt();
		
		c=new consult();
		c.setC_id(id);
		c.setCfee(fee);
		c.setPmeds(pmeds);
		c.setFdate(fdate);
		c.setFtime(ftime);
		c.setA_id(a_id);
		
		int i=cd.create(c);
		if(i>0)
			System.out.println("consultation result submitted successfully");
		else
			System.out.println("sorry could not finish the consultation result");
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Please enter the valid appointment id");
		}catch(DateTimeException e2) {
			System.out.println("enter the valid date");
		}
		
	}
	public void delete() throws ClassNotFoundException, SQLException {
		System.out.println("enter the id of the consultation to delete: ");
		int id=sc.nextInt();
		c=new consult();
		c.setC_id(id);
		
		if(cd.cancel(c)>0) 
			System.out.println("record deleted successfully");
		else 
			System.out.println("sorry con not delete the record");
	}
	public void Cshow() throws SQLException {
		c=new consult();
		System.out.println("enter the consultation id to view the details");
		int id=sc.nextInt();
		c.setC_id(id);
		consult ans=cd.show(c);
		System.out.println("details are :- "+ans);
	}
	public void showA() throws SQLException{
		List<consult> list=cd.showAll();
		System.out.println("consultation record is :-");
		for(consult c:list)
			System.out.println(c);
	}
	public void update_con()throws SQLException{
		try {
		c=new consult();
		System.out.println("enter the consultation id of record whos details you want to update ");
		int cid=sc.nextInt();
		System.out.println("enter the updated consultant fee: ");
		double fee=sc.nextDouble();
		System.out.println("enter the updated prescribed medicines: ");
		String pmeds=sc.next();
		System.out.println("enter the updated follow up date: ");
		System.out.println("year");
		int year=sc.nextInt();
		System.out.println("month");
		int month=sc.nextInt();
		System.out.println("date");
		int date=sc.nextInt();
		LocalDate dt1=LocalDate.of(year, month, date);
		String fdate=dt1.toString();
		System.out.println("enter the updated follow up time in HH:MM :-");
		String ftime=sc.next();
		System.out.println("enter the updated appointment id: ");
		int a_id=sc.nextInt();
		
		c.setC_id(cid);
		c.setCfee(fee);
		c.setPmeds(pmeds);
		c.setFdate(fdate);
		c.setFtime(ftime);
		c.setA_id(a_id);
		
		int i=cd.update(c);
		if(i>0)
			System.out.println("update successfully");
		else
			System.out.println("sorry, could not update!!");
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Please provide the valid appointment ID");
		}
		
	}
	/*public static void main(String args[]) throws ClassNotFoundException, SQLException {
		C_consult ci=new C_consult();
		ci.delete();
	}*/
}
