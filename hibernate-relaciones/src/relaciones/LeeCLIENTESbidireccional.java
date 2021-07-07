package relaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LeeCLIENTESbidireccional {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CLIENTES.class).addAnnotatedClass(DETALLESCLIENTES.class).addAnnotatedClass(PEDIDOS.class).buildSessionFactory();
		Session sesion = factory.openSession(); 
		try {
			sesion.beginTransaction();
			DETALLESCLIENTES dc1 = sesion.get(DETALLESCLIENTES.class, 5);					//en un objeto de tipo DETALLESCLIENTES guardo la informacion que me de el id 5 de DETALLESCLIENTES
			if(dc1!=null) { 																//si no hay ninguno con id 5 va a saltar al else										
				System.out.println(dc1.getCLIENTES() + ", " + dc1); 						//ahora la relacion es bidireccional y a partir de el DETALLESCLIENTES con el metodo getCLIENTES y su metodo toString construido me va a devolver toda la informacion del CLIENTES en formato texto y luego despues con una coma y utilizando la variable que guarda el objeto de tipo DETELLESCLIENTES con el id 5, gracias a su metodo toString tambien me va a devolver la informacion en formato texto									//si no es null borra el objeto de la bbdd y como es en cascada tambien borra su otra tabla de detalles
			//	sesion.delete(dc1);															//este es para eliminar el registro de detalles clientes con el id 5, y como es en cascada tambien lo borra de la tabla clientes
				sesion.getTransaction().commit(); 											//commit para ejecutar todas las querys en busca de fallos, si hay alguno, al rollback del catch
				System.out.println("obtencion bidireccional correcta");
			}else {
				System.out.println("no hay ningun objeto con ese id");						//si no hay ningun DETALLESCLIENTES con id 5 imprimira esto
			}
			
		}catch(Exception e) {
			sesion.getTransaction().rollback();												//deshace todas las querys ejecutadas antes de haber encontrado la que contenia el error para que no queden registros incompletos y no ejecute ninguna query leida
			e.printStackTrace();
			System.out.println("algo salio mal en el try");
			
		}finally {
			sesion.close();
			factory.close();
		}

	}

}
