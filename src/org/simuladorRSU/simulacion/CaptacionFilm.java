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
public class CaptacionFilm extends Modulo {

	private Linea lineaEntrada = null;
	private Linea lineaSalidaFilm = null;
	private Linea lineaSalidaOtros = null;
    private int velocidad = 50;
	
	public CaptacionFilm(Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFilm = lineaSalidaFilm;
		this.lineaSalidaOtros = lineaSalidaOtros;
        this.velocidad = 50;
	}

	public CaptacionFilm(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFilm = lineaSalidaFilm;
		this.lineaSalidaOtros = lineaSalidaOtros;
        this.velocidad = 50;
	}

    public CaptacionFilm(Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros, int velocidad) {
        super();
        this.lineaEntrada = lineaEntrada;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaOtros = lineaSalidaOtros;
        this.velocidad = velocidad;
    }

    public CaptacionFilm(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros, int velocidad) {
        super(RSU);
        this.lineaEntrada = lineaEntrada;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaOtros = lineaSalidaOtros;
        this.velocidad = velocidad;
    }

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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
	public void salida() {
		Residuos residuos;

    	synchronized (RSU) {
    		residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		lineaSalidaFilm.put(residuos.getResiduosCaptadosSeparacionFilm(0.776588 * calcularPorcentaje()));
		lineaSalidaOtros.put(residuos);
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
