package org.simuladorRSU.simulacion;

public class TromelFinos extends Modulo {

	private Linea lineaEntrada;
    private Linea lineaSalidaHundidos;
    private Linea lineaSalidaRebose;
    private int diametro;
    private int angulo;
    private int velocidadGiro;
    private int longitud;
    private int diametroHuecos;
    
    
    
	public TromelFinos(Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametro = 2500;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitud = 10000;
	    diametroHuecos = 800;
	}
	
	public TromelFinos(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametro = 2500;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitud = 10000;
	    diametroHuecos = 800;
	}
	
	public TromelFinos(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose, int diametro, int angulo, int velocidadGiro, int longitud,
			int diametroHuecos) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametro = diametro;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitud = longitud;
		this.diametroHuecos = diametroHuecos;
	}
	
	public TromelFinos(Linea lineaEntrada, Linea lineaSalidaHundidos,
			Linea lineaSalidaRebose, int diametro, int angulo, int velocidadGiro, int longitud,
			int diametroHuecos) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidos = lineaSalidaHundidos;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametro = diametro;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitud = longitud;
		this.diametroHuecos = diametroHuecos;
	}

	public synchronized int getDiametroHuecos() {
		return diametroHuecos;
	}

	public synchronized void setDiametroHuecos(int diametroHuecos) {
		this.diametroHuecos = diametroHuecos;
	}

	public synchronized int getDiametro() {
		return diametro;
	}

	public synchronized int getAngulo() {
		return angulo;
	}

	public synchronized int getVelocidadGiro() {
		return velocidadGiro;
	}

	public synchronized int getLongitud() {
		return longitud;
	}

	public synchronized void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public synchronized void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public synchronized void setVelocidadGiro(int velocidadGiro) {
		this.velocidadGiro = velocidadGiro;
	}

	public synchronized void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	
	@Override
	public void salida() {
		Residuos residuos;
		synchronized (RSU) {
			 residuos = RSU.disminuirPorcentaje(1.0);
		}
		this.lineaSalidaHundidos.add(residuos.disminuirPorcentaje(0.444981*calcularPorcentaje()));
		this.lineaSalidaRebose.add(residuos.disminuirPorcentaje(1.0));
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

	@Override
	protected double calcularPorcentaje() {
		return 1.0;
	}

}
