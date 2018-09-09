/**
 * 
 */
package br.lry.components.va;

import static org.junit.Assert.assertNotNull;

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
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_ENDERECO;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_RESIDENCIA;
import br.lry.dataflow.AUTDataFlow.*;
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
	public static String AUT_NUMERO_DOC_CPF_OUTPUT=null,AUT_NUMERO_DOC_CNPJ_OUTPUT=null,AUT_NUMERO_DOC_PASSAPORTE_OUTPUT=null;
	
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

	/**
	 * 
	 *Enumera as opções de configuração de configuração dos scripts de cadastro
	 *
	 *
	 * @author Softtek-QA
	 *
	 */
	public static enum AUT_VA_CADASTROS{
		FISICA,
		JURIDICA,
		ESTRANGEIRO;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
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
		AUT_VA_TIPO_CONTATO numeroTipoTelefoneContato = (AUT_VA_TIPO_CONTATO)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_TELEFONE");
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
		
		txtNomeSocial.click();
		txtNomeSocial.setText(razaoFantasia);
		
		txtRazaoFantasia.click();
		txtRazaoFantasia.setText(razaoFantasia);
		
		txtInscricaoEstadual.click();
		txtInscricaoEstadual.setText(inscricaoEstadualEstra);
		
		txtInscricaoMunicipal.click();
		txtInscricaoMunicipal.setText(inscricaoMunicipal);
		
		txtNomeContato.click();
		txtNomeContato.setText(nomeContato);
		
		txtEmailContato.click();
		txtEmailContato.setText(emailContato);
		
		txtDepartamentoContato.click();
		txtDepartamentoContato.setText(departamentoContato);
		
		listNumeroTipoTelefoneContato.click();
		listNumeroTipoTelefoneContato.select(numeroTipoTelefoneContato.toString());
		
		txtNumeroTelefoneContato.click();
		txtNumeroTelefoneContato.setText(numeroTelefoneContato);
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoSMS").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoPropagLeroy").click();
		
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

		txtEnderecoPesquisa.click();
		txtEnderecoPesquisa.setText(endereco);

		txtBairroPesquisa.click();
		txtBairroPesquisa.setText(bairro);

		DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");

		btBuscarEndereco.click();

		DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

		itemSelectResultPesquisa.click();
			
		String tipoEndereco = autGetCurrentParameter("AUT_TIPO_ENDERECO").toString();
		String cep = autGetCurrentParameter( "AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter( "AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter( "AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter( "AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter( "AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter( "AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter( "AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter( "AUT_REFERENCIA_ENDERECO").toString();
		String tipoImovelResidencia = autGetCurrentParameter( "AUT_TIPO_IMOVEL_RESIDENCIA").toString();
		
		
		
		DomListBox slctTipoEndereco = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.Endereco");
		DomTextField numCep = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.CEP");
		DomTextField txtNomeRua = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeRua");
		DomTextField txtNumeroLocal = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NumeroLocal");
		DomTextField txtBairro = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Bairro");
		DomTextField txtCidade = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Cidade");
		
		slctTipoEndereco.click();
		slctTipoEndereco.select(tipoEndereco.toString());
		numCep.setText(cep);
		txtNomeRua.setText(nomeRuaEndereco);
		txtNumeroLocal.setText(numeroEndereco);
		txtBairro.setText(bairroResidencia);
		txtCidade.setText(cidadeResidencia);
		
		
		/*AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesPJ.Avancar").click();
		
		DomTextField btNovidadesN = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.RadioNovidades");
		DomTextField btMalaDiretaN = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.RadioNovidades");
		
		btNovidadesN.click();
		btMalaDiretaN.click();
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesPJ.Avancar").click();*/
		DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesPJ.Avancar");
		btCadastroPFAvanc.click();
		
		DomElement btNovidadesN = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.RadioNovidades");
		btNovidadesN.click();
	//	btNovidadesN.domClick();
		
		DomElement btMalaDiretaN = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.RadioMalaDireta");
		btMalaDiretaN.click();	
	//	btMalaDiretaN.domClick();
					
		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro");

		btCadastroPFAvanc2.click();
		
		try {
			AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");		
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
		
		String nomeCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME_ESTRANGEIRO").toString();
		String passaPorteCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
		String emailCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_EMAIL").toString();
		AUT_VA_TIPO_CONTATO tipoContatoCliente = (AUT_VA_TIPO_CONTATO) autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_TIPO_TELEFONE");
		String numeroTelefoneCliente = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NUMERO_TELEFONE").toString();
		AUT_VA_TIPO_ENDERECO tipoEnderecoCliente = (AUT_VA_TIPO_ENDERECO) autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_TIPO_ENDERECO");
				
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
		

		tipoTel.click();
		tipoTel.select(tipoContatoCliente.toString());
		
		numeroTel.setFocus();
		numeroTel.click();
		numeroTel.setText(numeroTelefoneCliente);
		numeroTel.setFocus();
		numeroTel.click();
		
		tipoEndereco.click();
		tipoEndereco.select(tipoEnderecoCliente.toString());

		
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

		txtEnderecoPesquisa.click();
		txtEnderecoPesquisa.setText(endereco);

		txtBairroPesquisa.click();
		txtBairroPesquisa.setText(bairro);

		DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");

		btBuscarEndereco.click();

		DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

		itemSelectResultPesquisa.click();

		String cep = autGetCurrentParameter( "AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter( "AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter( "AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter( "AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter( "AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter( "AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter( "AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter( "AUT_REFERENCIA_ENDERECO").toString();
		String tipoImovelResidencia = autGetCurrentParameter( "AUT_TIPO_IMOVEL_RESIDENCIA").toString();

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
				
	
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesEstrangeiro.CheckItemPromocoes").click();
		
		DomButton btCadastroPFAvanc2 = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesEstrangeiro.BotaoAvancarCadastro");

		btCadastroPFAvanc2.click();
			
		
		AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");			
		
		
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * Inclusão os parametros de cadastro para pessoa física
	 * 
	 */
	public void autCadastrarPF() {
		String clienteNome = autGetCurrentParameter("AUT_NOME").toString();
		String clienteEmail = autGetCurrentParameter("AUT_EMAIL").toString();
		String ClienteInscricao = autGetCurrentParameter( "AUT_INCRICAO_ESTADUAL_PF").toString();

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

		String tipoTelefone = autGetCurrentParameter( "AUT_TIPO_TELEFONE")
				.toString();
		String numeroTelefone = autGetCurrentParameter( "AUT_NUMERO_TELEFONE").toString();

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

		txtEnderecoPesquisa.click();
		txtEnderecoPesquisa.setText(endereco);

		txtBairroPesquisa.click();
		txtBairroPesquisa.setText(bairro);

		DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");

		btBuscarEndereco.click();

		DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

		itemSelectResultPesquisa.click();

		String tipoEndereco = autGetCurrentParameter( "AUT_TIPO_ENDERECO").toString();
		String cep = autGetCurrentParameter( "AUT_CEP").toString();
		String nomeRuaEndereco = autGetCurrentParameter( "AUT_RUA_ENDERECO").toString();
		String numeroEndereco = autGetCurrentParameter( "AUT_NUMERO_ENDERECO").toString();
		String bairroResidencia = autGetCurrentParameter( "AUT_BAIRRO_ENDERECO").toString();
		String complementoResidencia = autGetCurrentParameter( "AUT_COMPLEMENTO_ENDERECO").toString();
		String cidadeResidencia = autGetCurrentParameter( "AUT_CIDADE_ENDERECO").toString();
		String estadoResidencia = autGetCurrentParameter( "AUT_ESTADO_ENDERECO").toString();
		String referenciaResidencia = autGetCurrentParameter( "AUT_REFERENCIA_ENDERECO").toString();
		String tipoImovelResidencia = autGetCurrentParameter( "AUT_TIPO_IMOVEL_RESIDENCIA").toString();

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
		
		try {
			AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");		
		}
		catch(java.lang.Exception e) {
			
		}
	}
	
	
	public void autCadastrarCliente(AUT_VA_CADASTROS tipoCadastro) {
		
		autInitWebApplication();
		autStartLoginDefault();
		DomElement menuClient = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal");
		menuClient.click();
		DomElement subMenuCliente = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes");
		subMenuCliente.click();
		DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
		
		String numCPF = "";
		String numCNPJ = "";
		String numPassPorte = "";
		
		AUT_VA_CADASTROS tpCadastroConfig =  (AUT_VA_CADASTROS)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_TIPO_CADASTRO");
		
		switch(tpCadastroConfig) {
		case ESTRANGEIRO:{
			btAddNovoClient.click();
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : ESTRANGEIRO - PASSA PORTE");
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.ClienteEstrangeiro").check();			
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
			AUT_NUMERO_DOC_PASSAPORTE_OUTPUT = numPassPorte;			
			autCadastrarEstrangeiro();
			
			break;
		}
		case FISICA:{
			btAddNovoClient.click();
			DomTextField numeroDoc = null;
			numCPF = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CPF").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PF - CPF");			
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCPF = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CPF").toString();
			AUT_NUMERO_DOC_CPF_OUTPUT = numCPF;
			numeroDoc.typeKeys(numCPF);
			autCadastrarPF();
			
			break;
		}
		case JURIDICA:{
			DomTextField txtNumDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.NumeroDocumento");
			
			numCNPJ = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CNPJ").toString();
			AUT_NUMERO_DOC_CNPJ_OUTPUT = numCNPJ;			
			txtNumDoc.typeKeys(numCNPJ,500);
			
			btAddNovoClient.click();
			
			
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
		
	@Test
	public void autInitClientMenuCadastroPF() {
		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", AUT_VA_CADASTROS.FISICA);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

				
		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", AUT_VA_TIPO_ENDERECO.COMERCIAL);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");
		
		
		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", AUT_VA_TIPO_RESIDENCIA.LOJA_OU_SOBRELOJA);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");
		
		
		autCadastrarCliente(opCadastro);
		
	}	
	
	
	@Test
	public void autInitClientMenuCadastroPJ() {
		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", AUT_VA_CADASTROS.JURIDICA);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

				
		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", AUT_VA_TIPO_ENDERECO.COMERCIAL);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");
		
		
		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", AUT_VA_TIPO_RESIDENCIA.LOJA_OU_SOBRELOJA);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");
		
		
		autCadastrarCliente(opCadastro);
		
	}	
	
	
	@Test
	public void autInitClientMenuCadastroExtrangeiro() {
		//TIPO PESSOA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_CADASTRO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_CADASTRO", AUT_VA_CADASTROS.ESTRANGEIRO);
		AUT_VA_CADASTROS opCadastro = (AUT_VA_CADASTROS) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_CADASTRO");

				
		//TIPO ENDERECO
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_ENDERECO");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_ENDERECO", AUT_VA_TIPO_ENDERECO.COMERCIAL);
		AUT_VA_TIPO_ENDERECO opTipoEndereco = (AUT_VA_TIPO_ENDERECO) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_ENDERECO");
		
		
		//TIPO RESIDENCIA
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).remove("AUT_TIPO_IMOVEL_RESIDENCIA");
		autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).put("AUT_TIPO_IMOVEL_RESIDENCIA", AUT_VA_TIPO_RESIDENCIA.LOJA_OU_SOBRELOJA);
		AUT_VA_TIPO_RESIDENCIA opTipoResidencia = (AUT_VA_TIPO_RESIDENCIA) autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS.toString()).get(1).get("AUT_TIPO_IMOVEL_RESIDENCIA");
		
		
		autCadastrarCliente(opCadastro);
		
	}	

}


