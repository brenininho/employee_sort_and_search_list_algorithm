/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithmarchitecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Employee;
import utils.*;
import utils.InputUtils;
import utils.FirstNameBinarySearch;
import utils.FirstNameMergeSort;

/**
 *
 * @author Breno, student number: 2023263
 */
public class AlgorithmArchitecture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String searchedName;
        
        InputUtils iu = new InputUtils();
        // Read file and store data in array
        ArrayList<Employee> employees = FileUtils.readEmployeesFromFile("Applicants_Form.txt", 20);
        
        //Sort the list by first name in alphabeticall order
        FirstNameMergeSort.sortByFirstName(employees);
        
        System.out.println("Employee list sorted by first name\n");
        
        searchedName = iu.askUserForText("\nWhat name would you like to search?\n");
       
        ArrayList<Employee> searchResult = FirstNameBinarySearch.binarySearchByFirstName(employees, searchedName);
        
        if (searchResult.isEmpty()) {
            System.out.println("Employee named: " + searchedName +  " not found. " );
        } else {
            // print searched employee's data
            System.out.println("Result of your search:");
            for (Employee emp : searchResult) {
                System.out.println(emp);
            }
        }
        
        // print employees data
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    
    }
}