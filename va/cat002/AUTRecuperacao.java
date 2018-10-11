package br.lry.components.va.cat002;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTRecuperacao extends AUTVABaseComponent {

	
	public boolean autVaFluxoSaida(AUT_VA_FLUXO_SAIDA fluxoSaida) {
		String turno = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_TURNO_PERIODO").toString();
		String horario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_TURNO_HORARIO").toString();
		
		
		try {
			if(fluxoSaida ==AUT_VA_FLUXO_SAIDA.CAIXA){
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoCaixa").select();
			}
			else if(fluxoSaida == AUT_VA_FLUXO_SAIDA.ENTREGA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.Entrega").select();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.ListaEndereco").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.PopUpFreteAdicional").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.Turno").select(turno.toString());
			} 
			else if(fluxoSaida == AUT_VA_FLUXO_SAIDA.RETIRADA_EXTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRADA_EXTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.turno").select(horario.toString());
			}
			else if(fluxoSaida == AUT_VA_FLUXO_SAIDA.RETIRADA_EXTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRADA_EXTERNA_IMEDIATA.toString());
			}
			else if(fluxoSaida == AUT_VA_FLUXO_SAIDA.RETIRADA_INTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRADA_INTERNA_IMEDIATA.toString());
			}
			else if(fluxoSaida == AUT_VA_FLUXO_SAIDA.RETIRADA_INTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRADA_INTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.turno").select(horario.toString());
			}
			AUT_AGENT_SILK4J.<DomButton>find("VA02.FluxoSaida.Avancar").click();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
}
