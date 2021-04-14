package ejerciciocontroladoresfabricassingletonyobserver.presentacion;

import ejerciciocontroladoresfabricassingletonyobserver.logica.*;
import ejerciciocontroladoresfabricassingletonyobserver.datatypes.*;
import javax.swing.*;

public class FormEmpleado extends javax.swing.JInternalFrame {
    
    public FormEmpleado() {
        initComponents();
    }
    
    private void initComponents() {//GEN-BEGIN:initComponents
        panelCentro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panelSur = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulario de Empleado");
        panelCentro.setLayout(new java.awt.GridLayout(2, 2));

        jLabel2.setText("N\u00famero:");
        panelCentro.add(jLabel2);

        panelCentro.add(txtNumero);

        jLabel3.setText("Nombre:");
        panelCentro.add(jLabel3);

        panelCentro.add(txtNombre);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        btnAgregar.setFont(new java.awt.Font("MS Sans Serif", 1, 11));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        panelSur.add(btnAgregar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        panelSur.add(btnCancelar);

        getContentPane().add(panelSur, java.awt.BorderLayout.SOUTH);

        jLabel1.setFont(new java.awt.Font("MS Sans Serif", 1, 12));
        jLabel1.setText("Datos de un Empleado");
        panelNorte.add(jLabel1);

        getContentPane().add(panelNorte, java.awt.BorderLayout.NORTH);

        pack();
    }//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int numero=0;
        String nombre="";
        String errores = "";
        
        try {
            numero = Integer.parseInt(txtNumero.getText());
        } catch (NumberFormatException e) {
            errores += "Por favor ingrese un Número";
        }
        
        if (txtNombre.getText().equals("")) 
            errores += "\nPor favor ingrese un Nombre";
        else
            nombre = txtNombre.getText();
        
        if (errores.equals("")) {
            // Primero obtenemos una referencia a "alguien" que implemente
            // la interfaz IEmpleados, pues lo que queremos es trabajar con
            // los empleados (en particular queremos agregar uno nuevo).
            IEmpleados manejadorEmpleados = Fabrica.getIEmpleados();
            
            // Luego de obtener esa referencia (que no sabemos de que tipo
            // concreto es) le pedimos que agregue un nuevo empleado ocn
            // los datos ingresados por el usuario.
            manejadorEmpleados.agregarEmpleado(numero, nombre);
            txtNumero.setText("");
            txtNombre.setText("");
        } else {
            JOptionPane.showMessageDialog(this,errores);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    public void mostrarEmpleado(DataEmpleado de) {

        // Al recibir un DataType de empleado, no dependemos de la clase
        // Empleado, solamente de un tipo de dato (DataEmpleado).
        btnAgregar.setEnabled(false);
        txtNumero.setEnabled(false);
        txtNombre.setEnabled(false);
        
        txtNumero.setText(String.valueOf(de.getNumero()));
        txtNombre.setText(de.getNombre());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
    
}
