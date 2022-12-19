package Lista.Q2;

public class Exemplar {
    private int tombo; // número de tombo de exemplar
    private String titulo; // título
    private String autores; // nomes de autores de título
    private boolean aptoEmprestimo; // exemplar habilitado para empréstimos se valor for true
    private int emprestimos; // quantidade, até então, de empréstimos

    public Exemplar(int tombo, String titulo, String autores, boolean aptoEmprestimo) {
        this.tombo = tombo;
        this.titulo = titulo;
        this.autores = autores;
        this.aptoEmprestimo = aptoEmprestimo;
        this.emprestimos = 0;
    }

    public int getTombo() {
        return tombo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public boolean isAptoEmprestimo() {
        return aptoEmprestimo;
    }

    public String getEmprestimos() {
        return autores;
    }

    public void setTombo(int tombo) {
        this.tombo = tombo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    // habilitação de exemplar para empréstimo
    public void habilitarEmprestimo() {
        aptoEmprestimo = true;
    }

    // desabilitação de exemplar para empréstimo
    public void desabilitarEmprestimo() {
        aptoEmprestimo = false;
    }

    /*
     * incremento de empréstimos de exemplar ate então realizados, com retorno
     * de true se empréstimo processado com êxito (caso contrário, retorno de false)
     */
    public boolean adicionarEmprestimo() {
        if (aptoEmprestimo) { // caso empréstimos habilitados
            emprestimos++; // atualização de empréstimos de exemplar
            return true; // retorno de indicativo de processamento de empréstimo
        } else {
            return false; // retorno de indicativo de não processamento de empréstimo
        }
    }
}
