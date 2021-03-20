
import java.io.Serializable;
 import java.util.ArrayList;

public class Bank implements Serializable {
	String bankName;
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	public Bank() {
		super();
		this.bankName = bankName;
	}
	private void addAccount(BankAccount acc) 
	{
		accounts.add(acc);
	}
	 void 	SavingsAccount (String Membername, double Accountbalance, double maxWithimit) 
	{
		SavingsAccount b1= new SavingsAccount(Membername, maxWithimit, maxWithimit);
		addAccount(b1);
		System.out.println("Success");
	}
	public void addAccount(String name, double balance, String tradeLicense) 
	{
		CurrentAccount b1= new CurrentAccount(name,balance,tradeLicense);
		addAccount(b1);
		System.out.println("Success");
	}
	private BankAccount findAccount(String accNum)
	{
		for(int i=0; i<accounts.size(); i++)
		{
			BankAccount b=accounts.get(i);
			if(b.getAccNum().equals(accNum))
				return b;
		}
		return null;
	}
	public void deposit(String accNum, double depAmount)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			b.deposit(depAmount);
			System.out.println("Amount added!");
		}
		else
		System.out.println("Account Not Found!");					
	}
	public void withdraw(String accNum, double withAmount)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			try {
				b.withdraw(withAmount);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		System.out.println("Account Not Found!");
	}
	public void display(String accNum)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			b.display();
		}
		else
			System.out.println("Account Not Found!");
	}
	public double getBalance(String accNum)
	{
		BankAccount b=findAccount(accNum);
		if(b!=null)
		{
			if(b instanceof CurrentAccount)
			return b.getBalance();
			else
				return b.getBalance();
		}
		else
			{
			System.out.println("Account Not Found!");
			return 0;
			}
	}
	public void display()
	{
		System.out.println(bankName);
		for(int i=0; i<accounts.size(); i++)
		{
			BankAccount b=accounts.get(i);
			b.display();
		}
	}
	
}
