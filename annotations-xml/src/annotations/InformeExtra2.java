package annotations;

import org.springframework.stereotype.Component;

@Component("elotroinforme")
public class InformeExtra2 implements CreacionInforme {

	@Override
	public String getInformeExtra() {
		
		return "este es el informe superhiperextra";
	}

}
