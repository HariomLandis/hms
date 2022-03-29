package hospital.controller;
import java.sql.SQLException;
import java.util.Scanner;

import hospital.dao.billingdao;
import hospital.entity.billing;
public class C_bill {
	billing b;
	billingdao bd;
	public C_bill() throws ClassNotFoundException, SQLException {
		bd=new billingdao();
	}
	public void createBill() throws SQLException {
		try {
			b = new billing();
			System.out.println("enter the billing id: ");
			Scanner sc = new Scanner(System.in);
			int b_id = sc.nextInt();
			System.out.println("enter the doctors id: ");
			int doc_id = sc.nextInt();

			b.setB_id(b_id);
			b.setD_id(doc_id);

			int i = bd.create(b);
			sc.close();
			if (i > 0) {
				int res = bd.bill(b_id);
				System.out.println("you have to pay "+res+"  INR");
			} else
				System.out.println("invalid credentials!!");
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("this doctor id does not exist or billing id already exists. Try Again.");
		}
		
	}

}
