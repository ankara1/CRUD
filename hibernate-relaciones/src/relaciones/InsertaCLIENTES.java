package relaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import relaciones.CLIENTES;

public class InsertaCLIENTES {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CLIENTES.class).addAnnotatedClass(DETALLESCLIENTES.class).addAnnotatedClass(PEDIDOS.class).buildSessionFactory();		//en el factory se establece tanto la configuracion por medio del archivo cfg.xml como todas las clases o tablas que estan relacionadas en la correspondiente base de datos especificada en el archivo cfg.xml, seguidamente construye el factory         
		Session sesion = factory.openSession(); 																	//utiliza el metodo openSession para realizar operaciones
		try {
			CLIENTES cl1 = new CLIENTES("sergio", "ramos"); 														//como quiero crear un CLIENTES, tengo que pasarle los parametros al constructor, el id es autonumerico
			DETALLESCLIENTES dc1 = new DETALLESCLIENTES(38846959, "elotroemail2@hotmail.com", "avellaneda");		//como tambien quiero agregar los datos en DETALLESCLIENTES creo una instancia la cual debe recibir sus parametros para luego agregar esos datos por medio del set
			cl1.setDetallesclientes(dc1);             															    //el correspondiente set que establece la informacion del DETALLESCLIENTES del nuevo CLIENTES creado
			
			sesion.beginTransaction();																				//arranca la ejecucion de las querys
			sesion.save(cl1);        																				//CLIENTES guardado junto con su correspondiente DETALLESCLIENTES
			sesion.getTransaction().commit(); 																		//ejecuta todas las querys en busca de errores
			System.out.println("insertado correctamente");															//si no hubo errores dira este mensaje, y si no..
		
		}catch(Exception e) {
			sesion.getTransaction().rollback();												//deshace todas las querys ejecutadas antes de haber encontrado la que contenia el error para que no queden registros incompletos y no ejecute ninguna query leida
			e.printStackTrace(); 																					//para ver la pila de llamadas
			System.out.println("fallo el try o el commit");	 														//este es el mensaje que dira si en algo falla el try
		
		}finally {																									//finalmente se cierra la sesion y el factory para no consumir recursos
			factory.close();
			sesion.close();
		}

	}

}
