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
import org.simuladorRSU.simulacion.SeparadorBalistico;
import org.simuladorRSU.simulacion.StaticComponents;

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
public class SeparadorBalisticoUI extends JDialog {
    SeparadorBalistico separadorBalistico = StaticComponents.getInstance().getSeparadorBalistico();

    public SeparadorBalisticoUI(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public SeparadorBalisticoUI(Frame owner) {
        super(owner);
        initComponents();
    }

    public SeparadorBalisticoUI(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        separadorBalistico.setTiempo(sliderTiempoProcesamiento.getValue());
        separadorBalistico.setAnguloInclinacion(sliderAngulo.getValue());
        separadorBalistico.setMovimiento(sliderVelocidad.getValue());
        separadorBalistico.setDiametroHuecos(sliderDiametroHuecos.getValue());
        separadorBalistico.setLongitud(sliderLongitud.getValue());
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
        sliderLongitud.setValue(separadorBalistico.getLongitud());
        sliderVelocidad.setValue(separadorBalistico.getMovimiento());
        sliderAngulo.setValue(separadorBalistico.getAnguloInclinacion());
        sliderDiametroHuecos.setValue(separadorBalistico.getDiametroHuecos());
        sliderTiempoProcesamiento.setValue(separadorBalistico.getTiempo());
    }

    private void initComponents() {
        // Component initialization

        contentPanel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        sliderDiametroHuecos = new JSlider();
        sliderVelocidad = new JSlider();
        sliderTiempoProcesamiento = new JSlider();
        label5 = new JLabel();
        sliderLongitud = new JSlider();
        label6 = new JLabel();
        sliderAngulo = new JSlider();
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Separador Balistico");
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
                new LineBorder(new Color(37, 87, 153), 1, true),
                new EtchedBorder()), "Separador Balistico", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));

            //---- label2 ----
            label2.setText("Diametro Huecos (mm)");
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label3 ----
            label3.setText("Velocidad (subir-bajar/s)");
            label3.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Tiempo de procesamiento (ms)");
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderDiametroHuecos ----
            sliderDiametroHuecos.setMinorTickSpacing(2);
            sliderDiametroHuecos.setMajorTickSpacing(10);
            sliderDiametroHuecos.setPaintLabels(true);
            sliderDiametroHuecos.setPaintTicks(true);
            sliderDiametroHuecos.setMinimum(20);
            sliderDiametroHuecos.setBackground(new Color(131, 170, 219));

            //---- sliderVelocidad ----
            sliderVelocidad.setMaximum(10);
            sliderVelocidad.setMinorTickSpacing(1);
            sliderVelocidad.setMajorTickSpacing(3);
            sliderVelocidad.setPaintTicks(true);
            sliderVelocidad.setPaintLabels(true);
            sliderVelocidad.setBackground(new Color(131, 170, 219));
            sliderVelocidad.setMinimum(1);

            //---- sliderTiempoProcesamiento ----
            sliderTiempoProcesamiento.setMaximum(2000);
            sliderTiempoProcesamiento.setMajorTickSpacing(500);
            sliderTiempoProcesamiento.setMinorTickSpacing(100);
            sliderTiempoProcesamiento.setPaintLabels(true);
            sliderTiempoProcesamiento.setPaintTicks(true);
            sliderTiempoProcesamiento.setValue(1000);
            sliderTiempoProcesamiento.setBackground(new Color(131, 170, 219));

            //---- label5 ----
            label5.setText("Longitud (mm)");
            label5.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderLongitud ----
            sliderLongitud.setMaximum(7500);
            sliderLongitud.setMinorTickSpacing(100);
            sliderLongitud.setMajorTickSpacing(500);
            sliderLongitud.setPaintTicks(true);
            sliderLongitud.setPaintLabels(true);
            sliderLongitud.setMinimum(4500);
            sliderLongitud.setBackground(new Color(131, 170, 219));

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
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanel2Layout.createParallelGroup()
                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderLongitud, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanel2Layout.createSequentialGroup()
                                    .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addGroup(contentPanel2Layout.createParallelGroup()
                                        .addComponent(sliderVelocidad, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sliderDiametroHuecos, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sliderAngulo, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            contentPanel2Layout.setVerticalGroup(
                contentPanel2Layout.createParallelGroup()
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderDiametroHuecos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61))
                            .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(sliderVelocidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderAngulo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanel2Layout.createParallelGroup()
                            .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
            );
        }
        contentPane.add(contentPanel2, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration

    private JPanel contentPanel2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JSlider sliderDiametroHuecos;
    private JSlider sliderVelocidad;
    private JSlider sliderTiempoProcesamiento;
    private JLabel label5;
    private JSlider sliderLongitud;
    private JLabel label6;
    private JSlider sliderAngulo;
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    }
