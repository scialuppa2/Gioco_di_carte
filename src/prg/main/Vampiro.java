package prg.main;
import java.util.Random;


public class Vampiro implements Mostro {
    private int forza;
    private int vita;
    protected Random random;

    public Vampiro(Random random) {
    	this.random = random;
        forza = 10;
        vita = 30;
    }


    @Override
    public void azzanna(Personaggio avversario) {
        if (vita > 0 && forza > 1) {
        	int dannoInflitto = Math.max(random.nextInt(forza / 2) + 1, 1);
            forza += 2;
            avversario.subisciDanno(dannoInflitto); // Applica il danno all'avversario
            System.out.println("Il vampiro azzanna!");
            System.out.println("Forza aumentata a " + forza);
            System.out.println("Danno inflitto all'avversario: " + dannoInflitto);
        } else {
            System.out.println("Non posso azzannare!");
        }
    }

    @Override
    public void attacca(Personaggio avversario) {
        if (avversario != null && avversario.isVivo()) {
            azzanna(avversario);
        } else {
            System.out.println("Non posso attaccare un avversario morto!");
        }
    }
    
    @Override
    public void subisciDanno(int danno) {
    	vita -= danno;
    	if (vita <= 0) {
    		System.out.println("Il vampiro è morto!");
    	}
    }

    @Override
    public int getForza() {
        return forza;
    }

    @Override
    public int getVita() {
        return vita;
    }


    @Override
    public boolean isVivo() {
        return vita > 0;
    }
}
