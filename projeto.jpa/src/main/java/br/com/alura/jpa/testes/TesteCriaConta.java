package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteCriaConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Michael");
		conta.setAgencia(3125);
		conta.setNumero(14105656);
		conta.setSaldo(1000.00);
		
		em.getTransaction().begin(); // é necessario iniciar uma transação 
		em.persist(conta);
		em.getTransaction().commit(); // significa que estamos finalizando a transação, caso der erro, volta ao estado anterior
		
		
		
		
	}

}
