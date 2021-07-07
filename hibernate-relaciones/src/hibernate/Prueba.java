package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class Prueba {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";					//url de mi localhost mysql
		String usuario = "root";															//mi root o usuario sql
		String pass = "";																	//mi password
		
		try {																				//intento esto y si no
			System.out.println("intentando conectar con la bbdd: " + url);
			Connection conexion = DriverManager.getConnection(url, usuario, pass);			//conexion almacenar el resultado de la clase estatica con su metodo al cual hay que pasarle la url, el usuario y el pass
			System.out.println("conecto exitosamente");
		}catch(Exception e) {																//intenta esto otro
			System.out.println("fallo el try");				
			e.printStackTrace();
		}

	}

}
