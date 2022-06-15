package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank_Account_Assignment {
	int accountNo;
	String name;
	String pinNo;
	String password;
	int balance;
	public Bank_Account_Assignment() {
		
	}
	public Bank_Account_Assignment(String name,String pinNo,String password,int balance) {
		this.name = name;
		this.pinNo = pinNo;
		this.password = password;
		this.balance = balance;
	}
	void Deposit(int balance_) {
		System.out.println("Current balance ->" +this.balance);
		this.balance += balance_;
		System.out.println("Deposit balance ->" +this.balance);
	}
	void Withdraw(int balance_) {
		if(balance_ > this.balance) {
			System.out.println("Balance is not emough!");
		}
		else {
			System.out.println("Current balance ->" +this.balance);
			this.balance -= balance_;
			System.out.println("Reamin balance: " + this.balance);
			System.out.println("Widthdraw balance -> " + balance_);
		}
	}
	void changePassword(String change) {
		this.password = change;
		System.out.println("Success");
	}
	void showInfo() {
		System.out.println("Holder name -> " +name);
		System.out.println("PinNo ->" + pinNo);
		System.out.println("Password ->" + password);
		System.out.println("Reamin balance: " + balance);
	}
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);) {
			System.out.print("Enter Account number : ");
			int accountNo = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			System.out.print("Enter your pin number: ");
			String pinNo = sc.nextLine();
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			System.out.print("Enter your balance: ");
			int balance = sc.nextInt();
			
			Bank_Account_Assignment bank1 = new Bank_Account_Assignment(name, pinNo, password, balance);
			System.out.print("\nDeposit amount: ");
			int deposit = sc.nextInt();
			bank1.Deposit(deposit);
			
			System.out.print("\nWithdraw amount: ");
			int withdraw = sc.nextInt();
			bank1.Withdraw(withdraw);
			sc.nextLine();
			System.out.print("Enter your pin No: ");
			String pin = sc.nextLine();
			if(pin.equals(bank1.pinNo)) {
				System.out.print("Change password: ");
				String passw = sc.nextLine();
				bank1.changePassword(passw);
			}else {
				System.err.println("Invalid pin number!");
				System.err.println("Password does not change!");
				return;
			}
			bank1.showInfo();
		} catch (InputMismatchException e) {
			System.err.println("Only must be number!");
		}
	}
}
