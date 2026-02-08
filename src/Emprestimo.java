import java.time.LocalDateTime;

public class Emprestimo {
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
}
