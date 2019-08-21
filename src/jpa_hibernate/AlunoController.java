package jpa_hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;





public class AlunoController {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoController() {
		emf =  Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public void salvar (Aluno _aluno) {
		em.getTransaction().begin(); // Cria a transação no banco
		em.merge(_aluno); // Salva o aluno no banco
		em.getTransaction().commit(); 
		emf.close(); // Fecha a transação
		}
	
	public void remover (Aluno _aluno) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete aluno from aluno where matricula = "+_aluno.getMatricula());
		em.getTransaction().commit();
		emf.close();
	}
	
	public void listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("from Aluno");
		List<Aluno> alunos = consulta.getResultList();
		for (int i=0; i<alunos.size(); i++) {
			System.out.println("Nome: "+alunos.get(i).getNome());	
		}
		em.getTransaction().commit();
		emf.close();
	}
}
