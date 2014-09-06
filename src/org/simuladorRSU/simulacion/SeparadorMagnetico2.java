package org.simuladorRSU.simulacion;

public class SeparadorMagnetico2 extends Modulo {

	private Linea lineaEntrada = null;
	private Linea lineaSalidaPlasticos = null; 
	private Salida lineaSalidaFerricos = null;
	private int velocidad = 50; // TODO Separador Magnetico velocidad cinta
	
	
	
	public SeparadorMagnetico2(Residuos RSU, Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico2(Linea lineaEntrada, Salida lineaSalidaFerricos,
			Linea lineaSalidaPlasticos) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = 50;
	}
	
	public SeparadorMagnetico2(Residuos RSU, Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos, int velocidad) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = velocidad;
	}

	public SeparadorMagnetico2(Linea lineaEntrada,
			Salida lineaSalidaFerricos, Linea lineaSalidaPlasticos, int velocidad) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFerricos = lineaSalidaFerricos;
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
		this.velocidad = velocidad;
	}

	public Linea getLineaEntrada() {
		return lineaEntrada;
	}

	public Salida getLineaSalidaFerricos() {
		return lineaSalidaFerricos;
	}

	public Linea getLineaSalidaPlasticos() {
		return lineaSalidaPlasticos;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setLineaEntrada(Linea lineaEntrada) {
		this.lineaEntrada = lineaEntrada;
	}

	public void setlineaSalidaFerricos(Salida lineaSalidaFerricos) {
		this.lineaSalidaFerricos = lineaSalidaFerricos;
	}

	public void setLineaSalidaPlasticos(Linea lineaSalidaPlasticos) {
		this.lineaSalidaPlasticos = lineaSalidaPlasticos;
	}

	@Override
	public void salida() { 
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		this.lineaSalidaFerricos.add(residuos.disminuirAceroPorcentaje(0.99*calcularPorcentaje()));
		this.lineaSalidaPlasticos.add(residuos);
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

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}

}