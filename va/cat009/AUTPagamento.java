package br.lry.components.va.cat009;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTPagamento extends AUTVABaseComponent {


	public enum AUT_VA_MEIOS_PAGAMENTO{
		CARTAO_CREDITO,
		CARTAO_CELEBRE,
		POS_CREDITO,
		FINANCEIRA_CDC,
		DINHEIRO,
		CARTAO_DEBITO,
		POS_DEBITO,
		CHEQUE,
		VOUCHER,
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
			case VALE_TROCA: {
				return "VALE TROCA";
			}
			}
			
			return super.toString();
		}
	}

	
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
	 * Seleção do meio de pagamento a ser utilizado no pedido/orçamento
	 * @param meioPagamento - Meio de Pagamento a ser selecionado
	 * @param planoPagamento - Plano de Pagamento a ser selecionado
	 * @return - Verdadeiro caso o meio de pagamento seja devidamente selecioando
	 */
	public boolean autVAMeioDePagamento(AUT_VA_MEIOS_PAGAMENTO meioPagamento, AUT_VA_PLANO_PAGAMENTO planoPagamento) {
		String numeroCartao = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NUMERO_CARTAO").toString();
		String nomeTitular = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_NOME_TITULAR").toString();
		String validade = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_GERACAO_PEDIDOS, "AUT_VALIDADE").toString();
		String codigo = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_CARTAO").toString();
				
		
		try {
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").select(meioPagamento.toString());
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.PlanoPagamento").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.PlanoPagamento").select(planoPagamento.toString());
			
			if (meioPagamento != AUT_VA_MEIOS_PAGAMENTO.DINHEIRO) {
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NumeroCartao").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NumeroCartao").setText(numeroCartao);
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NomeTitular").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.NomeTitular").setText(nomeTitular);
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Validade").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Validade").setText(validade);
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Codigo").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaMeioPagamento.Codigo").setText(codigo);
			}
			AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaMeioPagamento.Avancar").click();
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	

}
