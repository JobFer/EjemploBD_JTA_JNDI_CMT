package dao;

import entities.Categoria;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @EJB
    private EJBSubordinado eJBSubordinado;

    @PersistenceContext(unitName = "EjemploBD_JTA_JNDI_CMTPU")
    private EntityManager em;
    
//    //Tb se permite asi:
//    @PersistenceUnit(unitName = "EjemploBD_JTA_JNDI_CMTPU")
//    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
//        return em = emf.createEntityManager();
    }
    
    public void crearCategoria(){
        
        System.out.println("*****************************  principal  *******************************");
//        EntityManager em = getEntityManager();
        
        em.persist(new Categoria("miCategoria"));
//        em.persist(new Categoria(1)); //Esto para provocar excepcion y ROLLBACK   
        
        try{
            eJBSubordinado.subordinado();
        }catch(Exception e){
            System.out.println("Excepcion en principal: " + e);
        }
     
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
}
