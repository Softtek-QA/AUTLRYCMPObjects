/**
 * 
 */
package br.lry.components.va;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.TestObject;
import com.borland.silktest.jtf.win32.AccessibleControl;

import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.components.va.cat001.AUTVALogin;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import org.junit.Assert;

/**
 * 
 * Objetivo principal :
 * 
 *  - Consulta status do pedido - VA
 *  - Fazer levantamento de todos os status possíveis que um pedido pode ter
 * 
 * 
 * @author Softtek - QA
 *
 */
public class AUTVA03ConsultaStatusPedido extends AUTVALogin{
	/**
	 * SCRIPT DE CONSULTA DE STATUS DE PEDIDO
	 */
	@Test
	public void AUTVA03ConsultaStatusPedido(String numeroPedido, String statusPedido) {
		autInsertScreenByScenario();
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
		autStartLoginDefaultVA();
		autInsertScreenByScenario();
		autStartLoginDefault();
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoRecuperarPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.OpcoesDeFiltro.InformacoesDeFiltro").setText(numeroPedido);
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();
		autInsertScreenByScenario();
		DomElement status = AUT_AGENT_SILK4J.<DomElement>find("VA.Validacao.Status");

		Assert.assertTrue(status.getText().contains(statusPedido));
		if(status.getText().contains(statusPedido)) {
			status.waitForProperty("Text",status.getText(), 20000);
		}
		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}

	
	public void autConsultaPedido(String numeroPedido, String statusPedido,String usuario,String senha) {
		autInsertScreenByScenario();
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
		autInitWebApplicationVA();
		autLoginVA(usuario,senha);
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoRecuperarPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.OpcoesDeFiltro.InformacoesDeFiltro").setText(numeroPedido);
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();
		autInsertScreenByScenario();
		DomElement status = AUT_AGENT_SILK4J.<DomElement>find("VA.Validacao.Status");

		Assert.assertTrue(status.getText().contains(statusPedido));
		if(status.getText().contains(statusPedido)) {
			status.waitForProperty("Text",status.getText(), 20000);
		}
		autInsertScreenByScenario();

		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}

	
	public boolean AUTVA03ConsultaPedido(String numeroPedido) {

		try {
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.OpcoesDeFiltro.InformacoesDeFiltro").setText(numeroPedido);
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();

			return true;
		
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}

	}
	
	
	public void AUTVAConsultaStatusPedidoCompleto(String numeroPedido, String statusPedido) {
		autInsertScreenByScenario();
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
		autStartLoginDefaultVA();
		autInsertScreenByScenario();
		autStartLoginDefault();
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoRecuperarPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.OpcoesDeFiltro.InformacoesDeFiltro").setText(numeroPedido);
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoDocsRelacionados").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoDocsRelExibir").click();

		boolean existeDocsVinculados = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPedidos").exists("TituloDocsVinculados", 1000 * 10);

		if(existeDocsVinculados) {
			autInsertScreenByScenario();
			System.out.println("AUT INFO : VA : DOCS GERADOS : SAP : INIT");
			Integer cont = 1;

			for(cont = 1; cont < 10;cont++) {
				String locatorParent = "VA.AtualizacaoDados.//UL[@class='list'][2]";
				String locator = "//LI[%s]";
				String fullLocator = String.format("%s%s", locatorParent,locator);			
				locator = String.format(locator, cont);
				fullLocator = String.format(fullLocator, cont);
				
				if(AUT_AGENT_SILK4J.<DomElement>find(locatorParent).exists(locator, 1000 * 3)) {					
					for(TestObject obj : AUT_AGENT_SILK4J.<DomElement>find(fullLocator).getChildren()) {
						System.out.println(obj.getText());
						obj.highlightObject();	
						try {
							AUT_AGENT_SILK4J.<DomElement>find(locatorParent).click();
						}
						catch(java.lang.Exception e) {
							
						}
					}
					
					autInsertScreenByScenario();
				}
			}
			System.out.println("AUT INFO : VA : DOCS GERADOS : SAP : END");
		}	

		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.Fechar").click();
	
		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}

	public void AUTVAConsultaStatusPedidoCompleto(String numeroPedido, String statusPedido,String usuario,String senha) {
		autInsertScreenByScenario();
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}
		autInitWebApplicationVA();
		autLoginVA(usuario,senha);
		
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoRecuperarPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.OpcoesDeFiltro").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcoesDeFiltro.OpcaoNumeroPedidoVenda").select();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.OpcoesDeFiltro.InformacoesDeFiltro").setText(numeroPedido);
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPedidos.OpcoesDeFiltro.Buscar").click();
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoDocsRelacionados").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoDocsRelExibir").click();

		boolean existeDocsVinculados = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPedidos").exists("TituloDocsVinculados", 1000 * 10);

		if(existeDocsVinculados) {
			autInsertScreenByScenario();
			System.out.println("AUT INFO : VA : DOCS GERADOS : SAP : INIT");
			Integer cont = 1;

			for(cont = 1; cont < 10;cont++) {
				String locatorParent = "VA.AtualizacaoDados.//UL[@class='list'][2]";
				String locator = "//LI[%s]";
				String fullLocator = String.format("%s%s", locatorParent,locator);			
				locator = String.format(locator, cont);
				fullLocator = String.format(fullLocator, cont);
				
				if(AUT_AGENT_SILK4J.<DomElement>find(locatorParent).exists(locator, 1000 * 3)) {					
					for(TestObject obj : AUT_AGENT_SILK4J.<DomElement>find(fullLocator).getChildren()) {
						System.out.println(obj.getText());
						obj.highlightObject();	
						try {
							AUT_AGENT_SILK4J.<DomElement>find(locatorParent).click();
						}
						catch(java.lang.Exception e) {
							
						}
					}
					
					autInsertScreenByScenario();
				}
			}
			System.out.println("AUT INFO : VA : DOCS GERADOS : SAP : END");
		}	

		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.Fechar").click();
	
		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}

}
