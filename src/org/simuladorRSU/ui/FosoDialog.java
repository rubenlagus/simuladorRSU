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
import org.simuladorRSU.simulacion.Residuos;
import org.simuladorRSU.simulacion.StaticComponents;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Ruben Bermudez
 */
public class FosoDialog extends JDialog {
    boolean correctValues = true;

    public FosoDialog(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public FosoDialog(Frame owner) {
        super(owner);
        initComponents();
    }

    public FosoDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        if (!correctValues)
            return;
        try {
            Residuos nuevosResiduos = new Residuos();
            nuevosResiduos.setAluminioNoEnvases(Double.parseDouble(textFieldAluminioNoEnvase.getText()));
            nuevosResiduos.setBolsas(Double.parseDouble(textFieldBolsas.getText()));
            nuevosResiduos.setBriks(Double.parseDouble(textFieldBrick.getText()));
            nuevosResiduos.setCelulosas(Double.parseDouble(textFieldCelulosa.getText()));
            nuevosResiduos.setFilm(Double.parseDouble(textFieldFilm.getText()));
            nuevosResiduos.setFinos(Double.parseDouble(textFieldFinos.getText()));
            nuevosResiduos.setJardinyPoda(Double.parseDouble(textFieldJardinPoda.getText()));
            nuevosResiduos.setLatasAcero(Double.parseDouble(textFieldLatasAcero.getText()));
            nuevosResiduos.setLatasAluminio(Double.parseDouble(textFieldLatasAluminio.getText()));
            nuevosResiduos.setMadera(Double.parseDouble(textFieldMadera.getText()));
            nuevosResiduos.setMaderaNoEnvase(Double.parseDouble(textFieldMaderaNoEnv.getText()));
            nuevosResiduos.setChatarraNoEnvase(Double.parseDouble(textFieldMetalesNoEnvases.getText()));
            nuevosResiduos.setPlaticosMezcla(Double.parseDouble(textFieldMezcla.getText()));
            nuevosResiduos.setMateriaOrganica(Double.parseDouble(textFieldOrganica.getText()));
            nuevosResiduos.setOtros(Double.parseDouble(textFieldOtros.getText()));
            nuevosResiduos.setPapelyCarton(Double.parseDouble(textFieldPapelCarton.getText()));
            nuevosResiduos.setPEAD(Double.parseDouble(textFieldPEAD.getText()));
            nuevosResiduos.setPET(Double.parseDouble(textFieldPET.getText()));
            nuevosResiduos.setPlasticosNoEnvases(Double.parseDouble(textFieldPlasticosNoEnvases.getText()));
            nuevosResiduos.setPVC(Double.parseDouble(textFieldPVC.getText()));
            nuevosResiduos.setRAEES(Double.parseDouble(textFieldRAEES.getText()));
            nuevosResiduos.setEscombros(Double.parseDouble(textFieldRCD.getText()));
            nuevosResiduos.setRopa(Double.parseDouble(textFieldRopa.getText()));
            nuevosResiduos.setVidrio(Double.parseDouble(textFieldVidrio.getText()));
            nuevosResiduos.setVoluminososMetalicos(Double.parseDouble(textFieldVolMetalicos.getText()));
            nuevosResiduos.setVoluminososNoMetalicos(Double.parseDouble(textFieldVolNoMetalicos.getText()));
            MasterThread.getInstance().setResiduosToFoso(nuevosResiduos);
        } catch (Exception exception) {
        }
        setVisible(false);
        dispose();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        setVisible(false);
        dispose();
    }

