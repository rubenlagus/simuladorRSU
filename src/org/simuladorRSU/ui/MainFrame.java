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
package org.simuladorRSU.ui;

import org.simuladorRSU.simulacion.MasterThread;
import org.simuladorRSU.simulacion.StaticComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ruben Bermudez
 */
public class MainFrame extends JFrame {

    private static final DecimalFormat df = new DecimalFormat("0.0000");
    private JButton selected = null;

    private class Line {
        public int x0, y0, x1, y1;

        public Line(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.x1 = x1;
            this.y0 = y0;
            this.y1 = y1;
        }

        public Line2D getLine() {
            return new Line2D.Float(x0, y0, x1, y1);
        }
    }

    public static ArrayList<Line> lines = new ArrayList<Line>();

    public MainFrame() {
        createLines();
        initComponents();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                refreshResources();
            }
        }, 1000, 1000);
        enableModules(false);
    }

    private void refreshResources() {
        labelAluminio.setText("Aluminio: " + df.format(StaticComponents.getInstance().getSalidaAluminio().getTotal()));
        labelBrick.setText("Bricks: " + df.format(StaticComponents.getInstance().getSalidaBriks().getTotal()));
        labelCompost.setText("Compost: " + df.format(StaticComponents.getInstance().getSalidaCompost().getTotal()));
        labelFe.setText("Férricos: " + df.format(StaticComponents.getInstance().getSalidaMetalicos().getTotal()));
        labelFilm.setText("Film: " + df.format(StaticComponents.getInstance().getSalidaFilm().getTotal()));
        labelMezcla.setText("Plasticos Mezcla: " + df.format(StaticComponents.getInstance().getSalidaMezcla().getTotal()));
        labelPC.setText("Papel y Cartón: " + df.format(StaticComponents.getInstance().getSalidaPapelCarton().getTotal()));
        labelPEAD.setText("PEAD: " + df.format(StaticComponents.getInstance().getSalidaPEAD().getTotal()));
        labelPET.setText("PET: " + df.format(StaticComponents.getInstance().getSalidaPET().getTotal()));
        labelVidrio.setText("Vidrio: " + df.format(StaticComponents.getInstance().getSalidaVidrio().getTotal()));
        bottomPanel.repaint();
    }

    public boolean isPaused() {
        return reanudarButton.isEnabled();
    }

    private void createLines() {
        lines.add(new Line(220, 65, 280, 65)); // TM Primario - Tromel F.
        lines.add(new Line(368, 65, 498, 65)); // Tromel F - Tromel E.
        lines.add(new Line(590, 60, 918, 60)); // Tromel E - TM Positivo1
        lines.add(new Line(319, 80, 319, 135)); // Tromel F - Sep. Mag1
        lines.add(new Line(319, 135, 220, 135)); // Tromel F - Sep. Mag1
        lines.add(new Line(220, 145, 319, 145)); // Sep. Balistico - Sep. Mag1
        lines.add(new Line(319, 145, 319, 225)); // Sep. Balistico - Sep. Mag1
        lines.add(new Line(319, 225, 488, 225)); // Sep. Balistico - Sep. Mag1
        lines.add(new Line(150, 155, 150, 220)); // Sep. Mag1 - Compostaje
        lines.add(new Line(475, 75, 475, 215)); // Trimel E. - Sep. Balistico
        lines.add(new Line(550, 75, 550, 130)); // Trimel E. - TM Positivo2
        lines.add(new Line(600, 150, 600, 215)); // TM Positivo2 - Sep. Balistico
        lines.add(new Line(630, 225, 720, 225)); // Sep. Balistico - Sep. Film
        lines.add(new Line(720, 225, 720, 145)); // Sep. Balistico - Sep. Film
        lines.add(new Line(720, 145, 760, 145)); // Sep. Balistico - Sep. Film
        lines.add(new Line(830, 130, 830, 70)); // Sep. Film - TM Positivo1
        lines.add(new Line(830, 70, 918, 70)); // Sep. Film - TM Positivo1
        lines.add(new Line(900, 140, 970, 140)); // Sep. Film - TM Control Film
        lines.add(new Line(1020, 160, 1020, 200)); // TM Control Film - TM Control P/C
        lines.add(new Line(475, 230, 520, 230)); // Sep. Balistico - Sep. Magnetico 2
        lines.add(new Line(540, 245, 540, 295)); // Sep. Magnetico 2 - SO Plasticos
        lines.add(new Line(485, 315, 350, 315)); // SO Plasticos - SO Brick
        lines.add(new Line(575, 315, 680, 315)); // SO Plasticos - SO PET
        lines.add(new Line(290, 315, 170, 315)); // SO. Brick - TC Brick
        lines.add(new Line(320, 330, 320, 365)); // SO. Brick - Sep. Ind.
        lines.add(new Line(300, 385, 190, 385)); // Sep. Ind - TC Aluminio
        lines.add(new Line(360, 375, 520, 375)); // Sep. Ind. - TC Mezcla
        lines.add(new Line(760, 315, 940, 315)); // SO. PET - TC PET
        lines.add(new Line(720, 330, 720, 365)); // SO. PET - SO. PEAD
        lines.add(new Line(755, 385, 940, 385)); // SO. PEAD - TC PEAD
        lines.add(new Line(680, 375, 540, 375)); // SO. PEAD - TC Mezcla
    }

    private void mainFrameWindowClosing(WindowEvent e) {
        MasterThread.getInstance().interruptThread();
        System.exit(0);
    }

    private void clearSelected() {
        if (selected != null) {
            selected.setBackground(new Color(81, 193, 171));
        }
        selected = null;
    }

    private void showhideResults(boolean visibility) {
        labelAluminio.setVisible(visibility);
        labelBrick.setVisible(visibility);
        labelCompost.setVisible(visibility);
        labelFe.setVisible(visibility);
        labelFilm.setVisible(visibility);
        labelMezcla.setVisible(visibility);
        labelPC.setVisible(visibility);
        labelPEAD.setVisible(visibility);
        labelPET.setVisible(visibility);
        labelVidrio.setVisible(visibility);
    }

    private void enableModules(boolean enabled) {
        triajeManualPrimario.setEnabled(enabled);
        tromelFinos.setEnabled(enabled);
        tromelEnvases.setEnabled(enabled);
        triajeManualPositivo1.setEnabled(enabled);
        separadorMagnetico1.setEnabled(enabled);
        separadorMagnetico2.setEnabled(enabled);
        triajeManualPositivo2.setEnabled(enabled);
        compostaje.setEnabled(enabled);
        separadorBalistico.setEnabled(enabled);
        captacionFilm.setEnabled(enabled);
        triajeDeControlFilm.setEnabled(enabled);
        triajeDeControlPanelyCarton.setEnabled(enabled);
        separadorOpticoPlasticos.setEnabled(enabled);
        separadorOpticoBrik.setEnabled(enabled);
        separadorOpticoPET.setEnabled(enabled);
        separadorInductivo.setEnabled(enabled);
        separadorOpticoPEAD.setEnabled(enabled);
        triajeDeControlBrik.setEnabled(enabled);
        triajeDeControlAluminio.setEnabled(enabled);
        triajeDeControlPET.setEnabled(enabled);
        triajeDeControlPEAD.setEnabled(enabled);
        triajeDeControlMezcla.setEnabled(enabled);
    }

    private void mainPanelMouseClicked(MouseEvent e) {
        showhideResults(true);
        setBottomPanelBorder("Residuos obtenidos (Toneladas)");
        labelExplanation.setText("");
        labelExplanation.setVisible(false);
        clearSelected();

    }

    private void empezarButtonMouseClicked(MouseEvent e) {
        if (empezarButton.isEnabled()) {
            pausarButton.setEnabled(true);
            pausarButtonNewBackground(true);
            reanudarButton.setEnabled(false);
            reanudarButtonNewBackground(false);
            empezarButton.setEnabled(false);
            empezarButtonNewBackground(false);
            pararButton.setEnabled(true);
            pararButtonNewBackground(true);
            buttonFoso.setEnabled(false);
            buttonFosoNewBackground(false);
            buttonVerRechazo.setEnabled(true);
            buttonVerRechazoNewBackground(true);

            enableModules(true);
            MasterThread.getInstance().start();
        }
    }

    private void pararButtonMouseClicked(MouseEvent e) {
        if (pararButton.isEnabled()) {
            pausarButton.setEnabled(false);
            pausarButtonNewBackground(false);
            reanudarButton.setEnabled(false);
            reanudarButtonNewBackground(false);
            empezarButton.setEnabled(true);
            empezarButtonNewBackground(true);
            pararButton.setEnabled(false);
            pararButtonNewBackground(false);
            buttonFoso.setEnabled(true);
            buttonFosoNewBackground(true);
            buttonVerRechazo.setEnabled(false);
            buttonVerRechazoNewBackground(false);


            enableModules(false);
            MasterThread.getInstance().interruptThread();
        }
    }

    private void pausarButtonMouseClicked(MouseEvent e) {
        if (pausarButton.isEnabled()) {
            pausarButton.setEnabled(false);
            pausarButtonNewBackground(false);
            reanudarButton.setEnabled(true);
            reanudarButtonNewBackground(true);
            empezarButton.setEnabled(false);
            empezarButtonNewBackground(false);
            pararButton.setEnabled(true);
            pararButtonNewBackground(true);
            buttonFoso.setEnabled(false);
            buttonFosoNewBackground(false);
            buttonVerRechazo.setEnabled(true);
            buttonVerRechazoNewBackground(true);
            MasterThread.getInstance().suspend();
        }
    }

    private void reanudarButtonMouseClicked(MouseEvent e) {
        if (reanudarButton.isEnabled()) {
            pausarButton.setEnabled(true);
            pausarButtonNewBackground(true);
            reanudarButton.setEnabled(false);
            reanudarButtonNewBackground(false);
            empezarButton.setEnabled(false);
            empezarButtonNewBackground(false);
            pararButton.setEnabled(true);
            pararButtonNewBackground(true);
            buttonFoso.setEnabled(false);
            buttonFosoNewBackground(false);
            buttonVerRechazo.setEnabled(true);
            buttonVerRechazoNewBackground(true);
            MasterThread.getInstance().resume();
        }
    }

    private void buttonFosoMouseClicked(MouseEvent e) {
        if (buttonFoso.isEnabled()) {
            MasterThread.getInstance().suspend();
            FosoDialog dialog = new FosoDialog(this, true);
            dialog.setVisible(true);
        }
    }

    private void buttonVerRechazoMouseClicked(MouseEvent e) {
        if (buttonVerRechazo.isEnabled()) {
            ResiduosDialog dialog = new ResiduosDialog(this, true);
            dialog.setVisible(true);
        }
    }

    private void empezarButtonNewBackground(boolean visible) {
        if (visible) {
            empezarButton.setBackground(new Color(146, 138, 223));
        } else {
            empezarButton.setBackground(new Color(190, 185, 241));
        }
    }

    private void pararButtonNewBackground(boolean visible) {
        if (visible) {
            pararButton.setBackground(new Color(146, 138, 223));
        } else {
            pararButton.setBackground(new Color(190, 185, 241));
        }
    }

    private void pausarButtonNewBackground(boolean visible) {
        if (visible) {
            pausarButton.setBackground(new Color(146, 138, 223));
        } else {
            pausarButton.setBackground(new Color(190, 185, 241));
        }
    }

    private void reanudarButtonNewBackground(boolean visible) {
        if (visible) {
            reanudarButton.setBackground(new Color(146, 138, 223));
        } else {
            reanudarButton.setBackground(new Color(190, 185, 241));
        }
    }

    private void buttonFosoNewBackground(boolean visible) {
        if (visible) {
            buttonFoso.setBackground(new Color(146, 138, 223));
        } else {
            buttonFoso.setBackground(new Color(190, 185, 241));
        }
    }

    private void buttonVerRechazoNewBackground(boolean visible) {
        if (buttonVerRechazo.isEnabled()) {
            buttonVerRechazo.setBackground(new Color(146, 138, 223));
        } else {
            buttonVerRechazo.setBackground(new Color(190, 185, 241));
        }
    }

    private void setBottomPanelBorder(String title) {
        TitledBorder titledBorder = new TitledBorder(new CompoundBorder(
                new LineBorder(new Color(37, 87, 153), 1, true),
                new EtchedBorder()),  title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125));
        bottomPanel.setBorder(titledBorder);
    }

    private void triajeManualPrimarioMouseClicked(MouseEvent e) {
        if (!triajeManualPrimario.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeManualPrimarioUI dialog = new TriajeManualPrimarioUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeManualPrimario;
            triajeManualPrimario.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje Manual Positivo");
            labelExplanation.setText("Esta separación consiste, principalmente, en eliminar del proceso " +
                    "aquellos residuos que no son adecuados para el resto de módulos " +
                    "(papel y cartón, vidrio, objetos voluminosos metálicos y no metálicos).");
            labelExplanation.setVisible(true);
        }
    }

    private void tromelFinosMouseClicked(MouseEvent e) {
        if (!tromelFinos.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TromelFinosUI dialog = new TromelFinosUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = tromelFinos;
            tromelFinos.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Tromel de Finos");
            labelExplanation.setText("Este módulo tiene como misión principal sacar del proceso los materiales de pequeño tamaño. Estos materiales " +
                    "extraídos del proceso, generalmente, estan compuestos por gran cantidad de materia orgánica.");
            labelExplanation.setVisible(true);
        }
    }

    private void tromelEnvasesMouseClicked(MouseEvent e) {
        if (!tromelEnvases.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TromelEnvasesUI dialog = new TromelEnvasesUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = tromelEnvases;
            tromelEnvases.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Tromel de Envases");
            labelExplanation.setText("En este módulo se separan los materiales en tres grupos: los que, por su pequeño tamaño, pueden pasar directamente al" +
                    " separador balístico; los que deben pasar por un triaje manual y el abrebolsas antes de llegar al separador (generalmente llevan gran cantidad" +
                    " de bolsas de plástico cerradas) y los que solamente pasarán por un triaje manual antes de ser rechazados (los más grandes).");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeManualPositivo1MouseClicked(MouseEvent e) {
        if (!triajeManualPositivo1.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeManualPositivo1UI dialog = new TriajeManualPositivo1UI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeManualPositivo1;
            triajeManualPositivo1.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje  Manual Positivo");
            labelExplanation.setText("La misión de este módulo es extraer el film, el PEAD, el papel y el " +
                    "cartón del rebose del tromel de envases, continuando el resto de materiales directamente al rechazo.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeManualPositivo2MouseClicked(MouseEvent e) {
        if (!triajeManualPositivo2.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeManualPositivo2UI dialog = new TriajeManualPositivo2UI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeManualPositivo2;
            triajeManualPositivo2.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje  Manual Positivo");
            labelExplanation.setText("En este módulo se eliminan del proceso aquellos materiales que no son adecuados para el " +
                    "separador balístico y módulos posteriores: Papel y Carton, Film y PEAD. " +
                    "Estos productos no requerirán de más procesamiento.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorMagnetico1MouseClicked(MouseEvent e) {
        if (!separadorMagnetico1.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorMagnetico1UI dialog = new SeparadorMagnetico1UI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorMagnetico1;
            separadorMagnetico1.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Magnético");
            labelExplanation.setText("En este módulo extrae los metales férricos del proceso antes de que se proceda al compostaje.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorMagnetico2MouseClicked(MouseEvent e) {
        if (!separadorMagnetico2.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorMagnetico2UI dialog = new SeparadorMagnetico2UI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorMagnetico2;
            separadorMagnetico2.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Magnético");
            labelExplanation.setText("En este módulo extrae los metales férricos del proceso antes de que se proceda a la clasificación de plásticos.");
            labelExplanation.setVisible(true);
        }
    }

    private void compostajeMouseClicked(MouseEvent e) {
        if (!compostaje.isEnabled())
            return;

        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            CompostajeUI dialog = new CompostajeUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = compostaje;
            compostaje.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Compostaje");
            labelExplanation.setText("Este módulo transforma la materia orgánica en compost para su uso agrícola");
            labelExplanation.setVisible(true);
        }
    }

    private void captacionFilmMouseClicked(MouseEvent e) {
        if (!captacionFilm.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            CaptacionFilmUI dialog = new CaptacionFilmUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = captacionFilm;
            captacionFilm.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Captación de Film");
            labelExplanation.setText("Este módulo consiste en un aspirador, situado por encima de la cinta que transporta " +
                    "los residuos, que aspirará aquellos materiales de bajo peso como el Film o el papel y cartón.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlFilmMouseClicked(MouseEvent e) {
        if (!triajeDeControlFilm.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlFilmUI dialog = new TriajeDeControlFilmUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlFilm;
            triajeDeControlFilm.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de Film");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como film y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlPanelyCartonMouseClicked(MouseEvent e) {
        if (!triajeDeControlPanelyCarton.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlPapelyCartonUI dialog = new TriajeDeControlPapelyCartonUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlPanelyCarton;
            triajeDeControlPanelyCarton.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de Papel y Cartón");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como papel o cartón y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorBalisticoMouseClicked(MouseEvent e) {
        if (!separadorBalistico.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorBalisticoUI dialog = new SeparadorBalisticoUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorBalistico;
            separadorBalistico.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Balístico");
            labelExplanation.setText("Este módulo separa los residuos en: finos, que se unirán a los hundidos del tromel de finos; los planares, que" +
                    " pasaran a la captación de film y los rodante, que pasaran al proceso de clasificación de plásticos (previa separación magnética).");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlBrikMouseClicked(MouseEvent e) {
        if (!triajeDeControlBrik.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlBrikUI dialog = new TriajeDeControlBrikUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlBrik;
            triajeDeControlBrik.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de Briks");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como brik y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlAluminioMouseClicked(MouseEvent e) {
        if (!triajeDeControlAluminio.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlAluminioUI dialog = new TriajeDeControlAluminioUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlAluminio;
            triajeDeControlAluminio.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de Aluminio");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como aluminio y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlMezclaMouseClicked(MouseEvent e) {
        if (!triajeDeControlMezcla.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlMezclaUI dialog = new TriajeDeControlMezclaUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlMezcla;
            triajeDeControlMezcla.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de Plásticos Mezcla");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como plásticos mezcla y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlPETMouseClicked(MouseEvent e) {
        if (!triajeDeControlPET.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlPETUI dialog = new TriajeDeControlPETUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlPET;
            triajeDeControlPET.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de PET");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como PET y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void triajeDeControlPEADMouseClicked(MouseEvent e) {
        if (!triajeDeControlPEAD.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            TriajeDeControlPEADUI dialog = new TriajeDeControlPEADUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = triajeDeControlPEAD;
            triajeDeControlPEAD.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Triaje de Control de PEAD");
            labelExplanation.setText("Este módulo analiza de forma manual los residuos que el proceso automático a declarado como PEAD y elimina " +
                    "aquellos materiales que no lo sean.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorOpticoBrikMouseClicked(MouseEvent e) {
        if (!separadorOpticoBrik.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorOpticoBrikUI dialog = new SeparadorOpticoBrikUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorOpticoBrik;
            separadorOpticoBrik.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Óptico de Briks");
            labelExplanation.setText("Este módulo separa los Briks usando un sensor espectrométrico.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorOpticoPETMouseClicked(MouseEvent e) {
        if (!separadorOpticoPET.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorOpticoPETUI dialog = new SeparadorOpticoPETUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorOpticoPET;
            separadorOpticoPET.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Óptico de PET");
            labelExplanation.setText("Este módulo separa los PET usando un sensor espectrométrico.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorOpticoPEADMouseClicked(MouseEvent e) {
        if (!separadorOpticoPEAD.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorOpticoPEADUI dialog = new SeparadorOpticoPEADUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorOpticoPEAD;
            separadorOpticoPEAD.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Óptico de PEAD");
            labelExplanation.setText("Este módulo separa los PEAD usando un sensor espectrométrico.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorInductivoMouseClicked(MouseEvent e) {
        if (!separadorInductivo.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorInductivoUI dialog = new SeparadorInductivoUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorInductivo;
            separadorInductivo.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Inductivo");
            labelExplanation.setText("Este módulo separa los materiales conductores restantes usando un corrientes de Foucault.");
            labelExplanation.setVisible(true);
        }
    }

    private void separadorOpticoPlasticosMouseClicked(MouseEvent e) {
        if (!separadorOpticoPlasticos.isEnabled())
            return;
        if (e.getClickCount() >= 2) {
            MasterThread.getInstance().suspend();
            SeparadorOpticoPlasticosUI dialog = new SeparadorOpticoPlasticosUI(this, true);
            dialog.setVisible(true);
        } else {
            clearSelected();
            selected = separadorOpticoPlasticos;
            separadorOpticoPlasticos.setBackground(new Color(24, 149, 125));
            showhideResults(false);
            setBottomPanelBorder("Separador Óptico de Plásticos");
            labelExplanation.setText("Este módulo separa los plásticos usando un sensor espectrométrico.");
            labelExplanation.setVisible(true);
        }
    }

    private void initComponents() {
        // Component initialization
        panel1 = new JPanel();
        empezarButton = new JButton();
        pararButton = new JButton();
        pausarButton = new JButton();
        reanudarButton = new JButton();
        buttonFoso = new JButton();
        buttonVerRechazo = new JButton();
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                for (Line line : lines) {
                    g2.draw(line.getLine());
                }
            }
        };
        triajeManualPrimario = new JButton();
        tromelFinos = new JButton();
        tromelEnvases = new JButton();
        triajeManualPositivo1 = new JButton();
        separadorMagnetico1 = new JButton();
        triajeManualPositivo2 = new JButton();
        compostaje = new JButton();
        separadorBalistico = new JButton();
        captacionFilm = new JButton();
        triajeDeControlFilm = new JButton();
        triajeDeControlPanelyCarton = new JButton();
        separadorOpticoPlasticos = new JButton();
        separadorOpticoBrik = new JButton();
        separadorOpticoPET = new JButton();
        separadorInductivo = new JButton();
        separadorOpticoPEAD = new JButton();
        triajeDeControlBrik = new JButton();
        triajeDeControlAluminio = new JButton();
        triajeDeControlPET = new JButton();
        triajeDeControlPEAD = new JButton();
        triajeDeControlMezcla = new JButton();
        separadorMagnetico2 = new JButton();
        bottomPanel = new JPanel();
        labelVidrio = new JLabel();
        labelPC = new JLabel();
        labelPEAD = new JLabel();
        labelFe = new JLabel();
        labelFilm = new JLabel();
        labelCompost = new JLabel();
        labelBrick = new JLabel();
        labelAluminio = new JLabel();
        labelPET = new JLabel();
        labelMezcla = new JLabel();
        labelExplanation = new JTextArea();

        //======== this ========
        setTitle("Simulador RSU");
        setResizable(false);
        setBackground(new Color(180, 206, 239));
        setMaximizedBounds(new Rectangle(1150, 32789, 1150, 32789));
        try {
            setIconImage(ImageIO.read(MainFrame.class.getResource("/org/simuladorRSU/resources/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrameWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(180, 206, 239));
            panel1.setMaximumSize(new Dimension(1150, 31));

            //---- empezarButton ----
            empezarButton.setText("Empezar");
            empezarButton.setBackground(new Color(146, 138, 223));
            empezarButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    empezarButtonMouseClicked(e);
                }
            });

            //---- pararButton ----
            pararButton.setText("Parar");
            pararButton.setEnabled(false);
            pararButton.setBackground(new Color(190, 185, 241));
            pararButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pararButtonMouseClicked(e);
                }
            });

            //---- pausarButton ----
            pausarButton.setText("Pausar");
            pausarButton.setEnabled(false);
            pausarButton.setBackground(new Color(190, 185, 241));
            pausarButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pausarButtonMouseClicked(e);
                }
            });

            //---- reanudarButton ----
            reanudarButton.setText("Reanudar");
            reanudarButton.setEnabled(false);
            reanudarButton.setBackground(new Color(190, 185, 241));
            reanudarButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    reanudarButtonMouseClicked(e);
                }
            });

            //---- buttonFoso ----
            buttonFoso.setText("Modificar Foso");
            buttonFoso.setBackground(new Color(146, 138, 223));
            buttonFoso.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonFosoMouseClicked(e);
                }
            });

            //---- buttonVerRechazo ----
            buttonVerRechazo.setText("Ver Rechazo");
            buttonVerRechazo.setEnabled(false);
            buttonVerRechazo.setBackground(new Color(190, 185, 241));
            buttonVerRechazo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonVerRechazoMouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(empezarButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(pararButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(pausarButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(reanudarButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(buttonFoso, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(buttonVerRechazo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addComponent(empezarButton)
                            .addComponent(pararButton)
                            .addComponent(pausarButton)
                            .addComponent(reanudarButton)
                            .addComponent(buttonFoso)
                            .addComponent(buttonVerRechazo)
            );
        }
        contentPane.add(panel1);

        //======== mainPanel ========
        {
            mainPanel.setBackground(new Color(180, 206, 239));
            mainPanel.setBorder(new TitledBorder(new CompoundBorder(
                    new LineBorder(new Color(37, 87, 153), 1, true),
                    new EtchedBorder()),  "Simulador", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));
            mainPanel.setMaximumSize(new Dimension(1150, 32789));
            mainPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mainPanelMouseClicked(e);
                }
            });

            //---- triajeManualPrimario ----
            triajeManualPrimario.setText("Triaje Manual Primario");
            triajeManualPrimario.setBackground(new Color(81, 193, 171));
            triajeManualPrimario.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeManualPrimarioMouseClicked(e);
                }
            });

            //---- tromelFinos ----
            tromelFinos.setText("Tromel Finos");
            tromelFinos.setHorizontalAlignment(SwingConstants.CENTER);
            tromelFinos.setBackground(new Color(81, 193, 171));
            tromelFinos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tromelFinosMouseClicked(e);
                }
            });

            //---- tromelEnvases ----
            tromelEnvases.setText("Tromel Envases");
            tromelEnvases.setBackground(new Color(81, 193, 171));
            tromelEnvases.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tromelEnvasesMouseClicked(e);
                }
            });

            //---- triajeManualPositivo1 ----
            triajeManualPositivo1.setText("Triaje Manual Positivo");
            triajeManualPositivo1.setBackground(new Color(81, 193, 171));
            triajeManualPositivo1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeManualPositivo1MouseClicked(e);
                }
            });

            //---- separadorMagnetico1 ----
            separadorMagnetico1.setText("Sep. Magn\u00e9tico");
            separadorMagnetico1.setBackground(new Color(81, 193, 171));
            separadorMagnetico1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorMagnetico1MouseClicked(e);
                }
            });

            //---- triajeManualPositivo2 ----
            triajeManualPositivo2.setText("Triaje Manual Positivo");
            triajeManualPositivo2.setBackground(new Color(81, 193, 171));
            triajeManualPositivo2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeManualPositivo2MouseClicked(e);
                }
            });

            //---- compostaje ----
            compostaje.setText("Compostaje");
            compostaje.setBackground(new Color(81, 193, 171));
            compostaje.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    compostajeMouseClicked(e);
                }
            });

            //---- separadorBalistico ----
            separadorBalistico.setText("Separador Bal\u00edstico");
            separadorBalistico.setBackground(new Color(81, 193, 171));
            separadorBalistico.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorBalisticoMouseClicked(e);
                }
            });

            //---- captacionFilm ----
            captacionFilm.setText("Captaci\u00f3n de film");
            captacionFilm.setBackground(new Color(81, 193, 171));
            captacionFilm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    captacionFilmMouseClicked(e);
                }
            });

            //---- triajeDeControlFilm ----
            triajeDeControlFilm.setText("T.C. Film");
            triajeDeControlFilm.setBackground(new Color(81, 193, 171));
            triajeDeControlFilm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlFilmMouseClicked(e);
                }
            });

            //---- triajeDeControlPanelyCarton ----
            triajeDeControlPanelyCarton.setText("T.C. Papel y Cart\u00f3n");
            triajeDeControlPanelyCarton.setBackground(new Color(81, 193, 171));
            triajeDeControlPanelyCarton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlPanelyCartonMouseClicked(e);
                }
            });

            //---- separadorOpticoPlasticos ----
            separadorOpticoPlasticos.setText("S.O. Pl\u00e1sticos");
            separadorOpticoPlasticos.setBackground(new Color(81, 193, 171));
            separadorOpticoPlasticos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorOpticoPlasticosMouseClicked(e);
                }
            });

            //---- separadorOpticoBrik ----
            separadorOpticoBrik.setText("S.O. Brik");
            separadorOpticoBrik.setBackground(new Color(81, 193, 171));
            separadorOpticoBrik.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorOpticoBrikMouseClicked(e);
                }
            });

            //---- separadorOpticoPET ----
            separadorOpticoPET.setText("S.O. PET");
            separadorOpticoPET.setBackground(new Color(81, 193, 171));
            separadorOpticoPET.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorOpticoPETMouseClicked(e);
                }
            });

            //---- separadorInductivo ----
            separadorInductivo.setText("Sep. Inductivo");
            separadorInductivo.setBackground(new Color(81, 193, 171));
            separadorInductivo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorInductivoMouseClicked(e);
                }
            });

            //---- separadorOpticoPEAD ----
            separadorOpticoPEAD.setText("S.O. PEAD");
            separadorOpticoPEAD.setBackground(new Color(81, 193, 171));
            separadorOpticoPEAD.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorOpticoPEADMouseClicked(e);
                }
            });

            //---- triajeDeControlBrik ----
            triajeDeControlBrik.setText("T.C. Brik");
            triajeDeControlBrik.setBackground(new Color(81, 193, 171));
            triajeDeControlBrik.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlBrikMouseClicked(e);
                }
            });

            //---- triajeDeControlAluminio ----
            triajeDeControlAluminio.setText("T.C. Aluminio");
            triajeDeControlAluminio.setBackground(new Color(81, 193, 171));
            triajeDeControlAluminio.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlAluminioMouseClicked(e);
                }
            });

            //---- triajeDeControlPET ----
            triajeDeControlPET.setText("T.C. PET");
            triajeDeControlPET.setBackground(new Color(81, 193, 171));
            triajeDeControlPET.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlPETMouseClicked(e);
                }
            });

            //---- triajeDeControlPEAD ----
            triajeDeControlPEAD.setText("T.C. PEAD");
            triajeDeControlPEAD.setBackground(new Color(81, 193, 171));
            triajeDeControlPEAD.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlPEADMouseClicked(e);
                }
            });

            //---- triajeDeControlMezcla ----
            triajeDeControlMezcla.setText("T.C. Mezcla");
            triajeDeControlMezcla.setBackground(new Color(81, 193, 171));
            triajeDeControlMezcla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    triajeDeControlMezclaMouseClicked(e);
                }
            });

            //---- separadorMagnetico2 ----
            separadorMagnetico2.setText("Sep. Magn\u00e9tico");
            separadorMagnetico2.setBackground(new Color(81, 193, 171));
            separadorMagnetico2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    separadorMagnetico2MouseClicked(e);
                }
            });

            GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);
            mainPanelLayout.setHorizontalGroup(
                    mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(mainPanelLayout.createParallelGroup()
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                    .addGap(53, 53, 53)
                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                            .addComponent(triajeDeControlBrik)
                                                            .addComponent(triajeDeControlAluminio))
                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                                    .addGap(58, 58, 58)
                                                                                    .addComponent(tromelFinos)
                                                                                    .addGap(57, 57, 57)
                                                                                    .addComponent(tromelEnvases))
                                                                            .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                    .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                                                                            .addGap(56, 56, 56)
                                                                                            .addComponent(separadorInductivo)
                                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(triajeDeControlMezcla))
                                                                                    .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                                                                            .addGap(48, 48, 48)
                                                                                            .addComponent(separadorOpticoBrik)
                                                                                            .addGap(91, 91, 91)
                                                                                            .addComponent(separadorOpticoPlasticos))))
                                                                    .addGap(58, 58, 58)
                                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(separadorOpticoPEAD)
                                                                            .addComponent(separadorOpticoPET)))
                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                    .addGap(292, 292, 292)
                                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                                            .addComponent(separadorMagnetico2)
                                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                                    .addComponent(triajeManualPositivo2)
                                                                                    .addGap(53, 53, 53)
                                                                                    .addComponent(captacionFilm)))))
                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                    .addGap(38, 38, 38)
                                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                                            .addComponent(triajeDeControlFilm, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(triajeDeControlPanelyCarton, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                                                            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(triajeDeControlPEAD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(triajeDeControlPET, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(85, 85, 85))))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addGroup(mainPanelLayout.createParallelGroup()
                                                                    .addComponent(separadorMagnetico1)
                                                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                                                            .addGap(13, 13, 13)
                                                                            .addComponent(compostaje)))
                                                            .addComponent(triajeManualPrimario))
                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                    .addGap(18, 18, Short.MAX_VALUE)
                                                                    .addComponent(triajeManualPositivo1)
                                                                    .addGap(68, 68, 68))
                                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                                    .addGap(96, 96, 96)
                                                                    .addComponent(separadorBalistico)
                                                                    .addGap(0, 596, Short.MAX_VALUE)))))
                                    .addGap(16, 16, 16))
            );
            mainPanelLayout.setVerticalGroup(
                    mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(triajeManualPrimario, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeManualPositivo1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tromelEnvases, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tromelFinos, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(43, 43, 43)
                                    .addGroup(mainPanelLayout.createParallelGroup()
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(triajeManualPositivo2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(captacionFilm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(triajeDeControlFilm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(29, 29, 29)
                                                    .addComponent(triajeDeControlPanelyCarton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                    .addComponent(separadorMagnetico1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(48, 48, 48)
                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(compostaje, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(separadorBalistico, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(separadorMagnetico2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
                                    .addGap(43, 43, 43)
                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(separadorOpticoBrik, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeDeControlBrik, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeDeControlPET, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(separadorOpticoPET, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(separadorOpticoPlasticos, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(separadorInductivo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(separadorOpticoPEAD, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeDeControlAluminio, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeDeControlPEAD, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(triajeDeControlMezcla, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(57, Short.MAX_VALUE))
            );
        }
        contentPane.add(mainPanel);

        //======== bottomPanel ========
        {
            bottomPanel.setBackground(new Color(180, 206, 239));
            bottomPanel.setBorder(new TitledBorder(new CompoundBorder(
                    new LineBorder(new Color(37, 87, 153), 1, true),
                    new EtchedBorder()),  "Residuos obtenidos (Toneladas)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));
            bottomPanel.setMaximumSize(new Dimension(1150, 123));

            //---- labelVidrio ----
            labelVidrio.setText("Vidrio: 0,00");

            //---- labelPC ----
            labelPC.setText("Papel y Cart\u00f3n: 0,00");

            //---- labelPEAD ----
            labelPEAD.setText("PEAD: 0,00");

            //---- labelFe ----
            labelFe.setText("F\u00e9rricos: 0,00");

            //---- labelFilm ----
            labelFilm.setText("Film: 0,00");

            //---- labelCompost ----
            labelCompost.setText("Compost: 0,00");

            //---- labelBrick ----
            labelBrick.setText("Bricks: 0,00");

            //---- labelAluminio ----
            labelAluminio.setText("Aluminio: 0,00");

            //---- labelPET ----
            labelPET.setText("PET: 0,00");

            //---- labelMezcla ----
            labelMezcla.setText("Plasticos Mezcla: 0,00");

            //---- labelExplanation ----
            labelExplanation.setBackground(new Color(180, 206, 239));
            labelExplanation.setEditable(false);
            labelExplanation.setFont(new Font("Dialog", Font.BOLD, 12));
            labelExplanation.setLineWrap(true);
            labelExplanation.setWrapStyleWord(true);

            GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
            bottomPanel.setLayout(bottomPanelLayout);
            bottomPanelLayout.setHorizontalGroup(
                    bottomPanelLayout.createParallelGroup()
                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addGroup(bottomPanelLayout.createParallelGroup()
                                            .addComponent(labelExplanation)
                                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(labelPC, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                            .addComponent(labelVidrio, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(labelFe, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                            .addComponent(labelPEAD, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                                    .addGap(61, 61, 61)
                                                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(labelCompost, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                            .addComponent(labelFilm, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                                    .addGap(49, 49, 49)
                                                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(labelAluminio, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                            .addComponent(labelBrick, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                                    .addGap(32, 32, 32)
                                                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(labelMezcla, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                            .addComponent(labelPET, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                                    .addGap(27, 27, 27)))
                                    .addContainerGap())
            );
            bottomPanelLayout.setVerticalGroup(
                    bottomPanelLayout.createParallelGroup()
                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(labelExplanation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(bottomPanelLayout.createParallelGroup()
                                            .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(bottomPanelLayout.createSequentialGroup()
                                                            .addComponent(labelVidrio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(labelPC, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.LEADING, bottomPanelLayout.createSequentialGroup()
                                                            .addComponent(labelPEAD, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(12, 12, 12)
                                                            .addComponent(labelFe, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                                    .addComponent(labelFilm, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(labelCompost, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                                    .addComponent(labelBrick, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(labelAluminio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(bottomPanelLayout.createSequentialGroup()
                                                    .addComponent(labelPET, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(labelMezcla, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(41, Short.MAX_VALUE))
            );
        }
        contentPane.add(bottomPanel);
        setSize(1080, 680);
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration
    private JPanel panel1;
    private JButton empezarButton;
    private JButton pararButton;
    private JButton pausarButton;
    private JButton reanudarButton;
    private JButton buttonFoso;
    private JButton buttonVerRechazo;
    private JPanel mainPanel;
    private JButton triajeManualPrimario;
    private JButton tromelFinos;
    private JButton tromelEnvases;
    private JButton triajeManualPositivo1;
    private JButton separadorMagnetico1;
    private JButton triajeManualPositivo2;
    private JButton compostaje;
    private JButton separadorBalistico;
    private JButton captacionFilm;
    private JButton triajeDeControlFilm;
    private JButton triajeDeControlPanelyCarton;
    private JButton separadorOpticoPlasticos;
    private JButton separadorOpticoBrik;
    private JButton separadorOpticoPET;
    private JButton separadorInductivo;
    private JButton separadorOpticoPEAD;
    private JButton triajeDeControlBrik;
    private JButton triajeDeControlAluminio;
    private JButton triajeDeControlPET;
    private JButton triajeDeControlPEAD;
    private JButton triajeDeControlMezcla;
    private JButton separadorMagnetico2;
    private JPanel bottomPanel;
    private JLabel labelVidrio;
    private JLabel labelPC;
    private JLabel labelPEAD;
    private JLabel labelFe;
    private JLabel labelFilm;
    private JLabel labelCompost;
    private JLabel labelBrick;
    private JLabel labelAluminio;
    private JLabel labelPET;
    private JLabel labelMezcla;
    private JTextArea labelExplanation;
    // End of variables declaration
}