package domain.Advogado.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_estado", uniqueConstraints = {
		@UniqueConstraint(name = "UK_nm_estado", columnNames = "nm_estado"),
		@UniqueConstraint(name = "UK_sigla_estado", columnNames = "sigla_estado")
})
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_est")
	@SequenceGenerator(name = "seq_est",
			sequenceName = "seq_est",
			allocationSize = 1)
	@Column(name = "id_estado")
	private int id;
	@Column(name = "nm_estado")
	private String nome;
	@Column(name = "sigla_estado")
	private String sigla;

	public Estado() {
	}

	public Estado(int id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public int getId() {
		return id;
	}

	public Estado setId(int id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Estado setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSigla() {
		return sigla;
	}

	public Estado setSigla(String sigla) {
		this.sigla = sigla;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Estado{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", sigla='").append(sigla).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
