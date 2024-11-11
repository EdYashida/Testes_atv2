package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import biblioteca_atv2.Emprestimo;
import biblioteca_atv2.Livro;

class TestCalculaDataDevol {

	@Test
	public void testCalculaDataDevolucaoEmpMais3() {
		Emprestimo emp = new Emprestimo();
		
		List <Livro> livros = new ArrayList();
		livros.add(new Livro(1));
		livros.add(new Livro(2));
		livros.add(new Livro(3));
		livros.add(new Livro(4));

		emp.emprestar(livros);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataDevolucaoCalculada = sdf.format(emp.getDataPrevista());

        
        // Configura a data esperada com a data atual + X dias
        int diasParaAdicionar = 9; // 4 dias do livro + 4 dias do 4º livro +  dia seguinte
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Data atual
        calendar.add(Calendar.DATE, diasParaAdicionar);
        Date dataEsperada = calendar.getTime(); 
        String dataDevEsperada = sdf.format(dataEsperada);
        
        assertEquals(dataDevEsperada, dataDevolucaoCalculada);

	    }
	
		@Test
		public void testCalculaDataDevolucaoEmpMenos3() {
		Emprestimo emp = new Emprestimo();
		
		List <Livro> livros = new ArrayList();
		livros.add(new Livro(1));
		livros.add(new Livro(2));

		emp.emprestar(livros);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataDevolucaoCalculada = sdf.format(emp.getDataPrevista());

        
        // Configura a data esperada com a data atual + X dias
        int diasParaAdicionar = 3; // 2 dias do livro +  dia seguinte
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Data atual
        calendar.add(Calendar.DATE, diasParaAdicionar);
        Date dataEsperada = calendar.getTime(); 
        String dataDevEsperada = sdf.format(dataEsperada);
        
        assertEquals(dataDevEsperada, dataDevolucaoCalculada);

	    }
		
		@Test
		public void testCalculaDataDevolucao1Liv() {
		Emprestimo emp = new Emprestimo();
		
		List <Livro> livros = new ArrayList();
		livros.add(new Livro(1));

		emp.emprestar(livros);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataDevolucaoCalculada = sdf.format(emp.getDataPrevista());

        
        // Configura a data esperada com a data atual + X dias
        int diasParaAdicionar = 2; // 1 dia do livro +  dia seguinte
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Data atual
        calendar.add(Calendar.DATE, diasParaAdicionar);
        Date dataEsperada = calendar.getTime(); 
        String dataDevEsperada = sdf.format(dataEsperada);
        
        assertEquals(dataDevEsperada, dataDevolucaoCalculada);

	    }
		
		

}
