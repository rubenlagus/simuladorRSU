package org.simuladorRSU.simulacion;

public class TriajeDeControlPET extends TriajeDeControl {

	/**
	 * 
	 */
	public TriajeDeControlPET(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(lineaEntrada, salidaMaterial, salidaRechazo);
	}

    /**
     *
     */
    public TriajeDeControlPET(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo);
    }

    /**
     *
     */
    public TriajeDeControlPET(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }

    /**
     *
     */
    public TriajeDeControlPET(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
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
