package juego;
import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {
	// posicion en X e Y
	double pos_x;
	double pos_y;
	// medidas del obstaculo
	int ancho;
	int alto;
	Image imgObstaculo;
	double angulo;
	
	
	public Obstaculo(int posX, int posY) {
		this.pos_x = posX;
		this.pos_y = posY;
		
		this.ancho = ancho;
		this.alto = alto;
		imgObstaculo = Herramientas.cargarImagen("Casa_1.png");
	}
	public void dibujarObs(Entorno entorno) {
		entorno.dibujarRectangulo(this.pos_x, this.pos_y, this.ancho, this.alto, this.angulo, Color.blue);
	}
	public void dibujarImg(Entorno entorno) {
		entorno.dibujarImagen(imgObstaculo, this.pos_x, this.pos_y, 0.0, 0.5);
		
	}

}
