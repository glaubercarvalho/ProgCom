package mb;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Produto;

/**
 *
 * @author Glauber
 */
@Named
@RequestScoped
public class TelaMB implements Serializable {

    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvar() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Salvou");
    }
}
