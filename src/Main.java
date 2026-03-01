void main() {

    Usuario usuario01 = new Usuario( "Felipe M.", "felipematrone@gmail.com", "11553125353", "44991024053", false);


    System.out.println("------ TESTE USUARIO REGISTRADO ------");
    System.out.println("Nome: " + usuario01.getNome() );
    System.out.println("Email: " + usuario01.getEmail() );
    System.out.println("Telefone: " + usuario01.getTelefone() );
    System.out.println("CPF: " + usuario01.getCpf() );
    System.out.println("Registrado: " + usuario01.getRegistrado() );




}
