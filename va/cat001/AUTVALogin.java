/**
 * 
 */
package br.lry.components.va.cat001;

import br.lry.components.AUTBaseComponent;
import br.lry.components.AUTVABaseComponent;
import br.lry.functions.AUTVAProjectFunctions;


/**
 * CMP00001 - Componente para login - VA
 * 
 * @author Sottek-QA
 *
 */
public class AUTVALogin extends AUTVABaseComponent {

	
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
	
	
	public void autStartLoginDefault(String usuario, String senha) {
		try {
		
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplication();
			autLogin(usuario, senha);
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
			//TESTE CONFIGURAÃ‡ÃƒO CUSTOMIZADA TESTE 111111111111111
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void autLoginVATelevendas() {
		//comentado, pois não é usado e gera erro. Se usar, passar o parametro do dataflow para esse metodo
		//AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER_TELEVENDAS").toString();
		//AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		
		//AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
	}
	
	public void autLoginVATelevendasDefault() {
		try {
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplication();
			autLoginVATelevendas();
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
			//TESTE CONFIGURAÇÃO CUSTOMIZADA TESTE 111111111111111
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
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
			//comentado, pois não é usado e gera erro. Se usar, passar o parametro do dataflow para esse metodo
			
			//AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			//AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			
			//AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
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
			//AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
			//AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
			
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
