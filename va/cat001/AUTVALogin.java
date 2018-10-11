/**
 * 
 */
package br.lry.components.va.cat001;

import br.lry.components.AUTVABaseComponent;


/**
 * Componente para login - VA
 * 
 * @author Sottek-QA
 *
 */
public class AUTVALogin extends AUTVABaseComponent {

	
	public void autStartLoginDefault() {
		try {	
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			//autInitWebApplication();			
			autLogin();
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	
	
	public void autStartLoginDefaultVA() {
		try {			
			autGetLogManager().logMensagem("AUT VA: LOGIN VA APPLICATION: INIT");
			autLoginVA();
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
			//TESTE CONFIGURAÇÃO CUSTOMIZADA TESTE 111111111111111
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
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
	
	

	public void autStartLoginHomolog1() {
		
	}
	
	public AUTVALogin() {
		super();
	}
	
}
