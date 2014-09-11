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
public class StaticComponents {

	private static StaticComponents instance = null;
	
    // Modulos
    private Foso foso = null;
    private TriajeManualPrimario triajePrimario = null;
    private TromelFinos tromelFinos = null;
    private TromelEnvases tromelEnvases = null;
    private SeparadorBalistico separadorBalistico = null;
    private SeparadorMagnetico1 separadorMagnetico1 = null;
    private SeparadorMagnetico2 separadorMagnetico2 = null;
    private CaptacionFilm captacionFilm = null;
    private TriajeManualPositivo1 triajeManualPositivo1 = null;
    private TriajeManualPositivo2 triajeManualPositivo2 = null;
    private SeparadorOpticoPlasticos separadorOpticoPlasticos = null;
    private SeparadorOpticoPEAD separadorOpticoPEAD = null;
    private SeparadorOpticoPET separadorOpticoPET = null;
    private SeparadorOpticoBRIK separadorOpticoBRIK = null;
    private SeparadorInductivo separadorInductivo = null;
    private Compostaje compostaje = null;
    private TriajeDeControlAluminio triajeDeControlAluminio = null;
    private TriajeDeControlBriks triajeDeControlBriks = null;
    private TriajeDeControlFilm triajeDeControlFilm = null;
    private TriajeDeControlMezcla triajeDeControlMezcla = null;
    private TriajeDeControlPapelyCarton triajeDeControlPapelyCarton = null;
    private TriajeDeControlPEAD triajeDeControlPEAD = null;
    private TriajeDeControlPET triajeDeControlPET = null;
    
    // Salidas
    private Salida salidaVidrio = null;
    private Salida salidaVoluminosos = null;
    private Salida salidaPapelCarton = null;
    private Salida salidaPEAD = null;
    private Salida salidaMetalicos = null;
    private Salida salidaOrganica = null;
    private Salida salidaFilm = null;
    private Salida salidaCompost = null;
    private Salida salidaBriks = null;
    private Salida salidaAluminio = null;
    private Salida salidaMezcla = null;
    private Salida salidaPET = null;
    private SalidaRechazo salidaRechazo = null;
    
    
    // Lineas
    private Linea linea1 = null;
    private Linea linea2 = null;
    private Linea linea3 = null;
    private Linea linea4 = null;
    private Linea linea5 = null;
    private Linea linea6 = null;
    private Linea linea7 = null;
    private Linea linea8 = null;
    private Linea linea9 = null;
    private Linea linea10 = null;
    private Linea linea11 = null;
    private Linea linea12 = null;
    private Linea linea13 = null;
    private Linea linea14 = null;
    private Linea linea15 = null;
    private Linea linea16 = null;
    private Linea linea17 = null;
    private Linea linea18 = null;
    private Linea linea19 = null;
    private Linea linea20 = null;
    private Linea linea21 = null;
    private Linea linea22 = null;
    private Linea linea23 = null;
    private Linea linea24 = null;
    private Linea linea25 = null;

    public static StaticComponents getInstance() {
    	if (instance == null)
    		instance = new StaticComponents();
    	return instance;
    }
    
