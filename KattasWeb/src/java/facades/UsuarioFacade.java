
package facades;

import entidades.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/**
 *
 * @author Roberto_Diaz
 */
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
    
        public Usuario UserLogin(String clave, String email) throws NoSuchAlgorithmException{
        clave=encriptarClave(clave);
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
    public boolean CorreoLogin(String email){
        List<Usuario> listaUsuario = new ArrayList<>();
        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email");
        consulta.setParameter("email", email);
        listaUsuario = consulta.getResultList();
        if (listaUsuario.isEmpty()) {
            return false;
            
        }else {
            return true;
        }
        
    }
    public String encriptarClave(String clave) throws NoSuchAlgorithmException{
        MessageDigest encrip = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        encrip.update(clave.getBytes());
        byte[]datos=encrip.digest();
        byte[]datosfinal=Base64.encodeBase64(datos);        
        return new String(datosfinal);
    }
    
}
