package br.senai.sp.jandira.model;

public class Contato {
    private int id;
    private long telefone;
    private String nome, email, foto;
    private boolean favorito;

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
