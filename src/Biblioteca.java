import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void registrarEmprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    public List<Livro> getLivros() { return livros; }
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}
