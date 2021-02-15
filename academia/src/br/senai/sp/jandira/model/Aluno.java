package br.senai.sp.jandira.model;

	import java.time.LocalDate;
	import java.time.Period;

	public class Aluno {
		
		private String nome;
		private char sexo;
		private double peso;
		private double altura;
		private LocalDate dataDeNascimento;
		private int nivelDeAtividade;
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		
		public char getSexo() {
			return this.sexo;
		}
		
		public void setPeso(double peso) {
			this.peso = peso;
		}
		
		public double getPeso() {
			return this.peso;
		}
		
		public void setAltura(double altura) {
			this.altura = altura;
		}
		
		public double getAltura() {
			return this.altura;
		}

		public void setNivelDeAtividade(int nivelDeAtividade) {
			if (nivelDeAtividade == 0) {
				this.nivelDeAtividade = 0;//nenhuma
			}else {
				if (nivelDeAtividade == 1) {
					this.nivelDeAtividade = 1;//leve
				}else {
					if (nivelDeAtividade == 2) {
						this.nivelDeAtividade = 2;//moderada
					}else {
						if (nivelDeAtividade == 3) {
							this.nivelDeAtividade = 3;//intensa
						}
					}
				}
			}
		}
		
		public int getNivelDeAtividade() {
			return this.nivelDeAtividade;
		}
		
		public void setDataDeNascimento(LocalDate dataDeNascimento) { //representa: LocalDate dataDeNascimento = LocalDate.algumaCoisa 
			this.dataDeNascimento = dataDeNascimento;
		}
		
		public int getIdade(){
			LocalDate hoje  = LocalDate.now(); //guarda a data atual baseada no computador
			Period periodo = Period.between(this.dataDeNascimento, hoje); //retorna um periodo, esse perido � seu tempo de vida.
			 
			return periodo.getYears();
		}
		
		public double getImc() {
			return this.peso/Math.pow(this.altura, 2);
		}
		
		public String getStatusImc() {
			if (getImc() <= 18.5 ) {
				return "Abaixo do peso";
			} else if (getImc() >= 18.6 && getImc() < 25.0) {
					return "Peso ideal(Parabens)";
				}else if (getImc() >= 25.1 && getImc() <= 29.9) {
						return "Levemente acima do peso";
					}else if (getImc() >= 30.0 && getImc() <= 34.9) {
							return "Obesidade grau I";
						}else if (getImc() >= 35.0 && getImc() <= 39.9) {
								return "Obesidade grau II (Severa)";
							}else if(getImc() >= 40.0){
									return "Obesidade grau III (M�rbida)";
							}else {
								return "Falha na requisi��o";
							}
						}
		
		public double getNcd() {
			///////////////////////////////////
			////  NCD PARA SEXO MACULINO    ///
			///////////////////////////////////
			if (this.sexo == 'm') {
				///////////////////////////////////
				//// NIVEL DE ATIVIDADE NENHUMA ///
				///////////////////////////////////
				if (this.nivelDeAtividade == 0) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return 15.3*this.peso + 679;
					}else if (getIdade() >= 31 && getIdade() <= 60) {
						return 11.6*this.peso + 879;
					}else if (getIdade() >= 60) {
						return 13.5*this.peso + 487;
					}else {
						return 0;
					}
					///////////////////////////////////
					//// NIVEL DE ATIVIDADE LEVE    ///
					///////////////////////////////////
				}else if (this.nivelDeAtividade == 1) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return (15.3*this.peso + 679)*1.5;
					}else if (getIdade() >= 31 && getIdade() <= 60) {
						return (11.6*this.peso + 879)*1.5;
					}else if (getIdade() >= 60) {
						return (13.5*this.peso + 487)*1.5;
					}else {
						return 0;
					}
					///////////////////////////////////
					//// NIVEL DE ATIVIDADE MODERADA///
					///////////////////////////////////
				}else if (this.nivelDeAtividade == 2) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return (15.3*this.peso + 679)*1.8;
					}else if (getIdade() >= 31 && getIdade() <= 60) {
						return (11.6*this.peso + 879)*1.8;
					}else if (getIdade() >= 60) {
						return (13.5*this.peso + 487)*1.8;
					}else {
						return 0;
					}
					///////////////////////////////////
					//// NIVEL DE ATIVIDADE INTENSA ///
					///////////////////////////////////
				}else if (this.nivelDeAtividade == 3) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return (15.3*this.peso + 679)*2.1;
					}else if (getIdade() >= 31 && getIdade() <= 60) {
						return (11.6*this.peso + 879)*2.1;
					}else if (getIdade() >= 60) {
						return (13.5*this.peso + 487)*2.1;
					}else {
						return 0;
					}
				}else {
					return 0;
				}
				
				///////////////////////////////////
				////  NCD DO SEXO FEMININO      ///
				///////////////////////////////////
				
			}else if (this.sexo == 'f') {
				///////////////////////////////////
				//// NIVEL DE ATIVIDADE NENHUMA ///
				///////////////////////////////////
				if (this.nivelDeAtividade == 0) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return 14.7*this.peso + 496;
					}else if (getIdade() >= 31 && getIdade() <= 60) {
						return 8.7*this.peso + 829;
					}else if (getIdade() >= 60) {
						return 10.5*this.peso + 596;
						///////////////////////////////////
						//// NIVEL DE ATIVIDADE LEVE    ///
						///////////////////////////////////
					}else if (this.nivelDeAtividade == 1) {
						if (getIdade() >= 18 && getIdade() <= 30) {
							return (14.7*this.peso + 496)*1.6;
						}else if (getIdade() >= 31 && getIdade() <= 60) {
							return (8.7*this.peso + 829)*1.6;
						}else if (getIdade() >= 60) {
							return (10.5*this.peso + 596)*1.6;
							////////////////////////////////////
							//// NIVEL DE ATIVIDADE MODERADA ///
							///////////////////////////////////
						}else if (this.nivelDeAtividade == 2) {
							if (getIdade() >= 18 && getIdade() <= 30) {
								return (14.7*this.peso + 496)*1.6;
							}else if (getIdade() >= 31 && getIdade() <= 60) {
								return (8.7*this.peso + 829)*1.6;
							}else if (getIdade() >= 60) {
								return (10.5*this.peso + 596)*1.6;
								///////////////////////////////////
								//// NIVEL DE ATIVIDADE INTENSA ///
								///////////////////////////////////
							}else if (this.nivelDeAtividade == 3) {
								if (getIdade() >= 18 && getIdade() <= 30) {
									return (14.7*this.peso + 496)*1.8;
								}else if (getIdade() >= 31 && getIdade() <= 60) {
									return (8.7*this.peso + 829)*1.8;
								}else if (getIdade() >= 60) {
									return (10.5*this.peso + 596)*1.8;
								}else {
									return 0;
								}
							}else {
								return 0;
							}
						}else {
							return 0;
						}
					}else {
						return 0;
					}
				}else {
					return 0;
				}
			}else {
				return 0;
			}
		}
		
		///////////////////////////////////
		//// M�TODO PARA CASO HAJA FALHA ///
		///////////////////////////////////
		
		public String getFalha() {
				if (getNcd() == 0) {
					return "H� uma falha na sua requisi��o";
				}else {
					return "";
				}
		}
		
}
