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
public class TriajeManualPositivo2 extends ModuloHumano {

    private Linea lineaEntradaTromel;
    private Salida lineaSalidaPapelyCarton;
    private Salida lineaSalidaFilm;
    private Salida lineaSalidaPEAD;
    private Linea lineaSalidaSeparador;

    public TriajeManualPositivo2(Linea lineaEntradaTromel, Salida lineaSalidaPEAD,
    							Salida lineaSalidaPapelyCarton, Salida lineaSalidaFilm, 
    							Linea lineaSalidaSeparador) {
        super();
        this.lineaEntradaTromel = lineaEntradaTromel;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaSeparador = lineaSalidaSeparador;

    }

    public TriajeManualPositivo2(Residuos RSU, Salida lineaSalidaPEAD,
    							Linea lineaEntradaTromel, Salida lineaSalidaPapelyCarton, 
    							Salida lineaSalidaFilm, Linea lineaSalidaSeparador) {
        super(RSU,1,1,1);
        this.lineaEntradaTromel = lineaEntradaTromel;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaSeparador = lineaSalidaSeparador;
    }
    
    public TriajeManualPositivo2(Residuos RSU, Salida lineaSalidaPEAD,
								Linea lineaEntradaTromel, Salida lineaSalidaPapelyCarton, 
								Salida lineaSalidaFilm, Linea lineaSalidaSeparador, 
								int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, efectividad, velocidad, numTrabajadores);
        this.lineaEntradaTromel = lineaEntradaTromel;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaSeparador = lineaSalidaSeparador;

    }

    public TriajeManualPositivo2(Salida lineaSalidaPEAD,
    							Linea lineaEntradaTromel, Salida lineaSalidaPapelyCarton, 
								Salida lineaSalidaFilm, Linea lineaSalidaSeparador, 
								int efectividad, int velocidad, int numTrabajadores) {
        super(efectividad, velocidad, numTrabajadores);
        this.lineaEntradaTromel = lineaEntradaTromel;
        this.lineaSalidaPapelyCarton = lineaSalidaPapelyCarton;
        this.lineaSalidaFilm = lineaSalidaFilm;
        this.lineaSalidaPEAD = lineaSalidaPEAD;
        this.lineaSalidaSeparador = lineaSalidaSeparador;

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
    	this.lineaSalidaPEAD.add(residuos.disminuirPEADPorcentaje(0.015654*calcularPorcentaje()));
    	this.lineaSalidaFilm.add(residuos.disminuirFilmPorcentaje(0.002980*calcularPorcentaje()));
    	this.lineaSalidaPapelyCarton.add(residuos.disminuirPapelyCartonPorcentaje(0.010710*calcularPorcentaje()));
    	this.lineaSalidaSeparador.add(residuos);
    }

    @Override
    public synchronized void entrada () {
        Residuos aux = this.lineaEntradaTromel.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
    }
}
