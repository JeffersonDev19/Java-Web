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
						.getElement(contador).getTextContent().trim().replace("&#231;", "ç").replace("&#245;", "õ")
						.replace("&#186;", "°").replace("&#202;", "Ê").replace("&#195;", "Ã").replace("&quot;", "'")
						.replace("&#218;", "Ú").replace("&#244;", "ô").replace("&#199;", "Ç").replace("&#192;", "À")
						.replace("&#193;", "Á").replace("&#233;", "é").replace("&#227;", "ã").replace("&#225;", "á")
						.replace("&#250;", "ú").replace("&#227;", "ã").replace("&#237;", "í").replace("&#243;", "ó")
						.replace("&#224;", "à").replace("&#234;", "ê").replace("&#170;", "ª").replace("&#226;", "â")
						.replace("&#245;", "õ").replace("&#211;", "Ó").replace("&#39;", "'").replace("&#201;", "É")
						+ " <br /> Nome: "
						+ nomes.getElement(contador).getTextContent().trim().replace("&#231;", "ç")
								.replace("&#245;", "õ").replace("&#186;", "°").replace("&#202;", "Ê")
								.replace("&#195;", "Ã").replace("&quot;", "'").replace("&#218;", "Ú")
								.replace("&#244;", "ô").replace("&#199;", "Ç").replace("&#192;", "À")
								.replace("&#193;", "Á").replace("&#233;", "é").replace("&#227;", "ã")
								.replace("&#225;", "á").replace("&#250;", "ú").replace("&#227;", "ã")
								.replace("&#237;", "í").replace("&#243;", "ó").replace("&#224;", "à")
								.replace("&#234;", "ê").replace("&#170;", "ª").replace("&#226;", "â")
								.replace("&#245;", "õ").replace("&#211;", "Ó").replace("&#39;", "'")
								.replace("&#201;", "É")
						+ " <br /> --------------------------------------------------------------------------------------- <br /> ");
			}

		} catch (JauntException e) {
			System.err.println("Erro no arquivo do Jaunt");
		}
		return resposta;
	}
}