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
public class Foso extends Modulo {
    private Linea lineaSalida;
    private double porcentaje = 0.1;
    
    public Foso(Linea lineaSalida) {
        super();
        this.lineaSalida = lineaSalida;
    }

    public Foso(Residuos RSU, Linea lineaSalida) {
        super(RSU);
        this.lineaSalida = lineaSalida;
    }

    @Override
    public void salida() {
    	Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(0.3);
    	}
        lineaSalida.add(residuos);
    }

    @Override
    public void entrada() {
    }

    public void entrada(Residuos RSU) {
    	synchronized (RSU) {
    		this.RSU.suma(RSU);
    	}
    }

    @Override
    public void run() {
        while(!finished) {
            try {
                Thread.sleep(1000);
                synchronized(myThread) {
                    while (suspended) {
                        myThread.wait();
                    }
                }
            } catch (InterruptedException e) {
                finished = true;
            }
            this.salida();
        }
    }

    public double getPorcentaje() {
    	return porcentaje;
    }
    
    public void setPorcentaje(double porcentaje) {
    	this.porcentaje = porcentaje;
    }
    
	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}
}
