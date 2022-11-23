import java.util.Random;

public class Jogador extends Thread{
	
	private int id, valuePlay, win, lose, draw;
	private Random randomValue = new Random();
	private String result;
	
	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void jogar()
	{
		valuePlay = randomValue.nextInt(3);
	}
	
	public int getValue()
	{
		return valuePlay;
	}
	
	public String getResult()
	{
		switch (valuePlay) {
		case 0:
			return "PEDRA";
		case 1:
			return "PAPEL";
		case 2:
			return "TESOURA";
		}
		return null;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

}
