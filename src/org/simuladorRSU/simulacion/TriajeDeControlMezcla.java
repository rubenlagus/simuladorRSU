package org.simuladorRSU.simulacion;

public class TriajeDeControlMezcla extends TriajeDeControl {

	/**
	 * 
	 */
	public TriajeDeControlMezcla(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	/**
	 * 
	 */
	public TriajeDeControlMezcla(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
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
		salidaMaterial.add(residuos.disminuirPlaticosMezclaPorcenaje(0.874319*calcularPorcentaje()));
		salidaRechazo.add(residuos);
	}

}
