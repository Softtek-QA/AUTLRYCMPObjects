package br.lry.components.va.cat002;

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

	
	/**
	 * Recuperação de carrinho de compra
	 * @return - Verdadeiro para carrinho de compra recuperado
	 */
	public boolean autRecuperarCarrinho() {
		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarCarrinho").click();
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
		
		System.out.println(parametros);
		
		System.out.println(parametros.get("AUT_NUMERO_PEDIDO").toString());

		AUTVA03ConsultaStatusPedido consultaPedido = new AUTVA03ConsultaStatusPedido();
		
		try {
			
			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarPedido").click();
			
			consultaPedido.AUTVA03ConsultaPedido(parametros.get("AUT_NUMERO_PEDIDO").toString());
			

			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaPedido.CopiarPedido").click();
						
			
			boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA02.TelaPedido").exists("PrecosVigentes",10000);
			if(status) {
				
				AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaPedido.PrecosVigentes").click();
				
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
	public boolean autRecuperarOrcamento() {
		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarOrcamento").click();
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
			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();
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
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();
			}
			else if(parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_PEDIDO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarPedido").click();
			}
			else if(parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_ORCAMENTO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarOrcamento").click();
			}
			else if (parametros.get("OPCAO_INICIAR_ATENDIMENTO") == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_CARRINHO){
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarCarrinho").click();
			}
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
		
}
