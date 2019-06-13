package br.lry.components;

import br.lry.components.AUTBaseComponent;
import br.lry.components.safe.AUTSafeBaseServices;
import br.lry.components.safe.AUTSafeConsultaValeTroca;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_TYPE_PERSONS;
import br.lry.components.va.cat002.AUTRecuperacao;

import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

public class AUTSafeBaseComponent extends AUTBaseComponent{
	
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	public static br.lry.components.safe.AUTSafeBaseServices safe;	
	public static br.lry.components.safe.AUTSafeConsultaValeTroca autValeTroca;
	
	
	public void autInitConfigurationSafe() {
		safe = new AUTSafeBaseServices();
		autValeTroca = new AUTSafeConsultaValeTroca();
	}

	
	/**
	 * 
	 * CAT0XX
	 * CMP00093 - Realizar login no SAFE
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00093(java.util.HashMap<String, Object> parametros) {
		autInitConfigurationSafe();	
		safe.autSAFEInitApplication();
		safe.autLoginWithInit(parametros);
		autInsertScreenByScenario();
	}
	
	/**
	 * 
	 * CAT0XX
	 * CMP00094 - Consulta Vale Troca PF
	 * @param parametro - Parametros de entrada do sistema
	 * @return vale troca
	 */	
	public <TOutput extends AUTSafeConsultaValeTroca> TOutput CMP00094(java.util.HashMap<String, Object> parametros) {
		autInitConfigurationSafe();	
		autValeTroca.autConsultaValeTrocaClientePF(parametros);
		return (TOutput) autValeTroca;
	}
	

}