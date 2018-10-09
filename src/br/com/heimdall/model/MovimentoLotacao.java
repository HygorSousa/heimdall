package br.com.heimdall.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MovimentoLotacao extends DefaultEntity<MovimentoLotacao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value = TemporalType.DATE)
    private Date data;

    private String motivo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idlotacao")
    private Lotacao lotacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
