/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithmarchitecture;

import java.util.ArrayList;
import model.Employee;
import utils.*;

/**
 *
 * @author Breno, student number: 2023263
 */
public class AlgorithmArchitecture {

    private static ArrayList<Employee> employees = null;
    private static boolean isSorted = false;
    private static InputUtils iu = new InputUtils();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--- Employee Management System ---\\n");
        
        // Load file
        loadFile();
        
        // Open the menu
        if (employees != null && !employees.isEmpty()) {
            showMenu();
        } else {
            System.out.println("Error: Could not load employees. Exiting...");
    }
}
    private static void loadFile() {
        String filename = "Applicants_Form.txt";
        employees = FileUtils.readEmployeesFromFile(filename, 20);

        if (employees != null && !employees.isEmpty()) {
            System.out.println("Successfully loaded " + employees.size() + " employees.\n");
        }
    }
        
    private static void showMenu() {
        while (true) {
            int choice = iu.askUserForInt("""
                                          \n=== MENU ===
                                          1. Display Employee list
                                          2. Sort
                                          3. Search
                                          4. Add Records
                                          5. Create a Binary Tree
                                          6. Exit
                                          Choose an option: 
                                          """
            );
            MenuOptions option = getUserOption(choice);
            
            switch (option) {
                case Display_Employees:
                    displayEmployees();
                    break;
                case Sort_Employee:
                    sortEmployees();
                    break;
                case Search_Employee:
                    searchEmployee();
                    break;
                case Add_Employee_Records:
                    addRecord();
                    break;
                case Create_Binary_Tree:
                    createBinaryTree();
                    break;
                case Exit:
                    System.out.println("Exiting... See you next time!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5");
            }
        }
    }
    
    private static MenuOptions getUserOption(int userChoice) {
        return switch (userChoice) {
            case 1 -> MenuOptions.Display_Employees;
            case 2 -> MenuOptions.Sort_Employee;
            case 3 -> MenuOptions.Search_Employee;
            case 4 -> MenuOptions.Add_Employee_Records;
            case 5 -> MenuOptions.Create_Binary_Tree;
            case 6 -> MenuOptions.Exit;
            default -> null;
        };
        
}
    
    private static void sortEmployees() {
        System.out.println("\n--- Sort Employees ---");
        System.out.println("Sorting by first name...");
        
        FirstNameMergeSort.sortByFirstName(employees);
        isSorted = true;
        
        System.out.println("Employees sorted successfully!\n");
        System.out.println("Sorted list:");
        displayEmployees();
    }
    
    private static void searchEmployee() {
        System.out.println("\n--- Search Employee ---");
        
        // Warning the user and check if is sorted
        if (!isSorted) {
            System.out.println("WARNING: The Employee list is not sorted!");
            System.out.println("The search requires sorted data for accurate results.");
            String response = iu.askUserForText("Would you like to sort the list first? (y/n): ");
            
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                sortEmployees();
            } else {
                System.out.println("Returning to menu...");
                return;
            }
        }
        
        String searchedName = iu.askUserForText("Enter first name to search: ");
        ArrayList<Employee> searchResult = FirstNameBinarySearch.binarySearchByFirstName(employees, searchedName);
        
        if (searchResult.isEmpty()) {
            System.out.println("Employee named '" + searchedName + "' not found.");
        } else {
            System.out.println("\n Found " + searchResult.size() + " employee(s):");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println((i + 1) + ". " + searchResult.get(i));
            }
        }
    }
        
    private static void addRecord() {
        System.out.println("\n--- Add Employee Record ---");
        
        String firstName = iu.askUserForText("Insert first name");
        String lastName = iu.askUserForText("Insert last name");
        String gender = iu.askUserForText("Insert gender");
        String email = iu.askUserForEmail("Insert email");
        double salary = iu.askUserForDouble("Insert salary");
        String department = iu.askUserForText("Insert department");
        String position = iu.askUserForText("Insert position");
        String jobTitle = iu.askUserForText("Insert job title");
        String company = iu.askUserForText("Insert company");
        
        Employee emp = new Employee(
                    firstName, // firstName
                    lastName, // lastName
                    gender, // gender
                    email, // email
                    salary, // salary
                    department, // department
                    position, // position
                    jobTitle, // jobTitle
                    company  // company
                );
        employees.add(emp);
        
        // set isSorted = false after adding
        isSorted = false;
        
        System.out.println("Employee registered: \n" + emp);
    }
    
    private static void createBinaryTree() {
        System.out.println("\n--- Create Binary Tree ---");
        System.out.println("This feature will be implemented later.");
        
        // TODO: Implement later
    }
    
    private static void displayEmployees() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }
}