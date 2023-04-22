package domain.Processo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TP_ACAO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_nm_tp_acao", columnNames = "nm_tp_acao")
})
public class TipoDeAcao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tp_acao")
    @SequenceGenerator(name = "seq_tp_acao",
            sequenceName = "seq_tp_acao",
            allocationSize = 1)
    @Column(name = "id_tp_acao")
    private long id;
    @Column(name = "nm_tp_acao")
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public TipoDeAcao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoDeAcao{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
