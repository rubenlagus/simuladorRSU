package org.simuladorRSU.simulacion;


public class CaptacionFilm extends Modulo {

	private Linea lineaEntrada = null;
	private Linea lineaSalidaFilm = null;
	private Linea lineaSalidaOtros = null;
	
	public CaptacionFilm(Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFilm = lineaSalidaFilm;
		this.lineaSalidaOtros = lineaSalidaOtros;
	}

	public CaptacionFilm(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaFilm, Linea lineaSalidaOtros) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaFilm = lineaSalidaFilm;
		this.lineaSalidaOtros = lineaSalidaOtros;
	}

	protected double calcularPorcentaje() {
		return 1.0;
	}
	
	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		lineaSalidaFilm.add(residuos.disminuirPorcentaje(0.776588*calcularPorcentaje()));
		lineaSalidaOtros.add(residuos);
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
