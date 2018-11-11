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
	
		autLogin(parametrosConfig.get("AUT_USER").toString(), parametrosConfig.get("AUT_PWD").toString());
		
	}
	
	@Test
	public void autIniCadastroClienteConveniado() {
		autLogin(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_USER").toString(),autGetCurrentParameter("AUT_PWD").toString());
		
		
		AUT_SAFE_TIPO_CONVENIO convenio = (AUT_SAFE_TIPO_CONVENIO)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_CADASTROS_CLIENTE_CONVENIADO_LINX,"AUT_TIPO_CONVENIO");
		AUT_SAFE_TYPE_PERSONS tipoPessoa = (AUT_SAFE_TYPE_PERSONS)autGetCurrentParameter("AUT_TIPO_PESSOA");
		String documento = autGetCurrentParameter("AUT_DOCUMENTO").toString();;
		String nomeCliente = autGetCurrentParameter("AUT_PF_NOME").toString();;
		String rgCliente = autGetCurrentParameter("AUT_PF_RG").toString();;			
		String docOrgEmissor = autGetCurrentParameter("AUT_ORG_EMISSOR").toString();;
		String dataNascimento = autGetCurrentParameter("AUT_DATA_NASCIMENTO").toString();;
		AUT_SAFE_PROFISSOES profissoes = (AUT_SAFE_PROFISSOES)autGetCurrentParameter("AUT_PROFISSAO");
		String email = autGetCurrentParameter("AUT_EMAIL").toString();;
		String logradouro = autGetCurrentParameter("AUT_LOGRADOURO").toString();;
		String numeroEndereco = autGetCurrentParameter("AUT_NUMERO_ENDERECO").toString();;
		String complemento = autGetCurrentParameter("AUT_COMPLEMENTO_ENDERECO").toString();;
		String bairro = autGetCurrentParameter("AUT_BAIRRO").toString();;
		String cep = autGetCurrentParameter("AUT_CEP").toString();;
		String cidade = autGetCurrentParameter("AUT_CIDADE").toString();
		String uf = autGetCurrentParameter("AUT_UF").toString();;
		String dd1 = autGetCurrentParameter("AUT_TEL_DD1").toString();;
		String telefone1 = autGetCurrentParameter("AUT_TEL_FONE1").toString();;
		String ramal1 = autGetCurrentParameter("AUT_TEL_RAMAL1").toString();;
		
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("002MenuConvenio", 30000);
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002MenuConvenio").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu002GestaoConveniado").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.002SubMenu002CadastroConveniado").click();
		
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoConvenio").select(convenio.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaTipoPessoa").select( tipoPessoa.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NumeroDocumento").setText(documento);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.NomeCliente").setText(nomeCliente);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.RG").setText(rgCliente);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.OrgaoEmissor").setText(docOrgEmissor);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.001TelaCadastroConveniado.DataNascimento").setText(dataNascimento);
		AUT_AGENT_SILK4J.<DomListBox>find("SAFE.001TelaCadastroConveniado.ListaProfissoes").select(profissoes.toString());
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
		
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoSalvar").click();		

		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").waitForProperty("Text", AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.CheckPointCadastro").getText());	
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.001TelaCadastroConveniado.BotaoOKConfirmCad").click();		
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.001TelaCadastroConveniado").close();
	}
	
	
	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeCadastroConveniado() {
		// TODO Auto-generated constructor stub
	}

}
