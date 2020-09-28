import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Davi Oliveira
 */
public class Main {
    public static boolean ValidarPalavra(String palavra) {   	
    	
        System.out.println("Verificando: " + palavra);

        Stack<Character> inputStack = new Stack();

        char[] simbolos = palavra.toCharArray();
        for (Character checarSimbolo : simbolos) {

            if (checarSimbolo == '(' || checarSimbolo == '{' || checarSimbolo == '[' || checarSimbolo == '<') {

                inputStack.push(checarSimbolo);
            } else if (checarSimbolo == ')' || checarSimbolo == ']' || checarSimbolo == '}' || checarSimbolo == '>') {

                try {

                    char Comparar = inputStack.pop();

                    if (checarSimbolo == ')' && Comparar == '(') {
                        continue;
                    } else if (checarSimbolo == '}' && Comparar == '{') {
                        continue;
                    } else if (checarSimbolo == ']' && Comparar == '[') {
                        continue;
                    } else if (checarSimbolo == '>' && Comparar == '<') {
                        continue;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        char[] permitidas = {'<','>','[',']','{','}','(',')'};
        
	        String[] inputs = {"[](){}", "[)]{}", "[(]){}<>", "(((((([]))))))", "{{[[()]()]}}", "{[[([)]]]}", "<{(())}>", "{<[]()[[]]<>>}"};
	        for (String palavra : inputs) {System.out.println(ValidarPalavra(palavra)?"Ok":"Não permitido");}

        while (continuar) {
        	String valor = "";
            System.out.println("Digite uma sentença: <{[( )]}>");
            String sentença = scanner.nextLine();
            String[] inserir = { sentença };
            boolean verificaString = false;
            
            for (String palavra : inserir) {            	
            	char[] caracteres = palavra.toCharArray();
            	for(char c : caracteres) {
            		for(int i=0; i<permitidas.length;i++) {
            			if(permitidas[i] == c) {
            				verificaString = true;
            				break;
            			}
            			verificaString = false;
            		}
            		if(!verificaString) {
            			continuar = false;
            			break;
            		}
            	}
            	if(continuar) {
                    System.out.println(ValidarPalavra(palavra) ? "Ok" : "Não permitido");            		
            	} else {
            		System.out.println("Caracter não valido");
            	}
            }

            System.out.println("Deseja Continuar? (S/N)");
            valor = scanner.nextLine().toUpperCase().trim();
            if(valor.equals("N")) {
            	continuar = false;
            } else {
            	continuar = true;
            }
        }
    }
}
