/**
 * 
 */
package br.lry.components;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestClass;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.TestObject;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.common.types.ItemIdentifier;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.microfocus.silktest.jtf.*;

import br.lry.components.AUTVABaseComponent.AUTVAFluxosSaidaComponente.FILIAIS;
import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem.AUT_TIPO_MSG_LOG;
import br.stk.framework.db.management.AUTDBProcessDataFlow;
import br.stk.framework.db.management.AUTDBProject;
import br.stk.framework.tests.AUTFWKTestObjectBase;
import junit.framework.TestCase;
import junit.framework.TestResult;

/**
 * 
 * Componente - Realiza login no  sistema:
 * 
 * VA : Vendas assistidas
 * 
 * @author Softtek-QA
 *
 */
public abstract class AUTBaseComponent extends AUTFWKTestObjectBase{
	private AUTDataFlow AUT_CURRENT_DATA_FLOW = null; //Objeto de gerenciamento do fluxo de dados
	private AUTLogMensagem AUT_CURRENT_LOG_MANAGER = null; //Objeto de gerenciamento do log
	protected AUT_TABLE_PARAMETERS_NAMES AUT_CURRENT_PARAMETERS_TABLE_NAME = null;
	public String AUT_USUARIO_LOGIN_DEFAULT = "";
	public String AUT_SENHA_LOGIN_DEFAULT = "";
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	
	
	/**
	 * 
	 * Representa o item de loja para venda
	 * 
	 * @author Softtek-QA
	 *
	 */
	public static class AUTStoreItem extends AUTBaseComponent{
		private Integer ID;       																		//ID EXCLUSIVO DO PRODUTO,
		private Integer idProject;																		//DESCRIÇÃO DA FRENTE DE PROJETO ASSOCIADO AO PRODUTO
		private Integer lmMaterial;																		//ID DO PRODUTO
		private String lojaMaterial;																	//LOJA ASSOCIADA AO PRODUTO
		private String lmNomeMaterial;																	//NOME DO PRODUTO
		private String lmDescricaoMaterial; 															//DESCRIÇÃO ASSOCIADA AO PRODUTO
		private Boolean eUnidadePedidoFracionado;														//ITEM GERENCIADO POR LOTE
		private Boolean eUnidadePedidoUnitaria;															//ITEM UNITÁRIO
		private Boolean eGerenciadoPorLote;																//DEFINE SE O ITEM É CONTROLADO POR LOTE
		private Boolean temMultiplosLotes;																//DEFINE SE O ITEM POSSUI MULTIPLOS LOJAS
		private Boolean temLoteUnico;																	//DEFINE SE O ITEM POSSUI LOTE UM ÚNICO ASSOCIADO
		private Boolean semLoteAssociado;																//DEFINE SE O ITEM NÃO POSSUI LOTE ASSOCIADO
		private String precoBoitata;																	//DEFINE O PREÇO DO ITEM NO BOITATA
		private String precoEcommerce;																	//DEFINE O PREÇO DO ITEM NO SISTEMA ECOMMERCE
		private String precoVA;																			//DEFINE O PREÇO DO ITEM NO SISTEMA VA
		private String precoPDV;																		//DEFINE O PREÇO DO ITEM NO SISTEMA PDV
		private String precoSAP;																		//DEFINE O PREÇO DO ITEM NO SISTEMA SAP
		private String precoHMC;																		//DEFINE O PREÇO DO ITEM NO SISTEMA HMC
		private Boolean temServico;																		//DEFINE SE O ITEM POSSUI SERVIÇO ASSOCIADO
		private Boolean temGarantia;																	//DEFINE SE O ITEM POSSUI GARANTIA ASSOCIADA
		private Boolean eTop0;																			//DEFINE SE O ITEM POSSUI TOPAGEM 0 NA LOJA
		private Boolean eTop1;																			//DEFINE SE O ITEM POSSUI TOPAGEM 1 NA LOJA
		private Boolean eTop2;																			//DEFINE SE O ITEM POSSUI TOPAGEM 2 NA LOJA
		private Boolean eTop3;																			//DEFINE SE O ITEM POSSUI TOPAGEM 3 NA LOJA	
		private Boolean eTop4;																			//DEFINE SE O ITEM POSSUI TOPAGEM 4 NA LOJA
		private Boolean eTop5;																			//DEFINE SE O ITEM POSSUI TOPAGEM 5 NA LOJA
		private Boolean temEstoqueLoja;																	//DEFINE SE O ITEM POSSUI ESTOQUE NA LOJA	
		private Boolean temEstoqueCentralDistribuicao;													//DEFINE SE O ITEM POSSUI ESTOQUE NA CENTRAL DE DISTRIBUIÇÃO
		private String estoqueLoja;																		//DEFINE O ESTOQUE DO ITEM NA LOJA
		private String estoqueCentralDistribuicao;														//DEFINE O ESTOQUE DO ITEM NA CENTRAL DE DISTRIBUIÇÃO
		private String fluxoSaida;																		//DEFINE O FLUXO DE SAIDA PARA O ITEM
		private String dataInclusao;																	//DEFINE A DATA DE INCLUSÃO DO ITEM
		private String dataAlteracao;																	//DEFINE A DATA DE ALTERAÇÃO DO ITEM
		private Boolean estaAtivo;																		//DEFINE SE O ITEM ESTÁ ATIVO PARA UTILIZAÇÃO
		private Integer quantidadePadrao;
		private AUTDBProject projDb = null;
		
		private boolean autFluxoPedidoAlterarQuantidadePedido = false;
		private boolean autFluxoPedidoAlterarDeposito = false;
		private boolean autFluxoPedidoAlterarLoja = false;
		private boolean autFluxoPedidoIncluirItemCarrinho = false;
		private boolean autFluxoPedidoExcluirItemCarrinho = false;
		
		
		/**
		 * @return the autFluxoPedidoExcluirItemCarrinho
		 */
		public boolean isAutFluxoPedidoExcluirItemCarrinho() {
			return autFluxoPedidoExcluirItemCarrinho;
		}
		/**
		 * @param autFluxoPedidoExcluirItemCarrinho the autFluxoPedidoExcluirItemCarrinho to set
		 */
		public void setAutFluxoPedidoExcluirItemCarrinho(boolean autFluxoPedidoExcluirItemCarrinho) {
			this.autFluxoPedidoExcluirItemCarrinho = autFluxoPedidoExcluirItemCarrinho;
		}
		/**
		 * @return the autFluxoPedidoIncluirItemCarrinho
		 */
		public boolean isAutFluxoPedidoIncluirItemCarrinho() {
			return autFluxoPedidoIncluirItemCarrinho;
		}
		/**
		 * @param autFluxoPedidoIncluirItemCarrinho the autFluxoPedidoIncluirItemCarrinho to set
		 */
		public void setAutFluxoPedidoIncluirItemCarrinho(boolean autFluxoPedidoIncluirItemCarrinho) {
			this.autFluxoPedidoIncluirItemCarrinho = autFluxoPedidoIncluirItemCarrinho;
		}

