package prg.main;

import java.util.Random;

public class Licantropo implements Mostro, Umano {
    private int forzaUmano;
    private int forzaMostro;
    private int vita;
    private boolean isUomo;
    protected Random random;

    public Licantropo(boolean luna, Random random) {
    	this.random = random;
        isUomo = !luna;
        if (luna) {
            forzaMostro = 20;
            forzaUmano = 0;
            vita = 50;
        } else {
            forzaUmano = 50;
            forzaMostro = 0;
            vita = 30;
        }
    }

    @Override
    public void azzanna(Personaggio avversario) {
    	if (vita > 0 && forzaMostro > 1) {
    		int dannoInflitto = Math.max(random.nextInt(forzaMostro / 2) + 1, 1);
            forzaMostro += 2;
            avversario.subisciDanno(dannoInflitto); // Applica il danno all'avversario
            System.out.println("Il licantropo azzanna!");
            System.out.println("Danno inflitto: " + dannoInflitto);
        }
    }

    @Override
    public void combatti(Personaggio avversario) {
    	if (vita > 0 && forzaUmano > 1) {
    		int dannoInflitto = Math.max(random.nextInt(forzaUmano / 2) + 1, 1);
            forzaUmano -= 3;
            avversario.subisciDanno(dannoInflitto); // Applica il danno all'avversario
            System.out.println("Il licantropo combatte!");
            System.out.println("Danno inflitto: " + dannoInflitto);
        }
    }


    @Override
    public void attacca(Personaggio avversario) {
    	if (!isUomo && avversario != null && avversario.isVivo()) {
    		azzanna(avversario); // Utilizza l'abilità "Azzanna" quando è in forma di mostro
    	} else if (isUomo && avversario != null && avversario.isVivo()){
    		combatti(avversario); // Utilizza l'abilità "Combatti" quando è in forma umana
    	} else {
            System.out.println("Non posso attaccare un avversario morto!");
    	}
    	
    }
    
    @Override
    public void subisciDanno(int danno) {
    	vita -= danno;
    	if (vita <= 0) {
    		System.out.println("Il licantropo è morto!");
    	}
    }

    @Override
    public int getVita() {
        return vita;
    }

    @Override
    public boolean isVivo() {
        return vita > 0;
    }

    @Override
    public int getForza() {
        return forzaUmano + forzaMostro;
    }


}
