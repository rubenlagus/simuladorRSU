package org.simuladorRSU.simulacion;


public class Compostaje extends Modulo {
	
	private Linea entrada;
	private Linea rechazo;
	private Salida compost;
	
	/**
	 * @param rechazo
	 * @param compost
	 * @param entrada
	 */
	public Compostaje(Linea entrada, Linea rechazo, Salida compost) {
		super();
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}
	
	/**
	 * @param rechazo
	 * @param compost
	 * @param entrada
	 */
	public Compostaje(Linea entrada, Linea rechazo, Salida compost, Residuos RSU) {
		super(RSU);
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}
	
	/**
	 * @param rechazo
	 * @param compost
	 * @param entrada
	 */
	public Compostaje(Linea entrada, Linea rechazo, Salida compost, int tiempo) {
		super();
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}
	
	/**
	 * @param rechazo
	 * @param compost
	 * @param entrada
	 */
	public Compostaje(Linea entrada, Linea rechazo, Salida compost, Residuos RSU, int tiempo) {
		super(RSU);
		this.rechazo = rechazo;
		this.compost = compost;
		this.entrada = entrada;
	}

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}
		
	private double calcularPorcentajePerdido() {
		return 1.0;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		compost.add(residuos.generarCompost(0.340891*calcularPorcentaje(), 0.434089*calcularPorcentajePerdido()));
		rechazo.add(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.entrada.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
	}

}
