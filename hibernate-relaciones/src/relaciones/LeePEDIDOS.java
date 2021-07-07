package relaciones;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import relaciones.CLIENTES;

public class LeePEDIDOS {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CLIENTES.class).addAnnotatedClass(DETALLESCLIENTES.class).addAnnotatedClass(PEDIDOS.class).buildSessionFactory();
		Session sesion = factory.openSession(); 
		try {
/*			Query<CLIENTES> query = sesion.createQuery("SELECT cl FROM CLIENTES cl JOIN FETCH cl.PEDIDOS WHERE cl.IDCLIENTE=:elclienteid", CLIENTES.class);		//2 formas de pedir informacion a la base de datos.. por medio de lenguaje hql o con mapeo orm.. primero creo un objeto de tipo Query del paquete org.hibernate.query y especifico en el generico el tipo de objeto a manejar de la base de datos que en este caso es un CLIENTES, en lenguaje hql siempre que se quiera obtener informacion hay que dar un alias al objeto a rescatar, en este caso lo llame cl, cl JOIN hace referencia a INNER JOIN porque va a acceder a los datos de otra tabla como es la tabla de PEDIDOS, el FETCH hace referencia a que se establecera un tipo de fetch, que se hace 2 lineas abajo.. y el where id.idclientes=:elclienteid hace referencia a un alias para establecer un valor a pasarle que se le hace en la linea siguiente          
			query.setParameter("elclienteid", 7);																//establece el id en el parametro elclienteid
			CLIENTES cl2 = query.getSingleResult();																//carga toda la informacion simulando un fetchtype eager
*/			
			CLIENTES cl1 = sesion.get(CLIENTES.class, 5);														//el id del cliente que hara los pedidos es el 1 y su clase es CLIENTES.class
			sesion.beginTransaction();
			System.out.println("cliente: " + cl1 + ", y los pedidos que ha hecho son: " + cl1.getPedidos());	//en cl1 esta almacenado el CLIENTES con IDCLIENTE 5 y por el metodo toString si le pido que me imprima el cl1 me va a imprimir la informacion de todos sus campos y luego gracias al metodo getPedidos puedo obtener por medio de la instancia del CLIENTES los PEDIDOS que haya hecho ese CLIENTES gracias a el foreing key IDCLIENTE que esta en ambos campos relacionado
			sesion.getTransaction().commit(); 
			System.out.println("pedido obtenidos correctamente");
			
		}catch(Exception e){
			sesion.getTransaction().rollback();																	//deshace todas las querys ejecutadas antes de haber encontrado la que contenia el error para que no queden registros incompletos y no ejecute ninguna query leida
			e.printStackTrace();
			System.out.println("algo salio mal en el try");
			
		}finally {
			sesion.close();
			factory.close();
		}

	}

}
