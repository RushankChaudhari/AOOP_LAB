package All_6A_codes;

//Q(i): Task Management System Using ArrayList

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added.");
    }

    public void updateTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newDescription);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Task 2. Update Task 3. Remove Task 4. Display Tasks 5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Enter task description:");
                    String task = sc.nextLine();
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.println("Enter task number to update:");
                    int updateIndex = sc.nextInt() - 1;
                    sc.nextLine(); 
                    System.out.println("Enter new description:");
                    String newDescription = sc.nextLine();
                    taskManager.updateTask(updateIndex, newDescription);
                    break;
                case 3:
                    System.out.println("Enter task number to remove:");
                    int removeIndex = sc.nextInt() - 1;
                    taskManager.removeTask(removeIndex);
                    break;
                case 4:
                    taskManager.displayTasks();
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
