public class Kontroller implements Runnable{
    GUILabyrint gui;
    Labyrint labyrint;
    int rad = 10; 
    int kol = 10; 
    boolean erTrykket;
    Thread spilltraad = null;


    //hent parset fil fra modell og overfør til gui via controller
    Kontroller(){

        labyrint = new Labyrint("2.in"); 
        gui = new GUILabyrint(this, rad, kol);

    }

//tar inn labyrint fra modell- labyrint: 
    void tegn(Rute[][] labyrint){ // ta inn rutenett fra Labyrint klassen, og skrive det ut i gui-klassen
        for(int i = 0; i < rad; i++){
            for(int j = 0; j < kol; j++){
                Rute rute = labyrint[i][j];
                


              

                
            }
        }

      
    }


    void avsluttSpillet(){
        System.exit(0);

    }

    public void velgStartRute(int rad, int kol) { //metode for å velge koordinatrute;
        //skriv ut koordinatet til ruten på en jlabel
     
           
    }

    //game loop
    void start(){
        //vil kun starte en spill-tråd
        if(spilltraad != null){
            return;

        }

        spilltraad = new Thread(this);
        spilltraad.start();

    }



    @Override
    public void run() {
        int teller = 0;

        while(true){
            
         
        }
    }


}

    


