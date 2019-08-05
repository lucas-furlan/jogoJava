package jplay;

import jplay.Window;

public class WRegras {
	
	private Window window;
	private Keyboard teclado;
	
	private GameImage backGround = new GameImage("src/recursos/img/images.jpg"); 
	private GameImage texto = new GameImage("src/recursos/img/textoRegra.png"); 
	
	public WRegras() {	
		window = new Window(800,600);
		window.setVisible(false);
		teclado = window.getKeyboard();
	}
	
	public void run() {	
		boolean menuOn = true;
		window.setVisible(true);
		
		while(menuOn) {					
			backGround.draw();
			texto.draw();
			draw();
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				window.setVisible(false);
				WMenu menu = new WMenu();
				menu.run();
			}
		}
	}
	
	public void draw() {
		window.update();		
	}
	
}
