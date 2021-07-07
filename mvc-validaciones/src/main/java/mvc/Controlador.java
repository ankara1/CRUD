package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
	
	@RequestMapping											//para lo que sirve RequestMapping es para indicar que este metodo debe buscar cual es la vista a mappear
	public String pagina() {
		return "vista";										//en el return va el nombre del archivo de la pagina o vista
	}

}
