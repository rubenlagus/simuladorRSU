package org.simuladorRSU.simulacion;

public class TriajeDeControlAluminio extends TriajeDeControl {
	/**
	 * 
	 */
	public TriajeDeControlAluminio(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(lineaEntrada, salidaMaterial, salidaRechazo);
	}
	
	/**
	 * 
	 */
	public TriajeDeControlAluminio(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo);
	}

    /**
     *
     */
    public TriajeDeControlAluminio(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }

    /**
     *
     */
    public TriajeDeControlAluminio(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
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
