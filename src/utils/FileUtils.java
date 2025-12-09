/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Breno
 */
public class FileUtils {
    
    private static ArrayList<Employee> cachedEmployees = null;
    
    /**
     * Get name file and maximum lines to read in a .txt file
     * and store Employee objects in an array.
     * if can not read the file - display error
     * @param filename the file name to be read 
     * @param maxLines maximum lines to read
     * @return an array of employees
     */
    public static ArrayList<Employee> readEmployeesFromFile(String filename, int maxLines) {
        // check if already read the file, if yes, it return the array with employees
        if (cachedEmployees != null) {
            System.out.println("Using cached data...");
            return cachedEmployees;
        }
        
        System.out.println("Reading file...");
        cachedEmployees = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            int count = 0;
            
            while ((line = br.readLine()) != null && count < maxLines) {
                // Skip header line
                if (firstLine) {
                    firstLine = false; 
                    continue;
                }
                
                String[] data = line.split(",");
                
                Employee emp = new Employee(
                    data[0], // firstName
                    data[1], // lastName
                    data[2], // gender
                    data[3], // email
                    Double.parseDouble(data[4]), // salary
                    data[5], // department
                    data[6], // position
                    data[7], // jobTitle
                    data[8]  // company
                );
                
                cachedEmployees.add(emp);
                count++;
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return cachedEmployees;
    }
        // Clear cache, next time it will read the file
        public static void clearCache() {
            System.out.println("Cache cleared!");
            cachedEmployees = null;
    }
}
