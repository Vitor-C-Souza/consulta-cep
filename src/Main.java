import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.CepLenghtInvalidException;
import service.ConsumoApiViaCep;
import model.DadoEndereco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        
        try {
            System.out.println("Digite o cep que deseja consultar: ");
            String cep = read.nextLine().replace("-","");

            if (cep.length() != 8) {
                throw new CepLenghtInvalidException("Cep digitado invalido!!!");
            }
            ConsumoApiViaCep viaCep = new ConsumoApiViaCep(cep);

            DadoEndereco dadoEndereco = viaCep.ConsultaCep();

            if(!cep.equals("00000000")){
                FileWriter file = new FileWriter(cep + ".json");
                file.write(gson.toJson(dadoEndereco));
                file.close();
            }

        } catch (CepLenghtInvalidException e) {
            System.out.println(e.getMessage());
        }


    }
}