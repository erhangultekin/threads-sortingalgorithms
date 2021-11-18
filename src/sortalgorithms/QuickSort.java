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
public class QuickSort implements Strategy{

    @Override
    public void sortOperation(int[] numbers) {
        recursiveQuickSort(numbers, 0, numbers.length - 1);
    }
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx){
        int idx = partition(array, startIdx, endIdx);
        if (startIdx < idx - 1) { 
            recursiveQuickSort(array, startIdx, idx - 1); 
        }
        if (endIdx > idx) { 
            recursiveQuickSort(array, idx, endIdx); 
        }
        
    }
    
    public static int partition(int[] array, int left, int right){
        int pivot = array[left];
        while (left <= right){
            while (array[left] < pivot){
                left++;
            }
        
        while (array[right] > pivot){
            right--;
        }
        
        if (left <= right){
            int tmp = array[left]; 
            array[left] = array[right]; 
            array[right] = tmp;
            left++;
            right--;
        }
        }
        return left;
        
    }


    
}
