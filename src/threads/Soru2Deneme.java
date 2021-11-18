/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author DELL
 */
public class Soru2Deneme{
    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        
       
        
        BufferedReader br = new BufferedReader(new FileReader("Matris1.txt")); //MATRİS TXTDEN OKUNUYOR
        ArrayList<Integer> matrisIntegers = new ArrayList<>(); //MATRİS YARATILMADAN ONCE DEGEERLERI BURDA TUTULUYOR
        String line; //SATIRLAR
        int satirSayisi=0; //MATRIS ICIN GEREKLI OLAN SATIR SAYISI
        while ((line = br.readLine()) != null) { //OKUMA
            satirSayisi++;        
            String[] txtarray = line.split(" "); //TXT BOSLUKLARINA GORE SPLIT ISLEMI
            for(int s=0;s<txtarray.length;s++){
                matrisIntegers.add(Integer.parseInt(txtarray[s])); //TXT ICINDE STRING BULUNAN DEGERLERI INT'E CEVIRME
        }
        }
        int sutunSayisi=(matrisIntegers.size()/satirSayisi); //MATEMATIKSEL OLARAK SUTUN SAYISI HESAPLANIYOR
        int[][] matris1 = new int[satirSayisi][sutunSayisi]; //MATRIS OLUSTURULUYOR
        int counter=0; //ARRAYLIST ICIN GEREKLI INDEX
        for(int x=0;x<satirSayisi;x++){ //SATIR VE SUTUNA GORE INTEGER ARRAYLIST ICINDEKI DEGERLER MATRISE YAZILIYOR
            for(int j=0;j<sutunSayisi;j++){
                matris1[x][j]=matrisIntegers.get(counter);
                counter++;
            }
        }
        
        
        BufferedReader br1 = new BufferedReader(new FileReader("Matris2.txt"));
        ArrayList<Integer> matris2Integers = new ArrayList<>();
        String lines;
        int satirSayisi1=0;
        while ((lines = br1.readLine()) != null) {
            satirSayisi1++;        
            String[] txtarrays = lines.split(" ");
            for(int s=0;s<txtarrays.length;s++){
                matris2Integers.add(Integer.parseInt(txtarrays[s]));
        }
        }
        
        int sutunSayisi1=(matris2Integers.size()/satirSayisi1);
        int[][] matris2 = new int[satirSayisi1][sutunSayisi1];
        int counters=0;
        for(int x=0;x<satirSayisi1;x++){
            for(int j=0;j<sutunSayisi1;j++){
                matris2[x][j]=matris2Integers.get(counters);
                counters++;
            }
        }
           
        
        
        Buffer b=new Buffer(matris1.length,matris2[0].length); //BUFFER TAMPON BOLGESI OLUSTURULUYOR 1.MATRISIN SATIRI 2.MATRISIN SUTUNU VERILIYOR
        ExecutorService executorService = Executors.newFixedThreadPool(1); //POOL ICINDEN 1 THREAD ALINIYOR
        for(int q=0;q<matris1.length;q++){ //SATIR SAYISI KADAR THREAD MATRISMULTIPLY ISLEMI ICIN BURDA YARATILIYOR
            MultiplyWorker multiplyWorker=new MultiplyWorker(matris1[q],matris2,b, q);
            executorService.submit(multiplyWorker);
        }
        executorService.shutdown(); //KAPATILIYOR
        executorService.awaitTermination(1, TimeUnit.DAYS);
        
        b.print2D(); //2BOYUTLU LISTE PRINT
        
    
    
    
    
    
    }
    
        
        
        
        
       
    }
        
        
   
       
        
        
        
    
    

