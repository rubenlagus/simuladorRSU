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
 * Created by Ruben Bermudez on 08/05/2014.
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
        super(RSU,1,1,1);
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
    	return 1.0;
    }
    
    @Override
    public synchronized void salida() {
    	Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
    	this.lineaSalidaFilm.add(residuos.disminuirFilmPorcentaje(0.044848*calcularPorcentaje()));
    	this.lineaSalidaPapelyCarton.add(residuos.disminuirPapelyCartonPorcentaje(0.085683*calcularPorcentaje()));
    	this.lineaSalidaPEAD.add(residuos.disminuirPEADPorcentaje(0.125235*calcularPorcentaje()));
    	this.lineaSalidaRechazo.add(residuos);
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
