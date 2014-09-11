/**
 *   Copyright 2014 Ruben Bermudez
 *
 *   This file is part of SimulacionRSU.
 *
 *   SimulacionRSU is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   SimulacionRSU is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SimulacionRSU.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.simuladorRSU.simulacion;

/**
 * @author Ruben Bermudez
 */
public class Residuos {

	private double voluminososMetalicos;
	private double voluminososNoMetalicos;
	// FIN VOLUMINOSOS
    private double PET;
    private double PEAD;
    private double PVC;
    private double bolsas;
    private double platicosMezcla;
    private double latasAcero;
    private double latasAluminio;
    private double briks;
    // FIN ENVASES
    private double madera;
    private double papelyCarton;
    private double film;
    private double plasticosNoEnvases;
    private double aluminioNoEnvases;
    private double chatarraNoEnvase;
    // FIN RECUPERABLES
    private double materiaOrganica;
    private double jardinyPoda;
    private double finos;
    private double celulosas;
    private double ropa;
    private double zapatos;
    private double maderaNoEnvase;
    private double vidrio;
    private double RAEES;
    private double escombros;
    private double otros;
    // TOTAL

    public Residuos() {
    	voluminososMetalicos = 0;
    	voluminososNoMetalicos = 0; 
        PET = 0;
        PEAD = 0;
        PVC = 0;
        bolsas = 0;
        platicosMezcla = 0;
        latasAcero = 0;
        latasAluminio = 0;
        briks = 0;
        madera = 0;
        papelyCarton = 0;
        film = 0;
        plasticosNoEnvases = 0;
        aluminioNoEnvases = 0;
        chatarraNoEnvase = 0;
        materiaOrganica = 0;
        jardinyPoda = 0;
        finos = 0;
        celulosas = 0;
        ropa = 0;
        zapatos = 0;
        maderaNoEnvase = 0;
        vidrio = 0;
        RAEES = 0;
        escombros = 0;
        otros = 0;
    }

    public Residuos(double cantidad) {
    	voluminososMetalicos = cantidad*0.0083;
    	voluminososNoMetalicos = cantidad*0.0083;
        PET = cantidad*0.0142;
        PEAD = cantidad*0.0097;
        PVC = cantidad*0.0;
        bolsas = cantidad*0.0463;
        platicosMezcla = cantidad*0.0252;
        latasAcero = cantidad*0.0199;
        latasAluminio = cantidad*0.0026;
        briks = cantidad*0.0131;
        madera = cantidad*0.0070;
        papelyCarton = cantidad*0.1417;
        film = cantidad*0.0233;
        plasticosNoEnvases = cantidad*0.0082;
        aluminioNoEnvases = cantidad*0.0033;
        chatarraNoEnvase = cantidad*0.0078;
        materiaOrganica = cantidad*0.3861;
        jardinyPoda = cantidad*0.0205;
        finos = cantidad*0.0880;
        celulosas = cantidad*0.0709;
        ropa = cantidad*0.0226;
        zapatos = cantidad*0.0033;
        maderaNoEnvase = cantidad*0.0107;
        vidrio = cantidad*0.0410;
        RAEES = cantidad*0.0004;
        escombros = cantidad*0.0157;
        otros = cantidad*0.0019;
    }

    public Residuos(Residuos copia) {
    	voluminososMetalicos = copia.getVoluminososMetalicos();
    	voluminososNoMetalicos = copia.getVoluminososNoMetalicos();
        PET = copia.getPET();
        PEAD = copia.getPEAD();
        PVC = copia.getPVC();
        bolsas = copia.getBolsas();
        platicosMezcla = copia.getPlaticosMezcla();
        latasAcero = copia.getLatasAcero();
        latasAluminio = copia.getLatasAluminio();
        briks = copia.getBriks();
        madera = copia.getMadera();
        papelyCarton = copia.getPapelyCarton();
        film = copia.getFilm();
        plasticosNoEnvases = copia.getPlasticosNoEnvases();
        aluminioNoEnvases = copia.getAluminioNoEnvases();
        chatarraNoEnvase = copia.getChatarraNoEnvase();
        materiaOrganica = copia.getMateriaOrganica();
        jardinyPoda = copia.getJardinyPoda();
        finos = copia.getFinos();
        celulosas = copia.getCelulosas();
        ropa = copia.getRopa();
        zapatos = copia.getZapatos();
        maderaNoEnvase = copia.getMaderaNoEnvase();
        vidrio = copia.getVidrio();
        RAEES = copia.getRAEES();
        escombros = copia.getEscombros();
        otros = copia.getOtros();
    }

