import java.io.Serializable;
import java.time.LocalDateTime;

public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String titulo;
    private  String autor;
    private boolean disponivel;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Livro (int id, String titulo, String autor){
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

    public String getStatusLivro(){
        if(disponivel){
            return "✅ Disponivel";
        } else {
            return "🔴 Emprestado";
        }
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

    public String getAutor(){
        return autor;
    }

    public boolean getDisponivel(){
        return disponivel;
    }
}
