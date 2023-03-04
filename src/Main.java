import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Qual a quantidade de atletas? ");
		int n = sc.nextInt();
		String nome, nomeMaiorAltura = "";
		char sexo;
		double altura, peso, somaPeso = 0, mediaPeso, maiorAltura = 0, porcHomens, countHomens = 0,
				somaAlturaMulheres = 0, countMulheres = 0, mediaAlturaMulheres;

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do atleta numero " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			nome = sc.nextLine();

			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);
			while (sexo != 'F' && sexo != 'M') {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}
			if (sexo == 'M') {
				countHomens++;
			}

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			if (altura > maiorAltura) {
				maiorAltura = altura;
				nomeMaiorAltura = nome;
			}
			if (sexo == 'F') {
				countMulheres++;
				somaAlturaMulheres += altura;
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			somaPeso += peso;
		}
		mediaPeso = somaPeso / n;
		porcHomens = countHomens * 100 / n;

		System.out.println("\nRELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f%n", mediaPeso);
		System.out.printf("Atleta mais alto: %s%n", nomeMaiorAltura);
		System.out.printf("Porcentagem de homens: %.1f %% %n", porcHomens);
		if (countMulheres > 0) {
			mediaAlturaMulheres = somaAlturaMulheres / countMulheres;
			System.out.printf("Altura média das mulheres: %.2f", mediaAlturaMulheres);
		}
		else {
			System.out.println("Não há mulheres cadastradas");
		}

		sc.close();
	}

}
