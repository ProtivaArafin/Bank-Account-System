import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
class SavingsAccount extends BankAccount implements Serializable {
	private double interest=0.05;
	private double maxWithLimit;
	
	public SavingsAccount(String memberName, double AccountBalance, double maxWithLimit) {
		super(memberName, AccountBalance,5000);
		this.maxWithLimit=maxWithLimit;
	}

	private double calculateInterest()
	{
		return getBalance()*interest;
	}
	public double getNetBalance() 
	{
		return calculateInterest()+getBalance();
	}
	public void withdraw(double withAmount)
	{
		if(withAmount<=maxWithLimit)
			try {
				super.withdraw(withAmount);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			System.out.println("Maximum Limit Exceeded");
	}
	public void display() 
	{
		super.display();
		System.out.println("; interest:" + calculateInterest() + "; maxWithdrawLimit:" + maxWithLimit);
	}
	public double getMaxWithLimit()
	{
		return maxWithLimit;
	}
	public void setmaxWithLimit(double val)
	{
		maxWithLimit=val;
	}

	
}