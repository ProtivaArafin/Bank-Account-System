import java.util.Random;


abstract class BankAccount {
	protected String memberName;
	private String accNumber;
	private double accountBalance;
	private double minimumBalance;
	public BankAccount(String memberName, double accountBalance, double minimumBalance) {
		this.memberName = memberName;
		this.setAccountBalance(accountBalance);
		this.minimumBalance = minimumBalance;
		Random rand = new Random();
		accNumber ="" + rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10);
	}
	public void deposit(double depAmount)
	{
		this.setAccountBalance(this.getAccountBalance() + depAmount);
	}
	public void withdraw(double withAmount) throws InsufficientBalanceException
	{
		
		if(this.getAccountBalance()-withAmount>=minimumBalance)
			{
			this.setAccountBalance(this.getAccountBalance() - withAmount);
			System.out.println("Amount withdrawn!");
			}
		else {
			throw new InsufficientBalanceException(this.getAccountBalance()-withAmount); 
		}
	}
	public String getAccNum()
	{
		return accNumber;
	}
	public double getBalance()
	{
		return getAccountBalance();
	}
	public String getMemberName()
	{
		return memberName;
	}
	public void setMemberName(String name)
	{
		memberName=name;
	}
	public double getMinBalance()
	{
		return minimumBalance;
	}
	public void setMinBalance(double bal)
	{
		minimumBalance=bal;
	}
	public void display() 
	{
		System.out.printf("Name:%s; Account Number:%s; Balance:%lf ",memberName, accNumber, getAccountBalance());
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}