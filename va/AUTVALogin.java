/**
 * 
 */
package br.lry.components.va;

import br.lry.components.AUTVABaseComponent;

import org.junit.Test;

import com.borland.silktest.jtf.*;
import com.borland.silktest.jtf.keyworddriven.KeywordTests;
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
			
			
			
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: AUT");
		
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");
	
		}
	}
	
	public AUTVALogin() {
		super();
	}
}
