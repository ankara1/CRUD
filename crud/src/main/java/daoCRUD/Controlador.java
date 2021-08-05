package daoCRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.CRUD;

@Controller
@RequestMapping("/proyecto")																								//se debe especificar en los href de los jsp a que redireccionamiento nos manda con el click, a proyecto/lista, manda a llamar al metodo con el requestMapping /lista que es el primero de abajo
public class Controlador {
	
	@Autowired
	private ClienteDAO elDAO;																								//creo instancia de la interfaz que implementa el DAO para ponerle el autowired y me haga reconocimiento automatico
	
	@RequestMapping("/lista")
	public String lista(Model modelo) {																						//esto recibe un model pero no estoy muy seguro de que es aun
		List<CRUD> losclientes=elDAO.getCRUD();																				//almaceno dentro de este List losclientes el CRUD con todos los registros del CRUD para luego recorrerlos con un bucle forEach desde la pagina de la vista, el metodo getCRUD esta desarrollado en la clase que implementa la interfaz ClienteDAO
		modelo.addAttribute("losclientes", losclientes);																	//el primero es el id a rescatar y el segundo es la lista de clientes del CRUD
		return "lista";
	}
	
	@RequestMapping("/agregar")
	public String agregar(Model modelo) {
		CRUD crud = new CRUD();																								//nuevo objeto del tipo de la clase CRUD para insertar en la base de datos
		modelo.addAttribute("addcliente", crud);																			//su id rescatable y el objeto que lo representa
		return "AgregarCRUD";																								//nombre de la jsp que va a devolver
	}
	
	@PostMapping("/insertado")																								//aun no se la diferencia entre PostMapping y RequestMapping
	public String insertar(@ModelAttribute("addcliente") CRUD elcrud) {														//este modelAttribute es para pasar la informacion dentro de las etiquetas form:form del jsp AgregarCRUD.jsp que contiene el modelAttribute con id "addcliente" y lo almaceno en un objeto de tipo CRUD
		elDAO.insertado(elcrud);																							//utilizo el nombre de la instancia del ClienteDAO creada arriba de todo para crear el metodo insertar que sera creado en la interfaz e implementado por la clase DAO y propiamente rellenado
		return "redirect:/proyecto/lista";
	}
	
	@GetMapping("/actualizar")																								//aun no se la diferencia entre PostMapping y RequestMapping
	public String actualizar(@RequestParam("elID") int ID, Model modelo) {													//este modelAttribute es para pasar la informacion dentro de las etiquetas form:form del jsp AgregarCRUD.jsp que contiene el modelAttribute con id "addcliente" y lo almaceno en un objeto de tipo CRUD
		CRUD elcrud = elDAO.getCliente(ID);																					//utilizo el nombre de la instancia del ClienteDAO creada arriba de todo para crear el metodo insertar que sera creado en la interfaz e implementado por la clase DAO y propiamente rellenado
		modelo.addAttribute("addcliente", elcrud);
		return "AgregarCRUD";
	}
	
	@GetMapping("/borrar")																									//aun no se la diferencia entre PostMapping y RequestMapping
	public String actualizar(@RequestParam("elID") int ID) {																//este modelAttribute es para pasar la informacion dentro de las etiquetas form:form del jsp AgregarCRUD.jsp que contiene el modelAttribute con id "addcliente" y lo almaceno en un objeto de tipo CRUD
		elDAO.borrar(ID);
		return "redirect:/proyecto/lista";
	}
}
