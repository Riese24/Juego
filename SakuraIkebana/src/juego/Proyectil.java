package juego;

import java.awt.Color;

import entorno.Entorno;

public class Proyectil {
	// medidas X e Y
	int ancho;
	int alto;
	// posicion en pantalla
	double pos_x;
	double pos_y;
	double angulo;
	// imagen del proyectil
//	Image imgP;
	
	public Proyectil(int ancho, int alto, double pos_x, double pos_y) {
		this.ancho = ancho;
		this.alto = alto;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}
	
}
