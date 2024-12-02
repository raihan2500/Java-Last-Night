package Inheritance.E91;

public class Test {
    public static void main(String[] args) {
        Employee raihan = new Employee("Raihan", 50);
        Manager manager = new Manager("Manager", 60, 30);

        Employee employee = new Manager("raihan", 23, 42);
        System.out.println(manager);
    }
}
