/**
 * 
 */
package br.lry.components;

import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTVAProjectFunctions;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

/**
 * 
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {
	java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	
	
	public AUTVABaseComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Realiza login na aplicação - VA
	 *
	 */
	
	public void autLogin() {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString(), AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString());
	}
	
	public void autLogin(String usuario, String senha) {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, usuario.toString(), senha.toString());
	}
	

	
}
