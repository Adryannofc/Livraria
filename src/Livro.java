import java.time.LocalDateTime;

public class Livro {
    private int id;
    private String titulo;
    private  Autor autor;
    private boolean disponivel;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Livro (int id, String titulo, Autor autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void emprestar(){
        this.disponivel = false;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void devolver(){
        this.disponivel = false;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public Autor getAutor(){
        return autor;
    }

    public boolean getDisponivel(){
        return disponivel;
    }
}
