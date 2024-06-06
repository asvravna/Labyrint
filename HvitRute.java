
public class HvitRute extends Rute{

    public HvitRute(Labyrint labyrint, int radNum, int kolNum) {
        super(labyrint, radNum, kolNum);
        super.tegn = '.';
        
    }

    @Override 
    public String toString(){
        return " ";
    }

    @Override
    public void finn(Rute fra){
        if(nord != null && nord != fra) {
            nord.finn(this); 
        }
        if(sor != null && sor != fra) {
            sor.finn(this);
        }
        if(ost != null && ost != fra) {
            ost.finn(this);
        }
        if(vest != null && vest != fra) {
            vest.finn(this);
        }    
    }
    
}
