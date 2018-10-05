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

import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.DomElement;

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
			autInitWebApplicationVA();
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
	

	public void autStartLoginHomolog1() {
		
	}
	
	public AUTVALogin() {
		super();
	}
	
}
