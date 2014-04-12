/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shakki;

import Nappula.Kuningas;
import Nappula.Kuningatar;
import Nappula.Lahetti;
import Nappula.Nappula;
import Nappula.Ratsu;
import Nappula.Sotilas;
import Nappula.Torni;
import Nappula.Tyhja;

/**
 *Sisältää shakkipelin pelimekaniikan ja siirtoihin liittyviä toimintoja
 * @author henrimmo
 */
public class Lauta {
    
    public Nappula[][] nappulat;
    
/*
 * vuoroa kuvaava muuttuja,
 * true = valkoisen vuoro, false = mustan 
 */  
    
    public boolean vuoro;

    
    public Lauta() {
        nappulat = new Nappula[8][8];
    }
    
    
    public Nappula setNappula(Nappula nappula, int x, int y) {
        nappulat[x][y] = nappula;
        nappula.x = x;
        nappula.y = y;
        return nappula;
    }
    
    /*
     * asettaa laudan täyteen "tyhjiä" nappula olioita
     */
    
    public void asetaTyhjaLauta() {
       for(int x = 0; x <8; x++) {
            for(int y = 0; y <8; y++) {
                setNappula(new Tyhja(true), x,y);
            }
        } 
    }
    
    /*
     * tyhjentää laudan
     */
    public void tyhjennaLauta() {
        for(int x = 0; x <8; x++) {
            for(int y = 0; y <8; y++) {
                poistaNappula(x,y);
            }
        }
    }
    
    /**
    * asettaa laudan aloitustilanteeseen, valkoiset alas, mustat ylös ja väliin tyhjät nappulat
    * vaihtaa vuoron valkoiselle
    */
    public void asetaLauta() {
        
//          tyhjät nappulat        
        for(int x = 0; x <8; x++) {
            for(int y = 2; y <6; y++) {
                setNappula(new Tyhja(true), x,y);
            }
        }
        
//          valkoisen nappulat
        setNappula(new Torni(true), 0, 0);
        setNappula(new Ratsu(true), 1, 0);
        setNappula(new Lahetti(true), 2, 0);
        setNappula(new Kuningatar(true), 3, 0);
        setNappula(new Kuningas(true), 4, 0);
        setNappula(new Lahetti(true), 5, 0);
        setNappula(new Ratsu(true), 6, 0);
        setNappula(new Torni(true), 7, 0);
        for(int i = 0; i <8; i++) {
            setNappula(new Sotilas(true), i, 1);
        }
        
//          mustan nappulat
        setNappula(new Torni(false), 0, 7);
        setNappula(new Ratsu(false), 1, 7);
        setNappula(new Lahetti(false), 2, 7);
        setNappula(new Kuningatar(false), 3, 7);
        setNappula(new Kuningas(false), 4, 7);
        setNappula(new Lahetti(false), 5, 7);
        setNappula(new Ratsu(false), 6, 7);
        setNappula(new Torni(false), 7, 7);
        for(int i = 0; i <8; i++) {
            setNappula(new Sotilas(false), i, 6);
        }  
        vuoro = true;
    }
    
    
    public Nappula getNappula(int x, int y) {
        return nappulat[x][y];
    }
    
    public boolean getVuoro() {
        return vuoro;
    }
    
    /*
     * Vaihtaa vuoron toiselle pelaajalle
     */
    public void vaihdaVuoro() {
        vuoro = !vuoro;
    }
    
    public void setVuoroValk() {
        vuoro = true;
    }
    
    /*
     * Siirtää nappulan alkuperäisestä ruudusta haluttuun ruutuun.
     * 
     * @param   alkuX   nappulan tämänhetkisen ruudun x-koordinaatti
     * @param   alkuY   nappulan tämänhetkisen ruudun y-koordinaatti
     * @param   kohdeX  halutun ruudun x-koordinaatti
     * @param   kohdeY  halutun ruudun y-koordinaatti
     */
    public void siirraNappula(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        
    // Tarkistaa onko aloitusruudussa nappulaa
        if(onkoRuutuTyhja(alkuX, alkuY) == true) {
                System.out.println("Valitse ruutu jossa on nappula"); 
            } else
        if (nappulat[alkuX][alkuY] != null) {
            
            //tarkistaa onko siirretäänkö oikeaa nappulaa oikealla vuorolla
            if(oikeaVari(alkuX, alkuY) == vuoro) {
                
                //tarkistaa onko siirto nappulan siirtosäännön mukainen
                if (nappulat[alkuX][alkuY].siirra(alkuX, alkuY, kohdeX, kohdeY) == true) {
                    
                    //tarkistaa onko siirrettävä nappula ratsu. Tällöin siirron välissä olevista nappuloista ei välitetä
                    if(nappulat[alkuX][alkuY].getTyyppi().equals("R") || nappulat[alkuX][alkuY].getTyyppi().equals("r")) {
                        //tarkistaa onko kohde ruutu tyhjä tai onko siinä vastustajan nappula
                        if(onkoRuutuTyhja(kohdeX, kohdeY) == true || nappulat[kohdeX][kohdeY].getVari() != vuoro) {

                            poistaNappula(kohdeX, kohdeY);
                            setNappula(nappulat[alkuX][alkuY], kohdeX, kohdeY);

                            poistaNappula(alkuX, alkuY);
                            setNappula(new Tyhja(true), alkuX, alkuY);

                            vaihdaVuoro();      
                        } 
                    
                    } else {
                        //tarkistaa onko ruutujen väli tyhjä
                        if(onkoValiTyhja(alkuX, alkuY, kohdeX, kohdeY) == true) {
                            if(onkoRuutuTyhja(kohdeX, kohdeY) == true || nappulat[kohdeX][kohdeY].getVari() != vuoro) {
                        
                                poistaNappula(kohdeX, kohdeY);
                                setNappula(nappulat[alkuX][alkuY], kohdeX, kohdeY);

                                poistaNappula(alkuX, alkuY);
                                setNappula(new Tyhja(true), alkuX, alkuY);

                                vaihdaVuoro();  
                            }
                        }
                    }   
                }
            }
        }
    }
    
    
    /*
     * Palauttaa true mikäli nappulan väri on valkoinen, false jos musta
     * 
     * @param   x   nappulan x-koordinaatti
     * @param   y   nappulan y-koordinaatti
     * 
     * @return boolean  riippuu nappulan väristä
     */
    
