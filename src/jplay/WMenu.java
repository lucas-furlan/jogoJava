package jplay;

import java.awt.event.KeyEvent;
import jplay.Window;

public class WMenu {
	
	private Window window;
	private Keyboard teclado;
	
	private GameImage backGround = new GameImage("src/recursos/img/images.jpg"); 
	private GameImage texto = new GameImage("src/recursos/img/texto.png"); 
	
	public WMenu() {	
		window = new Window(800,600);
		window.setVisible(false);
		teclado = window.getKeyboard();
		
		teclado.addKey(KeyEvent.VK_1);
		teclado.addKey(KeyEvent.VK_2);
		teclado.addKey(KeyEvent.VK_3);
	}
	
	public void run() {	
		boolean menuOn = true;
		window.setVisible(true);
		
		while(menuOn) {					
			backGround.draw();
			texto.draw();
			draw();
			selecao();
		}
	}
	
	public void draw() {
		window.update();		
	}
	
	public void selecao() {
		if(teclado.keyDown(KeyEvent.VK_1)) {		
			WCenario cenarioJogo = new WCenario();		
			window.setVisible(false);
			cenarioJogo.run();
		}else if(teclado.keyDown(KeyEvent.VK_2)) {
			WRegras regras = new WRegras();
			window.setVisible(false);
			regras.run();
		}else if(teclado.keyDown(KeyEvent.VK_3)) {
			WCredito credito = new WCredito();
			window.setVisible(false);
			credito.run();
		}else if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
			window.exit();
		}
	}
	
	
}
