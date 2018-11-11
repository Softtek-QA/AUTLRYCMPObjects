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
	
		autLogin(parametrosConfig.get("AUT_USER").toString(), parametrosConfig.get("AUT_PWD").toString());
		
	}
	
	
	@Test
	public void autInitGerarVoucher() {
		AUTSafeCadastroConveniado cadastro = new AUTSafeCadastroConveniado();
		cadastro.autIniCadastroClienteConveniado();
		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_GERADOR_VOUCHER_LINX, "AUT_DOCUMENTO",cadastro.autGetCurrentParameter("AUT_DOCUMENTO"));
		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_GERADOR_VOUCHER_LINX, "AUT_CLIENTE_NOME",cadastro.autGetCurrentParameter("AUT_PF_NOME"));
		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_SAFE_GERADOR_VOUCHER_LINX, "AUT_OBSERVACOES","AUT VOUCHER : FLUXO END-TO-END : ".concat(cadastro.autGetCurrentParameter("AUT_PF_NOME").toString()));
		
		autIniAssocClienteConveniado();
	}
	
	
	public void autIniAssocClienteConveniado() {
		autLogin(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_USER").toString(),autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX,"AUT_PWD").toString());
				
		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_TIPO_CONVENIO");
		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_TIPO_PESSOA");
		String documento = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_DOCUMENTO").toString();;
		String nomeCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_CLIENTE_NOME").toString();;
		String valorVoucher = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_VALOR_VOUCHER").toString();;
		AUT_SAFE_LOJAS_ENUM loja = (AUT_SAFE_LOJAS_ENUM)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_LOJA");
		String observacoes = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_GERADOR_VOUCHER_LINX,"AUT_OBSERVACOES").toString();;
		
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.003MenuConvenioPrePago").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.003MenuConvenioPrePago").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.004SubMenu003GerarVoucher").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.004SubMenu003GerarVoucher").click();

		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaTipoConvenio").select(convenio.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaTipoPessoa").select(tipoPessoa.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.NumeroDocumento").setText(documento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.ValorVoucher").setText(valorVoucher);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaLojas").select(loja.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.Observacoes").setText(observacoes);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.BotaoGerar").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.BotaoGerar").click();
		
		boolean exibMSGConfirm = AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").exists("001TelaConfirmGerVoucher", 10000);
		if(exibMSGConfirm) {
			boolean exibMsgVoucher = AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.001TelaConfirmGerVoucher").exists("MsgConfirmVoucher", 5000);
			if(exibMsgVoucher) {
				AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.001TelaConfirmGerVoucher.BotaoOK").click();
				String codeText = AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.002TelaDetalhesVoucher.CodigoBarra").getDomAttribute("src").toString();
				System.out.println(codeText);
				java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("code\\=\\d+");
				java.util.regex.Matcher verif = regExp.matcher(codeText);
				if(verif.find()) {
					regExp = java.util.regex.Pattern.compile("\\d+");
					AUT_NUMERO_VOUCHER_OUTPUT = verif.group();
					verif = regExp.matcher(AUT_NUMERO_VOUCHER_OUTPUT);
					if(verif.find()) {
						AUT_NUMERO_VOUCHER_OUTPUT = verif.group();
					}
					System.out.println("AUT INFO: CODIGO DE BARRAS PROCESSADO : ");
					System.out.println(AUT_NUMERO_VOUCHER_OUTPUT);
				}
			}
		}
		else {
			
		}
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();
	}
	
	
	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeGeradorVoucher() {
		// TODO Auto-generated constructor stub
		
	}

}
