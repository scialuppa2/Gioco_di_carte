package prg.main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


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

    // Metodo per scegliere il personaggio del giocatore
    private static Personaggio scegliPersonaggio(Scanner scanner, Random random) {
        System.out.println("Scegli il tuo personaggio:");
        System.out.println("1. Eroe");
        System.out.println("2. Vampiro");
        System.out.println("3. Licantropo");
        System.out.println("4. Lupo Mannaro");
        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di fine linea

        switch (scelta) {
            case 1:
                return new Eroe(random);
            case 2:
                return new Vampiro(random);
            case 3:
                return new Licantropo(false, random); // Licantropo in forma umana
            case 4:
                return new Licantropo(true, random); // Licantropo in forma di mostro
            default:
                System.out.println("Scelta non valida. Scegliere nuovamente.");
                return scegliPersonaggio(scanner, random);
        }
    }

    // Metodo per scegliere l'avversario
    private static Personaggio scegliAvversario(Scanner scanner, Random random) {
        System.out.println("Scegli l'avversario:");
        System.out.println("1. Vampiro");
        System.out.println("2. Licantropo");
        System.out.println("3. Lupo Mannaro");
        System.out.println("4. Eroe");
        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di fine linea

        switch (scelta) {
            case 1:
                return new Vampiro(random);
            case 2:
                return new Licantropo(false, random); // Licantropo in forma umana
            case 3:
                return new Licantropo(true, random); // Licantropo in forma di mostro
            case 4:
                return new Eroe(random);
            default:
                System.out.println("Scelta non valida. Scegliere nuovamente.");
                return scegliAvversario(scanner, random);
        }
    }
}
