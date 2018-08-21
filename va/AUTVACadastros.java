/**
 * 
 */
package br.lry.components.va;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomLink;

import sun.management.resources.agent;

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
	
	@Test
	public void autInitClientMenu() {
		autStartLoginDefault();
		DomLink menuClient = AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.MenuPrincipal");
		menuClient.click();
		DomLink subMenuCliente = AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.SubMenuClientes");
		subMenuCliente.click();
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
	
	/**
	 * 
	 * Define o tipo de cadastro que será realizado no VA
	 * 
	 * @param tipoCadastro - Tipo de cadastro
	 * 
	 * 
	 */
	public AUTVACadastros(AUT_VA_CADASTROS tipoCadastro) {
		super();
	}
	
}

