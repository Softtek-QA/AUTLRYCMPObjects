package br.lry.components.safe;

import java.util.HashMap;

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
import br.lry.components.safe.AUTSafeBaseComponent.AUT_SAFE_COUNTRY;
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

	public void autInitGerarVoucherPF(java.util.HashMap<String,Object> parameters) {
		AUTSafeCadastroConveniado cadastro = new AUTSafeCadastroConveniado(false);		
		autInsertScreenByScenario();
		autIniCadastroClienteConveniadoPF(parameters);	
	}

	public void autInitGerarVoucherEst(java.util.HashMap<String,Object> parameters) {
		AUTSafeCadastroConveniado cadastro = new AUTSafeCadastroConveniado(false);		
		autInsertScreenByScenario();
		autIniCadastroClienteConveniadoEst(parameters);	
	}

	public void autInitGerarVoucherPJ(java.util.HashMap<String,Object> parameters) {
		AUTSafeCadastroConveniado cadastro = new AUTSafeCadastroConveniado(false);		
		autInsertScreenByScenario();
		autIniCadastroClienteConveniadoPJ(parameters);	
	}


	public void autIniAssocClienteConveniadoPF(java.util.HashMap<String,Object> parameters) {
		try {
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
			//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();
		}
		catch(java.lang.Exception e) {
			//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();			
		}
	}
		
	public void autIniAssocClienteConveniadoEst(java.util.HashMap<String,Object> parameters) {
		try {
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
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.ValorVoucher").setText(valorVoucher);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.002TelaAssocClientConveniado.ListaLojas").select(loja.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.002TelaAssocClientConveniado.Observacoes").setText(observacoes);
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.002TelaAssocClientConveniado.BotaoGerar").setFocus();
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
			//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();
		}
		catch(java.lang.Exception e) {
			//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();			
		}
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
	
	public void autIniAssocClienteConveniadoPJ(java.util.HashMap<String,Object> parameters) {
			try {
				AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO)parameters.get("AUT_TIPO_CONVENIO");
				AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");
				String documento = parameters.get("AUT_DOCUMENTO").toString();
				String nomeCliente = parameters.get("AUT_NOME_PJ").toString();;
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
				//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();
			}
			catch(java.lang.Exception e) {
				//AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.002TelaAssocClientConveniado").close();			
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


	/**
	 * 
	 * Geração de Voucher PF
	 * 
	 */
	
	
	public  <TOutput extends AUTSafeGeradorVoucher> TOutput autIniCadastroClienteConveniadoPF(HashMap<String, Object> parameters) {
		// TODO Auto-generated method stub
		
		String documento = "";
		String rgCliente = "";			
		String docOrgEmissor = "";
		String dataNascimento = "";
		String nomeCliente = "";

		documento = parameters.get("AUT_DOCUMENTO").toString();
		rgCliente = parameters.get("AUT_PF_RG").toString();			
		docOrgEmissor = parameters.get("AUT_ORG_EMISSOR").toString();
		dataNascimento = parameters.get("AUT_DATA_NASCIMENTO").toString();
		nomeCliente = parameters.get("AUT_NOME").toString();

		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");
		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO) parameters.get("AUT_TIPO_CONVENIO");
		AUT_SAFE_PROFISSOES profissoes = (AUT_SAFE_PROFISSOES)parameters.get("AUT_PROFISSAO");
		
		String email = parameters.get("AUT_EMAIL").toString();
		String logradouro = parameters.get("AUT_LOGRADOURO").toString();
		String numeroEndereco = parameters.get("AUT_NUMERO_ENDERECO").toString();
		String complemento = parameters.get("AUT_COMPLEMENTO_ENDERECO").toString();
		String bairro = parameters.get("AUT_BAIRRO").toString();
		String cep = parameters.get("AUT_CEP").toString();
		String cidade = parameters.get("AUT_CIDADE").toString();
		String uf = parameters.get("AUT_UF").toString();
		String dd1 = parameters.get("AUT_TEL_DD1").toString();
		String telefone1 = parameters.get("AUT_TEL_FONE1").toString();
		String ramal1 = parameters.get("AUT_TEL_RAMAL1").toString();

//		autInsertScreenByScenario();

		//autLoginWithInit(parameters.get("USER_SAFE").toString(),parameters.get("PWS_SAFE").toString());
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").click();

		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").select(convenio.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoPessoa").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoPessoa").select( tipoPessoa.toString());
		
		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroDocumento").setText(documento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NomeCliente").setText(nomeCliente);

		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());

		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomCheckBox>find("SAFE.001TelaCadastroConveniado.CheckParceiro").check();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Email").setText(email);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Logradouro").setText(logradouro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroResidencia").setText(numeroEndereco);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Complemento").setText(complemento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Bairro").setText(bairro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cep").setText(cep);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cidade").setText(cidade);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.UF").select(uf);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setText(dd1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Telefone1").setText(telefone1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Ramal").setText(ramal1);

		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoSalvar").click();		
	
		autInsertScreenByScenario();
		
		try {
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").waitForProperty("Text", AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").getText());	
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoOKConfirmCad").click();		
		}
		catch(java.lang.Exception e) {
			autInsertScreenByScenario();
		}
		
		return (TOutput) null; //Vale troca

		
	}
	
	/**
	 * 
	 * Geração de Voucher Estrangeiro
	 * 
	 */
	

	public  <TOutput extends AUTSafeGeradorVoucher> TOutput autIniCadastroClienteConveniadoEst(java.util.HashMap<String,Object> parameters) {


		String documento = "";
		String rgCliente = "";			
		String dataNascimento = "";
		String nomeCliente = "";

		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO) parameters.get("AUT_TIPO_CONVENIO");
		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");
		AUT_SAFE_TYPE_PERSONS tipoDoc = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_DOC");
		AUT_SAFE_COUNTRY paisOrigem = ( AUT_SAFE_COUNTRY) parameters.get("AUT_PAIS_ORIGEM");
		
		//case PASSAPORTE: > Escolhido no dataflow
		//case RNE:{       > Escolhido no dataflow
		documento = parameters.get("AUT_DOCUMENTO").toString();
		nomeCliente = parameters.get("AUT_CLIENTE_NOME").toString();

		dataNascimento = parameters.get("AUT_DATA_NASCIMENTO").toString();
		AUT_SAFE_PROFISSOES profissoes = (AUT_SAFE_PROFISSOES)parameters.get("AUT_PROFISSAO");
		
		String email = parameters.get("AUT_EMAIL").toString();
		String logradouro = parameters.get("AUT_LOGRADOURO").toString();
		String numeroEndereco = parameters.get("AUT_NUMERO_ENDERECO").toString();
		String complemento = parameters.get("AUT_COMPLEMENTO_ENDERECO").toString();
		String bairro = parameters.get("AUT_BAIRRO").toString();
		String cep = parameters.get("AUT_CEP").toString();
		String cidade = parameters.get("AUT_CIDADE").toString();
		String uf = parameters.get("AUT_UF").toString();
		String dd1 = parameters.get("AUT_TEL_DD1").toString();
		String telefone1 = parameters.get("AUT_TEL_FONE1").toString();
		String ramal1 = parameters.get("AUT_TEL_RAMAL1").toString();
		//autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").click();
		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").select(convenio.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoPessoa").select( tipoPessoa.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.TipoDocEstrangeiro").select( tipoDoc.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroDocumento").setText(documento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NomeCliente").setText(nomeCliente);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
		AUT_AGENT_SILK4J.<DomCheckBox>find("SAFE.001TelaCadastroConveniado.CheckParceiro").check();
		autInsertScreenByScenario();


		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Email").setText(email);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaPaisOrigem").select( paisOrigem.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Logradouro").setText(logradouro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroResidencia").setText(numeroEndereco);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Complemento").setText(complemento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Bairro").setText(bairro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cep").setText(cep);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cidade").setText(cidade);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.UF").select(uf);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setText(dd1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Telefone1").setText(telefone1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Ramal").setText(ramal1);
		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoSalvar").click();		
		autInsertScreenByScenario();
		
		try {
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").waitForProperty("Text", AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").getText());	
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoOKConfirmCad").click();		
		}
		catch(java.lang.Exception e) {
			autInsertScreenByScenario();
		}

		return (TOutput) null; //Vale troca		
	}


	/**
	 * 
	 * Geração de Voucher PJ
	 * 
	 */
	
	public  <TOutput extends AUTSafeGeradorVoucher> TOutput autIniCadastroClienteConveniadoPJ(java.util.HashMap<String,Object> parameters) {

		String documento = "";
		String rgCliente = "";			
		String docOrgEmissor = "";
		String dataNascimento = "";
		String nomeCliente = "";


		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");
		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO) parameters.get("AUT_TIPO_CONVENIO");
		AUT_SAFE_PROFISSOES profissoes = (AUT_SAFE_PROFISSOES)parameters.get("AUT_PROFISSAO");

		documento = parameters.get("AUT_DOCUMENTO").toString();
		nomeCliente = parameters.get("AUT_NOME_PJ").toString();

		String email = parameters.get("AUT_EMAIL").toString();
		String logradouro = parameters.get("AUT_LOGRADOURO").toString();
		String numeroEndereco = parameters.get("AUT_NUMERO_ENDERECO").toString();
		String complemento = parameters.get("AUT_COMPLEMENTO_ENDERECO").toString();
		String bairro = parameters.get("AUT_BAIRRO").toString();
		String cep = parameters.get("AUT_CEP").toString();
		String cidade = parameters.get("AUT_CIDADE").toString();
		String uf = parameters.get("AUT_UF").toString();
		String dd1 = parameters.get("AUT_TEL_DD1").toString();
		String telefone1 = parameters.get("AUT_TEL_FONE1").toString();
		String ramal1 = parameters.get("AUT_TEL_RAMAL1").toString();
		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").click();
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").select(convenio.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoPessoa").select( tipoPessoa.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroDocumento").setText(documento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NomeCliente").setText(nomeCliente);
		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RazaoSocial").setText(nomeCliente);		


		autInsertScreenByScenario();


		AUT_AGENT_SILK4J.<DomCheckBox>find("SAFE.001TelaCadastroConveniado.CheckParceiro").check();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Email").setText(email);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Logradouro").setText(logradouro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroResidencia").setText(numeroEndereco);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Complemento").setText(complemento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Bairro").setText(bairro);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cep").setText(cep);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Cidade").setText(cidade);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.UF").select(uf);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DD1").setText(dd1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Telefone1").setText(telefone1);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.Ramal").setText(ramal1);
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoSalvar").click();		
		autInsertScreenByScenario();
		
		try {
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").waitForProperty("Text", AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").getText());	
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoOKConfirmCad").click();		
		}
		catch(java.lang.Exception e) {
			autInsertScreenByScenario();
		}
		
		return (TOutput) null; //Vale troca		
	}


	
	
	
	
}
