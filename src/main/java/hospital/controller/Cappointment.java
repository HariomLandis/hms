package hospital.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import hospital.dao.A_interface;
import hospital.dao.Appointment_dao;
import hospital.entity.appointment;
import hospital.entity.doctor;
import hospital.entity.join;
import hospital.entity.patient;

public class Cappointment {
	static appointment ap;
	static A_interface ad;
	static Scanner sc=new Scanner(System.in);
	
	public void appoint() throws Exception {
		try {
		//sc=new Scanner(System.in);
		Cdoctor cd=new Cdoctor();
		cd.findbyprob();
		
		ap=new appointment();
		ad=new Appointment_dao();
		System.out.println("enter the appointment id: ");
		int id=sc.nextInt();
		System.out.println("enter the appointment date :-");
		System.out.println("year");
		int year=sc.nextInt();
		System.out.println("month");
		int month=sc.nextInt();
		System.out.println("date");
		int date=sc.nextInt();
		LocalDate dt1=LocalDate.of(year, month, date);
		String dt=dt1.toString();
		System.out.println("enter the appointment time in HH:MM :-");
		String time=sc.next();
		System.out.println("enter the patient id :-");
		int pid=sc.nextInt();
		System.out.println("enter the doctor id :-");
		int did=sc.nextInt();
		System.out.println("enter the department of the doctor");
		String dpt=sc.next();
		
		ap.setA_id(id);
		ap.setA_date(dt);
		ap.setA_time(time);
		ap.setPat_id(pid);
		ap.setDoc_id(did);
		ap.setDep_name(dpt);
		
		
		int b=ad.capp(ap);
		if(b>0)
			System.out.println("appointment created successfully. Please be present on the chosen date and time!!");
		else
			System.out.println("could not create your appointment.. try again!!");
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("sorry the id exists please use another ID number");
		}catch(DateTimeException e2) {
			System.out.println("enter the valid date");
		}
	}
	public void cancel_app() throws SQLException {
		ad=new Appointment_dao();
		System.out.println("enter the appointment id :");
		int id=sc.nextInt();
		int i=ad.cancel(id);
		if(i>0)
			System.out.println("appointment cancelled successfully!!");
		else
			System.out.println("sorry could not cancel appointment. TRY AGAIN");
	}
	public void Cupdate()throws SQLException{
		try {
		ad=new Appointment_dao();
		ap=new appointment();
		System.out.println("enter the appointment id");
		int id=sc.nextInt();
		System.out.println("enter the updated appointment date :-");
		System.out.println("year");
		int year=sc.nextInt();
		System.out.println("month");
		int month=sc.nextInt();
		System.out.println("date");
		int date=sc.nextInt();
		LocalDate dt1=LocalDate.of(year, month, date);
		String dt=dt1.toString();
		System.out.println("enter the updated appointment time in HH:MM :-");
		String time=sc.next();
		System.out.println("enter the updated doctor id :-");
		int did=sc.nextInt();
		System.out.println("enter the updated department ");
		String dpt=sc.next();
		
		ap.setA_id(id);
		ap.setA_date(dt);
		ap.setA_time(time);
		//ap.setPat_id(pid);
		ap.setDoc_id(did);
		ap.setDep_name(dpt);
		
		int i=ad.update(ap);
		if(i>0)
			System.out.println("Appointment record updated successfully!!");
		else 
			System.out.println("sorry!! record is not updated. Try Again..");
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("please provide valid doctor id");
		}
	}
	public void Cseeone() throws SQLException {
		ad=new Appointment_dao();
		ap=new appointment();
		System.out.println("enter the appointment id");
		int id=sc.nextInt();
		ap=ad.seeOne(id);
		System.out.println(ap);
	}
	public void seeAll()throws SQLException{
		ad=new Appointment_dao();
		List<appointment> li=ad.seeAll();
		System.out.println("appointment details are:");
		for(appointment i:li) {
			System.out.println(i);
			System.out.println();
		}
	}
	public void show_doc_pat_d() throws SQLException{
		System.out.println("enter the appointment id: ");
		int id=sc.nextInt();
		ap=new appointment();
		ap.setA_id(id);
		ad=new Appointment_dao();
		List<join> li=ad.show_pat_doc_det(ap);
		for(join j:li)
			System.out.println(j);
	}
	/*public static void main(String args[]) throws SQLException {
		Cappointment ca=new Cappointment();
		ca.show_doc_pat_d();
	}*/
}
