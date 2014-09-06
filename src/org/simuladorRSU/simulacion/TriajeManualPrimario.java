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
public class TriajeManualPrimario extends ModuloHumano {

    private Linea lineaEntrada;
    private Linea lineaSalida;
    private Salida lineaSalidaVoluminosos;
    private Salida lineaSalidaVoluminososMetalicos;
    private Salida lineaSalidaVidrio;
    private Salida lineaSalidaPapelCarton;

    public TriajeManualPrimario(Linea lineaEntrada, Salida lineaSalidaVidrio,
                                Salida lineaSalidaVoluminosos, Salida lineaSalidaPapelCarton,
                                Salida lineaSalidaVoluminososMetalicos, Linea lineaSalida) {
        super();
        this.lineaEntrada = lineaEntrada;
        this.lineaSalida = lineaSalida;
        this.lineaSalidaPapelCarton = lineaSalidaPapelCarton;
        this.lineaSalidaVidrio = lineaSalidaVidrio;
        this.lineaSalidaVoluminosos = lineaSalidaVoluminosos;
        this.lineaSalidaVoluminososMetalicos = lineaSalidaVoluminososMetalicos;

    }

    public TriajeManualPrimario(Residuos RSU, Linea lineaEntrada, Salida lineaSalidaVidrio,
                                Salida lineaSalidaVoluminosos, Salida lineaSalidaPapelCarton,
                                Salida lineaSalidaVoluminososMetalicos, Linea lineaSalida) {
        super(RSU,1,1,1);
        this.lineaEntrada = lineaEntrada;
        this.lineaSalida = lineaSalida;
        this.lineaSalidaPapelCarton = lineaSalidaPapelCarton;
        this.lineaSalidaVidrio = lineaSalidaVidrio;
        this.lineaSalidaVoluminosos = lineaSalidaVoluminosos;
        this.lineaSalidaVoluminososMetalicos = lineaSalidaVoluminososMetalicos;

    }
    public TriajeManualPrimario(Residuos RSU, Linea lineaEntrada, Salida lineaSalidaVidrio,
                                Salida lineaSalidaVoluminosos, Salida lineaSalidaPapelCarton,
                                Salida lineaSalidaVoluminososMetalicos, Linea lineaSalida, int efectividad,
                                int velocidad, int numTrabajadores) {
        super(RSU, efectividad, velocidad, numTrabajadores);
        this.lineaEntrada = lineaEntrada;
        this.lineaSalida = lineaSalida;
        this.lineaSalidaPapelCarton = lineaSalidaPapelCarton;
        this.lineaSalidaVidrio = lineaSalidaVidrio;
        this.lineaSalidaVoluminosos = lineaSalidaVoluminosos;
        this.lineaSalidaVoluminososMetalicos = lineaSalidaVoluminososMetalicos;

    }

    public TriajeManualPrimario(Linea lineaEntrada, Salida lineaSalidaVidrio,
                                Salida lineaSalidaVoluminosos, Salida lineaSalidaPapelCarton,
                                Salida lineaSalidaVoluminososMetalicos, Linea lineaSalida, int efectividad,
                                int velocidad, int numTrabajadores) {
        super(efectividad, velocidad, numTrabajadores);
        this.lineaEntrada = lineaEntrada;
        this.lineaSalida = lineaSalida;
        this.lineaSalidaPapelCarton = lineaSalidaPapelCarton;
        this.lineaSalidaVidrio = lineaSalidaVidrio;
        this.lineaSalidaVoluminosos = lineaSalidaVoluminosos;
        this.lineaSalidaVoluminososMetalicos = lineaSalidaVoluminososMetalicos;

    }

    protected double calcularPorcentaje() {
		return (efectividad/100)*(velocidad/100)*numTrabajadores;
	}
    
    @Override
    public synchronized void salida() {
    	Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
        this.lineaSalidaVidrio.add(residuos.disminuirVidrioPorcentaje(0.407268*calcularPorcentaje()));
        this.lineaSalidaVoluminosos.add(residuos.disminuirVoluminososCompleto());
        this.lineaSalidaVoluminososMetalicos.add(residuos.disminuirVoluminososMetalicosCompleto());
        this.lineaSalidaPapelCarton.add(residuos.disminuirPapelyCartonPorcentaje(0.093716*calcularPorcentaje()));
        this.lineaSalida.add(residuos);
    }

    @Override
    public synchronized void entrada () {
        Residuos aux = this.lineaEntrada.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
    }
}
