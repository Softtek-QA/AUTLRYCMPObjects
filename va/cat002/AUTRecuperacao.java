package br.lry.components.va.cat002;

import com.borland.silktest.jtf.xbrowser.DomLink;

import br.lry.components.AUTVABaseComponent;

public class AUTRecuperacao extends AUTVABaseComponent {

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
	
	
	
	/**
	 * Iniciar atendimento no sistema VA
	 * @param inicioAtendimento - Ação a ser relaizada, seja iniciar novo atendimento ou continuar uma compra
	 * @return - Verdadeiro caso o atendimento seja iniciado
	 */
	public boolean autVAIniciarAtendimento(AUT_VA_INICIAR_ATENDIMENTO inicioAtendimento) {
		try {
			if(inicioAtendimento == AUT_VA_INICIAR_ATENDIMENTO.CRIAR_CARRINHO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();
			}
			else if(inicioAtendimento == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_PEDIDO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarPedido").click();
			}
			else if(inicioAtendimento == AUT_VA_INICIAR_ATENDIMENTO.RECUPERAR_ORCAMENTO) {
				AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.RecuperarOrcamento").click();
			}
			else {
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
