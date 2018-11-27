package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class REST {

	private Model model;

	public REST(Model store) {
		this.model = store;
	}

	public void getLogin() {

		get("/login/:username/:password", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				response.header("Access-Control-Allow-Origin", "*");

				try {
					Usuario usuario = model.login(request.params(":username"), request.params(":password"));

					if (usuario != null) {

						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();

						jsonObj.put("Email", usuario.getEmail());
						jsonObj.put("Senha", usuario.getSenha());

						jsonResult.put(jsonObj);

						return jsonResult;

					} else {

					}

				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("Email", 0);

				jsonResult.put(jsonObj);

				return jsonResult;

			}

		});

	}

	public void getDados() {

		get("/dados", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				response.header("Access-Control-Allow-Origin", "*");

				try {
					Dados dados = model.getDados();

					if (dados != null) {

						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("Dados", dados.getDados());

						jsonResult.put(jsonObj);

						return jsonResult;

					} else {

					}

				} catch (JSONException e) {

					// e.printStackTrace();

				}
				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("Dados", 0);

				jsonResult.put(jsonObj);

				return jsonResult;

			}
		});

	}
}
