/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categoria;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EJBSubordinado {
    
    @PersistenceContext(unitName = "EjemploBD_JTA_JNDI_CMTPU")
    private EntityManager em;
    
//    //Tb se permite así
//    @PersistenceUnit(unitName = "EjemploBD_JTA_JNDI_CMTPU")
//    private EntityManagerFactory emf;

//    @TransactionAttribute(value = TransactionAttributeType.NEVER)  //Tb se puede poner en la clase
//    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)    
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
//    @TransactionAttribute(value = TransactionAttributeType.MANDATORY)
    public void subordinado() {
        
//        em = emf.createEntityManager();
        
        System.out.println("*****************************  subordinado  *******************************");
        em.persist(new Categoria("miCategoriaSubordinada"));
//        em.persist(new Categoria(1));
    }
}
