package annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration										//con esto le avisamos a spring que este es el archivo remplazo del xml
@ComponentScan("annotations") 						//aca se especifica cual va a ser el paquete que va a contener los beans a guardar y usar
@PropertySource("classpath:datosEmpresa.properties")//esto es para decirle a nuestro archivo de configuracion en donde se encuentra nuestro archivo properties para acceder a variables de forma comoda
public class EmpleadosConfig {

	//definir el bean para CEOEmpleado y uno para el InformeEspecial
	//es un poco mas dificil de ver asi que en xml...
	@Bean													//con esto reservo el bean
	public CreacionInforme informeBean(){					//informeBean es el id del bean, y aca el tipo de dato debe ser la interfaz del informe que implementa la clase y el nombre es indistinto
		return new InformeEspecial();						//instancio directamente dentro del return el InformeEspecial que es el informe que quiero inyectar.. el mismo se va a guardar en el nombre del metodo informeBean
	}
	@Bean
	public Empleados CEOEmpleado() {						//CEOEmpleado es el id del bean, y aca el tipo de dato siempre es la interfaz o la abstraccion, el nombre es indistinto
		return new CEOEmpleado(informeBean());				//aca instancio directamente el CEOEmpleado que es la clase de la cual quiero generar el bean, y su constructor esta preparado para recibir un objeto de tipo CreacionInforme, al cual se le debe de pasar el nombre del metodo que inyecta el informe.. en este caso es informeBean el cual es un InformeEspecial el cual es un CreacionInforme                     
	}
}
