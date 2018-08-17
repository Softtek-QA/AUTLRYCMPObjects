/**
 * 
 */
package br.lry.components;

import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.functions.AUTVAProjectFunctions;

import com.borland.silktest.jtf.xbrowser.DomButton;

/**
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {

	@Test
	public void autLogin(String user,String password) {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, user, password);
	}
	
}
