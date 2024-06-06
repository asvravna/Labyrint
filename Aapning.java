
public class Aapning extends HvitRute{

    public Aapning(Labyrint l, int radNum, int kolNum) {
        super(l, radNum, kolNum);
        super.tegn = 'O';
        
    }
    @Override
    public void finn(Rute fra){
       
        String punkt = String.format("(%d,%d)", radnummer, kolonnenummer);
        System.out.println(punkt);

        //må kalle på metoden på nytt for å finne andre åpninger
        super.finn(fra); 
        
    }
}
