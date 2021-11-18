/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MultiplyWorker implements Runnable {

    public Buffer buffer;
    int ilkmatris[];
    int ikincimatris[][];
    int islemgorenSatir;

    public MultiplyWorker(int ilkmatris[], int ikincimatris[][], Buffer buffer, int islemgorenSatir) {
        this.ilkmatris = ilkmatris;
        this.ikincimatris = ikincimatris;
        this.buffer = buffer;
        this.islemgorenSatir = islemgorenSatir;
    }

    @Override
    public void run() {
        int sum = 0; //TOPLAMA ISLEMI
        int counter = 0; //IKINCI MATRIS ICINDE GEZEBILMEK ICIN INT DEGER
        for (int s = 0; s < ikincimatris[0].length; s++) { //SUTUN SAYISI
            sum = 0;
            for (int i : ilkmatris) { // MATRIS1 ICINDE BULUNAN TUM DEGERLER SIRAYLA SUTUNLARLA CARPILIYOR
                sum += i * (ikincimatris[counter][s]); //CARPILAN SONUCLAR TOPLANIYOR
                counter++;
            }try{
                System.out.println("Thread uyutuldu..."); //THREAD UYUTMA ISLEMI
                Thread.sleep(1000); //SLEEP
                System.out.println("Değer hesaplanıyor..."); //ACIKLAYICI PRINT
                Thread.sleep(1000); //DEMO ICIN PRINT
                System.out.println("Hesaplanan değer :"+sum); // BUFFERA GONDERILMEDEN ONCE SUM ISLEMI
                buffer.put(sum, islemgorenSatir, s); //BUFFER TAMPON BOLGEYE AKTARILAN DEGER
            }catch (InterruptedException ex) {
                Logger.getLogger(MultiplyWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter = 0;
        }
    }
}
