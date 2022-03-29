package hospital.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hospital.dao.ddao;
import hospital.dao.ddao_interface;
import hospital.dao.pdao;
import hospital.entity.doctor;
import hospital.entity.patient;

public class Cdoctor {
	doctor d;
	ddao_interface di;
	Scanner sc=new Scanner(System.in);
	public void createp() throws Exception {
		di=new ddao();
		d=new doctor();
		System.out.println("enter the id: ");
		int id=sc.nextInt();
		System.out.println("enter doctor name: ");
		String name=sc.next();
		//sc.nextLine();
		System.out.println("enter the address: ");
		String address=sc.next();
		System.out.println("enter the age :");
		int age=sc.nextInt();
		System.out.println("enter the phone number :");
		String phone=sc.next();
		System.out.println("enter the department :");
		String dept=sc.next();
		System.out.println("enter the gender :");
		String gender=sc.next();
		System.out.println("enter the speciality :");
		String emer_contact=sc.next();
		System.out.println("enter your fee per appointment");
		int d_fee=sc.nextInt();
		
		d.setD_id(id);
		d.setD_name(name);
		d.setD_address(address);
		d.setD_age(age);
		d.setD_phone(phone);
		d.setD_dept(dept);
		d.setD_gender(gender);
		d.setD_specialist(emer_contact);
		d.setD_fee(d_fee);
		
		
		int i=di.create_doc(d);
		if(i>0)
			System.out.println("doctor id created successfully!!");
		else
			System.out.println("Sorry can't create id.. try again!!");
	}
	public void deleted() throws SQLException, ClassNotFoundException {
		di=new ddao();
		d=new doctor();
		System.out.println("enter the doctors name  :");
		String name=sc.nextLine();
		System.out.println("enter the phone number :");
		String num=sc.next();
		d.setD_name(name);
		d.setD_phone(num);
		int i=di.delete_doc(d);
		if(i>0)
			System.out.println("record deleted successfully!!");
		else {
			System.out.println("can not delete record!!");
		}
	}
	public void show_doctordtl() throws SQLException, ClassNotFoundException {
		d=new doctor();
		di=new ddao();
		System.out.println("enter the name of the doctor who's detail you want to see: ");
		String name=sc.next();
		System.out.println("enter the phone number :-");
		String num=sc.next();
		d.setD_phone(num);
		d.setD_name(name);
		doctor r=di.show_doc_detail(d);
		System.out.println("details of the doctor are :-");
		System.out.println(r);
	}
	public void showall() throws SQLException, ClassNotFoundException{
		di=new ddao();
		
		List<doctor> b=di.showall();
		System.out.println("total doctors in the record and there details are below :-");
		for(doctor i:b)
			System.out.println(i);
	}
	public void findbyprob()throws SQLException, ClassNotFoundException{
		patient pd=new patient();
		System.out.println("enter the speciliast domain you want to see:-");
		String s=sc.next();
		pd.setPat_problem(s);
		di =new ddao();
		List<doctor> b=di.findbyprob_dao(pd);
		System.out.println("If doctors are available please remember their ID number-:");
		if (b.isEmpty()) 
			System.out.println("sorry no doctors are available for " + s);
		else {
			System.out.println("available " + s + "s are :-");
			for (doctor d : b)
				System.out.println(d);
		}
		
	}
	public void updated() throws Exception{
		d=new doctor();
		di=new ddao();
		System.out.println("enter name: ");
		String name1=sc.next();
		System.out.println("enter phone number:");
		String num=sc.next();
		doctor doc=new doctor();
		doc.setD_name(name1);
		doc.setD_phone(num);
		doctor ans=di.show_doc_detail(doc);
		//int id=ans.getD_id();
		if(ans!=null) {
			System.out.println("your old details are :-"+ans);
			
			System.out.println("enter updated address: ");
			String address=sc.next();
			System.out.println("enter updated age :");
			int age=sc.nextInt();
			System.out.println("enter updated phone number :");
			String phone=sc.next();
			System.out.println("enter updated department :");
			String dept=sc.next();
			System.out.println("enter updated gender :");
			String gender=sc.next();
			System.out.println("enter updated speciality :");
			String spec=sc.next();
			System.out.println("enter the updated fee");
			int d_fee=sc.nextInt();
			
			d.setD_id(ans.getD_id());
			d.setD_name(name1);
			d.setD_address(address);
			d.setD_age(age);
			d.setD_phone(phone);
			d.setD_dept(dept);
			d.setD_gender(gender);
			d.setD_specialist(spec);
			d.setD_fee(d_fee);
			
			int i=di.update_doc(d);
			if(i>0)
				System.out.println("Record update successfully!!");
			else 
				System.out.println("Could not update the records.. try again!!");
		}
	}
	/*public static void main(String args[]) throws SQLException {
		Cdoctor cd=new Cdoctor();
		cd.findbyprob();
	}*/
}
