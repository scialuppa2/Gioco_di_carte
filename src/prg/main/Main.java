package prg.main;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
         
	 
        //Gestione della luna
        FaseLunare faseLunare = new FaseLunare();
        boolean isNotte;
        int statoLuna = 0;
        boolean isLunaPiena;
        //Gestione della data
    	LocalDateTime orario = LocalDateTime.now();
    	int iYear = orario.getYear();
    	int iMonth = orario.getMonthValue();
    	int iDay = orario.getDayOfMonth();
        int iHour = orario.getHour();
        
        if(iHour < 22 && iHour > 6) {
        	isNotte = false;
        } else {
        	isNotte = true;
        	statoLuna = faseLunare.Moon_phase(iYear, iMonth, iDay);
        	if(statoLuna == 4) {
        		isLunaPiena = true;
        	}
        
        }
        
        System.out.println(faseLunare.Moon_phase(iYear, iMonth, iDay));
	
	 
        
        
        
        

        // Inizio della sfida
        System.out.println("\r\n"
        		+ "███████╗████████╗ █████╗ ██████╗ ████████╗    ████████╗██╗  ██╗███████╗     ██████╗  █████╗ ███╗   ███╗███████╗\r\n"
        		+ "██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝    ╚══██╔══╝██║  ██║██╔════╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\r\n"
        		+ "███████╗   ██║   ███████║██████╔╝   ██║          ██║   ███████║█████╗      ██║  ███╗███████║██╔████╔██║█████╗  \r\n"
        		+ "╚════██║   ██║   ██╔══██║██╔══██╗   ██║          ██║   ██╔══██║██╔══╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  \r\n"
        		+ "███████║   ██║   ██║  ██║██║  ██║   ██║          ██║   ██║  ██║███████╗    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\r\n"
        		+ "╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝          ╚═╝   ╚═╝  ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝\r\n"
        		+ "                                                                                                               \r\n"
        		+ "");
        
     // Creazione dei personaggi e dei mostri
        Personaggio personaggio = scegliPersonaggio(scanner, random);
        Personaggio avversario = scegliAvversario(scanner, random);
        
        while (personaggio.isVivo() && avversario.isVivo()) {
            // Turno del personaggio
        	System.out.println("Premi Invio per attaccare il tuo avversario...");
            scanner.nextLine(); // Attendiamo che l'utente prema Invio per continuare
            personaggio.attacca(avversario);
            ricalcolaFaseLunare();
            
          	 
            if (!avversario.isVivo()) {
                System.out.println("Hai sconfitto il tuo avversario!");
                break;
            }

            // Turno dell'avversario
            System.out.println("__________________________________________________");
            System.out.println("Premi Invio per l'attacco del tuo avversario...");
            scanner.nextLine(); // Attendiamo che l'utente prema Invio per continuare
            avversario.attacca(personaggio);
            
            if (!personaggio.isVivo()) {
                System.out.println("Il tuo avversario ti ha sconfitto!");
                break;
            }

            // Stampa la vita e la forza dei personaggi
            System.out.println("__________________________________________________");
            System.out.println("Vita del tuo personaggio: " + personaggio.getVita());
            System.out.println("Forza del tuo personaggio: " + personaggio.getForza());
            System.out.println("-------------------------");
            System.out.println("Vita dell'avversario: " + avversario.getVita());
            System.out.println("Forza dell'avversario: " + avversario.getForza());
            System.out.println("__________________________________________________");

        }

        // Chiudi lo scanner
        scanner.close();
    }

    private static void ricalcolaFaseLunare() {
    	LocalDateTime orario = LocalDateTime.now();
		int iAddedHours = 30;
      	orario = orario.plusHours(iAddedHours);
      	System.out.println(orario);
		
	}

	// Metodo per scegliere il personaggio del giocatore
    private static Personaggio scegliPersonaggio(Scanner scanner, Random random) {
    	boolean isUomo;
    	LocalTime orarioCorrente = LocalTime.now();
        int isLuna = orarioCorrente.getHour();
        if(isLuna < 22 && isLuna > 6) {
        	isUomo = true;
        } else {
        	isUomo = false;
        }
        System.out.println("Scegli il tuo personaggio:");
        System.out.println("1. Eroe");
        System.out.println("2. Vampiro");
        System.out.println("3. Licantropo");
        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di fine linea

        switch (scelta) {
            case 1:
                return new Eroe(random);
            case 2:
                return new Vampiro(random);
            case 3:
                return new Licantropo(isUomo, random);
            default:
                System.out.println("Scelta non valida. Scegliere nuovamente.");
                return scegliPersonaggio(scanner, random);
        }
    }

    // Metodo per scegliere l'avversario
    private static Personaggio scegliAvversario(Scanner scanner, Random random) {
    	boolean isUomo;
    	LocalTime orarioCorrente = LocalTime.now();
        int isLuna = orarioCorrente.getHour();
        if(isLuna < 22 && isLuna > 6) {
        	isUomo = true;
        } else {
        	isUomo = false;
        }
        
        System.out.println("Scegli l'avversario:");
        System.out.println("1. Vampiro");
        System.out.println("2. Licantropo");
        System.out.println("3. Eroe");
        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di fine linea

        switch (scelta) {
            case 1:
                return new Vampiro(random);
            case 2:
                return new Licantropo(isUomo, random);
            case 3:
                return new Eroe(random);
            default:
                System.out.println("Scelta non valida. Scegliere nuovamente.");
                return scegliAvversario(scanner, random);
        }
    }
        
        
        
    
}
