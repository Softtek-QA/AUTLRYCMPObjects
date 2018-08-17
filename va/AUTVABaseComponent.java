/**
 * 
 */
package br.lry.components.va;

import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.functions.AUTVAProjectFunctions;

import com.borland.silktest.jtf.xbrowser.DomButton;

/**
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {
	java.util.HashMap<String,String> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();
		
	@Test
	public void autLogin() {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER"), AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD"));
		this.autGetDataFlow();
	}
	
}
