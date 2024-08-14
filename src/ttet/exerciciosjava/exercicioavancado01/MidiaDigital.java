package ttet.exerciciosjava.exercicioavancado01;

class MidiaDigital extends ItemBiblioteca {

    public MidiaDigital(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if (!disponivel) {
            throw new ItemNaoDisponivelException("A mídia digital '" + titulo + "' não está disponível para empréstimo.");
        }
        disponivel = false;
        System.out.println("Mídia digital '" + titulo + "' emprestada com sucesso.");
    }

    @Override
    public void devolver() {
        disponivel = true;
        System.out.println("Mídia digital '" + titulo + "' devolvida com sucesso.");
    }
}
