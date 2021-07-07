package dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDAO {											//esta es la clase que sera el aspecto, adentro del metodo insertar deberia estar la logica para conectar con la bbdd y el codigo necesario para agregar un nuevo cliente a la base de datos, pero por ahora le voy a mandar un system.out.print para comprobar que funciona el aspecto

	public void insertar() {
		System.out.println("registro insertado \n");
		
	}
}
