package br.lry.components.safe;

import org.junit.Test;
import org.w3c.dom.traversal.DocumentTraversal;

import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_PROFISSOES;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_TIPO_CONVENIO;
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_TYPE_PERSONS;
import br.lry.components.sap.AUTSAPBaseComponent;
import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;


/**
 * 
 * Realiza procedimentos de consulta de vale troca
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTSafeGeradorVoucher extends AUTSafeBaseComponent {

	public String AUT_NUMERO_VOUCHER_OUTPUT = null; //Vale troca

	/**
	 * 
	 * Consulta numeros de vale troca gerados para cliente
	 * 
	 * @param parametrosConfig - Parametros de configuração
	 * 
	 * 
	 */
	public void autIniConsultaValeTrocaParaCliente(java.util.HashMap<String,Object> parametrosConfig) {

		autLoginWithInit(parametrosConfig.get("AUT_USER").toString(), parametrosConfig.get("AUT_PWD").toString());
		autInsertScreenByScenario();
	}

	public void autInitGerarVoucher(java.util.HashMap<String,Object> parameters) {
		AUTSafeCadastroConveniado cadastro = new AUTSafeCadastroConveniado(false);		
		autInsertScreenByScenario();
		cadastro.autIniCadastroClienteConveniado(parameters);	
	}


	public void autIniAssocClienteConveniado(java.util.HashMap<String,Object> parameters) {
		try {
			autLogin(parameters.get("AUT_USER").toString(),parameters.get("AUT_PWD").toString());
			autInsertScreenByScenario();
			AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO)parameters.get("AUT_TIPO_CONVENIO");
			AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");
			String documento = parameters.get("AUT_DOCUMENTO").toString();
			String nomeCliente = parameters.get("AUT_CLIENTE_NOME").toString();;
			String valorVoucher = parameters.get("AUT_VALOR_VOUCHER").toString();;
			AUT_SAFE_LOJAS_ENUM loja = (AUT_SAFE_LOJAS_ENUM)parameters.get("AUT_LOJA");
			String observacoes = parameters.get("AUT_OBSERVACOES").toString();;

			AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.003MenuConvenioPrePago").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.003MenuConvenioPrePago").click();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.004SubMenu003GerarVoucher").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.004SubMenu003GerarVoucher").click();
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaTipoConvenio").select(convenio.toString());
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaTipoPessoa").select(tipoPessoa.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.NumeroDocumento").setText(documento);
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.ValorVoucher").setText(valorVoucher);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaLojas").select(loja.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.Observacoes").setText(observacoes);
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.BotaoGerar").setFocus();
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.BotaoGerar").click();
			autInsertScreenByScenario();
			boolean exibMSGConfirm = AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").exists("001TelaConfirmGerVoucher", 10000);
			if(exibMSGConfirm) {
				boolean exibMsgVoucher = AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.001TelaConfirmGerVoucher").exists("MsgConfirmVoucher", 5000);
				if(exibMsgVoucher) {
					AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.001TelaConfirmGerVoucher.BotaoOK").click();
					String codeText = AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.002TelaDetalhesVoucher.CodigoBarra").getDomAttribute("src").toString();
					System.out.println(codeText);
					autInsertScreenByScenario();
					java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("code\\=\\d+");
					java.util.regex.Matcher verif = regExp.matcher(codeText);
					if(verif.find()) {
						regExp = java.util.regex.Pattern.compile("\\d+");
						AUT_NUMERO_VOUCHER_OUTPUT = verif.group();
						verif = regExp.matcher(AUT_NUMERO_VOUCHER_OUTPUT);
						if(verif.find()) {
							AUT_NUMERO_VOUCHER_OUTPUT = verif.group();
							autInsertScreenByScenario();
						}
						System.out.println("AUT INFO: CODIGO DE BARRAS PROCESSADO : ");
						System.out.println(AUT_NUMERO_VOUCHER_OUTPUT);
					}
				}
			}
			else {
				autInsertScreenByScenario();
			}
			AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();
		}
		catch(java.lang.Exception e) {
			AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();			
		}
	}


	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeGeradorVoucher() {
		// TODO Auto-generated constructor stub

	}

	public AUTSafeGeradorVoucher(boolean syncronizeDataFlow) {
		// TODO Auto-generated constructor stub
		super(syncronizeDataFlow);
	}
}
