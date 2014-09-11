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
public class TriajeManualPositivo1 extends ModuloHumano {

    private Linea lineaEntradaTromelEnvases;
    private Linea lineaEntradaCaptacionFilm;
    private Salida lineaSalidaPapelyCarton;
    private Salida lineaSalidaFilm;
    private Salida lineaSalidaPEAD;
    private Linea lineaSalidaRechazo;

    public TriajeManualPositivo1(Linea lineaEntradaTromelEnvases, Linea lineaEntradaCaptacionFilm, 
    							Salida lineaSalidaPapelyCarton, Salida lineaSalidaFilm, 
    							Salida lineaSalidaPEAD, Linea lineaSalidaRechazo) {
        super();
        this.lineaEntradaTromelEnvases = lineaEntradaTromelEnvases;
        this.lineaEntradaCaptacionFilm = lineaEntradaCaptacionFilm;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaRechazo = lineaSalidaRechazo;

    }

    public TriajeManualPositivo1(Residuos RSU, Linea lineaEntradaTromelEnvases, 
    							Linea lineaEntradaCaptacionFilm, Salida lineaSalidaPapelyCarton, 
    							Salida lineaSalidaFilm, Salida lineaSalidaPEAD, Linea lineaSalidaRechazo) {
        super(RSU);
        this.lineaEntradaTromelEnvases = lineaEntradaTromelEnvases;
        this.lineaEntradaCaptacionFilm = lineaEntradaCaptacionFilm;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaRechazo = lineaSalidaRechazo;
    }
    
    public TriajeManualPositivo1(Residuos RSU, Linea lineaEntradaTromelEnvases, 
								Linea lineaEntradaCaptacionFilm, Salida lineaSalidaPapelyCarton, 
								Salida lineaSalidaFilm, Salida lineaSalidaPEAD, Linea lineaSalidaRechazo, 
								int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, efectividad, velocidad, numTrabajadores);
        this.lineaEntradaTromelEnvases = lineaEntradaTromelEnvases;
        this.lineaEntradaCaptacionFilm = lineaEntradaCaptacionFilm;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaRechazo = lineaSalidaRechazo;

    }

    public TriajeManualPositivo1(Linea lineaEntradaTromelEnvases, 
								Linea lineaEntradaCaptacionFilm, Salida lineaSalidaPapelyCarton, 
								Salida lineaSalidaFilm, Salida lineaSalidaPEAD, Linea lineaSalidaRechazo, 
								int efectividad, int velocidad, int numTrabajadores) {
        super(efectividad, velocidad, numTrabajadores);
        this.lineaEntradaTromelEnvases = lineaEntradaTromelEnvases;
        this.lineaEntradaCaptacionFilm = lineaEntradaCaptacionFilm;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaRechazo = lineaSalidaRechazo;

    }

    protected double calcularPorcentaje() {
        double resultado = 1.0;

        double resultNumTrabajadores = 1.0;
        if (numTrabajadores == 0) {
            resultNumTrabajadores = 0.0;
        } else if (numTrabajadores <= 4) {
            // f(x):=(0.6*x)/4;
            resultNumTrabajadores = (0.6*numTrabajadores)/4;
        } else if (numTrabajadores <= 8) {
            // f(x):=(0.3*x)/4 + 0.3;
            resultNumTrabajadores = (0.3*numTrabajadores)/4 + 0.3;
        } else {
            // f(x):=(0.05*x)/2 + 0.7;
            resultNumTrabajadores = (0.05*numTrabajadores)/2 + 0.7;
        }

        double resultVelocidad = 1.0;
        if (velocidad == 0) {
            resultVelocidad = 0.0;
        } else if (velocidad <= 50) {
            // f(x):=(-0.16*x)/49 + 47.2/49;
            resultVelocidad = (-1.0*0.16*velocidad)/49;
            resultVelocidad += 47.2/49.0;
        } else {
            // g(x):=(-0.60*x)/50 + 7/5;
            resultVelocidad = (-1.0*0.60*velocidad)/50;
            resultVelocidad += 7/5;
        }

        resultado = resultNumTrabajadores*resultVelocidad*(efectividad/100.0);

        return resultado;
    }
    
    @Override
    public synchronized void salida() {
    	Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
    	this.lineaSalidaFilm.add(residuos.disminuirFilmPorcentaje(0.044848*calcularPorcentaje()));
    	this.lineaSalidaPapelyCarton.add(residuos.disminuirPapelyCartonPorcentaje(0.085683*calcularPorcentaje()));
    	this.lineaSalidaPEAD.add(residuos.disminuirPEADPorcentaje(0.125235*calcularPorcentaje()));
    	this.lineaSalidaRechazo.put(residuos);
    }

    @Override
    public synchronized void entrada () {
        Residuos aux = this.lineaEntradaCaptacionFilm.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
        aux = this.lineaEntradaTromelEnvases.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
    }
}
