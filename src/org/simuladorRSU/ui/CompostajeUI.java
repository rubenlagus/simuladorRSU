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

import org.simuladorRSU.simulacion.Compostaje;
import org.simuladorRSU.simulacion.MasterThread;
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
public class CompostajeUI extends JDialog {
    Compostaje compostaje = StaticComponents.getInstance().getCompostaje();

    public CompostajeUI(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public CompostajeUI(Frame owner) {
        super(owner);
        initComponents();
    }

    public CompostajeUI(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        compostaje.setTiempo(sliderTiempoProcesamiento.getValue());
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
        sliderTiempoProcesamiento.setValue(compostaje.getTiempo());
    }

    private void initComponents() {
        // Component initialization
        contentPanel2 = new JPanel();
        label4 = new JLabel();
        sliderTiempoProcesamiento = new JSlider();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Compostaje");
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
                    new EtchedBorder()), "Compostaje", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Dialog", Font.BOLD, 14), new Color(24, 149, 125)));

            //---- label4 ----
            label4.setText("Tiempo de procesamiento (ms)");
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            //---- sliderTiempoProcesamiento ----
            sliderTiempoProcesamiento.setMaximum(2000);
            sliderTiempoProcesamiento.setMajorTickSpacing(500);
            sliderTiempoProcesamiento.setMinorTickSpacing(100);
            sliderTiempoProcesamiento.setPaintLabels(true);
            sliderTiempoProcesamiento.setPaintTicks(true);
            sliderTiempoProcesamiento.setValue(1000);
            sliderTiempoProcesamiento.setBackground(new Color(131, 170, 219));

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

            GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
            contentPanel2.setLayout(contentPanel2Layout);
            contentPanel2Layout.setHorizontalGroup(
                contentPanel2Layout.createParallelGroup()
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            contentPanel2Layout.setVerticalGroup(
                contentPanel2Layout.createParallelGroup()
                    .addGroup(contentPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanel2Layout.createParallelGroup()
                                .addComponent(sliderTiempoProcesamiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))
            );
        }
        contentPane.add(contentPanel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // End of component initialization
    }

    // Variables declaration

    private JPanel contentPanel2;
    private JLabel label4;
    private JSlider sliderTiempoProcesamiento;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // End of variables declaration
}
