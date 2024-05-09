package service;

import com.google.gson.Gson;
import exception.CepNotFoundException;
import model.DadoEndereco;
import model.DadoEnderecoError;

public class Desserializador {
    private final String body;

    public Desserializador(String body) {
        this.body = body;
    }

    public DadoEndereco desserializador() {
        Gson gson = new Gson();
        try {
            var errorCaption = gson.fromJson(this.body, DadoEnderecoError.class);

            if (errorCaption.erro()) {
                throw new CepNotFoundException("Endereço do cep não encontrado!!!");
            }

            var dadoDesserializado = gson.fromJson(this.body, DadoEndereco.class);
            System.out.println(dadoDesserializado);

            return dadoDesserializado;
        } catch (CepNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
