
import java.util.Scanner;
import java.util.Arrays;

public class Principal {
		public static void main(String[] args) {
			Scanner entrada = new Scanner(System.in);

			// variaveis de controle 
			boolean caso1;
			int n = 0;
			int i = 0;
			int o = 0;
			int q = 1;
			int vetor[] = new int[100];
			int valorNaBaseOut = 0; // valor para ser contado na base de destino
			int resul_int[] = new int[110000000];
			double resul_fraci[] = new double[110];

	//************************************************************************************************
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("1 = Converter N na base x para base y");
			System.out.println("2 = Converte converter N na base x para base y com PF");
			System.out.println("3  Multiplicar de X e Y na mesma Base");
			System.out.println("4 = Somar de X e Y na mesma Base");
			int caso = entrada.nextInt(); //

			switch (caso) {

			case 1:
				System.out.println("Digite um número:");
				double num1_double = entrada.nextDouble(); // valor_entrada = Numero que será convertido

				System.out.println("Digite a Base de Origem:");
				int b_in = entrada.nextInt(); // base de origem

				System.out.println("Digite a Base de destino:");
				int b_out = entrada.nextInt();// base de destino

				// Parte inteira do Num_1
				int num1_int = (int) num1_double; // Parte inteira da entrada

				double num1_double_fraci = num1_double - num1_int; // Parte fracionaria de Num_1

				// System.out.println(num1_int);
				// num1_double_fraci += 0.000000000000001;
				// System.out.println((num1_double_fraci));

				entrada.close();

	//********************************************************************************************//	

				while (num1_int > 0) { // separa o valor lido em uni, dez, cent... nas posições do vetor
					vetor[i] = num1_int % 10;
					num1_int /= 10;
					// System.out.print(vetor[i] + " - ");
					i++; // i = numero de posições do vetor controle

				}
				// System.out.println();
				// System.out.println("n° de posições :" + i);
	//********************************************************************************************//		
				System.out.println("Método de Horner p/ b.out = 10");
				do {

					if (vetor[n] >= b_in) {
						System.out.println("O número digitado não existe na base digitada");
						break;
					}
					if (vetor[n] != b_in) {
						valorNaBaseOut += (vetor[n] * (Math.pow(b_in, n)));
						System.out.println("+ " + vetor[n] + "*" + b_in + "^" + n);
					}
					n++;

				} while (n <= (i - 1));

				// *************************************************************************************//
				System.out.println("Algoritmo da divisão de Euclides");
				System.out.println("a = q * b + r");
				while (valorNaBaseOut >= 0) {
					resul_int[o] = valorNaBaseOut % b_out;
					System.out.println(valorNaBaseOut + " = " + (valorNaBaseOut / b_in) + " * " + b_in + " + "
							+ valorNaBaseOut % b_in);
					valorNaBaseOut = valorNaBaseOut / b_out;
					System.out.println("---------------------------");
					o++;
					if (valorNaBaseOut == 0)
						break;
				}
				q = o;
				System.out.print("Resultado da Conversão é : ");
				while (o >= 0) {
					System.out.print(resul_int[(q - 1)]);
					q--;
					if (q == 0)
						System.out.println();
						break;
				}

				i = 0;
				System.out.print(",");
				while ((num1_double_fraci != 1)) {
					//System.out.println(resul_fraci[i] + " = " + "(" + num1_double_fraci + " * " + b_out + ")" + " % 10");

					resul_fraci[i] = (int)((num1_double_fraci * b_out) / 10);
					//System.out.println(  num1_double_fraci + " * " + b_out + ")" + " % 10");
					num1_double_fraci = (num1_double_fraci * b_out) % 10;
					System.out.print(resul_int[(i)]);
					i++;
					//if (i > 7)
						//break;
				}

			}
		}
	}


