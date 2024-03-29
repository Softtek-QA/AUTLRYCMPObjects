/**
 * 
 */
package br.lry.components.va;

import java.util.regex.Matcher;

import org.junit.After;
import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.va.AUTVACadastros.AUT_VA_CADASTROS;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_CONTATO;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_MEIOS_PAGAMENTO;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_PLANO_PAGAMENTO;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTProjectsFunctions;
import br.lry.functions.AUTVAProjectFunctions;

import com.borland.silktest.jtf.win32.AccessibleControl;

/**
 * 
 * Gerador de pedidos no VA, objetivos principais:
 * 
 * -Deve gerar pedidos no com fluxo de saída variável -  Caixa, Interna Imediata e Externa Imediata
 * -Deve variar as formas de pagamento - Dinheiro e cartão
 * 
 * @author Softtek - QA
 *
 */


public class AUTVAGeradorPedido extends AUTVALogin {
	public static String AUT_CURRENT_DOC=null,AUT_CLIENT_DOC_CPF = null, AUT_CLIENT_DOC_CNPJ=null, AUT_CLIENT_DOC_PASSAPORT=null, AUT_VA_USER = null, AUT_VA_PASSWORD=null;
	public AUT_VA_CADASTROS AUT_CLIENT_TYPE = null;	
	public String currentDocument="";
	public String AUT_NUMERO_PEDIDO;

	public enum AUT_VA_MEIOS_PAGAMENTO{
		CARTAO_CREDITO,
		CARTAO_CELEBRE,
		POS_CREDITO,
		FINANCEIRA_CDC,
		DINHEIRO,
		CARTAO_DEBITO,
		POS_DEBITO,
		CHEQUE,
		VOUCHER,
		VALE_TROCA;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case CARTAO_CREDITO: {
				return "C. CRÉDITO";
			}
			case CARTAO_CELEBRE: {
				return "CARTÃO PRÓPRIO";
			}
			case POS_CREDITO: {
				return "POS CRÉDITO";
			}
			case FINANCEIRA_CDC: {
				return "FINANCEIRA CDC";
			}
			case DINHEIRO: {
				return "DINHEIRO";
			}
			case CARTAO_DEBITO: {
				return "C. DÉBITO";
			}
			case POS_DEBITO: {
				return "POS DÉBITO";
			}
			case CHEQUE: {
				return "CHEQUE";
			}
			case VOUCHER: {
				return "VOUCHER";
			}
			case VALE_TROCA: {
				return "VALE TROCA";
			}
			}
			
