package sistema.bancario.model;

import sistema.bancario.persistencia.PersistenciaArquivo;
import java.util.Scanner;
public class Programa {
	
	
	public static void main(String[] args) {
		int opcaoMenu = 0;
		
		String nome = null;
		
		Scanner entrada = new Scanner(System.in);
		PersistenciaArquivo p = new PersistenciaArquivo();
		Cliente temp = new Cliente(null,null);
		Conta tempConta = new Conta(null);
		
		do {
			mostrarMenu();
			opcaoMenu = lerOpcaoMenu(entrada);
			switch(opcaoMenu) {
			case 1:
				listarClientes(p);				
				break;
			case 2:
				consultarClienteCpf(entrada,p,temp);
				break;
			case 3:
				cadastroCliente(entrada, p, nome, temp);
				break;
			case 4:
				removerCliente(entrada,p,temp);
				break;
			case 5:
				criarConta(entrada, p, temp, tempConta);
				break;
			case 6:
				removerConta(entrada, p, temp, tempConta);
				break;
			case 7:
				depositarQuantia(entrada, p, temp, tempConta);
				break;
			case 8:
				sacarQuantia(entrada, p, temp, tempConta);
				break;
			case 9:
				System.out.println("encerrando programa");
				break;
			default:
				System.out.println("Opção invalida digite novamente!");
			}	
		}while(opcaoMenu != 9);
		System.out.println("\n\nPrograma encerrado");
	}
	
		private final static int lerOpcaoMenu(Scanner entrada) {
			int opcaoMenu = entrada.nextInt();
			return opcaoMenu;
 		}
		
		private static void mostrarMenu() {
			System.out.println("Sistema Bancario");
			System.out.println("------------------------------------------------------------");
			System.out.println("1.Listar clientes ");
			System.out.println("2.Consultar cliente por CPF");
			System.out.println("3.Cadastro Cliente");
			System.out.println("4.Remover cliente");
			System.out.println("5.Criar conta");
			System.out.println("6.Remover conta");
			System.out.println("7.Realizar depósito");
			System.out.println("8.Realizar Saque");
			System.out.println("9.Encerrar programa");
			System.out.println("-----------------------------------------------------------");
			

		}
		private static void listarClientes(PersistenciaArquivo p) {
			limparTela();
			System.out.println("Lista Clientes");
			System.out.println("-----------------");
			p.listarClientes();
			System.out.println("--------------------");
		
			
		}
		private static void consultarClienteCpf(Scanner entrada, PersistenciaArquivo p,Cliente temp) {
			System.out.println("insira o cpf...");
			temp.cpf = entrada.next();
			temp = p.localizarClienteCPF(temp.cpf);
			System.out.println("Conta encontrada");
			System.out.println("---------------------");
			System.out.println(temp);
			System.out.println("---------------------");
		}
		private static void cadastroCliente(Scanner entrada, PersistenciaArquivo p,String nome,Cliente temp) {
			System.out.println("insira o nome: ");
			temp.nome = entrada.next();
			System.out.println("insira o cpf :");
			temp.cpf = entrada.next();
			p.adicionarCliente(temp);
			temp = null;
		}
		private static void removerCliente(Scanner entrada, PersistenciaArquivo p,Cliente temp) {
			System.out.println("insira o cpf...");
			temp.cpf = entrada.next();
			temp = p.localizarClienteCPF(temp.cpf);
			if(p.localizarClienteCPF(temp.cpf)==null) {
				System.out.println("conta não encontrada");
			}
			else {
				p.removerCliente(temp);
				System.out.println("Conta Removida");
				System.out.println("---------------------");
			}
		} 
		private static void criarConta(Scanner entrada,PersistenciaArquivo p, Cliente temp,Conta tempConta) {
			System.out.println("insira o cpf do cliente");
			String entradaCpf = entrada.next();
			temp = p.localizarClienteCPF(temp.cpf=entradaCpf);
			System.out.println("Insira o numero da nova conta:");
			tempConta.numeroConta = entrada.next();
			temp.adicionarConta(tempConta);
			checagem(entrada, p);
			
		}
		private static void removerConta(Scanner entrada,PersistenciaArquivo p, Cliente temp,Conta tempConta) {
			System.out.println("insira o cpf do cliente");
			String entradaCpf = entrada.next();
			temp = p.localizarClienteCPF(temp.cpf=entradaCpf);
			System.out.println("Insira o numero da conta:");
			tempConta.numeroConta = entrada.next();
			temp.removerConta(tempConta);	
	
			checagem(entrada, p);
			
		}
		
		private static void checagem(Scanner entrada,PersistenciaArquivo p) {
			System.out.println("Digite 1 para confirmar a operação \n ou 0 para recusar");
			int resposta = entrada.nextInt();
			p.confirmarOperacao(resposta);
					
		}
		private static void depositarQuantia(Scanner entrada,PersistenciaArquivo p, Cliente temp,Conta tempConta) {
			System.out.println("insira o cpf do cliente");
			String entradaCpf = entrada.next();
			temp =p.localizarClienteCPF(temp.cpf=entradaCpf);
			System.out.println("Insira o numero da conta:");
			tempConta.numeroConta = entrada.next();
			
			System.out.println("insira a quantia a ser depositada:");
			float quantia = entrada.nextFloat();
			
			p.localizarClienteCPF(entradaCpf).realizarDeposito(tempConta.numeroConta, quantia);
			
			System.out.println(p.localizarClienteCPF(entradaCpf).localizarConta(tempConta.numeroConta));
			checagem(entrada, p);
			
		}
		private static void sacarQuantia(Scanner entrada,PersistenciaArquivo p, Cliente temp,Conta tempConta) {
			System.out.println("insira o cpf do cliente");
			String entradaCpf = entrada.next();
			temp =p.localizarClienteCPF(temp.cpf=entradaCpf);
			System.out.println("Insira o numero da conta:");
			tempConta.numeroConta = entrada.next();
			
			System.out.println("insira a quantia a ser sacada:");
			float quantia = entrada.nextFloat();
			
			p.localizarClienteCPF(entradaCpf).realizarSaque(tempConta.numeroConta, quantia);
			
			System.out.println(p.localizarClienteCPF(entradaCpf).localizarConta(tempConta.numeroConta));
			
			
			checagem(entrada, p);
		}
		public static void limparTela(){
			
			for(int i=0;i<100;i++) {
				System.out.println("");
			}
		}
		
}

