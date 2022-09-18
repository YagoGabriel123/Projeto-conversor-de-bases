
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		// variaveis de controle
		int n = 0;
		int i = 0;
		int o = 0;
		int q = 1;
		int vetor[] = new int[100];
		int valorNaBaseOut = 0; // valor para ser contado na base de destino
		int resul_int[] = new int[110000000];
		double resul_fraci[] = new double[110];

		// ************************************************************************************************

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

			if(num1_double < 0) {
				num1_double = num1_double*(-1);
				
			}
			if (b_in < 2 || b_out < 2 || b_out > 16  || b_in > 16) {
				
				System.out.println(" AS BASES DEVEM SER:  2 <= B_IN <=16  E  2 <= B_IN <=16");
				System.exit(0);
			}
			
			// Parte inteira do Num_1
			int num1_int = (int) num1_double; // Parte inteira da entrada

			double num1_double_fraci = num1_double - num1_int; // Parte fracionaria de Num_1

			entrada.close();

			// ********************************************************************************************//

			while (num1_int > 0) { // separa o valor lido em uni, dez, cent... nas posições do vetor
				vetor[i] = num1_int % 10;
				num1_int /= 10;
				// System.out.print(vetor[i] + " - ");
				i++; // i = numero de posições do vetor controle

			}

			// ********************************************************************************************//
			//Converte o valor na base de entrada para base 10
			do {

				if (n == 0 && vetor[n] <= b_in) {

					System.out.println("Método de Horner p/ b.out = 10");
				}

				if (vetor[n] >= b_in) {// teste se algum digito do NUM1 é >= que a base de entrada
					System.out.println("O NÚMERO DIGITADO NÃO EXISTE NA BASE DE ENTRADA!!!! .... Aperte F11");
					System.exit(0);
					break;
				}
				if (vetor[n] != b_in) {
					valorNaBaseOut += (vetor[n] * (Math.pow(b_in, n)));
					System.out.println("+ " + vetor[n] + "*" + b_in + "^" + n);
				}
				n++;
				if (!(n <= (i - 1))) {

					System.out.println("__________________");
					System.out.println("   " + valorNaBaseOut);
				}

			} while (n <= (i - 1));

			// *************************************************************************************//
			//Converte o valor na base 10 para base de entrada
			System.out.println("Algoritmo da divisão de Euclides");
			System.out.println("a = q * b + r");
			while (valorNaBaseOut >= 0) {
				resul_int[o] = valorNaBaseOut % b_out;
				System.out.println(valorNaBaseOut + " = " + (valorNaBaseOut / b_in) + " * " + b_in + " + "
						+ (valorNaBaseOut % b_in));
				valorNaBaseOut = valorNaBaseOut / b_out;
				o++;
				if (valorNaBaseOut == 0)
					break;
			}

			i = 0;
			// *************************************************************************************//
			//Converte a parte fracionaria do valor na base de entrada para base de entrada
			while ((num1_double_fraci > 0)) {
				if (i == 0) {
					System.out.println();
					System.out.println("Método de multiplicação sucessiva pela base");
				}
				resul_fraci[i] = (int) ((num1_double_fraci * b_out));
				i++;
				
				System.out.println(Math.round(num1_double_fraci * 100.0) / 100.0 + " * " + b_out + " = "
						+ ((num1_double_fraci * b_out) - (int) resul_fraci[i - 1]) + " + "
						+ ((int) resul_fraci[i - 1]));
				
				num1_double_fraci = (num1_double_fraci * b_out) - (int) resul_fraci[i - 1];

			}

			// *************************************************************************************//
			//Exibe a parte inteira do valor na base de destino
			q = o;
			System.out.print("Resultado da Conversão é : ");
			while (o >= 0) {
				System.out.print(resul_int[(q - 1)]);
				q--;
				if (q == 0)
					break;
			}
			// *************************************************************************************//
			//Exibe a parte fracionada do valor na base de destino
			for (int j = 0; j != i; j++) {

				if (j == 0)
					System.out.print(",");

				System.out.print((int) (resul_fraci[j]));
				if (j == 10) {
					System.out.println("..." + b_out);

					break;
				}

			}

		}
	}
}
