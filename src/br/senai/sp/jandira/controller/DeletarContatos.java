package br.senai.sp.jandira.controller;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import javax.swing.plaf.SplitPaneUI;
import java.io.IOException;
import java.sql.SQLException;

public class DeletarContatos implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
     String path = exchange.getRequestURI().getPath();
     String[] pathSegments = path.split("/");

     String nomeDelete = pathSegments[pathSegments.length - 1];
     ContatoController contatos = new ContatoController();

     try {
         contatos.deletarContato(nomeDelete);
     }catch (SQLException e) {
         throw  new RuntimeException(e);
     }
    }
}
