package model;

public record DadoEndereco(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        int ddd
) {
}
