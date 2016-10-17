package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Produto;
import util.JPAUtil;

/**
 *
 * @author Glauber
 */
public class ProdutoDAO {

    private EntityManager em
            = JPAUtil.ConnectionFactory().createEntityManager();

    public void insert(Produto p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }

    public Produto select(String nome) {

        return em.createNamedQuery("Produto.buscaPorNome", Produto.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> select() {
        return em.createNamedQuery("Produto.buscaTodos", Produto.class)
                .getResultList();
    }

    public void update(Produto p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();

    }

    public void delete(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (JPAUtil.ConnectionFactory().isOpen()) {
            JPAUtil.ConnectionFactory().close();
        }
    }

}
