package org.simuladorRSU.simulacion;

public class TriajeDeControlBricks extends TriajeDeControl {

	/**
	 * 
	 */
	public TriajeDeControlBricks(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
		this.lineaEntrada = lineaEntrada;
		this.salidaMaterial = salidaMaterial;
		this.salidaRechazo = salidaRechazo;
	}
	
	/**
	 * 
	 */
	public TriajeDeControlBricks(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
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
		salidaMaterial.add(residuos.disminuirBricksPorcenaje(0.917643*calcularPorcentaje()));
		salidaRechazo.add(residuos);
	}

}
