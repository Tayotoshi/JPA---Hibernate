package jpa_hibernate;


public class Teste {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno ();
		
		a1.setNome("Bernardo");
		a1.setIdade(19);
		a1.setMatricula("123456789");
		
		AlunoController con = new AlunoController();
		
		//Adiciona um aluno na tabela
		
		con.salvar(a1);
		
		//Remove um aluno da tabela
		
		con.remover(a1);
		
		//Lista os nomes dos alunos da tabela
		con.listarTodos();
	}
}
