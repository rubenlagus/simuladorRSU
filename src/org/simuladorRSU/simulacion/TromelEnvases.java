package org.simuladorRSU.simulacion;

public class TromelEnvases extends Modulo {

	private Linea lineaEntrada;
    private Linea lineaSalidaHundidosPequenios;
    private Linea lineaSalidaHundidosGrandes;
    private Linea lineaSalidaRebose;
    private int diametroPequenios;
    private int diametroGrandes;
    private int angulo;
    private int velocidadGiro;
    private int longitudPequenios;
    private int longitudGrandes;
    private int diametro;
    
	public TromelEnvases(Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametroPequenios = 200;
		diametroGrandes = 350;
	    angulo = 3;
	    velocidadGiro = 13;
	    longitudPequenios = 3000;
	    longitudGrandes = 3000;
	    diametro = 2500;
	}
	
	public TromelEnvases(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		diametroPequenios = 200;
		diametroGrandes = 350;
	    angulo = 3;
	    velocidadGiro = 13;  // revoluciones por segundo
	    longitudPequenios = 3000;
	    longitudGrandes = 3000;
	    diametro = 2500;
	}
	
	public TromelEnvases(Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes, int diametroPequenios,
			int diametroGrandes, int angulo, int velocidadGiro, int diametro, 
			int longitudPequenios, int longitudGrandes) {
		super();
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametroPequenios = diametroPequenios;
		this.diametroGrandes = diametroGrandes;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitudPequenios = longitudPequenios;
		this.longitudGrandes = longitudGrandes;
		this.diametro = diametro;
	}
	
	public TromelEnvases(Residuos RSU, Linea lineaEntrada, Linea lineaSalidaHundidosPequenios,
			Linea lineaSalidaRebose, Linea lineaSalidaHundidosGrandes, int diametroPequenios,
			int diametroGrandes, int angulo, int velocidadGiro, int diametro, 
			int longitudPequenios, int longitudGrandes) {
		super(RSU);
		this.lineaEntrada = lineaEntrada;
		this.lineaSalidaHundidosPequenios = lineaSalidaHundidosPequenios;
		this.lineaSalidaHundidosGrandes = lineaSalidaHundidosGrandes;
		this.lineaSalidaRebose = lineaSalidaRebose;
		this.diametroPequenios = diametroPequenios;
		this.diametroGrandes = diametroGrandes;
		this.angulo = angulo;
		this.velocidadGiro = velocidadGiro;
		this.longitudPequenios = longitudPequenios;
		this.longitudGrandes = longitudGrandes;
		this.diametro = diametro;
	}

	public synchronized int getDiametro() {
		return diametro;
	}

	public synchronized void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public synchronized int getLongitudGrandes() {
		return longitudGrandes;
	}

	public synchronized void setLongitudGrandes(int longitudGrandes) {
		this.longitudGrandes = longitudGrandes;
	}

	public synchronized int getDiametroPequenios() {
		return diametroPequenios;
	}

	public synchronized void setDiametroPequenios(int diametroPequenios) {
		this.diametroPequenios = diametroPequenios;
	}

	public synchronized int getDiametroGrandes() {
		return diametroGrandes;
	}

	public synchronized int getAngulo() {
		return angulo;
	}

	public synchronized int getVelocidadGiro() {
		return velocidadGiro;
	}

	public synchronized int getLongitud200() {
		return longitudPequenios;
	}

	public synchronized void setDiametroGrandes(int diametroGrandes) {
		this.diametroGrandes = diametroGrandes;
	}

	public synchronized void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public synchronized void setVelocidadGiro(int velocidadGiro) {
		this.velocidadGiro = velocidadGiro;
	}

	public synchronized void setLongitudPequenios(int longitudPequenios) {
		this.longitudPequenios = longitudPequenios;
	}
	
	@Override
	public void salida() { // TODO salidas Criba 200-350
		Residuos residuos;
		synchronized (RSU) {
			 residuos = RSU.disminuirPorcentaje(1.0);
		}
		this.lineaSalidaHundidosPequenios.add(residuos.disminuirPorcentaje(0.556350*calcularPorcentaje()));
		this.lineaSalidaHundidosGrandes.add(residuos.disminuirPorcentaje(0.268593*calcularPorcentaje()));
		this.lineaSalidaRebose.add(residuos);		
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
