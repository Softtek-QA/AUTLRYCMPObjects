package br.lry.components;

import br.lry.components.AUTBaseComponent.AUT_SYNC_EXECUTION_STATE;
import br.lry.components.pdv.AUTPDVBaseServices;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTPDVBaseComponent extends AUTBaseComponent{
	
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	public static br.lry.components.pdv.AUTPDVBaseServices pdv;
	

	
	public void autInitConfigurationPDV() {
		autInsertScreenByScenario();
		pdv = new AUTPDVBaseServices();
	}

	
	/**
	 * 
	 * CAT0XX
	 * CMP00002 - Realizar login no PDV
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00090(java.util.HashMap<String, Object> parametros) {
//		try {
//			autLogoutApplication();
//		}
//		catch(java.lang.Exception e) {
//			
//		}
		
		autInitConfigurationPDV();	
		pdv.autPDVAcessos().autPDVLoginDefault(parametros);
		autInsertScreenByScenario();
	}
	
	/**
	 * 
	 * CAT0XX
	 * CMP00012 - Realizar Pagamento no PDV
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00091(java.util.HashMap<String, Object> parametros) {
		autInitConfigurationPDV();	
		pdv.autStartPagamentoPedido(parametros);
		autInsertScreenByScenario();
	}
	
	/**
	 * 
	 * CAT0XX
	 * CMP00092 - Realizar Devolucao no PDV
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00092(java.util.HashMap<String, Object> parametros) {
		autInitConfigurationPDV();	
		pdv.autStartDevolucaoItem(parametros);
		autInsertScreenByScenario();
	}
}
