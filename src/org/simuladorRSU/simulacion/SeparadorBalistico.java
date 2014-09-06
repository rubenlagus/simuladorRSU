package org.simuladorRSU.simulacion;

public class SeparadorBalistico extends Modulo {

	private Linea lineaEntradaCriba = null;
	private Linea lineaEntradaTriajeManual = null;
	private Linea lineaSalidaPlanares = null;
	private Linea lineaSalidaRodantes = null;
	private Linea lineaSalidaFinos = null;
	private int anguloInclinacion = 3; // TODO Separador Balistico Angulo inclinacion
	private int longitud = 6000; // TODO Separador Balistico Longitud
	private int movimiento = 1; // TODO Separador Bal�stico vibracion 
	
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
	}
	
	public SeparadorBalistico(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntrajaTriajeManual,
			Linea lineaSalidaPlanares, Linea lineaSalidaRodantes, Linea lineaSalidaFinos,
			int anguloInclinacion, int longitud, int movimiento) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntrajaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = anguloInclinacion;
		this.longitud = longitud;
		this.movimiento = movimiento;
	}

	public SeparadorBalistico(Linea lineaEntradaCriba, Linea lineaEntradaTriajeManual, Linea lineaSalidaPlanares,
			Linea lineaSalidaRodantes, Linea lineaSalidaFinos, int anguloInclinacion,
			int longitud, int movimiento) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaTriajeManual = lineaEntradaTriajeManual;
		this.lineaSalidaPlanares = lineaSalidaPlanares;
		this.lineaSalidaRodantes = lineaSalidaRodantes;
		this.lineaSalidaFinos = lineaSalidaFinos;
		this.anguloInclinacion = anguloInclinacion;
		this.longitud = longitud;
		this.movimiento = movimiento;
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
	
	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		this.lineaSalidaFinos.add(residuos.disminuirPorcentaje(0.254257*calcularPorcentaje()));
		this.lineaSalidaRodantes.add(residuos.disminuirPorcentaje(0.251230*calcularPorcentaje()));
		this.lineaSalidaPlanares.add(residuos);

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
		return 1.0;
	}
	
	private double calcularPorcentajePlanares() {
		return 1.0;
	}
}
