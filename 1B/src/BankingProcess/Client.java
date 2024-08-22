package BankingProcess;

public class Client {
	
		public static void main(String[] args) {
			Bank bank = Bank.getInstance();
			bank.log("2,50,000", "2000", "200");
		}
}
