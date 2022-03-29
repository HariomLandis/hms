package hospital.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import hospital.dao.pdao;
import hospital.dao.pdao_interface;
import hospital.entity.patient;

public class Cpatient {
	
	patient p;
	pdao_interface pi;
	Scanner sc=new Scanner(System.in);
	
	public boolean createp() throws Exception {
		int i = 0;
		try {
			pi = new pdao();
			p = new patient();
			System.out.println("enter the id: ");
			int id = sc.nextInt();
			System.out.println("enter patient name: ");
			String name = sc.next();
			// sc.nextLine();
			System.out.println("enter the address: ");
			String address = sc.next();
			System.out.println("enter the age :");
			int age = sc.nextInt();
			System.out.println("enter the phone number :");
			String phone = sc.next();
			System.out.println("enter the problem suffering with :");
			String problem = sc.next();
			System.out.println("enter the gender :");
			String gender = sc.next();
			System.out.println("enter the emergency contact number :");
			String emer_contact = sc.next();
			System.out.println("enter the status \n1.y for ill \n2. n for not ill");
			String status = sc.next();
			p.setPat_id(id);
			p.setPat_name(name);
			p.setPat_address(address);
			p.setPat_age(age);
			p.setPat_phone(phone);
			p.setPat_problem(problem);
			p.setPat_gender(gender);
			p.setPat_emer_contact(emer_contact);
			p.setActive(status);
			i = pi.create_pat(p);
		} catch (InputMismatchException e) {
			System.out.println("please provide the proper input");
		} catch (SQLIntegrityConstraintViolationException e1) {
			System.out.println("id is already in use please choose other id number and try again");
		}
		if (i > 0)
			return true;
		return false;

	}
	public void deletep() throws SQLException {
		pi=new pdao();
		p=new patient();
		System.out.println("enter the patient id you want to delete :");
		int id=sc.nextInt();
		p.setPat_id(id);
		int i=pi.delete_pat(p);
		if(i>0)
			System.out.println("patient discharged successfully!!");
		else {
			System.out.println("can not discharge patient!!");
		}
	}
	public void show_patientdtl() throws SQLException {
		p=new patient();
		pi=new pdao();
		
		System.out.println("enter the name of the patient: ");
		String name=sc.next();
		System.out.println("enter the phone number");
		String num=sc.next();
		p.setPat_name(name);
		p.setPat_phone(num);
		patient r=pi.show_pat_detail(p);
		
		System.out.println(r);
	}
	public void showall() throws SQLException{
		pi=new pdao();
		
		List<patient> b=pi.showall();
		System.out.println("total patients in the record are :-");
		for(patient i:b)
			System.out.println(i);
	}
	public void updatep() throws Exception{
		p=new patient();
		pi=new pdao();
		System.out.println("enter name: ");
		String name=sc.next();
		System.out.println("enter phone number: ");
		String num=sc.next();
		patient pati=new patient();
		pati.setPat_name(name);
		pati.setPat_phone(num);
		patient ans=pi.show_pat_detail(pati);
		if(ans!=null) {
			System.out.println("your current details are :-"+ans);
			
			System.out.println("enter updated address: ");
			String address=sc.next();
			System.out.println("enter updated age :");
			int age=sc.nextInt();
			System.out.println("enter updated phone number :");
			String phone=sc.next();
			System.out.println("enter updated problem suffering with :");
			String problem=sc.next();
			System.out.println("enter updated gender :");
			String gender=sc.next();
			System.out.println("enter updated emergency contact number :");
			String emer_contact=sc.next();
			
			p.setPat_id(ans.getPat_id());
			p.setPat_name(ans.getPat_name());
			p.setPat_address(address);
			p.setPat_age(age);
			p.setPat_phone(phone);
			p.setPat_problem(problem);
			p.setPat_gender(gender);
			p.setPat_emer_contact(emer_contact);
			int i=pi.update_pat(p);
			if(i>0)
				System.out.println("Patients Record updated successfully!!");
			else 
				System.out.println("Could not update records.. try again!!");
		}
	}
	public boolean update_status(String status) throws SQLException {
		p=new patient();
		pi=new pdao();
		System.out.println("enter the name :");
		String name=sc.next();
		System.out.println("enter the phone number");
		String num=sc.next();
		p.setActive(status);
		p.setPat_name(name);
		p.setPat_phone(num);
		int i=pi.status_dao(p);
		if(i>0)
			return true;
		return false;
	}
	/*public static void main(String args[]) throws Exception{
		Cpatient cp=new Cpatient();
		cp.updatep();
	}*/
}
