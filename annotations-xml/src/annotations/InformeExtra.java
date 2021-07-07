package annotations;

import org.springframework.stereotype.Component;

@Component("Informe")
public class InformeExtra implements CreacionInforme {

	@Override
	public String getInformeExtra() {
		
		return "este es el informe extra";
	}

}
