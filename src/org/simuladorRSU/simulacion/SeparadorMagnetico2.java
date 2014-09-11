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
public class SeparadorMagnetico2 extends Modulo {

	private Linea lineaEntrada = null;
	private Linea lineaSalidaPlasticos = null; 
	private Salida lineaSalidaFerricos = null;
	private int velocidad = 50;
	
	
	
	public SeparadorMagnetico2(Residuos RSU, Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico2(Linea lineaEntrada, Salida lineaSalidaFerricos,
			Linea lineaSalidaPlasticos) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico2(Residuos RSU, Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos, int velocidad) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = velocidad;
	}

	public SeparadorMagnetico2(Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos, int velocidad) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = velocidad;
	}

	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public Salida getLineaSalidaFerricos() {
		return lineaSalidaFerricos;
	}

	public Linea getLineaSalidaPlasticos() {
		return lineaSalidaPlasticos;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public void setlineaSalidaFerricos(Salida lineaSalidaFerricos) {
		this.lineaSalidaFerricos = lineaSalidaFerricos;
	}

	public void setLineaSalidaPlasticos(Linea lineaSalidaPlasticos) {
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
	}

	@Override
	public void salida() { 
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		this.lineaSalidaFerricos.add(residuos.disminuirAceroPorcentaje(0.99*calcularPorcentaje()));
		this.lineaSalidaPlasticos.put(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.lineaEntrada.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
	}

	@Override
	protected double calcularPorcentaje() {
        double resultado = 1.0;
        if (velocidad == 0) {
            resultado = 0.0;
        } else if (velocidad<=50) {
            // f(x):=(-0.16*x)/49 + 47.2/49;
            resultado = (-1.0*0.16*velocidad)/49;
            resultado += 47.2/49.0;
        } else {
            // g(x):=(-0.60*x)/50 + 7/5;
            resultado = (-1.0*0.60*velocidad)/50;
            resultado += 7/5;
        }
        return resultado;
	}

}