package br.lry.components.hmc;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.dataflow.AUTDataFlow.AUT_URL_APLICACOES;
import br.lry.functions.AUTVAProjectFunctions;


public class AUTHMCLogin extends AUTBaseComponent{
	
	java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	

	/**
	 * 
	 * Realiza login na aplicação - HMC - Hybris
	 *
	 */
	
	
	public void autLogin(String usuario, String senha) {
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").clearText();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaLogin.Login").click();
	}
	
	
	
	public void autStartLoginDefault(String usuario, String senha) {
		try {	
			autGetLogManager().logMensagem("AUT ERROR: LOGIN HMC APPLICATION: INIT");
			autInitHmcApplication();
			autLogin(usuario, senha);
			
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void autCloseApplication() {
		
	}

}
