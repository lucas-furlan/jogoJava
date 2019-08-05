package jplay;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;

import JPlay.Time;

public class WCenario{
	
	private Window window;
	private Scene cena;
	private Keyboard teclado;
	private Player jogador;
	private Lixo lixo;
	private GameImage imgLixeira = new GameImage("src/recursos/img/lixo2.png");
	private Font fonte = new Font("Comic Sans MS", Font. TRUETYPE_FONT, 20);
	private Time tempo;
	
	public WCenario() {
		window = new Window(800,600);
		window.setVisible(false);	
		teclado = window.getKeyboard();
		
		tempo = new Time(00,01,00,0,0,false);
	
		lixo = new Lixo();
		jogador = new Player(300,100);
		
		imgLixeira.x = 350;
		imgLixeira.y = 560;
		
		cena = new Scene();
		cena.loadFromFile(URL.scenario("cenario.scn"));
		
		
		cena.addOverlay(lixo);
		cena.addOverlay(imgLixeira);
		cena.addOverlay(jogador);
	}
	
	public void run() {	
		boolean jogoOn = true;		
		window.setVisible(true);
		
		while(jogoOn) {			
			draw();
			
			jogador.mover(teclado);	
			fecharJogo(teclado);
			jogador.colidiuLixo(lixo, cena);
			jogador.colidirLixeira(imgLixeira, cena, window);	

			fimDeJogo();
		}
	}
	
	public void draw() {
		cena.draw();
		window.drawText(""+tempo, 300, 25, Color.BLUE, fonte);
		window.drawText("Lixos coletados: "+jogador.getContadorLixo()+".", 20, 25, Color.BLUE, fonte);
		window.drawText("Pressione ESC para sair", 500, 25, Color.BLUE, fonte);
		window.update();
	}
	
	public void fecharJogo(Keyboard teclado) {
		if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
			WMenu WMenu = new WMenu();
			window.setVisible(false);
			WMenu.run();
		}
	}
	
	public void fimDeJogo() {
		if(tempo.timeEnded()) {
			if(jogador.getContadorLixo() >= 20)
				JOptionPane.showMessageDialog(window, "JOGO FINALIZADO\n"+
						"Você coletou "+jogador.getContadorLixo()+" lixos.\n\n"+
						"PARABÈS VOCÊ VENCEU O JOGO!!!!!!!!!!!!!!", "RESULTADO DO JOGO",1);
			else
				JOptionPane.showMessageDialog(window, "JOGO FINALIZADO\n"+
						"Você coletou "+jogador.getContadorLixo()+" lixos.\n\n"+
						"VOCÊ NÃO CONSEGUIU VENCER!! TENTE NOVAMENTE!", "RESULTADO DO JOGO",1);
			
		WMenu menu = new WMenu();
		window.setVisible(false);
		menu.run();
		}
	}

}
