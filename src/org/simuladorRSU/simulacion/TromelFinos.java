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
public class TromelFinos extends Modulo {

	private Linea lineaEntrada;
    private Linea lineaSalidaHundidos;
    private Linea lineaSalidaRebose;
    private int diametro;
    private int angulo;
    private int velocidadGiro;
    private int longitud;
    private int diametroHuecos;

	public TromelFinos(Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametro = 2500;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitud = 10000;
	    diametroHuecos = 80;
	}
	
	public TromelFinos(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametro = 2500;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitud = 10000;
	    diametroHuecos = 80;
	}
	
	public TromelFinos(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose, int diametro, int angulo, int velocidadGiro, int longitud,
			int diametroHuecos) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametro = diametro;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitud = longitud;
		this.diametroHuecos = diametroHuecos;
	}
	
	public TromelFinos(Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose, int diametro, int angulo, int velocidadGiro, int longitud,
			int diametroHuecos) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametro = diametro;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitud = longitud;
		this.diametroHuecos = diametroHuecos;
	}

	public synchronized int getDiametroHuecos() {
		return diametroHuecos;
	}

	public synchronized void setDiametroHuecos(int diametroHuecos) {
		this.diametroHuecos = diametroHuecos;
	}

	public synchronized int getDiametro() {
		return diametro;
	}

	public synchronized int getAngulo() {
		return angulo;
	}

	public synchronized int getVelocidadGiro() {
		return velocidadGiro;
	}

	public synchronized int getLongitud() {
		return longitud;
	}

	public synchronized void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public synchronized void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public synchronized void setVelocidadGiro(int velocidadGiro) {
		this.velocidadGiro = velocidadGiro;
	}

	public synchronized void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	
	@Override
	public void salida() {
		Residuos residuos;
		synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
		}
		this.lineaSalidaHundidos.put(residuos.getResiduosHundidosTromelFinos(0.444981 * calcularPorcentaje()));
		this.lineaSalidaRebose.put(residuos);
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
		double result = 1.0;

        double resultVelocidadGiro = 1.0;
        if (velocidadGiro == 0) {
            resultVelocidadGiro = 0.0;
        } else if (velocidadGiro <= 12) {
            resultVelocidadGiro = (-1.0*0.1*velocidadGiro)/7;
            resultVelocidadGiro += 6.8/7;
        } else {
            resultVelocidadGiro = -1.0*0.1*velocidadGiro + 2.1;
        }
        double resultDiametroCilindro = 1.0;
        resultDiametroCilindro = (0.2*diametro)/2000 + 0.45;

        double resultDiametroHuecos = 1.0;
        if (diametroHuecos == 0) {
            resultDiametroHuecos = 0.0;
        } else {
            resultDiametroHuecos = (0.4*diametroHuecos)/80;
            resultDiametroHuecos += 0.3;
        }

        double resultInclinacion = 1.0;
        resultInclinacion = (83 - angulo)/80;

        double resultLongitud = 1.0;
        if (longitud <= 10000) {
            resultLongitud = (0.2*longitud)/5000;
            resultLongitud += 0.1;
        } else {
            resultLongitud = (0.4*longitud)/5000;
            resultLongitud -= 0.3;
        }

        result = resultVelocidadGiro * resultDiametroCilindro * resultDiametroHuecos * resultInclinacion * resultLongitud;
        return result;
	}

}
