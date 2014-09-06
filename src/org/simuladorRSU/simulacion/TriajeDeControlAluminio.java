package org.simuladorRSU.simulacion;

public class TriajeDeControlAluminio extends TriajeDeControl {

	
	
	/**
	 * 
	 */
	public TriajeDeControlAluminio(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	/**
	 * 
	 */
	public TriajeDeControlAluminio(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
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
		salidaMaterial.add(residuos.disminuirAluminioPorcentaje(0.295421*calcularPorcentaje()));
		salidaRechazo.add(residuos);
	}

}