		private Integer inputFluxoPedidoAlterarQuantidadePedido = 0;
		private FILIAIS inputFluxoPedidoAlterarDeposito = null;
		private FILIAIS inputFluxoPedidoAlterarLoja = null;
		
		
		/**
		 * @return the autFluxoPedidoAlterarQuantidadePedido
		 */
		public boolean isAutFluxoPedidoAlterarQuantidadePedido() {
			return autFluxoPedidoAlterarQuantidadePedido;
		}
		/**
		 * @param autFluxoPedidoAlterarQuantidadePedido the autFluxoPedidoAlterarQuantidadePedido to set
		 */
		public void setAutFluxoPedidoAlterarQuantidadePedido(boolean autFluxoPedidoAlterarQuantidadePedido) {
			this.autFluxoPedidoAlterarQuantidadePedido = autFluxoPedidoAlterarQuantidadePedido;
		}
		/**
		 * @return the autFluxoPedidoAlterarDeposito
		 */
		public boolean isAutFluxoPedidoAlterarDeposito() {
			return autFluxoPedidoAlterarDeposito;
		}
		/**
		 * @param autFluxoPedidoAlterarDeposito the autFluxoPedidoAlterarDeposito to set
		 */
		public void setAutFluxoPedidoAlterarDeposito(boolean autFluxoPedidoAlterarDeposito) {
			this.autFluxoPedidoAlterarDeposito = autFluxoPedidoAlterarDeposito;
		}
		/**
		 * @return the autFluxoPedidoAlterarLoja
		 */
		public boolean isAutFluxoPedidoAlterarLoja() {
			return autFluxoPedidoAlterarLoja;
		}
		/**
		 * @param autFluxoPedidoAlterarLoja the autFluxoPedidoAlterarLoja to set
		 */
		public void setAutFluxoPedidoAlterarLoja(boolean autFluxoPedidoAlterarLoja) {
			this.autFluxoPedidoAlterarLoja = autFluxoPedidoAlterarLoja;
		}
		/**
		 * @return the inputFluxoPedidoAlterarQuantidadePedido
		 */
		public Integer getInputFluxoPedidoAlterarQuantidadePedido() {
			return inputFluxoPedidoAlterarQuantidadePedido;
		}
		/**
		 * @param inputFluxoPedidoAlterarQuantidadePedido the inputFluxoPedidoAlterarQuantidadePedido to set
		 */
		public void setInputFluxoPedidoAlterarQuantidadePedido(Integer inputFluxoPedidoAlterarQuantidadePedido) {
			this.inputFluxoPedidoAlterarQuantidadePedido = inputFluxoPedidoAlterarQuantidadePedido;
		}
		/**
		 * @return the inputFluxoPedidoAlterarDeposito
		 */
		public FILIAIS getInputFluxoPedidoAlterarDeposito() {
			return inputFluxoPedidoAlterarDeposito;
		}
		/**
		 * @param inputFluxoPedidoAlterarDeposito the inputFluxoPedidoAlterarDeposito to set
		 */
		public void setInputFluxoPedidoAlterarDeposito(FILIAIS inputFluxoPedidoAlterarDeposito) {
			this.inputFluxoPedidoAlterarDeposito = inputFluxoPedidoAlterarDeposito;
		}
		/**
		 * @return the inputFluxoPedidoAlterarLoja
		 */
		public FILIAIS getInputFluxoPedidoAlterarLoja() {
			return inputFluxoPedidoAlterarLoja;
		}
		/**
		 * @param inputFluxoPedidoAlterarLoja the inputFluxoPedidoAlterarLoja to set
		 */
		public void setInputFluxoPedidoAlterarLoja(FILIAIS inputFluxoPedidoAlterarLoja) {
			this.inputFluxoPedidoAlterarLoja = inputFluxoPedidoAlterarLoja;
		}

		AUT_SELECT_PRODUCT_OPTIONS_BY_STORE filterOptions;
		java.util.HashMap<Integer,java.util.HashMap<String,Object>> outputData = null;
		Integer indexRow = 0;
		enum AUT_SQL_PRODUCT_STRUCTURE{
			ID,
			 PJT_ID,
			 PRD_ID,
			 PRD_LOJA,
			 PRD_NOME,
			 PRD_DESCRICAO,
			 PRD_ITEM_FRACIONADO,
			 PRD_ITEM_UNITARIO,
			 PRD_ITEM_CONTROLE_LOTE,
			 PRD_ITEM_CONTROLE_LOTE_MULTIPLOS,
			 PRD_ITEM_CONTROLE_LOTE_UNICO,
			 PRD_ITEM_SEM_LOTE_ASSOCIADO,
			 PRD_ITEM_PRECO_BOITATA,
			 PRD_ITEM_PRECO_ECOMMERCE,
			 PRD_ITEM_PRECO_VA,
			 PRD_ITEM_PRECO_PDV,
			 PRD_ITEM_PRECO_SAP,
			 PRD_ITEM_PRECO_HMC,
			 PRD_ITEM_COM_SERVICO,
			 PRD_ITEM_COM_GARANTIA,
			 PRD_ITEM_TOP0,
			 PRD_ITEM_TOP1,
			 PRD_ITEM_TOP2,
			 PRD_ITEM_TOP3,
			 PRD_ITEM_TOP4,
			 PRD_ITEM_TOP5,
			 PRD_ITEM_POSSUI_ESTOQUE_LOJA,
			 PRD_ITEM_POSSUI_ESTOQUE_CD,
			 PRD_ITEM_ESTOQUE_LOJA,
			 PRD_ITEM_ESTOQUE_CD,
			 PRD_ITEM_FLUXO_SAIDA,
			 PRD_DATA_INCLUSAO,
			 PRD_DATA_ALTERACAO,
			 PRD_ESTA_ATIVO,
			 PRD_QUANTIDADE_CARRINHO_PADRAO
		}
		
		
		public static enum AUT_SELECT_PRODUCT_OPTIONS_BY_STORE{
			CONDITION_BY_ID,
			CONDITION_BY_LM,
			CONDITION_BY_WARRANTY,
			CONDITION_BY_SERVICE,
			CONDITION_BY_STORE,		
			CUSTOM_CONDITION,
			MATERIAL,
			STORE,
			SELECT_ALL_ITEMS,
			SELECT_ALL_ITEMS_WITH_ORDER_LIST;			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				switch(this) {
				case SELECT_ALL_ITEMS_WITH_ORDER_LIST:{
					return "SELECT * FROM LRY.AUT_PROJECT_PRODUCTS ORDER BY ID ASC";
				}
				case SELECT_ALL_ITEMS:{
					return "SELECT * FROM LRY.AUT_PROJECT_PRODUCTS";
				}
				case CONDITION_BY_STORE:{
					return " WHERE PRD_LOJA LIKE '%s' ORDER BY ID ASC";
				}
				case STORE:{
					return CONDITION_BY_STORE.toString();
				}
				case CONDITION_BY_WARRANTY:{
					return " WHERE PRD_ITEM_COM_GARANTIA=1 ORDER BY ID ASC";
				}
				case CONDITION_BY_SERVICE:{
					return " WHERE PRD_ITEM_COM_SERVICO=1 ORDER BY ID ASC";
				}
				case CONDITION_BY_ID:{
					return " WHERE ID IN (%s) ORDER BY ID ASC";
				}
				case CONDITION_BY_LM:{
					return " WHERE PRD_ID LIKE '%s' ORDER BY ID ASC";
				}
				case MATERIAL:{
					return CONDITION_BY_LM.toString();
				}
				default:{
					return super.toString();
				}
				}
			}
		}
		
