import java.util.ArrayList;
import java.util.List;

public class ServicosUsuario {

    private List<Usuario> usuarios = new ArrayList<>();
    public void registrar( Usuario usuario ) {

        for ( Usuario usu : usuarios ) {
            if ( usu.getCpf().equals( usuario.getCpf() ) ) {
                System.out.println( "Usuário já cadastrado!" );
                return;
            }
        }

        usuarios.add( usuario );
        System.out.println( "Usuário salvo." );
    }

    public Usuario login( String cpf ) {

        for ( Usuario usuario : usuarios ) {
            if ( usuario.getCpf().equals( cpf.trim() ) ) {
                return usuario;
            }
        }
        return null;
    }
}