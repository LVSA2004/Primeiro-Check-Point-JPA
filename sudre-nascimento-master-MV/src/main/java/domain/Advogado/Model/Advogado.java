package domain.Advogado.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_advogado",uniqueConstraints = {
        @UniqueConstraint(name = "UK_numb_OAB", columnNames = "numb_OAB")
})
public class Advogado {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator = "seq_adv")
@SequenceGenerator(name = "seq_adv",
           sequenceName = "seq_adv",
        allocationSize = 1)
    @Column(name = "id_advogado")
    private long id;
    @Column(name = "nm_advogado")
    private String nome;
    @Column(name = "numb_OAB",nullable = false)
    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado",
            foreignKey = @ForeignKey(name = "fk_adv_estado", value = ConstraintMode.CONSTRAINT))
    private Estado estado;

    public Advogado() {
    }

    public Advogado(long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
    }

    public long getId() {
        return id;
    }

    public Advogado setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Advogado{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", numeroOAB='").append(numeroOAB).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
