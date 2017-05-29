
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Conexion {

    public static void main(String[] args) {
        String cadena = "jdbc:postgresql://localhost:5432/PM-ISI";
        String user = "postgres";
        String pass = "boca";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            String sql = "SELECT * FROM productor ";
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
    }
}
