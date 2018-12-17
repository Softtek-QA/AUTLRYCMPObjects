/**
 * 
 */
package br.lry.components.safe;

import br.lry.components.AUTBaseComponent;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

/**
 * Gerencia componentes e funções reutilizaveis para o safe
 * 
 * @author Softtek-QA
 *
 */
public class AUTSafeBaseComponent extends AUTBaseComponent {
	public boolean AUT_ENABLE_LOGIN_INIT = true;
	public static enum AUT_SAFE_LOJAS_ENUM{
		LJ0001,
		LJ0002,
		LJ0003,
		LJ0005,
		LJ0007,
		LJ0009,
		LJ0010,
		LJ0011,
		LJ0012,
		LJ0013,
		LJ0015,
		LJ0017,
		LJ0018,
		LJ0021,
		LJ0022,
		LJ0023,
		LJ0024,
		LJ0026,
		LJ0028,
		LJ0029,
		LJ0032,
		LJ0033,
		LJ0034,
		LJ0035,
		LJ0036,
		LJ0037,
		LJ0038,
		LJ0039,
		LJ0041,
		LJ0042,
		LJ0043,
		LJ0044,
		LJ0045,
		LJ0046,
		LJ0055,
		LJ0058,
		LJ9999;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case LJ0001:{
				return "0001 - LOJA_0001 INTER";
			}
			case LJ0002:{
				return "0002 - LOJA_0002 R PRE";
			}
			case LJ0003:{
				return "0003 - LOJA 0003 D PED";
			}
			case LJ0005:{
				return "0005 - LOJA-0005 RAPOS";
			}
			case LJ0007:{
				return "0007 - LOJA_0007 R NOR";
			}
			case LJ0009:{
				return "0009 - LOJA_0009 CURIT";
			}
			case LJ0010:{
				return "0010 - LOJA-0010 SCS";
			}
			case LJ0011:{
				return "0011 - LOJA_0011 R BAR";
			}
			case LJ0012:{
				return "0012 - LOJA_0012 MORUM";
			}
			case LJ0013:{
				return "0013 - LOJA_0013 B SUL";
			}
			case LJ0015:{
				return "0015 - LOJA_0015 SJC";
			}
			case LJ0017:{
				return "0017 - LOJA_0017 BANGU";
			}
			case LJ0018:{
				return "0018 - LOJA_0018 GOIAN";
			}
			case LJ0021:{
				return "0021 - LOJA-0021 NITER";
			}
			case LJ0022:{
				return "0022 - LOJA_0022 ANHAN";
			}
			case LJ0023:{
				return "0023 - LOJA-0023 TAGUA";
			}
			case LJ0024:{
				return "0024 - LOJA_0024 LAR C";
			}
			case LJ0026:{
				return "0026 - LOJA_0026 JACAR";
			}
			case LJ0028:{
				return "0028 - LOJA-0028 BRASI";
			}
			case LJ0029:{
				return "0029 - LOJA_0029 UBERL";
			}
			case LJ0032:{
				return "0032 - LOJA_0032 SAOLE";
			}
			case LJ0033:{
				return "0033 - LOJA_033 LONDR";
			}
			case LJ0034:{
				return "0034 - LOJA_0034 SJRP";
			}
			case LJ0035:{
				return "0035 - LOJA 0035 ATUBA";
			}
			case LJ0036:{
				return "0036 - LOJA_0036 BH NO";
			}
			case LJ0037:{
				return "0037 - CD_0037 CAJAMAR";
			}
			case LJ0038:{
				return "0038 - LOJA_0038 FORTA";
			}
			case LJ0039:{
				return "0039 - LOJA_0039 S JOS";
			}
			case LJ0041:{
				return "0041 - LOJA_0041";
			}
			case LJ0042:{
				return "0042 - LOJA_0042 JAGUA";
			}
			case LJ0043:{
				return "0043 - E-CO_0043 ECOME";
			}
			case LJ0044:{
				return "0044 - LOJA_0044 C.GRA";
			}
			case LJ0045:{
				return "0045 - LOJA-0045 S BER";
			}
			case LJ0046:{
				return "0046 - LOJA_0046 TAMB";
			}
			case LJ0055:{
				return "0055 - LOJA_0055 TAUBA";
			}
			case LJ0058:{
				return "0058 - LOJA-0058 TIETE";
			}
			case LJ9999:{
				return "9999 - LOJA-9999 MATRI";
			}
			default:{
				return this.name();
			}
			}
		}
	}
	
	
	public static enum AUT_SAFE_TYPE_PERSONS{
		FISICA,
		FISICA2,
		JURIDICA,
		JURIDICA2,
		ESTRANGEIRO,
		RNE,
		PASSAPORTE;		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case JURIDICA2:{
				return "Jurídica";
			}
			case ESTRANGEIRO:{
				return "Estrangeiro";
			}
			case FISICA:{
				return "Físico";
			}
			case FISICA2:{
				return "Física";
			}
			case  JURIDICA:{
				return "Jurídico";
			}
			case PASSAPORTE:{
				return "Passaporte";
			}
			case RNE:{				
				return "RNE";
			}
			default:{
				return this.name();
			}
			}
		}
	}

	public static enum AUT_SAFE_PROFISSOES{
		ARQUITETO,
		DECORADOR,
		ENGENHEIRO;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ARQUITETO:{
				return "2 - ARQUITETO";
			}
			case DECORADOR:{
				return "3 - DECORADOR";
			}
			case ENGENHEIRO:{
				return "1 - ENGENHEIRO";
			}
			default:{
				return this.name();
			}
			}
		}
	}
	

	
	public static enum AUT_SAFE_TIPO_CONVENIO{
		ACORDO_EXTRAJUDICIAL,
		CHEQUE_PRESENTE,
		CLIENTE_EM_CONTA,
		CLUBE_DO_ESPECIALISTA,
		COLABORADOR,
		CONSTRUTORA,
		GIFT_CARD,
		REEMISSAO_VOUCHER_EXPIRADO,
		SAFE_E_S,
		SALDAO_SOLIDARIO,
		VALE_GEMCO_EXPIRADO;
		
		@Override
		public String toString() {
			switch(this) {
			case ACORDO_EXTRAJUDICIAL:{
				return "ACORDO EXTRAJUDICIAL";
			}
			case CHEQUE_PRESENTE:{
				return "CHEQUE PRESENTE";
			}
			case CLIENTE_EM_CONTA:{
				return "CLIENTE EM CONTA";
			}
			case CLUBE_DO_ESPECIALISTA:{
				return "CLUBE DO ESPECIALISTA";
			}
			case COLABORADOR:{
				return "COLABORADOR";
			}
			case CONSTRUTORA:{
				return "CONSTRUTORA";
			}
			case GIFT_CARD:{
				return "GIFT CARD";
			}
			case REEMISSAO_VOUCHER_EXPIRADO:{
				return "REEMISSAO VOUCHER EXPIRADO";
			}
			case SAFE_E_S:{
				return "SAFE E/S";
			}
			case SALDAO_SOLIDARIO:{
				return "SALDAO SOLIDARIO";
			}
			case VALE_GEMCO_EXPIRADO:{
				return "VALE GEMCO EXPIRADO";
			}
			default:{
				return this.name();
			}
			}
		}
	}
	
	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeBaseComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AUTSafeBaseComponent(boolean syncronizeDataFlow) {
		super(syncronizeDataFlow);
	}
	/**
	 * 
	 * Login padrão no SAFE que não executa rotinas de inicialização da aplicação
	 * 
	 * 
	 * @param usuario - Usuário SAFE
	 * @param senha - Senha SAFE
	 * 
	 */
	public void autLogin(String usuario, String senha) {
		AUT_ENABLE_LOGIN_INIT = true;
		autLoginWithInit(usuario,senha);
	}
	
	
	/**
	 * 
	 * Executa procedimentos de login  no SAFE
	 * 
	 * @param usuario - Usuario SAFE
	 * @param senha - Senha SAFE
	 * 
	 */
	public void autLoginWithInit(String usuario, String senha) {
				
		AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE").maximize();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomButton>find("SAFE.Login.BotaoEntrar").click();
	}
}
