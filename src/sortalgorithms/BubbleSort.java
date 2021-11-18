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
public class BubbleSort implements Strategy{

    @Override
    public void sortOperation(int[] numbers) {
        int n = numbers.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (numbers[j] > numbers[j+1]) 
                {  
                    int temp = numbers[j]; 
                    numbers[j] = numbers[j+1]; 
                    numbers[j+1] = temp; 
                }
    }
}
