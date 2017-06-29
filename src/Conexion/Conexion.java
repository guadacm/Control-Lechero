package Conexion;

import Establecimiento.AltaEstablecimiento;
import static Establecimiento.Animal.tablaA;
import static Establecimiento.Estadisticas.tablaDE;
import static Establecimiento.Produccion.tablaPA;
import static Establecimiento.establecimiento.tablaE;
import static Productor.GestionarProductor.tablaP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Conexion {
    // Constantes de Conexion a la Baase de datos
    public static String cadena = "jdbc:postgresql://localhost:5432/PM-ISI";
    public static String user = "postgres";
    public static String pass = "carmen26";
    
    public static void listarProductor(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tablaP.getModel();

            String sql = "SELECT * FROM productor ORDER BY nombre";
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[5];
            while (result.next()) {
                fila[0] = result.getString("nombre");
                fila[1] = result.getString("dni");
                fila[2] = result.getString("telefono");
                fila[3] = result.getString("domicilio");
                fila[4] = result.getString("pcod");
                m.addRow(fila);
            }
            tablaP.setModel(m);
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void agregarProductor(String dni, String nombre, String telefono, String domicilio){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();

            String sql = "INSERT INTO productor ( dni,nombre,telefono,domicilio)"+
            " VALUES ('"+dni+"', '"+nombre+"', '"+telefono+"', '"+domicilio+"');";

            //String sql = "INSERT INTO productor ( pcod,dni,nombre,telefono,domicilio) "
            //        + " VALUES ('PR032', '33456453', 'Clon de Raul', '266415789', 'BELGRANO 1355');";

            ResultSet result = st.executeQuery(sql);
           
            st.close();
            conex.close();
        } 
        catch (Exception exc) {
            String m,e;
            m = "ERROR: llave duplicada viola restricción de unicidad «productor_dni_key»\n" +
            "  Detail: Ya existe la llave (dni)=("+dni+").";
            e =exc.getMessage();
            System.out.println("Errorx:" + e);
            if (e.equals(m)){ 
                System.out.println("Error de dni repetido" ); 
            }
            else{
            try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();

            String sql = "SELECT pcod FROM productor WHERE dni='" + dni + "';";

            //String sql = "INSERT INTO productor ( pcod,dni,nombre,telefono,domicilio) "
            //        + " VALUES ('PR032', '33456453', 'Clon de Raul', '266415789', 'BELGRANO 1355');";

            //ResultSet result = st.executeQuery(sql);
            ResultSet result = st.executeQuery(sql);
            System.out.println(result);
            String cod ;//= result.getString("pcod");
            if (result.next()){
                cod = result.getString("pcod");
            
            
                AltaEstablecimiento nueva = new Establecimiento.AltaEstablecimiento();
                nueva.setVisible(true);
                nueva.setLocationRelativeTo(null);            
                nueva.campoPcod.setText(cod);
            }
            
            st.close();
            conex.close();
            
            
        
        } catch (Exception exc1) {
            System.out.println("Errorx:" + exc1.getMessage());
        }

                
            }
        }
    }
    
    public static void editarProductor(String nombre, String telefono, String domicilio, String dni, int pcod){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            
            String sql = "UPDATE productor SET nombre='" + nombre + "', telefono='"
                    + telefono + "', domicilio='" + domicilio + "', dni='" + dni
                    + "' WHERE pcod=" + pcod + ";";
            //String sql = "INSERT INTO productor ( dni,nombre,telefono,domicilio)"+
            //" VALUES ('"+dni+"', '"+nombre+"', '"+telefono+"', '"+domicilio+"');";

            //String sql = "INSERT INTO productor ( pcod,dni,nombre,telefono,domicilio) "
            //        + " VALUES ('PR032', '33456453', 'Clon de Raul', '266415789', 'BELGRANO 1355');";

            ResultSet result = st.executeQuery(sql);
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void eliminarProductor(int pcodBorrar){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            
            String sql = "DELETE FROM establecimiento WHERE pcod=" + pcodBorrar
                    + "; DELETE FROM productor WHERE pcod=" + pcodBorrar +";";

            ResultSet result = st.executeQuery(sql);
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void listarEstablecimiento(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tablaE.getModel();

            String sql = "SELECT establecimiento.nombre, ubicacion, ecod, productor.nombre as pnombre \n" +
                         "FROM establecimiento, productor \n" +
                         "WHERE establecimiento.pcod = productor.pcod ORDER BY establecimiento.nombre";
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[4];
            while (result.next()) {
                fila[0] = result.getString("nombre");
                fila[1] = result.getString("ubicacion");
                fila[2] = result.getString("pnombre");
                fila[3] = result.getString("ecod");
                m.addRow(fila);
            }
            tablaE.setModel(m);
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void altaEstablecimiento(String nombre, int pCod, String ubicacion){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();

            String sql = "INSERT INTO establecimiento (nombre,ubicacion,pcod)"+
            " VALUES ('"+nombre+"', '"+ubicacion+"', '"+pCod+"');";

            //String sql = "INSERT INTO prod ( pcod,dni,nombre,telefono,domicilio) "
            //        + " VALUES ('PR032', '33456453', 'Clon de Raul', '266415789', 'BELGRANO 1355');";

            ResultSet result = st.executeQuery(sql);
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void listarAnimal(String codigoE){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tablaA.getModel();
            
            String sql = "SELECT *    " +
                         "FROM animal " +
                         " WHERE ecod ='" +codigoE+ "' ORDER BY raza";
            
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[4];
            while (result.next()) {
                fila[0] = result.getString("raza");
                fila[1] = result.getString("fechanac");
                fila[2] = result.getString("peso");
                fila[3] = result.getString("acod");
                m.addRow(fila);
            }
            tablaA.setModel(m);
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void altaAnimal(String raza, float peso, String fechaNac, int eCod){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();

            String sql = "INSERT INTO animal (raza,fechanac,peso,ecod)"
                    + " VALUES ('" + raza + "', '" + fechaNac + "', '" + peso + "', '" + eCod +"');";
            ResultSet result = st.executeQuery(sql);
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void listarProduccion(String codigoA){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tablaPA.getModel();
            
            String sql = "SELECT *    " +
                         "FROM produccion " +
                         " WHERE acod ='" +codigoA+ "' ORDER BY fecha";
            
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[5];
            while (result.next()) {
                fila[0] = result.getString("fecha");
                fila[1] = result.getString("cantlts");
                fila[2] = result.getString("sng");
                fila[3] = result.getString("densidad");
                fila[4] = result.getString("nroReg");
                m.addRow(fila);
            }
            tablaPA.setModel(m);
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    
    public static void registrarProduccion(String fecha, float cantlts, float sng, float densidad, int acod){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();

            String sql = "INSERT INTO produccion (fecha,cantlts,sng,densidad,acod)"
                    + " VALUES ('" + fecha + "', '" + cantlts + "', '" + sng + "', '" + densidad +"', '" + acod +"');";
            ResultSet result = st.executeQuery(sql);
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }

    public static void obtenerLitrosPorMes(int eCod){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(Conexion.cadena, Conexion.user, Conexion.pass);
            java.sql.Statement st = conex.createStatement();
            DefaultTableModel m = (DefaultTableModel) tablaDE.getModel();
            
            String sql = "SELECT EXTRACT(MONTH FROM fecha) AS fecha, SUM(cantlts)\n" +
                    "FROM produccion, animal, establecimiento\n" +
                    "WHERE (produccion.acod=animal.acod AND animal.ecod=establecimiento.ecod)AND establecimiento.ecod=" + eCod + "\n" +
                    "GROUP BY (EXTRACT(MONTH FROM fecha));";
            
            ResultSet result = st.executeQuery(sql);
            String fila[] = new String[2];
            while (result.next()) {
                fila[0] = result.getString("fecha");
                fila[1] = result.getString("sum");
                switch (Integer.parseInt(fila[0])){
                    case 1: fila[0] = "Enero"; break;
                    case 2: fila[0] = "Febrero"; break;
                    case 3: fila[0] = "Marzo"; break;
                    case 4: fila[0] = "Abril"; break;
                    case 5: fila[0] = "Mayo"; break;
                    case 6: fila[0] = "Junio"; break;
                    case 7: fila[0] = "Julio"; break;
                    case 8: fila[0] = "Agosto"; break;
                    case 9: fila[0] = "Septiembre"; break;
                    case 10: fila[0] = "Octubre"; break;
                    case 11: fila[0] = "Noviembre"; break;
                    case 12: fila[0] = "Diciembre"; break;
                }
                m.addRow(fila);
            }
            tablaDE.setModel(m);            
            result.close();
            st.close();
            conex.close();
            
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
}