package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PreRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component("Vendedor")
@Scope("singleton")																		//con prototype indicas que cree clones del bean pero no se puede usar prototype para usar metodos init y destroy
public class VendedorEmpleado implements Empleados {
	
	@Autowired
	@Qualifier("elotroinforme")
	private CreacionInforme informe;													//informe a inyectar

/*	@Autowired
	public VendedorEmpleado(CreacionInforme informe) {									//3 formas de inyectar con autowired, por constructor, por setter o metodo y por el campo de clase de la interfaz a inyectar.. con el autowired busca que clase implementa la interfaz y la guarda, luego podemos acceder a los metodos de esa clase
		this.informe = informe;
	}*/
	
/*	@Autowired
	public void setInforme(CreacionInforme informe) {
		this.informe = informe;
	}*/
	
	//-----------------------------------------------------------------------------------------------

	@Override
	public String getTareas() {
		
		return "vender y vender";
	}
	@Override
	public String getInformes() {
		
		return informe.getInformeExtra();
	}
	
	//----------------------------------------------------------------------------------------

	@PostConstruct
	public void init() {															//importante que el metodo init y el metodo destroy no lleven ningun parametro, es una regla general
		System.out.println("aca va el codigo que queres ejecutar antes del bean");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("aca va el codigo que queres ejecutar despues de terminar de usar el bean, generalmente cerrar bases de datos o contextos, etc");
	}
	
	//----------------------------------------------------------------------------------------------
}
