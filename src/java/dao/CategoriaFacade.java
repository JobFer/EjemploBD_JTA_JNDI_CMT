package dao;

import entities.Categoria;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @EJB
    private EJBSubordinado eJBSubordinado;

    @PersistenceContext(unitName = "EjemploBD_JTA_JNDI_CMTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void crearCategoria(){
        System.out.println("*****************************  principal  *******************************");
        eJBSubordinado.subordinado();
        em.persist(new Categoria("miCategoria"));
//        em.persist(new Categoria(1)); //Esto para provocar excepcion y ROLLBACK
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
}
