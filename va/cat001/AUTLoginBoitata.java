package br.lry.components.va.cat001;

import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;

import br.lry.components.AUTBaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTVAProjectFunctions;


/**
 * CMP00002 - Componente para login - Boitata
 * 
 * @author Sottek-QA
 *
 */
public class AUTLoginBoitata extends AUTBaseComponent{

	public void autStartLoginBoitata(java.util.HashMap<String, Object> parametros) {
		try {			
			autGetLogManager().logMensagem("AUT VA: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationBoitata();
			autLogin(parametros);
			autGetLogManager().logMensagem("AUT VA: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}
	
	
	
	public void autLogin(java.util.HashMap<String, Object> parametros) {
		try {
			AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			AUTVAProjectFunctions.autLoginBoitata(this.AUT_AGENT_SILK4J, parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
