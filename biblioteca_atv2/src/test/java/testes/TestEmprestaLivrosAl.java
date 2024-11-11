package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import biblioteca_atv2.Aluno;
import biblioteca_atv2.Controle;

class TestEmprestaLivrosAl {

	@Test
	void EmprestaAlunoNcad() {
		
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "10";
		 int num = 3;
		 codigos[0]=1;
		 codigos[1]=2;
		 codigos[2]=3;
		 
       Controle c = new Controle();
       boolean retorno = c.emprestar(aluno, codigos, num);
       
       assertEquals(retorno,false);
       Aluno al= new Aluno(aluno);
       boolean existeAl = al.verficaAluno();
       assertEquals(existeAl,false);

	}
	
	@Test
	void EmprestaAlunoDeb() {
				
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "4";
		 int num = 3;
		 codigos[0]=1;
		 codigos[1]=2;
		 codigos[2]=3;
		 
      Controle c = new Controle();
      boolean retorno = c.emprestar(aluno, codigos, num);
      
      assertEquals(retorno,false);

      Aluno al= new Aluno(aluno);
      boolean debitoAl = al.verificaDebito();
      assertEquals(debitoAl,false);

	}

	@Test
	void EmprestaAlunoCerto() {
				
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "1";
		 int num = 3;
		 codigos[0]=1;
		 codigos[1]=2;
		 codigos[2]=3;
		 
      Controle c = new Controle();
      boolean retorno = c.emprestar(aluno, codigos, num);
      
      assertEquals(retorno,true);
	}

}
