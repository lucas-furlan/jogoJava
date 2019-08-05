package jplay;


public class Player extends Sprite{

	private double velocidade = 0.5;
	private int contBag = 0;
	private int contadorLixo = 0;
	
	private GameImage imgLixo = new GameImage("src/recursos/img/maca.png");;
	
	public Player(int x, int y) {
		super(("src/recursos/img/rato.png"));
		this.x = x;
		this.y = y;
		
		imgLixo.x = 220;
		imgLixo.y = -8;
	}
	
	public void mover(Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY) == true) {
			if(this.x>32)
				this.x -= velocidade;
				
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY) == true) {
			if(this.x < 800 - 64) 
				this.x += velocidade;
		}else if(teclado.keyDown(Keyboard.UP_KEY) == true) {
				if(this.y > 64) 	
					this.y -= velocidade;
			}else if(teclado.keyDown(Keyboard.DOWN_KEY) == true) {
				if(this.y < 600 - 64) 
					this.y += velocidade;
				if(this.x > 340 && this.x < 800 - 380) {
					if(this.y < 600-60)		  
						this.y += velocidade;
				}
				
			}	
	}
		
	
		
	public void colidiuLixo(Lixo lixo, Scene cena) {
		if(contBag == 0 && this.collided(lixo)) {
			contBag++;
			if(contBag == 1)
				cena.addOverlay(imgLixo);
			lixo.spawn();
		}
		
	}
	
	public void colidirLixeira(GameImage img, Scene cena, Window janela) {
		if(this.collided(img) && this.getContBag() == 1) {
			contBag--;			
			janela.delay(10);
			
			if(contBag == 0)
				cena.removeOverlay(imgLixo);
			contadorLixo++;
		}
	
	}
	
	public int getContBag() {
		return contBag;
	}
	
	public int getContadorLixo() {
		return contadorLixo;
	}
	
}
	