    public boolean oikeaVari(int x, int y) {
        if (nappulat[x][y].getVari()== true) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Poistaa nappulan laudalta
     * 
     * @param   x   poistettavan nappulan x-koordinaatti
     * @param   y   poistettavan nappulan y-koordinaatti
     */
    
    public void poistaNappula(int x, int y) {
        nappulat[x][y] = null;
    }
    

    /*
     * Tarkistaa onko ruutu tyhjö
     * 
     * @param   x   ruudun x-koordinaatti
     * @param   y   ruudun y-koordinaatti
     * 
     * @return  palauttaa true jos ruutu on tyhjä, false jos ei
     */
    public boolean onkoRuutuTyhja(int x, int y) {
        if(getNappula(x, y).getTyyppi().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /*
     * Tarkistaa onko ruutujen väli tyhjä
     * 
     * @param   alkuX   aloitusruudun x-koordinaatti
     * @param   alkuY   aloitusruudun y-koordinaatti
     * @param   kohdeX  kohderuudun x-koordinaatti
     * @param   kohdeY  kohderuudun y-koordinaatti
     * 
     * @return  palauttaa true jos väli on tyhjä, false jos ei
     */
    public boolean onkoValiTyhja(int alkuX, int alkuY, int kohdeX, int kohdeY) {

        if(alkuY == kohdeY && onkoValiTyhjaVaaka(alkuX, alkuY, kohdeX, kohdeY) == false) {
            return false;
        }
        
        
        
        if(alkuX == kohdeX && onkoValiTyhjaPysty(alkuX, alkuY, kohdeX, kohdeY) == false) {
            return false;
        }
        
       

        if ((alkuX - alkuY == kohdeX - kohdeY || alkuX + alkuY == kohdeX + kohdeY) 
                && onkoValiTyhjaVino(alkuX, alkuY, kohdeX, kohdeY)==false){
            return false;
 
        }

        return true;
    }
    
    public boolean onkoValiTyhjaVaaka(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        String k = "";

        if(kohdeX > alkuX && alkuY == kohdeY) {
            for(int i = alkuX +1; i < kohdeX;i++) {
                k = k + nappulat[i][kohdeY].getTyyppi();
            }
        }
        
        if(kohdeX < alkuX && alkuY == kohdeY) {
            for(int i = kohdeX +1; i < alkuX; i++) {
                k = k + nappulat[i][kohdeY].getTyyppi();
            }
        }
        
        if(k.length() == 0) {
            return true;  
        } else {
            System.out.println("Laiton siirto, välissä on nappula!");
            return false;
        } 
    }
    
    public boolean onkoValiTyhjaPysty(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        
        String k = "";
        
        if(kohdeY > alkuY && alkuX == kohdeX) {
            for(int i = alkuY +1; i < kohdeY;i++) {
                k = k + nappulat[kohdeX][i].getTyyppi();
            }
        }
        
        if(kohdeY < alkuY && alkuX == kohdeX) {
            for(int i = kohdeY +1; i < alkuY; i++) {
                k = k + nappulat[kohdeX][i].getTyyppi();
            }
        }
        
        if(k.length() == 0) {
            return true;  
        } else {
            System.out.println("Laiton siirto, välissä on nappula!");
            return false;
        }
    }
    
    public boolean onkoValiTyhjaVino(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        
        String k = "";
        
        if(kohdeX < alkuX && kohdeY < alkuY) {
                int i = kohdeX +1;
                int j = kohdeY +1;
                
                while(i < alkuX && j < alkuY) {
                    k = k + nappulat[i][j].getTyyppi();
                    i++;
                    j++;
                }
            }
            
            if(kohdeX > alkuX && kohdeY > alkuY) {
                int i = alkuX +1;
                int j = alkuY +1;
                
                while(i < kohdeX && j < kohdeY) {
                    k = k + nappulat[i][j].getTyyppi();
                    i++;
                    j++;
                }
            }
            
            if(kohdeX < alkuX && kohdeY > alkuY) {
                int i = alkuX -1;
                int j = alkuY +1;
                
                while(i > kohdeX && j < kohdeY) {
                    k = k + nappulat[i][j].getTyyppi();
                    i--;
                    j++;
                }
            }
 
            if(kohdeX > alkuX && kohdeY < alkuY) {
                int i = alkuX +1;
                int j = alkuY -1;
                
                while(i <kohdeX && j > kohdeY) {
                    k = k + nappulat[i][j].getTyyppi();
                    i++;
                    j--;
                }
            }
            
            if(k.length() == 0) {
            return true;  
        } else {
            System.out.println("Laiton siirto, välissä on nappula!");
            return false;
        }
    }
}

