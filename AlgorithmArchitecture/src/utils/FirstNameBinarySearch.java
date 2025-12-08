/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import model.Employee;
import java.util.ArrayList;

/**
 *
 * @author Breno
 */
public class FirstNameBinarySearch {
    
    public static ArrayList<Employee> binarySearchByFirstName(ArrayList<Employee> employees, String targetName) {
        
        ArrayList<Employee> results = new ArrayList<>();
        
        int left = 0;
        int right = employees.size() - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2; // avoid error if numbers are too big
            Employee midEmployee = employees.get(mid);

            int comparison = midEmployee.getFirstName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                break; // found one, stop searching
            } else if (comparison < 0) {
                left = mid + 1;     // search right half
            } else {
                right = mid - 1;    // search left half
            }
        }
            
        // No match found
        if (mid == -1 ||
            !employees.get(mid).getFirstName().equalsIgnoreCase(targetName)) {
            return results; // empty list
        }

        // Add the found match
        results.add(employees.get(mid));

        // Scan LEFT for duplicates
        int i = mid - 1;
        while (i >= 0 && employees.get(i).getFirstName().equalsIgnoreCase(targetName)) {
            results.add(employees.get(i));
            i--;
        }

        // Scan RIGHT for duplicates
        i = mid + 1;
        while (i < employees.size() && employees.get(i).getFirstName().equalsIgnoreCase(targetName)) {
            results.add(employees.get(i));
            i++;
        }

        return results;
    }
}
