import java.io.Serializable;
import java.time.LocalDateTime;

public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(int id, Livro livro, Usuario usuario){
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucao = null;
    }

    public void finalizar(){
        this.dataDevolucao = LocalDateTime.now();
        this.livro.devolver();
    }

    public Livro getLivro(){
        return livro;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public boolean isAtivo(){
        return dataDevolucao == null;
    }
}
