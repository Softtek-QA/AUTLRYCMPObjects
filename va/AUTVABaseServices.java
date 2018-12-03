/**
 * 
 */
package br.lry.components.va;

import br.lry.components.AUTBaseComponent;

/**
 * 
 * Gerenciamento de classes de configuração para o sistema Vendas Assistidas
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseServices extends AUTBaseComponent {
	br.lry.components.va.AUTVACadastros cadastros = null;
	br.lry.components.va.AUTVAGeradorPedido pedidos = null;
	br.lry.components.va.AUTVA03ConsultaStatusPedido consultas = null;
	
	
	/**
	 * 
	 * Retorna o componentes para gerenciamento de cadastros VA
	 * 
	 * @return TVACadastros - Classe que implementa funcionalidade de cadastro
	 * 
	 */
	public <TVACadastros extends br.lry.components.va.AUTVACadastros> TVACadastros autVACadastros() {
		if(cadastros==null) {
			
			cadastros = new br.lry.components.va.AUTVACadastros();						
			cadastros.AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
			cadastros.AUT_BASE_STATE_CONFIGURATION_BROWSER = new com.borland.silktest.jtf.BrowserBaseState("va.settings");
			cadastros.AUT_AGENT_SILK4J.executeBaseState(cadastros.AUT_BASE_STATE_CONFIGURATION_BROWSER);
			cadastros.autInitWebApplicationVA();
			return (TVACadastros)cadastros;
		}
		else {			
			return (TVACadastros)cadastros;
		}
	}
	
	public <TVAPedidos extends br.lry.components.va.AUTVAGeradorPedido> TVAPedidos autVAPedidos() {
		if(pedidos==null) {
			
			pedidos = new br.lry.components.va.AUTVAGeradorPedido();						
			pedidos.AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
			pedidos.AUT_BASE_STATE_CONFIGURATION_BROWSER = new com.borland.silktest.jtf.BrowserBaseState("va.settings");
			pedidos.AUT_AGENT_SILK4J.executeBaseState(pedidos.AUT_BASE_STATE_CONFIGURATION_BROWSER);
			pedidos.autInitWebApplication();
			
			return (TVAPedidos)pedidos;
		}
		else {			
			return (TVAPedidos)pedidos;
		}
	}
	
	
	/**
	 * 
	 * Retorna o componente para consulta de pedidos
	 * 
	 * @return TVAConsultas - Objeto para consulta de pedidos
	 * 
	 */
	public <TVAConsultas extends br.lry.components.va.AUTVA03ConsultaStatusPedido> TVAConsultas autVAConsultas() {
		if(consultas==null) {
			
			consultas = new br.lry.components.va.AUTVA03ConsultaStatusPedido();						
			consultas.AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
			consultas.AUT_BASE_STATE_CONFIGURATION_BROWSER = new com.borland.silktest.jtf.BrowserBaseState("va.settings");
			consultas.AUT_AGENT_SILK4J.executeBaseState(consultas.AUT_BASE_STATE_CONFIGURATION_BROWSER);
			consultas.autInitWebApplication();
			return (TVAConsultas)consultas;
			
		}
		else {
			
			return (TVAConsultas)consultas;
			
		}
	}
	
	
	/**
	 * 
	 * 
	 * Construtor padrao da classe
	 * 
	 */
	public AUTVABaseServices() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param syncronizeDataFlow
	 * 
	 */
	public AUTVABaseServices(boolean syncronizeDataFlow) {
		super(syncronizeDataFlow);
		// TODO Auto-generated constructor stub
	}

}
