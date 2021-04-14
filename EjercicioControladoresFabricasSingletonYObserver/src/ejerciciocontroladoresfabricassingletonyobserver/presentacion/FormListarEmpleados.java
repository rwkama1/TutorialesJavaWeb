package ejerciciocontroladoresfabricassingletonyobserver.presentacion;

import ejerciciocontroladoresfabricassingletonyobserver.logica.*;
import ejerciciocontroladoresfabricassingletonyobserver.datatypes.*;
import javax.swing.*;
import java.util.Vector;

public class FormListarEmpleados extends javax.swing.JInternalFrame implements IObserver {
    
    private DefaultListModel modelo = new DefaultListModel();
    
    public FormListarEmpleados() {
        initComponents();
        
        // Hacemos lo mismo que el caso de agregar empleado.
        IEmpleados manejadorEmpleados = Fabrica.getIEmpleados();
        
        // El vector que nos devuelve, es un vector de DataEmpleado.
        Vector empleados = manejadorEmpleados.devolverColEmpleados();
        
        // Llenamos el model con DataEmpleado que son solo datos!!!
        // Para mostrar un DataEmpleado por línea, se invoca automáticamente
        // al toString() de la clase DataEmpleado.
        for (int i=0; i<empleados.size(); i++) {
            modelo.addElement(empleados.get(i));
        }
        
        // Asociamos el modelo con el JList.
        jList1.setModel(modelo);
        
        // Lo unico que resta es agregar este formulario
        // como un observador de.
        manejadorEmpleados.agregarObservador(this);
    }
    
    private void initComponents() {//GEN-BEGIN:initComponents
        panelCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        panelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelSur = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulario de Listado de Empleados");
        jList1.setPreferredSize(null);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        panelCentro.add(jScrollPane1);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("MS Sans Serif", 1, 12));
        jLabel1.setText("Listado de Empleados");
        panelNorte.add(jLabel1);

        getContentPane().add(panelNorte, java.awt.BorderLayout.NORTH);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        panelSur.add(btnCerrar);

        getContentPane().add(panelSur, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount()==2) {        
            DataEmpleado de = (DataEmpleado)modelo.get(jList1.getSelectedIndex());
            FormEmpleado fe = new FormEmpleado();
            FormPrincipal.escritorio.add(fe);
            fe.mostrarEmpleado(de);  
            fe.show();
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    
    // Este es el método que invoca la Capa Lógica cada vez que alguien
    // agrega un nuevo empleado. Los datos del nuevo empleado están en "de"
    public void update(DataEmpleado de) {
        modelo.addElement(de);
    }    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    // End of variables declaration//GEN-END:variables
    
}