    public double disminuirVoluminososCompleto() {
    	double aux = this.voluminososNoMetalicos;
    	this.voluminososNoMetalicos = 0.0;
    	return aux;
	}
    
    public double disminuirVoluminososMetalicosCompleto() {
    	double aux = this.voluminososMetalicos;
    	this.voluminososMetalicos = 0.0;
    	return aux;
	}
    
    public double disminuirMaderaPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.madera;
        this.madera *= porcentaje;
        return aux-this.madera;
    }

    public double disminuirFilmPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.film;
        this.film *= porcentaje;
        return aux-this.film;
    }

    public double disminuirPlasticosNoEnvasesPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.plasticosNoEnvases;
        this.plasticosNoEnvases *= porcentaje;
        return aux-this.plasticosNoEnvases;
    }

    public double disminuirAluminioNoEnvasesPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.aluminioNoEnvases;
        this.aluminioNoEnvases *= porcentaje;
        return aux-this.aluminioNoEnvases;
    }

    public double disminuirChatarraNoEnvasePorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.chatarraNoEnvase;
        this.chatarraNoEnvase *= porcentaje;
        return aux-this.chatarraNoEnvase;
    }

    public double disminuirMateriaOrganicaPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.materiaOrganica;
        this.materiaOrganica *= porcentaje;
        return aux-this.materiaOrganica;
    }

    public double disminuirJardinyPodaPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.jardinyPoda;
        this.jardinyPoda *= porcentaje;
        return aux-this.jardinyPoda;
    }

    public double disminuirCelulosasPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.celulosas;
        this.celulosas *= porcentaje;
        return aux-this.celulosas;
    }

    public double disminuirRopaPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.ropa;
        this.ropa *= porcentaje;
        return aux-this.ropa;
    }

    public double disminuirZapatosPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.zapatos;
        this.zapatos *= porcentaje;
        return aux-this.zapatos;
    }

    public double disminuirMaderaNoEnvasePorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.maderaNoEnvase;
        this.maderaNoEnvase *= porcentaje;
        return aux-this.maderaNoEnvase;
    }

    public double disminuirRAEESPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.RAEES;
        this.RAEES *= porcentaje;
        return aux-this.RAEES;
    }

    public double disminuirEscombrosPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.escombros;
        this.escombros *= porcentaje;
        return aux-this.escombros;
    }

    public double disminuirPETPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.PET;
        this.PET *= porcentaje;
        return aux-this.PET;
    }

    public double disminuirPEADPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.PEAD;
        this.PEAD *= porcentaje;
        return aux-this.PEAD;
    }

    public double disminuirPVCPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.PVC;
        this.PVC *= porcentaje;
        return aux-this.PVC;
    }

    public double disminuirBolsasPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.bolsas;
        this.bolsas *= porcentaje;
        return aux-this.bolsas;
    }

    public double disminuirPlaticosMezclaPorcenaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.platicosMezcla;
        this.platicosMezcla *= porcentaje;
        return aux-this.platicosMezcla;
    }

    public double disminuirAceroPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.latasAcero;
        this.latasAcero *= porcentaje;
        return aux-this.latasAcero;
    }

    public double disminuirLatasAluminioPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.latasAluminio;
        this.latasAluminio *= porcentaje;
        return aux-this.latasAluminio;
    }

    public double disminuirBricksPorcenaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.briks;
        this.briks *= porcentaje;
        return aux-this.briks;
    }

    public double disminuirPapelyCartonPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.papelyCarton;
        this.papelyCarton *= porcentaje;
        return aux-this.papelyCarton;
    }

    public double disminuirFinosPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.finos;
        this.finos *= porcentaje;
        return aux-this.finos;
    }

    public double disminuirVidrioPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.vidrio;
        this.vidrio *= porcentaje;
        return aux-this.vidrio;
    }

    public double disminuirOtrosPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        double aux = this.otros;
        this.otros *= porcentaje;
        return aux-this.otros;
    }
    
    public double disminuirAluminioPorcentaje(double porcentaje) {
		double resultado = 0.0;
		resultado += disminuirLatasAluminioPorcentaje(porcentaje);
		resultado += disminuirAluminioNoEnvasesPorcentaje(porcentaje);
		return resultado;
	}

    public void suma(Residuos newResiduos)  {
    	voluminososMetalicos += newResiduos.getVoluminososMetalicos();
    	voluminososNoMetalicos += newResiduos.getVoluminososNoMetalicos();
        PET += newResiduos.getPET();
        PEAD += newResiduos.getPEAD();
        PVC += newResiduos.getPVC();
        bolsas += newResiduos.getBolsas();
        platicosMezcla += newResiduos.getPlaticosMezcla();
        latasAcero += newResiduos.getLatasAcero();
        latasAluminio += newResiduos.getLatasAluminio();
        briks += newResiduos.getBriks();
        madera += newResiduos.getMadera();
        papelyCarton += newResiduos.getPapelyCarton();
        film += newResiduos.getFilm();
        plasticosNoEnvases += newResiduos.getPlasticosNoEnvases();
        aluminioNoEnvases += newResiduos.getAluminioNoEnvases();
        chatarraNoEnvase += newResiduos.getChatarraNoEnvase();
        materiaOrganica += newResiduos.getMateriaOrganica();
        jardinyPoda += newResiduos.getJardinyPoda();
        finos += newResiduos.getFinos();
        celulosas += newResiduos.getCelulosas();
        ropa += newResiduos.getRopa();
        zapatos += newResiduos.getZapatos();
        maderaNoEnvase += newResiduos.getMaderaNoEnvase();
        vidrio += newResiduos.getVidrio();
        RAEES += newResiduos.getRAEES();
        escombros += newResiduos.getEscombros();
        otros += newResiduos.getOtros();
    }

    public void resta(Residuos newResiduos)  {
    	voluminososMetalicos -= newResiduos.getVoluminososMetalicos();
    	voluminososNoMetalicos -= newResiduos.getVoluminososNoMetalicos();
    	PET -= newResiduos.getPET();
        PEAD -= newResiduos.getPEAD();
        PVC -= newResiduos.getPVC();
        bolsas -= newResiduos.getBolsas();
        platicosMezcla -= newResiduos.getPlaticosMezcla();
        latasAcero -= newResiduos.getLatasAcero();
        latasAluminio -= newResiduos.getLatasAluminio();
        briks -= newResiduos.getBriks();
        madera -= newResiduos.getMadera();
        papelyCarton -= newResiduos.getPapelyCarton();
        film -= newResiduos.getFilm();
        plasticosNoEnvases -= newResiduos.getPlasticosNoEnvases();
        aluminioNoEnvases -= newResiduos.getAluminioNoEnvases();
        chatarraNoEnvase -= newResiduos.getChatarraNoEnvase();
        materiaOrganica -= newResiduos.getMateriaOrganica();
        jardinyPoda -= newResiduos.getJardinyPoda();
        finos -= newResiduos.getFinos();
        celulosas -= newResiduos.getCelulosas();
        ropa -= newResiduos.getRopa();
        zapatos -= newResiduos.getZapatos();
        maderaNoEnvase -= newResiduos.getMaderaNoEnvase();
        vidrio -= newResiduos.getVidrio();
        RAEES -= newResiduos.getRAEES();
        escombros -= newResiduos.getEscombros();
        otros -= newResiduos.getOtros();
    }

    public Residuos disminuirPorcentaje(double porcentaje) {
        porcentaje = 1-porcentaje;
        Residuos diferencia = new Residuos(this);
        voluminososMetalicos *= porcentaje;
    	voluminososNoMetalicos *= porcentaje;
        PET *= porcentaje;
        PEAD *= porcentaje;
        PVC *= porcentaje;
        bolsas *= porcentaje;
        platicosMezcla *= porcentaje;
        latasAcero *= porcentaje;
        latasAluminio *= porcentaje;
        briks *= porcentaje;
        madera *= porcentaje;
        papelyCarton *= porcentaje;
        film *= porcentaje;
        plasticosNoEnvases *= porcentaje;
        aluminioNoEnvases *= porcentaje;
        chatarraNoEnvase *= porcentaje;
        materiaOrganica *= porcentaje;
        jardinyPoda *= porcentaje;
        finos *= porcentaje;
        celulosas *= porcentaje;
        ropa *= porcentaje;
        zapatos *= porcentaje;
        maderaNoEnvase *= porcentaje;
        vidrio *= porcentaje;
        RAEES *= porcentaje;
        escombros *= porcentaje;
        otros *= porcentaje;
        diferencia.resta(this);
        return diferencia;
    }
    
    public double obtenerTotalMasa() {
    	double masaTotal = 0.0;
    	
    	masaTotal += voluminososMetalicos;
    	masaTotal += voluminososNoMetalicos;
    	masaTotal += PET;
    	masaTotal += PEAD;
    	masaTotal += PVC;
    	masaTotal += bolsas;
    	masaTotal += platicosMezcla;
    	masaTotal += latasAcero;
    	masaTotal += latasAluminio;
    	masaTotal += briks;
    	masaTotal += madera;
    	masaTotal += papelyCarton;
    	masaTotal += film;
    	masaTotal += plasticosNoEnvases;
    	masaTotal += aluminioNoEnvases;
    	masaTotal += chatarraNoEnvase;
    	masaTotal += materiaOrganica;
    	masaTotal += jardinyPoda;
    	masaTotal += finos;
    	masaTotal += celulosas;
    	masaTotal += ropa;
    	masaTotal += zapatos;
    	masaTotal += maderaNoEnvase;
    	masaTotal += vidrio;
    	masaTotal += RAEES;
    	masaTotal += escombros;
    	masaTotal += otros;
    	
    	return masaTotal;
    }
    
    public double generarCompost(double porcentaje, double porcentajePerdido) {
		Residuos resultado = disminuirPorcentaje((1-porcentajePerdido)*porcentaje);

        double masaTotal = 0.0;
        masaTotal += resultado.getMadera();
        masaTotal += resultado.getPapelyCarton();
        masaTotal += resultado.getMateriaOrganica();
        masaTotal += resultado.getJardinyPoda();
        masaTotal += resultado.getMaderaNoEnvase();

        return masaTotal;
	}

    public Residuos getResiduosHundidosTromelFinos(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosHundidosPequeniosTromelEnvases(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosHundidosGrandesTromelEnvases(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosFinosSeparadorBalistico(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosRodantesSeparadorBalistico(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosCaptadosSeparacionFilm(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosSeparadosSeparadorOpticoBrick(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosSeparadosSeparadorOpticoPEAD(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosSeparadosSeparadorOpticoPET(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosSeparadosSeparadorOpticoPlasticos(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public Residuos getResiduosSeparadosSeparadorInductivo(double porcentaje) {
        return disminuirPorcentaje(porcentaje);
    }

    public double getMadera() {
        return madera;
    }

    public void setMadera(double madera) {
        this.madera = madera;
    }

    public double getFilm() {
        return film;
    }

    public void setFilm(double film) {
        this.film = film;
    }

    public double getPlasticosNoEnvases() {
        return plasticosNoEnvases;
    }

    public void setPlasticosNoEnvases(double plasticosNoEnvases) {
        this.plasticosNoEnvases = plasticosNoEnvases;
    }

    public double getAluminioNoEnvases() {
        return aluminioNoEnvases;
    }

    public void setAluminioNoEnvases(double aluminioNoEnvases) {
        this.aluminioNoEnvases = aluminioNoEnvases;
    }

    public double getChatarraNoEnvase() {
        return chatarraNoEnvase;
    }

    public void setChatarraNoEnvase(double chatarraNoEnvase) {
        this.chatarraNoEnvase = chatarraNoEnvase;
    }

    public double getMateriaOrganica() {
        return materiaOrganica;
    }

    public void setMateriaOrganica(double materiaOrganica) {
        this.materiaOrganica = materiaOrganica;
    }

    public double getJardinyPoda() {
        return jardinyPoda;
    }

    public void setJardinyPoda(double jardinyPoda) {
        this.jardinyPoda = jardinyPoda;
    }

    public double getCelulosas() {
        return celulosas;
    }

    public void setCelulosas(double celulosas) {
        this.celulosas = celulosas;
    }

    public double getRopa() {
        return ropa;
    }

    public void setRopa(double ropa) {
        this.ropa = ropa;
    }

    public double getZapatos() {
        return zapatos;
    }

    public void setZapatos(double zapatos) {
        this.zapatos = zapatos;
    }

    public double getMaderaNoEnvase() {
        return maderaNoEnvase;
    }

    public void setMaderaNoEnvase(double maderaNoEnvase) {
        this.maderaNoEnvase = maderaNoEnvase;
    }

    public double getRAEES() {
        return RAEES;
    }

    public void setRAEES(double RAEES) {
        this.RAEES = RAEES;
    }

    public double getEscombros() {
        return escombros;
    }

    public void setEscombros(double escombros) {
        this.escombros = escombros;
    }

    public double getPET() {
        return PET;
    }

    public void setPET(double PET) {
        this.PET = PET;
    }

    public double getPEAD() {
        return PEAD;
    }

    public void setPEAD(double PEAD) {
        this.PEAD = PEAD;
    }

    public double getPVC() {
        return PVC;
    }

    public void setPVC(double PVC) {
        this.PVC = PVC;
    }

    public double getBolsas() {
        return bolsas;
    }

    public void setBolsas(double bolsas) {
        this.bolsas = bolsas;
    }

    public double getPlaticosMezcla() {
        return platicosMezcla;
    }

    public void setPlaticosMezcla(double platicosMezcla) {
        this.platicosMezcla = platicosMezcla;
    }

    public double getLatasAcero() {
        return latasAcero;
    }

    public void setLatasAcero(double latasAcero) {
        this.latasAcero = latasAcero;
    }

    public double getLatasAluminio() {
        return latasAluminio;
    }

    public void setLatasAluminio(double latasAluminio) {
        this.latasAluminio = latasAluminio;
    }

    public double getBriks() {
        return briks;
    }

    public void setBriks(double briks) {
        this.briks = briks;
    }

    public double getPapelyCarton() {
        return papelyCarton;
    }

    public void setPapelyCarton(double papelyCarton) {
        this.papelyCarton = papelyCarton;
    }

    public double getFinos() {
        return finos;
    }

    public void setFinos(double finos) {
        this.finos = finos;
    }

    public double getVidrio() {
        return vidrio;
    }

    public void setVidrio(double vidrio) {
        this.vidrio = vidrio;
    }

    public double getOtros() {
        return otros;
    }

    public void setOtros(double otros) {
        this.otros = otros;
    }
    
    public double getVoluminososMetalicos() {
		return voluminososMetalicos;
	}

	public void setVoluminososMetalicos(double voluminososMetalicos) {
		this.voluminososMetalicos = voluminososMetalicos;
	}

	public double getVoluminososNoMetalicos() {
		return voluminososNoMetalicos;
	}

	public void setVoluminososNoMetalicos(double voluminososNoMetalicos) {
		this.voluminososNoMetalicos = voluminososNoMetalicos;
	}
}
