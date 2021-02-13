package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Movimentacao mov = new Movimentacao ();
		
		Conta conta = new Conta();
		conta.setAgencia(3125);
	    conta.setNumero(14101234);
	    conta.setSaldo(1000.0);
	    conta.setTitular("Michael");
		
		mov.setData(LocalDateTime.now());
		mov.setDescricao("Churrascaria");
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setValor(new BigDecimal (200.0));
		mov.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		em.close();
		
	}

}
