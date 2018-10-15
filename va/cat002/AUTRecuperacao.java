package br.lry.components.va.cat002;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomLink;

import br.lry.components.AUTVABaseComponent;

public class AUTRecuperacao extends AUTVABaseComponent {

	
	@Test
	public void autStartTest() {
		java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
		
		parametros.put("OPCAO_INICIAR_ATENDIMENTO", AUT_VA_INICIAR_ATENDIMENTO.values());
	}
	
	
	
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

	public boolean autRecuperarPedido() {
		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarPedido").click();
			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}
	}

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
