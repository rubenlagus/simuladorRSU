package org.simuladorRSU.simulacion;

public abstract class TriajeDeControl extends ModuloHumano {
	
	protected Linea lineaEntrada = null;
	protected Linea salidaRechazo = null;
	protected Salida salidaMaterial = null;

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

}
