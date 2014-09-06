package org.simuladorRSU.simulacion;


public class SeparadorInductivo extends Modulo {

	protected Linea lineaEntrada = null; 
	protected Linea lineaSalidaAluminio = null;
	protected Linea lineaSalidaMezcla = null;
	protected int velocidadCinta = 50;
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaAluminio
	 * @param lineaSalidaMezcla
	 * @param velocidadCinta
	 */
	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, int velocidadCinta) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = velocidadCinta;
	}
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaAluminio
	 * @param lineaSalidaMezcla
	 */
	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = 50;
	}

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaAluminio
	 * @param lineaSalidaMezcla
	 * @param velocidadCinta
	 */
	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, int velocidadCinta, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = velocidadCinta;
	}
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaAluminio
	 * @param lineaSalidaMezcla
	 */
	public SeparadorInductivo(Linea lineaEntrada, Linea lineaSalidaAluminio,
			Linea lineaSalidaMezcla, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaAluminio = lineaSalidaAluminio;
		this.lineaSalidaMezcla = lineaSalidaMezcla;
		this.velocidadCinta = 50;
	}
	
	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public Linea getLineaSalidaAluminio() {
		return lineaSalidaAluminio;
	}

	public void setLineaSalidaAluminio(Linea lineaSalidaAluminio) {
		this.lineaSalidaAluminio = lineaSalidaAluminio;
	}

	public Linea getLineaSalidaMezcla() {
		return lineaSalidaMezcla;
	}

	public void setLineaSalidaMezcla(Linea lineaSalidaMezcla) {
		this.lineaSalidaMezcla = lineaSalidaMezcla;
	}

	public int getVelocidadCinta() {
		return velocidadCinta;
	}

	public void setVelocidadCinta(int velocidadCinta) {
		this.velocidadCinta = velocidadCinta;
	}
	
	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
    	lineaSalidaAluminio.add(residuos.disminuirPorcentaje(0.015228*calcularPorcentaje()));
		lineaSalidaMezcla.add(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.lineaEntrada.get();
		if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
	}
	

}
