package juego;
import entorno.*;

import java.awt.*;

public class Personaje {
	// Atributos
	String nombre;
	int vida;
	// ambos double se utilizan para identificar la posicion de mi personaje
	double pos_x;
	double pos_y;
	Pixel[][] pixels;
	int alto;
	int ancho;
	//..
	double angulo;
	Image img;
	Image img2;
	Rectangle rectangulo;
	
	
	// Constructores
	public Personaje(String nombre, int vida, double posx, double posy) {	// ("mikasa", 3, ancho/2, alto/2)
		this.nombre = nombre;
		this.vida = vida;
		this.pos_x = posx; // pos en x donde aparecera el personaje
		this.pos_y = posy; // pos en y donde aparecera el personaje
		
		img = Herramientas.cargarImagen("levi.png");
		img2=Herramientas.cargarImagen("levi de derecha.png");
	}
	public double getY() 
	{
		return this.pos_y;
	}

	public double getX() 
	{
		return this.pos_x;
	}
//	 Metodos
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img2, this.pos_x, this.pos_y, this.angulo, 0.1);	
//		entorno.dibujarTriangulo(this.pos_x , this.pos_y - 75, 20, 10, this.angulo, Color.cyan);
		
	}
	
	public void movimiento() {
//	 En este metodo, solo incrementaremos los valores de x e y, no controlamos las acciones del teclado
		this.pos_x += Math.cos(angulo)*4;	// Utilizando el sen y cos, el movimiento del personaje se
		this.pos_y += Math.sin(angulo)*4;	// vuelve un poco mas suave
	}
	
	public void girar(double modificador) {
		this.angulo = this.angulo + modificador;
		if(this.angulo < 0) {
			this.angulo +=4*Math.PI;
		}
        if(this.angulo > 4*Math.PI) {
        	this.angulo -=4*Math.PI;
        }
	}
	public boolean colisionaCon(Humanoide p) 
	{
		if (p.getY() >= this.pos_y - (this.alto / 2) && p.getY() <= this.pos_y + (this.alto / 2) &&
			p.getX() >= this.pos_x - (this.ancho / 2) && p.getX() <= this.pos_x + (this.ancho / 2))
		{
			return true;
		}
		
		return false;			
	}
}