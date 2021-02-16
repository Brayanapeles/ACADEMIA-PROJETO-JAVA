package br.senai.sp.jandira.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {

	private String nome;
	private String sexo;
	private double peso;
	private double altura;
	private String dataNasc;
	private String dataNascimento;
	private int idade;
	private String nivelAtividade;

///////////////-_Se��o Nome_-////////////////////////////////////////////////////////
	public void setNome(String nome) {										////////
		this.nome = nome;											//////////
	}															///////////		
															///////
	public String getNome() {						////////
		return this.nome;					/////////	
	}								////////////
/////////////////////////////////////

	
//////////////////-_Se��o Sexo_-//////////////////////////////////////////		
public void setSexo(String sexo) {							//////////
this.sexo = sexo;									//////////
}													////////
public String getSexo() {					/////////
return this.sexo;				//////////
}							//////////
//////////////////////////////////	
	

///////////////-_Se��o Peso-/////////////////////////////////////////////
public void setPeso(double peso) {							///////
this.peso = peso;									//////
}													//////
public double getPeso() {						///////
return this.peso;					/////////
}								//////////
/////////////////////////////////////


///////////////-_Se��o Altura_-///////////////////////////////////////////
public void setAltura(double altura) {							/////
this.altura = altura;									/////
}														////
public double getAltura() {						/////////
return this.altura;					//////////
}								/////////
//////////////////////////////////////


///////////////-_Se��o Data de nascimento_-/////////////////////////////////////////////////////////////////////////////////////////
	public void setDataNascimento(String dataNascimento) {											/////////////////
		this.dataNascimento = dataNascimento;										/////////////////
	}																	//////////////
																////////		
	public String getDataNascimento() {							///////
		return dataNascimento;											//////////////////////////////
	}																								//////////////////////////////
	public int getIdade() {																								////////
		LocalDate nascimento = LocalDate.parse(this.dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));		/////////
		LocalDate hoje = LocalDate.now();													////////////////////////////
		int idade = Period.between(nascimento, hoje).getYears();		//////////////////////////
		return idade;										/////////////
	}										///////////////////
//////////////////////////////////////////////
	
	
	
//////////////////-_Se��o N�vel de Atividade_-//////////////////////////////////////////////////////////////////////////////////////////
	public void setNivelDeAtividade(String nivelAtividade) {																	/////
		if (nivelAtividade.equals("Leve") || nivelAtividade.equals("Moderada") || nivelAtividade.equals("Intensa")) {	////////////
			if (getSexo().equals("Masculino")) {															/////////////////////
				if (nivelAtividade.equals("Leve")) {													////////////////////
					this.nivelAtividade = String.valueOf(1.5);										//////////////////
				} else if (nivelAtividade.equals("Moderada")) {									//////////////////
					this.nivelAtividade = String.valueOf(1.8);								///////////////////
				} else if (getSexo().equals("Intesa")) {								////////////////////
					this.nivelAtividade = String.valueOf(2.1);							////////////
				}																		////////////
			} else if (getSexo().equals("Feminino")) {										//////////////
				if (nivelAtividade.equals("Leve")) {												////////////////
					this.nivelAtividade = String.valueOf(1.6);											//////////////////
				} else if (nivelAtividade.equals("Moderada")) {													//////////////
					this.nivelAtividade = String.valueOf(1.6);												///////////////
				} else if (getSexo().equals("Intesa")) {												////////////////
					this.nivelAtividade = String.valueOf(1.8);										/////////////////
				}																				///////////////////
			}																		////////////////////////
		}																	///////////////////
	}																/////////////////////
	public String getNivelDeAtividade() {				/////////////////////
		return this.nivelAtividade;				///////////////////
	}			//////////////////////////////////
/////////////////////
	
	
//////////////////-_Se��o Calculo do IMC_-////////////////////////////////////////////////////////////////////////////////////////			
	public double getImc() {																			/////////////////////////
		return this.peso / Math.pow(altura, 2);														//////////////////////////
	}																					//////////////////////////////////
	public String getStatusImc() {														/////////////////////////////
		if (this.getImc() <= 18.6) {													///////////////////////
			return "Abaixo do peso";													/////////////////
		} else if (this.getImc() > 18.6 && this.getImc() < 25) {						//////////////////
			return "Peso ideal (Parab�ns)";													////////////////////
		} else if (this.getImc() >= 25 && this.getImc() < 30) {											/////////////
			return "Levemente acima do peso";														//////////
		} else if (this.getImc() >= 30 && this.getImc() < 35) {									///////////
			return "Obesidade grau I";													////////////
		} else if (this.getImc() >= 35 && this.getImc() <= 40) {				///////////////
			return "Obesidade grau II (Severa)";						//////////////////
		} else {												//////////////////
			return "Obesidade III (Morbida)";				////////////////
		}										/////////////////
	}								////////////////////
////////////////////////////////////////////
	
	
//////////////////-_Se��o Calculo do NCD_-////////////////////////////////////////////////////////////////////////////////////////			
	public double getNcd() {																							///////////
		if (getSexo().equals("Masculino")) {																		/////////////////
			if (getIdade() >= 18 && getIdade() <= 30) {														///////////////////////
				return (15.3 * getPeso() + 679) * Double.parseDouble(getNivelDeAtividade());			///////////////////////
			} else if (getIdade() > 30 && getIdade() <= 60) {										///////////////////////
				return (11.6 * getPeso() + 879) * Double.parseDouble(getNivelDeAtividade());	////////////////////////
			} else {																			//////////////////////
				return (13.5 * getPeso() + 487) * Double.parseDouble(getNivelDeAtividade());	////////////////////
			}																					/////////////////
		} else if (getSexo().equals("Feminino")) {												/////////////////
			if (getIdade() >= 18 && getIdade() <= 30) {												////////////////////
				return (14.7 * getPeso() + 496) * Double.parseDouble(getNivelDeAtividade());				//////////////////
			} else if (getIdade() > 30 && getIdade() <= 60) {															///////////
				return (8.7 * getPeso() + 829) * Double.parseDouble(getNivelDeAtividade());							//////////
			} else {																						//////////////
				return (10.5 * getPeso() + 596) * Double.parseDouble(getNivelDeAtividade());		//////////////////
			}																				/////////////////////
		}																			/////////////////////
		return this.getNcd();													////////////////////
	}																	///////////////////////
}																	///////////////////////
//////////////////////////////////////////////////////////////////////////