/**
 * 
 */
package br.lry.components.safe;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.Window;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_LOJAS_ENUM;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_TIPO_CONVENIO;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_TYPE_PERSONS;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import com.borland.silktest.jtf.xbrowser.DomElement;

/**
 * 
 * Gerenciamento de componentes automatizados do SAFE
 * 
 * @author SOFTTEK-QA
 *
 */
public class AUTSafeBaseServices extends AUTBaseComponent {
	br.lry.components.safe.AUTSafeGeradorVoucher safeVoucher = null; //Componente para processos de geração de Vouchers
	br.lry.components.safe.AUTSafeConsultaValeTroca safeVales = null; //Componente para processos de geração de Vouchers



	/**
	 * Retorna o gerenciador de voucher do SAFE
	 * 
	 * @return
	 */
	public <TSafeVoucher extends br.lry.components.safe.AUTSafeGeradorVoucher> TSafeVoucher autSAFEVouchers() {
		if(safeVoucher==null) {
			safeVoucher = new AUTSafeGeradorVoucher(false);
			safeVoucher.autGetDataFlow().AUT_ENABLE_SYNCRONIZE_ALL_OBJECTS=true;
			safeVoucher.autGetDataFlow().autInitDataFlow();
			
			return (TSafeVoucher)safeVoucher;
		}
		else {
			return (TSafeVoucher)safeVoucher;
		}
	}
	
	
	public <TSafeVoucher extends br.lry.components.safe.AUTSafeGeradorVoucher> TSafeVoucher autSAFEVouchers(boolean startApplication) {
		if(safeVoucher==null) {
		
			safeVoucher = new AUTSafeGeradorVoucher();
			
			return (TSafeVoucher)safeVoucher;
		}
		else {
			return (TSafeVoucher)safeVoucher;
		}
	}

	/**
	 * Retorna o gerenciador de vales compra
	 * 
	 * @return TSafeVales - Objeto de gerencimento de vales
	 */
	public <TSafeVales extends br.lry.components.safe.AUTSafeConsultaValeTroca> TSafeVales autSAFEVales() {
		if(safeVales==null) {
			safeVales = new AUTSafeConsultaValeTroca();			
			return (TSafeVales)safeVales;
		}
		else {
			return (TSafeVales)safeVales;
		}
	}

