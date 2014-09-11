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
public abstract class SeparadorOptico extends Modulo {

	protected Linea lineaEntrada = null; 
	protected Linea lineaSalidaSoplados = null;
	protected Linea lineaSalidaOtros = null;
	protected int velocidadCinta = 50;

	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, int velocidadCinta) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = velocidadCinta;
	}

	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = 50;
	}

	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, int velocidadCinta, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = velocidadCinta;
	}

	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = 50;
	}



	@Override
    public void entrada() {
    	Residuos aux = this.lineaEntrada.get();
        if (aux != null) {
        	synchronized (RSU){
        		this.RSU.suma(aux);
        	}
        }
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

	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public Linea getLineaSalidaSoplados() {
		return lineaSalidaSoplados;
	}

	public void setLineaSalidaSoplados(Linea lineaSalidaSoplados) {
		this.lineaSalidaSoplados = lineaSalidaSoplados;
	}

	public Linea getLineaSalidaOtros() {
		return lineaSalidaOtros;
	}

	public void setLineaSalidaOtros(Linea lineaSalidaOtros) {
		this.lineaSalidaOtros = lineaSalidaOtros;
	}

	public int getVelocidadCinta() {
		return velocidadCinta;
	}

	public void setVelocidadCinta(int velocidadCinta) {
		this.velocidadCinta = velocidadCinta;
	}    
}
