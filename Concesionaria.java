package com.tp9;

import ar.edu.unlam.pb1.trabajoPractico01.Coche;

public class Concesionaria {

	private Coche[] flota;
	private int cantidadDeCoches;

	public Concesionaria(int cantidadCochesEnLaFlota) {
		flota = new Coche[cantidadCochesEnLaFlota];

	}

	// opcion1
//	public void ingresarCoche(Coche nuevoCoche) {
//		for (int i = 0; i < flota.length; i++) {
//			if (flota[i] == null) {
//				flota[i] = nuevoCoche;
//			}
//		}
//	}

	// opcion2
	public boolean ingresarCoche(Coche nuevoCoche) {
		boolean resultado = false;
		if (this.cantidadDeCoches < this.flota.length) {
			flota[this.cantidadDeCoches++] = nuevoCoche;

		}
		return true;
	}

	public int calcularCantidadDeUsados() {
		int cantidadDeUsados = 0;

		for (int i = 0; i < Coche.getCantidadCoches(); i++) {
			if (flota[i].getKilometros() != 0) {
				cantidadDeUsados++;
			}
		}
		return cantidadDeUsados;

	}

	public int CalcularCantidadDe0Km() {
		int cantidadDe0Km = 0;
		for (int i = 0; i < Coche.getCantidadCoches(); i++) {
			if (flota[i].getKilometros() == 0) {
				cantidadDe0Km++;

			}

		}
		return cantidadDe0Km;

	}

	public double calcularPrecioPromedio() {
		double sumatoriaDePrecio = 0.0;

		for (int i = 0; i < Coche.getCantidadCoches(); i++) {
			sumatoriaDePrecio += flota[i].getPrecio();
		}
		return (sumatoriaDePrecio / Coche.getCantidadCoches());
	}

	public String toString() {
		String resultado = "";

		for (int i = 0; i < cantidadDeCoches; i++) {
			resultado += flota[i].toString() + "\n";

		}
		return resultado;
	}
}