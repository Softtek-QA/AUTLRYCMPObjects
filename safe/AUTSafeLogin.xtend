package br.lry.components.safe

import org.junit.Test
import com.borland.silktest.jtf.xbrowser.DomElement
import com.borland.silktest.jtf.xbrowser.DomTextField
import br.lry.components.AUTBaseComponent

class AUTSafeLogin extends AUTBaseComponent {
	package java.util.HashMap<String, Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter()

	def void autLogin(String usuario, String senha) {
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.TelaLogin.Usuario").clearText()
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.TelaLogin.Usuario").setText(usuario)
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.TelaLogin.Senha").setText(senha)
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaLogin.Entar").click()
	}

	@Test def void autStartLoginDefault(String usuario, String senha) {
		try {
			autGetLogManager().logMensagem("AUT ERROR: LOGIN HMC APPLICATION: INIT")
			autInitHmcApplication()
			autLogin(usuario, senha)
		} catch (java.lang.Exception e) {
			System.out.println(e.getMessage())
			e.printStackTrace()
		}

	}

	override void autCloseApplication() {
	}
}
