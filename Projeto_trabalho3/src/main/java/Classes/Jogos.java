package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Jogos {
	
	private String nome;
	private String classe;
    private Long id;
	private int vida;
	
	
	
	
	private int dano;
	public Long getId() {
		return id;
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	@Override
	public String toString() {
		return "Personagem [id=" + id + ", nome=" + nome + ",classe=" + classe + ",vida=" + vida + ",dano=" + dano + "]";
	}
}
