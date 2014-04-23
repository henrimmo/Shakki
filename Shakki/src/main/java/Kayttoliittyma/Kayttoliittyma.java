/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import shakki.Lauta;

/**
 *
 * @author Henri
 */
public class Kayttoliittyma {
    
    private Lauta lauta;
    private Scanner lukija = new Scanner(System.in);
    private boolean jatkuu;
    
    public Kayttoliittyma(Lauta lauta) {
        this.lauta = lauta;
    }
    
    public void aloita() {
        int komento;
        
        while(true) {
            komento = valikko();
            
            if(komento == 0) {
                break;
            }
            
            if(komento == 1) {
                aloitaPeli();
            }
        }
    }
    
    public int valikko() {
        System.out.println("Komennot:");
        System.out.println("1 = ALOITA PELI");
        System.out.println("0 = LOPETA");
        int komento = lukija.nextInt();
//        if ( komento != 0 || komento != 1) {
//            System.out.println("ANNA SALLITTU KOMENTO");
//            return -1;
//        }
        
        return komento;
    }
    
    public void aloitaPeli() {
        lauta.asetaLauta();
        jatkuu = true;
        lukija.nextLine();
        
        while(jatkuu = true) {
            paivita();
            annaSiirto();
        }
        
    }
    
    public void paivita() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for(int j=7; j>=0; j--) {
            System.out.print((0 +j));
            for(int i=0; i<8; i++) {
                if(!lauta.getNappula(i, j).getTyyppi().isEmpty()) {
                    
                      System.out.print("|"+ lauta.getNappula(i, j).getTyyppi());  
                    
                    
                    
                    
                } else {
                    System.out.print("| ");
                }
                
            }
            System.out.println();
        }
        
        System.out.println("  0 1 2 3 4 5 6 7");
    }
    

    

    public boolean syoteOikein( int i) {
        if(Integer.toString(i).length()>1) {
            System.out.println("Liikaa numeroita syötteessä");
        }
        if(i >= 0 && i <8) {
            
            return true;
        } else {
            System.out.println("Tarkista että antamasi luku on väliltä 0-7");
        }
        return false;
    }
    
    public void annaSiirto() {
        System.out.println();
        System.out.println("Anna siirto");
        
        int x1;
        int y1;
        int x2;
        int y2;
        
        
        do {
            System.out.println("Anna lähtöruudun x-koordinaatti");
            x1 = lukija.nextInt();
            if(x1==0000) {
                jatkuu = false;
            }
        }   while(syoteOikein(x1)==false);
        
        do {
            System.out.println("Anna lähtöruudun y-koordinaatti");
            y1 = lukija.nextInt();
        }   while(syoteOikein(y1)==false);
        
        do {
            System.out.println("Anna kohderuudun x-koordinaatti");
            x2 = lukija.nextInt();
        }   while(syoteOikein(x2)==false);
        
        do {
            System.out.println("Anna kohderuudun y-koordinaatti");
            y2 = lukija.nextInt();
        }   while(syoteOikein(y2)==false);
        
        lauta.siirraNappula(x1, y1, x2, y2);
    }
}



