public class Usuario {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private boolean registrado;

    public Usuario(String nome, String email, String telefone, String cpf){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.registrado = true;
    }

    public Usuario(String cpf) {
        this.cpf = cpf;
        this.registrado = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean getRegistrado() {
        return registrado;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone(){
        return telefone;
    }
}