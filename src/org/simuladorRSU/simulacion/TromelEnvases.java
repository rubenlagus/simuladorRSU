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
public class TromelEnvases extends Modulo {

	private Linea lineaEntrada;
    private Linea lineaSalidaHundidosPequenios;
    private Linea lineaSalidaHundidosGrandes;
    private Linea lineaSalidaRebose;
    private int diametroPequenios;
    private int diametroGrandes;
    private int angulo;
    private int velocidadGiro;
    private int longitudPequenios;
    private int longitudGrandes;
    private int diametro;
    
	public TromelEnvases(Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametroPequenios = 200;
		diametroGrandes = 350;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitudPequenios = 3000;
	    longitudGrandes = 3000;
	    diametro = 2500;
	}
	
	public TromelEnvases(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametroPequenios = 200;
		diametroGrandes = 350;
	    angulo = 3;
	    velocidadGiro = 13;  // revoluciones por segundo
	    longitudPequenios = 3000;
	    longitudGrandes = 3000;
	    diametro = 2500;
	}
	
	public TromelEnvases(Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes, int diametroPequenios,
			int diametroGrandes, int angulo, int velocidadGiro, int diametro, 
			int longitudPequenios, int longitudGrandes) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametroPequenios = diametroPequenios;
		this.diametroGrandes = diametroGrandes;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitudPequenios = longitudPequenios;
		this.longitudGrandes = longitudGrandes;
		this.diametro = diametro;
	}
	
	public TromelEnvases(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes, int diametroPequenios,
			int diametroGrandes, int angulo, int velocidadGiro, int diametro, 
			int longitudPequenios, int longitudGrandes) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametroPequenios = diametroPequenios;
		this.diametroGrandes = diametroGrandes;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitudPequenios = longitudPequenios;
		this.longitudGrandes = longitudGrandes;
		this.diametro = diametro;
	}

	public synchronized int getDiametro() {
		return diametro;
	}

	public synchronized void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public synchronized int getLongitudGrandes() {
		return longitudGrandes;
	}

	public synchronized void setLongitudGrandes(int longitudGrandes) {
		this.longitudGrandes = longitudGrandes;
	}

	public synchronized int getDiametroPequenios() {
		return diametroPequenios;
	}

	public synchronized void setDiametroPequenios(int diametroPequenios) {
		this.diametroPequenios = diametroPequenios;
	}

	public synchronized int getDiametroGrandes() {
		return diametroGrandes;
	}

	public synchronized int getAngulo() {
		return angulo;
	}

	public synchronized int getVelocidadGiro() {
		return velocidadGiro;
	}

	public synchronized int getLongitudPequenios() {
		return longitudPequenios;
	}

	public synchronized void setDiametroGrandes(int diametroGrandes) {
		this.diametroGrandes = diametroGrandes;
	}

	public synchronized void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public synchronized void setVelocidadGiro(int velocidadGiro) {
		this.velocidadGiro = velocidadGiro;
	}

	public synchronized void setLongitudPequenios(int longitudPequenios) {
		this.longitudPequenios = longitudPequenios;
	}
	
	@Override
	public void salida() {
		Residuos residuos;
		synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
		}
		this.lineaSalidaHundidosPequenios.put(residuos.getResiduosHundidosPequeniosTromelEnvases(0.556350 * calcularPorcentaje()));
		this.lineaSalidaHundidosGrandes.put(residuos.getResiduosHundidosGrandesTromelEnvases(0.268593 * calcularPorcentaje()));
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

        double resultInclinacion = 1.0;
        resultInclinacion = (83 - angulo)/80;

        double resultDiametroHuecosGrandes = 1.0;
        if (diametroGrandes == 0) {
            resultDiametroHuecosGrandes = 0.0;
        } else {
            resultDiametroHuecosGrandes = (0.4*diametroGrandes)/200;
            resultDiametroHuecosGrandes += 0.3;
        }

        double resultDiametroHuecosPequenios = 1.0;
        if (diametroPequenios == 0) {
            resultDiametroHuecosPequenios = 0.0;
        } else {
            resultDiametroHuecosPequenios = (0.4*diametroPequenios)/100;
            resultDiametroHuecosPequenios -= 0.1;
        }

        double resultLongitudPequenios = 1.0;
        if (longitudPequenios <= 2500) {
            resultLongitudPequenios = (0.2*longitudPequenios)/1500;
            resultLongitudPequenios += 16.0/3.0;
        } else {
            resultLongitudPequenios = (0.4*longitudPequenios)/2500;
            resultLongitudPequenios += 0.1;
        }

        double resultLongitudGrandes = 1.0;
        if (longitudGrandes <= 2500) {
            resultLongitudGrandes = (0.2*longitudGrandes)/1500;
            resultLongitudGrandes += 16.0/3.0;
        } else {
            resultLongitudGrandes = (0.4*longitudGrandes)/2500;
            resultLongitudGrandes += 0.1;
        }

        result = resultVelocidadGiro * resultDiametroCilindro * resultDiametroHuecosGrandes *
                resultDiametroHuecosPequenios * resultInclinacion * resultLongitudPequenios * resultLongitudGrandes;
        return result;
	}

}
