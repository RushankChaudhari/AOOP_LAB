package All_6A_codes;

//Q(iii): Customer Support Ticket System Using Queue Interface

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerSupport {
    private Queue<String> tickets;

    public CustomerSupport() {
        tickets = new LinkedList<>();
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
        System.out.println("Ticket added.");
    }

    public void processNextTicket() {
        if (!tickets.isEmpty()) {
            System.out.println("Processing ticket: " + tickets.poll());
        } else {
            System.out.println("No tickets to process.");
        }
    }

    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending tickets: " + tickets);
        }
    }

    public static void main(String[] args) {
        CustomerSupport support = new CustomerSupport();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Ticket 2. Process Next Ticket 3. Display Tickets 4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter ticket description:");
                    String ticket = sc.nextLine();
                    support.addTicket(ticket);
                    break;
                case 2:
                    support.processNextTicket();
                    break;
                case 3:
                    support.displayTickets();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
                    sc.close();
                    
            }
        }
    }
}
