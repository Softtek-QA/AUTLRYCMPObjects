/**
 * 
 */
package br.lry.components;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.microfocus.silktest.jtf.*;

/**
 * 
 * Componente - Realiza login no sistema:
 * 
 * VA : Vendas assistidas
 * 
 * @author Softtek-QA
 *
 */
public abstract class AUTBaseComponent {
	Desktop agent = new Desktop();
	BrowserBaseState bsConfigBrowser = null;
	
	/**
	 * 
	 * Inicializa aplicação da aplicaçao VA
	 * 
	 */
	@Before
	public void autInitWebApplication() {
		
		bsConfigBrowser = new BrowserBaseState();
		agent.executeBaseState(bsConfigBrowser);
		
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");
		
	}
	
	
	/**
	 * 
	 * Finaliza a aplicação utilizada na automação
	 * 
	 */
	@After
	public void autCloseApplication() {
		System.out.println("AUT INFO: FINALIZANDO APLICAÇÃO");			
	}
	
	/**
	 * 
	 * Construtor padrão da classe
	 * 
	 */
	public AUTBaseComponent() {
		
	}
}
