package br.lry.components.va.cat002;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVA03ConsultaStatusPedido;
import br.lry.components.va.cat016.AUTFinalizarPedidoVA;

public class AUTRecuperacao extends AUTVABaseComponent {
	
	
	public static String  AUT_NUMERO_CARRINHO;

	

	/**
	 * Recuperação de carrinho de compra
	 * @return - Verdadeiro para carrinho de compra recuperado
	 */
	public boolean autRecuperarCarrinho(java.util.HashMap parametros) {
		try {
			System.out.println("Parametros na Tela de Recuperaçaõ"+parametros);
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BuscarCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").typeKeys(parametros.get("AUT_NUMERO_CARRINHO").toString());
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.CopiarPedido").click();

			
			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

	
	/**
	 * Recuperação de pedido de compra
	 * @return - Verdadeiro para pedido de compra recuperado
	 */
	public boolean autRecuperarPedido(java.util.HashMap parametros) {

		AUTVA03ConsultaStatusPedido consultaPedido = new AUTVA03ConsultaStatusPedido();

		try {
			
			System.out.println("Parametros na Recuperacao"+parametros);

			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.Buscar pedidos").click();

			consultaPedido.AUTVA03ConsultaPedido(parametros.get("AUT_NUMERO_PEDIDO").toString());

			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.CopiarPedido").click();


			//boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPedidos").exists("PrecosVigentes", 10000);
			//if (status) {

			//	AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.PrecosVigentes").click();

			//}
			
			//Confirma Manter condição comercial
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("ManterCondicoes", 5000)){
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.ManterCondicoes").click();
			}
			
			//Confirma edição de pedido finalizado
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.Desconto").exists("PopUp1", 5000)){
				AUT_AGENT_SILK4J.<DomButton>find("VA.Desconto.Confirmar").click();
			}
			
			return true;

		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}


	}

	
	/**
	 * Recuperação de orçamento
	 * @return - Verdadeiro para orçamento recuperado
	 */
	public boolean autRecuperarOrcamento(java.util.HashMap parametros) {
		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.BotaoRecuperarOrcamento").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").typeKeys(parametros.get("AUT_NUMERO_PEDIDO").toString());

			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();

			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.CopiarPedido").click();

			boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPedidos").exists("PrecosVigentes", 10000);
			if (status) {

				AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.PrecosVigentes").click();

			}

			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

	
	/**
	 * Criação de carrinho de compra
	 * @return - Verdadeiro para opção carrinho de compra selecionado
	 */
	public boolean autCriarCarrinho() {
		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.CriarCarrinho").click();
			
			AUT_NUMERO_CARRINHO = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.NumeroCarrinho").getText();

			System.out.println("O número do carrinho é "+AUT_NUMERO_CARRINHO);
			
			
			
			
			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	
}
	
	
	/**
	 * Listagem das opções de inicialização de atendimento
	 * @author Softtek - QA
	 *
	 */
	public enum AUT_VA_INICIAR_ATENDIMENTO{
		CRIAR_CARRINHO,
		RECUPERAR_PEDIDO,
		RECUPERAR_ORCAMENTO,
		RECUPERAR_CARRINHO;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case CRIAR_CARRINHO: {
				return "Criar carrinho...";
			}
			case RECUPERAR_PEDIDO: {
				return "Recuperar pedido";
			}
			case RECUPERAR_ORCAMENTO: {
				return "Recuperar orçamento";
			}
			case RECUPERAR_CARRINHO: {
				return "Recuperar pedido";
			}
			}
			return super.toString();
		}
	}
	
	
	/**
	 * Iniciar atendimento no sistema VA
	 * @param inicioAtendimento - Ação a ser relaizada, seja iniciar novo atendimento ou continuar uma compra
	 * @return - Verdadeiro caso o atendimento seja iniciado
	 */
	public boolean autVAIniciarAtendimento(java.util.HashMap parametros) {
		try {
			if(parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.CRIAR_CARRINHO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.CriarCarrinho").click();
			}
			else if(parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_PEDIDO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.RecuperarPedido").click();
			}
			else if(parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_ORCAMENTO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.RecuperarOrcamento").click();
			}
			else if (parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_CARRINHO){
				AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.RecuperarCarrinho").click();
			}
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Recuperação de pedido de compra e edita
	 * @return - Verdadeiro para pedido de compra recuperado
	 */
	public boolean autRecuperarPedidoEditar(java.util.HashMap parametros) {

		AUTVA03ConsultaStatusPedido consultaPedido = new AUTVA03ConsultaStatusPedido();

		try {
			
			System.out.println("Parametros na Recuperacao"+parametros);

			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.Buscar pedidos").click();

			consultaPedido.AUTVA03ConsultaPedido(parametros.get("AUT_NUMERO_PEDIDO").toString());

			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.EditarPedido").click();


			//boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPedidos").exists("PrecosVigentes", 10000);
			//if (status) {

			//	AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.PrecosVigentes").click();

			//}
			
			//Confirma edição de pedido finalizado
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("Confirmar", 10000)){
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Confirmar").click();
			}

			return true;

		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}


	}
	
	/**
	 * Recuperação de pedido de compra
	 * @return - Verdadeiro para pedido de compra recuperado
	 */
	public boolean autRecuperarPedidoStatusEData(java.util.HashMap parametros) {

		AUTVA03ConsultaStatusPedido consultaPedido = new AUTVA03ConsultaStatusPedido();

		try {
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.Buscar pedidos").click();

			GregorianCalendar calendar = new GregorianCalendar();
			int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH) - 1;
	
			consultaPedido.autConsultaPedidoPorStatusEData(parametros.get("AUT_STATUS_PEDIDO").toString(), dia);

			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.CopiarPedido").click();
			
			//Confirma Manter condição comercial
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("ManterCondicoes", 5000)){
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.ManterCondicoes").click();
			}
			
			//Confirma edição de pedido finalizado
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.Desconto").exists("PopUp1", 5000)){
				AUT_AGENT_SILK4J.<DomButton>find("VA.Desconto.Confirmar").click();
			}
			
			return true;

		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}


	}
	
	/**
	 * Captura número do carrinho exibido na tela
	 * @return - Verdadeiro para pedido de compra recuperado
	 */
	public String autCapturarNumeroCarrinho() {

		String AUT_NUMERO_CARRINHO;
		
		AUT_NUMERO_CARRINHO = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroCarrinho").getText();
		
		
		System.out.println("O número do carrinho é "+AUT_NUMERO_CARRINHO);
		autInsertScreenByScenario();
		java.util.regex.Pattern padrao = java.util.regex.Pattern.compile("\\d+");
		java.util.regex.Matcher analise = padrao.matcher(AUT_NUMERO_CARRINHO);
		if(analise.find()) {
			AUT_NUMERO_CARRINHO = analise.group();
		}
		else {
			AUT_NUMERO_CARRINHO= "00000000000";
		}
		
		return AUT_NUMERO_CARRINHO;
	}	
	
	
	public boolean autVerificaStatus(java.util.HashMap parametros) {
		
		String numPedido = parametros.get("AUT_NUMERO_PEDIDO").toString();
		String statusEsperado = parametros.get("AUT_STATUS_ESPERADO").toString();
		
		AUTVA03ConsultaStatusPedido consultaPedido = new AUTVA03ConsultaStatusPedido();

		try {
						
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.Buscar pedidos").click();

			consultaPedido.AUTVA03ConsultaPedido(numPedido);

			autInsertScreenByScenario();
			DomElement status = AUT_AGENT_SILK4J.<DomElement>find("VA.Validacao.Status");

			Assert.assertTrue(status.getText().contains(statusEsperado));
			if(status.getText().contains(statusEsperado)) {
				status.waitForProperty("Text",status.getText(), 20000);
			}

			return true;
			
		} catch (java.lang.Exception e) {
			e.getMessage();
			return false;
		}
	}
}
