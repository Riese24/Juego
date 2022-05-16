package juego;
import java.awt.Color;

import java.util.Random;

import entorno.Entorno;

public class Humanoide {
	private double x;
	private double y;
	private double diametro;
	private double velocidad;
	private double angulo; 
	private boolean cazado;
	private int[] signo;
	

	public Humanoide(){
		this.diametro = 80;
		Random gen = new Random();
		
		this.x = gen.nextInt(800);
		this.signo = new int[2];
		this.signo[0] = -1;
		this.signo[1] = 1;
		this.y = gen.nextInt(200) + 1;
		this.velocidad = 3; //+ gen.nextInt(5);
		this.angulo = Math.atan2(y, x);
		
		this.cazado=false;
	}
	public void dibujarse(Entorno entorno){
		if (this.y < 600 && this.x <800 && this.x > 0)
		entorno.dibujarCirculo(x, y, diametro, Color.blue);
	
	}

	public void avanzar(){
		this.y+= this.velocidad*0.7 * Math.sin(this.angulo);
		this.x+= this.velocidad*0.7 * Math.cos(this.angulo);	
		
		// borde derecho
		if (this.x < 20 ){
			this.x = 20; 
		    this.angulo = Math.PI - this.angulo;
		   }
		// borde izquierdo
		if (this.x > 780 ){
			this.x = 780;
			this.angulo = Math.PI - this.angulo;
		   }
		//borde inferior
		if(this.y > 500){
			this.y= 500;
			this.angulo = Math.PI + this.angulo;
		}
		//borde superior
		if(this.y < 35){
			this.y= 35;
			this.angulo = Math.PI + this.angulo;
		}
	}
	public double getY(){
		return this.y;
	}
	
//	public static void setY(float y) {
//		Humanoide.y = y;
//	}

	public double getX(){
		return this.x;
	}
//	public static void setX(float x) {
//        Humanoide.x = x;
//    }

	public boolean getCazado() {
		return this.cazado;
	}

	public void setCazado(boolean atrapado){
		this.cazado = atrapado;
	}


}