    private void contentPanelComponentShown(ComponentEvent e) {
        textFieldAluminioNoEnvase.setText(StaticComponents.getInstance().getFoso().getRSU().getAluminioNoEnvases()+"");
        textFieldBolsas.setText(StaticComponents.getInstance().getFoso().getRSU().getBolsas()+"");
        textFieldBrick.setText(StaticComponents.getInstance().getFoso().getRSU().getBriks()+"");
        textFieldCelulosa.setText(StaticComponents.getInstance().getFoso().getRSU().getCelulosas()+"");
        textFieldFilm.setText(StaticComponents.getInstance().getFoso().getRSU().getFilm()+"");
        textFieldFinos.setText(StaticComponents.getInstance().getFoso().getRSU().getFinos()+"");
        textFieldJardinPoda.setText(StaticComponents.getInstance().getFoso().getRSU().getJardinyPoda()+"");
        textFieldLatasAcero.setText(StaticComponents.getInstance().getFoso().getRSU().getLatasAcero()+"");
        textFieldLatasAluminio.setText(StaticComponents.getInstance().getFoso().getRSU().getLatasAluminio()+"");
        textFieldMadera.setText(StaticComponents.getInstance().getFoso().getRSU().getMadera()+"");
        textFieldMaderaNoEnv.setText(StaticComponents.getInstance().getFoso().getRSU().getMaderaNoEnvase()+"");
        textFieldMetalesNoEnvases.setText(StaticComponents.getInstance().getFoso().getRSU().getChatarraNoEnvase()+"");
        textFieldMezcla.setText(StaticComponents.getInstance().getFoso().getRSU().getPlaticosMezcla()+"");
        textFieldOrganica.setText(StaticComponents.getInstance().getFoso().getRSU().getMateriaOrganica()+"");
        textFieldOtros.setText(StaticComponents.getInstance().getFoso().getRSU().getOtros()+"");
        textFieldPapelCarton.setText(StaticComponents.getInstance().getFoso().getRSU().getPapelyCarton()+"");
        textFieldPEAD.setText(StaticComponents.getInstance().getFoso().getRSU().getPEAD()+"");
        textFieldPET.setText(StaticComponents.getInstance().getFoso().getRSU().getPET()+"");
        textFieldPlasticosNoEnvases.setText(StaticComponents.getInstance().getFoso().getRSU().getPlasticosNoEnvases()+"");
        textFieldPVC.setText(StaticComponents.getInstance().getFoso().getRSU().getPVC()+"");
        textFieldRAEES.setText(StaticComponents.getInstance().getFoso().getRSU().getRAEES()+"");
        textFieldRCD.setText(StaticComponents.getInstance().getFoso().getRSU().getEscombros()+"");
        textFieldRopa.setText(StaticComponents.getInstance().getFoso().getRSU().getRopa()+"");
        textFieldVidrio.setText(StaticComponents.getInstance().getFoso().getRSU().getVidrio()+"");
        textFieldVolMetalicos.setText(StaticComponents.getInstance().getFoso().getRSU().getVoluminososMetalicos()+"");
        textFieldVolNoMetalicos.setText(StaticComponents.getInstance().getFoso().getRSU().getVoluminososNoMetalicos()+"");
    }

