package org.simuladorRSU.simulacion;

public class TriajeDeControlBricks extends TriajeDeControl {

    /**
     *
     */
    public TriajeDeControlBricks(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(lineaEntrada, salidaMaterial, salidaRechazo);
    }

    /**
     *
     */
    public TriajeDeControlBricks(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo);
    }

    /**
     *
     */
    public TriajeDeControlBricks(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
    }

    /**
     *
     */
    public TriajeDeControlBricks(Residuos RSU,Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, lineaEntrada, salidaMaterial, salidaRechazo, efectividad, velocidad, numTrabajadores);
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
