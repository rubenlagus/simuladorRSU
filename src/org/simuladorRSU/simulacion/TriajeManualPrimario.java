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
        super(RSU);
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
        this.lineaSalidaVidrio.add(residuos.disminuirVidrioPorcentaje(0.407268*calcularPorcentaje()));
        this.lineaSalidaVoluminosos.add(residuos.disminuirVoluminososCompleto());
        this.lineaSalidaVoluminososMetalicos.add(residuos.disminuirVoluminososMetalicosCompleto());
        this.lineaSalidaPapelCarton.add(residuos.disminuirPapelyCartonPorcentaje(0.093716*calcularPorcentaje()));
        this.lineaSalida.put(residuos);
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
