package br.lry.components;

import br.lry.components.AUTBaseComponent.AUT_SYNC_EXECUTION_STATE;
import br.lry.components.pdv.AUTPDVBaseServices;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTPDVBaseComponent extends AUTBaseComponent{
	
	//protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	public static br.lry.components.pdv.AUTPDVBaseServices pdv;

	
	public void autInitConfigurationPDV() {
		autInsertScreenByScenario();
		pdv = new AUTPDVBaseServices();
	}

	
	/**
	 * 
	 * CAT0XX
	 * CMP00090 - Realizar login no PDV se necessário
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00090(java.util.HashMap<String, Object> parametros) {	
		boolean telaInicial = false;
		autInitConfigurationPDV();	
		
		telaInicial = pdv.autPDVVerificaTelaInicial("PDV-STATUS-0001");

		//Se Tela inicial "Cx Fechado Parcial", realiza login no PDV	
		if(telaInicial) {
			pdv.autPDVAcessos().autPDVLoginDefault(parametros);
		} else {
			//Se tela inicial "Caixa Disponivel", segue execução
			telaInicial = pdv.autPDVVerificaTelaInicial("PDV-STATUS-0005");
		
			//Tela inesperada está sendo exibida
			if(!telaInicial) {
				System.out.println("PDV : ERROR : NÃO FOI POSSIVEL INICIAR PROCESSO NO PDV ");
				AUT_AGENT_SILK4J.verifyAsset("PDV-STATUS-0005");
			}
		
		}
		
		System.out.println("PDV : TELA CAIXA DISPONIVEL OK PARA INICIO DO PDV");		
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
	
	
	/**
	 * 
	 * CAT0XX
	 * CMP00096 - Realizar logout no PDV
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00096(java.util.HashMap<String, Object> parametros) {
		
		autInitConfigurationPDV();	
		pdv.autPDVAcessos().autPDVLogoutDefault(parametros);
	}
}
