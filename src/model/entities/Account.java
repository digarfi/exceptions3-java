package model.entities;

import model.exceptions.DomainException;

public class Account {
		private int number;
		private String holder;
		private double balance;
		private double withdrawLimit;
		private double withdrawValue;
		
		
		public Account(int number, String holder, double balance, double withdrawLimit, double withdrawValue) {
			this.number = number;
			this.holder = holder;
			this.balance = balance;
			this.withdrawLimit = withdrawLimit;
		}		
		
		public int getNumber() {
			return number;
		}
	
		public String getHolder() {
			return holder;
		}
		
		public void setHolder(String holder) {
			this.holder = holder;
		}
	
		public double getBalance() {
			return balance;
		}
			
		public double getWithdrawLimit() {
			return withdrawLimit;
		}
	   
		public void setWithdrawLimit(Double withdrawLimit) {
			this.withdrawLimit = withdrawLimit;
		}
			
		public void deposity(double amount) {
		   balance += amount;
		}
	
		public void withdraw(double amount) {
		   withdrawValue(amount);
		   balance -= amount;
		}
	
	
		private void withdrawValue(double amount) {
		   if (amount > getBalance()){
			   throw new DomainException("Withdraw error. Insuficiente balance for withdraw");
		   }
		   
		   
		   if (amount > getWithdrawLimit()) {
			   throw new DomainException("Withdraw error. The amount exceeds withdraw limit");
		   }
		   
		}
	 	   
		public String toString() {
			return "Account "
					+ number
					+ ", Holder: "
					+ holder
					+ ", Balance: $ "
					+ String.format("%.2f", balance)
					+ ", Withdraw Limit: $ "
					+ String.format("%.2f", withdrawLimit);
		}
}
