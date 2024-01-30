/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import entidades.ProductosInsumos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author familia perez
 */
@Stateless
public class ProductosInsumosFacade extends AbstractFacade<ProductosInsumos> {

    @PersistenceContext(unitName = "KattasWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosInsumosFacade() {
        super(ProductosInsumos.class);
    }
    
}
