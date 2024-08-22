package BankingProcess;

public class Bank {
	
	private static Bank single_instance = null;
	private Bank () { }
	public static Bank getInstance() {
		if(single_instance == null) {
			single_instance = new Bank();
		}
		return single_instance;
	}
	public void log(String balance, String deposit, String withdraw) {
		System.out.println("Balance: "+balance);
		System.out.println("Deposit: "+deposit);
		System.out.println("Withdraw: "+withdraw);
	}
}
