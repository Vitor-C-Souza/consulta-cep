package service;

import model.DadoEndereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApiViaCep {
    private final String cep;

    public ConsumoApiViaCep(String cep) {
        this.cep = cep;
    }


    public DadoEndereco ConsultaCep() throws IOException, InterruptedException {
        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Desserializador desserializado = new Desserializador(response.body());

        return desserializado.desserializador();
    }
}
