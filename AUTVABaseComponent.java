/**
 * 
 */
package br.lry.components;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent.AUT_SYNC_EXECUTION_STATE;
import br.lry.components.AUTBaseComponent.AUTStoreItem.AUT_SELECT_PRODUCT_OPTIONS_BY_STORE;
import br.lry.components.AUTVABaseComponent.DEPOSITOS;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.AUT_VA_TURNOS_ENTREGA;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.ENCOMENDA;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.FILIAIS;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.FLUXO_SAIDA_TIPOS;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.TIPOS_RETIRA;
import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.USAR_DATA_MAIS_PROXIMA;
import br.lry.components.hmc.AUTHMCBaseServices;
import br.lry.components.va.AUTVABaseServices;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat001.AUTConfirmacaoLogin;
import br.lry.components.va.cat001.AUTLoginBoitata;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.components.va.cat002.AUTRecuperacao;
import br.lry.components.va.cat003.AUTInsercaoItens;
import br.lry.components.va.cat003.AUTItem;
import br.lry.components.va.cat005.AUTConversao;
import br.lry.components.va.cat006.AUTBuscarCliente;
import br.lry.components.va.cat006.AUTCadastroCliente;
import br.lry.components.va.cat006.AUTCadastroEstrangeiro;
import br.lry.components.va.cat006.AUTCadastroPJ;
import br.lry.components.va.cat007.AUTFluxoSaida;
import br.lry.components.va.cat007.AUTFluxoSaida.AUT_VA_TIPO_FRETE;
import br.lry.components.va.cat007.AUTFluxoSaidaItens;
import br.lry.components.va.cat009.AUTMeiosPagamento;
import br.lry.components.va.cat010.AUTDesconto;
import br.lry.components.va.cat010.AUTEdicao;
import br.lry.components.va.cat011.AUTLogOffBoitata;
import br.lry.components.va.cat011.AUTLogOffVA;
import br.lry.components.va.cat014.AUTMenuLiberacaoPendente;
import br.lry.components.va.cat016.AUTFinalizarPedidoVA;
import br.lry.components.va.cat017.AUTEcommerce;
import br.lry.components.va.cat018.AUTSelecaoLojaBoitata;
import br.lry.components.va.cat018.AUTSelecaoLojaVA;
import br.lry.dataflow.AUTDataFlow.AUT_CONFIRMACAO_USUARIO;
import br.lry.dataflow.AUTDataFlow.AUT_EDICAO_PEDIDO;
import br.lry.dataflow.AUTDataFlow.AUT_MODO_CONSULTAS_VA_SELECAO_ITEM;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.dataflow.AUTDataFlow.AUT_TIPO_TELEFONE_PARA_CONTATO;
import br.lry.dataflow.AUTDataFlow.AUT_VA_TIPO_DOCUMENTO_PESQUISA;
import br.lry.functions.AUTVAProjectFunctions;
import br.lry.functions.AUTProjectsFunctions;
import br.lry.functions.AUTProjectsFunctions.AUT_TYPE_DOCUMENT_GENERATOR;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem.AUT_TIPO_MSG_LOG;
import br.lry.functions.AUTProjectsFunctions.AUT_TIPO_FLUXO_SAIDA;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.TestObject;
import com.borland.silktest.jtf.Utils;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomForm;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;

import br.lry.qa.rsp.pjttrc.frt001.va.cat008.AUTServicoGarantia;