    private StaticComponents() {
        linea1 = new Linea();
        linea2 = new Linea();
        linea3 = new Linea();
        linea4 = new Linea();
        linea5 = new Linea();
        linea6 = new Linea();
        linea7 = new Linea();
        linea8 = new Linea();
        linea9 = new Linea();
        linea10 = new Linea();
        linea11 = new Linea();
        linea12 = new Linea();
        linea13 = new Linea();
        linea14 = new Linea();
        linea15 = new Linea();
        linea16 = new Linea();
        linea17 = new Linea();
        linea18 = new Linea();
        linea19 = new Linea();
        linea20 = new Linea();
        linea21 = new Linea();
        linea22 = new Linea();
        linea23 = new Linea();
        linea24 = new Linea();
        linea25 = new Linea();
        
        salidaRechazo = new SalidaRechazo();
        
        salidaVidrio = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Vidrio interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Vidrio: " + this.totalMaterial);
            }
        };

        salidaVoluminosos = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Voluminosos interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Voluminosos: " + this.totalMaterial);
            }
        };

        salidaPapelCarton = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Papel y Carton interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Papel y Carton: " + this.totalMaterial);
            }
        };

        salidaPEAD = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida PEAD interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida PEAD: " + this.totalMaterial);
            }
        };

        salidaMetalicos = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Metalicos interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Metalicos: " + this.totalMaterial);
            }
        };

        salidaFilm = new Salida() {
            @Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Film interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Film: " + this.totalMaterial);
            }
        };
        
        salidaOrganica = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Organica interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Organica: " + this.totalMaterial);
            }
        };
        
        salidaBriks = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Bricks interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Bricks: " + this.totalMaterial);
            }
        };
        
        salidaCompost = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Compostt interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Compost: " + this.totalMaterial);
            }
        };
        
        salidaAluminio = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Aluminio interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Aluminio: " + this.totalMaterial);
            }
        };
        
        salidaMezcla = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida Mezcla interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida Mezcla: " + this.totalMaterial);
            }
        };
        
        salidaPET = new Salida() {
        	@Override
            public void DebugInfo(Boolean interrupted) {
                if (interrupted)
                    System.out.println("Salida PET interrumpida: " + this.totalMaterial);
                else
                    System.out.println("Salida PET: " + this.totalMaterial);
            }
        };
        
        foso = new Foso(linea1);
        triajePrimario = new TriajeManualPrimario(linea1,salidaVidrio, salidaVoluminosos, salidaPapelCarton, salidaMetalicos, linea2);
        tromelFinos = new TromelFinos(linea2, linea4, linea3);
        tromelEnvases = new TromelEnvases(linea3, linea7, linea6, linea5);
        triajeManualPositivo1 = new TriajeManualPositivo1(linea6, linea12, salidaPapelCarton, salidaFilm, salidaPEAD, salidaRechazo);
        triajeManualPositivo2 = new TriajeManualPositivo2(linea5, salidaPEAD, salidaPapelCarton, salidaFilm, linea9);
        separadorBalistico = new SeparadorBalistico(linea7, linea9, linea11, linea10, linea8);
        captacionFilm = new CaptacionFilm(linea11, linea13, linea12);
        separadorMagnetico1 = new SeparadorMagnetico1(linea4, linea8, salidaMetalicos, linea24);
        separadorMagnetico2 = new SeparadorMagnetico2(linea10, salidaMetalicos, linea14);
        compostaje = new Compostaje(linea24, salidaRechazo, salidaCompost);
        separadorOpticoPlasticos = new SeparadorOpticoPlasticos(linea14, linea15, linea16);
        separadorOpticoBRIK = new SeparadorOpticoBRIK(linea16, linea18, linea7);
        separadorOpticoPET = new SeparadorOpticoPET(linea15, linea21, linea20);
        separadorOpticoPEAD = new SeparadorOpticoPEAD(linea20, linea22, linea23);
        separadorInductivo = new SeparadorInductivo(linea17, linea19, linea23);
        triajeDeControlAluminio = new TriajeDeControlAluminio(linea19, salidaAluminio, salidaRechazo);
        triajeDeControlBriks = new TriajeDeControlBriks(linea18, salidaBriks, salidaRechazo);
        triajeDeControlFilm = new TriajeDeControlFilm(linea13, salidaFilm, linea25);
        triajeDeControlPapelyCarton = new TriajeDeControlPapelyCarton(linea25, salidaPapelCarton, salidaRechazo);
        triajeDeControlPEAD = new TriajeDeControlPEAD(linea22, salidaPEAD, salidaRechazo);
        triajeDeControlPET = new TriajeDeControlPET(linea21, salidaPET, salidaRechazo);
        triajeDeControlMezcla = new TriajeDeControlMezcla(linea23, salidaMezcla, salidaRechazo);
    }

	public Foso getFoso() {
		return foso;
	}

	public void setFoso(Foso foso) {
		this.foso = foso;
	}

	public TriajeManualPrimario getTriajePrimario() {
		return triajePrimario;
	}

	public void setTriajePrimario(TriajeManualPrimario triajePrimario) {
		this.triajePrimario = triajePrimario;
	}

	public TromelFinos getTromelFinos() {
		return tromelFinos;
	}

	public void setTromelFinos(TromelFinos tromelFinos) {
		this.tromelFinos = tromelFinos;
	}

	public TromelEnvases getTromelEnvases() {
		return tromelEnvases;
	}

	public void setTromelEnvases(TromelEnvases tromelEnvases) {
		this.tromelEnvases = tromelEnvases;
	}

	public SeparadorBalistico getSeparadorBalistico() {
		return separadorBalistico;
	}

	public void setSeparadorBalistico(SeparadorBalistico separadorBalistico) {
		this.separadorBalistico = separadorBalistico;
	}

	public SeparadorMagnetico1 getSeparadorMagnetico1() {
		return separadorMagnetico1;
	}

	public void setSeparadorMagnetico1(SeparadorMagnetico1 separadorMagnetico1) {
		this.separadorMagnetico1 = separadorMagnetico1;
	}

	public SeparadorMagnetico2 getSeparadorMagnetico2() {
		return separadorMagnetico2;
	}

	public void setSeparadorMagnetico2(SeparadorMagnetico2 separadorMagnetico2) {
		this.separadorMagnetico2 = separadorMagnetico2;
	}

	public CaptacionFilm getCaptacionFilm() {
		return captacionFilm;
	}

	public void setCaptacionFilm(CaptacionFilm captacionFilm) {
		this.captacionFilm = captacionFilm;
	}

	public TriajeManualPositivo1 getTriajeManualPositivo1() {
		return triajeManualPositivo1;
	}

	public void setTriajeManualPositivo1(TriajeManualPositivo1 triajeManualPositivo1) {
		this.triajeManualPositivo1 = triajeManualPositivo1;
	}

	public TriajeManualPositivo2 getTriajeManualPositivo2() {
		return triajeManualPositivo2;
	}

	public void setTriajeManualPositivo2(TriajeManualPositivo2 triajeManualPositivo2) {
		this.triajeManualPositivo2 = triajeManualPositivo2;
	}

	public SeparadorOpticoPlasticos getSeparadorOpticoPlasticos() {
		return separadorOpticoPlasticos;
	}

	public void setSeparadorOpticoPlasticos(
			SeparadorOpticoPlasticos separadorOpticoPlasticos) {
		this.separadorOpticoPlasticos = separadorOpticoPlasticos;
	}

	public SeparadorOpticoPEAD getSeparadorOpticoPEAD() {
		return separadorOpticoPEAD;
	}

	public void setSeparadorOpticoPEAD(SeparadorOpticoPEAD separadorOpticoPEAD) {
		this.separadorOpticoPEAD = separadorOpticoPEAD;
	}

	public SeparadorOpticoPET getSeparadorOpticoPET() {
		return separadorOpticoPET;
	}

	public void setSeparadorOpticoPET(SeparadorOpticoPET separadorOpticoPET) {
		this.separadorOpticoPET = separadorOpticoPET;
	}

	public SeparadorOpticoBRIK getSeparadorOpticoBRIK() {
		return separadorOpticoBRIK;
	}

	public void setSeparadorOpticoBRIK(SeparadorOpticoBRIK separadorOpticoBRIK) {
		this.separadorOpticoBRIK = separadorOpticoBRIK;
	}

	public SeparadorInductivo getSeparadorInductivo() {
		return separadorInductivo;
	}

	public void setSeparadorInductivo(SeparadorInductivo separadorInductivo) {
		this.separadorInductivo = separadorInductivo;
	}

	public Compostaje getCompostaje() {
		return compostaje;
	}

	public void setCompostaje(Compostaje compostaje) {
		this.compostaje = compostaje;
	}

	public TriajeDeControlBriks getTriajeDeControlBriks() {
		return triajeDeControlBriks;
	}

	public void setTriajeDeControlBriks(TriajeDeControlBriks triajeDeControlBriks) {
		this.triajeDeControlBriks = triajeDeControlBriks;
	}

	public TriajeDeControlFilm getTriajeDeControlFilm() {
		return triajeDeControlFilm;
	}

	public void setTriajeDeControlFilm(TriajeDeControlFilm triajeDeControlFilm) {
		this.triajeDeControlFilm = triajeDeControlFilm;
	}

	public TriajeDeControlMezcla getTriajeDeControlMezcla() {
		return triajeDeControlMezcla;
	}

	public void setTriajeDeControlMezcla(TriajeDeControlMezcla triajeDeControlMezcla) {
		this.triajeDeControlMezcla = triajeDeControlMezcla;
	}

	public TriajeDeControlPapelyCarton getTriajeDeControlPapelyCarton() {
		return triajeDeControlPapelyCarton;
	}

	public void setTriajeDeControlPapelyCarton(
			TriajeDeControlPapelyCarton triajeDeControlPapelyCarton) {
		this.triajeDeControlPapelyCarton = triajeDeControlPapelyCarton;
	}

	public TriajeDeControlPEAD getTriajeDeControlPEAD() {
		return triajeDeControlPEAD;
	}

	public void setTriajeDeControlPEAD(TriajeDeControlPEAD triajeDeControlPEAD) {
		this.triajeDeControlPEAD = triajeDeControlPEAD;
	}

	public TriajeDeControlPET getTriajeDeControlPET() {
		return triajeDeControlPET;
	}

	public void setTriajeDeControlPET(TriajeDeControlPET triajeDeControlPET) {
		this.triajeDeControlPET = triajeDeControlPET;
	}

	public TriajeDeControlAluminio getTriajeDeControlAluminio() {
		return triajeDeControlAluminio;
	}

	public void setTriajeDeControlAluminio(
			TriajeDeControlAluminio triajeDeControlAluminio) {
		this.triajeDeControlAluminio = triajeDeControlAluminio;
	}

	public Salida getSalidaVidrio() {
		return salidaVidrio;
	}

	public void setSalidaVidrio(Salida salidaVidrio) {
		this.salidaVidrio = salidaVidrio;
	}

	public Salida getSalidaVoluminosos() {
		return salidaVoluminosos;
	}

	public void setSalidaVoluminosos(Salida salidaVoluminosos) {
		this.salidaVoluminosos = salidaVoluminosos;
	}

	public Salida getSalidaPapelCarton() {
		return salidaPapelCarton;
	}

	public void setSalidaPapelCarton(Salida salidaPapelCarton) {
		this.salidaPapelCarton = salidaPapelCarton;
	}

	public Salida getSalidaPEAD() {
		return salidaPEAD;
	}

	public void setSalidaPEAD(Salida salidaPEAD) {
		this.salidaPEAD = salidaPEAD;
	}

	public Salida getSalidaMetalicos() {
		return salidaMetalicos;
	}

	public void setSalidaMetalicos(Salida salidaMetalicos) {
		this.salidaMetalicos = salidaMetalicos;
	}

	public Salida getSalidaOrganica() {
		return salidaOrganica;
	}

	public void setSalidaOrganica(Salida salidaOrganica) {
		this.salidaOrganica = salidaOrganica;
	}

	public Salida getSalidaFilm() {
		return salidaFilm;
	}

	public void setSalidaFilm(Salida salidaFilm) {
		this.salidaFilm = salidaFilm;
	}

	public Salida getSalidaCompost() {
		return salidaCompost;
	}

	public void setSalidaCompost(Salida salidaCompost) {
		this.salidaCompost = salidaCompost;
	}

	public Salida getSalidaBriks() {
		return salidaBriks;
	}

	public void setSalidaBriks(Salida salidaBriks) {
		this.salidaBriks = salidaBriks;
	}

	public Salida getSalidaAluminio() {
		return salidaAluminio;
	}

	public void setSalidaAluminio(Salida salidaAluminio) {
		this.salidaAluminio = salidaAluminio;
	}

	public Salida getSalidaMezcla() {
		return salidaMezcla;
	}

	public void setSalidaMezcla(Salida salidaMezcla) {
		this.salidaMezcla = salidaMezcla;
	}

	public Salida getSalidaPET() {
		return salidaPET;
	}

	public void setSalidaPET(Salida salidaPET) {
		this.salidaPET = salidaPET;
	}

	public Linea getLinea1() {
		return linea1;
	}

	public void setLinea1(Linea linea1) {
		this.linea1 = linea1;
	}

	public Linea getLinea2() {
		return linea2;
	}

	public void setLinea2(Linea linea2) {
		this.linea2 = linea2;
	}

	public Linea getLinea3() {
		return linea3;
	}

	public void setLinea3(Linea linea3) {
		this.linea3 = linea3;
	}

	public Linea getLinea4() {
		return linea4;
	}

	public void setLinea4(Linea linea4) {
		this.linea4 = linea4;
	}

	public Linea getLinea5() {
		return linea5;
	}

	public void setLinea5(Linea linea5) {
		this.linea5 = linea5;
	}

	public Linea getLinea6() {
		return linea6;
	}

	public void setLinea6(Linea linea6) {
		this.linea6 = linea6;
	}

	public Linea getLinea7() {
		return linea7;
	}

	public void setLinea7(Linea linea7) {
		this.linea7 = linea7;
	}

	public Linea getLinea8() {
		return linea8;
	}

	public void setLinea8(Linea linea8) {
		this.linea8 = linea8;
	}

	public Linea getLinea9() {
		return linea9;
	}

	public void setLinea9(Linea linea9) {
		this.linea9 = linea9;
	}

	public Linea getLinea10() {
		return linea10;
	}

	public void setLinea10(Linea linea10) {
		this.linea10 = linea10;
	}

	public Linea getLinea11() {
		return linea11;
	}

	public void setLinea11(Linea linea11) {
		this.linea11 = linea11;
	}

	public Linea getLinea12() {
		return linea12;
	}

	public void setLinea12(Linea linea12) {
		this.linea12 = linea12;
	}

	public Linea getLinea13() {
		return linea13;
	}

	public void setLinea13(Linea linea13) {
		this.linea13 = linea13;
	}

	public Linea getLinea14() {
		return linea14;
	}

	public void setLinea14(Linea linea14) {
		this.linea14 = linea14;
	}

	public Linea getLinea15() {
		return linea15;
	}

	public void setLinea15(Linea linea15) {
		this.linea15 = linea15;
	}

	public Linea getLinea16() {
		return linea16;
	}

	public void setLinea16(Linea linea16) {
		this.linea16 = linea16;
	}

	public Linea getLinea17() {
		return linea17;
	}

	public void setLinea17(Linea linea17) {
		this.linea17 = linea17;
	}

	public Linea getLinea18() {
		return linea18;
	}

	public void setLinea18(Linea linea18) {
		this.linea18 = linea18;
	}

	public Linea getLinea19() {
		return linea19;
	}

	public void setLinea19(Linea linea19) {
		this.linea19 = linea19;
	}

	public Linea getLinea20() {
		return linea20;
	}

	public void setLinea20(Linea linea20) {
		this.linea20 = linea20;
	}

	public Linea getLinea21() {
		return linea21;
	}

	public void setLinea21(Linea linea21) {
		this.linea21 = linea21;
	}

	public Linea getLinea22() {
		return linea22;
	}

	public void setLinea22(Linea linea22) {
		this.linea22 = linea22;
	}

	public Linea getLinea23() {
		return linea23;
	}

	public void setLinea23(Linea linea23) {
		this.linea23 = linea23;
	}

	public Linea getLinea24() {
		return linea24;
	}

	public void setLinea24(Linea linea24) {
		this.linea24 = linea24;
	}

	public Linea getLinea25() {
		return linea25;
	}

	public void setLinea25(Linea linea25) {
		this.linea25 = linea25;
	}

	public SalidaRechazo getSalidaRechazo() {
		return salidaRechazo;
	}

	public void setSalidaRechazo(SalidaRechazo salidaRechazo) {
		this.salidaRechazo = salidaRechazo;
	}

	public void startThreads() {
        salidaPapelCarton.start();
        salidaVidrio.start();
        salidaVoluminosos.start();
        salidaMetalicos.start();
        salidaPEAD.start();
        salidaOrganica.start();
        salidaFilm.start();
        salidaCompost.start();
        salidaBriks.start();
        salidaAluminio.start();
        salidaMezcla.start();
        salidaPET.start();
        salidaRechazo.start();
        
        foso.start();
        triajePrimario.start();
        tromelFinos.start();
        tromelEnvases.start();
        separadorBalistico.start();
        separadorMagnetico1.start();
        separadorMagnetico2.start();
        captacionFilm.start();
        triajeManualPositivo1.start();
        triajeManualPositivo2.start();
        compostaje.start();
        separadorOpticoPlasticos.start();
        separadorOpticoBRIK.start();
        separadorOpticoPET.start();
        separadorOpticoPEAD.start();
        separadorInductivo.start();
        triajeDeControlAluminio.start();
        triajeDeControlBriks.start();
        triajeDeControlFilm.start();
        triajeDeControlPapelyCarton.start();
        triajeDeControlPEAD.start();
        triajeDeControlPET.start();
        triajeDeControlMezcla.start();
    }

    public void stopThreads() {
        salidaPapelCarton.interrupt();
        salidaVidrio.interrupt();
        salidaVoluminosos.interrupt();
        salidaMetalicos.interrupt();
        salidaPEAD.interrupt();
        salidaOrganica.interrupt();
        salidaFilm.interrupt();
        salidaCompost.interrupt();
        salidaBriks.interrupt();
        salidaAluminio.interrupt();
        salidaMezcla.interrupt();
        salidaPET.interrupt();
        salidaRechazo.interrupt();
        
        foso.interrupt();
        triajePrimario.interrupt();
        tromelFinos.interrupt();
        tromelEnvases.interrupt();
        separadorBalistico.interrupt();
        captacionFilm.interrupt();
        triajeManualPositivo1.interrupt();
        triajeManualPositivo2.interrupt();
        separadorMagnetico1.interrupt();
        separadorMagnetico2.interrupt();
        compostaje.interrupt();
        separadorOpticoPlasticos.interrupt();
        separadorOpticoBRIK.interrupt();
        separadorOpticoPET.interrupt();
        separadorOpticoPEAD.interrupt();
        separadorInductivo.interrupt();
        triajeDeControlAluminio.interrupt();
        triajeDeControlBriks.interrupt();
        triajeDeControlFilm.interrupt();
        triajeDeControlPapelyCarton.interrupt();
        triajeDeControlPEAD.interrupt();
        triajeDeControlPET.interrupt();
        triajeDeControlMezcla.interrupt();

        instance = null;
    }

    public void suspendThreads() {
        salidaPapelCarton.suspend();
        salidaVidrio.suspend();
        salidaVoluminosos.suspend();
        salidaMetalicos.suspend();
        salidaPEAD.suspend();
        salidaOrganica.suspend();
        salidaFilm.suspend();
        salidaCompost.suspend();
        salidaBriks.suspend();
        salidaAluminio.suspend();
        salidaMezcla.suspend();
        salidaPET.suspend();
        salidaRechazo.suspend();

        foso.suspend();
        triajePrimario.suspend();
        tromelFinos.suspend();
        tromelEnvases.suspend();
        separadorBalistico.suspend();
        captacionFilm.suspend();
        triajeManualPositivo1.suspend();
        triajeManualPositivo2.suspend();
        separadorMagnetico1.suspend();
        separadorMagnetico2.suspend();
        compostaje.suspend();
        separadorOpticoPlasticos.suspend();
        separadorOpticoBRIK.suspend();
        separadorOpticoPET.suspend();
        separadorOpticoPEAD.suspend();
        separadorInductivo.suspend();
        triajeDeControlAluminio.suspend();
        triajeDeControlBriks.suspend();
        triajeDeControlFilm.suspend();
        triajeDeControlPapelyCarton.suspend();
        triajeDeControlPEAD.suspend();
        triajeDeControlPET.suspend();
        triajeDeControlMezcla.suspend();
    }

    public void resumeThreads() {
    	salidaPapelCarton.resume();
        salidaVidrio.resume();
        salidaVoluminosos.resume();
        salidaMetalicos.resume();
        salidaPEAD.resume();
        salidaOrganica.resume();
        salidaFilm.resume();
        salidaCompost.resume();
        salidaBriks.resume();
        salidaAluminio.resume();
        salidaMezcla.resume();
        salidaPET.resume();
        salidaRechazo.resume();

        foso.resume();
        triajePrimario.resume();
        tromelFinos.resume();
        tromelEnvases.resume();
        separadorBalistico.resume();
        captacionFilm.resume();
        triajeManualPositivo1.resume();
        triajeManualPositivo2.resume();
        separadorMagnetico1.resume();
        separadorMagnetico2.resume();
        compostaje.resume();
        separadorOpticoPlasticos.resume();
        separadorOpticoBRIK.resume();
        separadorOpticoPET.resume();
        separadorOpticoPEAD.resume();
        separadorInductivo.resume();
        triajeDeControlAluminio.resume();
        triajeDeControlBriks.resume();
        triajeDeControlFilm.resume();
        triajeDeControlPapelyCarton.resume();
        triajeDeControlPEAD.resume();
        triajeDeControlPET.resume();
        triajeDeControlMezcla.resume();
        
        
        salidaPapelCarton.notifyThread();
        salidaVidrio.notifyThread();
        salidaVoluminosos.notifyThread();
        salidaMetalicos.notifyThread();
        salidaPEAD.notifyThread();
        salidaOrganica.notifyThread();
        salidaFilm.notifyThread();
        salidaCompost.notifyThread();
        salidaBriks.notifyThread();
        salidaAluminio.notifyThread();
        salidaMezcla.notifyThread();
        salidaPET.notifyThread();
        salidaRechazo.notifyThread();

        foso.notifyThread();
        triajePrimario.notifyThread();
        tromelFinos.notifyThread();
        tromelEnvases.notifyThread();
        separadorBalistico.notifyThread();
        captacionFilm.notifyThread();
        triajeManualPositivo1.notifyThread();
        triajeManualPositivo2.notifyThread();
        separadorMagnetico1.notifyThread();
        separadorMagnetico2.notifyThread();
        compostaje.notifyThread();
        separadorOpticoPlasticos.notifyThread();
        separadorOpticoBRIK.notifyThread();
        separadorOpticoPET.notifyThread();
        separadorOpticoPEAD.notifyThread();
        separadorInductivo.notifyThread();
        triajeDeControlAluminio.notifyThread();
        triajeDeControlBriks.notifyThread();
        triajeDeControlFilm.notifyThread();
        triajeDeControlPapelyCarton.notifyThread();
        triajeDeControlPEAD.notifyThread();
        triajeDeControlPET.notifyThread();
        triajeDeControlMezcla.notifyThread();
    }
    
    public void addFoso(Residuos residuos) {
        foso.entrada(residuos);
    }
}
