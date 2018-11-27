package hello;

import static spark.Spark.*;




import java.util.LinkedList;
import java.util.List;



public class MainServer {

	final static Model model = new Model();

    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

		
        
        initializeModel();
		
		staticFileLocation("/static");
		
		REST controller = new REST(model); 
		
		
		controller.getLogin();
		controller.getDados();
    }
	
    public static void initializeModel(){
    	
    	
    	
    	//Cadastro usuario
    	
    	Usuario usuario = new Usuario();
    	usuario.setEmail("teste@teste.com");
    	usuario.setSenha("teste");
    	model.insereUsuario(usuario);
    	
    	
    	//Dados coletados
    	
    	
    	Dados dados = new Dados();
    	Scrap scrap = new Scrap();
    	dados.setDados(scrap.Pesquisa());
    	model.insereDados(dados);
	}
	
}
