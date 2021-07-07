package relaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import relaciones.CLIENTES;

public class EliminaCLIENTES {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CLIENTES.class).addAnnotatedClass(DETALLESCLIENTES.class).addAnnotatedClass(PEDIDOS.class).buildSessionFactory();
		Session sesion = factory.openSession(); 
		try { 
			sesion.beginTransaction();
			CLIENTES cl1 = sesion.get(CLIENTES.class, 2); 							//creo variable de tipo CLIENTES para almacenar el cliente segun su id.. que en este caso es el id 2, o visto de otra forma.. select * from clientes where idcliente = 2;
																					
			if(cl1!=null) { 														//si no existe ningun cliente con id 2 se almacena null
				System.out.println("eliminando al cliente: " + cl1.getNOMBRE());
				sesion.delete(cl1);  												//si no es null borra el objeto de la bbdd y como es en cascada tambien borra su otra tabla de detalles
				sesion.getTransaction().commit(); 
				System.out.println("eliminado correctamente");
			}else {
				System.out.println("no hay ningun objeto con ese id");
			}
			
		}catch(Exception e) {
			sesion.getTransaction().rollback();												//deshace todas las querys ejecutadas antes de haber encontrado la que contenia el error para que no queden registros incompletos y no ejecute ninguna query leida
			e.printStackTrace();
			System.out.println("algo fallo en el try");
			
		}finally {
			factory.close();
			sesion.close();
		}
	}
}
