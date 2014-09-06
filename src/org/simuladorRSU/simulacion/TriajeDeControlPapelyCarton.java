package org.simuladorRSU.simulacion;

public class TriajeDeControlPapelyCarton extends TriajeDeControl {

    /**
     *
     */
    public TriajeDeControlPapelyCarton(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(lineaEntrada, salidaMaterial, salidaRechazo);
    }

    /**
     *
     */
    public TriajeDeControlPapelyCarton(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo);
    }

    /**
     *
     */
    public TriajeDeControlPapelyCarton(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }

    /**
     *
     */
    public TriajeDeControlPapelyCarton(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
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
