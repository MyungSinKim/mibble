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
 * As a special exception, the copyright holders of this library give
 * you permission to link this library with independent modules to
 * produce an executable, regardless of the license terms of these
 * independent modules, and to copy and distribute the resulting
 * executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the
 * license of that module. An independent module is a module which is
 * not derived from or based on this library. If you modify this
 * library, you may extend this exception to your version of the
 * library, but you are not obligated to do so. If you do not wish to
 * do so, delete this exception statement from your version.
 *
 * Copyright (c) 2004 Watsh Rajneesh. All rights reserved.
 */

package net.percederberg.mibble.browser;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The MIB browser about dialog.
 *
 * @author   Watsh Rajneesh
 * @version  2.3
 * @since    2.3
 */
public class AboutDialog extends JDialog {

    /**
     * The about dialog text.
     */
    private static final String TEXT = 
        "Mibble MIB Browser\n" +
        "~~~~~~~~~~~~~~\n\n\n" +
        "Author: Watsh Rajneesh\n\n" +
        "Acknowledgements: \n" +
        "This software uses the Westhawk SNMP Stack.\n" +
        "See http://snmp.westhawk.co.uk/ for more info.\n\n\n" +
        "Thanks for using this software.\n\n" +
        "----------------------------------\n" +
        "rwatsh@hp.com\nDec 15th, 2003.";

    /**
     * Creates new about dialog.
     *
     * @param parent         the parent frame
     * @param modal          the modal flag
     */
    public AboutDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /* Size the frame */
        this.setSize(300, 400);

        /* Center the frame */
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frameDim = getBounds();
        setLocation((screenDim.width - frameDim.width) / 2,
                    (screenDim.height - frameDim.height) / 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        aboutScrollPane = new JScrollPane();
        aboutTextArea = new JTextArea();

        setTitle("About...");
        setModal(true);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });

        aboutTextArea.setEditable(false);
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setText(TEXT);
        aboutTextArea.setWrapStyleWord(true);
        aboutScrollPane.setViewportView(aboutTextArea);

        getContentPane().add(aboutScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    /** Closes the dialog */
    void closeDialog(WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane aboutScrollPane;
    private javax.swing.JTextArea aboutTextArea;
    // End of variables declaration//GEN-END:variables
}
