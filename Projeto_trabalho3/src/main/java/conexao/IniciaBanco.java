package conexao;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import Classes.Jogos;
import dao.JogosDAO;

public class IniciaBanco {
	@Test
	public void initListar() {
		try {
			JogosDAO jogosDAO = new JogosDAO();
			List<Jogos> list = jogosDAO.listar();
			
			for(Jogos jogos : list) {
				
				System.out.print(jogos.getNome()+" ");
				System.out.print(jogos.getClasse());
				
				System.out.print("\n___________________________\n");
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		try {
			JogosDAO jogosDAO = new JogosDAO();
			Jogos jogos = jogosDAO.buscar(5L);
			
			System.out.println(jogos.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void initAtualizar () {
		
		try {
			JogosDAO jogosDAO = new JogosDAO();
			Jogos jogos = jogosDAO.buscar(5l);
			
			jogos.setNome("Jeff");
			
			jogosDAO.atualizar(jogos);
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void initDeletar() {
	try {
		JogosDAO jogosDAO = new JogosDAO();
		jogosDAO.deletar(1L);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	

	
	}
	
	
	

