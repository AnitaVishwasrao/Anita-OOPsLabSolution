package com.gl.main;

import java.util.Scanner;

import com.gl.credentialservice.CredentialService;
import com.gl.employee.Employee;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Please enter the department from following\n1. Technical\n2. Admin\n3. Human Resource\n4.Legal");
		int dept = scanner.nextInt();
		String sDepartment = "";

		switch (dept) {
		case 1:
			sDepartment = "tech";
			break;
		case 2:
			sDepartment = "admin";
			break;
		case 3:
			sDepartment = "humanresource";
			break;
		case 4:
			sDepartment = "legal";
			break;
		default:
			sDepartment = "";
			System.out.println("Unknown department!!! Please try again");
			System.exit(0);
		}

		//Create Employee object
		System.out.print("Enter employee's first name: ");
		String firstName = scanner.next();
		System.out.print("Enter employee's last name: ");
		String lastName = scanner.next();
		Employee employee = new Employee(firstName, lastName);

		//Generate email and password for employee
		employee.setEmail(CredentialService.generateEmailAddress(employee, sDepartment, "gl"));
		employee.setPassword(CredentialService.generatePassword());

		//Display credentials
		CredentialService.showCredentials(employee);

		scanner.close();
		System.exit(0);
	}
}
