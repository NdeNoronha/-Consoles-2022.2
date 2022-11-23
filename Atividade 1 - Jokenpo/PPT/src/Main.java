import java.util.concurrent.Semaphore;

public class Main {

	private static Jogador jogador[] = new Jogador[2];
	private static Semaphore semaforo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		semaforo = new Semaphore(1);
		
		for(int i = 0; i < jogador.length; i++)
		{
			jogador[i] = new Jogador();
			jogador[i].setId(i);
			jogador[i].start();
		}
		
		jogadas(100);
		
		for(int i = 0; i < jogador.length; i++) {
			System.out.println("JOGADOR " + jogador[i].getId());
			System.out.println("VITÓRIAS: " + jogador[i].getWin());
			System.out.println("DERROTAS: " + jogador[i].getLose());
			System.out.println("EMPATES: " + jogador[i].getDraw());
			System.out.println("*****************************");
		}
	}
	
	private static void jogadas(int nJogadas)
	{
		for(int i = 0; i < nJogadas; i++)
		{
			try {
				semaforo.acquire();
				jogo();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			semaforo.release();
			
		}
	}
	
	private static void jogo()
	{
		for(int i = 0; i < jogador.length; i++)
			jogador[i].jogar();
			
		
		
		System.out.println("Jogador " + jogador[0].getId() + " escolheu " + jogador[0].getResult() +" e o " + 
						jogador[1].getId() + " escolheu " + jogador[1].getResult());
		
		if(jogador[0].getValue() == jogador[1].getValue())
		{
			System.out.println("Nesta rodada ocorreu EMPATE");
			for(int i = 0; i < jogador.length; i++)
				jogador[i].setDraw(jogador[i].getDraw() + 1);
			
		} else if(jogador[0].getValue() == 0 && jogador[1].getValue() == 2)
		{
			jogador[0].setWin(jogador[0].getWin() + 1);
			jogador[1].setLose(jogador[1].getLose() + 1);
			System.out.println("Jogador 0 VENCEU!");
		} else if(jogador[0].getValue() == 1 && jogador[1].getValue() == 0)
		{
			jogador[0].setWin(jogador[0].getWin() + 1);
			jogador[1].setLose(jogador[1].getLose() + 1);
			System.out.println("Jogador 0 VENCEU!");
		} else if(jogador[0].getValue() == 2 && jogador[1].getValue() == 1)
		{
			jogador[0].setWin(jogador[0].getWin() + 1);
			jogador[1].setLose(jogador[1].getLose() + 1);
			System.out.println("Jogador 0 VENCEU!");
		} else {
			jogador[1].setWin(jogador[0].getWin() + 1);
			jogador[0].setLose(jogador[1].getLose() + 1);
			System.out.println("Jogador 1 VENCEU!");
		}
		
		System.out.println("**********************");
	}
}
