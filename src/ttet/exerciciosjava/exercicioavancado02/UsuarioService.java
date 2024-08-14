package ttet.exerciciosjava.exercicioavancado02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty() ||
                usuario.getEmail() == null || usuario.getEmail().isEmpty() ||
                usuario.getIdade() <= 0) {
            throw new IllegalArgumentException("Dados inválidos para cadastro de usuário.");
        }
        usuarios.add(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorNome(String nome) {
        String regex = "^[A-Za-z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        return usuarios.stream()
                .filter(usuario -> pattern.matcher(usuario.getNome()).matches() && usuario.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
