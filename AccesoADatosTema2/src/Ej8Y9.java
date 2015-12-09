import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ej8Y9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","root");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			
			System.out.println("INFORMACION SOBRE LA BASE DE DATOS:");
			System.out.println("===================================");
			System.out.println("Nombre : "+nombre);
			System.out.println("Driver : "+driver);
			System.out.println("URL    : "+url);
			System.out.println("Usuario: "+usuario);
			
			resul = dbmd.getTables(null, "departamentos", null, null);
			
			while(resul.next()){
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				
				System.out.println(tipo + " = Catalogo : "+catalogo+ ", Esquema : "+esquema+", Nombre : "+tabla);
				ResultSet columnas = dbmd.getTables(null,"ejemplo","departamentos",null);
				
				while(columnas.next()){
				
					String nombreCol = columnas.getString("COLUMN_NAME");
					String tipoCol = columnas.getString("TYPE_NAME");
					String tamCol = columnas.getString("COLUMN_SIZE");
					String nula = columnas.getString("IS_NULLABLE");
					
					System.out.println("Columna: "+nombreCol+", Tipo: "+tipoCol+", Tamaño: "+tamCol+ ", ¿Puede ser nula:? "+nula);
				}
			}
			conexion.close();
		}
		catch(ClassNotFoundException cn) {cn.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		
	}

}
