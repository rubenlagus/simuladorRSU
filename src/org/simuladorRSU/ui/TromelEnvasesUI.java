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
import org.simuladorRSU.simulacion.TromelEnvases;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Ruben Bermudez
 */
public class TromelEnvasesUI extends JDialog {
    TromelEnvases tromelEnvases = StaticComponents.getInstance().getTromelEnvases();

    public TromelEnvasesUI(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public TromelEnvasesUI(Frame owner) {
        super(owner);
        initComponents();
    }

    public TromelEnvasesUI(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        tromelEnvases.setTiempo(sliderTiempoProcesamiento.getValue());
        tromelEnvases.setAngulo(sliderAngulo.getValue());
        tromelEnvases.setDiametro(sliderDiametro.getValue());
        tromelEnvases.setDiametroGrandes(sliderDiametroHuecosGrandes.getValue());
        tromelEnvases.setDiametroPequenios(sliderDiametroHuecosPequenios.getValue());
        tromelEnvases.setLongitudGrandes(sliderLongitudHuecosGrandes.getValue());
        tromelEnvases.setLongitudPequenios(sliderLongitudHuecosPequenios.getValue());
        tromelEnvases.setVelocidadGiro(sliderVelGiro.getValue());
        setVisible(false);
        if (this.getParent() instanceof MainFrame) {
            MainFrame mainFrame = (MainFrame) this.getParent();
            if (mainFrame.isPaused()) {
                MasterThread.getInstance().resume();
            }
        }
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        if (this.getParent() instanceof MainFrame) {
            MainFrame mainFrame = (MainFrame) this.getParent();
            if (mainFrame.isPaused()) {
                MasterThread.getInstance().resume();
            }
        }
        dispose();
    }

    private void thisWindowActivated(WindowEvent e) {
        sliderLongitudHuecosGrandes.setValue(tromelEnvases.getLongitudGrandes());
        sliderLongitudHuecosPequenios.setValue(tromelEnvases.getLongitudPequenios());
        sliderDiametroHuecosGrandes.setValue(tromelEnvases.getDiametroGrandes());
        sliderDiametroHuecosPequenios.setValue(tromelEnvases.getDiametroPequenios());
        sliderVelGiro.setValue(tromelEnvases.getVelocidadGiro());
        sliderDiametro.setValue(tromelEnvases.getDiametro());
        sliderAngulo.setValue(tromelEnvases.getAngulo());
        sliderTiempoProcesamiento.setValue(tromelEnvases.getTiempo());
    }

    private void initComponents() {
        // Component initialization

        contentPanel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        sliderDiametro = new JSlider();
        sliderDiametroHuecosPequenios = new JSlider();
        sliderVelGiro = new JSlider();
        sliderTiempoProcesamiento = new JSlider();
        label5 = new JLabel();
        sliderLongitudHuecosGrandes = new JSlider();
        label6 = new JLabel();
        sliderAngulo = new JSlider();
        label7 = new JLabel();
        sliderDiametroHuecosGrandes = new JSlider();
        label8 = new JLabel();
        sliderLongitudHuecosPequenios = new JSlider();
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Tromel de Envases");
        setBackground(new Color(131, 170, 219));
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);
        setUndecorated(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== contentPanel2 ========
        {
            contentPanel2.setBackground(new Color(131, 170, 219));

            contentPanel2.setBorder(new TitledBorder(new CompoundBorder(
                    new LineBorder(new Color(23, 87, 153), 1, true),
                    new EtchedBorder()), "Tromel de Envases", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));

            //---- label1 ----
            label1.setText("Diametro Cilindro (mm)");
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Diametro Huecos Peque\u00f1os (mm)");
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label3 ----
            label3.setText("Vel. Giro (rpm)");
            label3.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Tiempo de procesamiento (ms)");
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderDiametro ----
            sliderDiametro.setMajorTickSpacing(500);
            sliderDiametro.setMinorTickSpacing(100);
            sliderDiametro.setPaintLabels(true);
            sliderDiametro.setPaintTicks(true);
            sliderDiametro.setMaximum(3500);
            sliderDiametro.setMinimum(1500);
            sliderDiametro.setBackground(new Color(131, 170, 219));

            //---- sliderDiametroHuecosPequenios ----
            sliderDiametroHuecosPequenios.setMinorTickSpacing(5);
            sliderDiametroHuecosPequenios.setMajorTickSpacing(50);
            sliderDiametroHuecosPequenios.setPaintLabels(true);
            sliderDiametroHuecosPequenios.setPaintTicks(true);
            sliderDiametroHuecosPequenios.setMinimum(100);
            sliderDiametroHuecosPequenios.setMaximum(300);
            sliderDiametroHuecosPequenios.setBackground(new Color(131, 170, 219));

            //---- sliderVelGiro ----
            sliderVelGiro.setMaximum(20);
            sliderVelGiro.setMinorTickSpacing(1);
            sliderVelGiro.setMajorTickSpacing(5);
            sliderVelGiro.setPaintTicks(true);
            sliderVelGiro.setPaintLabels(true);
            sliderVelGiro.setMinimum(5);
            sliderVelGiro.setBackground(new Color(131, 170, 219));

            //---- sliderTiempoProcesamiento ----
            sliderTiempoProcesamiento.setMaximum(2000);
            sliderTiempoProcesamiento.setMajorTickSpacing(500);
            sliderTiempoProcesamiento.setMinorTickSpacing(100);
            sliderTiempoProcesamiento.setPaintLabels(true);
            sliderTiempoProcesamiento.setPaintTicks(true);
            sliderTiempoProcesamiento.setValue(1000);
            sliderTiempoProcesamiento.setBackground(new Color(131, 170, 219));

            //---- label5 ----
            label5.setText("Longitud Huecos Grandes (mm)");
            label5.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderLongitudHuecosGrandes ----
            sliderLongitudHuecosGrandes.setMaximum(5000);
            sliderLongitudHuecosGrandes.setMinorTickSpacing(100);
            sliderLongitudHuecosGrandes.setMajorTickSpacing(500);
            sliderLongitudHuecosGrandes.setPaintTicks(true);
            sliderLongitudHuecosGrandes.setPaintLabels(true);
            sliderLongitudHuecosGrandes.setMinimum(1000);
            sliderLongitudHuecosGrandes.setBackground(new Color(131, 170, 219));

            //---- label6 ----
            label6.setText("Angulo (\u00ba)");
            label6.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderAngulo ----
            sliderAngulo.setMaximum(83);
            sliderAngulo.setMinorTickSpacing(1);
            sliderAngulo.setMajorTickSpacing(10);
            sliderAngulo.setPaintTicks(true);
            sliderAngulo.setPaintLabels(true);
            sliderAngulo.setMinimum(3);
            sliderAngulo.setBackground(new Color(131, 170, 219));

            //---- label7 ----
            label7.setText("Diametro Huecos Grandes (mm)");
            label7.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderDiametroHuecosGrandes ----
            sliderDiametroHuecosGrandes.setMinorTickSpacing(5);
            sliderDiametroHuecosGrandes.setMajorTickSpacing(50);
            sliderDiametroHuecosGrandes.setPaintLabels(true);
            sliderDiametroHuecosGrandes.setPaintTicks(true);
            sliderDiametroHuecosGrandes.setMinimum(300);
            sliderDiametroHuecosGrandes.setMaximum(500);
            sliderDiametroHuecosGrandes.setBackground(new Color(131, 170, 219));

            //---- label8 ----
            label8.setText("Longitud Huecos Peque\u00f1os (mm)");
            label8.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderLongitudHuecosPequenios ----
            sliderLongitudHuecosPequenios.setMinorTickSpacing(100);
            sliderLongitudHuecosPequenios.setMajorTickSpacing(500);
            sliderLongitudHuecosPequenios.setPaintLabels(true);
            sliderLongitudHuecosPequenios.setPaintTicks(true);
            sliderLongitudHuecosPequenios.setMinimum(1000);
            sliderLongitudHuecosPequenios.setMaximum(5000);
            sliderLongitudHuecosPequenios.setBackground(new Color(131, 170, 219));

            //======== dialogPane ========
            {
                dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
                dialogPane.setBackground(new Color(131, 170, 219));
                dialogPane.setLayout(new BorderLayout());

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
                    okButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            okButtonActionPerformed(e);
                        }
                    });
                    buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- cancelButton ----
                    cancelButton.setText("Cancel");
                    cancelButton.setBackground(new Color(146, 138, 223));
                    cancelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cancelButtonActionPerformed(e);
                        }
                    });
                    buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                dialogPane.add(buttonBar, BorderLayout.SOUTH);
            }

            GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
            contentPanel2.setLayout(contentPanel2Layout);
            contentPanel2Layout.setHorizontalGroup(
                contentPanel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                            .addContainerGap(46, Short.MAX_VALUE)
                            .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(contentPanel2Layout.createSequentialGroup()
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sliderAngulo, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPanel2Layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPanel2Layout.createSequentialGroup()
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sliderVelGiro, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                            .addGap(37, 37, 37))
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(sliderLongitudHuecosGrandes, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPanel2Layout.createParallelGroup()
                                                        .addGroup(contentPanel2Layout.createSequentialGroup()
                                                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(contentPanel2Layout.createParallelGroup()
                                                                        .addComponent(sliderDiametro, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sliderDiametroHuecosGrandes, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sliderDiametroHuecosPequenios, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(contentPanel2Layout.createSequentialGroup()
                                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sliderLongitudHuecosPequenios, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            contentPanel2Layout.setVerticalGroup(
                contentPanel2Layout.createParallelGroup()
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                        .addComponent(sliderDiametro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(sliderDiametroHuecosPequenios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(sliderDiametroHuecosGrandes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderLongitudHuecosPequenios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderLongitudHuecosGrandes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderVelGiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderAngulo, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                            .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        contentPane.add(contentPanel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration

    private JPanel contentPanel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JSlider sliderDiametro;
    private JSlider sliderDiametroHuecosPequenios;
    private JSlider sliderVelGiro;
    private JSlider sliderTiempoProcesamiento;
    private JLabel label5;
    private JSlider sliderLongitudHuecosGrandes;
    private JLabel label6;
    private JSlider sliderAngulo;
    private JLabel label7;
    private JSlider sliderDiametroHuecosGrandes;
    private JLabel label8;
    private JSlider sliderLongitudHuecosPequenios;
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    }
