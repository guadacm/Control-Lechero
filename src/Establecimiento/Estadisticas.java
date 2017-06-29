
package Establecimiento;

import Conexion.Conexion;
import static Menu.Principal.panelDerecha;
import java.awt.Dimension;
import org.jfree.chart.ChartPanel;

public class Estadisticas extends javax.swing.JPanel {
    
    float lts[] = new float[12];
    
    public Estadisticas(int ecod, String s) {
        initComponents();
        Dimension d = panelDerecha.getSize();
        jLabel2.setText("Establecimiento: " + s);
        
        Conexion.obtenerLitrosPorMes(ecod);
        
        float lts[] = new float[12];
        for (int i=0; i<12; i++){
            lts[i] = (float)0.0;
        }
        for(int i=0; i<tablaDE.getRowCount(); i++){
            String fecha = (String) tablaDE.getValueAt(i, 0);
            int mes = 0;
            switch (fecha){
                    case "Enero": mes = 1; break;
                    case "Febrero": mes = 2; break;
                    case "Marzo": mes = 3; break;
                    case "Abrl": mes = 4; break;
                    case "Mayo": mes = 5; break;
                    case "Junio": mes = 6; break;
                    case "Julio": mes = 7; break;
                    case "Agosto": mes = 8; break;
                    case "Septiembre": mes = 9; break;
                    case "Octubre": mes = 10; break;
                    case "Noviembre": mes = 11; break;
                    case "Diciembre": mes = 12; break;
                }
            lts[mes-1] = Float.parseFloat((String) tablaDE.getValueAt(i, 1));
        }
        Grafico g = new Grafico(lts);
        ChartPanel PanelGraf = new ChartPanel(g.grafica);
        Dimension jd = jPanel1.getSize();
        PanelGraf.setSize(jd.width-10, jd.height-10);
        jPanel1.add(PanelGraf);
        jPanel1.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datos = new javax.swing.JScrollPane();
        tablaDE = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();

        setLayout(null);

        tablaDE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes", "Cant. Lts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDE.setMinimumSize(new java.awt.Dimension(150, 0));
        tablaDE.setRowHeight(10);
        tablaDE.setRowSelectionAllowed(false);
        datos.setViewportView(tablaDE);

        add(datos);
        datos.setBounds(30, 90, 230, 310);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(274, 90, 700, 310);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produccion por mes");
        add(jLabel1);
        jLabel1.setBounds(0, 40, 970, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 830, 22);

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver);
        volver.setBounds(880, 440, 63, 23);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Establecimiento.establecimiento panelEstablecimiento = new Establecimiento.establecimiento();
        panelEstablecimiento.setSize(1000,599);
        panelEstablecimiento.setLocation(5, 5);
        panelDerecha.removeAll();
        panelDerecha.add(panelEstablecimiento);
        panelDerecha.revalidate();
        panelDerecha.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_volverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane datos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTable tablaDE;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
