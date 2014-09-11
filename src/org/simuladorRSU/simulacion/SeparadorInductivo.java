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
public class SeparadorInductivo extends Modulo {

	protected Linea lineaEntrada = null; 
	protected Linea lineaSalidaAluminio = null;
	protected Linea lineaSalidaMezcla = null;
	protected int velocidadCinta = 50;
	
	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, int velocidadCinta) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = velocidadCinta;
	}

	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = 50;
	}

	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, int velocidadCinta, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = velocidadCinta;
	}

	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = 50;
	}
	
	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public Linea getLineaSalidaAluminio() {
		return lineaSalidaAluminio;
	}

	public void setLineaSalidaAluminio(Linea lineaSalidaAluminio) {
		this.lineaSalidaAluminio = lineaSalidaAluminio;
	}

	public Linea getLineaSalidaMezcla() {
		return lineaSalidaMezcla;
	}

	public void setLineaSalidaMezcla(Linea lineaSalidaMezcla) {
		this.lineaSalidaMezcla = lineaSalidaMezcla;
	}

	public int getVelocidadCinta() {
		return velocidadCinta;
	}

	public void setVelocidadCinta(int velocidadCinta) {
		this.velocidadCinta = velocidadCinta;
	}
	
	@Override
	protected double calcularPorcentaje() {
        double resultado = 1.0;
        if (velocidadCinta == 0) {
            resultado = 0.0;
        } else if (velocidadCinta <= 50) {
            // f(x):=(-0.16*x)/49 + 47.2/49;
            resultado = (-1.0*0.16*velocidadCinta)/49;
            resultado += 47.2/49.0;
        } else {
            // g(x):=(-0.60*x)/50 + 7/5;
            resultado = (-1.0*0.60*velocidadCinta)/50;
            resultado += 7/5;
        }
        return resultado;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
    	lineaSalidaAluminio.put(residuos.getResiduosSeparadosSeparadorInductivo(0.015228 * calcularPorcentaje()));
		lineaSalidaMezcla.put(residuos);
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
	

}
