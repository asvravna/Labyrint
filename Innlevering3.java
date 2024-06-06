
import java.util.Scanner;

public class Innlevering3 {


    public static void main(String[] args){

        Innlevering3 program = new Innlevering3();

        String filnavn = program.parseFilnavn(args);

        program.start(filnavn);
        
    }

    public String parseFilnavn(String[] args){ 
       
        if(args.length == 0){
            System.out.println("Ingen fil oppgitt.");
            System.exit(1);
    
        }
        return args[0];
            
    }



    public void start(String filnavn){

        Labyrint lab = new Labyrint(filnavn);
    
        Scanner scanner = new Scanner(System.in);
      

        while(true){
            System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)");
            String input = scanner.nextLine();
            if(input.equals("-1"))
                break;

            String[] split = input.split(" ");
            int rad = 0;
            int kolonne = 0;

            if(split.length < 2){
                System.out.println("Trenger to heltall som input.");
                continue;
            }

            try{
                rad = Integer.parseInt(split[0]);
                kolonne = Integer.parseInt(split[1]);

            } 
            catch(NumberFormatException e) {
                System.out.println("Ugyldig input.");
                continue;
            }


            lab.finnUtveiFra(rad, kolonne);

        }

        
        scanner.close();

      
    }



    
}
