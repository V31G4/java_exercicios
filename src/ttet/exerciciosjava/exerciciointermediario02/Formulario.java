package ttet.exerciciosjava.exerciciointermediario02;

public class Formulario {

    public boolean verificarNome(String nome){
        String regex = "^[a-zA-Z]{1,}$";
        return nome.matches(regex);
    }

    public boolean verificarSobrenome(String sobrenome) {
        String regex = "^[a-zA-Z]{1,}$";
        return sobrenome.matches(regex);
    }

    public boolean verificarCPF(String cpf) {
        String regex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        return cpf.matches(regex);
    }

    public boolean verificarEmail(String email) {
        String regex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }
}
