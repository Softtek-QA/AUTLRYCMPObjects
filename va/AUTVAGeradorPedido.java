/**
 * 
 */
package br.lry.components.va;

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
import br.lry.components.va.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTProjectsFunctions;

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
	public String AUT_CLIENT_DOC_CPF = null, AUT_CLIENT_DOC_CNPJ=null, AUT_CLIENT_DOC_PASSAPORT=null, AUT_VA_USER = null, AUT_VA_PASSWORD=null;
	public AUT_VA_CADASTROS AUT_CLIENT_TYPE = null;	
	private Desktop AUT_AGENT_SILK4J = new Desktop();


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
		SEM_JUROS_CELEBRE_2X;
		
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
			case SEM_JUROS_CELEBRE_2X: {
				return "2X SEM JUROS CELEBRE";
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
	
	
	
	public void aut_test() {
		
	}
	
	
	@Test
	/**
	 *  SCRIPT DE GERACAO DE PEDIDOS
	 */
	public void autVAGeracaoPedidos(String usuario, String senha, String fluxoSaida, String meioPagamento, String planoPagamento) {
		
		String quantidadeItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_QUANTIDADE_ITEM").toString();
		String codigoItem = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS,"AUT_CODIGO_ITEM").toString();	
		String numeroCartao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NUMERO_CARTAO").toString();
		String nomeTitular = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NOME_TITULAR").toString();
		String validade = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_VALIDADE").toString();
		String codigo = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_CARTAO").toString();
		
		
		String docCliente = (String)(AUT_CLIENT_TYPE==null || AUT_CLIENT_TYPE==AUT_VA_CADASTROS.FISICA ? AUT_CLIENT_DOC_CPF : 
			(AUT_CLIENT_TYPE==AUT_VA_CADASTROS.ESTRANGEIRO ? AUT_CLIENT_DOC_PASSAPORT : 
				(AUT_CLIENT_TYPE==AUT_VA_CADASTROS.JURIDICA ? AUT_CLIENT_DOC_CNPJ : "000000000")));

		
		autStartLoginDefault(usuario, senha);

		AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaInicialLoja.QuantidadeItem").setText(quantidadeItem);
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaInicialLoja.CodigoItem").setText(codigoItem);
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaInicialLoja.PesquisarProduto").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.ConverterPedido").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Usuario").clearText();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.ConfirmacaoLogin.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.ConfirmacaoLogin.Avancar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();
		
		if(fluxoSaida == AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoCaixa").select();
		}else { 
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(fluxoSaida);//AUT_VA_TIPO_RETIRADA.REITRADA_INTERNA_IMEDIATA.toString());
		}
		
		AUT_AGENT_SILK4J.<DomButton>find("VA02.FluxoSaida.Avancar").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").select(meioPagamento);
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.PlanoPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.PlanoPagamento").select(planoPagamento);
		
		if(meioPagamento != AUT_VA_MEIOS_PAGAMENTO.DINHEIRO.toString()) {
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NumeroCartao").setText(numeroCartao);
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NomeTitular").setText(nomeTitular);
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Validade").setText(validade);
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Codigo").setText(codigo);
		}
	
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaMeioPagamento.Avancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaResumo.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.TelaResumo.FecharPopUp").click();
		AUT_AGENT_SILK4J.verifyAsset("CHECKPOINT-AUTVA02GERADORPEDIDOS001");
		AUT_AGENT_SILK4J.<DomElement>find("VA02.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}
	
	

	
	
	
	public AUTVAGeradorPedido() {
		super();
	}
}
