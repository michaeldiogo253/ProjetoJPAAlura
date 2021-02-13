package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoMichael {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta contaDoMichael = em.find(Conta.class, 1L);

        em.getTransaction().begin();

        contaDoMichael.setSaldo(20.0);

        em.getTransaction().commit();

	}

}
