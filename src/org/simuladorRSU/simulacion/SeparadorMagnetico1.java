package org.simuladorRSU.simulacion;

public class SeparadorMagnetico1 extends Modulo {

	private Linea lineaEntradaCriba = null;
	private Linea lineaEntradaSeparadorBalistico = null;
	private Linea lineaSalidaOrganica = null; 
	private Salida lineaSalidaFerricos = null;
	private int velocidad = 50; // TODO Separador Magnetico velocidad cinta
	
	
	
	public SeparadorMagnetico1(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico1(Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico, Salida lineaSalidaFerricos,
			Linea lineaSalidaOrganica) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico1(Residuos RSU, Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica, int velocidad) {
		super(RSU);
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = velocidad;
	}

	public SeparadorMagnetico1(Linea lineaEntradaCriba, Linea lineaEntradaSeparadorBalistico,
			Salida lineaSalidaFerricos, Linea lineaSalidaOrganica, int velocidad) {
		super();
		this.lineaEntradaCriba = lineaEntradaCriba;
		this.lineaEntradaSeparadorBalistico = lineaEntradaSeparadorBalistico;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaOrganica = lineaSalidaOrganica;
		this.velocidad = velocidad;
	}

	public Linea getLineaEntrada() {
		return lineaEntradaCriba;
	}

	public Salida getLineaSalidaFerricos() {
		return lineaSalidaFerricos;
	}

	public Linea getLineaSalidaOrganica() {
		return lineaSalidaOrganica;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntradaCriba = lineaEntrada;
	}

	public void setlineaSalidaFerricos(Salida lineaSalidaFerricos) {
		this.lineaSalidaFerricos = lineaSalidaFerricos;
	}

	public void setLineaSalidaOrganica(Linea lineaSalidaOrganica) {
		this.lineaSalidaOrganica = lineaSalidaOrganica;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		this.lineaSalidaFerricos.add(residuos.disminuirAceroPorcentaje(0.99*calcularPorcentaje()));
		this.lineaSalidaOrganica.add(residuos);
	}

	@Override
	public void entrada() {
		Residuos aux = this.lineaEntradaCriba.get();
        if (aux != null) {
        	synchronized (RSU) {
        		this.RSU.suma(aux);
        	}
        }
        aux = this.lineaEntradaSeparadorBalistico.get();
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

}
