/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopfınal;

/**
 *
 * @author DELL
 */
public class InsertionSort implements Strategy{

    @Override
    public void sortOperation(int[] numbers) {
        int n = numbers.length; 
        for (int i = 1; i < n; ++i) { 
            int key = numbers[i]; 
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) { 
                numbers[j + 1] = numbers[j]; 
                j = j - 1; 
            } 
            numbers[j + 1] = key; 
        }
    } 
}