		public <TItem extends AUTStoreItem> AUTStoreItem autCopyItemStore(TItem item) {
			AUTStoreItem it = new AUTStoreItem();
			it.setLmMaterial(item.getLmMaterial());
			it.setLmDescricaoMaterial(item.getLmDescricaoMaterial());
			it.setEstaAtivo(item.getEstaAtivo());
			it.setIdProject(item.getIdProject());
			it.setEGerenciadoPorLote(item.getEGerenciadoPorLote());
			it.setTemEstoqueCentralDistribuicao(item.getTemEstoqueCentralDistribuicao());
			it.setTemServico(item.getTemServico());
			it.setTemGarantia(item.getTemGarantia());
			it.setTemLoteUnico(item.getTemLoteUnico());
			it.setTemMultiplosLotes(item.getTemMultiplosLotes());
			it.setLmNomeMaterial(item.getLmNomeMaterial());
			return it;
		}
		/**
		 * @return the quantidadePadrao
		 */
		public Integer getQuantidadePadrao() {
			return quantidadePadrao;
		}

		/**
		 * @param quantidadePadrao the quantidadePadrao to set
		 */
		public void setQuantidadePadrao(Integer quantidadePadrao) {
			this.quantidadePadrao = quantidadePadrao;
		}

		/**
		 * Retorna as opções de filtro para seleção de itens
		 * 
		 * @return AUT_SELECT_PRODUCT_OPTIONS - Filter options
		 */
		public AUT_SELECT_PRODUCT_OPTIONS_BY_STORE autGetFilterOptions(){
			return filterOptions;
		}
		
