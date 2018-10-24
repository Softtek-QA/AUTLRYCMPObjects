/**
 * 
 */
package br.lry.components.va.cat001;

import br.lry.components.AUTBaseComponent;
import br.lry.functions.AUTVAProjectFunctions;


/**
 * CMP00001 - Componente para login - VA
 * 
 * @author Sottek-QA
 *
 */
public class AUTVALogin extends AUTBaseComponent {

	
	/**
	 * Inicialização Login VA, parametros pré-definidos
	 */
	public void autStartLoginDefault() {
		try {	
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationVA();			
			autLogin();
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	

	
	/**
	 * Relaizar Login VA, com parametros pré-definidos
	 */
	public void autLogin() {
		try {
			AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			
			AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * Inicialização Login VA, com parametros configuráveis
	 */
	public void autStartLoginVA(java.util.HashMap<String, Object> parametros) {
		try {	
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationVA();			
			autLoginVA(parametros);
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	

	
	/**
	 * Relaizar Login VA, com parametros configuráveis
	 */
	public void autLoginVA(java.util.HashMap<String, Object> parametros) {
		try {
			AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationVA();			
			autLogin(parametros);
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	

	
	/**
	 * Relaizar Login VA, com parametros configuráveis
	 */
	public void autLogin(java.util.HashMap<String, Object> parametros) {
		try {
			AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			
			AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public AUTVALogin() {
		super();
	}
	
}
