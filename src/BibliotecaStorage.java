import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BibliotecaStorage {
    private static final Path DATA_PATH = Paths.get("data", "biblioteca.dat");

    public static Biblioteca carregar() {
        if (!Files.exists(DATA_PATH)) {
            return new Biblioteca();
        }

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(DATA_PATH))) {
            Object obj = in.readObject();
            if (obj instanceof Biblioteca) {
                return (Biblioteca) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Nao foi possivel carregar os dados.");
        }

        return new Biblioteca();
    }

    public static void salvar(Biblioteca biblioteca) {
        try {
            Path parent = DATA_PATH.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(DATA_PATH))) {
                out.writeObject(biblioteca);
            }
        } catch (IOException e) {
            System.err.println("Nao foi possivel salvar os dados.");
        }
    }

    private BibliotecaStorage() {
    }
}
