package mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller																									//controlador
@RequestMapping("/alumno")																					//ruta relativa
public class AlumnoControlador {

	@RequestMapping("/formulario")																			//ruta url a redireccionar para llamar a este metodo
	public String formularioAlumno(Model modelo) {															//objeto model para manipular o agregar atributos
		
		Alumno alumno1 = new Alumno();																		//nuevo alumno a registrar
		modelo.addAttribute("elalumno", alumno1);															//id agregada para obtener al alumno nuevo como si fuera un getter
		return "registro";																					//jsp a retornar al llamar a este metodo
	}
	
	@RequestMapping("/procesar")																			//ruta url a redireccionar para llamar a este medoto
	public String procesar(@Valid @ModelAttribute("elalumno") Alumno alumno1, BindingResult result) {		//@Valid para indicar que va a contener una validacion, @ModelAttribute para simplificar agregando el id que le quiero dar al alumno y lo guardo en un objeto de tipo alumno, BindingResult para que se guarden es esta variable los resultados de la validacion      
		if(result.hasErrors()) {																			//si hay errores en el bindingresult, me va a devolver la misma pagina
			return "registro";
		}else {																								//si no hay errores, me va a enviar a la pagina final de registrado.jsp
			return "registrado";																			//jsp a retornar al llamar a este metodo y encontrar que no hay errores
		}
	}
	
	@InitBinder																								//esta annotation es leida automaticamente como si fuera un autowired, y es para corregir el error de caracteres en blanco en la validacion de formularios
	public void miBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);										//esta clase es para poder true o false si quiero o no quiero que tome los vacios o espacios en blanco como null
		binder.registerCustomEditor(String.class, trimmer);													//WebDataBinder tiene este metodo al cual le tenes que pasar por parametro el tipo de dato a recortar y el StringTrimmerEditor con el true o false indicado
	}
}