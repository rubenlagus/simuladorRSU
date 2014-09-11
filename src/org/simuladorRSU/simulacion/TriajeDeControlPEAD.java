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
public class TriajeDeControlPEAD extends TriajeDeControl {

    public TriajeDeControlPEAD(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(lineaEntrada, salidaMaterial, salidaRechazo);
    }

    public TriajeDeControlPEAD(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo);
    }

    public TriajeDeControlPEAD(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }

    public TriajeDeControlPEAD(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }
	
	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		salidaMaterial.add(residuos.disminuirPEADPorcentaje(0.860989*calcularPorcentaje()));
		salidaRechazo.put(residuos);
	}

}
