package hello;

import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class Scrap {
	public static String resposta = "";

	public String Pesquisa() {

		try {
			UserAgent userAgent = new UserAgent();
			userAgent.settings.autoSaveAsHTML = true;
			// userAgent.visit("http://acontece.faap.br/eventos/acontece/"+local);
			// http://acontece.faap.br/eventos/acontece/sao_jose_dos_campos/eventos/2018-04
			userAgent.visit("http://acontece.faap.br/eventos/acontece/sao_paulo");
			com.jaunt.Elements horas = userAgent.doc.findEvery("<span class=\"horario\">");
			com.jaunt.Elements nomes = userAgent.doc.findEvery("<span class=\"organizador\">");
			com.jaunt.Elements titulos = userAgent.doc.findEvery("<p class=\"tit-descricao\">");
			for (int contador = 0; contador < horas.size(); contador++) {
				resposta += (" <br /> Titulo: " + titulos
						.getElement(contador).getTextContent().trim().replace("&#231;", "�").replace("&#245;", "�")
						.replace("&#186;", "�").replace("&#202;", "�").replace("&#195;", "�").replace("&quot;", "'")
						.replace("&#218;", "�").replace("&#244;", "�").replace("&#199;", "�").replace("&#192;", "�")
						.replace("&#193;", "�").replace("&#233;", "�").replace("&#227;", "�").replace("&#225;", "�")
						.replace("&#250;", "�").replace("&#227;", "�").replace("&#237;", "�").replace("&#243;", "�")
						.replace("&#224;", "�").replace("&#234;", "�").replace("&#170;", "�").replace("&#226;", "�")
						.replace("&#245;", "�").replace("&#211;", "�").replace("&#39;", "'").replace("&#201;", "�")
						+ " <br /> Nome: "
						+ nomes.getElement(contador).getTextContent().trim().replace("&#231;", "�")
								.replace("&#245;", "�").replace("&#186;", "�").replace("&#202;", "�")
								.replace("&#195;", "�").replace("&quot;", "'").replace("&#218;", "�")
								.replace("&#244;", "�").replace("&#199;", "�").replace("&#192;", "�")
								.replace("&#193;", "�").replace("&#233;", "�").replace("&#227;", "�")
								.replace("&#225;", "�").replace("&#250;", "�").replace("&#227;", "�")
								.replace("&#237;", "�").replace("&#243;", "�").replace("&#224;", "�")
								.replace("&#234;", "�").replace("&#170;", "�").replace("&#226;", "�")
								.replace("&#245;", "�").replace("&#211;", "�").replace("&#39;", "'")
								.replace("&#201;", "�")
						+ " <br /> --------------------------------------------------------------------------------------- <br /> ");
			}

		} catch (JauntException e) {
			System.err.println("Erro no arquivo do Jaunt");
		}
		return resposta;
	}
}