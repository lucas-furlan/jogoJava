package jplay;

import java.util.Random;

public class Lixo extends Sprite{
	
	Sprite lixo;
	Random gerador = new Random();
	
	public Lixo() {
		super("src/recursos/img/maca.png");
		this.x = 100;
		this.y = 100;
	}
	
	public void spawn() {
		this.x = 50+gerador.nextInt(650);
		
		this.y = 100+gerador.nextInt(350);
	}

	
	
}
