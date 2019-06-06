/**
 * 
 */
package br.lry.components.pdv;

import java.io.File;

import org.junit.Test;

import com.borland.silktest.jtf.BaseState;

import br.lry.components.AUTBaseComponent;
import br.lry.components.AUTBaseComponent.AUT_SYNC_EXECUTION_STATE;
import br.lry.components.pdv.linx.AUTPDVBaseComponent;
import br.lry.components.pdv.linx.AUTPDVBaseComponent.AUTPDVSyncProcess;
import br.lry.components.pdv.linx.AUTPDVLogin;
import br.lry.components.pdv.linx.AUTPDVLogout;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.process.AUTPDVConsultaPrecoItem;
import br.lry.process.AUTPDVPagamentoPedido;
import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;


/**
 * 
 * Componente base de serviços
 * 
 * @author Softtek-QA
 *
 */
public class AUTPDVBaseServices extends AUTBaseComponent {
	private br.lry.process.AUTPDVConsultaPrecoItem pdvConsultas = null;
	private br.lry.process.AUTPDVPagamentoPedido pdvPagamentos = null;
	private br.lry.process.AUTPDVDevolucaoItem pdvDevolucoes = null;
	private br.lry.components.pdv.linx.AUTPDVBaseComponent pdvBase = null;
	private AUTPDVAcessos pdvAccess = null;
	private AUTDataFlow autDataFlow = null;		
	
	public static class AUTPDVAcessos{
		private br.lry.components.pdv.linx.AUTPDVLogin pdvLogin = null;
		private br.lry.components.pdv.linx.AUTPDVLogout pdvLogout = null;
		private br.lry.components.AUTBaseComponent autSharedBaseComponent = null;
		
		/**
		 * Componente para gerenciamento de acesos do sistema PDV
		 * 
		 * @return br.lry.components.pdv.linx.AUTPDVLogin - Componente para gerenciamento de componentes de entrada no sistema
		 * 
		 */
		public <TPDVLogin extends br.lry.components.pdv.linx.AUTPDVLogin>  TPDVLogin autPDVLogin(){
			if(pdvLogin==null) {
				pdvLogin = new AUTPDVLogin();
				return (TPDVLogin) pdvLogin;
			}
			else {
				return (TPDVLogin) pdvLogin;
			}
		}
		
		/**
		 * Componente para gerenciamento de saídas do sistema
		 * 
		 * @return br.lry.components.pdv.linx.AUTPDVLogout- Logout
		 * 
		 */
		public <TPDVLogout extends br.lry.components.pdv.linx.AUTPDVLogout>  TPDVLogout autPDVLogouts(){
			if(pdvLogin==null) {
				pdvLogout = new AUTPDVLogout();
				return (TPDVLogout) pdvLogout;
			}
			else {
				return (TPDVLogout) pdvLogout;
			}
		}		
		
		/**
		 * 
		 * Inicia o processo de padrão no sistema
		 * 
		 * @param operador - Operador de loja
		 * @param senha - Senha do operador de loja
		 * 
		 */
		public void autPDVStartLogin(String operador,String senha) {
			AUT_AGENT_SILK4J = autPDVLogin().AUT_AGENT_SILK4J;
			java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
			parametrosConfig.put("AUT_OPERADOR", operador);
			parametrosConfig.put("AUT_PWD_OPERADOR", senha);
			autPDVLogin().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {
				
				@Override
				public void autStartProcess() {
					// TODO Auto-generated method stub
					autGetSharedBaseComponent().autInsertScreenByScenario();
				}
				
				@Override
				public void autStartParallelProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autInitProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autEndProcess() {
					// TODO Auto-generated method stub
					
				}
			};
			
			autPDVLogin().autStartLogin(operador, senha);
		}
		
