package br.lry.components.va.cat009;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTMeiosPagamento extends AUTBaseComponent {

	
	/**
	 * Listagem dos meios de pagamento disponíveis a serem selecionados
	 * @author Softtek - QA
	 *
	 */
	public static enum AUT_VA_MEIOS_PAGAMENTO{
		CARTAO_CREDITO,
		CARTAO_CELEBRE,
		POS_CREDITO,
		FINANCEIRA_CDC,
		DINHEIRO,
		CARTAO_DEBITO,
		POS_DEBITO,
		CHEQUE,
		VOUCHER,
		VISA,
		VALE_TROCA;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case CARTAO_CREDITO: {
				return "C. CRÉDITO";
			}
			case CARTAO_CELEBRE: {
				return "CARTÃO PRÓPRIO";
			}
			case POS_CREDITO: {
				return "POS CRÉDITO";
			}
			case FINANCEIRA_CDC: {
				return "FINANCEIRA CDC";
			}
			case DINHEIRO: {
				return "DINHEIRO";
			}
			case CARTAO_DEBITO: {
				return "C. DÉBITO";
			}
			case POS_DEBITO: {
				return "POS DÉBITO";
			}
			case CHEQUE: {
				return "CHEQUE";
			}
			case VOUCHER: {
				return "VOUCHER";
			}
			case VISA: {
				return "VISA";
			}
			case VALE_TROCA: {
				return "VALE TROCA";
			}
			}
			return super.toString();
		}
	}

	
	
	
	/**
	 * Opções de plano de pagamento disponíveis a serem selecionadas no sistema VA
	 * @author Softtek - QA
	 *
	 */
	public enum AUT_VA_PLANO_PAGAMENTO{
		A_VISTA,
		SEM_JUROS_1X,
		SEM_JUROS_CELEBRE_1X;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case A_VISTA: {
				return "A VISTA";
			}
			
			case SEM_JUROS_1X: {
				return "1X SEM JUROS";
			}
			case SEM_JUROS_CELEBRE_1X: {
				return "1X SEM JUROS CELEBRE";
			}
			}
			return super.toString();
		}
	}
	
	
	/**
	 * Seleção do meio de pagamento a ser utilizado do sistema VA
	 * @param parametros - Meio de pagamento a ser selecionado
	 * @return - Verdadeiro para meio de pagamento devidamente selecioando
	 */
	public boolean autSelecaoMeioPagamento(java.util.HashMap parametros) {			
		try {
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").select(parametros.get("AUT_MEIO_PAGAMENTO").toString());
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").select(parametros.get("AUT_PLANO_PAGAMENTO").toString());

			if (parametros.get("AUT_MEIO_PAGAMENTO") != AUT_VA_MEIOS_PAGAMENTO.DINHEIRO) {
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").setText(parametros.get("AUT_NOME_TITULAR").toString());
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").setText(parametros.get("AUT_VALIDADE").toString());
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
			}
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	public boolean autVASegundoMeioPagamento(java.util.HashMap parametros) {
	try {	
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPagamento").setText(parametros.get("AUT_VALOR_PAGAMENTO").toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").select(parametros.get("AUT_MEIO_PAGAMENTO").toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").select(parametros.get("AUT_PLANO_PAGAMENTO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").setText(parametros.get("AUT_NOME_TITULAR").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").setText(parametros.get("AUT_VALIDADE").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.AdicionarNovoMeioPag").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPagamento").setText(parametros.get("AUT_VALOR_PAGAMENTO_2").toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.FormaPag2").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.FormaPag2").select(parametros.get("AUT_MEIO_PAGAMENTO_2").toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPag2").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPag2").select(parametros.get("AUT_PLANO_PAGAMENTO_2").toString());
		
		return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	

	
	public boolean autVAMultiplosMeiosPagamentoTelevendas(java.util.HashMap parametros) {
		try {
			String valorDividido = AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPedido1").getText();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPedido1").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPedido1").clearText();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.ValorPedido1").typeKeys(autGetDiv(valorDividido).toString());
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento").select(parametros.get("AUT_MEIO_PAGAMENTO").toString());
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento").select(parametros.get("AUT_PLANO_PAGAMENTO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.NomeTitular").setText(parametros.get("AUT_NOME_TITULAR").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Validade").setText(parametros.get("AUT_VALIDADE").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaMeioPagamento.Codigo").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.AdicionarMeioPagamento").click();
			
			if (parametros.get("AUT_MEIO_PAGAMENTO_2") == AUT_VA_MEIOS_PAGAMENTO.VOUCHER) {
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").doubleClick();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").select(parametros.get("AUT_MEIO_PAGAMENTO_2").toString());

				DomListBox listCombo = AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.Codigo_Voucher_VALETROCA");				
				listCombo.getItemCount();
				selectValor(listCombo, parametros.get("AUT_CODE_VOUCHER").toString());
				
				try {
					AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").click();
					AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").setDomAttribute("value", "2");	
					AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.Avancar").click();							

				}
				catch(java.lang.Exception e) {
				
				}
				
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").select(parametros.get("AUT_PLANO_PAGAMENTO_2").toString());
			}
			
			else if (parametros.get("AUT_MEIO_PAGAMENTO_2") == AUT_VA_MEIOS_PAGAMENTO.VALE_TROCA) {
				
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").doubleClick();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.MeioPagamento2").select(parametros.get("AUT_MEIO_PAGAMENTO_2").toString());

				DomListBox listCombo = AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.Codigo_Voucher_VALETROCA");				
				listCombo.getItemCount();
				selectValor(listCombo, parametros.get("AUT_CODE_VALE_TROCA").toString());
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.TelaMeioPagamento.PlanoPagamento2").select(parametros.get("AUT_PLANO_PAGAMENTO_2").toString());
				AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.Avancar").click();
				AUT_AGENT_SILK4J.<DomButton>find("VA.TelaMeioPagamento.ConfirmarValeTroca").click();
			
			}



			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
}
