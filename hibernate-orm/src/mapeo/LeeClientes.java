package mapeo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LeeClientes {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();     //con configure indico cual es el archivo de configuracion xml, con addAnotatedClass agrego la clase que va a contener a los clientes a agregar y buildsesion lo construye todo                   
		Session sesion = factory.openSession(); 																		//para abrir la sesion
		
		try {
			sesion.beginTransaction();
	//		List<Clientes> clientes = sesion.createQuery("from Clientes").getResultList();								//cree un list que es un array del paquete java util en el cual me pide un generico, osea, cualquier clase de objeto que quiera almacenar en ese array, en este caso clientes de la base de datos.. con sesion.createQuery realizo la consulta en lenguaje hql, muy similar a sql, "from Clientes" es igual a SELECT FROM Clientes y con el metodo getResultList obtengo todos los resultados y los guardo en formato List
			
			List<Clientes> clientes = sesion.createQuery("from Clientes cl where cl.SUELDO >= 40000").getResultList();	//cuando se quiere ser mas especifico, en formato hql se le debe dar un alias al campo a rescatar, en mi caso cl, haciendo referencia al cliente y luego "where cl." para acceder no al nombre de la tabla sino al nombre del campo o variable de la clase Clientes.java, en este caso se llama igual pero rescata ese parametro como si fuera un objeto
			lecturaClientes(clientes);
			
			List<Clientes> clientes1 = sesion.createQuery("from Clientes cl where cl.APELLIDO='guido' or cl.APELLIDO='lopez'").getResultList();	
			lecturaClientes(clientes1);
			
			sesion.getTransaction().commit();																			//el commit lo que hace es ejecutar todas las query programadas en bloque, si hay un fallo saltara al catch y hara un rollback para deshacer todas las querys
			System.out.println("lectura terminada");
			
		}catch(Exception e) {
			sesion.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("no se grabo nada porque algo fallo en el try");
			
		}finally {
			sesion.close();
			factory.close();
		}
	}

	private static void lecturaClientes(List<Clientes> clientes) {
		for (Clientes clientetemp : clientes) {																		//con un foreach indico la clase de objetos que contiene el array, en este caso son Clientes, en el segundo la variable a guardar cada vuelta, (puede ser cualquiera) y en el tercero le paso el arraylist a recorrer
			System.out.println(clientetemp);																		//a cada vuelta imprimira el cliente guardado en la bbdd y se leera toda la informacion gracias al metodo toString
		}
	}

}
