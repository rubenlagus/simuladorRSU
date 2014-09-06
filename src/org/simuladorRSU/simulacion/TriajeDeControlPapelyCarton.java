package org.simuladorRSU.simulacion;

public class TriajeDeControlPapelyCarton extends TriajeDeControl {

	
	
	/**
	 * 
	 */
	public TriajeDeControlPapelyCarton(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	/**
	 * 
	 */
	public TriajeDeControlPapelyCarton(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.RSU = RSU; 
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		salidaMaterial.add(residuos.disminuirPapelyCartonPorcentaje(0.080270*calcularPorcentaje()));
		salidaRechazo.add(residuos);
	}

}
