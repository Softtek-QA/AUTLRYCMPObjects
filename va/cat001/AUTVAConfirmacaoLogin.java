package br.lry.components.va.cat001;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;

public class AUTVAConfirmacaoLogin extends AUTBaseComponent{

	
	@Test
	public void autStartTest() {
		java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
		parametros.put("AUT_USER_TELEVENDAS", autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_USER_TELEVENDAS")).toString();
		parametros.put("AUT_PASSWORD", autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_PASSWORD")).toString();
	}
	
	
	public boolean autConfirmacaoLogin(java.util.HashMap<String, Object> parametros) {
		try {
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Usuario").clearText();
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Usuario").setText(parametros.get("AUT_USER_TELEVENDAS").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Senha").setText(parametros.get("AUT_PASSWORD").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA02.ConfirmacaoLogin.Avancar").click();
			return true;
		}
		catch(java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

}
