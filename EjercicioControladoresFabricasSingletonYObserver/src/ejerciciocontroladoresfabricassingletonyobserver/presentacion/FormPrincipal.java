package ejerciciocontroladoresfabricassingletonyobserver.presentacion;

import javax.swing.*;
import ejerciciocontroladoresfabricassingletonyobserver.logica.*;
import ejerciciocontroladoresfabricassingletonyobserver.datatypes.*;

public class FormPrincipal extends javax.swing.JFrame {
    
    public static JDesktopPane escritorio;
    
    public FormPrincipal() {
        initComponents();
        
        // Dejamos disponible en el atributo estático una referencia
        // al DesktopPane para que desde afuera puedan agregar InternalFrames.
        escritorio = this.jDesktopPane1;
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }
    
    private void initComponents() {//GEN-BEGIN:initComponents
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEmpleados = new javax.swing.JMenu();
        menuItemAgregarEmpleado = new javax.swing.JMenuItem();
        menuItemBuscarEmpleado = new javax.swing.JMenuItem();
        menuItemBorrarEmpleado = new javax.swing.JMenuItem();
        menuItemListarEmpleados = new javax.swing.JMenuItem();

        setTitle("Usando Controladores en un Ejemplo Sencillo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        menuEmpleados.setText("Empleados");
        menuItemAgregarEmpleado.setText("Agregar");
        menuItemAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarEmpleadoActionPerformed(evt);
            }
        });

        menuEmpleados.add(menuItemAgregarEmpleado);

        menuItemBuscarEmpleado.setText("Buscar");
        menuItemBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarEmpleadoActionPerformed(evt);
            }
        });

        menuEmpleados.add(menuItemBuscarEmpleado);

        menuItemBorrarEmpleado.setText("Borrar");
        menuItemBorrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBorrarEmpleadoActionPerformed(evt);
            }
        });

        menuEmpleados.add(menuItemBorrarEmpleado);

        menuItemListarEmpleados.setText("Listar");
        menuItemListarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarEmpleadosActionPerformed(evt);
            }
        });

        menuEmpleados.add(menuItemListarEmpleados);

        jMenuBar1.add(menuEmpleados);

        setJMenuBar(jMenuBar1);

        pack();
    }//GEN-END:initComponents

    private void menuItemBorrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBorrarEmpleadoActionPerformed
        int intNumero=0;
        String strNumero = JOptionPane.showInputDialog(this,"Ingrese el número del empleado a borrar");

        if (strNumero==null) return;
        try {
            intNumero = Integer.parseInt(strNumero);
            IEmpleados manejadorEmpleados = Fabrica.getIEmpleados();
            boolean pudoBorrar = manejadorEmpleados.eliminarEmpleado(intNumero);
            if (!pudoBorrar) {
                JOptionPane.showMessageDialog(this,"El empleado no existe.");
            } else {
                JOptionPane.showMessageDialog(this,"El empleado ha sido borrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"ERROR: No se ingresó un número.");
        }
        
    }//GEN-LAST:event_menuItemBorrarEmpleadoActionPerformed

    private void menuItemBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarEmpleadoActionPerformed
        int intNumero=0;
        String strNumero = JOptionPane.showInputDialog(this,"Ingrese el número del empleado a buscar");

        if (strNumero==null) return;
        try {
            intNumero = Integer.parseInt(strNumero);
            IEmpleados manejadorEmpleados = Fabrica.getIEmpleados();
            DataEmpleado de = manejadorEmpleados.obtenerEmpleado(intNumero);
            if (de==null) {
                JOptionPane.showMessageDialog(this,"El empleado no existe.");
            } else {
                FormEmpleado fe = new FormEmpleado();
                jDesktopPane1.add(fe);
                fe.mostrarEmpleado(de);
                fe.show();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"ERROR: No se ingresó un número.");
        }
        
        
    }//GEN-LAST:event_menuItemBuscarEmpleadoActionPerformed

    private void menuItemListarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarEmpleadosActionPerformed
        FormListarEmpleados fle = new FormListarEmpleados();
        jDesktopPane1.add(fle);
        fle.show();
    }//GEN-LAST:event_menuItemListarEmpleadosActionPerformed

    private void menuItemAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarEmpleadoActionPerformed
        FormEmpleado fe = new FormEmpleado();
        jDesktopPane1.add(fe);
        fe.show();
    }//GEN-LAST:event_menuItemAgregarEmpleadoActionPerformed
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    public static void main(String args[]) {
        new FormPrincipal().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenuItem menuItemAgregarEmpleado;
    private javax.swing.JMenuItem menuItemBorrarEmpleado;
    private javax.swing.JMenuItem menuItemBuscarEmpleado;
    private javax.swing.JMenuItem menuItemListarEmpleados;
    // End of variables declaration//GEN-END:variables
    
}
