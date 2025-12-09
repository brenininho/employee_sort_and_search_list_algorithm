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
            System.out.println("\n=== MENU ===");
            System.out.println("1. Sort");
            System.out.println("2. Search");
            System.out.println("3. Add Records");
            System.out.println("4. Create a Binary Tree");
            System.out.println("5. Exit");
            
            int choice = iu.askUserForInt("Choose an option: ");
            
            
            switch (choice) {
                case 1:
                    sortEmployees();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    addRecord();
                    break;
                case 4:
                    createBinaryTree();
                    break;
                case 5:
                    System.out.println("Exiting... See you next time!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5");
            }
        }
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
        System.out.println("This feature will be implemented later.");
        
        // TODO: set isSorted = false after adding
        // isSorted = false;
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