/**
 * 
 */
package br.lry.components.va;

import br.lry.components.AUTVABaseComponent;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem;
import junit.framework.AssertionFailedError;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestResult;

import org.junit.Before;
import org.junit.Test;

/**
 * Componente para login - VA
 * 
 * @author Sottek-QA
 *
 */
public class AUTVALogin extends AUTVABaseComponent {

	@Test
	public void autStartLoginDefault() {
		try {		
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autLogin();			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}
	
	
	public void autStartLoginDefault(String usuario, String senha) {
		try {
		
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			
			autLogin(usuario, senha);
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}
	
	public void autStartProxyConfiguration(String usuario,String senha) {
		
	}
	
	public static void main(String[] args) {
		AUTVALogin lg = new AUTVALogin();
		lg.AUT_AGENT_SILK4J.resetAllOptions();
		lg.autStartLoginDefault();
	}
	
	public AUTVALogin(String usuario, String senha) {
		autStartLoginDefault(usuario, senha);
	}
	
	public AUTVALogin() {
		autStartLoginDefault();
	}
}
