package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import biblioteca_atv2.Controle;

class testEmprestaLivrosLiv {

	@Test
	void EmprestaLivroBibPrimeiro() {
				
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "1";
		 int num = 3;
		 codigos[0]=3;
		 codigos[1]=1;
		 codigos[2]=2;
		 
      Controle c = new Controle();
      boolean retorno = c.emprestar(aluno, codigos, num);
      
      assertEquals(retorno,true);
	}
	@Test
	void EmprestaLivroBibUltimo() {
				
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
	@Test
	void EmprestaLivroLimite5() {
				
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "1";
		 int num = 6;
		 codigos[0]=1;
		 codigos[1]=2;
		 codigos[2]=4;
		 codigos[3]=5;
		 codigos[4]=6;
		 codigos[5]=7;
		 
      Controle c = new Controle();
      boolean retorno = c.emprestar(aluno, codigos, num);
      
      assertEquals(retorno,true);
	}
	
	@Rule
    public ExpectedException exceptionRuleNeg = ExpectedException.none();
	
	@Test
	void EmprestaLivroPrazoNeg() {
				
		int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 
		 String aluno = "1";
		 int num = 2;
		 codigos[0]=-1;
		 codigos[1]=1;
		 
      Controle c = new Controle();
      
      exceptionRuleNeg.expect(IllegalArgumentException.class);
      exceptionRuleNeg.expectMessage("Os prazos devem ser valores inteiros positivos");
      
      boolean retorno = c.emprestar(aluno, codigos, num);
      
      assertEquals(retorno,true);
	}
	
    

    @Test
    public void testEmprestarComListaVazia() {
        Controle controle = new Controle();
        int[] codigos = new int[0];
        
        // Espera-se que o método retorne false, já que não há itens para emprestar
        boolean retorno = controle.emprestar("1", codigos, 0);
        assertEquals(false, retorno);
    }

}
