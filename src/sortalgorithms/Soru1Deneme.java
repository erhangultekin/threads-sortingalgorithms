/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopfınal;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Soru1Deneme{
    
    static void printElement(int [] arrayElements){
         for (int i = 0; i < arrayElements.length; i++) {
             System.out.println(arrayElements[i]);   
        }
    }
    

    public static void main(String[] args) {
        
        
        int [] numbers=new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);//RANDOM SAYILAR ATILIYOR
            
            
        }
        int [] numbersBubble=Arrays.copyOf(numbers,numbers.length); //DENEYIN SAGLIKLI OLMASI ICIN AYNI VERILERI DIGER ARRAYLERE KOPYALADIM
        int [] numbersInsertion=Arrays.copyOf(numbers,numbers.length);
        int [] numbersQuickSort=Arrays.copyOf(numbers,numbers.length);
      
        System.out.println("Bubble"); //KONSOL KARISIKLIGI ICIN PRINT
        printElement(numbersBubble); // SIRALAMADAN ONCEKI ARRAY
        long startTime = new Date().getTime();//SIRALAMA ONCESI SURE
        Context context=new Context(new BubbleSort());//CONTEXT OLUSUTURULUP YAPILACAK ISLEME KARAR VERILIR
        context.executeStrategy(numbersBubble); //STRATEGY ICINDEKI SORT EXECUTE EDILIR
        long endTime = new Date().getTime(); //ISLEM SONRASI SURE
        long timeElapsed = endTime - startTime; //IKI SURE ARASINDAKI FARK
        System.out.println("------");
        printElement(numbersBubble);//SIRALANMIS LISTE
        System.out.println("Execution time milliseconds BUBBLE: " + timeElapsed);//GECEN SURE MILISANIYE CINSINDEN
        System.out.println("--------------------------------------------------");
        
        System.out.println("Insertion");
        printElement(numbersInsertion);
        long startTime1 = new Date().getTime();
        context=new Context(new InsertionSort());
        context.executeStrategy(numbersInsertion);
        long endTime1 = new Date().getTime();
        long timeElapsed1 = endTime1 - startTime1;
        System.out.println("------");
        printElement(numbersInsertion);
        System.out.println("Execution time milliseconds INSERTION: " + timeElapsed1);
        System.out.println("--------------------------------------------------");
        
        System.out.println("Quick");
        printElement(numbersQuickSort);
        long startTime2 = new Date().getTime();
        context=new Context(new QuickSort());
        context.executeStrategy(numbersQuickSort);
        long endTime2 = new Date().getTime();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("------");
        printElement(numbersQuickSort);
        System.out.println("Execution time milliseconds QUICK: " + timeElapsed2);
      
        
        
           

        
        
       
    }
    
  
    
}
