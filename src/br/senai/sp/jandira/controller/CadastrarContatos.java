package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Contato;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;

public class CadastrarContatos implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())){

            // Obter os dados FormData
            InputStream requestBody = exchange.getRequestBody();
            InputStreamReader isr = new InputStreamReader(requestBody, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String formData = br.readLine();

            System.out.println(formData); //Contem todos os dados do request Body front

            String[] parametros = formData.split("&");
            // Parametro Contem todos os dados para o cadastro: exemplo array [0, 1, 2] [nome, telefone, email]

            Contato newContato = new Contato();

            for (String parametro: parametros){
                //Desenvolver a logica que valida o nome do parametro e atribuir ao atributo correta!

                String[] paraParts = parametro.split("=");
                String paramNome = paraParts[0];
                String paramValues = paraParts[1];

                System.out.println(paramNome);
                System.out.println(paramValues);

            }
        }
    }
}
