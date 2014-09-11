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
public class SeparadorOpticoBRIK extends SeparadorOptico {

	public SeparadorOpticoBRIK(Linea lineaEntrada,
                               Linea lineaSalidaSoplados, Linea lineaSalidaOtros,
                               int velocidadCinta, Residuos RSU) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, velocidadCinta, RSU);
	}

	public SeparadorOpticoBRIK(Linea lineaEntrada,
                               Linea lineaSalidaSoplados, Linea lineaSalidaOtros,
                               int velocidadCinta) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, velocidadCinta);
	}

	public SeparadorOpticoBRIK(Linea lineaEntrada,
                               Linea lineaSalidaSoplados, Linea lineaSalidaOtros, Residuos RSU) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, RSU);
	}

	public SeparadorOpticoBRIK(Linea lineaEntrada,
                               Linea lineaSalidaSoplados, Linea lineaSalidaOtros) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros);
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
    	lineaSalidaSoplados.put(residuos.getResiduosSeparadosSeparadorOpticoBrick((0.249042 * calcularPorcentaje())));
		lineaSalidaOtros.put(residuos);
	}
}