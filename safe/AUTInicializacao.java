package br.lry.components.safe;


import br.lry.components.AUTBaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTInicializacao extends AUTBaseComponent{

	
	/**
	 * Inicialização Login SAFE, parametros pré-definidos
	 */
	public void autStartLoginSafe() {
		try {	
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationSafe();	
			autLoginSafe(AUT_AGENT_SILK4J, autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_LOGIN, "AUT_USER").toString(), autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_LOGIN, "AUT_PASSWORD").toString());
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	

	
	
	
}
