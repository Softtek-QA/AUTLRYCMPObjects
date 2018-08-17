/**
 * 
 */
package br.lry.components;

import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.DomButton;

/**
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {

	@Test
	public void autLogin() {
		agent.<DomTextField>find("VA.Login.Usuario").setText("51028487");
		agent.<DomTextField>find("VA.Login.Senha").setText("1234");
		agent.<DomButton>find("VA.Login.Avancar").click();
	}
	
}
