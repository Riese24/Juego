package juego;
import java.awt.Color;

import java.awt.Image;
import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	// ...
	// variables de instancia
	Personaje personaje;
	Image imgFondo;
	Obstaculo[]arregloObstaculo;
	Proyectil proyectil;
	Humanoide [] titan;
	int cazados;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "TP Attack on Titans - Grupo ? - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		personaje = new Personaje("mikasa",3,400,300);
		imgFondo = Herramientas.cargarImagen("3.jpg");
//		obs = new Obstaculo(300, 400,90,90);
	
//		proyectil = new Proyectil(300,400, 20,20);
		
		this.titan = new Humanoide[5]; 
		for(int i = 0; i<this.titan.length; i++) {
			this.titan[i] = new Humanoide();
		}
		// arreglo de obstaculos
		arregloObstaculo = new Obstaculo [5];
		arregloObstaculo [0] = new Obstaculo (150,150);
		arregloObstaculo [1] = new Obstaculo (650,500);
		arregloObstaculo [2] = new Obstaculo (150,500);
		arregloObstaculo [3] = new Obstaculo (650,150);
		arregloObstaculo [4] = new Obstaculo (390,460);
		
		int cazados=0;
		
		// Inicia el juego!
		this.entorno.iniciar();
		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick(){
		// Procesamiento de un instante de tiempo
		// ...
		entorno.dibujarImagen(imgFondo, 0, 0, 0, 0.9);
		entorno.cambiarFont("Arial", 30, Color.yellow);
		entorno.escribirTexto("Titanes cazados: " + cazados, 20, 585);
		personaje.dibujarse(entorno);
		for(int i = 0; i < arregloObstaculo.length; i++) {
			arregloObstaculo[i].dibujarImg(entorno);
		}
		// Muestro cosas por pantalla
		for (int i=0;i<titan.length;i++){
			titan[i].avanzar();	
			
		}
		for (int i=0;i<titan.length;i++){
			if (!titan[i].getCazado()){
				titan[i].dibujarse(entorno);
			}
		
		}
		//chequea que haya colision entre el personaje y los titanes del arreglo Humanoide
		for (int j = 0; j < titan.length; j++) {
				if (!titan[j].getCazado())
					if (personaje.colisionaCon(titan[j]))
					{
						titan[j].setCazado(true);
						cazados++;
				}
		}	
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			personaje.girar(Herramientas.radianes(3));
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			personaje.girar(Herramientas.radianes(-3));
		}
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			personaje.movimiento();

			// paredes
			
			//borde derecho
			if(personaje.pos_x > 770) {
				personaje.pos_x= 770;
			}
			//borde izquierdo
			if(personaje.pos_x < 35) {
				personaje.pos_x= 35;
			}
			//borde inferior
			if(personaje.pos_y > 525) {
				personaje.pos_y= 525;
			}
			//borde superior
			if(personaje.pos_y < 35) {
				personaje.pos_y= 35;
			}		
			
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
