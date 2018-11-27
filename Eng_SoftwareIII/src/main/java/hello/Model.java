package hello;

import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model {

	ObjectContainer dadosBD = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/dados.db4o");
	ObjectContainer usuarioBD = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/users.db4o");

	public boolean insereDados(Dados dados) {

		Query query = dadosBD.query();
		query.constrain(Dados.class);
		ObjectSet<Dados> todosDados = query.execute();

		for (Dados dado : todosDados) {
			dadosBD.delete(dado);
		}

		dadosBD.store(dados);
		dadosBD.commit();

		return true;
	}

	public boolean insereUsuario(Usuario usuario) {

		Query query = usuarioBD.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> todosUsuarios = query.execute();

		for (Usuario usuarios : todosUsuarios) {
			usuarioBD.delete(usuarios);
		}

		usuarioBD.store(usuario);
		usuarioBD.commit();

		return true;
	}

	public Usuario login(String username, String password) {
		Query query = usuarioBD.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> todosUsuarios = query.execute();

		for (Usuario usuarios : todosUsuarios) {
			if (usuarios.getEmail().equals(username) && usuarios.getSenha().equals(password)) {
				return usuarios;
			}

		}
		return null;

	}
	
	public Dados getDados() {
		Query query = dadosBD.query();
		query.constrain(Dados.class);
		ObjectSet<Dados> todosDados = query.execute();

		for (Dados dado : todosDados) {
			return dado;
		}
		return null;
	}
}