			return super.toString();
		}
	}

	
	public enum AUT_VA_PLANO_PAGAMENTO{
		A_VISTA,
		SEM_JUROS_1X,
		SEM_JUROS_CELEBRE_1X;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case A_VISTA: {
				return "A VISTA";
			}
			
			case SEM_JUROS_1X: {
				return "1X SEM JUROS";
			}
			case SEM_JUROS_CELEBRE_1X: {
				return "1X SEM JUROS CELEBRE";
			}
			}
			return super.toString();
		}
	}
	
	
	public enum AUT_VA_FLUXO_SAIDA{
		CAIXA,
		REITRADA_EXTERNA_AGENDADA,
		REITRADA_EXTERNA_IMEDIATA,
		REITRADA_INTERNA_AGENDADA,
		REITRADA_INTERNA_IMEDIATA;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch (this) {
			case CAIXA: {
				return "Caixa";
			}
			case REITRADA_EXTERNA_AGENDADA: {
				return "Retira externa agendada";
			}
			case REITRADA_EXTERNA_IMEDIATA: {
				return "Retira externa imediata";
			}
			case REITRADA_INTERNA_AGENDADA: {
				return "Retira interna agendada";
			}
			case REITRADA_INTERNA_IMEDIATA: {
				return "Retira interna imediata";
			}
			}
			return super.toString();
		}
	}
	
	public void autSetHostExecutionService(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
	}
	
	public void aut_test() {
		
	}
	
	
	
	@Test
	/**
	 *  SCRIPT DE GERACAO DE PEDIDOS
	 */
	public void autVAGeracaoPedidos(String usuario, String senha, String fluxoSaida, String meioPagamento, String planoPagamento,String... documentos) {
		String quantidadeItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_QUANTIDADE_ITEM").toString();
		String codigoItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_CODIGO_ITEM").toString();	
		String numeroCartao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NUMERO_CARTAO").toString();
		String nomeTitular = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NOME_TITULAR").toString();
		String validade = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_VALIDADE").toString();
		String codigo = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_CARTAO").toString();
		
		
		String docCliente = documentos[0];

		autStartLoginDefault(usuario, senha);

		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys(codigoItem);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPesquisaBoitata.BtAdicionarCarrinho").click();
		
		
		//AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinhoCompra").click();
		//AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.IniciarNovoAtendimento").click();
		
		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.CriarCarrinho").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.QuantidadeItem").setText(quantidadeItem);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.CodigoItem").setText(codigoItem);
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.PesquisarProduto").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.ConverterPedido").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Usuario").clearText();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomElement>find("VA.ConfirmacaoLogin.Avancar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
			
		if(documentos.length >= 2) {
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.Passaporte").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setText(docCliente);		
			
		}
		else {
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		}
		
	
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.Avancar").click();
		
		if(fluxoSaida == AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoCaixa").select();
		}else { 
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(fluxoSaida);//AUT_VA_TIPO_RETIRADA.REITRADA_INTERNA_IMEDIATA.toString());
		}
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.FluxoSaida.Avancar").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").select(meioPagamento);
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").click();
		
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").select(planoPagamento);
		
		if(meioPagamento != AUT_VA_MEIOS_PAGAMENTO.DINHEIRO.toString()) {
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").setText(numeroCartao);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").setText(nomeTitular);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").setText(validade);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").setText(codigo);
		}
	
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.Avancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaResumo.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaResumo.FecharPopUp").click();
		//AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-AUTVAGERADORPEDIDOS001");

		
		String conteudoElemento = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroPedido").getText();

		java.util.regex.Pattern padrao = java.util.regex.Pattern.compile("\\d+");
		java.util.regex.Matcher analise = padrao.matcher(conteudoElemento);
		if(analise.find()) {
			AUT_NUMERO_PEDIDO = analise.group();
		}
		else {
			AUT_NUMERO_PEDIDO= "00000000000";
		}
		
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}
	
	
	public void autIncluirItemCarrinho(String material) {
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys(material);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPesquisaBoitata.BtAdicionarCarrinho").click();
	
	}
	
	public void autVAGeracaoPedidosV2(String usuario, String senha, String fluxoSaida, String meioPagamento, String planoPagamento,String... documentos) {
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {
			
		}
		
		
		String quantidadeItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_QUANTIDADE_ITEM").toString();
		String codigoItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_CODIGO_ITEM").toString();	
		String numeroCartao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NUMERO_CARTAO").toString();
		String nomeTitular = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NOME_TITULAR").toString();
		String validade = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_VALIDADE").toString();
		String codigo = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_CARTAO").toString();
		
		
		String docCliente = documentos[0];
		autInitWebApplicationBoitata();
		AUTVAProjectFunctions.autLoginBoitata(AUT_AGENT_SILK4J, 
				usuario,
				senha);
		
		
		
		
		autIncluirItemCarrinho(codigoItem); //Boitata
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.CriarCarrinho").click();
		//AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.QuantidadeItem").setText(quantidadeItem);
		//AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.CodigoItem").setText(codigoItem);
		//AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.PesquisarProduto").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.ConverterPedido").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Usuario").clearText();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.ConfirmacaoLogin.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomElement>find("VA.ConfirmacaoLogin.Avancar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
		autInsertScreenByScenario();
		
		switch(AUT_CLIENT_TYPE) {
		case ESTRANGEIRO:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.Passaporte").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setText(docCliente);					
			
			break;
		}
		case FISICA:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
			
			break;
		}
		case JURIDICA:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
			break;
		}
		
		}	
		
	
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.Avancar").click();
		autInsertScreenByScenario();
		
		if(fluxoSaida == AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoCaixa").select();
		}else { 
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(fluxoSaida);//AUT_VA_TIPO_RETIRADA.REITRADA_INTERNA_IMEDIATA.toString());
		}
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.FluxoSaida.Avancar").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").select(meioPagamento);
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").click();
		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").select(planoPagamento);
		
		if(meioPagamento != AUT_VA_MEIOS_PAGAMENTO.DINHEIRO.toString()) {
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").setText(numeroCartao);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").setText(nomeTitular);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").setText(validade);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").setText(codigo);
		}
	
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.Avancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaResumo.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaResumo.FecharPopUp").click();
		//AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-AUTVAGERADORPEDIDOS001");
		autInsertScreenByScenario();
		
		String conteudoElemento = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroPedido").getText();

		java.util.regex.Pattern padrao = java.util.regex.Pattern.compile("\\d+");
		java.util.regex.Matcher analise = padrao.matcher(conteudoElemento);
		if(analise.find()) {
			AUT_NUMERO_PEDIDO = analise.group();
		}
		else {
			AUT_NUMERO_PEDIDO= "00000000000";
		}
		
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}
	
	
	
	public AUTVAGeradorPedido() {
		super();
	}
}
