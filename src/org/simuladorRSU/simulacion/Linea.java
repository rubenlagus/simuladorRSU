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

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Ruben Bermudez
 */
public class Linea {
    protected ConcurrentLinkedDeque<Residuos> colaResiduos;

    public Linea() {
        colaResiduos = new ConcurrentLinkedDeque<Residuos>();
    }

    public void put(Residuos RSU) {
        colaResiduos.add(RSU);
    }

    public Residuos get() {
        return colaResiduos.poll();
    }
}
