package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 *
 * @author Glauber
 */
//modelo de classe
@Entity
@Table(name = "tb_produto")
@NamedQueries({
    @NamedQuery(name = "Produto.buscaTodos", query = "select a from Produto a")
    ,
    @NamedQuery(name = "Produto.buscaPorId", query = "select a from Produto a where id = :id")
})
public class Produto {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "PRODUTO_NOME", length = 100, nullable = false)
    private String nome;
    @Column(name = "PRODUTO_DESCRICAO", length = 100, nullable = false)
    private String descricao;

    public Produto() {
    }

    public Produto(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Produto" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
