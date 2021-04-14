/*
 * FormPrincipal.java
 *
 * Created on 15 de septiembre de 2005, 17:36
 */

package ejerciciostate.presentacion;

import ejerciciostate.logica.*;

/**
 *
 * @author  Administrador
 */
public class FormPrincipal extends javax.swing.JFrame implements IObserver {
    
    /** Creates new form FormPrincipal */
    public FormPrincipal() {
        initComponents();
        
        ISistema is = Fabrica.getISistema();
        is.agregarObservador(this);
        txtHora.setText(is.consultarHora());
    }
    
    public void update(String nuevaHora) {
        txtHora.setText(nuevaHora);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        txtHora = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnA = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Probando State");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        txtHora.setEditable(false);
        jPanel1.add(txtHora);

        btnA.setText("A");
        btnA.setToolTipText("Presione aqu\u00ed para cambiar de modo");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        jPanel2.add(btnA);

        btnB.setText("B");
        btnB.setToolTipText("Presione aqu\u00ed para modificar dependiendo del modo");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        jPanel2.add(btnB);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Hora Actual:");
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        pack();
    }//GEN-END:initComponents

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        ISistema is = Fabrica.getISistema();
        is.presionarB();
    }//GEN-LAST:event_btnBActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        ISistema is = Fabrica.getISistema();
        is.presionarA();
    }//GEN-LAST:event_btnAActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new FormPrincipal().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
    
}