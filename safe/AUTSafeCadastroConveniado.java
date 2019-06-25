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
public class AUTSafeCadastroConveniado extends AUTSafeBaseComponent {

	public String AUT_VALE_TROCA_OUTPUT = null; //Vale troca

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

	}


	public void autIniCadastroClienteConveniado(java.util.HashMap<String,Object> parameters) {

		autLoginWithInit(parameters.get("AUT_USER").toString(),parameters.get("AUT_PWD").toString());



		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO) parameters.get("AUT_TIPO_CONVENIO");
		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)parameters.get("AUT_TIPO_PESSOA");

		String documento = "";
		String rgCliente = "";			
		String docOrgEmissor = "";
		String dataNascimento = "";
		String nomeCliente = "";


		switch(tipoPessoa) {		
		case ESTRANGEIRO:{
			documento = parameters.get("AUT_DOCUMENTO").toString();			
			nomeCliente = parameters.get("AUT_NOME_ESTRANGEIRO").toString();

			break;
		}
		case FISICA:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			rgCliente = parameters.get("AUT_PF_RG").toString();			
			docOrgEmissor = parameters.get("AUT_ORG_EMISSOR").toString();
			dataNascimento = parameters.get("AUT_DATA_NASCIMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME").toString();

			break;
		}
		case FISICA2:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			rgCliente = parameters.get("AUT_PF_RG").toString();			
			docOrgEmissor = parameters.get("AUT_ORG_EMISSOR").toString();
			dataNascimento = parameters.get("AUT_DATA_NASCIMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME").toString();

			break;
		}
		case JURIDICA:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME_PJ").toString();

			break;
		}
		case JURIDICA2:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME_PJ").toString();

			break;
		}
		case PASSAPORTE:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME_ESTRANGEIRO").toString();

			break;
		}
		case RNE:{
			documento = parameters.get("AUT_DOCUMENTO").toString();
			nomeCliente = parameters.get("AUT_NOME_ESTRANGEIRO").toString();

			break;
		}

		}

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
		switch(tipoPessoa) {		
		case ESTRANGEIRO:{
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
			autInsertScreenByScenario();
			break;
		}
		case FISICA:{
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
			autInsertScreenByScenario();
			break;
		}
		case FISICA2:{		
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
			autInsertScreenByScenario();
			break;
		}
		case JURIDICA:{
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RazaoSocial").setText(nomeCliente);		

			break;
		}
		case JURIDICA2:{
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RazaoSocial").setText(nomeCliente);		

			break;
		}
		case PASSAPORTE:{
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
			autInsertScreenByScenario();
			break;
		}
		case RNE:{
			break;
		}		
		}


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
			AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.001TelaCadastroConveniado").close();
		}
		catch(java.lang.Exception e) {
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE").close();
		}
		
		
	}


	

	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeCadastroConveniado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeCadastroConveniado(boolean syncronizeDataFlow) {
		super(syncronizeDataFlow);
		// TODO Auto-generated constructor stub
	}
}