    private void textFieldFocusLost(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField component = (JTextField) e.getComponent();
            try {
                Double.parseDouble(component.getText());
                component.setBackground(Color.white);
                correctValues = true;
            } catch (Exception exception) {
                component.requestFocus();
                component.setBackground(new Color(235,255,131));
                correctValues = false;
            }
        }
    }

    private void initComponents() {
        // Component initialization
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        labelVolMetalicos = new JLabel();
        textFieldVolMetalicos = new JTextField();
        panel2 = new JPanel();
        labelVolNoMetalicos = new JLabel();
        textFieldVolNoMetalicos = new JTextField();
        panel3 = new JPanel();
        labelPET = new JLabel();
        textFieldPET = new JTextField();
        panel4 = new JPanel();
        labelPEAD = new JLabel();
        textFieldPEAD = new JTextField();
        panel5 = new JPanel();
        labelPVC = new JLabel();
        textFieldPVC = new JTextField();
        panel6 = new JPanel();
        labelBolsas = new JLabel();
        textFieldBolsas = new JTextField();
        panel7 = new JPanel();
        labelMezcla = new JLabel();
        textFieldMezcla = new JTextField();
        panel8 = new JPanel();
        labelLatasAcero = new JLabel();
        textFieldLatasAcero = new JTextField();
        panel9 = new JPanel();
        labelLatasAluminio = new JLabel();
        textFieldLatasAluminio = new JTextField();
        panel10 = new JPanel();
        labelBrick = new JLabel();
        textFieldBrick = new JTextField();
        panel11 = new JPanel();
        labelMadera = new JLabel();
        textFieldMadera = new JTextField();
        panel12 = new JPanel();
        labelPapelCarton = new JLabel();
        textFieldPapelCarton = new JTextField();
        panel13 = new JPanel();
        labelFilm = new JLabel();
        textFieldFilm = new JTextField();
        panel14 = new JPanel();
        labelPlasticosNoEnvases = new JLabel();
        textFieldPlasticosNoEnvases = new JTextField();
        panel15 = new JPanel();
        labelAluminioNoEnvases = new JLabel();
        textFieldAluminioNoEnvase = new JTextField();
        panel16 = new JPanel();
        labelMetalesNoEnvases = new JLabel();
        textFieldMetalesNoEnvases = new JTextField();
        panel17 = new JPanel();
        labelMateriaOrganica = new JLabel();
        textFieldOrganica = new JTextField();
        panel18 = new JPanel();
        labelJardinPoda = new JLabel();
        textFieldJardinPoda = new JTextField();
        panel19 = new JPanel();
        labelFinos = new JLabel();
        textFieldFinos = new JTextField();
        panel20 = new JPanel();
        labelCelulosas = new JLabel();
        textFieldCelulosa = new JTextField();
        panel21 = new JPanel();
        labelRopa = new JLabel();
        textFieldRopa = new JTextField();
        panel22 = new JPanel();
        labelZapatos = new JLabel();
        textFieldZapatos = new JTextField();
        panel23 = new JPanel();
        labelMaderaNoEnv = new JLabel();
        textFieldMaderaNoEnv = new JTextField();
        panel24 = new JPanel();
        labelVidrio = new JLabel();
        textFieldVidrio = new JTextField();
        panel25 = new JPanel();
        labelRAEES = new JLabel();
        textFieldRAEES = new JTextField();
        panel26 = new JPanel();
        labelRCD = new JLabel();
        textFieldRCD = new JTextField();
        panel27 = new JPanel();
        labelOtros = new JLabel();
        textFieldOtros = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Contenido Foso (Toneladas)");
        setAlwaysOnTop(true);
        setBackground(new Color(131, 170, 219));
        setModal(true);
        setResizable(false);
        setUndecorated(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new TitledBorder(new CompoundBorder(
                new LineBorder(new Color(37, 87, 153), 1, true),
                new EtchedBorder()), "Contenido Foso (Toneladas)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));
            dialogPane.setBackground(new Color(131, 170, 219));

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(131, 170, 219));
                contentPanel.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentShown(ComponentEvent e) {
                        contentPanelComponentShown(e);
                    }
                });
                contentPanel.setLayout(new GridLayout(28, 2));

                //======== panel1 ========
                {
                    panel1.setBackground(new Color(131, 170, 219));
                    panel1.setLayout(new GridLayout());

                    //---- labelVolMetalicos ----
                    labelVolMetalicos.setText("Voluminosos Met\u00e1licos");
                    panel1.add(labelVolMetalicos);

                    //---- textFieldVolMetalicos ----
                    textFieldVolMetalicos.setText("0.0");
                    textFieldVolMetalicos.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldFocusLost(e);
                        }
                    });
                    panel1.add(textFieldVolMetalicos);
                }
                contentPanel.add(panel1);

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(131, 170, 219));
                    panel2.setLayout(new GridLayout());

                    //---- labelVolNoMetalicos ----
                    labelVolNoMetalicos.setText("Voluminosos No Met\u00e1licos");
                    panel2.add(labelVolNoMetalicos);

                    //---- textFieldVolNoMetalicos ----
                    textFieldVolNoMetalicos.setText("0.0");
                    textFieldVolNoMetalicos.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldFocusLost(e);
                        }
                    });
                    panel2.add(textFieldVolNoMetalicos);
                }
                contentPanel.add(panel2);

                //======== panel3 ========
                {
                    panel3.setBackground(new Color(131, 170, 219));
                    panel3.setLayout(new GridLayout());

                    //---- labelPET ----
                    labelPET.setText("PET");
                    panel3.add(labelPET);

                    //---- textFieldPET ----
                    textFieldPET.setText("0.0");
                    textFieldPET.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldFocusLost(e);
                        }
                    });
                    panel3.add(textFieldPET);
                }
                contentPanel.add(panel3);

                //======== panel4 ========
                {
                    panel4.setBackground(new Color(131, 170, 219));
                    panel4.setLayout(new GridLayout());

                    //---- labelPEAD ----
                    labelPEAD.setText("PEAD");
                    panel4.add(labelPEAD);

                    //---- textFieldPEAD ----
                    textFieldPEAD.setText("0.0");
                    textFieldPEAD.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldFocusLost(e);
                        }
                    });
                    panel4.add(textFieldPEAD);
                }
                contentPanel.add(panel4);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(131, 170, 219));
                    panel5.setLayout(new GridLayout());

                    //---- labelPVC ----
                    labelPVC.setText("PVC");
                    panel5.add(labelPVC);

                    //---- textFieldPVC ----
                    textFieldPVC.setText("0.0");
                    textFieldPVC.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldFocusLost(e);
                        }
                    });
                    panel5.add(textFieldPVC);
                }
                contentPanel.add(panel5);

                //======== panel6 ========
                {
                    panel6.setBackground(new Color(131, 170, 219));
                    panel6.setLayout(new GridLayout());

                    //---- labelBolsas ----
                    labelBolsas.setText("Bolsas");
                    panel6.add(labelBolsas);

                    //---- textFieldBolsas ----
                    textFieldBolsas.setText("0.0");
                    panel6.add(textFieldBolsas);
                }
                contentPanel.add(panel6);

                //======== panel7 ========
                {
                    panel7.setBackground(new Color(131, 170, 219));
                    panel7.setLayout(new GridLayout());

                    //---- labelMezcla ----
                    labelMezcla.setText("Plasticos Mezcla");
                    panel7.add(labelMezcla);

                    //---- textFieldMezcla ----
                    textFieldMezcla.setText("0.0");
                    panel7.add(textFieldMezcla);
                }
                contentPanel.add(panel7);

                //======== panel8 ========
                {
                    panel8.setBackground(new Color(131, 170, 219));
                    panel8.setLayout(new GridLayout());

                    //---- labelLatasAcero ----
                    labelLatasAcero.setText("Latas Acero");
                    panel8.add(labelLatasAcero);

                    //---- textFieldLatasAcero ----
                    textFieldLatasAcero.setText("0.0");
                    panel8.add(textFieldLatasAcero);
                }
                contentPanel.add(panel8);

                //======== panel9 ========
                {
                    panel9.setBackground(new Color(131, 170, 219));
                    panel9.setLayout(new GridLayout());

                    //---- labelLatasAluminio ----
                    labelLatasAluminio.setText("Latas Aluminio");
                    panel9.add(labelLatasAluminio);

                    //---- textFieldLatasAluminio ----
                    textFieldLatasAluminio.setText("0.0");
                    panel9.add(textFieldLatasAluminio);
                }
                contentPanel.add(panel9);

                //======== panel10 ========
                {
                    panel10.setBackground(new Color(131, 170, 219));
                    panel10.setLayout(new GridLayout());

                    //---- labelBrick ----
                    labelBrick.setText("Bricks");
                    panel10.add(labelBrick);

                    //---- textFieldBrick ----
                    textFieldBrick.setText("0.0");
                    panel10.add(textFieldBrick);
                }
                contentPanel.add(panel10);

                //======== panel11 ========
                {
                    panel11.setBackground(new Color(131, 170, 219));
                    panel11.setLayout(new GridLayout());

                    //---- labelMadera ----
                    labelMadera.setText("Madera");
                    panel11.add(labelMadera);

                    //---- textFieldMadera ----
                    textFieldMadera.setText("0.0");
                    panel11.add(textFieldMadera);
                }
                contentPanel.add(panel11);

                //======== panel12 ========
                {
                    panel12.setBackground(new Color(131, 170, 219));
                    panel12.setLayout(new GridLayout());

                    //---- labelPapelCarton ----
                    labelPapelCarton.setText("Papel y Cart\u00f3n");
                    panel12.add(labelPapelCarton);

                    //---- textFieldPapelCarton ----
                    textFieldPapelCarton.setText("0.0");
                    panel12.add(textFieldPapelCarton);
                }
                contentPanel.add(panel12);

                //======== panel13 ========
                {
                    panel13.setBackground(new Color(131, 170, 219));
                    panel13.setLayout(new GridLayout());

                    //---- labelFilm ----
                    labelFilm.setText("Film");
                    panel13.add(labelFilm);

                    //---- textFieldFilm ----
                    textFieldFilm.setText("0.0");
                    panel13.add(textFieldFilm);
                }
                contentPanel.add(panel13);

                //======== panel14 ========
                {
                    panel14.setBackground(new Color(131, 170, 219));
                    panel14.setLayout(new GridLayout());

                    //---- labelPlasticosNoEnvases ----
                    labelPlasticosNoEnvases.setText("Plasticos no Envases");
                    panel14.add(labelPlasticosNoEnvases);

                    //---- textFieldPlasticosNoEnvases ----
                    textFieldPlasticosNoEnvases.setText("0.0");
                    panel14.add(textFieldPlasticosNoEnvases);
                }
                contentPanel.add(panel14);

                //======== panel15 ========
                {
                    panel15.setBackground(new Color(131, 170, 219));
                    panel15.setLayout(new GridLayout());

                    //---- labelAluminioNoEnvases ----
                    labelAluminioNoEnvases.setText("Aluminio no Envases");
                    panel15.add(labelAluminioNoEnvases);

                    //---- textFieldAluminioNoEnvase ----
                    textFieldAluminioNoEnvase.setText("0.0");
                    panel15.add(textFieldAluminioNoEnvase);
                }
                contentPanel.add(panel15);

                //======== panel16 ========
                {
                    panel16.setBackground(new Color(131, 170, 219));
                    panel16.setLayout(new GridLayout());

                    //---- labelMetalesNoEnvases ----
                    labelMetalesNoEnvases.setText("Metales F\u00e9rricos no Envases");
                    panel16.add(labelMetalesNoEnvases);

                    //---- textFieldMetalesNoEnvases ----
                    textFieldMetalesNoEnvases.setText("0.0");
                    panel16.add(textFieldMetalesNoEnvases);
                }
                contentPanel.add(panel16);

                //======== panel17 ========
                {
                    panel17.setBackground(new Color(131, 170, 219));
                    panel17.setLayout(new GridLayout());

                    //---- labelMateriaOrganica ----
                    labelMateriaOrganica.setText("Materia Org\u00e1nica");
                    panel17.add(labelMateriaOrganica);

                    //---- textFieldOrganica ----
                    textFieldOrganica.setText("0.0");
                    panel17.add(textFieldOrganica);
                }
                contentPanel.add(panel17);

                //======== panel18 ========
                {
                    panel18.setBackground(new Color(131, 170, 219));
                    panel18.setLayout(new GridLayout());

                    //---- labelJardinPoda ----
                    labelJardinPoda.setText("Jardin y Poda");
                    panel18.add(labelJardinPoda);

                    //---- textFieldJardinPoda ----
                    textFieldJardinPoda.setText("0.0");
                    panel18.add(textFieldJardinPoda);
                }
                contentPanel.add(panel18);

                //======== panel19 ========
                {
                    panel19.setBackground(new Color(131, 170, 219));
                    panel19.setLayout(new GridLayout());

                    //---- labelFinos ----
                    labelFinos.setText("Finos");
                    panel19.add(labelFinos);

                    //---- textFieldFinos ----
                    textFieldFinos.setText("0.0");
                    panel19.add(textFieldFinos);
                }
                contentPanel.add(panel19);

                //======== panel20 ========
                {
                    panel20.setBackground(new Color(131, 170, 219));
                    panel20.setLayout(new GridLayout());

                    //---- labelCelulosas ----
                    labelCelulosas.setText("Celulosas");
                    panel20.add(labelCelulosas);

                    //---- textFieldCelulosa ----
                    textFieldCelulosa.setText("0.0");
                    panel20.add(textFieldCelulosa);
                }
                contentPanel.add(panel20);

                //======== panel21 ========
                {
                    panel21.setBackground(new Color(131, 170, 219));
                    panel21.setLayout(new GridLayout());

                    //---- labelRopa ----
                    labelRopa.setText("Ropa");
                    panel21.add(labelRopa);

                    //---- textFieldRopa ----
                    textFieldRopa.setText("0.0");
                    panel21.add(textFieldRopa);
                }
                contentPanel.add(panel21);

                //======== panel22 ========
                {
                    panel22.setBackground(new Color(131, 170, 219));
                    panel22.setLayout(new GridLayout());

                    //---- labelZapatos ----
                    labelZapatos.setText("Zapatos");
                    panel22.add(labelZapatos);

                    //---- textFieldZapatos ----
                    textFieldZapatos.setText("0.0");
                    panel22.add(textFieldZapatos);
                }
                contentPanel.add(panel22);

                //======== panel23 ========
                {
                    panel23.setBackground(new Color(131, 170, 219));
                    panel23.setLayout(new GridLayout());

                    //---- labelMaderaNoEnv ----
                    labelMaderaNoEnv.setText("Madera No Envase");
                    panel23.add(labelMaderaNoEnv);

                    //---- textFieldMaderaNoEnv ----
                    textFieldMaderaNoEnv.setText("0.0");
                    panel23.add(textFieldMaderaNoEnv);
                }
                contentPanel.add(panel23);

                //======== panel24 ========
                {
                    panel24.setBackground(new Color(131, 170, 219));
                    panel24.setLayout(new GridLayout());

                    //---- labelVidrio ----
                    labelVidrio.setText("Vidrio");
                    panel24.add(labelVidrio);

                    //---- textFieldVidrio ----
                    textFieldVidrio.setText("0.0");
                    panel24.add(textFieldVidrio);
                }
                contentPanel.add(panel24);

                //======== panel25 ========
                {
                    panel25.setBackground(new Color(131, 170, 219));
                    panel25.setLayout(new GridLayout());

                    //---- labelRAEES ----
                    labelRAEES.setText("RAEES");
                    panel25.add(labelRAEES);

                    //---- textFieldRAEES ----
                    textFieldRAEES.setText("0.0");
                    panel25.add(textFieldRAEES);
                }
                contentPanel.add(panel25);

                //======== panel26 ========
                {
                    panel26.setBackground(new Color(131, 170, 219));
                    panel26.setLayout(new GridLayout());

                    //---- labelRCD ----
                    labelRCD.setText("RCD");
                    panel26.add(labelRCD);

                    //---- textFieldRCD ----
                    textFieldRCD.setText("0.0");
                    panel26.add(textFieldRCD);
                }
                contentPanel.add(panel26);

                //======== panel27 ========
                {
                    panel27.setBackground(new Color(131, 170, 219));
                    panel27.setLayout(new GridLayout());

                    //---- labelOtros ----
                    labelOtros.setText("Otros");
                    panel27.add(labelOtros);

                    //---- textFieldOtros ----
                    textFieldOtros.setText("0.0");
                    panel27.add(textFieldOtros);
                }
                contentPanel.add(panel27);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(131, 170, 219));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.setBackground(new Color(146, 138, 223));
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setBackground(new Color(146, 138, 223));
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel labelVolMetalicos;
    private JTextField textFieldVolMetalicos;
    private JPanel panel2;
    private JLabel labelVolNoMetalicos;
    private JTextField textFieldVolNoMetalicos;
    private JPanel panel3;
    private JLabel labelPET;
    private JTextField textFieldPET;
    private JPanel panel4;
    private JLabel labelPEAD;
    private JTextField textFieldPEAD;
    private JPanel panel5;
    private JLabel labelPVC;
    private JTextField textFieldPVC;
    private JPanel panel6;
    private JLabel labelBolsas;
    private JTextField textFieldBolsas;
    private JPanel panel7;
    private JLabel labelMezcla;
    private JTextField textFieldMezcla;
    private JPanel panel8;
    private JLabel labelLatasAcero;
    private JTextField textFieldLatasAcero;
    private JPanel panel9;
    private JLabel labelLatasAluminio;
    private JTextField textFieldLatasAluminio;
    private JPanel panel10;
    private JLabel labelBrick;
    private JTextField textFieldBrick;
    private JPanel panel11;
    private JLabel labelMadera;
    private JTextField textFieldMadera;
    private JPanel panel12;
    private JLabel labelPapelCarton;
    private JTextField textFieldPapelCarton;
    private JPanel panel13;
    private JLabel labelFilm;
    private JTextField textFieldFilm;
    private JPanel panel14;
    private JLabel labelPlasticosNoEnvases;
    private JTextField textFieldPlasticosNoEnvases;
    private JPanel panel15;
    private JLabel labelAluminioNoEnvases;
    private JTextField textFieldAluminioNoEnvase;
    private JPanel panel16;
    private JLabel labelMetalesNoEnvases;
    private JTextField textFieldMetalesNoEnvases;
    private JPanel panel17;
    private JLabel labelMateriaOrganica;
    private JTextField textFieldOrganica;
    private JPanel panel18;
    private JLabel labelJardinPoda;
    private JTextField textFieldJardinPoda;
    private JPanel panel19;
    private JLabel labelFinos;
    private JTextField textFieldFinos;
    private JPanel panel20;
    private JLabel labelCelulosas;
    private JTextField textFieldCelulosa;
    private JPanel panel21;
    private JLabel labelRopa;
    private JTextField textFieldRopa;
    private JPanel panel22;
    private JLabel labelZapatos;
    private JTextField textFieldZapatos;
    private JPanel panel23;
    private JLabel labelMaderaNoEnv;
    private JTextField textFieldMaderaNoEnv;
    private JPanel panel24;
    private JLabel labelVidrio;
    private JTextField textFieldVidrio;
    private JPanel panel25;
    private JLabel labelRAEES;
    private JTextField textFieldRAEES;
    private JPanel panel26;
    private JLabel labelRCD;
    private JTextField textFieldRCD;
    private JPanel panel27;
    private JLabel labelOtros;
    private JTextField textFieldOtros;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // End of variables declaration
}
