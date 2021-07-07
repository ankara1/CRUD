package mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")																//habra veces que no se podra modificar la ruta del @RequestMapping del metodo aun habiendo otro igual en otro controlador, lo cual lanzara una excepcion al ejecutar.. la solucion es establecer una ruta relativa agregando otro @RequestMapping pero arriba de la clase principal   
public class OtroControlador {
	
	@RequestMapping("/formulario")				//el que mapea las vistas o jsps, formulario es la url que devuelve la vista
	public String formulario() {				//generalmente se usa el nombre del metodo como url
		return "formulario";					//nombre del archivo jsp
	}
	
	@RequestMapping("/procesar")				//url para acceder
	public String procesar() {					//nombre metodo
		return "respuesta";						//nombre del archivo vista a devolver
	}
	
	@RequestMapping("/procesar2")				//url a pasar al form action o href
	public String procesar2(@RequestParam("nombre") String nombre, Model modelo) {			//otra forma de hacer lo mismo sin el HttpServletRequest.. @RequestParam es para requerir un parametro y entre parentesis y comillas va el nombre de ese parametro a buscar, luego se puede directamente especificar donde queres guardarlo con un String y a continuacion el modelo
/*	public String procesar2(HttpServletRequest request, Model modelo) {						//paso por parametros un HttpServletRequest para poder usar su metodo para capturar un parametro del formulario y paso un modelo para 
		String nombre = request.getParameter("nombre");		*/								//para capturar el parametro lo tengo que hacer con la clase HttpServletRequest que es la encargada de manejar los datos de los formularios o jsps, guardo en un String el nombre del parametro que quiero rescatar.. en su momento lo llame "nombre" en el formulario.jsp       
		nombre+=" es el mejor alumno";														//al nombre capturado nomas le concatene otro string
		String mensaje = "quien es el mejor alumno? " + nombre;								//cree otro string con una pregunta previa y le agregue el nombre capturado con su concatenacion
		modelo.addAttribute("elmensaje", mensaje);											//con el modelo imaginario cree un id para rescatar el objeto mensaje que contiene el nombre rescatado mas la concatenacion mas la pregunta previa y le di un id "elmensaje"
		return "respuesta";																	//finalmente retorne la pagina jsp respuesta que era la respuesta al formulario, y en la respuesta al final mando a llamar con la jsp tag al id del modelo creado arriba que contiene todo el mensaje
	}

}
