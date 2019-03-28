/**
 * 
 */
package br.lry.components.va;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sun.management.resources.agent;
import br.lry.components.va.AUTVACadastros.AUT_VA_CADASTROS;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_CONTATO;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_ENDERECO;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_RESIDENCIA;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_MEIOS_PAGAMENTO;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_PLANO_PAGAMENTO;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.*;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.CommonOptions;
import com.borland.silktest.jtf.win32.AccessibleControl;
import org.junit.Assert;
/**
 * 
 * Cadastro de pessoa Física
 * 
 * @author Softtek-QA
 * 
 *
 */
public class AUTVACadastros extends AUTVALogin {
	public static String AUT_NUMERO_DOC_CPF_OUTPUT=null;
	public static String AUT_NUMERO_DOC_CNPJ_OUTPUT=null;
	public static String AUT_NUMERO_DOC_PASSAPORTE_OUTPUT=null;
	public int telefone;
	public int multiplosEnderecos;
	public String numeroDocumento;
	public String documentoInvalido;
	public int cepInvalido;

	public enum AUT_VA_PROPRIEDADE_RESIDENCIA{
		PROPRIA,
		ALUGADA,
		FINANCIADA,
		CEDIDA,
		FAMILIAR,
		FUNCIONAL,
		OUTROS;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case PROPRIA :{
				return "Própria";
			}
			case ALUGADA :{
				return "Alugada";
			}
			case FINANCIADA :{
				return "Financiada";
			}
			case CEDIDA :{
				return "Cedida";
			}
			case FAMILIAR :{
				return "Familiar";
			}
			case FUNCIONAL :{
				return "Funcional";
			}
			case OUTROS :{
				return "Outros";
			}


			}
			return super.toString();
		}


	}



	/**
	 * 
	 *Enumera as opções de configuração de configuração dos scripts de cadastro
	 *
	 *
	 * @author Softtek-QA
	 *
	 */
	public static enum AUT_VA_CADASTROS{
		FISICA_ATUALIZACAO,
		FISICA,
		JURIDICA,
		JURIDICA_ATUALIZACAO,
		ESTRANGEIRO;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}

	public enum AUT_VA_TIPO_CLIENTE_INVALIDO {
		CPF,
		CNPJ;
		@Override
		public String toString() {
			switch(this) {
			case CPF: {
				return "cpfInvalido";
			}
			case CNPJ: {
				return "cnpjInvalido";
			}
			}
			// TODO Auto-generated method stub
			return super.toString();
		}
	}


	/**
	 * 
	 * Inclusão os parametros de cadastro para pessoa física a partir do pedido 
	 * 
	 */
	public void autCadastrarPF(java.util.HashMap parametros) {
		String clienteNome = parametros.get("AUT_NOME").toString();
		String clienteEmail = parametros.get("AUT_EMAIL").toString();
		String ClienteInscricao = parametros.get("AUT_INCRICAO_ESTADUAL_PF").toString(); 

		DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Nome");
		DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Email");
		DomTextField numeroInscEstatual = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.InscricaoEstadual");

		nome.click();
		nome.domClick();
		nome.setText(clienteNome);

		email.click();
		email.domClick();
		email.setText(clienteEmail);

		numeroInscEstatual.click();
		numeroInscEstatual.domClick();
		numeroInscEstatual.setText(ClienteInscricao);

		String tipoTelefone = parametros.get("AUT_TIPO_TELEFONE").toString(); 
		String numeroTelefone = parametros.get("AUT_NUMERO_TELEFONE").toString(); 

		DomListBox listaTipoElement = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoTelefone");
		listaTipoElement.click();
		listaTipoElement.select(tipoTelefone);

		DomTextField txtNumeroContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroTelefone");
		txtNumeroContato.click();
		txtNumeroContato.domClick();
		txtNumeroContato.setText(numeroTelefone);

		txtNumeroContato.click();
		txtNumeroContato.setFocus();
		txtNumeroContato.domClick();



		DomButton btPesquisarCEP = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.NaoSeiCEPPesquisa");
		btPesquisarCEP.click();

		String UFEnderecoPesquisa = parametros.get("AUT_UF_PESQUISA").toString();  
		String cidade = parametros.get("AUT_CIDADE_PESQUISA").toString();   
		String endereco = parametros.get("AUT_ENDERECO_PESQUISA").toString(); 
		String bairro = parametros.get("AUT_BAIRRO_PESQUISA").toString();  

		DomListBox listUF = AUT_AGENT_SILK4J.<DomListBox>find("VA.PesquisaCEP.UF");

		listUF.click();
		listUF.domClick();
		listUF.select(UFEnderecoPesquisa);

		DomTextField txtCidadePesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Cidade");
		DomTextField txtEnderecoPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Endereco");
		DomTextField txtBairroPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Bairro");

		txtCidadePesquisa.click();
		txtCidadePesquisa.setText(cidade);

		txtEnderecoPesquisa.click();
		txtEnderecoPesquisa.setText(endereco);

		txtBairroPesquisa.click();
		txtBairroPesquisa.setText(bairro);

		DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");

		btBuscarEndereco.click();

		if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.PesquisaCEP").exists("MsgStatusCEP",10000)) {
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
		}
		else {
			DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

			itemSelectResultPesquisa.click();		

		}


		String tipoEndereco = parametros.get("AUT_TIPO_ENDERECO").toString();  
		String cep = parametros.get("AUT_CEP").toString(); 
		String nomeRuaEndereco = parametros.get("AUT_RUA_ENDERECO").toString();  
		String numeroEndereco = parametros.get("AUT_NUMERO_ENDERECO").toString(); 
		String bairroResidencia = parametros.get("AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = parametros.get("AUT_COMPLEMENTO_ENDERECO").toString(); 
		String cidadeResidencia = parametros.get("AUT_CIDADE_ENDERECO").toString(); 
		String estadoResidencia = parametros.get("AUT_ESTADO_ENDERECO").toString(); 
		String referenciaResidencia = parametros.get("AUT_REFERENCIA_ENDERECO").toString(); 
		String tipoImovelResidencia = parametros.get("AUT_TIPO_IMOVEL_RESIDENCIA").toString(); 

		DomListBox listTipoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoEndereco");
		DomTextField txtCEPEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.CEP");
		DomTextField txtNumeroCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroCasa");
		DomTextField txtBairroEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Bairro");
		DomTextField txtComplementoResidEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Complemento");
		DomTextField txtCidadeEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Cidade");
		DomListBox txtEstadoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Estado");
		DomTextField txtReferenciaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Referencia");
		DomListBox txtTipoImovelResidEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoImovelResidencial");

		listTipoEnd.click();
		listTipoEnd.select(tipoEndereco);

		txtCEPEnd.click();
		txtCEPEnd.setText(cep);

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NomeRua").setText(endereco);

		txtNumeroCasaEnd.click();
		txtNumeroCasaEnd.setText(numeroEndereco);

		txtBairroEnd.click();
		txtBairroEnd.setText(bairroResidencia);

		txtComplementoResidEnd.click();
		txtComplementoResidEnd.setText(complementoResidencia);

		txtCidadeEnd.click();
		txtCidadeEnd.setText(cidadeResidencia);

		txtEstadoEnd.click();
		txtEstadoEnd.select(estadoResidencia);

		txtReferenciaEnd.click();
		txtReferenciaEnd.setText(referenciaResidencia);

		txtTipoImovelResidEnd.click();
		txtTipoImovelResidEnd.select(tipoImovelResidencia);


		DomRadioButton btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");
		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();

		DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro");

		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS").click();

		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();
		try {
			btCadastroPFAvanc.click();

			btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");

			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			DomElement btCheckMalaDirectAceit = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");

			btCheckMalaDirectAceit.click();

			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").click();
		}
		catch(java.lang.Exception e ) {

		}

		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro2");

		btCadastroPFAvanc2.click();

	}


	public void autCadastroClienteInvalido(String usuario,String senha,AUT_VA_TIPO_CLIENTE_INVALIDO tipoClienteInvalido) {
		autInitWebApplicationVA();
		autLoginVA(usuario, senha);

		autInsertScreenByScenario();
		if (tipoClienteInvalido == AUT_VA_TIPO_CLIENTE_INVALIDO.CPF) {
			documentoInvalido = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CPF_INVALIDO").toString();
		} 
		else if (tipoClienteInvalido == AUT_VA_TIPO_CLIENTE_INVALIDO.CNPJ){
			documentoInvalido = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CNPJ_INVALIDO").toString();
		}

		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AdicionarNovo").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").setText(documentoInvalido);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").typeKeys("\n");
		autInsertScreenByScenario();
		String message = AUT_AGENT_SILK4J.<DomElement>find("VA.Validacao.DadosInvalidos").getText();
		String expected = "Digite um documento válido";
		Assert.assertEquals(message, expected);
		autInsertScreenByScenario();

		autVALogOff();

	}



	public void autCadastroFilhoPJExcecao(String numeroDocumento, String usuario, String senha, AUT_VA_TIPO_CONTATO tipoTelefone, AUT_VA_TIPO_ENDERECO tipoEndereco, AUT_VA_TIPO_RESIDENCIA tipoImovel, AUT_VA_PROPRIEDADE_RESIDENCIA propriedadeImovel) { //PS.passsar o número do documento
		autInitWebApplicationVA();
		autLoginVA(usuario,senha);

		String nomeFantasiaPJExcecao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME_PJ_FANTASIA2").toString();
		String nomeCompleto = autGetCurrentParameter("AUT_NOME_COMPLETO").toString();
		String email = autGetCurrentParameter("AUT_EMAIL").toString();
		String numeroTelefone = autGetCurrentParameter("AUT_NUMERO_TELEFONE_2").toString();

		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo").click();		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").click();	
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").setText(numeroDocumento);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosBasicos").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.NomeFantasia").setText(nomeFantasiaPJExcecao);
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosBasicos").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosParaContato").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.NomeCompleto").setText(nomeCompleto);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.Email").setText(email);
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosParaContato").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosTelefonicos").click();

		if (AUT_AGENT_SILK4J.<BrowserWindow>find("VA.CadastroClientesDados").exists("NumeroTelefone", 1000)) {
			AUT_AGENT_SILK4J.<DomListBox>find("VA.PJExcecao.TipoTelefone").select(tipoTelefone.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.NumeroTelefone").setText(numeroTelefone);
		}

		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.PJExcecao.NovidadesTelefone").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.PJExcecao.NovidadesTelefone").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosTelefonicos").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.PJExcecao.NovidadesTelefone").select();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.Endereco").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.PJExcecao.NovidadesEndereco").select();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.Endereco").click();

		AUT_AGENT_SILK4J.<DomButton>find("VA.PJExcecao.Salvar").click();

		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.DadosTelefonicos").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.PJExcecao.TipoTelefone").select(tipoTelefone.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.NumeroTelefone").clearText();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.NumeroTelefone").setText(numeroTelefone);
		AUT_AGENT_SILK4J.<DomButton>find("VA.PJExcecao.Salvar").click();

		AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-AUTVA-SPRINT02-CADASTRO");
		autVALogOff();
	}

	public void autCadastroClienteCEPInvalido(String usuario, String senha, AUT_VA_CADASTROS tipoPessoa, AUT_VA_TIPO_CONTATO tipoTelefone) {
		autInitWebApplicationVA();
		autLoginVA(usuario, senha);
		telefone = 1;
		multiplosEnderecos = 1;
		cepInvalido = 2;

		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", tipoPessoa);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");	

		//TIPO TELEFONE
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone);
		AUT_VA_TIPO_CONTATO opContato = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		autCadastrarCliente(opCadastro);

	}



	/**
	 * 
	 * Cadastro de Estados
	 * 
	 * @author Softtek-QA
	 *
	 */
	public enum AUT_VA_ESTADOS{
		AC,
		AL,
		AP,
		AM,
		BA,
		CE,
		DF,
		ES,
		GO,
		MA,
		MT,
		MS,
		MG,
		PA,
		PB,
		PR,
		PE,
		PI,
		RJ,
		RN,
		RS,
		RO,
		RR,
		SC,
		SP,
		SE,
		TO,
		FORMAT;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case FORMAT:{
				return "%s";							
			}			
			}
			return String.format(FORMAT.toString(), this.name());
		}		
	}


	public enum AUT_VA_TIPO_ENDERECO{
		RESIDENCIAL,
		COMERCIAL,
		ENTREGA,
		COBRANCA,
		OBRA;

		@Override
		public String toString() {
			// TODO Auto-generated method stub

			switch(this) {
			case COBRANCA:
			{
				return "Cobrança";
			}
			case COMERCIAL:{
				return "Comercial";
			}
			case ENTREGA:{
				return "Entrega";
			}
			case OBRA:{
				return "Obra";
			}
			case RESIDENCIAL:{
				return "Residencial";
			}
			}
			return super.toString();
		}
	}
	/**
	 *  
	 * Enumera as opções para os tipos de residencia
	 * 
	 * 
	 * @author Softtek-QA
	 *
	 */
	public enum AUT_VA_TIPO_RESIDENCIA{
		CASA,
		APARTAMENTO,
		CONDOMINIO,
		LOJA_OU_SOBRELOJA,
		SALA_OU_CONJUNTO_COMERCIAL,
		RURAL_CHACARA_FAZENDA_OU_SITIO,
		DEPOSITO_OU_GALPAO,
		TERRENO_OU_LOTEAMENTO,
		BOX_OU_STAND,
		OUTROS;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case APARTAMENTO:{
				return "Apartamento";
			}
			case BOX_OU_STAND:{
				return "Box ou Stand";
			}
			case CASA:{
				return "Casa";
			}
			case CONDOMINIO:{
				return "Condomínio";
			}
			case DEPOSITO_OU_GALPAO:{
				return "Depósito ou Galpão";
			}
			case LOJA_OU_SOBRELOJA:{
				return "Loja ou SobreLoja";
			}
			case OUTROS:{
				return "Outros";
			}
			case RURAL_CHACARA_FAZENDA_OU_SITIO:{
				return "Rural, Chácara, Fazenda ou Sítio";
			}
			case SALA_OU_CONJUNTO_COMERCIAL:{
				return "Sala ou Conjunto Comercial";
			}
			case TERRENO_OU_LOTEAMENTO:{
				return "Terreno ou Loteamento";
			}
			}
			return super.toString();
		}
	}

	public enum AUT_VA_TIPO_CONTATO{
		TELEFONE_FIXO,
		CELULAR;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case CELULAR:{
				return "Celular";
			}
			case TELEFONE_FIXO:{
				return "Fixo";
			}
			}
			return super.toString();
		}
	}



	public void autSetHostExecutionService(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
	}

	public void autCadastroClienteVA(String usuario, String senha, AUT_VA_CADASTROS tipoPessoa, AUT_VA_TIPO_CONTATO tipoTelefone, AUT_VA_TIPO_ENDERECO tipoEndereco, AUT_VA_TIPO_RESIDENCIA tipoResidencia) {
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
		autInitWebApplicationVA();
		autLoginVA(usuario, senha);
		autInsertScreenByScenario();
		telefone = 1;
		multiplosEnderecos = 1;
		cepInvalido = 1;
		autInsertScreenByScenario();
		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", tipoPessoa);
		//AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

		//TIPO TELEFONE
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone);
		AUT_VA_TIPO_CONTATO opTipoTelefone = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", tipoEndereco);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");

		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", tipoResidencia);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");
		autInsertScreenByScenario();
		autCadastrarCliente(tipoPessoa);
	}	


	public void autCadastroClientePJExcecao(String documento,String usuario, String senha, boolean cadastroPrevio) {
		autInitWebApplicationVA();
		autLoginVA(AUT_AGENT_SILK4J,usuario, senha);
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PJExcecao.SubMenuPJExcecao").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.PJExcecao.CNPJ").setText(documento);
		AUT_AGENT_SILK4J.<DomButton>find("VA.PJExcecao.Cadastrar").click();

		if (cadastroPrevio) {
			String popUp = AUT_AGENT_SILK4J.<DomElement>find("VA.Validacao.PJExecaoDuplicado").getText();
			String mensagem = "Esse CNPJ já está cadastrado.";
			autInsertScreenByScenario();
			Assert.assertEquals(popUp, mensagem);
			autInsertScreenByScenario();
		}
		autVALogOff();

	}	

	/**
	 * 
	 * Inclusão de parametros de cadastro pessoa jurídica
	 * 
	 */
	public void autCadastrarPJ(){

		String razaoSocial = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NOME_PJ").toString();
		String razaoFantasia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NOME_PJ_FANTASIA").toString();
		String inscricaoEstadual = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_INCRICAO_ESTADUAL").toString();
		String inscricaoMunicipal = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_INCRICAO_MUNICIPAL").toString();
		String nomeContato = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NOME_PJ_CONTATO").toString();
		String emailContato = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_PJ_EMAIL_CONTATO").toString();
		String departamentoContato = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_PJ_DEPARTAMENTO_CONTATO").toString();
		AUT_VA_TIPO_CONTATO numeroTipoTelefoneContato = AUT_VA_TIPO_CONTATO.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE").toString());
		String numeroTelefoneContato = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NUMERO_TELEFONE").toString();
		String inscricaoEstadualEstra = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_INCRICAO_ESTADUAL").toString();

		DomTextField txtNomeSocial = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.RazaoSocial");
		DomTextField txtRazaoFantasia = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeFantasia");
		DomTextField txtInscricaoEstadual = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoEstadual");
		DomTextField txtInscricaoMunicipal = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoMunicipal");
		DomTextField txtNomeContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeContato");
		DomTextField txtEmailContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.EmailContato");
		DomTextField txtDepartamentoContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Departamento");
		DomListBox listNumeroTipoTelefoneContato = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoTelefone");
		DomTextField txtNumeroTelefoneContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NumeroTelefone");
		autInsertScreenByScenario();
		txtNomeSocial.click();
		txtNomeSocial.setText(razaoFantasia);

		txtRazaoFantasia.click();
		txtRazaoFantasia.setText(razaoFantasia);

		txtInscricaoEstadual.click();
		txtInscricaoEstadual.typeKeys(inscricaoEstadualEstra);
		autInsertScreenByScenario();
		txtInscricaoMunicipal.click();
		txtInscricaoMunicipal.typeKeys(inscricaoMunicipal);
		autInsertScreenByScenario();

		txtNomeContato.click();
		txtNomeContato.setText(nomeContato);

		txtEmailContato.click();
		txtEmailContato.setText(emailContato);
		autInsertScreenByScenario();

		txtDepartamentoContato.click();
		txtDepartamentoContato.setText(departamentoContato);

		listNumeroTipoTelefoneContato.click();
		listNumeroTipoTelefoneContato.select(numeroTipoTelefoneContato.toString());
		autInsertScreenByScenario();
		txtNumeroTelefoneContato.click();
		txtNumeroTelefoneContato.setText(numeroTelefoneContato);
		autInsertScreenByScenario();


		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoSMS").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoPropagLeroy").click();

		String endereco = autGetCurrentParameter( "AUT_ENDERECO_PESQUISA").toString();

		autSearchCEP();

		AUT_VA_TIPO_ENDERECO tipoEndereco = AUT_VA_TIPO_ENDERECO.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO").toString());
		String cep = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_REFERENCIA_ENDERECO").toString();
		AUT_VA_TIPO_RESIDENCIA tipoImovelResidencia = AUT_VA_TIPO_RESIDENCIA.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA").toString());



		DomListBox slctTipoEndereco = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.Endereco");
		DomTextField numCep = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.CEP");
		DomTextField txtNomeRua = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeRua");
		DomTextField txtNumeroLocal = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NumeroLocal");
		DomTextField txtBairro = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Bairro");
		DomTextField txtCidade = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Cidade");

		slctTipoEndereco.click();
		slctTipoEndereco.select(tipoEndereco.toString());

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.CEP").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.CEP").typeKeys(cep);
		com.borland.silktest.jtf.Utils.sleep(1000 * 5);
		if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.PesquisaCEP").exists("MensagemSistemaIndisponivel", 5000)) {
			AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.BotaoConfirmar").click();		
		}

		txtNomeRua.setText(nomeRuaEndereco);
		txtNumeroLocal.setText(numeroEndereco);
		txtBairro.setText(bairroResidencia);
		txtCidade.setText(cidadeResidencia);
		autInsertScreenByScenario();

		DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesPJ.Avancar");
		btCadastroPFAvanc.click();
		autInsertScreenByScenario();

		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro");
		autInsertScreenByScenario();
		btCadastroPFAvanc2.click();
		autInsertScreenByScenario();

		try {
			DomElement btNovidadesN = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.RadioNovidades");
			btNovidadesN.click();
		}
		catch(java.lang.Exception e) {

		}

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro").click();

		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.RadioMalaDireta").click();

		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro").click();
		com.borland.silktest.jtf.Utils.sleep(1000 * 4);
		autInsertScreenByScenario();
		
		try {
			//AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");		
		}
		catch(java.lang.Exception e) {

		}
	}



	/**
	 * 
	 * Inclusão de parametros para cadastro de cliente estrangeiro
	 * 
	 */
	public void autCadastrarEstrangeiro() {
		System.out.println("****** AUT INFO: INICIANDO CADASTRO DE CLIENTE ESTRANGEIRO : PASSAPORTE *****");
		AUT_TABLE_PARAMETERS_NAMES.RSP_PJTTRC_FRT001_VA_MD00001_CN00003_CTP00001.name();
		String nomeCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME_ESTRANGEIRO").toString();
		String passaPorteCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
		String emailCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_EMAIL").toString();
		AUT_VA_TIPO_CONTATO tipoContatoCliente = AUT_VA_TIPO_CONTATO.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_TIPO_TELEFONE").toString());
		String numeroTelefoneCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NUMERO_TELEFONE").toString();
		AUT_VA_TIPO_ENDERECO tipoEnderecoCliente = AUT_VA_TIPO_ENDERECO.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_TIPO_ENDERECO").toString());
		
		DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Nome");
		DomTextField numeroPassaPorte = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.PassaPorte");
		DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Email");
		DomListBox tipoTel = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoTelefone");
		DomTextField numeroTel = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroTelefone");
		DomListBox tipoEndereco = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoImovel");

		nome.click();
		nome.setText(nomeCliente);
		numeroPassaPorte.click();
		numeroPassaPorte.setText(passaPorteCliente);
		email.click();
		email.setText(emailCliente);
		autInsertScreenByScenario();


		tipoTel.click();
		tipoTel.select(tipoContatoCliente.toString());

		numeroTel.setFocus();
		numeroTel.click();
		numeroTel.setText(numeroTelefoneCliente);
		numeroTel.setFocus();
		numeroTel.click();
		autInsertScreenByScenario();


		tipoEndereco.click();
		tipoEndereco.select(tipoEnderecoCliente.toString());

		String endereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_ENDERECO_PESQUISA").toString();

		autSearchCEP();

		String cep = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_REFERENCIA_ENDERECO").toString();
		String tipoImovelResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA").toString();

		DomTextField txtCEPEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.CEP");
		DomTextField txtRuaCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroCasa");
		DomTextField txtNumeroCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroCasa");
		DomTextField txtBairroEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Bairro");
		DomTextField txtComplementoResidEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Complemento");
		DomTextField txtCidadeEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Cidade");
		DomListBox txtEstadoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.Estado");
		DomTextField txtReferenciaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Referencia");
		DomListBox txtTipoImovelResidEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoImovelResidencial");

		tipoEndereco.click();
		tipoEndereco.select(tipoEnderecoCliente.toString());

		txtCEPEnd.click();
		txtCEPEnd.setText(cep);

		txtRuaCasaEnd.click();
		txtRuaCasaEnd.setText(nomeRuaEndereco);

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Rua").setText(endereco);

		txtNumeroCasaEnd.click();
		txtNumeroCasaEnd.setText(numeroEndereco);

		txtBairroEnd.click();
		txtBairroEnd.setText(bairroResidencia);

		txtComplementoResidEnd.click();
		txtComplementoResidEnd.setText(complementoResidencia);

		txtCidadeEnd.click();
		txtCidadeEnd.setText(cidadeResidencia);

		txtEstadoEnd.click();
		txtEstadoEnd.select(estadoResidencia);

		txtReferenciaEnd.click();
		txtReferenciaEnd.setText(referenciaResidencia);

		txtTipoImovelResidEnd.click();
		txtTipoImovelResidEnd.select(tipoImovelResidencia);

		DomRadioButton btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");
		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();

		DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro");

		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS").click();

		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();


		try {
			btCadastroPFAvanc.click();

			btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");

			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			DomElement btCheckMalaDirectAceit = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");

			btCheckMalaDirectAceit.click();
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").click();
		}
		catch(java.lang.Exception e ) {

		}

		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesEstrangeiro.CheckItemPromocoes").click();

		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro");
		autInsertScreenByScenario();
		Thread th = new Thread(
				new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						com.borland.silktest.jtf.Utils.sleep(8000);
						try {
							java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im chrome*");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

		th.start();
		btCadastroPFAvanc2.click();	
		
		autInsertScreenByScenario();		
		System.out.println("AUT INFO: STOP CAD ESTRANGEIRO: TEST");
	
		//AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");			


	}





	public void autSearchCEP() {
		try {
			DomButton btPesquisarCEP = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.NaoSeiCEPPesquisa");
			btPesquisarCEP.click();

			String UFEnderecoPesquisa = autGetCurrentParameter( "AUT_UF_PESQUISA").toString();
			String cidade = autGetCurrentParameter( "AUT_CIDADE_PESQUISA").toString();
			String endereco = autGetCurrentParameter( "AUT_ENDERECO_PESQUISA").toString();
			String bairro = autGetCurrentParameter( "AUT_BAIRRO_PESQUISA").toString();

			DomListBox listUF = AUT_AGENT_SILK4J.<DomListBox>find("VA.PesquisaCEP.UF");

			listUF.click();
			listUF.domClick();
			listUF.select(UFEnderecoPesquisa);

			DomTextField txtCidadePesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Cidade");
			DomTextField txtEnderecoPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Endereco");
			DomTextField txtBairroPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Bairro");

			txtCidadePesquisa.click();
			txtCidadePesquisa.setText(cidade);
			autInsertScreenByScenario();


			txtEnderecoPesquisa.click();
			txtEnderecoPesquisa.setText(endereco);

			txtBairroPesquisa.click();
			txtBairroPesquisa.setText(bairro);

			DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");


			btBuscarEndereco.click();
			autInsertScreenByScenario();

			if(!AUT_AGENT_SILK4J.<BrowserWindow>find("VA.PesquisaCEP").exists("MsgStatusCEP",10000)) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
			}
			else {

				DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

				itemSelectResultPesquisa.click();		
			}
		}
		catch(java.lang.Exception e) {
			boolean cepNaoCadastro = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.PesquisaCEP").exists("ItemResultadoPesqSelecionado", 5000);
			if(!cepNaoCadastro) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
			}
		}
	}

	/**
	 * 
	 * Inclusão os parametros de cadastro para pessoa física
	 * 
	 */
	public void autCadastrarPF() {
		String clienteNome = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NOME").toString();
		String clienteEmail = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_EMAIL").toString();
		String ClienteInscricao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_INCRICAO_ESTADUAL_PF").toString();

		DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Nome");
		DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Email");
		DomTextField numeroInscEstatual = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.InscricaoEstadual");

		nome.click();
		nome.domClick();
		nome.setText(clienteNome);
		autInsertScreenByScenario();

		email.click();
		email.domClick();
		email.setText(clienteEmail);
		autInsertScreenByScenario();

		numeroInscEstatual.click();
		numeroInscEstatual.domClick();
		//numeroInscEstatual.setText(ClienteInscricao);
		autInsertScreenByScenario();

		String tipoTelefone = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE")
				.toString();
		String numeroTelefone = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NUMERO_TELEFONE").toString();

		DomListBox listaTipoElement = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoTelefone");
		listaTipoElement.click();
		listaTipoElement.select(tipoTelefone);

		DomTextField txtNumeroContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroTelefone");
		txtNumeroContato.click();
		txtNumeroContato.domClick();
		txtNumeroContato.setText(numeroTelefone);

		txtNumeroContato.click();
		txtNumeroContato.setFocus();
		txtNumeroContato.domClick();
		String endereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_ENDERECO_PESQUISA").toString();

		autSearchCEP();

		autInsertScreenByScenario();
		String tipoEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO").toString();
		String cep = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_REFERENCIA_ENDERECO").toString();
		String tipoImovelResidencia = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA").toString();

		DomListBox listTipoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoEndereco");
		DomTextField txtCEPEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.CEP");
		DomTextField txtNumeroCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroCasa");
		DomTextField txtBairroEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Bairro");
		DomTextField txtComplementoResidEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Complemento");
		DomTextField txtCidadeEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Cidade");
		DomListBox txtEstadoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Estado");
		DomTextField txtReferenciaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Referencia");
		DomListBox txtTipoImovelResidEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoImovelResidencial");

		listTipoEnd.click();
		listTipoEnd.select(tipoEndereco);
		autInsertScreenByScenario();

		txtCEPEnd.click();
		txtCEPEnd.setText(cep);
		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NomeRua").setText(endereco);

		txtNumeroCasaEnd.click();
		txtNumeroCasaEnd.setText(numeroEndereco);

		txtBairroEnd.click();
		txtBairroEnd.setText(bairroResidencia);

		txtComplementoResidEnd.click();
		txtComplementoResidEnd.setText(complementoResidencia);
		autInsertScreenByScenario();

		txtCidadeEnd.click();
		txtCidadeEnd.setText(cidadeResidencia);
		autInsertScreenByScenario();


		txtEstadoEnd.click();
		txtEstadoEnd.select(estadoResidencia);
		autInsertScreenByScenario();


		txtReferenciaEnd.click();
		txtReferenciaEnd.setText(referenciaResidencia);

		txtTipoImovelResidEnd.click();
		txtTipoImovelResidEnd.select(tipoImovelResidencia);

		DomRadioButton btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");
		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();
		autInsertScreenByScenario();

		DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro");

		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS").click();

		btCheckAceitaNovidProp.select();
		btCheckAceitaNovidProp.click();
		btCheckAceitaNovidProp.select();
		try {
			btCadastroPFAvanc.click();

			btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");

			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			DomElement btCheckMalaDirectAceit = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");

			btCheckMalaDirectAceit.click();
			autInsertScreenByScenario();
			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").click();
		}
		catch(java.lang.Exception e ) {

		}
		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro2");
		autInsertScreenByScenario();
		btCadastroPFAvanc2.click();
		autInsertScreenByScenario();
	}



	public void autCadastrarCliente(AUT_VA_CADASTROS tipoCadastro) {
		
		DomElement menuClient = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal");
		menuClient.click();
		DomElement subMenuCliente = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes");
		subMenuCliente.click();
		DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
		String numCPF = "";
		String numCNPJ = "";
		String numPassPorte = "";
		String tpDocCadastro = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO").toString();
		
		AUT_VA_CADASTROS tpCadastroConfig =  AUT_VA_CADASTROS.valueOf(tpDocCadastro);

		switch(tpCadastroConfig) {
		case ESTRANGEIRO:{
			btAddNovoClient.click();
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.ClienteEstrangeiro").check();			
			numPassPorte = autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
			AUT_NUMERO_DOC_PASSAPORTE_OUTPUT = numPassPorte;
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_PASSAPORTE", numPassPorte);
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME_ESTRANGEIRO","AUT NOME EST: ".concat(numPassPorte));			
			autCadastrarEstrangeiro();

			break;
		}
		case FISICA:{
			btAddNovoClient.click();
			DomTextField numeroDoc = null;
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCPF = autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CPF").toString();
			AUT_NUMERO_DOC_CPF_OUTPUT = numCPF;
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CPF", numCPF);
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME","AUT NOME PF: ".concat(numCPF));
			
			numeroDoc.typeKeys(numCPF);
			autCadastrarPF();
			break;
		}
		case JURIDICA:{
			DomTextField txtNumDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroDocumento");
			numCNPJ = autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CNPJ").toString();
			AUT_NUMERO_DOC_CNPJ_OUTPUT = numCNPJ;
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CNPJ", numCNPJ);
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME_PJ","AUT NOME PJ: ".concat(numCPF));
			
			txtNumDoc.typeKeys(numCNPJ,500);

			btAddNovoClient.click();

			autInsertScreenByScenario();
			DomTextField numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");

			numeroDoc.click();
			numeroDoc.setText(numCNPJ);
			numeroDoc.typeKeys("\n");		
			autCadastrarPJ();
			break;
		}		
		}

	}



	/*
	 * CADASTRO DE CLIENTES - VA-VENDAS ASSISTIDAS
	 * 
	 */

	
	public void autInitClientMenuCadastroPF() {

		autInitWebApplicationVA();
		autStartLoginDefaultVA();

		autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO");
		AUT_VA_CADASTROS opCadastro = AUT_VA_CADASTROS.FISICA;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO", opCadastro.toString());

		
		AUT_VA_TIPO_ENDERECO opTipoEndereco = AUT_VA_TIPO_ENDERECO.RESIDENCIAL;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO", opTipoEndereco.toString());


		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = AUT_VA_TIPO_RESIDENCIA.CONDOMINIO;		
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA", opTipoResidencia.toString());

		AUT_VA_TIPO_CONTATO opTipoContact = AUT_VA_TIPO_CONTATO.CELULAR;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE", opTipoContact.toString());
				
		autCadastrarCliente(opCadastro);
	}	



	public void autInitClientMenuCadastroPJ() {
		autInitWebApplicationVA();
		autStartLoginDefaultVA();
		//TIPO PESSOA
		AUT_VA_CADASTROS opCadastro = AUT_VA_CADASTROS.JURIDICA;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO", opCadastro.toString());

		
		AUT_VA_TIPO_ENDERECO opTipoEndereco = AUT_VA_TIPO_ENDERECO.COMERCIAL;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO", opTipoEndereco.name());
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO", opTipoEndereco.name());

		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = AUT_VA_TIPO_RESIDENCIA.DEPOSITO_OU_GALPAO;		
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA", opTipoResidencia.name());

		AUT_VA_TIPO_CONTATO opTipoContact = AUT_VA_TIPO_CONTATO.CELULAR;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE", opTipoContact.name());

		autCadastrarCliente(opCadastro);
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
	}	



	public void autInitClientMenuCadastroExtrangeiro() {
		autInitWebApplicationVA();
		autStartLoginDefaultVA();
		//TIPO PESSOA
		AUT_VA_CADASTROS opCadastro = AUT_VA_CADASTROS.ESTRANGEIRO;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO", opCadastro.toString());

		
		AUT_VA_TIPO_ENDERECO opTipoEndereco = AUT_VA_TIPO_ENDERECO.RESIDENCIAL;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_ENDERECO", opTipoEndereco.name());


		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = AUT_VA_TIPO_RESIDENCIA.CASA;		
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_IMOVEL_RESIDENCIA", opTipoResidencia.toString());

		AUT_VA_TIPO_CONTATO opTipoContact = AUT_VA_TIPO_CONTATO.CELULAR;
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE", opTipoContact.name());

		
		autCadastrarCliente(opCadastro);
	}	


	@Test
	public void autCadastroClienteVA(AUT_VA_CADASTROS tipoPessoa, AUT_VA_TIPO_CONTATO tipoTelefone, AUT_VA_TIPO_ENDERECO tipoEndereco, AUT_VA_TIPO_RESIDENCIA tipoResidencia) {
		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", tipoPessoa);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

		//TIPO TELEFONE
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone);
		AUT_VA_TIPO_CONTATO opTipoTelefone = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", tipoEndereco);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");

		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", tipoResidencia);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");

		autCadastrarCliente(opCadastro);
	}	

	@Test
	public void autCadastroClienteMultiplosTelefonesVA(String usuario, String senha, AUT_VA_CADASTROS tipoPessoa, AUT_VA_TIPO_CONTATO tipoTelefone, AUT_VA_TIPO_CONTATO tipoTelefone2, AUT_VA_TIPO_ENDERECO tipoEndereco, AUT_VA_TIPO_RESIDENCIA tipoResidencia) {
		autInitWebApplicationVA();
		autLoginVA(usuario, senha);
		autInsertScreenByScenario();
		telefone = 2;
		multiplosEnderecos = 1;
		cepInvalido = 1;

		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", tipoPessoa);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");
		autInsertScreenByScenario();
		//TIPO TELEFONE
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone);
		AUT_VA_TIPO_CONTATO opTipoTelefone = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		//TIPO TELEFONE2
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone2);
		AUT_VA_TIPO_CONTATO opTipoTelefone2 = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", tipoEndereco);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");

		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", tipoResidencia);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");

		autCadastrarCliente(opCadastro);
	}	


	@Test
	public void autCadastroClienteMultiplosEnderecosVA(String usuario, String senha, AUT_VA_CADASTROS tipoPessoa, AUT_VA_TIPO_CONTATO tipoTelefone, AUT_VA_TIPO_ENDERECO tipoEndereco, AUT_VA_TIPO_RESIDENCIA tipoResidencia, AUT_VA_TIPO_ENDERECO tipoEndereco2, AUT_VA_TIPO_RESIDENCIA tipoResidencia2) {
		autInitWebApplicationVA();
		autLoginVA(usuario, senha);
		telefone = 1;
		multiplosEnderecos = 2;
		cepInvalido = 1;

		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", tipoPessoa);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

		//TIPO TELEFONE
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_TELEFONE");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_TELEFONE", tipoTelefone);
		AUT_VA_TIPO_CONTATO opTipoTelefone = (AUT_VA_TIPO_CONTATO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_TELEFONE");

		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", tipoEndereco);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");

		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", tipoResidencia);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");

		//TIPO ENDERECO2
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", tipoEndereco2);
		AUT_VA_TIPO_ENDERECO opTipoEndereco2 = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");

		//TIPO RESIDENCIA2
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", tipoResidencia2);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia2 = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");


		autCadastrarCliente(opCadastro);
	}


}


