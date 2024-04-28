package prg.main;

public interface Personaggio {
	int getForza();
	int getVita();
	void attacca(Personaggio avversario);
	void subisciDanno(int danno);
	boolean isVivo();

}
