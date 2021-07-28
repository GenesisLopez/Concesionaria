package com.tp9;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico01.Coche;

public class pruebaConcesionaria {

	private final static int INGRESAR_VEHICULO = 1, MOSTRAR_LISTADO_DE_VEHICULO = 2,
			MOSTRAR_DETALLES_DE_UN_VEHICULO = 3, SALIR = 9;
	private static Concesionaria olivieri;

	public static void main(String[] args) {

		int CAPACIDAD_MAXIMA_DE_LA_FLOTA = 100;
		olivieri = new Concesionaria(CAPACIDAD_MAXIMA_DE_LA_FLOTA);
		int opcionDeseada;
		do {
			mostrarElMenu();
			Scanner reader = new Scanner(System.in);
			opcionDeseada = reader.nextInt();
			switch (opcionDeseada) {
			case INGRESAR_VEHICULO:
				ingresarUnVehiculo();
				break;
			case MOSTRAR_LISTADO_DE_VEHICULO:
				System.out.println("Los vehiculos son " + olivieri.toString());
				
				break;
			case MOSTRAR_DETALLES_DE_UN_VEHICULO:
			case SALIR:
			default:
			}


		} while (opcionDeseada != 9);
	}
	
	private static void mostrarElMenu() {
		System.out.println("Bienvenido a la concesionaria");
		System.out.println("*****************************");
		System.out.println(INGRESAR_VEHICULO + "Ingresar un nuevo vehiculo");
		System.out.println(MOSTRAR_LISTADO_DE_VEHICULO + "Mostrar el listado de vehiculos");
		System.out.println(MOSTRAR_DETALLES_DE_UN_VEHICULO + "Mostrar el detalle de un vehiculo en particular");
		System.out.println(SALIR + "Salir");
		System.out.println("******************************");
		System.out.println("Ingresar la opcion deseada");
	}

	private static void ingresarUnVehiculo() {
		String marca, modelo;
		int kilometro, ano;
		double precio;
		Coche nuevoCoche;
		boolean sePudoAgregar;
		Scanner reader = new Scanner(System.in);

		System.out.println("Ingrese la marca \n" );
		marca = reader.nextLine();

		System.out.println("Ingrese el modelo \n");
		modelo = reader.nextLine();

		System.out.println("Ingrese los kilometros \n");
		kilometro = reader.nextInt();

		System.out.println("Ingrese el ano de fabricacion \n");
		ano = reader.nextInt();

		System.out.println("Ingrese el precion (en $): \n");
		precio = reader.nextDouble();

		nuevoCoche = new Coche(marca, modelo, kilometro, ano, precio);
		sePudoAgregar = olivieri.ingresarCoche(nuevoCoche);

		if (nuevoCoche != null && sePudoAgregar) {
			System.out.println("Se ingreso correctamente");
		} else {
			System.out.println("Ups! Ocurrio un error. Seguramente no hay mas lugar en la flota");
		}
	}
}
