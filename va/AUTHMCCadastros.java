package br.lry.components.va;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;

public class AUTHMCCadastros extends AUTHMCLogin {
	
	
	private Desktop AUT_AGENT_SILK4J = new Desktop();
	
	String usuario = "admin";
	String senha = "nimda";
	
	
	@Test
	public void autCadastrarUsuarioHMC() {
		
		autStartLoginDefault();
		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.User").click();
		//AUT_AGENT_SILK4J.<DomLink>find("HMC.TelaInicial.Customers").pressKeys(keys);
	}

	
}