	public String autCarregarValeTroca(String docClient,AUT_SAFE_TYPE_PERSONS typePerson) {
		switch(typePerson) {
		case ESTRANGEIRO:{
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_TYPE_PERSON",typePerson);
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_TYPE_DOC_FOREIGN",AUT_SAFE_TYPE_PERSONS.PASSAPORTE);
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_DOCUMENT",autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_CADASTROS, "AUT_PASSAPORTE"));			
		}
		case FISICA:{
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_TYPE_PERSON",typePerson);
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_DOCUMENT",autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_CADASTROS, "AUT_CPF"));		}	
		case JURIDICA:{
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_TYPE_PERSON",typePerson);
			autSAFEVales().autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_DOCUMENT",autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_CADASTROS, "AUT_CNPJ"));	
		}
		}

		autSAFEVales().autIniConsultaValeTrocaParaCliente();
		return autSAFEVales().AUT_VALE_TROCA_OUTPUT;
	}
	
	public String autCarregarValeTroca(java.util.HashMap<String, Object> parametros) {

		autSAFEVales().autConsultaValeTrocaClientePF(parametros);
		return autSAFEVales().AUT_VALE_TROCA_OUTPUT;
	}

	public void autSAFEInitApplication() {
		autSAFEVouchers(false).AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
		autSAFEVouchers(false).AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("safe.settings");
		AUT_AGENT_SILK4J.executeBaseState(autSAFEVouchers(false).AUT_BASE_STATE_CONFIGURATION_BROWSER);
	}
	
	/**
	 * 
	 * Executa procedimentos de login  no SAFE
	 * 
	 * @param usuario - Usuario SAFE
	 * @param senha - Senha SAFE
	 * 
	 */
	public void autLoginWithInit(java.util.HashMap<String, Object> parametros) {
				
		AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE").maximize();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Usuario").setText(parametros.get("USER_SAFE").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Senha").setText(parametros.get("PWS_SAFE").toString());
		AUT_AGENT_SILK4J.<DomButton>find("SAFE.Login.BotaoEntrar").click();
	}
	
	public void autSAFEGerarVoucher(AUT_SAFE_TYPE_PERSONS typePerson,AUT_SAFE_TIPO_CONVENIO convenio) {
		String docClient = "";
				
		java.util.HashMap<String,Object> parameters = autGetDataFlow().autGetMergeParameters(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_CADASTROS_CLIENTE_CONVENIADO_LINX,AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_GERADOR_VOUCHER_LINX);		
		java.util.HashMap<String,Object> parametersCads = autGetDataFlow().autGetMergeParameters(parameters, AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_CADASTROS);
		java.util.HashMap<String,Object> parameterOut = autGetDataFlow().autGetMergeParameters(parametersCads, parameters);
		
		
		switch(typePerson) {
		case ESTRANGEIRO:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.FISICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.FISICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",parameterOut.get("AUT_CPF_ESTRANGEIRO"));
			parameterOut.remove("AUT_CLIENTE_NOME");
			parameterOut.put("AUT_CLIENTE_NOME",parameterOut.get("AUT_NOME_ESTRANGEIRO"));
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_NOME_ESTRANGEIRO").toString()));
			
			
			break;
		}
		case FISICA:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.FISICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.FISICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",parameterOut.get("AUT_CPF"));
			parameterOut.remove("AUT_CLIENTE_NOME");
			parameterOut.put("AUT_CLIENTE_NOME",parameterOut.get("AUT_NOME"));			
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_CLIENTE_NOME").toString()));

			
			
			break;
		}
		case JURIDICA:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.JURIDICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.JURIDICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",parameterOut.get("AUT_CNPJ"));
			parameterOut.remove("AUT_NOME_PJ");
			parameterOut.put("AUT_NOME_PJ",parameterOut.get("AUT_NOME_PJ"));
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_NOME_PJ").toString()));
			
			break;
		}
		}		
		autInsertScreenByScenario();
		autSAFEInitApplication();	
		autInsertScreenByScenario();
		autSAFEVouchers().autInitGerarVoucher(parameterOut);
		autSAFEInitApplication();
		autSAFEVouchers().autIniAssocClienteConveniado(parameterOut);
		
	}

	public void autSAFEGerarVoucher(AUT_SAFE_TYPE_PERSONS typePerson,AUT_SAFE_TIPO_CONVENIO convenio,String documento,String nomeCliente) {
		String docClient = "";
				
		java.util.HashMap<String,Object> parameters = autGetDataFlow().autGetMergeParameters(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_CADASTROS_CLIENTE_CONVENIADO_LINX,AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_GERADOR_VOUCHER_LINX);		
		java.util.HashMap<String,Object> parametersCads = autGetDataFlow().autGetMergeParameters(parameters, AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_CADASTROS);
		java.util.HashMap<String,Object> parameterOut = autGetDataFlow().autGetMergeParameters(parametersCads, parameters);
		
		
		switch(typePerson) {
		case ESTRANGEIRO:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.FISICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.FISICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",documento);
			parameterOut.remove("AUT_CLIENTE_NOME");
			parameterOut.put("AUT_CLIENTE_NOME",nomeCliente);
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_NOME_ESTRANGEIRO").toString()));
			
			
			break;
		}
		case FISICA:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.FISICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.FISICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",documento);
			parameterOut.remove("AUT_CLIENTE_NOME");
			parameterOut.put("AUT_CLIENTE_NOME",nomeCliente);			
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_CLIENTE_NOME").toString()));

			
			
			break;
		}
		case JURIDICA:{
			parameterOut.remove("AUT_TYPE_PERSON");
			parameterOut.put("AUT_TYPE_PERSON",AUT_SAFE_TYPE_PERSONS.JURIDICA);
			parameterOut.remove("AUT_TIPO_PESSOA");
			parameterOut.put("AUT_TIPO_PESSOA",AUT_SAFE_TYPE_PERSONS.JURIDICA2);
			parameterOut.remove("AUT_TIPO_CONVENIO");
			parameterOut.put("AUT_TIPO_CONVENIO",convenio);
			parameterOut.remove("AUT_DOCUMENTO");
			parameterOut.put("AUT_DOCUMENTO",documento);
			parameterOut.remove("AUT_NOME_PJ");
			parameterOut.put("AUT_NOME_PJ",nomeCliente);
			parameterOut.remove("AUT_OBSERVACOES");
			parameterOut.put("AUT_OBSERVACOES","OBSERVACOES: VOUCHER: CLIENTE : ".concat(parameterOut.get("AUT_NOME_PJ").toString()));
			
			break;
		}
		}		
		autInsertScreenByScenario();
		autSAFEInitApplication();	
		autInsertScreenByScenario();
		autSAFEVouchers().autInitGerarVoucher(parameterOut);
		autSAFEInitApplication();
		autSAFEVouchers().autIniAssocClienteConveniado(parameterOut);
		
	}

	/**
	 * 
	 * Executa procedimentos de logout  no SAFE
	 * 
	 * @param 
	 * 
	 */
	public void autLogout() {

		AUT_AGENT_SILK4J.<DomElement>find("SAFE.Logout.IconeUsuario").click();
		AUT_AGENT_SILK4J.<DomButton>find("SAFE.Logout.Sair").click();

		
//		AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE.PopUp.OK").typeKeys("<Enter>");
		//AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE.PopUP").close();
		//AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE.Logout.PopUp").typeKeys("<Enter>");
		AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE.Logout.PopUp").click();

		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE").close();
	}
	
	/**
	 * 
	 * Constructor
	 * 
	 */
	public AUTSafeBaseServices() {

	}

}
