package main;

import modelo.Agenda;
import presentacion.controlador.ControladorPrincipal;
import presentacion.vista.Principal;


public class Main 
{

	public static void main(String[] args) 
	{
		Principal vista = new Principal();
		Agenda modelo = new Agenda();
		ControladorPrincipal controlador = new ControladorPrincipal(vista, modelo);
		controlador.inicializar();
	}
}
