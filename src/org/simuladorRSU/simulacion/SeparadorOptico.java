package org.simuladorRSU.simulacion;

public abstract class SeparadorOptico extends Modulo {

	protected Linea lineaEntrada = null; 
	protected Linea lineaSalidaSoplados = null;
	protected Linea lineaSalidaOtros = null;
	protected int velocidadCinta = 50;
	
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param velocidadCinta
	 */
	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, int velocidadCinta) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = velocidadCinta;
	}
	
	

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 */
	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = 50;
	}
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param velocidadCinta
	 * @param RSU
	 */
	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, int velocidadCinta, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = velocidadCinta;
	}
	
	

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param RSU
	 */
	public SeparadorOptico(Linea lineaEntrada, Linea lineaSalidaSoplados,
			Linea lineaSalidaOtros, Residuos RSU) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaSoplados = lineaSalidaSoplados;
		this.lineaSalidaOtros = lineaSalidaOtros;
		this.velocidadCinta = 50;
	}



	@Override
    public void entrada() {
    	Residuos aux = this.lineaEntrada.get();
        if (aux != null) {
        	synchronized (RSU){
        		this.RSU.suma(aux);
        	}
        }
    }

	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public Linea getLineaSalidaSoplados() {
		return lineaSalidaSoplados;
	}

	public void setLineaSalidaSoplados(Linea lineaSalidaSoplados) {
		this.lineaSalidaSoplados = lineaSalidaSoplados;
	}

	public Linea getLineaSalidaOtros() {
		return lineaSalidaOtros;
	}

	public void setLineaSalidaOtros(Linea lineaSalidaOtros) {
		this.lineaSalidaOtros = lineaSalidaOtros;
	}

	public int getVelocidadCinta() {
		return velocidadCinta;
	}

	public void setVelocidadCinta(int velocidadCinta) {
		this.velocidadCinta = velocidadCinta;
	}    
}
