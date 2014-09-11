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
public class SeparadorMagnetico1 extends Modulo {

	private Linea lineaEntradaCriba = null;
	private Linea lineaEntradaSeparadorBalistico = null;
	private Linea lineaSalidaOrganica = null; 
	private Salida lineaSalidaFerricos = null;
	private int velocidad = 50;
	
	
	
	public SeparadorMagnetico1(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico1(Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico, Salida lineaSalidaFerricos,
			Linea lineaSalidaOrganica) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico1(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica, int velocidad) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = velocidad;
	}

	public SeparadorMagnetico1(Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica, int velocidad) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = velocidad;
	}

	public Linea getLineaEntrada() {
		return lineaEntradaCriba;
	}

	public Salida getLineaSalidaFerricos() {
		return lineaSalidaFerricos;
	}

	public Linea getLineaSalidaOrganica() {
		return lineaSalidaOrganica;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntradaCriba = lineaEntrada;
	}

	public void setlineaSalidaFerricos(Salida lineaSalidaFerricos) {
		this.lineaSalidaFerricos = lineaSalidaFerricos;
	}

	public void setLineaSalidaOrganica(Linea lineaSalidaOrganica) {
		this.lineaSalidaOrganica = lineaSalidaOrganica;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		this.lineaSalidaFerricos.add(residuos.disminuirAceroPorcentaje(0.99*calcularPorcentaje()));
		this.lineaSalidaOrganica.put(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.lineaEntradaCriba.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
        aux = this.lineaEntradaSeparadorBalistico.get();
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
