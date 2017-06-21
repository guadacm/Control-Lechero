/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Establecimiento;

import Conexion.Conexion;
import static Menu.Principal.panelDerecha;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guada
 */
public class Produccion extends javax.swing.JPanel {

    /**
     * Creates new form Productor
     */
    int row;

    public Produccion(String codigoA, String codigoE){        
        initComponents();
        Titulo1.setText("Produccíon del Animal (Código: "+codigoA+")");
        codEstab=codigoE;
        volver.setEnabled(true);
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tabla.getModel();
            
            String sql = "SELECT *    " +
                         "FROM produccion " +
                         " WHERE acod ='" +codigoA+ "' ORDER BY fecha";
            
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[5];
            //DecimalFormat a = new DecimalFormat("#0.00");
            while (result.next()) {
                fila[0] = result.getString("fecha");
                fila[1] = result.getString("cantlts");
                fila[2] = result.getString("sng");
                fila[3] = result.getString("densidad");
                fila[4] = result.getString("nroReg");
                m.addRow(fila);
            }
            tabla.setModel(m);
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }

        setEventoMouseClicked(tabla);

        //tabla.addMouseListener(new MouseAdapter());
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tablaMouseClicked(e);
            }
        });
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
        row = tabla.getSelectedRow();
        if (row != -1){
            borrar.setEnabled(true);
            modificar.setEnabled(true);
           
        }else{
            borrar.setEnabled(false);
            modificar.setEnabled(false);
        }
    }
    
    /*   
    public Establecimiento1() {
        initComponents();
        String cadena = "jdbc:postgresql://localhost:5432/PM-ISI";
        String user = "postgres";
        String pass = "boca";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            String nombre, dni, telefono, domicilio;
            String sql = "SELECT * FROM productor ";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                nombre = result.getString("nombre");
                dni = result.getString("dni");
                telefono = result.getString("telefono");
                domicilio = result.getString("domicilio");
                
            }
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        Titulo1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        tablaEstab = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volver = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1000, 499));

        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.setEnabled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        Titulo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo1.setText("Producción del Animal: Código");

        jTextField1.setText("Fecha...");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cantidad de litros", "s.n.g. (en %)", "Densidad (en %)", "NroReg"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setColumnSelectionAllowed(true);
        tablaEstab.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        volver.setText("volver");
        volver.setEnabled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tablaEstab, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(borrar)
                        .addGap(38, 38, 38)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volver))
                    .addComponent(tablaEstab, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Animal panelAnimal = new Animal(codEstab);
        panelAnimal.setSize(1000,599);
        panelAnimal.setLocation(5, 5);
        panelDerecha.removeAll();
        panelDerecha.add(panelAnimal);
        panelDerecha.revalidate();
        panelDerecha.repaint();
        panelAnimal.codigoE = (codEstab);


        // TODO add your handling code here:
    }//GEN-LAST:event_volverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo1;
    private javax.swing.JButton borrar;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modificar;
    public static javax.swing.JTable tabla;
    public static javax.swing.JScrollPane tablaEstab;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
    public String codEstab;
}