/**
 * 
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {
	public String AUT_USUARIO_LOGIN_DEFAULT = "";
	public String AUT_SENHA_LOGIN_DEFAULT = "";
	public static AUTCadastroPJ cadastroPJ;
	//PARA COMPONENTES DE INTEGRAÇÃO
	public  AUTHMCBaseServices hmc = null;	
	public  AUTVABaseServices va = null;
	public  br.lry.components.pdv.AUTPDVBaseServices pdv = null;
	public  br.lry.components.sap.AUTSAPBaseServices sap = null;
	public  br.lry.components.safe.AUTSafeBaseServices safe = null;
	public  br.lry.qa.rsp.pjttrc.entregas.AUTEntregasBase workflow = null;
	br.lry.components.AUTVABaseComponent.AUTVAFormasPagamento autFormasPagamentoGerenciador = null;

	public static AUTVALogin autVALogin;
	public static AUTBuscarCliente autBuscaCliente;
	public static AUTLoginBoitata autLoginBoitata;
	public static AUTConfirmacaoLogin autVAConfirmacaoLogin;
	public static AUTRecuperacao autRecuperacao;
	public static AUTItem autItem;
	public static AUTConversao autConversao;
	public static AUTFluxoSaida autFluxoSaida;
	public static AUTMeiosPagamento autMeiosPagamento;
	public static AUTSelecaoLojaVA autSelecaoLojaVA;
	public static AUTSelecaoLojaBoitata autSelecaoLojaBoitata;
	public static AUTLogOffVA autLogOffVA;
	public static AUTLogOffBoitata autLogOffBoitata;
	public static AUTFinalizarPedidoVA autLogFinalizarPedidoVA;
	public static AUTCadastroCliente autCadastroCliente;
	public static AUTMenuLiberacaoPendente autMenuLiberacao;
	public static AUTDesconto autDesconto;
	public static AUTServicoGarantia servicoGarantia;
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();		
	public static AUTEcommerce autEcommerce;
	public static AUTInsercaoItens autInsercaoItens;
	public static AUTEdicao edicao;
	public static AUTFluxoSaidaItens autfluxoSaidaItens;
	public static AUTCadastroEstrangeiro cadastroEstrangeiro;
	public AUTVAFluxosSaidaComponente autFluxosSaidaComponenteV2;


	/**
	 * 
	 * Define os perfis de acesso padrão dos sistemas
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static enum AUT_TIPO_ACESSO_LOGIN{
		USUARIO_LOJA,
		USUARIO_TELEVENDAS,
		USUARIO_GERENTE_APROVADOR
	}


	/**
	 * Lojas ecommerce - Boitata
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static enum AUT_BOITATA_LOJAS{
		SP_SAO_PAULO,
		SP_RAPOSO_TAVARES,
		SAO_BERNARDO_CAMPO;		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case SAO_BERNARDO_CAMPO:{				
				return "Loja | São Bernardo do Campo";
			}
			case SP_RAPOSO_TAVARES:{
				return "Loja | São Bernardo do Campo";
			}
			case SP_SAO_PAULO:{
				return "Loja | São Bernardo do Campo";
			}
			}
			return super.toString();
		}
	}

	/**
	 * 
	 * Classe para gerenciamento de formas de pagamento
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static class AUTVAFormasPagamento <TObject extends com.borland.silktest.jtf.xbrowser.DomElement> extends AUTVABaseComponent{
		static AUTVAFormasPagamento currentObject=null;
		static CAMPOS_CONFIGURACAO campoConfiguracao=null;
		Integer indexItem=0;
		String valorCompra; //TODAS AS OPÇÕES DE PAGAMENTO
		METODOS_PAGAMENTO metodoPagamento; //TODOS AS OPÇÕES DE PAGAMENTO
		PLANOS_PAGAMENTO planoPagamento; //8-FORMAS DE PAGAMENTO - CARTAO + 1 - DINHEIRO
		String numeroCartao; //Número do cartão
		String nomeTitular; //Nome do titular
		String validade; //Validade do cartão
		String codigoSeguranca;	//Código de Segurança
		Boolean adicionarValorRestante; //Define se o valor restante para pagamento será utilizado na configuração da forma de pagamento atual
		Boolean excluirMeioPagamento; //Define a forma de pagamento atual será excluída
		Boolean naoAlterarMeioPagamentoCaixa; //Define se essa forma de pagamento poderá ser alterada no caixa;
		Boolean ignorarAntifraude; //Define se essa forma de pagamento poderá ser alterada no caixa;		
		String codigoValePresente; //Define o vale presente
		String codigoValeTroca; //Define o vale troca
		String codigoVoucher; //Define o código do voucher

		TObject valorCompraObject; //TODAS AS OPÇÕES DE PAGAMENTO
		TObject metodoPagamentoObject; //TODOS AS OPÇÕES DE PAGAMENTO
		TObject planoPagamentoObject; //8-FORMAS DE PAGAMENTO - CARTAO + 1 - DINHEIRO
		TObject numeroCartaoObject; //Número do cartão
		TObject nomeTitularObject; //Nome do titular
		TObject validadeObject; //Validade do cartão
		TObject codigoSegurancaObject;	//Código de Segurança
		TObject adicionarValorRestanteObject; //Define se o valor restante para pagamento será utilizado na configuração da forma de pagamento atual
		TObject excluirMeioPagamentoObject; //Define a forma de pagamento atual será excluída
		TObject naoAlterarMeioPagamentoCaixaObject; //Define se essa forma de pagamento poderá ser alterada no caixa;
		TObject codigoValePresenteObject; //Define o código do vale presente
		TObject codigoValeTrocaObject; //Define o código do vale troca
		TObject codigoVoucherObject; //Define o código do voucher
		PagamentoCartao autPagCartao = null;
		private Boolean pagarNaLoja;

		/**
		 * 
		 * Campos configurados fluxo de saída
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum CAMPOS_CONFIGURACAO{
			VALOR_COMPRA,
			MEIO_PAGAMENTO,
			PLANO_PAGAMENTO,
			NUMERO_CARTAO,
			NOME_TITULAR_CARTAO,
			DATA_VALIDADE_CARTAO,
			CODIGO_SEGURANCA,
			CODIGO_VALE_PRESENTE,
			CODIGO_VALE_TROCA,
			CODIDO_VOUCHER,
			IGNORAR_ANTIFRAUDE,
			PAGAR_NA_LOJA
		}

		/**
		 * Gerencia formas de pagamento com cartão
		 * 
		 * @author Administrador
		 *
		 */
		public static class PagamentoCartao{
			AUTVAFormasPagamento formasPag = null;
			CAMPOS_CONFIGURACAO cmpConfig = null;


			/**
			 * 
			 * Altera o campo alvo para edição de conteudo
			 * 
			 * @param campo - Campo para edição
			 * 
			 */
			public void setCampoEdicao(CAMPOS_CONFIGURACAO campo) {
				cmpConfig = campo;
				inicializar();
			}


			/**
			 * Retorna o campo alvo da edição
			 * 
			 * @return CAMPOS_CONFIGURACAO - Campo alvo da edição
			 */
			public CAMPOS_CONFIGURACAO getCampoEdicao() {
				return cmpConfig;
			}




			/**
			 * 
			 * Executa procedimentos para pagamento com cartão - MASTERCARD
			 * 
			 * @param parameters - Parametros de configuração
			 * 
			 */
			public void processarPagamento(java.util.HashMap<String, Object> parameters) {
				Boolean bFlagLoja = (parameters.get("AUT_PAGAR_NA_LOJA").toString()=="0"? false : true);
				Boolean bFlagAntFraude = (parameters.get("AUT_IGNORAR_ANTIFRAUDE").toString()== "0" ? false : true);

				setPagarNaLoja(bFlagLoja);
				setMeioPagamento(METODOS_PAGAMENTO.valueOf(parameters.get("AUT_METODO_PAGAMENTO").toString()));
				setPlanoPagamento(PLANOS_PAGAMENTO.valueOf(parameters.get("AUT_PLANO_PAGAMENTO").toString()));
				setNumeroCartao(parameters.get("AUT_NUMERO_CARTAO_PESSOAL").toString());
				setNomeTitular(parameters.get("AUT_CARTAO_NOME_TITULAR").toString());
				setValidadeCartao(parameters.get("AUT_CARTAO_DATA_VALIDADE").toString());
				setCodigoSeguranca(parameters.get("AUT_CARTAO_CODIGO_SEGURANCA").toString());				
				setIgnorarAntifraude(bFlagAntFraude);				

			}


			/**
			 * 
			 * Executa procedimentos de inicialização do sistema
			 * 
			 */
			public void inicializar() {
				switch(getCampoEdicao()) {
				case VALOR_COMPRA:{
					//getCurrentObject().setMeioPagamentoObject(AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomListBox[@id='payment-method-0']"));										
					break;
				}
				case MEIO_PAGAMENTO:{
					getCurrentObject().setMeioPagamentoObject(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='payment-method-0']"));					
					break;
				}
				case PLANO_PAGAMENTO:{
					getCurrentObject().setPlanoPagamentoObject(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='payment-plan-0']"));									
					break;
				}
				case NUMERO_CARTAO:{
					getCurrentObject().setNumeroCartaoObject(AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@id='payment-card-number-0']"));	
					break;
				}
				case NOME_TITULAR_CARTAO:{
					getCurrentObject().setNomeTitularObject(AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@name='paymentModes[0].cardName']"));					
					break;
				}
				case DATA_VALIDADE_CARTAO:{
					getCurrentObject().setValidadeCartaoObject(AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@id='payment-card-expiration-0']"));					
					break;
				}
				case CODIGO_SEGURANCA:{
					getCurrentObject().setCodigoSegurancaObject(AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@id='payment-card-code-0']"));
					break;
				}
				case IGNORAR_ANTIFRAUDE:{					
					break;
				}
				case PAGAR_NA_LOJA:{
					break;
				}
				}										
			}


			/**
			 * 
			 * Alterar valor do pagamento para opção selecionada
			 * 
			 * @param valorPagamento - Valor do pagamento
			 * 
			 */
			public void setValorCompra(String valorPagamento) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.VALOR_COMPRA);
				getCurrentObject().setValorCompra(valorPagamento);
			}

			/**
			 * 
			 * Altera o meio de pagamento padrão utilizado pelo sistema
			 *
			 * 
			 * @param meioPagamento - Meio de Pagamento
			 * 
			 */
			public void setMeioPagamento(METODOS_PAGAMENTO meioPagamento) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.MEIO_PAGAMENTO);
				getCurrentObject().setMeioPagamento(meioPagamento);
			}

			/**
			 * 
			 * Altera o plano de pagamento padrão utilizado pelo sistema
			 *
			 * 
			 * @param meioPagamento - Plano de pagamento
			 * 
			 */
			public void setPlanoPagamento(PLANOS_PAGAMENTO planoPagamento) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.PLANO_PAGAMENTO);
				getCurrentObject().setPlanoPagamento(planoPagamento);
			}

			/**
			 * 
			 * Altera o numero do cartao padrão utilizado pelo sistema
			 *
			 * 
			 * @param numeroCartao - Numero do cartao
			 * 
			 */
			public void setNumeroCartao(String numeroCartao) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.NUMERO_CARTAO);
				getCurrentObject().setNumeroCartao(numeroCartao);
			}

			/**
			 * 
			 * Altera o nome do titular cartao padrão utilizado pelo sistema
			 *
			 * 
			 * @param numeroCartao - Numero do cartao
			 * 
			 */
			public void setNomeTitular(String nomeTitular) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.NOME_TITULAR_CARTAO);
				getCurrentObject().setNomeTitular(nomeTitular);
			}

			/**
			 * 
			 * Altera data de validade do cartao padrão utilizado pelo sistema
			 *
			 * 
			 * @param validadeCartao - Validade do cartao exemplo:04/19
			 * 
			 */
			public void setValidadeCartao(String validadeCartao) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.DATA_VALIDADE_CARTAO);
				getCurrentObject().setValidadeCartao(validadeCartao);
			}


			/**
			 * 
			 * Altera código de segurança do cartão padrão utilizado pelo sistema
			 *
			 * 
			 * @param validadeCartao - Validade do cartao exemplo:04/19
			 * 
			 */
			public void setCodigoSeguranca(String codigoSegurancaCartao) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.CODIGO_SEGURANCA);
				getCurrentObject().setCodigoSeguranca(codigoSegurancaCartao);
			}

			public void setIgnorarAntifraude(Boolean ignorar) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.IGNORAR_ANTIFRAUDE);
				getCurrentObject().setIgnorarAntifraude(ignorar);
			}

			public void setPagarNaLoja(Boolean ignorar) {
				setCampoEdicao(CAMPOS_CONFIGURACAO.PAGAR_NA_LOJA);
				getCurrentObject().setPagarNaLoja(false);
			}

			/**
			 * 
			 * 
			 * Retorna o objeto corrente para gerencimento das formas de pagamento cadastrados no sistema
			 * 
			 * @return AUTVAFormasPagamento - Objeto para gerenciamento
			 * 
			 */
			public AUTVAFormasPagamento getCurrentObject() {
				if(formasPag==null) {
					formasPag = getCurrentInstance();
					return formasPag;
				}
				else {
					return formasPag;
				}
			}			
		}

		/**
		 * 
		 * Oções para pagamento em dinheiro
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static class PagamentoDinheiro extends AUTVABaseComponent{
			Integer indexCorrente;
			AUTVAFormasPagamento formasPag = null;

			/**
			 * 
			 * Gerencia as formas de pagamento
			 * 
			 * @return AUTVAFormasPagamento - Formas de pagamento
			 */
			public AUTVAFormasPagamento getCurrentObject() {
				if(formasPag==null) {
					formasPag = getCurrentInstance();
					return formasPag;
				}
				else {
					return formasPag;
				}
			}

			/**
			 * 
			 * Inicializa os objectos do meio de pagamento
			 * 
			 */
			public void inicializar() {
				getCurrentObject().setValorCompraObject(AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomTextField[@id='payment-value-0']"));
				getCurrentObject().setMeioPagamentoObject(AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.//DomListBox[@id='payment-method-0']"));
				getCurrentObject().setPlanoPagamentoObject(AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomListBox[@id='payment-plan-0']"));				
			}

			public void alterarValor(String valorPagamento) {

			}
		}

		public static enum PLANOS_PAGAMENTO{
			VALOR_DINAMICO,
			PARCELA_1X,
			PARCELA_2X,
			PARCELA_3X,
			PARCELA_4X,
			PARCELA_5X,
			PARCELA_6X,
			PARCELA_7X,
			PARCELA_8X,
			PARCELA_9X,
			PARCELA_10X,
			PARCELA_11X,
			PARCELA_12X,
			PARCELA_13X,
			PARCELA_14X,
			PARCELA_15X,
			PARCELA_16X,
			PARCELA_17X,
			PARCELA_18X,
			PARCELA_19X,
			PARCELA_20X,
			PARCELA_21X,
			PARCELA_22X,
			PARCELA_23X,
			PARCELA_24X,
			PARCELA_25X,
			PARCELA_26X,
			AVISTA;

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				switch(this) {
				case AVISTA:{
					return "A VISTA";
				}
				case PARCELA_1X:{
					return "(?i:1x|1 x)";
				}
				case PARCELA_2X:{
					return "(?i:2x|2 x)";
				}
				case PARCELA_3X:{
					return "(?i:3x|3 x)";
				}
				case PARCELA_4X:{
					return "(?i:4x|4 x)";
				}
				case PARCELA_5X:{
					return "(?i:6x|6 x)";
				}
				case PARCELA_6X:{
					return "(?i:7x|7 x)";
				}
				case PARCELA_8X:{
					return "(?i:8x|8 x)";
				}
				case PARCELA_9X:{
					return "(?i:9x|9 x)";
				}
				case PARCELA_10X:{
					return "(?i:10x|10 x)";
				}
				case PARCELA_11X:{
					return "(?i:11x|11 x)";
				}
				case PARCELA_12X:{
					return "(?i:11x|11 x)";
				}
				case PARCELA_13X:{
					return "(?i:13x|13 x)";
				}
				case PARCELA_14X:{
					return "(?i:14x|14 x)";
				}
				case PARCELA_15X:{
					return "(?i:15x|15 x)";
				}
				case PARCELA_16X:{
					return "(?i:16x|16 x)";
				}
				case PARCELA_17X:{
					return "(?i:17x|17 x)";
				}
				case PARCELA_18X:{
					return "(?i:18x|18 x)";
				}
				case PARCELA_19X:{
					return "(?i:19x|19 x)";
				}
				case PARCELA_20X:{
					return "(?i:20x|20 x)";
				}
				case PARCELA_21X:{
					return "(?i:21x|21 x)";
				}
				case PARCELA_22X:{
					return "(?i:22x|22 x)";
				}
				case PARCELA_23X:{
					return "(?i:23x|23 x)";
				}
				case PARCELA_24X:{
					return "(?i:24x|24 x)";
				}
				case PARCELA_25X:{
					return "(?i:25x|25 x)";
				}
				case PARCELA_26X:{
					return "(?i:26x|26 x)";
				}
				}
				return super.toString();
			}
		}
		/**
		 * 
		 * Opções de pagamento
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum METODOS_PAGAMENTO{
			VALOR_DINAMICO,
			ELO_CREDITO,
			MASTERCARD,
			HIPERCARD,
			CARTÃO_PROPRIO,
			C_CREDITO,
			DINNERS,
			DINHEIRO,
			AMERICAN_EXPRESS,
			VOUCHER,
			VISA,
			VALE_PRESENTE,
			VALE_TROCA;

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				switch(this) {
				case AMERICAN_EXPRESS:{
					return "AMERICAN EXPRESS";
				}
				case C_CREDITO:{
					return "C. CRÉDITO";
				}
				case CARTÃO_PROPRIO:{
					return "CARTÃO PRÓPRIO";
				}
				case DINHEIRO:{
					return "DINHEIRO";
				}
				case DINNERS:{
					return "DINNERS";
				}
				case ELO_CREDITO:{
					return "ELO CRÉDITO";
				} 
				case HIPERCARD:{
					return "HIPERCARD";
				}
				case MASTERCARD:{
					return "MASTERCARD";
				}
				case VALE_PRESENTE:{
					return "VALE PRESENTE";
				}
				case VALE_TROCA:{
					return "VALE TROCA";
				}
				case VISA:{
					return "VISA";
				}
				case VOUCHER:{
					return "VOUCHER";
				}
				}
				return super.toString();
			}
		}


		/**
		 * 
		 * Retorna o gerenciador de pagamentos para cartões
		 * 
		 * @return PagamentoCartao - Componente
		 */
		public PagamentoCartao getGerenciadorFormasPagamentoCartoes() {
			if(autPagCartao==null) {
				autPagCartao = new PagamentoCartao();				
				return autPagCartao;
			}
			else {				
				return autPagCartao;
			}
		}

		public static AUTVAFormasPagamento getCurrentInstance() {
			if(currentObject==null) {
				currentObject = new AUTVAFormasPagamento();
				return currentObject;
			}
			else {
				return currentObject;
			}
		}

		/**
		 * 
		 * @return the valorCompraObject
		 * 
		 */
		public TObject getValorCompraObject() {
			return valorCompraObject;
		}

		/**
		 * @param valorCompraObject the valorCompraObject to set
		 */
		public void setValorCompraObject(TObject valorCompraObject) {
			this.valorCompraObject = valorCompraObject;
		}

		/**
		 * @return the metodoPagamentoObject
		 */
		public TObject getMetodoPagamentoObject() {
			return metodoPagamentoObject;
		}
		/**
		 * @param metodoPagamentoObject the metodoPagamentoObject to set
		 */
		public void setMeioPagamentoObject(TObject metodoPagamentoObject) {
			this.metodoPagamentoObject = metodoPagamentoObject;
		}
		/**
		 * @return the planoPagamentoObject
		 */
		public TObject getPlanoPagamentoObject() {
			return planoPagamentoObject;
		}
		/**
		 * @param planoPagamentoObject the planoPagamentoObject to set
		 */
		public void setPlanoPagamentoObject(TObject planoPagamentoObject) {
			this.planoPagamentoObject = planoPagamentoObject;
		}
		/**
		 * @return the numeroCartaoObject
		 */
		public TObject getNumeroCartaoObject() {
			return numeroCartaoObject;
		}
		/**
		 * @param numeroCartaoObject the numeroCartaoObject to set
		 */
		public void setNumeroCartaoObject(TObject numeroCartaoObject) {
			this.numeroCartaoObject = numeroCartaoObject;
		}
		/**
		 * @return the nomeTitularObject
		 */
		public TObject getNomeTitularObject() {
			return nomeTitularObject;
		}
		/**
		 * @param nomeTitularObject the nomeTitularObject to set
		 */
		public void setNomeTitularObject(TObject nomeTitularObject) {
			this.nomeTitularObject = nomeTitularObject;
		}
		/**
		 * @return the validadeObject
		 */
		public TObject getValidadeObject() {
			return validadeObject;
		}
		/**
		 * @param validadeObject the validadeObject to set
		 */
		public void setValidadeCartaoObject(TObject validadeObject) {
			this.validadeObject = validadeObject;
		}
		/**
		 * @return the codigoSegurancaObject
		 */
		public TObject getCodigoSegurancaObject() {
			return codigoSegurancaObject;
		}
		/**
		 * @param codigoSegurancaObject the codigoSegurancaObject to set
		 */
		public void setCodigoSegurancaObject(TObject codigoSegurancaObject) {
			this.codigoSegurancaObject = codigoSegurancaObject;
		}
		/**
		 * @return the adicionarValorRestanteObject
		 */
		public TObject getAdicionarValorRestanteObject() {
			return adicionarValorRestanteObject;
		}
		/**
		 * @param adicionarValorRestanteObject the adicionarValorRestanteObject to set
		 */
		public void setAdicionarValorRestanteObject(TObject adicionarValorRestanteObject) {
			this.adicionarValorRestanteObject = adicionarValorRestanteObject;
		}
		/**
		 * @return the excluirMeioPagamentoObject
		 */
		public TObject getExcluirMeioPagamentoObject() {
			return excluirMeioPagamentoObject;
		}
		/**
		 * @param excluirMeioPagamentoObject the excluirMeioPagamentoObject to set
		 */
		public void setExcluirMeioPagamentoObject(TObject excluirMeioPagamentoObject) {
			this.excluirMeioPagamentoObject = excluirMeioPagamentoObject;
		}
		/**
		 * @return the naoAlterarMeioPagamentoCaixaObject
		 */
		public TObject getNaoAlterarMeioPagamentoCaixaObject() {
			return naoAlterarMeioPagamentoCaixaObject;
		}
		/**
		 * @param naoAlterarMeioPagamentoCaixaObject the naoAlterarMeioPagamentoCaixaObject to set
		 */
		public void setNaoAlterarMeioPagamentoCaixaObject(TObject naoAlterarMeioPagamentoCaixaObject) {
			this.naoAlterarMeioPagamentoCaixaObject = naoAlterarMeioPagamentoCaixaObject;
		}
		/**
		 * @return the codigoValePresenteObject
		 */
		public TObject getCodigoValePresenteObject() {
			return codigoValePresenteObject;
		}
		/**
		 * @param codigoValePresenteObject the codigoValePresenteObject to set
		 */
		public void setCodigoValePresenteObject(TObject codigoValePresenteObject) {
			this.codigoValePresenteObject = codigoValePresenteObject;
		}
		/**
		 * @return the codigoValeTrocaObject
		 */
		public TObject getCodigoValeTrocaObject() {
			return codigoValeTrocaObject;
		}
		/**
		 * @param codigoValeTrocaObject the codigoValeTrocaObject to set
		 */
		public void setCodigoValeTrocaObject(TObject codigoValeTrocaObject) {
			this.codigoValeTrocaObject = codigoValeTrocaObject;
		}
		/**
		 * @return the codigoVoucherObject
		 */
		public TObject getCodigoVoucherObject() {
			return codigoVoucherObject;
		}
		/**
		 * @param codigoVoucherObject the codigoVoucherObject to set
		 */
		public void setCodigoVoucherObject(TObject codigoVoucherObject) {
			this.codigoVoucherObject = codigoVoucherObject;
		}
		/**
		 * @return the indexItem
		 */
		public Integer getIndexItem() {
			return indexItem;
		}
		/**
		 * @param indexItem the indexItem to set
		 */
		public void setIndexItem(Integer indexItem) {
			this.indexItem = indexItem;
		}
		/**
		 * @return the valorCompra
		 */
		public String getValorCompra() {
			return valorCompra;
		}
		/**
		 * @param valorCompra the valorCompra to set
		 */
		public void setValorCompra(String valorCompra) {
			DomTextField txt = (DomTextField) getValorCompraObject();
			txt.setText(valorCompra);
			this.valorCompra = valorCompra;
		}
		/**
		 * @return the metodoPagamento
		 */
		public METODOS_PAGAMENTO getMetodoPagamento() {
			return metodoPagamento;
		}
		/**
		 * @param metodoPagamento the metodoPagamento to set
		 */
		public void setMeioPagamento(METODOS_PAGAMENTO metodoPagamento) {
			DomListBox list = (DomListBox) getMetodoPagamentoObject();
			selectValor(list,metodoPagamento.toString());
			this.metodoPagamento = metodoPagamento;
		}
		/**
		 * @return the planoPagamento
		 */
		public PLANOS_PAGAMENTO getPlanoPagamento() {
			return planoPagamento;
		}
		/**
		 * @param planoPagamento the planoPagamento to set
		 */
		public void setPlanoPagamento(PLANOS_PAGAMENTO planoPagamento) {
			DomListBox list = (DomListBox)getPlanoPagamentoObject();
			selectValor(list, planoPagamento.toString());
			this.planoPagamento = planoPagamento;
		}


		/**
		 * @return the numeroCartao
		 */
		public String getNumeroCartao() {
			return numeroCartao;
		}
		/**
		 * @param numeroCartao the numeroCartao to set
		 */
		public void setNumeroCartao(String numeroCartao) {
			DomTextField txt = (DomTextField) getNumeroCartaoObject();
			txt.setFocus();
			txt.click();
			txt.scrollIntoView();
			txt.setText(numeroCartao);
			this.numeroCartao = numeroCartao;
		}


		/**
		 * @return the nomeTitular
		 */
		public String getNomeTitular() {
			return nomeTitular;
		}
		/**
		 * @param nomeTitular the nomeTitular to set
		 */
		public void setNomeTitular(String nomeTitular) {
			DomTextField txt = (DomTextField) getNomeTitularObject();
			txt.setFocus();
			txt.click();
			txt.scrollIntoView();
			txt.setText(nomeTitular);
			this.nomeTitular = nomeTitular;
		}


		/**
		 * @return the validade
		 */
		public String getValidade() {
			return validade;
		}
		/**
		 * @param validade the validade to set
		 */
		public void setValidadeCartao(String validade) {
			DomTextField txt = (DomTextField) getValidadeObject();
			txt.setFocus();
			txt.click();
			txt.scrollIntoView();
			txt.setText(validade);
			this.validade = validade;
		}
		/**
		 * @return the codigoSeguranca
		 */
		public String getCodigoSeguranca() {
			return codigoSeguranca;
		}
		/**
		 * @param codigoSeguranca the codigoSeguranca to set
		 */
		public void setCodigoSeguranca(String codigoSeguranca) {
			DomTextField txt = (DomTextField) getCodigoSegurancaObject();
			txt.setText(codigoSeguranca);
			this.codigoSeguranca = codigoSeguranca;
		}


		/**
		 * @return the adicionarValorRestante
		 */
		public Boolean getAdicionarValorRestante() {
			return adicionarValorRestante;
		}
		/**
		 * @param adicionarValorRestante the adicionarValorRestante to set
		 */
		public void setAdicionarValorRestante(Boolean adicionarValorRestante) {
			this.adicionarValorRestante = adicionarValorRestante;
		}
		/**
		 * @return the ignorarAntifraude
		 */
		public Boolean getIgnorarAntifraude() {
			return ignorarAntifraude;
		}

		/**
		 * @param ignorarAntifraude the ignorarAntifraude to set
		 */
		public void setIgnorarAntifraude(Boolean ignorarAntifraude) {
			autScrollPage();
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='antifraud-option']").waitForProperty("Visible", "true",20 * 1000);
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='antifraud-option']").scrollIntoView();
			if(ignorarAntifraude) {				
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='antifraud-option']").check();
			}
			else {
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='antifraud-option']").uncheck();				
			}
			this.ignorarAntifraude = ignorarAntifraude;
		}


		/**
		 * @param pagarNaLoja configura opção de pagamento na loja
		 */
		public void setPagarNaLoja(Boolean pagarNaLoja) {
			if(pagarNaLoja) {
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='store-payment-option']").check();
			}
			else {
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.//BrowserWindow//DomCheckBox[@id='store-payment-option']").uncheck();				
			}
			this.pagarNaLoja = pagarNaLoja;
		}

		/**
		 * 
		 * 
		 * @return the excluirMeioPagamento
		 */
		public Boolean getExcluirMeioPagamento() {
			return excluirMeioPagamento;
		}
		/**
		 * @param excluirMeioPagamento the excluirMeioPagamento to set
		 */
		public void setExcluirMeioPagamento(Boolean excluirMeioPagamento) {
			this.excluirMeioPagamento = excluirMeioPagamento;
		}
		/**
		 * @return the naoAlterarMeioPagamentoCaixa
		 */
		public Boolean getNaoAlterarMeioPagamentoCaixa() {
			return naoAlterarMeioPagamentoCaixa;
		}
		/**
		 * @param naoAlterarMeioPagamentoCaixa the naoAlterarMeioPagamentoCaixa to set
		 */
		public void setNaoAlterarMeioPagamentoCaixa(Boolean naoAlterarMeioPagamentoCaixa) {
			this.naoAlterarMeioPagamentoCaixa = naoAlterarMeioPagamentoCaixa;
		}
		/**
		 * @return the codigoValePresente
		 */
		public String getCodigoValePresente() {
			return codigoValePresente;
		}
		/**
		 * @param codigoValePresente the codigoValePresente to set
		 */
		public void setCodigoValePresente(String codigoValePresente) {
			this.codigoValePresente = codigoValePresente;
		}
		/**
		 * @return the codigoValeTroca
		 */
		public String getCodigoValeTroca() {
			return codigoValeTroca;
		}
		/**
		 * @param codigoValeTroca the codigoValeTroca to set
		 */
		public void setCodigoValeTroca(String codigoValeTroca) {
			this.codigoValeTroca = codigoValeTroca;
		}
		/**
		 * @return the codigoVoucher
		 */
		public String getCodigoVoucher() {
			return codigoVoucher;
		}
		/**
		 * @param codigoVoucher the codigoVoucher to set
		 */
		public void setCodigoVoucher(String codigoVoucher) {
			this.codigoVoucher = codigoVoucher;
		}		




	}


	/**
	 * 
	 * Classe responsável pelo gerenciamento dos fluxos de saída no VA
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static class AUTVAFluxosSaidaComponente extends AUTVABaseComponent{
		java.util.List<AUTVAFluxosSaidaComponente> listaFluxos;
		FLUXO_SAIDA_TIPOS tipoFluxoSaida;
		TIPOS_RETIRA tipoRetiraGeral; //Define o fluxo de retira que será aplicado para todos os itens
		FILIAIS filialEstoqueGeral; //Define a filial de estoque para todos os itens
		FILIAIS filialSaidaGeral; //Define a filial de saída para todos os itens
		DEPOSITOS depositosGeral; //
		String dataEntregaGeral;
		String horaEntregaGeral;
		AGRUPAR_DATAS agruparDatas;
		ENCOMENDA encomendarItem;
		USAR_DATA_MAIS_PROXIMA usarDataMaisProxima;
		String enderecoCadastrado;
		String opcoesFrete;
		OPCIONAIS_ADICIONAIS_FRETE inforcoesAdicionaisFrete;
		TIPO_FRETE tipoCalcFrete;
		Integer indexFluxo;
		Integer material;

		AUT_VA_TIPO_FRETE tipoFrete;
		AUT_VA_TURNOS_ENTREGA turnoEntrega;
		Boolean habilitarEncomenda = false;



		/**
		 * 
		 * Habilitar encomenda para item especifico
		 * 
		 * 
		 * @return the habilitarEncomenda
		 * 
		 */
		public Boolean getHabilitarEncomenda() {
			return habilitarEncomenda;
		}


		/**
		 * 
		 * Habilita encomenda para item específico
		 * 
		 * @param habilitarEncomenda the habilitarEncomenda to set
		 * 
		 */
		public void setHabilitarEncomenda(Boolean habilitarEncomenda) {
			habilitarEncomenda = habilitarEncomenda;
		}


		/**
		 * @return the turnoEntrega
		 */
		public AUT_VA_TURNOS_ENTREGA getTurnoEntrega() {
			return turnoEntrega;
		}


		/**
		 * @param turnoEntrega the turnoEntrega to set
		 */
		public void setTurnoEntrega(AUT_VA_TURNOS_ENTREGA turnoEntrega,Integer rowIndex) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='deliveryOptionShift-%s']",(rowIndex > 0 ? --rowIndex : 0))));			
			this.turnoEntrega = turnoEntrega;
		}



		/**
		 * @param turnoEntrega the turnoEntrega to set
		 */
		public void setTurnoEntregaPorIndexLinha(AUT_VA_TURNOS_ENTREGA turnoEntrega,Integer rowIndex) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='deliveryOptionShift-*'][%s]",rowIndex)));			
			this.turnoEntrega = turnoEntrega;
		}

		public static enum AUT_VA_TURNOS_ENTREGA{
			MANHA,
			TARDE,
			NOITE
		}

		/**
		 * @return the tipoFrete
		 */
		public AUT_VA_TIPO_FRETE getTipoFrete() {			
			return tipoFrete;
		}

		///DomListBox[@id='delivery-option-freight']

		/**
		 * 
		 * Altera o tipo de frete
		 * 
		 * @param tipoFrete the tipoFrete to set
		 */
		public void setTipoFrete(AUT_VA_TIPO_FRETE tipoFrete,Integer rowIndex) {
			//AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionType-%s']",(rowIndex > 0 ? --rowIndex : 0))).select(tipoFrete.toString());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionType-%s']",(rowIndex > 0 ? --rowIndex : 0))),tipoFrete.toString());
			this.tipoFrete = tipoFrete;
		}

		public void setTipoFretePorIndexLinha(AUT_VA_TIPO_FRETE tipoFrete,Integer rowIndex) {
			//AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionType-%s']",(rowIndex > 0 ? --rowIndex : 0))).select(tipoFrete.toString());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionType-*'][%s]",rowIndex)),tipoFrete.toString());
			this.tipoFrete = tipoFrete;
		}


		public void setTipoFrete(AUT_VA_TIPO_FRETE tipoFrete) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.//SELECT[@id='delivery-option-freight']"),tipoFrete.toString());
			this.tipoFrete = tipoFrete;
		}

		static Boolean startEntregas = false,startCaixa = false,startRetira = false;
		/**
		 * @return the listaFluxos
		 */
		public java.util.List<AUTVAFluxosSaidaComponente> getListaFluxos() {
			return listaFluxos;
		}


		/**
		 * @param listaFluxos the listaFluxos to set
		 */
		public void setListaFluxos(java.util.List<AUTVAFluxosSaidaComponente> listaFluxos) {
			this.listaFluxos = listaFluxos;
		}


		/**
		 * @return the tipoFluxoSaida
		 */
		public FLUXO_SAIDA_TIPOS getTipoFluxoSaida() {
			return tipoFluxoSaida;
		}


		/**
		 * @param tipoFluxoSaida the tipoFluxoSaida to set
		 */
		public void setTipoFluxoSaida(FLUXO_SAIDA_TIPOS tipoFluxoSaida) {
			switch(tipoFluxoSaida) {
			case CAIXA:{	
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaGlobal").select();
				break;
			}
			case ENTREGA:{	
				fecharPopupEnderecosParaEntrega();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaEntrega").select();				
				break;
			}
			case RETIRA:{				
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaRetirada").select();
				break;
			}
			}
			this.tipoFluxoSaida = tipoFluxoSaida;
		}


		/**
		 * @return the tipoRetiraGeral
		 */
		public TIPOS_RETIRA getTipoRetiraGeral() {
			return tipoRetiraGeral;
		}


		/**
		 * @param tipoRetiraGeral the tipoRetiraGeral to set
		 */
		public void setTipoRetiraGeral(TIPOS_RETIRA tipoRetiraGeral) {
			switch(tipoRetiraGeral) {
			case RETIRA_EXTERNA_AGENDADA:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.TipoRetira"), tipoRetiraGeral.toString());		
				break;
			}
			case RETIRA_EXTERNA_IMEDIATA:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.TipoRetira"), tipoRetiraGeral.toString());

				break;
			}
			case RETIRA_INTERNA_AGENDADA:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.TipoRetira"), tipoRetiraGeral.toString());

				break;
			}
			case RETIRA_INTERNA_IMEDIATA:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.TipoRetira"), tipoRetiraGeral.toString());

				break;
			}
			}
			this.tipoRetiraGeral = tipoRetiraGeral;
		}

		/**
		 * 
		 * Altera o tipo de fluxo de entrega
		 * 
		 * @param tipoRetiraGeral - Tipo de fluxo de retira
		 * @param rowIndex - Número do registro que será alterado
		 * 
		 */
		public void setTipoRetiraGeral(TIPOS_RETIRA tipoRetiraGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				setTipoRetiraGeral(tipoRetiraGeral);				
			}
			default:{
				if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='withdrawalOptionType-%s*']",(rowIndex > 0 ? --rowIndex : 0))), tipoRetiraGeral.toString());				
			}
			}
		}


		/**
		 * 
		 * Retorna a filial de estoque para o registro específico
		 * 
		 * @return the filialEstoqueGeral - Filial de estoque
		 * 
		 */
		public FILIAIS getFilialEstoqueGeral() {
			return filialEstoqueGeral;
		}


		/**
		 * @param filialEstoqueGeral the filialEstoqueGeral to set
		 */
		public void setFilialEstoqueGeral(FILIAIS filialEstoqueGeral) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.FilialEstoque"), filialEstoqueGeral.toString());
			this.filialEstoqueGeral = filialEstoqueGeral;
		}

		/**
		 * 
		 * Filial de estoque geral
		 * 
		 * @param filialEstoqueGeral - 
		 * @param rowIndex
		 */
		public void setFilialEstoqueGeral(FILIAIS filialEstoqueGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.FilialEstoque"), filialEstoqueGeral.toString());
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='deliveryOptionDeposit-%s']",(rowIndex > 0 ? --rowIndex : 0))), filialEstoqueGeral.toString());									
					break;
				}
				default:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='withdrawalOptionDeposit-%s']",(rowIndex > 0 ? --rowIndex : 0))), filialEstoqueGeral.toString());		
					break;
				}
				}
			}
			}
		}

		/**
		 * 
		 * Filial de estoque geral
		 * 
		 * @param filialEstoqueGeral - 
		 * @param rowIndex
		 */
		public void setFilialEstoqueGeralPorIndexLinha(FILIAIS filialEstoqueGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.FilialEstoque"), filialEstoqueGeral.toString());
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionDeposi*'][%s]",rowIndex)), filialEstoqueGeral.toString());									
					break;
				}
				default:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionDeposi*'][%s]",rowIndex)), filialEstoqueGeral.toString());		
					break;
				}
				}
			}
			}
		}

		/**
		 * @return the filialSaidaGeral
		 */
		public FILIAIS getFilialSaidaGeral() {
			return filialSaidaGeral;
		}


		/**
		 * @param filialSaidaGeral the filialSaidaGeral to set
		 */
		public void setFilialSaidaGeral(FILIAIS filialSaidaGeral) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.FilialSaidaMercadoria"), filialSaidaGeral.toString());
			this.filialSaidaGeral = filialSaidaGeral;
		}


		public void setFilialSaidaGeral(FILIAIS filialSaidaGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				setFilialSaidaGeral(filialSaidaGeral);
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='deliveryOptionExpedition-%s']",(rowIndex > 0 ? --rowIndex : 0))), filialSaidaGeral.toString());					
					break;
				}
				default:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='withdrawalOptionExpedition-%s']",(rowIndex > 0 ? --rowIndex : 0))), filialSaidaGeral.toString());					
					break;
				}
				}
				break;
			}
			}
		}


		public void setFilialSaidaGeralPorIndexLinha(FILIAIS filialSaidaGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				setFilialSaidaGeral(filialSaidaGeral);
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionExpedi*'][%s]",rowIndex)), filialSaidaGeral.toString());					
					break;
				}
				default:{
					if(rowIndex > 0) selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionExpedi*'][%s]",(rowIndex > 0 ? --rowIndex : 0))), filialSaidaGeral.toString());					
					break;
				}
				}
				break;
			}
			}
		}
		/**
		 * @return the depositosGeral
		 */
		public DEPOSITOS getDepositosGeral() {
			return depositosGeral;
		}


		/**
		 * @param depositosGeral the depositosGeral to set
		 */
		public void setDepositosGeral(DEPOSITOS depositosGeral) {
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.Deposito"), depositosGeral.toString());
			this.depositosGeral = depositosGeral;
		}

		public void setDepositosGeral(DEPOSITOS depositosGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				setDepositosGeral(depositosGeral);				
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='deliveryOptionWarehouse-%s']",(rowIndex > 0 ? --rowIndex : 0))), depositosGeral.toString());					
					break;
				}
				default:{
					selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='withdrawalOptionWarehouse-%s']",(rowIndex > 0 ? --rowIndex : 0))), depositosGeral.toString());					
					break;
				}
				}
				break;
			}
			}
		}


		public void setDepositosGeralPorIndexLinha(DEPOSITOS depositosGeral,Integer rowIndex) {
			switch(rowIndex) {
			case 0:{
				setDepositosGeral(depositosGeral);				
				break;
			}
			default:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionWareho*'][%s]",rowIndex)), depositosGeral.toString());					
					break;
				}
				default:{
					selectValor(AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//SELECT[@id='deliveryOptionWareho*'][%s]",rowIndex)), depositosGeral.toString());					
					break;
				}
				}
				break;
			}
			}
		}
		/**
		 *
		 * @return the dataEntregaGeral
		 *
		 */
		public String getDataEntregaGeral() {
			return dataEntregaGeral;
		}


		/**
		 * 
		 * Altera a data de agendamento para  o valor padrão de acordo com regra específica do negócio
		 * 
		 * 
		 * - Fluxo de configuração de processo especificos de televendas
		 *
		 * -Data padrão - Dia atual
		 * 
		 */
		public void setDataEntregaGeral() {
			setDataEntregaGeral(autGetDateNow());
		}


		/**
		 * Altera a data de agendamento padrão do registro especificado na linha do registro especifica 
		 * 
		 * Fluxo de geração de pedidos
		 * 
		 * Configuração do fluxo de saída
		 * 
		 * -Data padrão - Dia atual
		 * @param rowIndex - Número do registro de configuração
		 * 
		 */
		public <TRowIndex extends Integer> void setDataEntregaGeral(TRowIndex rowIndex) {
			setDataEntregaGeral(autGetDateNow(),rowIndex);
		}

		/**
		 * @param dataEntregaGeral the dataEntregaGeral to set
		 *
		 *-Data padrão - Dia atual
		 *
		 */
		public void setDataEntregaGeral(String dataEntregaGeral) {
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FluxosDeSaida.DataDisponivel").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FluxosDeSaida.DataDisponivel").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FluxosDeSaida.DataDisponivel").setText(dataEntregaGeral);

			this.dataEntregaGeral = dataEntregaGeral;
		}

		/**
		 * 
		 * Altera a data padrão para o fluxo de saída específico
		 * 
		 * -Data padrão - Dia atual
		 * 
		 * @param dataEntregaGeral the dataEntregaGeral to set
		 * 
		 */
		public <TRow extends Integer> void setDataEntregaGeral(String dataEntregaGeral,Integer rowIndex) {
			if(rowIndex > 0) {				
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					DomTextField txtDt = AUT_AGENT_SILK4J.<DomTextField>find(String.format("VA.TL011FluxosDeSaida.//INPUT[@id='delivery-option-date-%s']",(rowIndex > 0 ? --rowIndex : 0)));
					txtDt.setFocus();
					txtDt.click();
					txtDt.setText(dataEntregaGeral);									
					break;
				}
				default:{
					DomTextField txtDt = AUT_AGENT_SILK4J.<DomTextField>find(String.format("VA.TL011FluxosDeSaida.//INPUT[@id='withdrawal-option-date-%s']",(rowIndex > 0 ? --rowIndex : 0)));
					txtDt.setFocus();
					txtDt.click();
					txtDt.setText(dataEntregaGeral);									
					break;
				}
				}

			}
			else {
				setDataEntregaGeral(autGetDateNow());
			}
		}

		/**
		 * @return the horaEntregaGeral
		 */
		public String getHoraEntregaGeral() {
			return horaEntregaGeral;
		}


		/**
		 * @param horaEntregaGeral the horaEntregaGeral to set
		 */
		public void setHoraEntregaGeral(String horaEntregaGeral) {
			DomListBox lt = AUT_AGENT_SILK4J.<DomListBox>find("VA.TL011FluxosDeSaida.HoraRetirada");
			if(lt.getItemCount() > 1) {
				selectValor(lt);						
			}
			else {
				lt.setProperty("textContent", horaEntregaGeral);
			}
			this.horaEntregaGeral = horaEntregaGeral;
		}

		public void setHoraEntregaGeral() {
			setHoraEntregaGeral(autGetTimeNow());
		}		

		public<TIndexRow extends Integer> void setHoraEntregaGeral(TIndexRow rowIndex) {
			setHoraEntregaGeral(autGetTimeNow(),rowIndex);
		}		

		/**
		 * 
		 * Altera a hora padrão do sistema, configuração do fluxo de saida
		 * 
		 * 
		 * @param horaEntregaGeral - Hora do agendamento
		 * @param rowIndex - Número do registro no fluxo de saída que será alterada
		 * 
		 */
		public void setHoraEntregaGeral(String horaEntregaGeral,Integer rowIndex) {			
			DomListBox lt = AUT_AGENT_SILK4J.<DomListBox>find(String.format("VA.TL011FluxosDeSaida.//DomListBox[@id='withdrawalOptionTime-%s']",(rowIndex > 0 ? --rowIndex : 0)));
			if(lt.getItemCount() > 1) {
				selectValor(lt);			
			}
			else {
				lt.setProperty("innerHtml", String.format("<option>%s</option>",horaEntregaGeral));
				lt.click();			
			}
			this.horaEntregaGeral = horaEntregaGeral;			
		}


		/**
		 * @return the agruparDatas
		 */
		public AGRUPAR_DATAS getAgruparDatas() {
			return agruparDatas;
		}


		/**
		 * @param agruparDatas the agruparDatas to set
		 */
		public void setAgruparDatas(AGRUPAR_DATAS agruparDatas) {
			this.agruparDatas = agruparDatas;
		}


		/**
		 * @return the encomendarItem
		 */
		public ENCOMENDA getEncomendarItem() {
			return encomendarItem;
		}


		/**
		 * @param encomendarItem the encomendarItem to set
		 */
		public void setEncomendarItem(ENCOMENDA encomendarItem) {
			switch(encomendarItem) {
			case SIM:{
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.EntregaPorEncomenda").select();
				break;
			}
			case NAO:{
				//AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.EntregaPorEncomenda"); //Bobão
				break;
			}
			}
			this.encomendarItem = encomendarItem;
		}

		/**
		 * 
		 * Define se o item especifico será entrega por encomenda ou não
		 * 
		 * @param encomendarItem - Sim ou não
		 * @param rowIndex - Numero do registro que será marcado para encomenda
		 * 
		 */
		public void setEncomendarItem(ENCOMENDA encomendarItem,Integer rowIndex) {
			switch(encomendarItem) {
			case NAO:{
				if(rowIndex > 0) {
					AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//INPUT[@id='delivery-order-%s']",(rowIndex > 0 ? --rowIndex : 0))).uncheck();	
					boolean exibiMsgLoteAlerta = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//DIV[@class='modal-body']//DomElement[@textContents='Continuar']", 3 * 1000);
					if(exibiMsgLoteAlerta) {
						AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow//DIV[@class='modal-body']//DomElement[@textContents='Continuar']").click();

					}
				}
				break;
			}
			case SIM:{
				if(rowIndex > 0) {
					//VA.//BrowserWindow//INPUT[@id='delivery-order-2']
					AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//INPUT[@id='delivery-order-%s']",(rowIndex > 0 ? --rowIndex : 0))).check();	

					boolean exibiMsgLoteAlerta = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//DIV[@class='modal-body']//DomElement[@textContents='Continuar']", 3 * 1000);
					if(exibiMsgLoteAlerta) {
						AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DIV[@class='modal-body']//DomElement[@textContents='Continuar']").click();						
					}
				}
				break;
			}
			}
		}

		/**
		 * @return the usarDataMaisProxima
		 */
		public USAR_DATA_MAIS_PROXIMA getUsarDataMaisProxima() {
			return usarDataMaisProxima;
		}

		/**
		 * 
		 * Define a data mais proxima para agendamento do item específico
		 * 
		 * @param usarDataMaisProxima - Sim ou nao - O item padrao e o primeiro registro
		 */
		public void setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA usarDataMaisProxima) {
			switch(usarDataMaisProxima){
			case NAO:{
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.TL011FluxosDeSaida.UsarDataMaisProxima").uncheck();		
				break;
			} 
			case SIM:{
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.TL011FluxosDeSaida.UsarDataMaisProxima").check();						
				break;
			}
			}
		}


		public void fecharPopupEnderecosParaEntrega() {
			boolean exibErroConsultaEstoque = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//DomButton[@textContents='Confirmar']", 1 * 1000);
			boolean exibErroConsultaEstoqueBotao1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//I[@class='modal-close glyph gl*'][2]", 1 * 1000);
			boolean exibiCepNaoCadastrado = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011PopupEnderecos").exists("//I[@class='modal-close glyph gl*'][4]", 1 * 1000);			
			boolean exibiMsgLoteAlerta = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//DIV[@class='modal-body']//DomElement[@textContents='Continuar']", 1 * 1000);
			boolean exibiPopupEnderecos = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011PopupEnderecos").exists("PopUp1", 1 * 1000);


			if(exibErroConsultaEstoqueBotao1 || exibErroConsultaEstoque) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//I[@class='modal-close glyph gl*'][2]").click();	
			}

			if(exibiMsgLoteAlerta) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.BrowserWindow//DIV[@class='modal-body']//DomElement[@textContents='Continuar']").click();
			}


			//Verifica se existe um popup informando erro na pesquisa de CEP			
			if(exibiCepNaoCadastrado) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PopupEnderecos.//I[@class='modal-close glyph gl*'][4]").click();		
			}


			//Verifica o popup para pesquisa de endereços
			if(exibiPopupEnderecos) {				
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PopupEnderecos.PopUp1.//LI[1]").click();				
				boolean existInfoAdicionais = AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PopupEnderecos.PopUp1").exists("//P[@textContents='Informações adiciona*']", 4 * 1000);
				if(existInfoAdicionais) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PopupEnderecos.BotaoSalvar").click();
				}
			}
		}


		/**
		 * Executa procedimentos para inicialização de fluxos de saida relacionados a entregas
		 */
		public void initFluxoSaidaRetira() {

			if(!startRetira) {
				fecharPopupEnderecosParaEntrega();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaRetirada").select();

			}
		}
		/**
		 * Executa procedimentos para inicialização de fluxos de saida relacionados a caixa
		 */
		public void initFluxoSaidaCaixa() {
			if(!startCaixa) {
				fecharPopupEnderecosParaEntrega();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaGlobal").select();
			}
		}

		/**
		 * Executa procedimentos para inicialização de fluxos de saida relacionados a entregas
		 */
		public void initFluxoSaidaEntrega() {
			if(!startEntregas) {

				setFluxoEntregasGeral();
				fecharPopupEnderecosParaEntrega();


				AUT_AGENT_SILK4J.<DomRadioButton>find("VA//BrowserWindow//INPUT[@id='itemcaixa-1']").select();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FluxosDeSaida.CaixaEntrega").select();
				startEntregas = true;
			}
		}

		/**
		 * Configura o fluxo de saída padrão como externa agendada para loja 19
		 * 
		 * 
		 * @param material - Material
		 */
		public void setFluxoExternaAgendaPadrao(String material) {
			autScrollPage();
			initFluxoSaidaRetira();
			Integer row = getIndexRowByItem(material);
			setTipoRetiraGeral(TIPOS_RETIRA.RETIRA_EXTERNA_AGENDADA,row);
			setFilialEstoqueGeral(FILIAIS.LJ0019,row);
			setFilialSaidaGeral(FILIAIS.LJ0019,row);
			setDepositosGeral(DEPOSITOS.C010,row);				
			setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);			
			setHoraEntregaGeral(row);			
		} 

		/**
		 * Configura o fluxo de saída padrão como interna agendada para loja 19
		 * 
		 * 
		 * @param material - Material
		 */		
		public void setFluxoInternaAgendaPadrao(String material) {
			autScrollPage();
			initFluxoSaidaRetira();

			Integer row = getIndexRowByItem(material);

			setTipoRetiraGeral(TIPOS_RETIRA.RETIRA_INTERNA_AGENDADA,row);
			setFilialEstoqueGeral(FILIAIS.LJ0019,row);
			setFilialSaidaGeral(FILIAIS.LJ0019,row);
			setDepositosGeral(DEPOSITOS.C010,row);				
			//setEncomendarItem(ENCOMENDA.SIM,row);
			setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);
			setHoraEntregaGeral(row);			
		} 



		/**
		 * Cria pedido com fluxo de entrega para central de distribuição
		 * 
		 * @param material - Material
		 */
		public void setFluxoEntregaPadraoCD(String material) {
			autScrollPage();
			initFluxoSaidaEntrega();

			Integer row = getIndexRowByItem(material);
			setTipoFrete(AUT_VA_TIPO_FRETE.NORMAL, row);
			setFilialEstoqueGeral(FILIAIS.LJ0014,row);
			setFilialSaidaGeral(FILIAIS.LJ0014,row);
			setDepositosGeral(DEPOSITOS.C010,row);				
			setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);
			setTurnoEntrega(turnoEntrega, getIndexRowByItem(material));	
			setTipoFrete(AUT_VA_TIPO_FRETE.NORMAL, row);	
			setTurnoEntrega(turnoEntrega, getIndexRowByItem(material));	

		}

		/**
		 * Seleciona a opção de entrega para um item individual
		 * 
		 * @param row
		 */
		public void setOpcaoItemEntrega(Integer row) {
			row-=1;
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists(String.format("//INPUT[@id='itemcaixa-%s']",row))) {
				AUT_AGENT_SILK4J.<DomRadioButton>find(String.format("VA//BrowserWindow//INPUT[@id='itemcaixa-%s']",row)).scrollIntoView();
				AUT_AGENT_SILK4J.<DomRadioButton>find(String.format("VA//BrowserWindow//INPUT[@id='itemcaixa-%s']",row)).select();				
				com.borland.silktest.jtf.Utils.sleep(2*1000);				
			}
			AUT_AGENT_SILK4J.<DomRadioButton>find(String.format("VA.//BrowserWindow//INPUT[@id='itementrega-%s']",(row).toString())).select();
		}

		/**
		 * Cria pedido com fluxo de entrega para central de distribuição
		 * 
		 * @param material - Material
		 */
		public void autIniciarGeradorPedidosAgendados(Integer row,AUT_VA_TIPO_FRETE tipoFrete,FILIAIS filialEstoque,FILIAIS filialSaida,DEPOSITOS deposito,AUT_VA_TURNOS_ENTREGA turnoEntregaInpupt) {
			autScrollPage();
			initFluxoSaidaEntrega();
			setOpcaoItemEntrega(row);
			setUsarDataMaisProximaPorIndexLinha(USAR_DATA_MAIS_PROXIMA.SIM,row);
			setTipoFretePorIndexLinha(tipoFrete, row);
			setFilialEstoqueGeralPorIndexLinha(filialEstoque,row);
			setFilialEstoqueGeralPorIndexLinha(filialSaida,row);
			setDepositosGeralPorIndexLinha(deposito,row);				
			setTurnoEntregaPorIndexLinha(turnoEntregaInpupt, row);	

			autScrollPage();
		}

		public void autConfigPedidos(Integer row,FILIAIS tipo) {
			row +=1 ;

			switch(tipo) {
			case CENTRAL_DISTRIBUICAO:{
				autIniciarGeradorPedidosAgendados(row, AUT_VA_TIPO_FRETE.NORMAL, FILIAIS.LJ0014, FILIAIS.LJ0045, DEPOSITOS.C010, AUT_VA_TURNOS_ENTREGA.MANHA);				
				break;
			}
			case LOJA:{
				autIniciarGeradorPedidosAgendados(row, AUT_VA_TIPO_FRETE.NORMAL, FILIAIS.LJ0045, FILIAIS.LJ0045, DEPOSITOS.C010, AUT_VA_TURNOS_ENTREGA.MANHA);				
				break;
			}
			}
		}

		private void autExceptionFluxoEntregas() {
			/*
			Boolean bMsgConfirmServico = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow//DIV[@class='container-fluid alig*'][3]").exists("//BUTTON[@textContents='Confirmar']", 3 * 1000);			
			if(bMsgConfirmServico) {
				AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//DIV[@class='container-fluid alig*'][3]//DomButton[@textContents='Confirmar']").click();
				com.borland.silktest.jtf.Utils.sleep(3 * 1000);
				AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//DIV[@class='container-fluid alig*'][3]//DomButton[@textContents='Confirmar']").click();				
			}
			 */
		}
		/**
		 * 
		 *
		 * 
		 * 
		 * Configura o fluxo de saída para todos os itens no fluxo
		 * 
		 * 
		 * - Por Index
		 * 
		 */
		public void autConfigurarFluxosSaidaEntrega(FILIAIS tipoPedido) {
			autExceptionFluxoEntregas();
			Integer row = 0;
			int totItens = getRowsCount();
			for(row=0;row < totItens;row++) {
				autConfigPedidos(row, tipoPedido);
			}
		}

		/**
		 * 
		 * 
		 * Configura o fluxo de saída para todos os itens no fluxo
		 * 
		 * 
		 * - Por Index
		 * 
		 */
		public void autConfigurarFluxosSaidaEntrega(FILIAIS fluxoParaTodosOsItens,FILIAIS fluxoParaItensEspecificos,Integer itemInicial,Integer itemFinal) {
			autExceptionFluxoEntregas();
			Integer row = 0;
			int totItens = getRowsCount();
			for(row=0;row < totItens;row++) {
				if(row >= itemInicial && row <= itemFinal) {
					autConfigPedidos(row, fluxoParaItensEspecificos);
				}
				else {
					autConfigPedidos(row, fluxoParaTodosOsItens);
				}		
			}
		}



		/**
		 * 
		 * 
		 * Configura o fluxo de saída para todos os itens no fluxo
		 * 
		 * 
		 * - Por Index
		 * 
		 */
		public void autConfigurarFluxosSaidaEntrega(FILIAIS tipoPedido,Integer row) {
			autExceptionFluxoEntregas();
			autConfigPedidos(row, tipoPedido);
		}


		public void setFluxoEntregasGeral() {

			setTipoFluxoSaida(FLUXO_SAIDA_TIPOS.ENTREGA);
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='delivery-option-freight']"),AUT_VA_TIPO_FRETE.NORMAL.toString());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//SELECT[@id='delivery-option-exte*']"),FILIAIS.LJ0045.toString());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='delivery-option-exit']"),FILIAIS.LJ0045.toString());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='deliveryOptionWareho*']"),DEPOSITOS.C050.toString());

			AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//INPUT[@id='deliveryOptionDate']").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//INPUT[@id='deliveryOptionDate']").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//INPUT[@id='deliveryOptionDate']").setText(autGetDateNow());
			selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//SELECT[@id='delivery-option-turn']"));
		}

		/**
		 * 
		 * Cria pedido com o fluxo de entrega padrão
		 * 
		 * @param material - Material
		 */
		public void setFluxoEntregaPadraoLoja(String material) {
			autScrollPage();
			initFluxoSaidaEntrega();

			Integer row = getIndexRowByItem(material);

			setTipoFrete(AUT_VA_TIPO_FRETE.NORMAL, row);
			setFilialEstoqueGeral(FILIAIS.LJ0045,row);
			setFilialSaidaGeral(FILIAIS.LJ0045,row);
			setDepositosGeral(DEPOSITOS.C050,row);				
			setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);
			setTurnoEntrega(turnoEntrega, getIndexRowByItem(material));	
			setTipoFrete(AUT_VA_TIPO_FRETE.NORMAL, row);

		}
		public void setFluxoEntregaPadrao(TIPOS_RETIRA retira,FILIAIS filialEstoque,FILIAIS filialSaida,DEPOSITOS deposito,String material) {
			autScrollPage();
			initFluxoSaidaEntrega();

			Integer row = getIndexRowByItem(material);

			setTipoRetiraGeral(retira,row);
			setFilialEstoqueGeral(filialEstoque,row);
			setFilialSaidaGeral(filialSaida,row);
			setDepositosGeral(deposito,row);				
			setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);
			setHoraEntregaGeral(row);			
		}

		/**
		 * Configura o fluxo de saída padrão como interna imediata para loja 19
		 * 
		 * 
		 * @param material - Material
		 */		
		public void setFluxoInternaImediataPadrao(String material) {
			autScrollPage();
			initFluxoSaidaRetira();
			Integer row = getIndexRowByItem(material);

			setTipoRetiraGeral(TIPOS_RETIRA.RETIRA_INTERNA_IMEDIATA,row);
			setFilialEstoqueGeral(FILIAIS.LJ0019,row);
			setFilialSaidaGeral(FILIAIS.LJ0019,row);
			setDepositosGeral(DEPOSITOS.C010,row);	
			try {
				//setEncomendarItem(ENCOMENDA.SIM,row);
				setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA.SIM,row);
				setHoraEntregaGeral(row);			
			}
			catch(java.lang.Exception e) {

			}
		} 


		/**
		 * 
		 * Configura o fluxo de saída padrão como Externa imediata para loja 19
		 * 
		 * 
		 * @param material - Material
		 */		
		public void setFluxoExternaImediataPadrao(String material) {
			autScrollPage();
			initFluxoSaidaRetira();
			Integer row = getIndexRowByItem(material);

			setTipoRetiraGeral(TIPOS_RETIRA.RETIRA_EXTERNA_IMEDIATA,row);
			setFilialEstoqueGeral(FILIAIS.LJ0019,row);
			setFilialSaidaGeral(FILIAIS.LJ0019,row);
			setDepositosGeral(DEPOSITOS.C010,row);	

			try {
				setDataEntregaGeral(row);
				setHoraEntregaGeral(row);			
			}
			catch(java.lang.Exception e) {

			}
		} 

		/**
		 * 
		 * Retorna o index da linha para o material especificado
		 * 
		 * @param itemMaterial - Index da linha de 0-X ou null caso tenha ocorrido algum erro no processo de captura
		 * @return Integer - Index da linha
		 * 
		 */
		public Integer getIndexRowByItem(String itemMaterial) {
			try {
				System.out.println(String.format("AUT INFO: PESQUISANDO INDEX DA LINHA RELACIONADA AO MATERIAL INFORMADO: %s",itemMaterial));
				DomElement item = AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.TL011FluxosDeSaida.//LI[@class='list-item' and @data-product-code='%s']",itemMaterial));
				String strIndexRow = item.getDomAttribute("data-item-number").toString();
				Integer indexRowOut = (strIndexRow!=null ? Integer.parseInt(strIndexRow) : -1);
				if(indexRowOut==-1) {
					return null;
				}
				else {
					return ++indexRowOut;
				}
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR: NAO FOI POSSIVEL RETORNA O INDEX DA LINHA DO MATERIAL");;
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}


		/**
		 * 
		 * Retorna o total de itens no fluxo de saída atual
		 * 
		 * @return Integer - Total de itens do fluxo de saída
		 * 
		 */
		public Integer getRowsCount() {
			try {
				System.out.println("AUT INFO: RECUPERAR NUMERO TOTAL DE ITENS DO FLUXO DE SAIDA");
				java.util.List<DomElement> list = AUT_AGENT_SILK4J.findAll("VA.TL011FluxosDeSaida.//DomElement[@data-component='order/flux/item order/flow/order-item-container']");
				Integer contItens = 0;
				java.util.regex.Pattern verifExp = java.util.regex.Pattern.compile("\\d+");
				java.util.regex.Matcher verifCode = null;
				for(DomElement item:list) {
					String material = item.getDomAttribute("data-product-code").toString();
					verifCode = verifExp.matcher(material);
					if(verifCode.find()) {
						contItens++;
						System.out.println(String.format("AUT INFO: ITEM CARREGADO NO FLUXO DE SAIDA: %s : VALID: OK",material));						
					}
					else {
						System.out.println(String.format("AUT INFO: ITEM CARREGADO NO FLUXO DE SAIDA: %s : VALID: NOK",material));												
					}
				}				
				return contItens;
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR: RECUPERAR NUMERO TOTAL DE ITENS DO FLUXO SAIDA");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}


		/**
		 * 
		 *Navega para a proxima pagina de configuração do fluxo de criação de pedidos - Meios de Pagamento 
		 *
		 */
		public void autIrProximaPagina() {
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FluxosDeSaida.AvancarPagina").click();						
		}



		public void autFinalizarPedido() {			
			autIrProximaPagina();			
			autIrProximaPagina();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FluxosDeSaida.Finalizar").click();		
		}

		public void autFinalizarPedidoFromConfigAgendamentoServicoGarantia(java.util.HashMap<String,Object> parameters) {			
			AUT_TIPO_TELEFONE_PARA_CONTATO tipoTel = AUT_TIPO_TELEFONE_PARA_CONTATO.valueOf(parameters.get("AUT_TIPO_TELEFONE_PARA_CONTATO_AGENDA_ENTREGA").toString());
			
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomElement[@data-action-flow='next']").click();		
			AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@id='phoneNumber']").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@id='phoneNumber']").setText(parameters.get("AUT_TELEFONE_PARA_CONTATO_AGENDA_ENTREGA").toString());			
		
			AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//DomForm[@data-form='phone-number']//DomButton[@type='submit']").scrollIntoView();
			
			AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//DomForm[@data-form='phone-number']//DomButton[@type='submit']").click();
			
			boolean cadastrarTel = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.//BrowserWindow").exists("//DomForm[@data-form='new-phone-number']",3 * 1000);
			if(cadastrarTel) {
				
				DomListBox lt = AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomForm[@data-form='new-phone-number']//DomListBox[@id='phoneType']");
				selectValor(lt,tipoTel.toString());
				AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//DomForm[@data-form='new-phone-number']//DomButton[@type='submit']").click();
				
			}

			autIrProximaPagina();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FluxosDeSaida.Finalizar").click();	
		}
		
		
		
		public void autFinalizarPedidoFromFluxosSaida() {			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FluxosDeSaida.Finalizar").click();		
		}

		public void autFinalizarPedidoFromConfigFormasPagamento() {

			autIrProximaPagina();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FluxosDeSaida.Finalizar").click();		
		}

		/**
		 * @param usarDataMaisProxima the usarDataMaisProxima to set
		 */
		public void setUsarDataMaisProxima(USAR_DATA_MAIS_PROXIMA usarDataMaisProxima,Integer rowIndex) {
			switch(usarDataMaisProxima) {
			case NAO:{
				if(rowIndex > 0) {
					//AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-%s-retire']",(rowIndex > 0 ? --rowIndex : 0))).uncheck();
				}
				break;
			}
			case SIM:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					if(rowIndex > 0) {
						AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-%s-delivery']",(rowIndex > 0 ? --rowIndex : 0))).check();	
					}		
					break;
				}
				default:{
					if(rowIndex > 0) {
						AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-%s-retire']",(rowIndex > 0 ? --rowIndex : 0))).check();					
					}									
					break;
				}
				}
			}
			}
			this.usarDataMaisProxima = usarDataMaisProxima;
		}



		/**
		 * @param usarDataMaisProxima the usarDataMaisProxima to set
		 */
		public void setUsarDataMaisProximaPorIndexLinha(USAR_DATA_MAIS_PROXIMA usarDataMaisProxima,Integer rowIndex) {
			switch(usarDataMaisProxima) {
			case NAO:{
				AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-*-delivery'][%s]",rowIndex)).uncheck();
				break;
			}
			case SIM:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					try {

						//AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-*-delivery'][%s]",rowIndex)).check();
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.//BrowserWindow//INPUT[@id='delivery-option-date-%s']",rowIndex)).scrollIntoView();
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.//BrowserWindow//INPUT[@id='delivery-option-date-%s']",rowIndex)).click();												
						AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DIV[@class='dayContainer']//SPAN[@class='flatpickr-day'][1]").click();						
					}
					catch(java.lang.Exception e) {

					}
					break;
				}
				}
			}
			}
			this.usarDataMaisProxima = usarDataMaisProxima;
		}

		/**
		 * @param usarDataMaisProxima the usarDataMaisProxima to set
		 */
		public void setUsarDataMaisProximaPorIndexLinha(USAR_DATA_MAIS_PROXIMA usarDataMaisProxima,Integer rowIndex,Integer indexDataPosterior) {
			switch(usarDataMaisProxima) {
			case NAO:{
				AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-*-delivery'][%s]",rowIndex)).uncheck();
				break;
			}
			case SIM:{
				switch(getTipoFluxoSaida()) {
				case ENTREGA:{
					try {

						//AUT_AGENT_SILK4J.<DomCheckBox>find(String.format("VA.TL011FluxosDeSaida.//DomCheckBox[@id='nearDate-*-delivery'][%s]",rowIndex)).check();
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.//BrowserWindow//INPUT[@id='delivery-option-date-%s']",rowIndex)).scrollIntoView();
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.//BrowserWindow//INPUT[@id='delivery-option-date-%s']",rowIndex)).click();												
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.//BrowserWindow//DIV[@class='dayContainer']//SPAN[@class='flatpickr-day'][%s]",indexDataPosterior)).click();						
					}
					catch(java.lang.Exception e) {

					}
					break;
				}
				}
			}
			}
			this.usarDataMaisProxima = usarDataMaisProxima;
		}

		/**
		 * @return the enderecoCadastrado
		 */
		public String getEnderecoCadastrado() {
			return enderecoCadastrado;
		}


		/**
		 * @param enderecoCadastrado the enderecoCadastrado to set
		 */
		public void setEnderecoCadastrado(String enderecoCadastrado) {
			this.enderecoCadastrado = enderecoCadastrado;
		}


		/**
		 * @return the opcoesFrete
		 */
		public String getOpcoesFrete() {
			return opcoesFrete;
		}


		/**
		 * @param opcoesFrete the opcoesFrete to set
		 */
		public void setOpcoesFrete(String opcoesFrete) {
			this.opcoesFrete = opcoesFrete;
		}


		/**
		 * @return the inforcoesAdicionaisFrete
		 */
		public OPCIONAIS_ADICIONAIS_FRETE getInforcoesAdicionaisFrete() {
			return inforcoesAdicionaisFrete;
		}


		/**
		 * @param inforcoesAdicionaisFrete the inforcoesAdicionaisFrete to set
		 */
		public void setInforcoesAdicionaisFrete(OPCIONAIS_ADICIONAIS_FRETE inforcoesAdicionaisFrete) {
			this.inforcoesAdicionaisFrete = inforcoesAdicionaisFrete;
		}


		/**
		 * @return the tipoCalcFrete
		 */
		public TIPO_FRETE getTipoCalcFrete() {
			return tipoCalcFrete;
		}


		/**
		 * @param tipoCalcFrete the tipoCalcFrete to set
		 */
		public void setTipoCalcFrete(TIPO_FRETE tipoCalcFrete) {
			this.tipoCalcFrete = tipoCalcFrete;
		}


		/**
		 * @return the indexFluxo
		 */
		public Integer getIndexFluxo() {
			return indexFluxo;
		}


		/**
		 * @param indexFluxo the indexFluxo to set
		 */
		public void setIndexFluxo(Integer indexFluxo) {
			this.indexFluxo = indexFluxo;
		}


		/**
		 * @return the material
		 */
		public Integer getMaterial() {
			return material;
		}


		/**
		 * @param material the material to set
		 */
		public void setMaterial(Integer material) {
			this.material = material;
		}


		/**
		 * 
		 * Tipo de atribuição de valores
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum TIPO_ATRIBUICAO_VALORES{
			DEFINIDO_PELO_USUARIO,
			VALORES_ALEATORIO
		}

		/**
		 * Tipo de cálculo do frete
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum TIPO_FRETE{
			NORMAL
		}

		/**
		 * Informações adicionais do frete
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum OPCIONAIS_ADICIONAIS_FRETE{

		}

		/**
		 * Define se a entrega do item será por encomenda
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum ENCOMENDA{
			SIM,
			NAO
		}

		public static enum AGRUPAR_DATAS{
			SIM,
			NAO
		}

		public static enum USAR_DATA_MAIS_PROXIMA{
			SIM,
			NAO
		}

		/**
		 * Define os tipos de fluxos de saída
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum FLUXO_SAIDA_TIPOS{
			CAIXA,							//Configura simultaneamente todos os itens do carrinho de compras para o tipo - CAIXA
			RETIRA,							//Configura simultaneamente todos os itens do carrinho de compras para o tipo - RETIRA
			ENTREGA							//Configura simultaneamente todos os itens do carrinho de compras para o tipo - CAIXA
		}

		public static enum TIPOS_ENTREGA{
			NORMAL,
			EXPRESSO,
			PLAT_SJCAMPOS;

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				switch(this) {
				case EXPRESSO:{
					return "EXPRESSO";
				}
				case NORMAL:{
					return "NORMAL";
				}
				case PLAT_SJCAMPOS:{
					return "PLAT SJCAMPOS";
				}
				}
				return super.toString();
			}
		}
		/**
		 * 
		 * Tipos de retira loja
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum TIPOS_RETIRA{
			RETIRA_EXTERNA_AGENDADA,
			RETIRA_EXTERNA_IMEDIATA,
			RETIRA_INTERNA_AGENDADA,
			RETIRA_INTERNA_IMEDIATA,
			RETIRA_POR_INDEX_LINHA,
			RETIRA_POR_MATERIAL;
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				switch(this) {				
				case RETIRA_EXTERNA_AGENDADA: {
					return "(?i:Retira externa agendada)";
				}
				case RETIRA_EXTERNA_IMEDIATA: {
					return "Retira externa imediata";
				}
				case RETIRA_INTERNA_AGENDADA: {
					return "Retira interna agendada";
				}
				case RETIRA_INTERNA_IMEDIATA: {
					return "Retira interna imediata";
				}
				case RETIRA_POR_INDEX_LINHA:{
					return "";
				}
				}
				return super.toString();

			}
		}


		/**
		 * 
		 * Define as opções de filiais
		 * 
		 * @author Softtek-QA
		 *
		 */
		public static enum FILIAIS{
			LOJA,
			CENTRAL_DISTRIBUICAO,
			LJ0019,
			LJ0045,
			LJ0014,
			CD0519,
			CD_OU_LOJA_POR_INDEX;
			@Override
			public String toString() {
				switch(this) {
				case LJ0014:{
					return "14";
				}
				case CD0519:{
					return "519";
				}
				case LJ0019:{
					return "19";
				}
				case LJ0045:{
					return "45";
				}
				default:{
					return this.name();
				}
				}
			}
		}
	}

	/**
	 * 
	 * Tipos de depósito
	 * 
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static enum DEPOSITOS{
		C010,
		C050,
		C060,
		C080,		
		DEPOSITO_POR_INDEX;

		@Override
		public String toString() {
			switch(this) {
			case C010:{
				return "(?i:C010)";
			}
			case C050:{
				return "(?i:C050)";
			}
			case C080:{
				return "(?i:C080)";
			}
			case C060:{
				return "(?i:C060)";
			}
			default:{
				this.name();
			}
			}
			return this.name();
		}
	}


	public AUTVABaseComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void autStartLoginDefaultVA() {
		try {			
			autGetLogManager().logMensagem("AUT VA: LOGIN VA APPLICATION: INIT");
			autInitWebApplicationVA();
			autLoginVA();
			autGetLogManager().logMensagem("AUT VA: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	

	public void autStartLoginDefault() {
		try {	

			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: INIT");
			//autInitWebApplication();			
			autLogin();
			autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION: END");
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//autGetLogManager().logMensagem("AUT ERROR: LOGIN VA APPLICATION");	
		}
	}	



	public boolean autLoginVA(Desktop agent, String user, String password) {
		try {

			autGetLogManager().logMensagem("AUT INFO: INICIANDO LOGIN : APLICACAO VA");
			autInsertScreenByScenario();
			agent.<DomTextField>find("VA.Login.Usuario").click();
			agent.<DomTextField>find("VA.Login.Usuario").setText(user);
			agent.<DomTextField>find("VA.Login.Senha").click();
			agent.<DomTextField>find("VA.Login.Senha").setText(password);
			agent.<DomButton>find("VA.Login.Avancar").click();
			autInsertScreenByScenario();
			autGetLogManager().logMensagem("AUT INFO: LOGIN REALIZADO COM SUCESSO");
			return true;
		} catch (java.lang.Exception e) {

			autGetLogManager().logMensagem(AUT_TIPO_MSG_LOG.MENSAGEM_INFORMATIVA,
					"AUT ERROR: LOGIN : APLICACAO VA");

			System.out.println(e.getMessage());
			e.printStackTrace();

			return false;
		}
	}
	/**
	 * 
	 * Realiza login na aplicaÃ§Ã£o - VA
	 *
	 */

	public void autLogin() {
		String usuarioHMC = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_HMC_LOGIN,"AUT_USER_ID").toString();
		String senhaHMC = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_HMC_LOGIN,"AUT_NOVA_SENHA").toString();
		String usuarioVA = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_USER").toString();
		String senhaVA = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_PASSWORD").toString();

		AUT_USUARIO_LOGIN_DEFAULT = (usuarioHMC==null ? usuarioVA : usuarioHMC);
		AUT_SENHA_LOGIN_DEFAULT = (senhaHMC==null ? senhaVA : senhaHMC);

		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
	}

	public void autLoginVA() {
		String usuarioHMC = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_HMC_LOGIN,"AUT_USER_ID").toString();
		String senhaHMC = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_HMC_LOGIN,"AUT_NOVA_SENHA").toString();
		String usuarioVA = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_USER").toString();
		String senhaVA = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_PASSWORD").toString();

		AUT_USUARIO_LOGIN_DEFAULT = (usuarioHMC==null ? usuarioVA : usuarioHMC);
		AUT_SENHA_LOGIN_DEFAULT = (senhaHMC==null ? senhaVA : senhaHMC);
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);	
	}

	public void autLogin(String usuario, String senha) {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, usuario.toString(), senha.toString());
	}


	public void autLogoutApplication() {
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
			AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
		}
		catch(java.lang.Exception e) {

		}
		/*try {
			java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im chrom*");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		//Utils.asList(5*1000);
	}

	public void autLoginVA(String usuario,String senha) {

		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_USER", usuario);
		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_PASSWORD", senha);


		AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
		AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		autInsertScreenByScenario();
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
		autInsertScreenByScenario();
	}


	public void autVALogOff() {
		AUT_AGENT_SILK4J.<DomElement>find("VA.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
	}

	public void autVALogOff(boolean closeBrowser) {
		if(closeBrowser) {
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//A[@class='dropdown-link' and @title='Sair']").click();
			AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Fechar").click();
		}
		else {
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//A[@class='dropdown-link' and @title='Sair']").click();
		}
	}


	/**
	 * 
	 * CAT001
	 * CMP00001 - Realizar login no VA
	 * @param parametro - Parametros de entreat do sistema
	 * @return
	 */
	public void CMP00001(java.util.HashMap<String, Object> parametros) {
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}

		autInitConfigurationTelevendas();	
		autVALogin.autStartLoginVA(parametros);
	}


	public void autInitConfigurationTelevendas() {
		autInsertScreenByScenario();
		autVALogin = new AUTVALogin();
		autBuscaCliente = new AUTBuscarCliente();
		autLoginBoitata = new AUTLoginBoitata();
		autVAConfirmacaoLogin = new AUTConfirmacaoLogin();
		autRecuperacao = new AUTRecuperacao();
		autItem = new AUTItem();
		autConversao = new AUTConversao();
		autFluxoSaida = new AUTFluxoSaida();
		autMeiosPagamento = new AUTMeiosPagamento();
		autSelecaoLojaVA = new AUTSelecaoLojaVA();
		autSelecaoLojaBoitata = new AUTSelecaoLojaBoitata();
		autLogOffVA = new AUTLogOffVA(); 
		autLogFinalizarPedidoVA  = new AUTFinalizarPedidoVA();
		autLogOffBoitata = new AUTLogOffBoitata();
		autCadastroCliente = new AUTCadastroCliente();
		autMenuLiberacao = new AUTMenuLiberacaoPendente();
		autDesconto = new AUTDesconto();
		servicoGarantia = new AUTServicoGarantia();
		autInsertScreenByScenario();
	}

	/**
	 * 
	 * CAT001
	 * CMP00002 - Realizar login no Boitata
	 * @param parametro - Parametros de entreat do sistema
	 * @return
	 */
	public void CMP00002(java.util.HashMap<String, Object> parametros) {
		try {
			autLogoutApplication();
		}
		catch(java.lang.Exception e) {

		}

		autInitConfigurationTelevendas();	
		autInsertScreenByScenario();
		autLoginBoitata.autStartLoginBoitata(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00003 - Recuperar Carrinho de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00007(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autRecuperacao.autRecuperarCarrinho(parametros);
		autInsertScreenByScenario();

	}


	/**
	 * 
	 * CMP00001 - Recuperar Pedido de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00005(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		System.out.println("Parametros no CMP"+parametros);
		autRecuperacao.autRecuperarPedido(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - Recuperar OrÃ§amento
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00062(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		System.out.println("Parametros no CMP"+parametros);
		autRecuperacao.autRecuperarOrcamento(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00003 - Cadastro de PJ
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00067(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		cadastroPJ.autCadastrarPJ(parametros);
		autInsertScreenByScenario();
	}

	public void CMP00068(HashMap<String, Object> parametros) {
		autEcommerce.autEcommercePedido(parametros);
	}

	public void CMP00069(HashMap<String, Object> parametros) {
		autEcommerce.autEcommerceClicaRetira(parametros);

	}

	/**
	 * 
	 * CMP00001 - Inserção de vários itens no carrinho
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */

	public <TOutput extends AUTInsercaoItens> TOutput CMP00070(HashMap<String, Object> parametros) {		
		autInsertScreenByScenario();
		return (TOutput) autInsercaoItens;
	}

	/**
	 * 
	 * CMP00001 - Copia de pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */

	public void CMP00071(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		edicao.autCopiaPedido(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00003 - Cadastro de Estrangeiro no meio do fluxo de pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00072(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		cadastroEstrangeiro.autCadastrarEstrangeiro(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - Fluxo de Saída para vários itens
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */

	public void CMP00080(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autfluxoSaidaItens.autVAFluxoSaidaItens(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - Inserir item no carrinho de compra pelo Boitata
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00009(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autItem.autBoitataIncluirItemCarrinho(parametros);
		autInsertScreenByScenario();
	}


	public void CMP00009_1(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autItem.autVAIncluirItemNoCarrinho(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00003 - Inserir item no carrinho de compra pelo VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00011(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autItem.autVAIncluirItemNoCarrinho(parametros);
		autInsertScreenByScenario();
	}

	/**
	 * 
	 * CMP00004 - Criar carrinho
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00008(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autRecuperacao.autCriarCarrinho();
		autInsertScreenByScenario();
	}



	/**
	 * 
	 * CMP00001 - Converter em Pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00012(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autConversao.autVAConvercaoParaPedido();
		autInsertScreenByScenario();
	}



	/**
	 * 
	 * CMP00001 - Converter em Orcamento
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00061(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autConversao.autVAConvercaoParaPedido();
		autInsertScreenByScenario();
	}





	/**
	 * 
	 * CMP00001 - Busca de Cliente
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00014(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autBuscaCliente.autBuscarCliente(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00002 - Cadastro de cliente a partir da busca de clientes
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00015(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autCadastroCliente.autCadastrarCliente(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - Fluxo de Saida
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00016(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autFluxoSaida.autSelecaoFluxoSaida(parametros);
		autInsertScreenByScenario();
	}




	/**
	 * 
	 * CMP00002 - CartÃ£o de Credito
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00039(HashMap<String, Object> parametros) {

		autInsertScreenByScenario();

	}



	/**
	 * 
	 * CMP00001 - Pagamento - VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public <TOutput extends AUTMeiosPagamento> TOutput CMP00020(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		return (TOutput) autMeiosPagamento;
	}


	/**
	 * 
	 * CMP00001 - Realizar logOff VA
	 * @return
	 */	
	public void CMP00022() {
		autLogOffVA.autRealizarLogOff();
	}


	/**
	 * 
	 * CMP00001 - Realizar logOff Boitata
	 * @return
	 */	
	public void CMP00023() {
		autInsertScreenByScenario();
		autLogOffBoitata.autRealizarLogOff();
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00003 - Busca de pedido para AprovaÃ§Ã£o Antifraude ou Desconto
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00027(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();


	}


	/**
	 * 
	 * CMP00001 - Finalizar compra no sistema BoitatÃ¡
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public <TOutput extends AUTFinalizarPedidoVA> TOutput CMP00034(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autLogFinalizarPedidoVA.autFinalizarPedidoVA(parametros);
		autInsertScreenByScenario();
		return (TOutput) autLogFinalizarPedidoVA;
	}



	/**
	 * 
	 * CMP00001 - SeleÃ§Ã£o de loja Televendas VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00036(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autSelecaoLojaVA.autSelecaoDeLoja(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - SeleÃ§Ã£o de loja Televendas Boitata
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00037(HashMap<String, Object> parametros) {
		autSelecaoLojaBoitata.autSelecaoDeLoja(parametros);
	}


	/**
	 * 
	 * CMP00004 - ConfirmaÃ§Ã£o de Login
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00004(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autVAConfirmacaoLogin.autConfirmacaoLogin(parametros);
		autInsertScreenByScenario();
	}


	public void CMP00014_CPF(HashMap<String, Object> parametros){
		autBuscaCliente.autBuscarClienteCPF(parametros);
	}


	/**
	 * 
	 * CMP00003 - Flag Ignorar Antifraude
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00030(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
	}

	/**
	 * 
	 * CMP00001 - reprovação antifraude
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00043(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autMenuLiberacao.autMonitorAntiFraudeReprovacao(parametros);
		autInsertScreenByScenario();
	}

	public void CMP00043_3(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autMenuLiberacao.autMonitorAntiFraudeEnviandoProAntiFraude(parametros);
		autInsertScreenByScenario();
	}


	public void CMP00044(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autMenuLiberacao.autMonitorAumentandoDescontoAprovando(parametros);
		autInsertScreenByScenario();
	}


	public void CMP00045(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autMenuLiberacao.autMonitorAprovandoECancelando(parametros);
		autInsertScreenByScenario();
	}



	/**
	 * 
	 * CMP00002 - aprovaÃ§Ã£o comercial
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00040(HashMap<String, Object> parametros) {
		autInsertScreenByScenario();
		autMenuLiberacao.monitorAprovacaoComercialAprovar(parametros);
		autInsertScreenByScenario();
	}


	/**
	 * 
	 * CMP00001 - Desconto no pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */

	public <TOutput extends AUTDesconto> TOutput CMP00024(HashMap<String, Object> parametros) {		autInsertScreenByScenario();
		return (TOutput) autDesconto;
	}


	public void CMP00017() {
		servicoGarantia.autServicoGarantia();
	}

	public void CMP00019(HashMap<String, Object> parametros) {
		servicoGarantia.agendarServico(parametros);
	}

	public void CMP00018(HashMap<String, Object> parametros) {
		servicoGarantia.adicionarGarantia(parametros);
	}

	/**
	 * 
	 * Altera a loja padrão
	 * 
	 */
	public void CMP11024(java.util.HashMap<String,Object> parameters) {		
		AUT_BOITATA_LOJAS loja = AUT_BOITATA_LOJAS.valueOf(parameters.get("AUT_LOJA_TELEVENDAS").toString());		
		AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='leroy-region']").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='leroy-region']").scrollIntoView();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.//BrowserWindow//DomListBox[@id='leroy-region']").select(loja.toString());
	}

	/**
	 * 
	 * Componente para gerenciamento das formas de pagamento
	 * 
	 * @param parameters - Parametros de configuração do projeto
	 * 
	 * @return br.lry.components.AUTVABaseComponent.AUTVAFormasPagamento - Componente
	 */
	public <TFormasPagamento extends  br.lry.components.AUTVABaseComponent.AUTVAFormasPagamento> TFormasPagamento CMP11025(java.util.HashMap<String,Object> parameters) {
		try {
			System.out.println("AUT INFO : CARREGANDO COMPONENTE DE GERENCIAMENTO : FORMAS DE PAGAMENTO");
			if(autFormasPagamentoGerenciador==null) {
				autFormasPagamentoGerenciador = new AUTVAFormasPagamento();
				return (TFormasPagamento) autFormasPagamentoGerenciador;
			}
			else {
				return (TFormasPagamento) autFormasPagamentoGerenciador;				
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERROR: CARREGANDO COMPONENTE PARA GERENCIAMENTO DE FORMAS DE PAGAMENTO");
			System.out.println(e.getMessage());
			return null;
		}
	}


	/**
	 * 
	 * Executa procedimentos para pagamento com uma forma de pagamento do tipo cartão
	 * 
	 * 
	 * @param parameters - Parametros de configuração do componente
	 */
	public void CMP11026(java.util.HashMap<String,Object> parameters) {
		CMP11025(parameters);
	}

	/**
	 * 
	 * Edita o número do lote do material
	 * 
	 * 
	 * @param parameters - Parametros de configuração do componente
	 */
	public void CMP11027(java.util.HashMap<String,Object> parameters) {	
		CMP11012(parameters);
		String locItem1 = "//DomButton[@textContents='*Lote:*']";
		String locItem2 = "//DomButton[@textContents='Definir lote especifico']";
		//VA.//BrowserWindow//LI[@data-code='89627601']//DomButton[@textContents='*Lote*']
		
		String locFull1 = String.format("VA.//BrowserWindow//LI[@data-code='*%s*']%s",parameters.get("INDEX_MATERIAL_POSSUI_LOTE"),locItem1);		
		String locFull2 = String.format("VA.//BrowserWindow//DIV[@textContents='LM: %s*']",parameters.get("INDEX_MATERIAL_POSSUI_LOTE")).concat(locItem2);
		
		System.out.println(locItem1);
		System.out.println(locItem2);
		System.out.println(locFull1);
		System.out.println(locFull2);
		
		boolean exitsLoteSelect = AUT_AGENT_SILK4J.exists(locFull1, 2 * 1000);	
		boolean exitsLote = AUT_AGENT_SILK4J.exists(locFull2,2 * 1000);
		
		
		if(exitsLoteSelect) {
			AUT_AGENT_SILK4J.<DomElement>find(locFull1).click();			
		}
		else if(exitsLote) {
			AUT_AGENT_SILK4J.<DomElement>find(locFull2).click();						
		}
		
		
		
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomElement[@id='batch-consult']").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomElement[@id='batch-consult']").scrollIntoView();
		AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomElement[@id='batch-consult']").typeKeys(parameters.get("AUT_NUMERO_LOTE_ALTERACAO").toString());		
		AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomElement[@id='batch-consult']").typeKeys("\n");
		//AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//FORM[@data-component='form cart/item/batch-consult validation']//DomButton[@type='submit']").click();		

		Boolean existRowSelect = AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//LI[@class='list-item color-prim*']").exists("/DIV[@class='row']", 3 * 1000);


		if(!exitsLoteSelect) {
			AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//LI[@class='list-item color-prim*']/DIV[@class='row']").click();	
		}
		else {
			AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomButton[@textContents='Confirmar troca de Lote']").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomButton[@id='btModificationOrder']").click();				
		}		
	}




	/**
	 * public 
	 * 
	 * @param parametros
	 */
	public boolean CMP11001(java.util.HashMap<String,Object> parametros) {
		try {			
			if(parametros.get("AUT_INIT_APP").equals(true)) {

				Boolean startApp = (Integer.parseInt(parametros.get("AUT_INIT_APP").toString()) == 0 ? false : true);

				if(startApp) {
					try {						
						java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im chrome*");
						com.borland.silktest.jtf.Utils.sleep(5 * 1000);
						autInitWebApplicationBoitata();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
				else {					
					System.out.println("AUT INFO: INICIALIZACAO DO BROWSER NAO É NECESSÁRIA");
				}
			}
			else {
				try {						
					java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im chrome*");
					com.borland.silktest.jtf.Utils.sleep(5 * 1000);
					autInitWebApplicationBoitata();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(parametros.containsKey("AUT_TIPO_ACESSO_LOGIN")) {
				AUT_TIPO_ACESSO_LOGIN tipoAcesso = AUT_TIPO_ACESSO_LOGIN.valueOf(parametros.get("AUT_TIPO_ACESSO_LOGIN").toString());			
				switch(tipoAcesso) {
				case USUARIO_GERENTE_APROVADOR:{
					autLogin(parametros.get("AUT_USER_GERENTE").toString(), parametros.get("AUT_PASSWORD_GERENTE").toString());
					AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 120 * 1000);									
					break;
				}
				case USUARIO_LOJA:{
					autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
					AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 120 * 1000);														
					break;
				}
				case USUARIO_TELEVENDAS:{
					autLogin(parametros.get("AUT_USER_TELEVENDAS").toString(), parametros.get("AUT_PASSWORD_TELEVENDAS").toString());
					AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 120 * 1000);																			
					CMP11024(parametros);					
					break;
				}
				}
			}
			else {
				autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
				AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 120 * 1000);				
			}			
			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			autInitWebApplicationVA();
			autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());

			return false;
		}
	}

	public boolean CMP11001_V2(java.util.HashMap<String,Object> parametros) {
		try {

			try {
				java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im chrome*");
				com.borland.silktest.jtf.Utils.sleep(5 * 1000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(parametros.containsKey("AUT_INIT_APP_EXECUTE")) {
				boolean initApp = (Boolean)parametros.containsKey("AUT_INIT_APP_EXECUTE");
				if(initApp) {
					autInitWebApplicationBoitata();
					autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
					AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 60 * 1000);
				}
				else {
					autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
					AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 60 * 1000);
				}
			}
			else {
				autInitWebApplicationBoitata();
				autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());
				AUT_AGENT_SILK4J.<BrowserApplication>find("VA").exists("TL011BoitataTelaPedidosInicial.CampoPesquisa", 60 * 1000);
			}

			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			autInitWebApplicationVA();
			autLogin(parametros.get("AUT_USER").toString(), parametros.get("AUT_PASSWORD").toString());

			return false;
		}
	}
	/**
	 * 
	 * Inclui um item padrão no carrinho de compras pelo fluxo do boitatá
	 * 
	 * @param parameters - Hash com os parametros de configuração do fluxo de negócio
	 * 
	 */
	public boolean CMP11002(java.util.HashMap<String,Object> parameters) {
		try {
			String quantDefault = parameters.get("AUT_MATERIAL_QUANTIDADE").toString();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.CampoPesquisa").waitForProperty("Visible", true,60 * 1000);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.CampoPesquisa").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.CampoPesquisa").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.CampoPesquisa").typeKeys(parameters.get("AUT_MATERIAL").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011BoitataTelaPedidosInicial.BotaoPesquisar").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.QuantidadeItem").setText(quantDefault);		
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011BoitataTelaPedidosInicial.CampoPesquisa").waitForProperty("Visible", true,60 * 1000);

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011BoitataTelaPedidosInicial.AdicionarItemCarrinho").click();
			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}



	/**
	 * Executa procedimentos de exclusão dos itens do carrinho de compras
	 * 
	 * @param parameters
	 * @return boolean - True caso o processo seja finalizado com sucesso false caso contrário
	 */
	public boolean CMP11003(java.util.HashMap<String,Object> parameters) {
		try {
			AUT_CONFIRMACAO_USUARIO opInitCarrinho = AUT_CONFIRMACAO_USUARIO.valueOf(parameters.get("AUT_REMOVER_ITENS_CARRINHO").toString());
			AUT_CONFIRMACAO_USUARIO opExclusaoItens = AUT_CONFIRMACAO_USUARIO.valueOf(parameters.get("AUT_TIPO_EXCLUSAO_ITEM").toString());
			Integer indexItemExclusaoIndividual = Integer.parseInt(parameters.get("AUT_PARAMETRO_EXCLUSAO_ITENS").toString());
			String[] indexMultiplosItens = parameters.get("AUT_PARAMETRO_EXCLUSAO_ITENS").toString().split("\\d+");
			System.out.println("AUT INFO : INICIANDO EXCLUSAO DE ITENS DO CARRINHO DE COMPRA");

			if(opInitCarrinho.equals(AUT_CONFIRMACAO_USUARIO.CONFIRMAR) || opInitCarrinho.equals(AUT_CONFIRMACAO_USUARIO.SIM)) {
				boolean existItem = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("BotaoExcluir",5 * 1000);
				while(existItem) {
					switch(opExclusaoItens) {
					case EXCLUIR_ITEM_POR_LM:{
						String lm = indexItemExclusaoIndividual.toString();
						String locItem = String.format("VA.//BrowserWindow//DomElement[@data-code='%s']//BUTTON[@data-trigger='item-removal']",lm);
						AUT_AGENT_SILK4J.<DomButton>find(locItem).click();
						
						AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();
						
					}
					case EXCLUIR_ITEM_POR_ATRIB_MATERIAL:{
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.TL011VACarrinhoCompra.//I[@class='glyph glyph-trash-ca*'][%s]",parameters.get("AUT_INDEX_EXCLUSAO").toString())).click();
						AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();						
						break;
					}
					case EXCLUIR_ITEM_INDIVIDUAL:{
						AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.TL011VACarrinhoCompra.//I[@class='glyph glyph-trash-ca*'][%s]",indexItemExclusaoIndividual)).click();
						AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();
						break;
					}
					case EXCLUIR_ITEM_MULTIPLOS_ITENS:{
						for(String index : indexMultiplosItens) {
							AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.TL011VACarrinhoCompra.//I[@class='glyph glyph-trash-ca*'][%s]",index)).click();
							AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
							AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
							AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();
						}
						break;
					}
					case EXCLUSAO_GERAL_LIMPAR_CARRINHO:{
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.BotaoExcluir").click();
						AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
						AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();						
						break;
					}
					case EXCLUSAO_ITEM_DESABILITADA:{						
						break;
					}
					}
					autScrollPage();
					com.borland.silktest.jtf.Utils.sleep(3*1000);

					existItem = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("BotaoExcluir",5 * 1000);		
				}
			}

			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERROR: EXCLUSAO DE ITENS DO CARRINHO DE COMPRA");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * 
	 * Criar carrinho de compra
	 * 
	 * @param parameters - Parametros de configuração do fluxo de dados
	 * 
	 * @return boolean - True caso o processo seja finalizado com sucesso, false caso contrário
	 * 
	 */
	public java.util.List<AUTStoreItem> CMP11004(java.util.HashMap<String,Object> parameters) {
		try {
			java.util.List<AUTStoreItem> ltOutItems = new java.util.ArrayList<AUTStoreItem>();
			br.lry.components.AUTBaseComponent.AUTStoreItem item = new br.lry.components.AUTBaseComponent.AUTStoreItem();
			AUT_SELECT_PRODUCT_OPTIONS_BY_STORE opSelect = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.valueOf(parameters.get("AUT_OPCAO_SELECAO_ITEM").toString());

			String parametroConfiguracao = parameters.get("AUT_OPCAO_SELECAO_PARAMETRO").toString();
			Integer quantMaxItens = Integer.parseInt(parameters.get("AUT_QUANTIDADE_MAXIMA_ITENS").toString());

			quantMaxItens = (quantMaxItens > 0 && quantMaxItens != 0 ? quantMaxItens : -1);
			Integer contItens = 1;
			if(!opSelect.equals(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.INCLUSAO_PARCIAL_ITENS_CARRINHO_CRIADO)) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011TelaInicialVA.CriarCarrinho").waitForProperty("Visible", true,30*1000);
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011TelaInicialVA.CriarCarrinho").click();													
				CMP11003(parameters);
			}

			switch(opSelect) {
			case CONDITION_BY_STORE:{
				while(item.autGetNextItemStore(opSelect,(parametroConfiguracao != null ? parametroConfiguracao : "%")) != null) {				
					if(quantMaxItens > 0 && contItens <= quantMaxItens) {	
						ltOutItems.add(item.autCopyItemStore(item));
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setText("");
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setFocus();
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").typeKeys(parameters.get("AUT_MATERIAL_QUANTIDADE").toString());
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setText("");
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setFocus();
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys(item.getLmMaterial().toString());
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys("\n");

						autScrollPage();
					}
					else if(quantMaxItens==-1){
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setText("");
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setFocus();
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").typeKeys(item.getQuantidadePadrao().toString());
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setText("");
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setFocus();
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys(item.getLmMaterial().toString());
						AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys("\n");
						autScrollPage();					
					}
					contItens++;
				}
				//FIM DO SWITCH CASE
				break;
			}
			case CONDITION_BY_ID:{
				AUTFunctionProcess func = null;
				if(parameters.containsKey("AUT_FUNCTION_BY_ITEM_PROCESS")) {
					if(!parameters.get("AUT_FUNCTION_BY_ITEM_PROCESS").equals(null)) {
						func = (AUTFunctionProcess)parameters.get("AUT_FUNCTION_BY_ITEM_PROCESS");
					}
				}
				
				//CARREGA OS ITENS DO CATÁLOGO DE PRODUTOS PELO CRITÉRIO DE FILTRO ESPECÍFICO
				for(AUTStoreItem itemCorrente:CMP11004_V2(parameters)) {		
					if(func!=null) {
						func.autProcessByItem(parameters);
					}
					ltOutItems.add(itemCorrente.autCopyItemStore(itemCorrente));
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setText("");
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setFocus();
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").typeKeys(parameters.get("AUT_MATERIAL_QUANTIDADE").toString());
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setText("");
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setFocus();
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys(itemCorrente.getLmMaterial().toString());
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys("\n");
					autScrollPage();
					contItens++;
				}
				break;
			}
			case INCLUSAO_PARCIAL_ITENS_CARRINHO_CRIADO:{
				//CARREGA OS ITENS DO CATÁLOGO DE PRODUTOS PELO CRITÉRIO DE FILTRO ESPECÍFICO
				parameters.remove("AUT_OPCAO_SELECAO_ITEM");
				parameters.put("AUT_OPCAO_SELECAO_ITEM", AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.CONDITION_BY_ID.name());				

				for(AUTStoreItem itemCorrente:CMP11004_V2(parameters)) {		

					ltOutItems.add(itemCorrente.autCopyItemStore(itemCorrente));

					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setText("");
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setFocus();
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").typeKeys(parameters.get("AUT_MATERIAL_QUANTIDADE").toString());
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setText("");
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setFocus();
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys(itemCorrente.getLmMaterial().toString());
					AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys("\n");

					autScrollPage();

					contItens++;
				}							
				break;
			}			
			}
			return ltOutItems;
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * Inseri itens no carrinho de compras já aberto, a partir da tela de carrinho
	 * 
	 * @param parameters - Parametros de configuração do fluxo de dados
	 * @return boolean - True caso o processo seja finalizado com sucesso, false caso contrário
	 * 
	 */
	public java.util.List<AUTStoreItem> CMP11004_V2(java.util.HashMap<String,Object> parameters) {
		try {

			java.util.List<AUTStoreItem> ltOutItems = new java.util.ArrayList<AUTStoreItem>();
			br.lry.components.AUTBaseComponent.AUTStoreItem item = new br.lry.components.AUTBaseComponent.AUTStoreItem();
			AUT_SELECT_PRODUCT_OPTIONS_BY_STORE opSelect = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.valueOf(parameters.get("AUT_OPCAO_SELECAO_ITEM").toString());
			String parametroConfiguracao = parameters.get("AUT_OPCAO_SELECAO_PARAMETRO").toString();
			while(item.autGetNextItemStore(opSelect,(parametroConfiguracao != null ? parametroConfiguracao : "%")) != null) {								
				ltOutItems.add(item.autCopyItemStore(item));
			}
			System.out.println(ltOutItems.size());
			return ltOutItems;
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}


	public void CMP11012(java.util.HashMap<String,Object> parameters) {
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Usuario").waitForProperty("Visible", true,5*1000);
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Usuario").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Usuario").setText("");
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Usuario").setText(parameters.get("AUT_USUARIO_VA").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Senha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Senha").setText("");
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.Senha").setText(parameters.get("AUT_SENHA_VA").toString());			
		AUT_AGENT_SILK4J.<DomButton>find("VA.TL011VACarrinhoCompra.Avançar").click();
	}

	public void CMP11013(java.util.HashMap<String,Object> parameters) {
		if(parameters.containsKey("AUT_INIT_APP_EXECUTE")) {
			parameters.remove("AUT_INIT_APP_EXECUTE");
			parameters.put("AUT_INIT_APP_EXECUTE", false);			
		}
		else {
			parameters.put("AUT_INIT_APP_EXECUTE", false);						
		}
		autVALogOff(false);
		//CMP11001_V2(parameters);
	}

	/**
	 * Retorna o componente para teste integrado com PDV
	 * 
	 * @param parameters - Parametros de configuração do fluxo de pagamento
	 * 
	 * @return br.lry.components.pdv.AUTPDVBaseServices - Componente para teste integrado do PDV
	 */
	public <TPDVComponent extends br.lry.components.pdv.AUTPDVBaseServices> TPDVComponent CMP11014(java.util.HashMap<String,Object> parameters) {
		if(pdv==null) {
			pdv = new br.lry.components.pdv.AUTPDVBaseServices();
			return (TPDVComponent) pdv;
		}
		else {
			return (TPDVComponent) pdv;
		}
	}

	/**
	 * Componente para teste integrado de SAP
	 * 
	 * @param parameters - Parametros de configuração dos fluxos de SAP
	 * @return br.lry.components.sap.AUTSAPBaseServices - Componente SAP
	 */
	public <TSAPComponent extends br.lry.components.sap.AUTSAPBaseServices> TSAPComponent CMP11016(java.util.HashMap<String,Object> parameters) {
		if(sap==null) {
			sap = new br.lry.components.sap.AUTSAPBaseServices();
			return (TSAPComponent) sap;
		}
		else {
			return (TSAPComponent) sap;
		}
	}

	
	/**
	 * 
	 * Executa procedimentos de faturamento parcial no SAP
	 * 
	 * @param parameters - Parametros de configuração do SAP
	 * 
	 */
	public void CMP11017(java.util.HashMap<String,Object> parameters) {
		try {			
			if(parameters.containsKey("AUT_FATURAR_ITENS_COM_LOTE")) {
				parameters.remove("AUT_FATURAR_ITENS_COM_LOTE");
				CMP11016(parameters).autSAPFaturamentos().autIniciarFaturamento(parameters);							
			}
			else {
				CMP11016(parameters).autSAPFaturamentos().autIniciarFaturamento(parameters);			
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERRO: FATURAMENTO SAP");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	
	/**
	 * 
	 * Executa procedimentos de faturamento parcial no SAP
	 * 
	 * @param parameters - Parametros de configuração do SAP
	 * 
	 */
	public void CMP11030(java.util.HashMap<String,Object> parameters) {
		try {			
			if(!parameters.containsKey("AUT_FATURAR_ITENS_COM_LOTE")) {
				parameters.put("AUT_FATURAR_ITENS_COM_LOTE","");
				CMP11016(parameters).autSAPFaturamentos().autIniciarFaturamento(parameters);							
			}
			else {
				CMP11016(parameters).autSAPFaturamentos().autIniciarFaturamento(parameters);			
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERRO: FATURAMENTO SAP");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Consulta items de uma ordem de venda para um pedido específico
	 * 
	 * @param parameters - Parametros de configuração do SAP
	 * 
	 */
	public void CMP11028(java.util.HashMap<String,Object> parameters) {
		try {			
			CMP11016(parameters).autSAPFaturamentos().autConsultaItensOrdemVenda(parameters);			
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERRO: FATURAMENTO SAP");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * Consulta items de uma ordem de venda para um pedido específico
	 * 
	 * @param parameters - Parametros de configuração do SAP
	 * 
	 */
	public void CMP11029(java.util.HashMap<String,Object> parameters) {
		try {			
			AUTStoreItem managItem = new AUTStoreItem();
			System.out.println("AUT INFO: TOTAL FUNCOES CONFIG AGENDA SERVICOS E GARANTIA");
			System.out.println(managItem.getHashFunctionServicosEGarantias().size());
			for(AUTFunctionProcess fc : managItem.getHashFunctionServicosEGarantias().values()) {
				fc.autProcessByItem(parameters);
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERRO: FATURAMENTO SAP");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * Executa procedimento de devolução no PDV
	 * 
	 * @param parameters - Parametros de configuração do fluxo de devolução
	 * 
	 */
	public void CMP11018(java.util.HashMap<String,Object> parameters) {
		try {
			CMP11014(parameters).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.EXECUTION);
			CMP11014(parameters).autStartDevolucaoItem(parameters);
			CMP11014(parameters).AUT_AGENT_SILK4J.detachAll();
			CMP11014(parameters).AUT_AGENT_SILK4J = null;
		}
		catch(java.lang.Exception e) {
			CMP11014(parameters).AUT_AGENT_SILK4J.detachAll();
			CMP11014(parameters).AUT_AGENT_SILK4J = null;
		}
	}	


	/**
	 * Gerencia liberações pedentes - Antifraude
	 * 
	 * @param parameters - Parametros de configuração
	 */
	public void CMP11019(java.util.HashMap<String,Object> parameters) {
		AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//A[@textContents='Liberações Pendentes']").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.//INPUT[@id='antifraud']").select();
		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@class='caret'][2]").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").setFocus();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").select(parameters.get("AUT_PONTO_VENDA_PEDIDO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='idAdvancedNumber']").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='idAdvancedNumber']").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='idAdvancedNumber']").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());

		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();

		//AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();
		//AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Buscar").click();

	}

	/**
	 * Gerencia liberações pedentes - Antifraude
	 * 
	 * @param parameters - Parametros de configuração
	 */
	public void CMP11019_V2(java.util.HashMap<String,Object> parameters) {
		AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//A[@textContents='Liberações Pendentes']").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.MenuPrincipal").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.LiberacoesPendentes").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.//INPUT[@id='antifraud']").select();
		com.borland.silktest.jtf.Utils.sleep(2*1000);
		//AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@name='orderNumber' and @data-context='input']").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@name='orderNumber' and @data-context='input']").scrollIntoView();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.//BrowserWindow//DomTextField[@name='orderNumber' and @data-context='input']").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//BUTTON[@class='button button-text'][2]").scrollIntoView();		
		AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//BUTTON[@class='button button-text'][2]").click();
		try {
			AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//BUTTON[@textContents='Liberar sem*']").click();	
			AUT_AGENT_SILK4J.<DomButton>find("VA.//BrowserWindow//BUTTON[@textContents='Confirmar*']").click();
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERRO: LIBERAR ANTIFRAUDE");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * Consulta documentos vinculados associados ao numero de pedido
	 * 
	 * @param parameters - Parametros de configuração
	 * 
	 */
	public void CMP11020(java.util.HashMap<String,Object> parameters) {
		try {
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.EXECUTION);
			CMP11021(parameters).autVAConsultas().AUTVAConsultaStatusPedidoCompleto(parameters.get("AUT_NUMERO_PEDIDO").toString(), parameters.get("AUT_PEDIDO_STATUS_ESPERADO").toString(),parameters.get("AUT_USER").toString(),parameters.get("AUT_PASSWORD").toString());			
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.PASSED);
		}
		catch(java.lang.Exception e) {
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.FAILED);
		}
	}

	/**
	 * 
	 * Consulta status de pedido
	 * 
	 * @param parameters - Parametros de configuração
	 * 
	 */
	public void CMP11022(java.util.HashMap<String,Object> parameters) {
		try {
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.EXECUTION);
			CMP11021(parameters).autVAConsultaStatusPedido(parameters.get("AUT_NUMERO_PEDIDO").toString(), parameters.get("AUT_PEDIDO_STATUS_ESPERADO").toString(),parameters.get("AUT_USER").toString(),parameters.get("AUT_PASSWORD").toString());			
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.PASSED);
		}
		catch(java.lang.Exception e) {
			CMP11021(parameters).autVAConsultas(false).autSyncStateExecution(AUT_SYNC_EXECUTION_STATE.FAILED);
		}
	}


	/**
	 * Retorna componente para teste integrado VA
	 * 
	 * @param parameters - Parametros de configuração
	 */
	public <TVAComponent extends br.lry.components.va.AUTVABaseServices> TVAComponent CMP11021(java.util.HashMap<String,Object> parameters) {
		if(va==null) {
			va = new br.lry.components.va.AUTVABaseServices();
			return (TVAComponent) va;
		}
		else {
			return (TVAComponent) va;
		}
	}


	/**
	 * 
	 *Executa os procedimentos de pagamento do pedido
	 *
	 * @param parameters - HashMap parametros de configuração
	 * 
	 */
	public  void CMP11015(java.util.HashMap<String,Object> parameters) {
		try {
			CMP11014(parameters).autStartPagamentoPedido(parameters);
			CMP11014(parameters).AUT_AGENT_SILK4J.detachAll();
		}
		catch(java.lang.Exception e) {
			CMP11014(parameters).AUT_AGENT_SILK4J.detachAll();		
		}
	}


	/**
	 * 
	 *Executa os procedimentos para login no PDV
	 *
	 * @param parameters - HashMap parametros de configuração
	 * 
	 */
	public  void CMP11023(java.util.HashMap<String,Object> parameters) {
		try {
			CMP11014(parameters).autPDVAcessos().autPDVLoginDefault(parameters);
			CMP11014(parameters).AUT_AGENT_SILK4J.detachAll();
		}
		catch(java.lang.Exception e) {			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}



	/**
	 * 
	 * Converte carrinho para pedido de compra - VA
	 * 
	 * @param parameters - Parametros de configuração dos testes
	 * 
	 * @return True - Caso o processo seja finalizado com sucesso false caso contrário
	 * 
	 */
	public boolean CMP11005(java.util.HashMap<String,Object> parameters) {
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.ConverterPedido").click();
			CMP11012(parameters);
			return true;
		}
		catch(java.lang.Exception e) {

			System.out.println("AUT ERROR: CONVERTER PEDIDO DE COMPRA");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}




	/**
	 * 
	 * Pesquisa cliente na no VA
	 * 
	 * @param parameters - Parametos de configuração do componente
	 * @return boolean - True caso o processo seja finalizado com sucesso , false caso contrário
	 *
	 */
	public boolean CMP11006(java.util.HashMap<String,Object> parameters) {
		try {
			System.out.println("AUT INFO: PESQUISA CLIENTE PARA PEDIDO");
			AUT_VA_TIPO_DOCUMENTO_PESQUISA opFiltroCliente = AUT_VA_TIPO_DOCUMENTO_PESQUISA.valueOf(parameters.get("AUT_TIPO_FILTRO_PESQUISA").toString());
			String documento = parameters.get("AUT_DOCUMENTO_CLIENTE").toString();

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.BuscarPedido").click();


			switch(opFiltroCliente) {
			case CPF_OU_CNPJ:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.CPFouCNPJ");
				break;
			}
			case NOME:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.Nome");				
				break;
			}
			case NOME_FANTASIA:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.NomeFantasia");				
				break;
			}
			case PASSAPORTE:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.Passaporte");				
				break;
			}
			case RAZAO_SOCIAL:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.RazaoSocial");				
				break;
			}
			case RG_OU_RNE:{
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.RGouRNE");	
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.AdicionarNovo").click();
				break;
			}
			}

			autSetContentWebTypeViaSetText(documento, AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.NumeroDocumento"));

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.BotaoPesquisa").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.ClienteSelect").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011PesquisaClienteLoja.AvancarConfirmaCliente").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Avançar").click();

			boolean existValidMultLotes = AUT_AGENT_SILK4J.<BrowserWindow>find("//BrowserApplication//BrowserWindow").exists("//DomElement[@textContents='Dividir por lotes']", 5  * 1000);
			if(existValidMultLotes) {
				AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//DomElement[@textContents='Dividir por lotes']").click();
			}
			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERROR: PESQUISA CLIENTE PARA PEDIDO");
			System.out.println(e.getMessage());
			e.printStackTrace();

			return false;
		}	
	}

	/**
	 * Componente para configuração dos fluxos de saida
	 * 
	 * @param parameters
	 * @return
	 */
	public <TFluxosGerenciador extends AUTVAFluxosSaidaComponente> TFluxosGerenciador CMP11007(java.util.HashMap<String,Object> parameters) {
		try {
			if(autFluxosSaidaComponenteV2==null) {
				autFluxosSaidaComponenteV2 = new AUTVAFluxosSaidaComponente();
				return (TFluxosGerenciador) autFluxosSaidaComponenteV2;
			}
			else {
				return (TFluxosGerenciador) autFluxosSaidaComponenteV2;				
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERROR : ERRO AO RECUPERAR COMPONENTE DE CONFIGURACAO DO FLUXO DE SAIDA");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}



	/**
	 * Configura os meios de pagamento para um pedido específico
	 * 
	 * @param parameters - Parametros de configuração
	 * @return 
	 */
	public void CMP11008(java.util.HashMap<String,Object> parameters) {

	}

	/**
	 * 
	 * Carrega o numero do pedido gerado
	 * 
	 * @param parameters - Parametros de configuração do fluxo
	 * @return String - Número do pedido
	 * 
	 */
	public String CMP11009(java.util.HashMap<String,Object> parameters) {
		try {
			System.out.println("AUT INFO: RECUPERANDO NUMERO DO PEDIDO");
			Boolean popup = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011ConfirmacaoPedido").exists("PopUp1");

			if(popup) {

				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011ConfirmacaoPedido.NumeroCartao").setText(parameters.get("AUT_NUMERO_CARTAO").toString());			
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011ConfirmacaoPedido.BotaoSalvar").click();							
			}

			String numeroPedido = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroPedido").getText();
			java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("\\d+");
			java.util.regex.Matcher verif = regExp.matcher(numeroPedido);

			if(verif.find()) {
				return verif.group();
			}
			else {
				return "00000000000";
			}
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT ERROR : RECUPERAR NUMERO DO PEDIDO");
			System.out.println(e.getMessage());
			e.printStackTrace();			
			return null;
		}
	}

	public void CMP11010(java.util.HashMap<String,Object> parameters) {
		AUT_MODO_CONSULTAS_VA_SELECAO_ITEM opSelect = AUT_MODO_CONSULTAS_VA_SELECAO_ITEM.valueOf(parameters.get("AUT_MODO_CONSULTA_ITEM").toString());


		switch(opSelect) {
		case COPIA:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.CopiaPedido").click();
			break;
		}
		case CONSULTA_STATUS_PEDIDO:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011MenuCarrinho.IconeCarrinho").click();;
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011MenuCarrinho.BotaoBuscarPedidos").click();;
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.BotaoPesquisa").click();

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").click();		
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FiltroPesquisa.TipoPesquisaPedido").select();

			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());		

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").click();


			break;
		}
		case EDICAO_DO_BOITATA:{
			AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//A[@class='color-text']//DIV[@textContents='Buscar Pedidos']").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.BotaoPesquisa").click();

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").click();		
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FiltroPesquisa.TipoPesquisaPedido").select();

			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());		

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").click();

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").waitForProperty("Visible", true,30 *1000);
			boolean existConf = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011FiltroPesquisa").exists("SimEditarPedido", 5 * 1000);
			boolean existAvanc = AUT_AGENT_SILK4J.<BrowserWindow>find("//BrowserApplication//BrowserWindow").exists("//DomButton[@textContents='Confirmar']", 2 * 1000);
			if(existConf) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.SimEditarPedido").click();			
			}
			else if(existAvanc) {
				AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//DomButton[@textContents='Avançar']").click();				
			}

			break;
		}
		case EDICAO:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011MenuCarrinho.IconeCarrinho").click();;
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011MenuCarrinho.BotaoBuscarPedidos").click();;
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.BotaoPesquisa").click();

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").click();		
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FiltroPesquisa.TipoPesquisaPedido").select();

			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());		

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").click();

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").waitForProperty("Visible", true,30 *1000);
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.SimEditarPedido").click();
			CMP11012(parameters);
			break;
		}
		case EXIBICAO_DOCUMENTOS_VINCULADOS:{
			AUT_AGENT_SILK4J.<DomElement>find("//BrowserApplication//BrowserWindow//DomElement[@textContents='Buscar Pedidos']").click();


			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.BotaoPesquisa").click();

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.LimparPesquisa").click();		
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TL011FiltroPesquisa.TipoPesquisaPedido").select();

			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011FiltroPesquisa.NumeroPedido").setText(parameters.get("AUT_NUMERO_PEDIDO").toString());		

			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").scrollIntoView();
			AUT_AGENT_SILK4J.<DomButton>find("VA.TL011FiltroPesquisa.BuscarPedido").click();

			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.DocumentosVinculados").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoDocsRelExibir").click();
			DomElement containerDocs = AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@class='container-fluid']");
			java.util.List<TestObject> docs = containerDocs.findAll("//P");
			for(TestObject item: docs) {
				DomElement it = (DomElement) item;
				it.scrollIntoView();
				it.highlightObject();
			}
			AUT_AGENT_SILK4J.<DomElement>find("VA.//BrowserWindow//DomElement[@class='modal-close*']").click();
			break;
		}
		case IMPRESSAO:{
			AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.ImprimirNota").click();
			break;
		}
		}

	}


	/**
	 * 
	 * Componente para edição de pedido
	 * 
	 * @param parameters - parametros de configuração do fluxo
	 * 
	 */
	public void CMP11011(java.util.HashMap<String,Object> parameters) {
		AUT_EDICAO_PEDIDO opEdit = AUT_EDICAO_PEDIDO.valueOf(parameters.get("AUT_EDICAO_ITEM_OPCAO").toString());
		java.util.List<AUTStoreItem> list = (List<AUTStoreItem>) parameters.get("AUT_ITENS_EDICAO");
		System.out.println("AUT INFO: EDITANDO ITENS DO CARRINIHO:");

		java.util.List<DomElement> items = AUT_AGENT_SILK4J.findAll("VA.TL011EdicaoPedido.Registros");
		int contInteraction = 1;
		for(AUTStoreItem item: list) {
			if(item.isAutFluxoPedidoIncluirItemCarrinho()) {
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setText("");
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.QuantidadeItem").typeKeys(item.getQuantidadePadrao().toString());
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setText("");
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys(item.getLmMaterial().toString());
				AUT_AGENT_SILK4J.<DomTextField>find("VA.TL011VACarrinhoCompra.eanOrCode").typeKeys("\n");
			}
			else if(item.isAutFluxoPedidoExcluirItemCarrinho()) {			
				AUT_AGENT_SILK4J.<DomElement>find(String.format("VA.TL011VACarrinhoCompra.//I[@class='glyph glyph-trash-ca*'][%s]",Integer.parseInt(parameters.get("AUT_PARAMETRO_EXCLUSAO_ITENS").toString()))).click();
				AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TL011VACarrinhoCompra").exists("PopUp1", 5000);
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.PopUp1").waitForProperty("Visible", true,4 * 1000);
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011VACarrinhoCompra.Sim").click();
			}
			switch(opEdit) {
			case GARANTIA_ITEM_INDIVIDUAL:{
				
				break;
			}
			case QUANTIDADE_ITEM_QUANT_ADICIONAR_POR_ATRIBUTO:{
				if(item.isAutFluxoPedidoAlterarQuantidadePedido()) {
					System.out.println("AUT INFO: ADICIONANDO QUANTIDADE NO ITEM:");
					System.out.println(item.getLmMaterial());						
					//DomElement itemList = (DomElement)autSearchObject(items, "DomTextField","class=\"cart-item-content\"", "id=\"input-\\d+\"");
					//DomTextField itemLM = (DomTextField)autSearchObject(itemList, "DomTextField",item.getLmMaterial().toString(), "id=\"input-\\d+\"");
					String locInput = String.format("VA.//BrowserWindow//DomElement[@data-product-code='%s']//DomTextField[@data-quantity='input']",item.getLmMaterial());
					System.out.println(locInput);
					AUT_AGENT_SILK4J.<DomTextField>find(locInput).scrollIntoView();					
					AUT_AGENT_SILK4J.<DomTextField>find(locInput).setText(item.getInputFluxoPedidoAlterarQuantidadePedido().toString());
				}
				break;
			}
			case QUANTIDADE_ITEM_QUANT_ADICIONAR_PADRAO:{
				if(item.isAutFluxoPedidoAlterarQuantidadePedido()) {
					//VA.//BrowserWindow//BUTTON[@class='cart-item-remove but*'][2] - Excluir
					//.//BUTTON[@data-action='sum'][2] - Botao soma
					//VA.//BrowserWindow//DIV[@class='field addon-right ac*'][2]//INPUT - Quantidade de item

					System.out.println("AUT INFO: ADICIONANDO QUANTIDADE NO ITEM:");
					System.out.println(item.getLmMaterial());						
					DomTextField txt = AUT_AGENT_SILK4J.<DomTextField>find(String.format("VA.//BrowserWindow//DIV[@class='field addon-right ac*'][%s]//INPUT",item.getAutIndexItemCarrinhoWebPage()));
					txt.scrollIntoView();						
					txt.setText("");
					txt.setFocus();
					txt.setText(item.getInputFluxoPedidoAlterarQuantidadePedido().toString());						
				}
				break;
			}
			case QUANTIDADE_ITEM_SUBTRAIR_PADRAO:{
				for(DomElement itList : items) {
					if(item.isAutFluxoPedidoAlterarQuantidadePedido()) {
						System.out.println("AUT INFO: SUBTRAINDO QUANTIDADE NO ITEM:");
						System.out.println(item.getLmMaterial());				
						autSearchObject(itList, "DomButton",item.getLmMaterial().toString(), "type=\"button\" data-action=\"sum\"").click();
					}
				}				
				break;
			}
			case DATA_AGENDAMENTO_FLUXO_ENTREGAS:{			
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.EditarPedido").waitForProperty("Visible", true,30 *1000);
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FiltroPesquisa.SimEditarPedido").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.TL011FluxosDeSaida.Finalizar").click();
				break;
			}
			case ALTERAR_CONFIGURACAO_FLUXO_SAIDA:{

			}
			}
		}		
	}



}


