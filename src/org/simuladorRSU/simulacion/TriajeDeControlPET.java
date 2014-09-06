package org.simuladorRSU.simulacion;

public class TriajeDeControlPET extends TriajeDeControl {

	/**
	 * 
	 */
	public TriajeDeControlPET(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	/**
	 * 
	 */
	public TriajeDeControlPET(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
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
		salidaMaterial.add(residuos.disminuirPETPorcentaje(0.977249*calcularPorcentaje()));
		salidaRechazo.add(residuos);
	}

}
