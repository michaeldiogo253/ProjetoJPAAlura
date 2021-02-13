package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Movimentacao {
 
		@Id // define chave primaria
		@GeneratedValue (strategy = GenerationType.IDENTITY) // auto increment
		private Long id;
		
		private BigDecimal valor;
		
		@Enumerated (EnumType.STRING) // definido que ele vai salvar os dados como String 
		private TipoMovimentacao tipoMovimentacao ; // criado usando enum #top
		
		private LocalDateTime data;
		
		private String descricao;

		@ManyToOne // uma conta pode ter varias movimentacoes (cardinalidade),esta anotacao causa a criação de uma chave estrangeira
		private Conta conta;
		@ManyToMany
		private List <Categoria> categoria;
		
		
		public Conta getConta() {
			return conta;
		}

		public void setConta(Conta conta) {
			this.conta = conta;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public TipoMovimentacao getTipoMovimentacao() {
			return tipoMovimentacao;
		}

		public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
			this.tipoMovimentacao = tipoMovimentacao;
		}

		public LocalDateTime getData() {
			return data;
		}

		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Categoria> getCategoria() {
			return categoria;
		}

		public void setCategoria(List<Categoria> categoria) {
			this.categoria = categoria;
		}
		
		
}
