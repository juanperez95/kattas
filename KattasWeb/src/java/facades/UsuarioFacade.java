
package facades;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "KattasWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario UserLogin(String clave, String email){
        List<Usuario> listaUsuario = new ArrayList<>();
        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email and u.contrasena=:clave");
        consulta.setParameter("email", email);
        consulta.setParameter("clave", clave);
        listaUsuario = consulta.getResultList();
        if(listaUsuario.isEmpty()){
            return null;
        }
        return listaUsuario.get(0);
    }
    
}
