/**
 * 
 */
package br.lry.components.va;

import br.lry.components.AUTSAPLogin;
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
			AUTSAPLogin sapLog = new AUTSAPLogin();
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			autInitWebApplication();			
			autLogin();
			sapLog.baseState();
			sapLog.autInitSAPApp();
			sapLog.autStartLoginDefault();
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
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
			
			autLogin(usuario, senha);
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}
	
}
