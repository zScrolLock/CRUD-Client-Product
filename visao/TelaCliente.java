/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleCliente;
import java.util.Scanner;

/**
 *
 * @author zScrolLock
 */
public class TelaCliente {
    ControleCliente controle = new ControleCliente();
	Scanner ler = new Scanner(System.in);
	
	public void adicionarCliente() {
            //int codigoCliente, String nome, String cpf, String endereco, String cidade, String estado, String telefone
		int codigoCliente; 
		String nome; 
		String cpf;
		String endereco; 
		String cidade; 
		String estado; 
		String telefone;
		
			System.out.println("CADASTRO DE CLIENTE CONVENIENCIA");
			System.out.print("Digite o Codigo do Cliente: ");
			codigoCliente = ler.nextInt();
			System.out.print("Digite o Nome do Cliente: ");
			nome = ler.nextLine();
			nome = ler.nextLine();
			System.out.print("Digite o CPF do Cliente: ");
			cpf = ler.nextLine();
			System.out.print("Digite o Endereco do Cliente: ");
			endereco = ler.nextLine();
			System.out.print("Digite a Cidade do Cliente: ");
			cidade = ler.nextLine();
			System.out.print("Digite o Estado do Cliente: ");
			estado = ler.nextLine();
			System.out.print("Digite o Telefone do Cliente: ");
			telefone = ler.nextLine();
			
                        try{
                            controle.inserirCliente(codigoCliente, nome, cpf, endereco, cidade, estado, telefone);
                        }catch(Exception e){
                            System.err.println("Nao foi possivel inserir Cliente\n");
                        }
	}
	
	public void alterarCliente() {
		int cod;
		String Novonome; 
		String Novocpf; 
		String Novoendereco; 
		String Novacidade; 
		String Novoestado; 
		String Novotelefone;
		
			System.out.print("Digite o Codigo do Cliente que Deseja Alterar: ");
			cod = ler.nextInt();
			
			System.out.println("\nALTERACAO DE DADOS CLIENTE");
			System.out.print("Digite o Nome do Cliente: ");
			Novonome = ler.nextLine();
			Novonome = ler.nextLine();
			System.out.print("Digite o CPF do Cliente: ");
			Novocpf = ler.nextLine();
			System.out.print("Digite o Endereco do Cliente: ");
			Novoendereco = ler.nextLine();
			System.out.print("Digite a Cidade do Cliente: ");
			Novacidade = ler.nextLine();
			System.out.print("Digite o Estado do Cliente: ");
			Novoestado = ler.nextLine();
			System.out.print("Digite o Telefone do Cliente: ");
			Novotelefone = ler.nextLine();
                        
                        try{
                            controle.alterarCliente(cod, Novonome, Novocpf, Novoendereco, Novacidade, Novoestado, Novotelefone);
                        }catch(Exception e){
                            System.err.println("Nao foi possivel alterar cliente ou ele nao existe\n");
                        }
	}
	
	public void apresentarCliente() {
		int cod;
		System.out.print("Digite o Codigo do Cliente que deseja exibir: ");
		cod = ler.nextInt();
		
                try{
                    controle.pesquisarCliente(cod);
                }catch(Exception e){
                    System.err.println("Nao ha cliente com esse codigo" + cod + "\n");
                }
	}
	
	public void relacaoCliente() {
            try{
		controle.listarTodosCliente();
            }catch(Exception e){
                System.err.println("Nao ha clientes para listar\n");
            }
	}
        
        public void excluirCliente(){
            int codigoCliente;
            System.out.println("Digite o Codigo do Cliente que Deseja Excluir: ");
            codigoCliente = ler.nextInt();
            
            try{
                controle.excluirCliente(codigoCliente);
            }catch(Exception e){
                System.err.println("Nao ha Clientes com esse codigo" + codigoCliente + "\n");
            }
        }
}
