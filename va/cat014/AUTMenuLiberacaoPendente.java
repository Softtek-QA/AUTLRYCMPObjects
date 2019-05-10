package br.lry.components.va.cat014;

import java.util.HashMap;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;

import br.lry.components.AUTVABaseComponent;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class AUTMenuLiberacaoPendente extends AUTVABaseComponent {
	
	


	/**
	 * Menu Liberação Pendentes 
	 * @return - Verdadeiro caso clicar no menu Liberação Pendentes
	 */
	public boolean autBuscaAntifraude(HashMap<String, Object> parametros) {
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.Menu").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendetes.MenuLiberacaoPendentes").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendetes.NumeroPedido").typeKeys(parametros.get("AUT_NUMERO_ANTIFRAUDE").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacasoPendetes.BotaoPesquisar").click();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}	
		
		/**
		 * Acessar o monitor liberação Antifraude - Aprovação
		 * @return  Verdadeiro para a aprovação antifraude
		 */
		public boolean autMonitorAntiFraudeAprovacao(HashMap<String, Object> parametros) {
			try {
				
				AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
				AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.MenuLiberacaoPendentes").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AntiFraude").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisar").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarSemAntiFraude").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarSemAntiFraude").click();
					if(AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.PopDesconto").isVisible()) {
						AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();
					}
			return true;
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		
		/**
		 * Acessar o monitor liberação Antifraude - Reprovação
		 * @return Verdadeiro para Reprovação antifraude
		 */
		public boolean autMonitorAntiFraudeReprovacao(HashMap<String, Object> parametros) {

			try {
				//AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
				if(AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.PopDesconto").exists()) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.FechaJanelaComentario").click();
				}
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AntiFraude").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumeroPedido").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumeroPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisar").click();
// DESCOMENTAR O TRECHO ABIXO, CASO HABILITE A INTEGRAÇÃO COM CLEARSAFE
//				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Reprovar").setFocus();
//				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Reprovar").click();
//					if(AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.PopDesconto").isVisible()) {
//						AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();
//					}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return false;
			}
		}

		/**
	 * Acessa o monitor liberação Antifraude - Aprovação
	 * @return true Aprovação
	 */
	public boolean monitorAprovacaoComercialAprovar(HashMap<String, Object> parametros) {

		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Desconto").click();
			
			//P/ busca direta pelo numero do pedido
			//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setFocus();
			//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
			
			//P/ busca avançada
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").select(parametros.get("AUT_CANAL").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.BuscaAvancadaNumeroPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();
			
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").click();
//			if(AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes").exists("PopDesconto", 10000)){
//				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();		
//			}
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.LiberacaoPendentes").exists("SimDesconto", 40000)){
				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();		
			}
				
	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public void autMonitorAntiFraudeEnviandoProAntiFraude(HashMap<String, Object> parametros) {

		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AntiFraude").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumeroPedido").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumeroPedido").typeKeys(parametros.get("AUT_NUMERO_PEDIDO").toString());
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisar").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisar").click();
	
// <<<<<<  DESCOMENTAR QUANDO O SISTEMA EXTERNO QUE GERA O ANTIFRAUDE ESTIVER LIGADOAUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.EnviarAntiFraude").setFocus();
//		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.EnviarAntiFraude").click();
//			if(AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.PopDesconto").isVisible()) {
//				AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();
//			}
}
	
	public void autMonitorAumentandoDescontoAprovando(HashMap<String, Object> parametros) {

		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Desconto").click();
		
		//P/ busca direta pelo numero do pedido
		//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setFocus();
		//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
		
		//P/ busca avançada
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").select("Loja");
		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.BuscaAvancadaNumeroPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();
		
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").click();
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.Porcentagem").setText(parametros.get("AUT_DESCONTO_AUMENTA").toString());
		
		autInsertScreenByScenario();
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").click();
		if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.LiberacaoPendentes").exists("SimDesconto", 40000)){
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.SimDesconto").click();		
		}
		
}
	
	public boolean autMonitorAprovandoECancelando(HashMap<String, Object> parametros) {

		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.menu").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Desconto").click();
			
			//P/ busca direta pelo numero do pedido
			//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setFocus();
			//AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.NumPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
			
			//P/ busca avançada
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").select("Loja");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.BuscaAvancadaNumeroPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();
			
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.Pedido").click();
			
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.Porcentagem").setText(parametros.get("AUT_DESCONTO_AUMENTA").toString());
			
			autInsertScreenByScenario();
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.AprovarDesconta").click();
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaMeioPagamento").exists("ConfirmarENao", 40000)){
				AUT_AGENT_SILK4J.<DomElement>find("VA.TelaMeioPagamento.ConfirmarENao").click();		
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		}

	

}

	

