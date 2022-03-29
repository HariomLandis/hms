package hospital.view;

import java.util.Scanner;

import hospital.controller.C_bill;
import hospital.controller.C_consult;
import hospital.controller.Cappointment;
import hospital.controller.Cdoctor;
import hospital.controller.Cpatient;


public class view {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "y";
		

		while (s.equals("y")) {
			System.out.println("**************MAIN MENU***************");
			
			System.out.println("press 1 if you are a patient");
			System.out.println("press 2 for appointment process");
			System.out.println("press 3 for consultation process");
			System.out.println("press 4 if you are a doctor");
			System.out.println("press 5 for billing");
			
			try {
				System.out.println("enter your choice");

				int c = sc.nextInt();
				C_bill cb=new C_bill();
				Cdoctor dc = new Cdoctor();
				Cpatient pc = new Cpatient();
				Cappointment ca=new Cappointment();
				C_consult cs=new C_consult();
				switch (c) {
				
				case 1:
					System.out.println("-------- WELCOME --------");
					System.out.println("press 1 for new registration");
					System.out.println("press 2 to see patient details using name and number");
					System.out.println("press 3 to update patients details");
					System.out.println("press 4 to Discharge");
					System.out.println("press 5 to view all the patients");
					int opt = sc.nextInt();
					switch (opt) {
					case 1:
						if (pc.createp()) {
							System.out.println("patient admitted successfully!!");
						} else {
							System.out.println("sorry can not admit the patient!!");
						}
						break;
					case 2:
						pc.show_patientdtl();
						break;
					case 3:
						pc.updatep();
						break;
					case 4:
						if (pc.update_status("n")) {
							System.out.println("can't discharge the patient!!");
						} else
							System.out.println("patient discharged successfully!!");
						break;
					case 5:
						pc.showall();
						break;			
					default:
						System.out.println("invalid choice. Try Again!!");
					}
					break;
				case 2:
					System.out.println("--------welcome--------");
					System.out.println("press 1 to book a new appointment");
					System.out.println("press 2 to cancel the appointment");
					System.out.println("press 3 to update the appointment");
					System.out.println("press 4 to view the appointment");
					System.out.println("press 5 to see all the appointments");
					System.out.println("press 6 to view the patients name, drs name along with date and time of the appointment ");
					System.out.println("enter your choice :-");
					int c1 = sc.nextInt();
					switch(c1) {
					case 1:
						ca.appoint();
						break;
					case 2:
						ca.cancel_app();
						break;
					case 3:
						ca.Cupdate();
						break;
					case 4:
						ca.Cseeone();
						break;
					case 5:
						ca.seeAll();
						break;
					case 6:
						ca.show_doc_pat_d();
						break;
					default:
						System.out.println("invalid choice");
					}
					break;
				case 3:
					System.out.println("--------welcome--------");
					System.out.println("press 1 to consult ");
					System.out.println("press 2 to cancel the consultation");
					System.out.println("press 3 to update the consultation");
					System.out.println("press 4 to view the consultation");
					System.out.println("press 5 to see all the consultation record");
					System.out.println("enter your choice :-");
					int c6 = sc.nextInt();
					switch(c6) {
					case 1:
						cs.Cregister();
						break;
					case 2:
						cs.delete();
						break;
					case 3:
						cs.update_con();
						break;
					case 4:
						cs.Cshow();
						break;
					case 5:
						cs.showA();
						break;
					default:
						System.out.println("invalid input!!");
					}
					break;
				case 4:
					System.out.println("--------welcome doc--------");
					System.out.println("press 1 if you are a new joinee");
					System.out.println("press 2 if you have resigned from the Hospital");
					System.out.println("press 3 to view your details");
					System.out.println("press 4 if you want to update your info");
					System.out.println("press 5 to see all the doctors in the hospital");
					System.out.println("enter your choice :-");
					int c3 = sc.nextInt();
					switch (c3) {
					case 1:
						dc.createp();
						break;
					case 2:
						dc.deleted();
						break;
					case 3:
						dc.show_doctordtl();
						break;
					case 4:
						dc.updated();
						break;
					case 5:
						dc.showall();
						break;
					default:
						System.out.println("wrong choice!!");
					}
					break;
				case 5:
					cb.createBill();
					break;
				default:
					System.out.println("wrong choice");
				}
				System.out.println("do you want to continue press y/n");
				s = sc.next();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
