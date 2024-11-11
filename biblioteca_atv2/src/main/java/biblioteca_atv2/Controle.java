package biblioteca_atv2;

import java.util.ArrayList;
import java.util.List;

public class Controle {

  public boolean emprestar(String aluno, int[] prazos, int num)
  {
	  boolean retorno=true;

      // Verifica se a lista de prazos está vazia
      if (prazos.length == 0) {
          System.out.println("Lista de prazos está vazia");
          return false;
      }
      
	  /*Aqui voc� deve instaciar um objeto aluno*/
	  Aluno a = new Aluno(aluno);
	  
	  //Verifica se o aluno existe
	  if (!a.verficaAluno())
	  {
		  System.out.println("Aluno Inexistente");
		  retorno = false;
       }
	  
	  //Verifica se o aluno possui algum Debito
	  if (!a.verificaDebito())
	  {
		  System.out.println("Aluno em Debito");
		  retorno = false;
       }
	  
	  //Caso o aluno n�o tenha d�bitos e exista
	  if(retorno)
	  {   
		  //Cria um conjunto de livros
		  List<Livro> livros = new ArrayList<Livro>();  
	     
		  /*Para cada livro verifica  se � exemplar da biblioteca 
                   e s� deixar� emprestar os livros que n�o s�o */
           for(int i=0; i< num;i++)
		   {   Livro l = new Livro(prazos[i]);
		   
		     //se ja tier 5 livros e estiver executando denovo, está violando limite de 5
		     if(livros.size()==5) {
			   System.out.println("Limite de 5 livros violado, os livros restantes não serão emprestados");
			   break;
		     }
		     
		     
		     //caso o livro n�o seja exemplar da biblioteca permite emprestar  
		     if (!l.verificaLivro()) {
		    	 if (l.verPrazo() < 0)  //se tiver prazo negativo, lança excessão
		              throw new IllegalArgumentException("Os prazos devem ser valores inteiros positivos");
		    	 else
		    		 livros.add(l);
		     }
		     //caso seja
		     else if(l.verificaLivro())
		       System.out.println("É um exemlar da biblioteca, não pode ser emprestado");
		     //caso viole limite de 5 livros, informa e encerra

		   }
			
		   /*Chama o m�todo delegado do aluno de emprestar cliente, passando o conjunto de livros como parametro caso tenha pelo menos um livro a ser emprestado*/
		   if (livros.size() > 0 )
		   {   
		     retorno = a.emprestar(livros);
		     return retorno;
		   }
		   else
		   return false;
		  
	  }
	  else
		  return retorno;
  }
	
}

