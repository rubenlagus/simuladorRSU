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
public class SeparadorBalistico extends Modulo {

	private Linea lineaEntradaCriba = null;
	private Linea lineaEntradaTriajeManual = null;
	private Linea lineaSalidaPlanares = null;
	private Linea lineaSalidaRodantes = null;
	private Linea lineaSalidaFinos = null;
	private int anguloInclinacion = 3;
	private int longitud = 6000;
	private int movimiento = 1;
    private int diametroHuecos = 20;
	
	public SeparadorBalistico(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntrajaTriajeManual,
			Linea lineaSalidaPlanares, Linea lineaSalidaRodantes, Linea lineaSalidaFinos) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntrajaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = 3;
		this.longitud = 6000;
		this.movimiento = 1;
        this.diametroHuecos = 20;
	}
	
	public SeparadorBalistico(Linea lineaEntradaCriba, Linea lineaEntradaTriajeManual, Linea lineaSalidaPlanares,
			Linea lineaSalidaRodantes, Linea lineaSalidaFinos) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntradaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = 3;
		this.longitud = 6000;
		this.movimiento = 1;
        this.diametroHuecos = 20;
	}
	
	public SeparadorBalistico(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntrajaTriajeManual,
			Linea lineaSalidaPlanares, Linea lineaSalidaRodantes, Linea lineaSalidaFinos,
			int anguloInclinacion, int longitud, int movimiento, int diametroHuecos) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntrajaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = anguloInclinacion;
		this.longitud = longitud;
		this.movimiento = movimiento;
        this.diametroHuecos = diametroHuecos;
	}

    public SeparadorBalistico(Linea lineaEntradaCriba, Linea lineaEntradaTriajeManual, Linea lineaSalidaPlanares,
			Linea lineaSalidaRodantes, Linea lineaSalidaFinos, int anguloInclinacion,
			int longitud, int movimiento, int diametroHuecos) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntradaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = anguloInclinacion;
		this.longitud = longitud;
		this.movimiento = movimiento;
        this.diametroHuecos = diametroHuecos;
	}

	public Linea getLineaEntrada() {
		return lineaEntradaCriba;
	}

	public Linea getLineaSalidaPlanares() {
		return lineaSalidaPlanares;
	}

	public Linea getLineaSalidaRodantes() {
		return lineaSalidaRodantes;
	}

	public Linea getLineaSalidaFinos() {
		return lineaSalidaFinos;
	}

	public synchronized int getAnguloInclinacion() {
		return anguloInclinacion;
	}

	public synchronized int getLongitud() {
		return longitud;
	}

	public synchronized int getMovimiento() {
		return movimiento;
	}

	public synchronized void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntradaCriba = lineaEntrada;
	}

	public void setLineaSalidaPlanares(Linea lineaSalidaPlanares) {
		this.lineaSalidaPlanares = lineaSalidaPlanares;
	}

	public void setLineaSalidaRodantes(Linea lineaSalidaRodantes) {
		this.lineaSalidaRodantes = lineaSalidaRodantes;
	}

	public void setLineaSalidaFinos(Linea lineaSalidaFinos) {
		this.lineaSalidaFinos = lineaSalidaFinos;
	}

	public synchronized void setAnguloInclinacion(int anguloInclinacion) {
		this.anguloInclinacion = anguloInclinacion;
	}

	public synchronized void setLongitud(int longitud) {
		this.longitud = longitud;
	}

    public int getDiametroHuecos() {
        return diametroHuecos;
    }

    public void setDiametroHuecos(int diametroHuecos) {
        this.diametroHuecos = diametroHuecos;
    }

    public Linea getLineaEntradaCriba() {
        return lineaEntradaCriba;
    }

    public void setLineaEntradaCriba(Linea lineaEntradaCriba) {
        this.lineaEntradaCriba = lineaEntradaCriba;
    }

    public Linea getLineaEntradaTriajeManual() {
        return lineaEntradaTriajeManual;
    }

    public void setLineaEntradaTriajeManual(Linea lineaEntradaTriajeManual) {
        this.lineaEntradaTriajeManual = lineaEntradaTriajeManual;
    }

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
            residuos = this.RSU;
            this.RSU = new Residuos();
    	}
		this.lineaSalidaFinos.put(residuos.getResiduosFinosSeparadorBalistico(0.254257 * calcularPorcentaje()));
		this.lineaSalidaRodantes.put(residuos.getResiduosRodantesSeparadorBalistico(0.251230 * calcularPorcentaje()));
		this.lineaSalidaPlanares.put(residuos);

	}

	@Override
	public void entrada() {
		Residuos aux = this.lineaEntradaCriba.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
        aux = this.lineaEntradaTriajeManual.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
	}

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}

	private double calcularPorcentajeFinos() {
        double resultado = 1.0;

        double resultadoLongitud = 1.0;
        resultadoLongitud = (0.2 * longitud)/3000 + 0.3;

        double resultadoDiametro = 1.0;
        resultadoDiametro = (0.1 * diametroHuecos)/40 + 0.65;

        double resultInclinacion = 1.0;
        resultInclinacion = (83 - anguloInclinacion)/80;

        resultado = resultadoDiametro * resultadoLongitud * resultInclinacion;
		return resultado;
	}
	
	private double calcularPorcentajePlanares() {
        double resultado = 1.0;

        double resultadoLongitud = 1.0;
        resultadoLongitud = (0.35 * longitud)/3000 - (1.75/2) + 0.95;

        double resultadoDiametro = 1.0;
        resultadoDiametro = (-0.15 * diametroHuecos)/80 + (7.9/8);

        double resultInclinacion = 1.0;
        resultInclinacion = (83 - anguloInclinacion)/80;

        double resultVelocidad = 1.0;
        resultVelocidad = (0.02 - anguloInclinacion) + 0.8;

        resultado = resultadoDiametro * resultadoLongitud * resultInclinacion * resultVelocidad;
        return resultado;
	}
}
