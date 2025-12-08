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
public class FirstNameMergeSort {
    
    public static void sortByFirstName(ArrayList<Employee> employees) {
        if (employees.size() <= 1) return;

        Employee[] arr = employees.toArray(new Employee[0]);
        mergeSortByFirstName(arr, 0, arr.length - 1);

        // Update the original list with sorted array
        employees.clear();
        for (Employee emp : arr) {
            employees.add(emp);
            
        }
    }
    
    private static void mergeSortByFirstName(Employee[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortByFirstName(arr, left, mid);
            mergeSortByFirstName(arr, mid + 1, right);
            mergeByFirstName(arr, left, mid, right);
        }
    }
    
    private static void mergeByFirstName(Employee[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];
        
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].getFirstName().compareTo(R[j].getFirstName()) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
