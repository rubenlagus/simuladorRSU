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
public abstract class ModuloHumano extends Modulo {
    protected int efectividad;
    protected int velocidad;
    protected int numTrabajadores;

    public ModuloHumano(Residuos RSU, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU);
        this.efectividad = efectividad;
        this.velocidad = velocidad;
        this.numTrabajadores = numTrabajadores;
    }

    public ModuloHumano(int efectividad, int velocidad, int numTrabajadores) {
        super();
        this.efectividad = efectividad;
        this.velocidad = velocidad;
        this.numTrabajadores = numTrabajadores;
    }

    public ModuloHumano(Residuos RSU) {
        super(RSU);
        this.efectividad = 50;
        this.velocidad = 50;
        this.numTrabajadores = 4;
    }

    public ModuloHumano() {
        super();
        this.efectividad = 50;
        this.velocidad = 50;
        this.numTrabajadores = 4;
    }

    public synchronized int getEfectividad() {
		return efectividad;
	}

    public synchronized void setEfectividad(int efectividad) {
		this.efectividad = efectividad;
	}

    public synchronized int getVelocidad() {
		return velocidad;
	}

    public synchronized void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

    public synchronized int getNumTrabajadores() {
		return numTrabajadores;
	}

    public synchronized void setNumTrabajadores(int numTrabajadores) {
		this.numTrabajadores = numTrabajadores;
	}
}
