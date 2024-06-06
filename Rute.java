
public abstract class Rute {
    public int radnummer, kolonnenummer;
    Labyrint labyrint; 
    char tegn; 
    Rute nord, sor, ost, vest = null; 

    public Rute(Labyrint labyrint, int radNum, int kolNum) {
        radnummer = radNum; 
        kolonnenummer = kolNum; 
        this.labyrint = labyrint;

    }

    public char hentTegn() {
        return tegn;
    }
    
    public abstract void finn(Rute fra);
   
     


    
}