		/**
		 * Atualiza os valores do objeto local com os inputs de dados do banco de dados
		 * 
		 * @return boolean - True caso o processo seja finalizado com sucesso, false caso contrário
		 *
		 */
		private boolean setCurrentObject() {
			try {
				setID(Integer.parseInt(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.ID.toString()).toString()));
				setIdProject(Integer.parseInt(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PJT_ID.toString()).toString()));
				setLmMaterial(Integer.parseInt(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ID.toString()).toString()));
				setLmNomeMaterial(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_NOME.toString()).toString());
				setLmDescricaoMaterial(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_DESCRICAO.toString()).toString());
				setLojaMaterial(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_LOJA.toString()).toString());
				setEUnidadePedidoFracionado((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_FRACIONADO.toString()));
				setEUnidadePedidoUnitaria((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_UNITARIO.toString()));				
				setEGerenciadoPorLote((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_CONTROLE_LOTE.toString()));			
				setEGerenciadoPorLote((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_CONTROLE_LOTE.toString()));
				setTemMultiplosLotes((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_CONTROLE_LOTE_MULTIPLOS.toString()));
				setTemLoteUnico((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_CONTROLE_LOTE_UNICO.toString()));
				setSemLoteAssociado((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_SEM_LOTE_ASSOCIADO.toString()));
				setSemLoteAssociado((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_SEM_LOTE_ASSOCIADO.toString()));
				setPrecoBoitata(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_BOITATA.toString()).toString());
				setPrecoEcommerce(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_ECOMMERCE.toString()).toString());
				setPrecoVA(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_VA.toString()).toString());
				setPrecoPDV(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_PDV.toString()).toString());
				setPrecoSAP(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_SAP.toString()).toString());
				setPrecoHMC(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_PRECO_HMC.toString()).toString());
				setTemServico((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_COM_SERVICO.toString()));
				setTemGarantia((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_COM_GARANTIA.toString()));
				setETop0((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP0.toString()));
				setETop1((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP1.toString()));
				setETop2((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP2.toString()));
				setETop3((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP3.toString()));
				setETop4((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP4.toString()));
				setETop5((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_TOP5.toString()));
				setTemEstoqueCentralDistribuicao((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_POSSUI_ESTOQUE_CD.toString()));
				setTemEstoqueLoja((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_POSSUI_ESTOQUE_LOJA.toString()));
				setFluxoSaida(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ITEM_FLUXO_SAIDA.toString()).toString());
				setDataInclusao(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_DATA_INCLUSAO.toString()).toString());
				setDataAlteracao(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_DATA_ALTERACAO.toString()).toString());
				setEstaAtivo((Boolean) outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_ESTA_ATIVO.toString()));
				setQuantidadePadrao(Integer.parseInt(outputData.get(indexRow).get(AUT_SQL_PRODUCT_STRUCTURE.PRD_QUANTIDADE_CARRINHO_PADRAO.toString()).toString()));

				return true;
			}
			catch(java.lang.Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				return false;
			}
		} 
	
		public boolean autResetListProductStore() {
			try {
				System.out.println("AUT INFO: RESET LIST PRODUCTS");
				indexRow = 1;
				outputData.clear();
				return true;
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR: RESET LIST PRODUCTS");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				return false;
			}
		}
		/**
		 * 
		 * Retorna os itens da tabela de produtos cadastrados
		 * 
		 * @param optionFilter - Opção de filtro 
		 * @return AUTStoreItem - Caso existe registros para o critério especifica, null caso a lista esteja vazia ou não tenha mais registros
		 * 
		 */
		public <TStoreItem extends AUTStoreItem,TOptionCondition extends java.lang.Enum<AUT_SELECT_PRODUCT_OPTIONS_BY_STORE>> TStoreItem autGetNextItemStore(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE optionFilter) {
			switch((AUT_SELECT_PRODUCT_OPTIONS_BY_STORE)optionFilter) {
			case CONDITION_BY_SERVICE:{
				return autGetNextItemStore(optionFilter, "");
			}
			case CONDITION_BY_WARRANTY:{
				return autGetNextItemStore(optionFilter, "");
			}
			case SELECT_ALL_ITEMS_WITH_ORDER_LIST:{
				return autGetNextItemStore(optionFilter, "");
			}
			case CONDITION_BY_LM:{
				return autGetNextItemStore(optionFilter, "%");
			}
			case MATERIAL:{
				return autGetNextItemStore(optionFilter, "%");
			}
			default:{
				System.out.println("AUT INFO: OPCAO INDISPONÍVEL PARA ESSA VERSAO DO METODO DE PESQUISA, SOLUÇÃO NAO IMPLEMENTADA");
				return null;
			}
			}
			
		}
			
		/**
		 * 
		 * Retorna o proximo item de loja cadastrado na tabela de dados do sistema
		 * 
		 * - Essa função pode ser utilizada em loops levando 
		 * em consideração o tipo de retorno no tratamento do laço de repetição
		 * 
		 * @return AUTStoreItem - Retorna um item de loja caso o processo seja realizado com sucesso, 
		 * retorna null caso seja o último item da lista ou a lista esteja vazia
		 *
		 */
		public <TStoreItem extends AUTStoreItem,TOptionCondition extends java.lang.Enum<AUT_SELECT_PRODUCT_OPTIONS_BY_STORE>> TStoreItem autGetNextItemStore(TOptionCondition conditionByFilter,String parametersByFilter){
			try {				
				if(outputData==null || outputData.size()==0) {
					if(projDb==null) {
						projDb = autGetProjectManagerDB();
						projDb.autStartDefaultConnection();
					}
					else {
						projDb.autStartDefaultConnection();
					}	
					
					
					String sqlCmd = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString();

					switch((AUT_SELECT_PRODUCT_OPTIONS_BY_STORE)conditionByFilter) {
					case CONDITION_BY_ID:{
						sqlCmd = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString();
						sqlCmd = String.format(sqlCmd.concat(conditionByFilter.toString()),parametersByFilter);
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(sqlCmd, AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case CONDITION_BY_LM:{
						sqlCmd = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString();
						sqlCmd = String.format(sqlCmd.concat(conditionByFilter.toString()),parametersByFilter);
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(sqlCmd, AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case SELECT_ALL_ITEMS_WITH_ORDER_LIST:{
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS_WITH_ORDER_LIST.toString(), AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});						
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case MATERIAL:{
						autGetNextItemStore(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.CONDITION_BY_LM, "%".concat(parametersByFilter.concat("%")));
						break;
					}
					case STORE:{
						autGetNextItemStore(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.CONDITION_BY_STORE,"%".concat(parametersByFilter).concat("%"));
						break;
					}
					case CONDITION_BY_WARRANTY:{
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString().concat(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.CONDITION_BY_WARRANTY.toString()), AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});						
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case CONDITION_BY_SERVICE:{
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString().concat(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.CONDITION_BY_SERVICE.toString()), AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});						
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case CUSTOM_CONDITION:{
						sqlCmd = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString();
						sqlCmd = sqlCmd.concat(parametersByFilter);
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(sqlCmd, AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					case CONDITION_BY_STORE:{
						sqlCmd = AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS.toString();
						sqlCmd = String.format(sqlCmd.concat(conditionByFilter.toString()),"%".concat(parametersByFilter).concat("%"));
						outputData = autGetProjectManagerDB().autGetDataTableByProperties(sqlCmd, AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});
						if(outputData.size() > 0) {
							setCurrentObject();
						}
						break;
					}
					default:{
						//outputData = autGetProjectManagerDB().autGetDataTableByProperties(AUT_SELECT_PRODUCT_OPTIONS_BY_STORE.SELECT_ALL_ITEMS_WITH_ORDER_LIST.toString(), AUT_SQL_PRODUCT_STRUCTURE.class, new Object[] {});		
						break;
					}
					}

						
					indexRow++;
				}
				else {
					indexRow++;			
					if(outputData.containsKey(indexRow)) {
						setCurrentObject();
					}
					else {
						return null;
					}
				}						
				
				return (TStoreItem) (this.getID()!=null?this:null);
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR: GET NEXT ITEM FROM STORE");
				System.out.println(e.getMessage());
				e.printStackTrace();				
				return null;
			}
		}
		
		/**
		 * @return the iD
		 */
		public Integer getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(Integer iD) {
			ID = iD;
		}
		/**
		 * @return the idProject
		 */
		public Integer getIdProject() {
			return idProject;
		}
		/**
		 * @param idProject the idProject to set
		 */
		public void setIdProject(Integer idProject) {
			this.idProject = idProject;
		}
		/**
		 * @return the lmMaterial
		 */
		public Integer getLmMaterial() {
			return lmMaterial;
		}
		/**
		 * @param lmMaterial the lmMaterial to set
		 */
		public void setLmMaterial(Integer lmMaterial) {
			this.lmMaterial = lmMaterial;
		}
		/**
		 * @return the lojaMaterial
		 */
		public String getLojaMaterial() {
			return lojaMaterial;
		}
		/**
		 * @param lojaMaterial the lojaMaterial to set
		 */
		public void setLojaMaterial(String lojaMaterial) {
			this.lojaMaterial = lojaMaterial;
		}
		/**
		 * @return the lmNomeMaterial
		 */
		public String getLmNomeMaterial() {
			return lmNomeMaterial;
		}
		/**
		 * @param lmNomeMaterial the lmNomeMaterial to set
		 */
		public void setLmNomeMaterial(String lmNomeMaterial) {
			this.lmNomeMaterial = lmNomeMaterial;
		}
		/**
		 * @return the lmDescricaoMaterial
		 */
		public String getLmDescricaoMaterial() {
			return lmDescricaoMaterial;
		}
		/**
		 * @param lmDescricaoMaterial the lmDescricaoMaterial to set
		 */
		public void setLmDescricaoMaterial(String lmDescricaoMaterial) {
			this.lmDescricaoMaterial = lmDescricaoMaterial;
		}
		/**
		 * @return the eUnidadePedidoFracionado
		 */
		public Boolean getEUnidadePedidoFracionado() {
			return eUnidadePedidoFracionado;
		}
		/**
		 * @param eUnidadePedidoFracionado the eUnidadePedidoFracionado to set
		 */
		public void setEUnidadePedidoFracionado(Boolean eUnidadePedidoFracionado) {
			this.eUnidadePedidoFracionado = eUnidadePedidoFracionado;
		}
		/**
		 * @return the eUnidadePedidoUnitaria
		 */
		public Boolean getEUnidadePedidoUnitaria() {
			return eUnidadePedidoUnitaria;
		}
		/**
		 * @param eUnidadePedidoUnitaria the eUnidadePedidoUnitaria to set
		 */
		public void setEUnidadePedidoUnitaria(Boolean eUnidadePedidoUnitaria) {
			this.eUnidadePedidoUnitaria = eUnidadePedidoUnitaria;

		}
		/**
		 * @return the eGerenciadoPorLote
		 */
		public Boolean getEGerenciadoPorLote() {
			return eGerenciadoPorLote;
		}
		/**
		 * @param eGerenciadoPorLote the eGerenciadoPorLote to set
		 */
		public void setEGerenciadoPorLote(Boolean eGerenciadoPorLote) {
			this.eGerenciadoPorLote = eGerenciadoPorLote;
		}
		/**
		 * @return the temMultiplosLotes
		 */
		public Boolean getTemMultiplosLotes() {
			return temMultiplosLotes;
		}
		/**
		 * @param temMultiplosLotes the temMultiplosLotes to set
		 */
		public void setTemMultiplosLotes(Boolean temMultiplosLotes) {
			this.temMultiplosLotes = temMultiplosLotes;
		}
		/**
		 * @return the temLoteUnico
		 */
		public Boolean getTemLoteUnico() {
			return temLoteUnico;
		}
		/**
		 * @param temLoteUnico the temLoteUnico to set
		 */
		public void setTemLoteUnico(Boolean temLoteUnico) {
			this.temLoteUnico = temLoteUnico;
		}
		/**
		 * @return the semLoteAssociado
		 */
		public Boolean getSemLoteAssociado() {
			return semLoteAssociado;
		}
		/**
		 * @param semLoteAssociado the semLoteAssociado to set
		 */
		public void setSemLoteAssociado(Boolean semLoteAssociado) {
			this.semLoteAssociado = semLoteAssociado;
		}
		/**
		 * @return the precoBoitata
		 */
		public String getPrecoBoitata() {
			return precoBoitata;
		}
		/**
		 * @param precoBoitata the precoBoitata to set
		 */
		public void setPrecoBoitata(String precoBoitata) {
			this.precoBoitata = precoBoitata;
		}
		/**
		 * @return the precoEcommerce
		 */
		public String getPrecoEcommerce() {
			return precoEcommerce;
		}
		/**
		 * @param precoEcommerce the precoEcommerce to set
		 */
		public void setPrecoEcommerce(String precoEcommerce) {
			this.precoEcommerce = precoEcommerce;
		}
		/**
		 * @return the precoVA
		 */
		public String getPrecoVA() {
			return precoVA;
		}
		/**
		 * @param precoVA the precoVA to set
		 */
		public void setPrecoVA(String precoVA) {
			this.precoVA = precoVA;
		}
		/**
		 * @return the precoPDV
		 */
		public String getPrecoPDV() {
			return precoPDV;
		}
		/**
		 * @param precoPDV the precoPDV to set
		 */
		public void setPrecoPDV(String precoPDV) {
			this.precoPDV = precoPDV;
		}
		/**
		 * @return the precoSAP
		 */
		public String getPrecoSAP() {
			return precoSAP;
		}
		/**
		 * @param precoSAP the precoSAP to set
		 */
		public void setPrecoSAP(String precoSAP) {
			this.precoSAP = precoSAP;
		}
		/**
		 * @return the precoHMC
		 */
		public String getPrecoHMC() {
			return precoHMC;
		}
		/**
		 * @param precoHMC the precoHMC to set
		 */
		public void setPrecoHMC(String precoHMC) {
			this.precoHMC = precoHMC;
		}
		/**
		 * @return the temServico
		 */
		public Boolean getTemServico() {
			return temServico;
		}
		/**
		 * @param temServico the temServico to set
		 */
		public void setTemServico(Boolean temServico) {
			this.temServico = temServico;
		}
		/**
		 * @return the temGarantia
		 */
		public Boolean getTemGarantia() {
			return temGarantia;
		}
		/**
		 * @param temGarantia the temGarantia to set
		 */
		public void setTemGarantia(Boolean temGarantia) {
			this.temGarantia = temGarantia;
		}
		/**
		 * @return the eTop0
		 */
		public Boolean getETop0() {
			return eTop0;
		}
		/**
		 * @param eTop0 the eTop0 to set
		 */
		public void setETop0(Boolean eTop0) {
			this.eTop0 = eTop0;
		}
		/**
		 * @return the eTop1
		 */
		public Boolean getETop1() {
			return eTop1;
		}
		/**
		 * @param eTop1 the eTop1 to set
		 */
		public void setETop1(Boolean eTop1) {
			this.eTop1 = eTop1;
		}
		/**
		 * @return the eTop2
		 */
		public Boolean getETop2() {
			return eTop2;
		}
		/**
		 * @param eTop2 the eTop2 to set
		 */
		public void setETop2(Boolean eTop2) {
			this.eTop2 = eTop2;
		}
		/**
		 * @return the eTop3
		 */
		public Boolean getETop3() {
			return eTop3;
		}
		/**
		 * @param eTop3 the eTop3 to set
		 */
		public void setETop3(Boolean eTop3) {
			this.eTop3 = eTop3;
		}
		/**
		 * @return the eTop4
		 */
		public Boolean getETop4() {
			return eTop4;
		}
		/**
		 * @param eTop4 the eTop4 to set
		 */
		public void setETop4(Boolean eTop4) {
			this.eTop4 = eTop4;
		}
		/**
		 * @return the eTop5
		 */
		public Boolean getETop5() {
			return eTop5;
		}
		/**
		 * @param eTop5 the eTop5 to set
		 */
		public void setETop5(Boolean eTop5) {
			this.eTop5 = eTop5;
		}
		/**
		 * @return the temEstoqueLoja
		 */
		public Boolean getTemEstoqueLoja() {
			return temEstoqueLoja;
		}
		/**
		 * @param temEstoqueLoja the temEstoqueLoja to set
		 */
		public void setTemEstoqueLoja(Boolean temEstoqueLoja) {
			this.temEstoqueLoja = temEstoqueLoja;
		}
		/**
		 * @return the temEstoqueCentralDistribuicao
		 */
		public Boolean getTemEstoqueCentralDistribuicao() {
			return temEstoqueCentralDistribuicao;
		}
		/**
		 * @param temEstoqueCentralDistribuicao the temEstoqueCentralDistribuicao to set
		 */
		public void setTemEstoqueCentralDistribuicao(Boolean temEstoqueCentralDistribuicao) {
			this.temEstoqueCentralDistribuicao = temEstoqueCentralDistribuicao;
		}
		/**
		 * @return the estoqueLoja
		 */
		public String getEstoqueLoja() {
			return estoqueLoja;
		}
		/**
		 * @param estoqueLoja the estoqueLoja to set
		 */
		public void setEstoqueLoja(String estoqueLoja) {
			this.estoqueLoja = estoqueLoja;
		}
		/**
		 * @return the estoqueCentralDistribuicao
		 */
		public String getEstoqueCentralDistribuicao() {
			return estoqueCentralDistribuicao;
		}
		/**
		 * @param estoqueCentralDistribuicao the estoqueCentralDistribuicao to set
		 */
		public void setEstoqueCentralDistribuicao(String estoqueCentralDistribuicao) {
			this.estoqueCentralDistribuicao = estoqueCentralDistribuicao;
		}
		/**
		 * @return the fluxoSaida
		 */
		public String getFluxoSaida() {
			return fluxoSaida;
		}
		/**
		 * @param fluxoSaida the fluxoSaida to set
		 */
		public void setFluxoSaida(String fluxoSaida) {
			this.fluxoSaida = fluxoSaida;
		}
		/**
		 * @return the dataInclusao
		 */
		public String getDataInclusao() {
			return dataInclusao;
		}
		/**
		 * @param dataInclusao the dataInclusao to set
		 */
		public void setDataInclusao(String dataInclusao) {
			this.dataInclusao = dataInclusao;
		}
		/**
		 * @return the dataAlteracao
		 */
		public String getDataAlteracao() {
			return dataAlteracao;
		}
		/**
		 * @param dataAlteracao the dataAlteracao to set
		 */
		public void setDataAlteracao(String dataAlteracao) {
			this.dataAlteracao = dataAlteracao;
		}
		/**
		 * @return the estaAtivo
		 */
		public Boolean getEstaAtivo() {
			return estaAtivo;
		}
		/**
		 * @param estaAtivo the estaAtivo to set
		 */
		public void setEstaAtivo(Boolean estaAtivo) {
			this.estaAtivo = estaAtivo;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String strOut = String.format("INDEX: %s / %s      PROJECT ID: %s : ID : %s : MATERIAL: %s : LOJA: %s : NOME: %s : DESC : %s : É FRAC : %s : É UN : %s : É Ger.Por Lote: %s : Tem Multiplos Lotes: %s : Tem Lote Unico: %s : POSSUI SERVICO: %s : POSSUI GARANTIA: %s",
					indexRow,outputData.size(),getIdProject(),getID(),getLmMaterial(),getLojaMaterial(),
					getLmNomeMaterial(),getLmDescricaoMaterial(),
					getEUnidadePedidoFracionado(),getEUnidadePedidoUnitaria(),
					getEGerenciadoPorLote(),getTemMultiplosLotes(),getTemLoteUnico(),
					getTemServico(),getTemGarantia()
					);
			return strOut;
		}
		
	}


	public static enum AUT_TEST_STATUS_EXECUCAO{
		WAIT,
		PASSED,
		FAILED,
		ERROR,
		EXECUTION;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ERROR:{
				return "ERRO";
			}
			case EXECUTION:{
				return "EXECUTANDO";
			}
			case FAILED:{
				return "FALHOU";
			}
			case PASSED:{
				return "PASSOU";
			}
			case WAIT:{
				return "AGUARDANDO";
			}
			}
			return super.toString();
		}
	}

	public static enum AUT_SYNC_EXECUTION_STATE{
		UPDATE_TABLE_PROJECT_DETAIL_WAIT,
		UPDATE_TABLE_PROJECT_DETAIL_PASSED,
		UPDATE_TABLE_PROJECT_DETAIL_EXECUTANDO,
		UPDATE_TABLE_PROJECT_DETAIL_ERRO,
		UPDATE_TABLE_PROJECT_DETAIL_FAILED,
		WAIT,
		PASSED,
		EXECUTION,
		ERROR,
		FAILED;

		@Override
		public String toString() {
			// TODO Auto-generated method stub

			switch(this) {
			case UPDATE_TABLE_PROJECT_DETAIL_PASSED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='PASSOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_FAILED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='FALHOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_ERRO:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='ERRO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_EXECUTANDO:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='EXECUTANDO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_WAIT:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='AGUARDANDO EXECUÇÃO' WHERE STD_ITEM_CONFIGURATION=?  AND PJT_ID IN(%s);";
			}
			case PASSED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='PASSOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case FAILED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='FALHOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case ERROR:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='ERRO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case EXECUTION:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='EXECUTANDO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case WAIT:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='AGUARDANDO EXECUÇÃO' WHERE STD_ITEM_CONFIGURATION=?  AND PJT_ID=?;";
			}
			}
			return super.toString();
		}
	}

	public <TObjectTest extends com.borland.silktest.jtf.xbrowser.DomElement> TObjectTest autSearchObject(TObjectTest container,String elementoJTF,String expressaoPesquisa,String expressaoSelecionarSubItem){
		java.util.List<TestObject> ltChild = null;
		java.util.regex.Pattern regExp = java.util.regex.Pattern.compile(expressaoPesquisa);
		java.util.regex.Pattern regExpChild = java.util.regex.Pattern.compile(expressaoSelecionarSubItem);
		java.util.regex.Matcher verif = null;

		verif=regExp.matcher(expressaoPesquisa);
		if(verif.find()) {
			ltChild = container.findAll(String.format("//%s",elementoJTF));
			for(TestObject it : ltChild) {
				Object chObj = it.getProperty("outerHTML");
				java.util.regex.Matcher verifChild = regExpChild.matcher(chObj.toString());
				if(verifChild.find()) {					
					System.out.println(it.getProperty("outerHTML"));
					DomElement itemChild = (DomElement) it;
					return (TObjectTest) itemChild;
				}
			}
		}

		
		return null;
	}
	
	
	public <TObjectTest extends java.util.List<com.borland.silktest.jtf.xbrowser.DomElement>,TChildItem extends com.borland.silktest.jtf.xbrowser.DomElement> TChildItem autSearchObject(TObjectTest container,String elementoJTF,String expressaoPesquisa,String expressaoSelecionarSubItem){
		java.util.List<TestObject> ltChild = null;
		java.util.regex.Pattern regExp = java.util.regex.Pattern.compile(expressaoPesquisa);
		java.util.regex.Pattern regExpChild = java.util.regex.Pattern.compile(expressaoSelecionarSubItem);
		java.util.regex.Matcher verif = null;

		for(DomElement domItem : container) {
			verif=regExp.matcher(domItem.getProperty("outerHTML").toString());
			System.out.println(domItem.getProperty("outerHTML").toString());
			if(verif.find()) {
				ltChild = domItem.findAll(String.format("//%s",elementoJTF));
				for(TestObject it : ltChild) {
					Object chObj = it.getProperty("outerHTML");
					java.util.regex.Matcher verifChild = regExpChild.matcher(chObj.toString());
					if(verifChild.find()) {					
						System.out.println(it.getProperty("outerHTML"));
						DomElement itemChild = (DomElement) it;
						return (TChildItem) itemChild;
					}
				}
			}			
		}

		
		return null;
	}
	public void autSetMicrosoftEdgeBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.Edge);		
	}	

	/**
	 * Retorna a data atual do sistema
	 * 
	 * @return String - data atual do sistema
	 * 
	 */
	public String autGetDateNow() {
		java.util.Calendar cld = java.util.Calendar.getInstance();
		String dia = (cld.get(cld.DAY_OF_MONTH) < 10 ? String.format("0%s", cld.get(cld.DAY_OF_MONTH)) : cld.get(cld.DAY_OF_MONTH)).toString();
		String mes = (cld.get(cld.MONTH) < 10 ? String.format("0%s", cld.get(cld.MONTH)) : cld.get(cld.MONTH)).toString();
		Integer ano = cld.get(cld.YEAR);
		String data = String.format("%s/%s/%s", dia,mes,ano);
		
		return data;
	}
	
	/**
	 * Retorna a data atual do sistema
	 * 
	 * @return String - data atual do sistema
	 * 
	 */
	public String autGetDateNow(String caractereReplaceDate) {
		return autGetDateNow().replaceAll("/", caractereReplaceDate);
	}
	
	/**
	 * 
	 * Retorna a hora atual do sistema
	 * 
	 * @return String - Hora atual do sistema
	 * 
	 */
	public String autGetTimeNow() {
		java.util.Calendar cld = java.util.Calendar.getInstance();
		String hora = (cld.get(cld.HOUR) < 10 ? String.format("0%s", cld.get(cld.HOUR)) : cld.get(cld.HOUR)).toString();
		String minuto = (cld.get(cld.MINUTE) < 10 ? String.format("0%s", cld.get(cld.MINUTE)) : cld.get(cld.MINUTE)).toString();
		String segundo = (cld.get(cld.SECOND) < 10 ? String.format("0%s", cld.get(cld.SECOND)) : cld.get(cld.SECOND)).toString();
		String time = String.format("%s:%s:%s", hora,minuto,segundo);
		
		return time;
	}

	/**
	 * 
	 * Retorna a hora atual do sistema
	 * 
	 * @return String - Hora atual do sistema
	 * 
	 */
	public String autGetTimeNow(String caractereReplaceDate) {
		return autGetTimeNow().replaceAll(":", caractereReplaceDate);
	}
	
	/**
	 * 
	 * Retorna a data e hora atual do sistema
	 * 
	 * @return String - Hora atual do sistema
	 * 
	 */
	public String autGetDateAndTime() {
		return autGetDateNow().concat(" ").concat(autGetTimeNow());
	}
	
	/**
	 * 
	 * Retorna a data e hora atual do sistema
	 * 
	 * @return String - Hora atual do sistema
	 * 
	 */
	public String autGetDateAndTime(String caractereReplaceDate,String caractereReplaceTime) {
		return autGetDateNow().replaceAll("/", caractereReplaceDate).concat(" ").concat(autGetTimeNow().replaceAll(":", caractereReplaceTime));
	}
	
	public void autSetInternetExplorerBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.InternetExplorer);
	}


	public void autSetFirefoxBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.Firefox);
	}

	public void autSetChromeBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
	}

	public boolean autScrollPage() {
		try {
			AUT_AGENT_SILK4J.<BrowserWindow>find("//BrowserApplication//BrowserWindow").executeJavaScript("window.scroll(0,100000)");
			return true;
		}
		catch(java.lang.Exception e) {
			return false;
		}
	}
	
	public boolean autScrollPage(Integer coordenadaX,Integer coordenadaY) {
		try {
			AUT_AGENT_SILK4J.<BrowserWindow>find("//BrowserApplication//BrowserWindow").executeJavaScript(String.format("window.scroll(%s,%s)",coordenadaX,coordenadaY));
			return true;
		}
		catch(java.lang.Exception e) {
			return false;
		}
	}
	
	public boolean autSetCurrentDataFlowObject(AUTDataFlow newDataflow) {
		try {

			AUT_CURRENT_DATA_FLOW = autGetDataFlow().autCopyDataFlow(autGetDataFlow(), newDataflow);
			System.out.println("AUT : DATAFLOW : SET CURRENT OBJECT : OK");

			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT : ERROR: DATAFLOW : SET CURRENT OBJECT");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 
	 * Retorna a instancia de gerenciamento de logs sistema
	 * 
	 * @return AUTLogMensagem - Classe de gerenciamento de Log
	 * 
	 */
	public AUTLogMensagem autGetLogManager()
	{
		try {

			System.out.println("AUT INFO: INICIALIZANDO SERVIÇO PARA GERENCIAMENTO DE LOGS DO SISTEMA");

			AUT_CURRENT_LOG_MANAGER = ( AUT_CURRENT_LOG_MANAGER!=null ? AUT_CURRENT_LOG_MANAGER : new AUTLogMensagem());

			return AUT_CURRENT_LOG_MANAGER;
		}
		catch(java.lang.Exception e) {

			System.out.println("AUT ERROR : ERROR INICIALIZAR SERVIÇO DE LOG");

			return null;
		}

	}	

	public void autSetHostExecution(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
	}


	/**
	 * 
	 * Configura ou retorna a instância ativa da classe de gerenciamento do fluxo de dados da automação
	 * 
	 * @return boolean - True caso o processo seja finalizado com sucesso false caso contrário
	 * 
	 */
	public AUTDataFlow autGetDataFlow() {
		try {

			autGetLogManager().logMensagem("AUT INFO: INICIALIZANDO CONFIGURAÇAO DO FLUXO DE DADOS");

			AUT_CURRENT_DATA_FLOW = (AUT_CURRENT_DATA_FLOW != null ? AUT_CURRENT_DATA_FLOW :  new AUTDataFlow());

			autGetLogManager().logMensagem("AUT INFO: CONFIGURAÇAO DO FLUXO DE DADOS : FINALIZADA");

			return AUT_CURRENT_DATA_FLOW;
		}
		catch(java.lang.Exception e) {

			autGetLogManager().logMensagem("AUT ERROR: INICIALIZAÇÃO DA CLASSE DE GERENCIAMENTO FLUXO DE DADOS");

			return null;
		}
	}



	public void selectValor (DomListBox listCombo) {

		String valor = null;
		int contador=0;

		List<ItemIdentifier> list = listCombo.getItems();

		for(ItemIdentifier item:listCombo.getItems()) {

			if (item.getText()  != null) {
				valor = item.getText();
				break;
			}
		}

		listCombo.select(valor);

	}


	public void selectValor (DomListBox listCombo, String criterioSelecao) {

		String valor = null;

		List<ItemIdentifier> list = listCombo.getItems();

		for(ItemIdentifier item : listCombo.getItems()) {
			System.out.println(item.getText());
			if(item.getText() != null && item.getText().trim() != "") {
				java.util.regex.Pattern padrao = java.util.regex.Pattern.compile(criterioSelecao);
				java.util.regex.Matcher analise = padrao.matcher(item.getText());

				if(analise.find()) {
					valor = item.getText();
					System.out.println(valor);
					listCombo.select(valor);
					break;			
				}
			}
		}
	}


	public Double autGetDiv(String valueInput) {
		String vlInput = valueInput;
		String[] vlParts = valueInput.trim().split(",");		
		Double dbValor = Double.parseDouble(vlParts[0]);
		Double result = dbValor / 2;

		System.out.println(valueInput);
		System.out.println(dbValor);
		System.out.println(vlParts[1]);
		System.out.println(result);
		System.out.println(result * 2);

		return result * 10000;
	}

	public Object autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName) {
		AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;
		return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(tableName.toString()).get(1).get(parameterName);
	}
	
	public Object autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName,Integer rowItem) {
		AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;
		return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(tableName).get(rowItem).get(parameterName);
	}

	public Object autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName) {
		AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;
		return autGetParametersFromDataFlow(tableName,parameterName);
	}
	
	/**
	 * 
	 * Recupera o valor do parametro especificado na fonte de dados corrente
	 * 
	 * @param parameterName - Nome do parametro
	 * 
	 * @return Object - Valor do parametro
	 */
	public Object autGetParametersFromDataFlow(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName) {
		try {
			return autGetDataFlow().autGetParametersFromTable(tableName, parameterName);
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "";
		}
	}

	public boolean autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName,Object value) {
		
		return autSetCurrentParameter(tableName, parameterName, value,1);
		
	}
	
	public boolean autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName,Object value,Integer rowChange) {
		try {

			AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;
			
			/*
			AUTRuntimeExecutionScenario scn = autGetCurrentScenarioRuntime();
			scn.AUT_DATAFLOW_SEARCH_KEY=tableName;
			
			if(scn.AUT_SCENARIO_FULL_NAME!=null) {
				java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("\\d+");
				java.util.regex.Matcher verif = regExp.matcher(scn.AUT_PROJECT_ID);
				if(verif.find()) {
					java.lang.Enum op = (java.lang.Enum)scn.AUT_DATAFLOW_SEARCH_KEY;
					Integer id = Integer.parseInt(verif.group());
					java.util.HashMap<String,Object> parameters = new java.util.HashMap<String,Object>();					
					parameters.put("PROJECT_ID", id);
					parameters.put("PROCESS_NAME", "%".concat(System.getenv("USERDOMAIN")));
					parameters.put("COLUMN_NAME", br.stk.framework.db.management.AUTDBProcessDataFlow.AUT_SQL_PROPERTIES.DRV_PARAMETER_NAME);
					parameters.put("COLUMN_TARGET", parameterName);
					parameters.put("COLUMN_VALUE", value);

					autGetDataFlowDBIntegration().autUpdateParameters(parameters);					
				}			
			}
			*/
			autGetDataFlowDBIntegration().autStartDefaultConnection();
			
			autGetDataFlowDBIntegration().autExecSubStatements("update lry.aut_projects_process_datadrivers set drv_parameter_value=? where drv_process_name like ? and drv_parameter_name=?;", new Object[] {value,"%".concat(System.getenv("USERDOMAIN")).concat("%"),parameterName});
			return true;
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: SET PARAMETER VALUE FROM CURRENT DATATABLE");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * 
	 * Retorna o valor do parametro especificado na tabela de parametros atualmente selecionada
	 * 
	 * @param parameterName - Nome do parametro
	 * 
	 * @return Object - Valor do objeto
	 * 
	 */
	public Object autGetCurrentParameter(String parameterName) {
		try {
			return autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME, parameterName);			
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");
			return null;
		}
	}

	public boolean autSetCurrentParameter(String parameterName,Object value) {
		try {
			autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME,parameterName,value);
			return true;
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: SET PARAMETER VALUE FROM CURRENT DATATABLE");
			return false;
		}
	}


	public junit.framework.TestCase autStartNewTestObject(Class<?> testObject,String testName){
		try {

			junit.framework.TestCase testItem = (TestCase) org.junit.runners.AllTests.testFromSuiteMethod(testObject);
			testItem.setName(testName);
			junit.textui.TestRunner.run(testItem);
			return testItem;

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			autGetLogManager().logMensagem("AUT ERROR: TEST OBJECT DEFINITION : ".concat(e.getMessage()));

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * Inicializa aplicação da aplicaçao VA
	 * 
	 */
	public void autInitWebApplication() {		
		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("va.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		AUT_AGENT_SILK4J.<BrowserApplication>find("VA").maximize();
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationBoitata() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("boitata.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");

		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);	
		AUT_AGENT_SILK4J.<BrowserApplication>find("VA").maximize();
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationHMC() {		
		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("hmc.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try {


		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationSafe() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("safe.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try {
			//AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationVA() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();		
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");

		AUT_BASE_STATE_CONFIGURATION_BROWSER.setUrl(autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_URL_VA").toString());
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		try {
			AUT_AGENT_SILK4J.<BrowserApplication>find("VA").maximize();
			//AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitHmcApplication() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();

		AUT_BASE_STATE_CONFIGURATION_BROWSER.setUrl(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_URL").toString());

		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try{
			AUT_AGENT_SILK4J.<AccessibleControl>find("HMC.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}




	/**
	 * 
	 * Finaliza a aplicação utilizada na automação
	 * 
	 */
	public void autCloseApplication() {

		System.out.println("AUT INFO: FINALIZANDO APLICAÇÃO");	
		AUT_AGENT_SILK4J.<BrowserApplication>find("VA").close();

	}

	public AUTBaseComponent() {
		super();
		autGetDataFlow().autInitDataFlow();
	}

	public AUTBaseComponent(boolean syncronizeDataFlow) {
		super();
	}

	
	/**
	 * 
	 * Altera o conteudo do elemento via SetText + Type
	 * 
	 * - Tratamento para parametros com vários caracteres
	 * 
	 * @param content - Conteúdo do campo
	 * @param objTest - Objeto alvo da alteração
	 * 
	 */
	public void autSetContentWebTypeViaSetText(String content,DomElement objTest) {
		Character chrItem = null;
		for(Character chr : content.toCharArray()) {
			chrItem = chr;
		}
		objTest.setFocus();
		objTest.setProperty("value", content.substring(0, content.length()-1));
		objTest.typeKeys(chrItem.toString());
	}
}
