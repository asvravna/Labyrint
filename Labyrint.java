import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrint{
    String filnavn;
    int antRader;
    int antKolonner;
    Rute [][] labyrint; 
    
    public Labyrint(String fil) {

        filnavn = fil;
        lesFil(fil);
        System.out.println(this);


    }

    public void setLabyrinth(Rute[][] rutenett) {
        this.labyrint = rutenett;
    }

    public void lesFil(String fil) {

        
        try {
            BufferedReader lesFil = new BufferedReader(new FileReader(fil));
            String linje = lesFil.readLine();
            String[] dimensjoner = linje.split(" ");
            
            antRader = Integer.parseInt(dimensjoner[0]);
            antKolonner = Integer.parseInt(dimensjoner[1]);

            labyrint = new Rute[antRader][antKolonner];

        

            for(int y = 0; y < antRader; y ++) {
                String line = lesFil.readLine();
                for(int x = 0; x <antKolonner; x++) {
                    char data = line.charAt(x); //henter hvert tegn i filen
                    

                    Rute rute;
                    if (data == '#') {
                        rute = new SortRute(this, y, x);

                    //sjekker om en rute er en åpning, og lager en åpningsrute
                    } else if(y == antRader -1 || y == 0 || x == antKolonner -1 || x == 0){
                        rute = new Aapning(this, y, x);
                        
                    } else {
                        rute = new HvitRute(this, y, x);
                    }
                    labyrint[y][x] = rute;

                    if (x != 0) {
                        Rute vest = labyrint[y][x-1];
                        rute.vest = vest;
                        vest.ost = rute;
                    }

                    if (y != 0) {
                        Rute nord = labyrint[y-1][x];
                        rute.nord = nord;
                        nord.sor = rute;
                    }
                }
            }           
            lesFil.close();
        } catch(IOException e){
            System.out.println("Filen ble ikke funnet: " + filnavn);
            System.exit(1);
        }


    }
//denne metoden til gui
    @Override
    public String toString() {
        System.out.println("Slik ser labyrinten ut: \n");
    
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < antRader; j++) {
            for (int i = 0; i < antKolonner; i++) {
                Rute rute = labyrint[j][i];

                sb.append(rute.hentTegn());
            }
            sb.append("\n");
        }
        return sb.toString();
        
    }

    public void finnUtveiFra(int rad, int kol){
      
        if(rad >= antRader || kol >= antKolonner) {
            System.out.println("Koordinatene er for stor.");
            return;    
        }
        if(rad < 0 || kol < 0) {
            System.out.println("Koordinatene er for små.");
            return;
        }

        Rute startrute = labyrint[rad][kol];

        System.out.println("Aapninger: ");

        if(startrute instanceof SortRute){
            System.out.println("Kan ikke starte i sort rute.");
            return;
        } 

        startrute.finn(null);



    }


    
}
