package All_6A_codes;

//Q(iv): Browsing History Using DEQUE (Double-Ended Queue)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    private Deque<String> history;
    private Deque<String> forwardStack;

    public BrowserHistory() {
        history = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
    }

    public void visitPage(String page) {
        history.push(page);
        forwardStack.clear(); 
        System.out.println("Visited: " + page);
    }

    public void goBack() {
        if (history.size() > 1) {
            forwardStack.push(history.pop());
            System.out.println("Back to: " + history.peek());
        } else {
            System.out.println("No more pages to go back to.");
        }
    }

    public void goForward() {
        if (!forwardStack.isEmpty()) {
            history.push(forwardStack.pop());
            System.out.println("Forward to: " + history.peek());
        } else {
            System.out.println("No more pages to go forward to.");
        }
    }

    public void displayCurrentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No pages visited.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Visit Page 2. Back 3. Forward 4. Display Current Page 5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter page URL:");
                    String page = sc.nextLine();
                    browser.visitPage(page);
                    break;
                case 2:
                    browser.goBack();
                    break;
                case 3:
                    browser.goForward();
                    break;
                case 4:
                    browser.displayCurrentPage();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
                    sc.close();
            }
        }
    }
}
