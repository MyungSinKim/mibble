/*
 * AboutDialog.java
 *
 * This work is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * This work is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * Copyright (c) 2004-2009 Per Cederberg. All rights reserved.
 */

package net.percederberg.mibble.browser;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * The MIB browser about dialog.
 *
 * @author   Per Cederberg, <per at percederberg dot net>
 * @version  2.5
 * @since    2.3
 */
public class AboutDialog extends JDialog {

    /**
     * The acknowledgements text.
     */
    private static final String ACKNOWLEDGEMENTS =
        "Written by Watsh Rajneesh & Per Cederberg.\n" +
        "Thanks to Charles F. Schatz for a similar effort.\n" +
        "This software uses the Westhawk SNMP Stack.\n" +
        "See http://snmp.westhawk.co.uk/ for info.";

    /**
     * The copyright text.
     */
    private static final String COPYRIGHT =
        "(c) 2004-2009 Per Cederberg. All rights reserved.\n" +
        "This program comes with ABSOLUTELY NO\n" +
        "WARRANTY; for details see the accompanying\n" +
        "license.";

    /**
     * Creates new about dialog.
     *
     * @param parent         the parent frame
     * @param buildInfo      the application build information
     */
    public AboutDialog(JFrame parent, Properties buildInfo) {
        super(parent, true);
        initialize(buildInfo);
        setLocationRelativeTo(parent);
    }

    /**
     * Initializes the dialog components.
     *
     * @param buildInfo      the application build information
     */
    private void initialize(Properties buildInfo) {
        JLabel              label;
        JTextArea           textArea;
        JButton             button;
        GridBagConstraints  c;
        String              str;

        // Set dialog title
        setTitle("About Mibble MIB Browser");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new GridBagLayout());

        // Add header text
        label = new JLabel("Mibble MIB Browser");
        label.setFont(Font.decode("sans bold 20"));
        label.setForeground(new Color(227, 96, 48));
        c = new GridBagConstraints();
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20, 15, 5, 15);
        getContentPane().add(label, c);

        // Add version text
        str = "Version " + buildInfo.getProperty("build.version", "N/A") +
              " (built on " + buildInfo.getProperty("build.date", "N/A") + ")";
        label = new JLabel(str);
        label.setFont(Font.decode("sans bold 12"));
        c = new GridBagConstraints();
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 15, 20, 15);
        getContentPane().add(label, c);

        // Add acknowledgments text
        label = new JLabel("Acknowledgments:");
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        c = new GridBagConstraints();
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 15, 0, 15);
        getContentPane().add(label, c);
        textArea = new JTextArea(ACKNOWLEDGEMENTS);
        textArea.setEditable(false);
        c = new GridBagConstraints();
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 15, 0, 15);
        getContentPane().add(textArea, c);

        // Add copyright text
        label = new JLabel("Copyright & License:");
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        c = new GridBagConstraints();
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 15, 0, 15);
        getContentPane().add(label, c);
        textArea = new JTextArea(COPYRIGHT);
        textArea.setEditable(false);
        c = new GridBagConstraints();
        c.gridy = 5;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 15, 0, 15);
        getContentPane().add(textArea, c);

        // Add license button
        button = new JButton("View License");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLicense();
            }
        });
        c = new GridBagConstraints();
        c.gridy = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0d;
        c.insets = new Insets(20, 15, 10, 15);
        getContentPane().add(button, c);

        // Add close button
        button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0d;
        c.insets = new Insets(20, 15, 10, 15);
        getContentPane().add(button, c);

        // Layout components
        pack();
    }

    /**
     * Closes this dialog and shows the license dialog.
     */
    protected void showLicense() {
        LicenseDialog  dialog = new LicenseDialog((JFrame) getParent());

        dispose();
        dialog.setVisible(true);
    }
}
