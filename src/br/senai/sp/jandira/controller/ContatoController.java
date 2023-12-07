package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Contato;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoController {
    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();


    public String consultarContato() throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM contatos";

        ResultSet resultSet = statement.executeQuery(queryConsulta);
        List<Contato> listContatos = new ArrayList<>();

        while (resultSet.next()){
            Contato contato = new Contato();
            contato.setId(resultSet.getInt("id"));
            contato.setNome(resultSet.getString("nome"));
            contato.setEmail(resultSet.getString("email"));
            contato.setFoto(resultSet.getString("foto"));
            contato.setFavorito(resultSet.getBoolean("favorito"));
            contato.setTelefone(resultSet.getLong(
                    "telefone"));

            listContatos.add(contato);

        }

        Gson gson = new Gson();

        String json = gson.toJson(listContatos);
        return json;

    }

    public void pesquisarContato(){

    }

    public void deletarContato(String nome) throws SQLException {
        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM contatos WHERE nome='" + nome + "'";

        statement.executeUpdate(queryDelete);
        System.out.println("Contato" + nome + "Deletado com sucesso!");


    }
    public void cadastrarContato(Contato newContato) throws SQLException {
        Statement statement = connection.createStatement();
        String queryCadastro = "INSERT INTO contatos (id, nome, telefone" + "email, favorito, foto) values ("+ newContato.getId() + "," + newContato.getNome() + "," + newContato.getTelefone() + "," + newContato.getEmail() + "," + newContato.isFavorito() + "," + newContato.getFoto() + ")";

        try {
            statement.executeUpdate(queryCadastro);
            System.out.println("Contato Cadastrado com Seucesso!");
        }catch (Exception error){
            System.out.println(error);
        }


    }



}
