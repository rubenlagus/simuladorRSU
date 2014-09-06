package org.simuladorRSU.simulacion;

public class SeparadorOpticoPEAD extends SeparadorOptico {
	
	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param velocidadCinta
	 * @param RSU
	 */
	public SeparadorOpticoPEAD(Linea lineaEntrada,
			Linea lineaSalidaSoplados, Linea lineaSalidaOtros,
			int velocidadCinta, Residuos RSU) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, velocidadCinta, RSU);
	}

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param velocidadCinta
	 */
	public SeparadorOpticoPEAD(Linea lineaEntrada,
			Linea lineaSalidaSoplados, Linea lineaSalidaOtros,
			int velocidadCinta) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, velocidadCinta);
	}

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 * @param RSU
	 */
	public SeparadorOpticoPEAD(Linea lineaEntrada,
			Linea lineaSalidaSoplados, Linea lineaSalidaOtros, Residuos RSU) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros, RSU);
	}

	/**
	 * @param lineaEntrada
	 * @param lineaSalidaSoplados
	 * @param lineaSalidaOtros
	 */
	public SeparadorOpticoPEAD(Linea lineaEntrada,
			Linea lineaSalidaSoplados, Linea lineaSalidaOtros) {
		super(lineaEntrada, lineaSalidaSoplados, lineaSalidaOtros);
	}

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}

	@Override
	public void salida() {
		Residuos residuos;
    	synchronized (RSU) {
    		residuos = RSU.disminuirPorcentaje(1.0);
    	}
		lineaSalidaSoplados.add(residuos.disminuirPorcentaje(0.274038*calcularPorcentaje()));
		lineaSalidaOtros.add(residuos);
	}
}
