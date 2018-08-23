/**
 * 
 */
package br.lry.components.va;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sun.management.resources.agent;
import br.lry.dataflow.AUTDataFlow.*;
import com.borland.silktest.jtf.win32.AccessibleControl;
/**
 * 
 * Cadastro de pessoa Física
 * 
 * @author Softtek-QA
 * 
 *
 */
public class AUTVACadastros extends AUTVALogin {

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
	public enum AUT_VA_CADASTROS{
		FISICA,
		JURIDICA,
		ESTRANGEIRO;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}

	public void autCadastrarPF() {
		String clienteNome = autGetCurrentParameter("AUT_NOME").toString();
		String clienteEmail = autGetCurrentParameter("AUT_EMAIL").toString();
		String ClienteInscricao = autGetCurrentParameter( "AUT_INCRICAO_ESTADUAL").toString();

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
		
		AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-CADASTRO");		
	}
	
	
	public void autCadastrarCliente(AUT_VA_CADASTROS tipoCadastro) {
		
		
		DomElement menuClient = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal");
		menuClient.click();
		DomElement subMenuCliente = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes");
		subMenuCliente.click();
		DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
		btAddNovoClient.click();
		String numCPF = "";
		String numCNPJ = "";
		String numPassPorte = "";
		
		AUT_VA_CADASTROS tpCadastroConfig =  (AUT_VA_CADASTROS)autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF,"AUT_TIPO_CADASTRO");
		
		switch(tpCadastroConfig) {
		case ESTRANGEIRO:{
			DomTextField numeroDoc = null;
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_PASSAPORTE").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : ESTRANGEIRO - PASSA PORTE");
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.ClienteEstrangeiro").check();			
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_PASSAPORTE").toString();
			numeroDoc.typeKeys(numPassPorte);
			
			break;
		}
		case FISICA:{
			DomTextField numeroDoc = null;
			numCPF = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_CPF").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PF - CPF");			
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCPF = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_CPF").toString();
			numeroDoc.typeKeys(numCPF);
			autCadastrarPF();
			
			break;
		}
		case JURIDICA:{
			DomTextField numeroDoc = null;
			numCNPJ = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_CNPJ").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PJ - CNPJ");
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCNPJ = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTRO_PF, "AUT_CNPJ").toString();
			numeroDoc.typeKeys(numCNPJ);
			
			break;
		}
		default:{
			
		}
		}
		
		DomTextField numeroDoc = null;
	
		switch(tpCadastroConfig) {
		case ESTRANGEIRO:{

			break;
		}
		case FISICA:{

			break;
		}
		case JURIDICA:{
			break;
		}
		default:{
			
		}
		}
		
		
		
	}
	
		
	@Test
	public void autInitClientMenu() {
		
		autCadastrarCliente(AUT_VA_CADASTROS.FISICA);
		
		//end recording
	}

	
	/**
	 * 
	 * Cadastra pessoa física
	 * 
	 */
	public void autCadastrarPF(String nomeTabelaParametros) {

	}



	/**
	 * 
	 * Construtor padrão da classe
	 * 
	 */
	public AUTVACadastros() {
		super();
	}

}

