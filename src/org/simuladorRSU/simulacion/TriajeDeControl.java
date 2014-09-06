package org.simuladorRSU.simulacion;

public abstract class TriajeDeControl extends ModuloHumano {
	
	protected Linea lineaEntrada = null;
	protected Linea salidaRechazo = null;
	protected Salida salidaMaterial = null;

    /**
     *
     */
    public TriajeDeControl(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super();
        this.lineaEntrada = lineaEntrada;
        this.salidaMaterial = salidaMaterial;
        this.salidaRechazo = salidaRechazo;
    }

    /**
     *
     */
    public TriajeDeControl(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo) {
        super(RSU, 50, 50, 1);
        this.lineaEntrada = lineaEntrada;
        this.salidaMaterial = salidaMaterial;
        this.salidaRechazo = salidaRechazo;
    }

    /**
     *
     */
    public TriajeDeControl(Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(efectividad, velocidad, numTrabajadores);
        this.lineaEntrada = lineaEntrada;
        this.salidaMaterial = salidaMaterial;
        this.salidaRechazo = salidaRechazo;
    }

    /**
     *
     */
    public TriajeDeControl(Residuos RSU, Linea lineaEntrada, Salida salidaMaterial, Linea salidaRechazo, int efectividad, int velocidad, int numTrabajadores) {
        super(RSU, efectividad, velocidad, numTrabajadores);
        this.lineaEntrada = lineaEntrada;
        this.salidaMaterial = salidaMaterial;
        this.salidaRechazo = salidaRechazo;
    }

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
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

    public Linea getLineaEntrada() {
        return lineaEntrada;
    }

    public void setLineaEntrada(Linea lineaEntrada) {
        this.lineaEntrada = lineaEntrada;
    }

    public Linea getSalidaRechazo() {
        return salidaRechazo;
    }

    public void setSalidaRechazo(Linea salidaRechazo) {
        this.salidaRechazo = salidaRechazo;
    }

    public Salida getSalidaMaterial() {
        return salidaMaterial;
    }

    public void setSalidaMaterial(Salida salidaMaterial) {
        this.salidaMaterial = salidaMaterial;
    }

}
