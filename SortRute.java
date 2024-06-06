public class SortRute extends Rute{

    public SortRute(Labyrint labyrint, int radNum, int kolNum) {
        super(labyrint, radNum, kolNum);
        super.tegn = '#';
        
    }
    //skal ikke gjøre noe med en sort rute
    @Override
    public void finn(Rute fra){
        
    }
    

    
}
