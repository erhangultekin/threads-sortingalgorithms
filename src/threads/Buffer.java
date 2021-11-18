/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class Buffer {
    public int satir = 0;
    public int sutun = 0;
    public int sonucmatrisi[][];
    
    
    public Buffer(int satir, int sutun) {
        this.satir=satir;
        this.sutun=sutun;
        sonucmatrisi = new int[satir][sutun]; //SATIR VE SUTUNA GORE OLUSTURULUYOR
    }
    
    public synchronized void put(int sum,int hangisatir,int hangisutun) throws InterruptedException {
            sonucmatrisi[hangisatir][hangisutun]=sum; //TAMPON BOLGEYE MULTIPLY THREADINDEN GELEN DEGERI SONUC MATRISINE YAZIYOR
    }
     public void print2D() 
    {
        System.out.println("--Matrisin son hali--"); //MATRISIN 2D PRINTI
        for (int i = 0; i < sonucmatrisi.length; i++) {
            for (int j = 0; j < sonucmatrisi[i].length; j++) {
                System.out.printf("%5d ",sonucmatrisi[i][j]);
            }
                 System.out.println(" ");
            }  
    }        
}
