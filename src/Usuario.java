import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private int livrosComEle = 0;
    private boolean temMulta = false;


    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getLivrosComEle() {
        return livrosComEle;
    }

    public String getStatusUsuario() {
        if (temMulta) {
            return "🔴 Bloqueado (Multa)";
        } else if (livrosComEle > 0) {
            return "⚠️ Pendente (" + livrosComEle + ")";
        } else {
            return "✅ Regular";
        }
    }

    @Override
    public String toString() {
        return nome + " (ID: " + id + ")";
    }
}
