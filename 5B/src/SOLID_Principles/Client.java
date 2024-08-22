package SOLID_Principles;

public class Client {
		 public static void main(String[] args) {
		     Employee emp1 = new Employee("Rushank", "Manager");
		     Employee emp2 = new Employee("Mohit", "Developer");

		     SalaryCalculator calculator = new SalaryCalculator();

		     System.out.println(emp1.getName() + "'s salary: " + calculator.calculateSalary(emp1));
		     System.out.println(emp2.getName() + "'s salary: " + calculator.calculateSalary(emp2));
		 }
		}

