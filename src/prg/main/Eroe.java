package prg.main;
import java.util.Random;

public class Eroe implements Umano {
    private int forza;
    private int vita;
    protected Random random;

    public Eroe(Random random) {
    	this.random = random;
        forza = 40;
        vita = 40;
    }

    @Override
    public void combatti(Personaggio avversario) {
        if (vita > 0 && forza > 1) {
        	int dannoInflitto = Math.max(random.nextInt(forza / 2) + 1, 1);
            if (forza - 4 >= 0) {
                forza -= 4; // Diminuzione della forza dell'eroe dopo l'attacco
                avversario.subisciDanno(dannoInflitto); // Applica il danno all'avversario
                System.out.println("L'eroe attacca!");
                System.out.println("Danno inflitto all'avversario: " + dannoInflitto);
            } else {
                System.out.println("Non posso attaccare perché la forza è troppo bassa!");
            }
        } else {
            System.out.println("Non posso attaccare!");
        }
    }

    @Override
    public void attacca(Personaggio avversario) {
        if (avversario != null && avversario.isVivo()) {
            combatti(avversario);
        } else {
            System.out.println("Non posso attaccare un avversario morto!");
        }
    }

    @Override
    public void subisciDanno(int danno) {
        vita -= danno;
        if (vita <= 0) {
            System.out.println("L'eroe è morto!");
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
