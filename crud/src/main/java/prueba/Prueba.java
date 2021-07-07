package prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prueba
 */
@WebServlet("/Prueba")
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/gestionPedidosCRUD?useSSL=false";			//url de mi localhost mysql
		String usuario = "root";															//mi root o usuario sql
		String pass = "";																	//mi password
		String driver = "com.mysql.cj.jdbc.Driver";											//el driver de conexion
		
		try {
			PrintWriter out = response.getWriter();
			out.println("nombre de la bbdd: " + url);
			Class.forName(driver);
			Connection conexion = DriverManager.getConnection(url, usuario, pass);
			out.println("conectado");
			conexion.close();
			
		}catch(Exception e) {
			System.out.println("el try salio mal");
			
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
