package SOLID_Principles;

interface MessageService {
 void sendMessage(String message);
}

class EmailService implements MessageService {
 @Override
 public void sendMessage(String message) {
     System.out.println("Email sent: " + message);
 }
}

class SMSService implements MessageService {
 @Override
 public void sendMessage(String message) {
     System.out.println("SMS sent: " + message);
 }
}

class MyApplication {
 private MessageService messageService;

 public MyApplication(MessageService messageService) {
     this.messageService = messageService;
 }

 public void processMessage(String message) {
     messageService.sendMessage(message);
 }
}

