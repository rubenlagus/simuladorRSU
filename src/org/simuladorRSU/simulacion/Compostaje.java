/**
 *   Copyright 2014 Ruben Bermudez
 *
 *   This file is part of SimulacionRSU.
 *
 *   SimulacionRSU is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   SimulacionRSU is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SimulacionRSU.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.simuladorRSU.simulacion;

/**
 * @author Ruben Bermudez
 */
public class Compostaje extends Modulo {
	
	private Linea entrada;
	private Linea rechazo;
	private Salida compost;

	public Compostaje(Linea entrada, Linea rechazo, Salida compost) {
		super();
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}

	public Compostaje(Linea entrada, Linea rechazo, Salida compost, Residuos RSU) {
		super(RSU);
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}

	public Compostaje(Linea entrada, Linea rechazo, Salida compost, int tiempo) {
		super();
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}

	public Compostaje(Linea entrada, Linea rechazo, Salida compost, Residuos RSU, int tiempo) {
		super(RSU);
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}

	@Override
	protected double calcularPorcentaje() {
		return 1.0; // Not Implemented
	}
		
	private double calcularPorcentajePerdido() {
		return 1.0; // Not Implemented
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		compost.add(residuos.generarCompost(0.340891*calcularPorcentaje(), 0.434089*calcularPorcentajePerdido()));
		rechazo.put(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.entrada.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
	}

}
