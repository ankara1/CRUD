package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodigoPostal implements ConstraintValidator<Postal, String>{			//debe implementar de ConstraintValidator y Postal es el nombre de la annotation creada, el parametro es de tipo String

	private String prefijo;
	
	@Override
    public void initialize(Postal laAnotacion) {									//valor default declarado en la annotation Postal para que inicie con ese valor "28"
		prefijo=laAnotacion.value();
    }
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {			//en arg0 se va a almacenar lo que el usuario introduzca en el campo
		boolean validacion;															//declaracion sin iniciacion de booleano
		if(arg0!=null) validacion=arg0.startsWith(prefijo);							//si lo que anoto el usuario en codigo postal no arranca con el prefijo por defecto o esta vacio va a guardar false en el booleano
		else  return validacion=true;												//y si no lo dejo vacio y arranca con el prefijo se va a almacenar true
		return validacion;															//finalmente devolvera true o false
	}		
}
