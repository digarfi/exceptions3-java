package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		try {
			Account account;
			
			System.out.println("Enter the account data");
			System.out.println();
			System.out.print("Account Number: ");
			int number = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Account Holder: ");
			String holder = sc.nextLine();
			
			System.out.print("Enter initial balance: ");
			double balance = sc.nextDouble();
			
			
			System.out.print("Enter withdrawLimit: ");
			double withdrawLimit = sc.nextDouble();
			System.out.println();
			double withdrawValue = 0;
			account = new  Account(number, holder, balance, withdrawLimit, withdrawValue);
			System.out.println(account);
			
			System.out.println();
			System.out.print("Are you going to make a deposity or withdraw(d / w): ");
			char ch = sc.next().charAt(0);
			
			if (ch == 'd') {
				System.out.print("Enter the deposity value: ");
				double deposityValue = sc.nextDouble();
				account.deposity(deposityValue);
				
				System.out.println();
				System.out.println("Upadated account data: ");
				System.out.println(account);
			}
			
			else {
				System.out.print("Enter the withdraw value: ");
				withdrawValue = sc.nextDouble();
								
				account.withdraw(withdrawValue);
				
				System.out.println("Updated account data: ");
				System.out.println(account);
				}
			}
		
			catch (DomainException e) {
				System.out.println(e.getMessage());
				}
			
			catch (InputMismatchException e) {
				System.out.println("It requires only numbers");
			}
			sc.close();
	}
}
