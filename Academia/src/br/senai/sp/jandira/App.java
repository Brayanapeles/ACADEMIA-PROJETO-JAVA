package br.senai.sp.jandira;

import java.time.LocalDate;

import br.senai.sp.jandira.gui.Tela;
import br.senai.sp.jandira.model.Aluno;

public class App {
	public static void main(String[] args) {
		
		Tela tela = new Tela();
		tela.criarTela();
		
		Aluno brayan = new Aluno(); {
			brayan.setNome("Brayan");
			brayan.setSexo("Masculino");
			brayan.setPeso(56);
			brayan.setAltura(1.78);
			LocalDate dataNascimento = LocalDate.of(2004, 01, 31);
			brayan.setDataNascimento("dataNascimento");
			brayan.setNivelDeAtividade("leve");
			
			System.out.println(brayan.getNome());
			System.out.println(brayan.getSexo());
			System.out.println(brayan.getPeso());
			System.out.println(brayan.getAltura());
			System.out.println(brayan.getDataNascimento());
			System.out.println(brayan.getNivelDeAtividade());
			System.out.println(brayan.getImc());
			System.out.println(brayan.getStatusImc());
			System.out.println(brayan.getNcd());
		}
	}
}
