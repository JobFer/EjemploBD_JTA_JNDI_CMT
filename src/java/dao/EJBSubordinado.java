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
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EJBSubordinado {
    
    @PersistenceContext(unitName = "EjemploBD_JTA_JNDI_CMTPU")
    private EntityManager em;

//    @TransactionAttribute(value = TransactionAttributeType.NEVER)  //Tb se puede poner en la clase
//    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)    
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void subordinado() {
        System.out.println("*****************************  subordinado  *******************************");
        em.persist(new Categoria("miCategoriaSubordinada"));
//        em.persist(new Categoria(1));
    }
}
