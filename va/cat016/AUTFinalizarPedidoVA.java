package br.lry.components.va.cat016;

import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.components.va.cat009.AUTMeiosPagamento.AUT_VA_MEIOS_PAGAMENTO;

public class AUTFinalizarPedidoVA extends AUTBaseComponent {
	
	public static String AUT_NUMERO_PEDIDO;
	
	
	public boolean autFinalizarPedidoVA(java.util.HashMap parametros) {			
		try {
			
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaResumo.Finalizar").click();
			
			
			autInsertScreenByScenario();
			boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaResumo").exists("FecharPopUp",10000);
			if(status) {
				
				AUT_AGENT_SILK4J.<DomElement>find("VA.TelaResumo.FecharPopUp").click();
				autInsertScreenByScenario();
			}
			
			AUT_NUMERO_PEDIDO = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroPedido").getText();

			System.out.println("O número do pedido é "+AUT_NUMERO_PEDIDO);
			autInsertScreenByScenario();
			java.util.regex.Pattern padrao = java.util.regex.Pattern.compile("\\d+");
			java.util.regex.Matcher analise = padrao.matcher(AUT_NUMERO_PEDIDO);
			if(analise.find()) {
				AUT_NUMERO_PEDIDO = analise.group();
			}
			else {
				AUT_NUMERO_PEDIDO= "00000000000";
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