		public void autPDVLoginDefault(java.util.HashMap<String, Object> parametros) {
			try {
				AUTBaseComponent bs = new AUTBaseComponent() {};
				//bs.autGetDataFlow().autInitDataFlow();
				
				autGetSharedBaseComponent().autInsertScreenByScenario();
				String operador = parametros.get("AUT_OPERADOR").toString();//bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR").toString();
				String pwd = parametros.get("AUT_PWD_OPERADOR").toString(); //bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR").toString();
				autPDVStartLogin(operador, pwd);				
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR : LOGIN PDV DEFAULT");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		public void autPDVLoginDefault() {
			try {
				AUTBaseComponent bs = new AUTBaseComponent() {};
				bs.autGetDataFlow().autInitDataFlow();
				
				autGetSharedBaseComponent().autInsertScreenByScenario();
				String operador = bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR").toString();
				String pwd = bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR").toString();
				autPDVStartLogin(operador, pwd);				
			}
			catch(java.lang.Exception e) {
				System.out.println("AUT ERROR : LOGIN PDV DEFAULT");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		public void autPDVStartLogout(String coordenador,String senha) {
			AUTBaseComponent bs = new AUTBaseComponent() {};
			bs.autGetDataFlow().autInitDataFlow();			
			autGetSharedBaseComponent().autInsertScreenByScenario();
			java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
			parametrosConfig.put("AUT_PWD_OPERADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
			parametrosConfig.put("AUT_COORDENADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));			
			autPDVLogouts().AUT_SYNC_PROCESS_EXECUTION=new AUTPDVSyncProcess() {
				
				@Override
				public void autStartProcess() {
					// TODO Auto-generated method stub
					autGetSharedBaseComponent().autInsertScreenByScenario();
				}
				
				@Override
				public void autStartParallelProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autInitProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autEndProcess() {
					// TODO Auto-generated method stub
					
				}
			};	
			
			autPDVLogouts().autPDVLogout(parametrosConfig.get("AUT_COORDENADOR").toString(), parametrosConfig.get("AUT_PWD_OPERADOR").toString());
		}
		
		public void autPDVLogoutDefault() {
			AUTBaseComponent dt = new AUTBaseComponent() {
			};
			
			String operador = dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR").toString();
			String pwd = dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR").toString();
			autPDVStartLogout(operador,pwd);
		}
		
		/**
		 * Retorna o componente de configuração compartilhado entre várias instâncias
		 * 
		 * 
		 * @return TBaseComponent - Componente que extende o item de configuração base do sistema
		 * 
		 */
		public <TBaseComponent extends br.lry.components.AUTBaseComponent> TBaseComponent autGetSharedBaseComponent() {			
			if(autSharedBaseComponent==null) {
				autSharedBaseComponent = new AUTBaseComponent() {
				};	
				return (TBaseComponent) autSharedBaseComponent;
			}
			else {
				return (TBaseComponent) autSharedBaseComponent;
			}			
		}
		
		/**
		 * 
		 * Construtor padrão da classe para gerenciamento de acesso do sistema
		 * 
		 * 
		 * @param bsComponent - Componente base de configuração
		 * 
		 */
		public <TBaseComponent extends br.lry.components.AUTBaseComponent> AUTPDVAcessos(TBaseComponent bsComponent) {
			autSharedBaseComponent = bsComponent;
		}
		
		public AUTPDVAcessos() {
			
		}
	}
	
	/**
	 * 
	 * Retorna o componente que gerencia os acessos no PDV
	 * 
	 * @return TPDVAccess - Componente para gerenciamento de acessos no PDV
	 * 
	 */
	public <TPDVAccess extends AUTPDVAcessos> TPDVAccess autPDVAcessos(){
		if(pdvAccess==null) {
			pdvAccess = new AUTPDVAcessos(this);
			return (TPDVAccess) pdvAccess;
		}
		else {
			return (TPDVAccess) pdvAccess;
		}
	}
	
	
	/**
	 * Retorna objeto para consulta de material
	 * 
	 * @return TPDVConsultas - Objeto para consulta de material que extende br.lry.process.AUTPDVConsultaPrecoItem
	 */
	public <TPDVConsultas extends br.lry.process.AUTPDVConsultaPrecoItem> TPDVConsultas autPDVConsultas(){		
		if(pdvConsultas==null) {
			pdvConsultas = new AUTPDVConsultaPrecoItem();
			return (TPDVConsultas)pdvConsultas;
		}
		else {
			return (TPDVConsultas)pdvConsultas;			
		}
	}
	
	/**
	 * 
	 * Retorna o gerenciador de parametros de entrada do sistema
	 * 
	 * @return TDataFlow - Classe que extends o dataflow herdado do componente base
	 * 
	 */
	public <TDataFlow extends AUTDataFlow> TDataFlow autGetCurrentDataFlow() {
		if(autDataFlow == null) {
			autDataFlow = autGetDataFlow();
			autDataFlow.autInitDataFlow();
			return (TDataFlow) autDataFlow;			
		}
		else {
			return (TDataFlow) autDataFlow;
		}
	}
	
	/**
	 * 
	 * Realiza a consulta de material do item especificado
	 * 
	 * @param material - LM do material para consulta
	 * 
	 */
	public void autStartConsulta(String material) {
		AUTBaseComponent bs = new AUTBaseComponent() {};
		bs.autGetDataFlow().autInitDataFlow();
		
		autInsertScreenByScenario();
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", material);
		parametrosConfig.put("AUT_OPERADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));
		parametrosConfig.put("AUT_PWD_COORDENADOR", bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_COORDENADOR"));
		autPDVConsultas().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {
			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		autPDVConsultas().autStartProcess(parametrosConfig);		
	}
		
	/**
	 * 
	 * Realiza a consulta de material o item cadastrado no dataflow
	 * 
	 */
	public void autStartConsultaDefault() {		
		AUTBaseComponent bs = new AUTBaseComponent() {};
		bs.autGetDataFlow().autInitDataFlow();
		autStartConsulta(bs.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM").toString());
	}

	public void autStartPagamentoPedido(String numeroPedido) {
		AUTBaseComponent dt = new AUTBaseComponent() {};
		autInsertScreenByScenario();
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM"));
		parametrosConfig.put("AUT_PEDIDO", Integer.parseInt(numeroPedido));		
		parametrosConfig.put("AUT_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));
		parametrosConfig.put("AUT_FLUXO_SAIDA", AUT_VA_FLUXO_SAIDA.CAIXA);
		autPDVPagamentos().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {
			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		autPDVPagamentos().autStartProcess(parametrosConfig);			
	}
	
	public void autStartPagamentoPedido(String numeroPedido,AUT_VA_FLUXO_SAIDA fluxoSaida) {
		AUTBaseComponent dt = new AUTBaseComponent() {};
		autPDVPagamentos().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {
			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM"));
		parametrosConfig.put("AUT_PEDIDO", Integer.parseInt(numeroPedido));		
		parametrosConfig.put("AUT_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));
		parametrosConfig.put("AUT_FLUXO_SAIDA", fluxoSaida.name());
		autPDVPagamentos().autStartProcess(parametrosConfig);	
	}
	
	public void autStartPagamentoPedido(java.util.HashMap<String, Object> parametros) {
		//AUTBaseComponent dt = new AUTBaseComponent() {};
		autPDVPagamentos().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {
			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", parametros.get("AUT_CODIGO_ITEM"));
		parametrosConfig.put("AUT_PEDIDO", Integer.parseInt(parametros.get("AUT_NUMERO_PEDIDO").toString()));		
		parametrosConfig.put("AUT_OPERADOR", parametros.get("AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", parametros.get("AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", parametros.get("AUT_COORDENADOR"));
		parametrosConfig.put("AUT_FLUXO_SAIDA",  parametros.get("AUT_FLUXO_SAIDA")); //fluxoSaida.name();
		autPDVPagamentos().autStartProcess(parametrosConfig);	
	}
	
	public void autStartDevolucaoItem(String numeroPedido) {
		AUTBaseComponent dt = new AUTBaseComponent() {};
		autInsertScreenByScenario();
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM"));
		parametrosConfig.put("AUT_PEDIDO", Integer.parseInt(numeroPedido));	
		parametrosConfig.put("AUT_LOJA_DEVOLUCAO","0035");
		Integer qtd = Integer.parseInt(dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_QUANTIDADE_ITEM").toString());			
		parametrosConfig.put("AUT_ITEM_QUANTIDADE",dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_QUANTIDADE_ITEM").toString());
		parametrosConfig.put("AU"
				+ "T_DD","11");
		parametrosConfig.put("AUT_TELEFONE","912123434");
		parametrosConfig.put("AUT_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));
		parametrosConfig.put("AUT_PWD_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_COORDENADOR"));
		parametrosConfig.put("AUT_FLUXO_SAIDA", AUT_VA_FLUXO_SAIDA.CAIXA.name());
		autPDVDevolucoes().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		autPDVDevolucoes().autStartProcess(parametrosConfig);			
	}
	
	public void autStartDevolucaoItem(String numeroPedido,AUT_VA_FLUXO_SAIDA fluxoSaida) {
		AUTBaseComponent dt = new AUTBaseComponent() {};
		autInsertScreenByScenario();
		java.util.HashMap<String,Object> parametrosConfig = new java.util.HashMap<String,Object>();
		parametrosConfig.put("AUT_MATERIAL", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM"));
		parametrosConfig.put("AUT_PEDIDO", Integer.parseInt(numeroPedido));	
		parametrosConfig.put("AUT_LOJA_DEVOLUCAO","0035");
		Integer qtd = Integer.parseInt(dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_QUANTIDADE_ITEM").toString());			
		parametrosConfig.put("AUT_ITEM_QUANTIDADE",dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_QUANTIDADE_ITEM").toString());
		parametrosConfig.put("AU"
				+ "T_DD","11");
		parametrosConfig.put("AUT_TELEFONE","912123434");
		parametrosConfig.put("AUT_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_OPERADOR"));
		parametrosConfig.put("AUT_PWD_OPERADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_OPERADOR"));
		parametrosConfig.put("AUT_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_COORDENADOR"));
		parametrosConfig.put("AUT_PWD_COORDENADOR", dt.autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_PDV_LINX, "AUT_PWD_COORDENADOR"));
		parametrosConfig.put("AUT_FLUXO_SAIDA", fluxoSaida.name());
		autPDVDevolucoes().AUT_SYNC_PROCESS_EXECUTION = new AUTPDVSyncProcess() {			
			@Override
			public void autStartProcess() {
				// TODO Auto-generated method stub
				autInsertScreenByScenario();
			}
			
			@Override
			public void autStartParallelProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autInitProcess() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void autEndProcess() {
				// TODO Auto-generated method stub
				
			}
		};
		autPDVDevolucoes().autStartProcess(parametrosConfig);			
	}
	
	/**
	 * 
	 * Retorna componente para gerenciamento de pedidos no PDV
	 * 
	 * @return br.lry.process.AUTPDVPagamentoPedido - Componente de pagamentos do PDV que extendem 
	 */
	public <TPDVPagamentos extends br.lry.process.AUTPDVPagamentoPedido> TPDVPagamentos autPDVPagamentos() {
		if(pdvPagamentos==null) {
			pdvPagamentos = new AUTPDVPagamentoPedido();
			pdvPagamentos.AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
			pdvPagamentos.AUT_AGENT_SILK4J_CONFIGURATION = new BaseState("pdv.settings");
			pdvPagamentos.AUT_AGENT_SILK4J.executeBaseState(pdvPagamentos.AUT_AGENT_SILK4J_CONFIGURATION);
			
			return (TPDVPagamentos)pdvPagamentos;
		}
		else {	
			return (TPDVPagamentos)pdvPagamentos;			
		}
	}

	/**
	 * Retorna o componente para gerenciamento de devoluções no PDV
	 * 
	 * @return TPDVDevolucoes - Componente para gerenciamento de devoluções no PDV
	 */
	public <TPDVDevolucoes extends br.lry.process.AUTPDVDevolucaoItem> TPDVDevolucoes autPDVDevolucoes() {
		if(pdvDevolucoes==null) {
			pdvDevolucoes = new br.lry.process.AUTPDVDevolucaoItem();
			pdvDevolucoes.AUT_AGENT_SILK4J = new com.borland.silktest.jtf.Desktop();
			pdvDevolucoes.AUT_AGENT_SILK4J_CONFIGURATION = new BaseState("pdv.settings");
			pdvDevolucoes.AUT_AGENT_SILK4J.executeBaseState(pdvPagamentos.AUT_AGENT_SILK4J_CONFIGURATION);
			
			return (TPDVDevolucoes)pdvDevolucoes;
		}
		else {
			return (TPDVDevolucoes)pdvDevolucoes;
		}
	}
	
	/**
	 * 
	 * Retorna o componente base do PDV
	 * 
	 * @return br.lry.components.pdv.linx.AUTPDVBaseComponent - Componente base do PDV
	 */
	public <TPDVBaseComponente extends br.lry.components.pdv.linx.AUTPDVBaseComponent> TPDVBaseComponente autPDVComponenteBase() {	
		if(pdvBase == null) {
			pdvBase = new AUTPDVBaseComponent();			
			return (TPDVBaseComponente) pdvBase;
		}
		else {
			return (TPDVBaseComponente) pdvBase;
		}		
	}
	
	/**
	 * 
	 * Executa procedimentos de configuração durante inicialização do sistema
	 * 
	 */
	public void autInitConfiguration() {
		autSetDesktopAgent(AUT_AGENT_SILK4J);
		BaseState bs = new BaseState(new File("AUT_AGENT_SILK4J"));
		bs.execute(AUT_AGENT_SILK4J);
	}
	
	/**
	 * 
	 * Construtor padrão da classe
	 */
	public AUTPDVBaseServices() {
		// TODO Auto-generated constructor stub
		//autInitConfiguration();
	}

}
