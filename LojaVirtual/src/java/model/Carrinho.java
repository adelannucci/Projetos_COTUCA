/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u11248
 */
@Entity
@Table(name = "carrinho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c"),
    @NamedQuery(name = "Carrinho.findByIdcarrinho", query = "SELECT c FROM Carrinho c WHERE c.idcarrinho = :idcarrinho")})
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarrinho")
    private Integer idcarrinho;
    @JoinColumn(name = "usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "produto", referencedColumnName = "idproduto")
    @ManyToOne
    private Produto produto;

    public Carrinho() {
    }

    public Carrinho(Integer idcarrinho) {
        this.idcarrinho = idcarrinho;
    }

    public Integer getIdcarrinho() {
        return idcarrinho;
    }

    public void setIdcarrinho(Integer idcarrinho) {
        this.idcarrinho = idcarrinho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarrinho != null ? idcarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.idcarrinho == null && other.idcarrinho != null) || (this.idcarrinho != null && !this.idcarrinho.equals(other.idcarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Carrinho[ idcarrinho=" + idcarrinho + " ]";
    }
    
}
