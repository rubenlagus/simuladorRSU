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
import org.simuladorRSU.simulacion.TriajeManualPositivo2;

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
public class TriajeManualPositivo2UI extends JDialog {
    TriajeManualPositivo2 triajeManualPositivo1 = StaticComponents.getInstance().getTriajeManualPositivo2();

    public TriajeManualPositivo2UI(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public TriajeManualPositivo2UI(Frame owner) {
        super(owner);
        initComponents();
    }

    public TriajeManualPositivo2UI(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        triajeManualPositivo1.setVelocidad(sliderVelocidad.getValue());
        triajeManualPositivo1.setNumTrabajadores(sliderNumtrabajadores.getValue());
        triajeManualPositivo1.setEfectividad(sliderEfectividad.getValue());
        triajeManualPositivo1.setTiempo(sliderTiempoProcesamiento.getValue());
        setVisible(false);
        if (this.getContentPane() instanceof MainFrame) {
            MainFrame mainFrame = (MainFrame) this.getContentPane();
            if (mainFrame.isPaused()) {
                MasterThread.getInstance().resume();
            }
        }
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        if (this.getContentPane() instanceof MainFrame) {
            MainFrame mainFrame = (MainFrame) this.getContentPane();
            if (mainFrame.isPaused()) {
                MasterThread.getInstance().resume();
            }
        }
        dispose();

    }

    private void thisWindowActivated(WindowEvent e) {
        sliderEfectividad.setValue(triajeManualPositivo1.getEfectividad());
        sliderNumtrabajadores.setValue(triajeManualPositivo1.getNumTrabajadores());
        sliderTiempoProcesamiento.setValue(triajeManualPositivo1.getTiempo());
        sliderVelocidad.setValue(triajeManualPositivo1.getVelocidad());
    }

    private void initComponents() {
        // Component initialization

        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        sliderVelocidad = new JSlider();
        sliderEfectividad = new JSlider();
        sliderNumtrabajadores = new JSlider();
        sliderTiempoProcesamiento = new JSlider();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Triaje Manual Positivo");
        setBackground(new Color(131, 170, 219));
        setAlwaysOnTop(true);
        setResizable(false);
        setModal(true);
        setUndecorated(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new TitledBorder(new CompoundBorder(
                new LineBorder(new Color(37, 87, 153), 1, true),
                new EtchedBorder()), "Triaje Manual Positivo", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));
            dialogPane.setBackground(new Color(131, 170, 219));

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(131, 170, 219));

                //---- label1 ----
                label1.setText("Velocidad Cinta");
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label2 ----
                label2.setText("Efectividad");
                label2.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label3 ----
                label3.setText("Num. Trabajadores");
                label3.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label4 ----
                label4.setText("Tiempo de procesamiento (ms)");
                label4.setHorizontalAlignment(SwingConstants.CENTER);

                //---- sliderVelocidad ----
                sliderVelocidad.setMajorTickSpacing(10);
                sliderVelocidad.setMinorTickSpacing(5);
                sliderVelocidad.setPaintLabels(true);
                sliderVelocidad.setPaintTicks(true);
                sliderVelocidad.setBackground(new Color(131, 170, 219));

                //---- sliderEfectividad ----
                sliderEfectividad.setMinorTickSpacing(5);
                sliderEfectividad.setMajorTickSpacing(10);
                sliderEfectividad.setPaintLabels(true);
                sliderEfectividad.setPaintTicks(true);
                sliderEfectividad.setBackground(new Color(131, 170, 219));

                //---- sliderNumtrabajadores ----
                sliderNumtrabajadores.setMaximum(10);
                sliderNumtrabajadores.setMinorTickSpacing(1);
                sliderNumtrabajadores.setMajorTickSpacing(2);
                sliderNumtrabajadores.setPaintTicks(true);
                sliderNumtrabajadores.setPaintLabels(true);
                sliderNumtrabajadores.setBackground(new Color(131, 170, 219));

                //---- sliderTiempoProcesamiento ----
                sliderTiempoProcesamiento.setMaximum(2000);
                sliderTiempoProcesamiento.setMajorTickSpacing(500);
                sliderTiempoProcesamiento.setMinorTickSpacing(100);
                sliderTiempoProcesamiento.setPaintLabels(true);
                sliderTiempoProcesamiento.setPaintTicks(true);
                sliderTiempoProcesamiento.setBackground(new Color(131, 170, 219));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(sliderEfectividad, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderNumtrabajadores, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderVelocidad, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(34, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(sliderVelocidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sliderEfectividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(61, 61, 61))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sliderNumtrabajadores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(22, 22, 22)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(sliderTiempoProcesamiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap(35, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(35, Short.MAX_VALUE))))
                );
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
                okButton.setText("Aceptar");
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
                cancelButton.setText("Cancelar");
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
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JSlider sliderVelocidad;
    private JSlider sliderEfectividad;
    private JSlider sliderNumtrabajadores;
    private JSlider sliderTiempoProcesamiento;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    }
