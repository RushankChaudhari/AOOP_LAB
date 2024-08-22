package SOLID_Principles;

public class MessageServiceMain {
	 public static void main(String[] args) {
	     MessageService emailService = new EmailService();
	     MessageService smsService = new SMSService();

	     MyApplication app1 = new MyApplication(emailService);
	     app1.processMessage("Hello via Email!");

	     MyApplication app2 = new MyApplication(smsService);
	     app2.processMessage("Hello via SMS!");
	 }

}
