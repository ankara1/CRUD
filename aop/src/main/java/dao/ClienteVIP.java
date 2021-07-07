package dao;

import org.springframework.stereotype.Component;

import aop.Cliente;

@Component("BeanVIP")
public class ClienteVIP {											//esta es la clase que sera el aspecto, adentro del metodo insertar deberia estar la logica para conectar con la bbdd y el codigo necesario para agregar un nuevo cliente a la base de datos, pero por ahora le voy a mandar un system.out.print para comprobar que funciona el aspecto

	private String valoracion;
	private String codigo;
	
//----------------------------------------------------------------------------------------------------------
	
	public void insertar(Cliente cl, String tipo) {
		System.out.println("este es un cliente vip y sera insertado despues de la comprobacion del login hecho en el aspecto \n");
	}
	
//-----------------------------------------------------------------------------------------------------------

	public String getValoracion() {
		System.out.println("este es el get de valoracion");
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		System.out.println("este es el set para establecer una valoracion");
		this.valoracion = valoracion;
	}

	public String getCodigo() {
		System.out.println("este es el get del codigo");
		return codigo;
	}

	public void setCodigo(String codigo) {
		System.out.println("este es el set para establecer un codigo");
		this.codigo = codigo;
	}
	
//-------------------------------------------------------------------------------------------------
	
}
