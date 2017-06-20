package Conexion;
<<<<<<< HEAD:src/Conexion/Conexion.java

=======
>>>>>>> deed47acd1eb7df373b19a4d0af7b7ca6022c397:src/Conexion/Conexion.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class Conexion {
<<<<<<< HEAD:src/Conexion/Conexion.java
    public static String cadena = "jdbc:postgresql://localhost:5432/PM-ISI";
    public static String user = "postgres";
    public static String pass = "carmen26";

    public static void main(String[] args) {
=======
    
    
   
/*    public static void main(String[] args) {
>>>>>>> deed47acd1eb7df373b19a4d0af7b7ca6022c397:src/Conexion/Conexion.java
        String cadena = "jdbc:postgresql://localhost:5432/PM-ISI";
        String user = "postgres";
        String pass = "boca";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            String sql = "SELECT * FROM prod ";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String usuario = result.getString("nombre");
                //String clave = result.getString("cla_usu");
                System.out.println("User: " + usuario);
            }
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }*/
}
