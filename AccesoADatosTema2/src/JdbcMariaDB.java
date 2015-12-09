import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcMariaDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ejemplo","root","root");
			
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");
			
			while(resul.next()){
				System.out.println(resul.getInt(1) + " " + resul.getString(2));
			}
			
			resul.close();
			sentencia.close();
			conexion.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
