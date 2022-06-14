package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
	
		//Pega o caminho do arquivo contendo os dados a serem computados
		String path = "arquivo.txt";
		
		//Bloco criado para fazer a leitura do arquivo
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			//Percorre o Arquivo
			while(line != null) {
				
				//Quebra cada linha do arquivo em duas partes
				String[] fields = line.split(",");
				//Armazena a primeira parte dentro da variavel name 
				String name = fields[0];
				//Armazena a segunda parte passando a String para um inteiro
				int count = Integer.parseInt(fields[1]);
				
				//verifica no MAP se já existe aquela chave 'nome' que esta sendo percorrida
				if(votes.containsKey(name)) {
					//armazeno na variavel inteira o numero se já existir
					int votesSoFar = votes.get(name);
					//depois substituo a ocorrência da chave, passando o valor já contido na variavel votesSoFar + count
					votes.put(name, count + votesSoFar);
				}
				//caso n tenha ocorrência ainda no map, somente crio uma nova linha no map passando os valores
				else {
					votes.put(name, count);
				}
				//continuou a iteração do arquivo até acabar as linhas
				line = br.readLine();
			}
			//percorro o meu map utilizando o keySet que me devolve o conjunto de chaves
			for(String key : votes.keySet()) {
				//Printo de maneira formatada, os nomes e os valores utilizando o método get, passando as chaves
				System.out.println(key + ": " + votes.get(key));
			}
			
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
