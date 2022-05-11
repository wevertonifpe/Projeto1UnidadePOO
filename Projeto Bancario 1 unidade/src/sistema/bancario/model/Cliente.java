package sistema.bancario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cpf;
	String nome;

	private List<Conta> contas = new ArrayList<>();

	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Cliente(String cpf)
	{
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
	}

	public void adicionarConta(Conta c)
	{
		if(!contas.contains(c))
			contas.add(c);
		else
			System.out.println("Conta já cadastrada!");
	}
	
	public void removerConta(Conta c)
	{
		if(contas.contains(c))
			contas.remove(c);
			
		else
			System.out.println("Conta não cadastrada!");
	}
	
	public Conta localizarConta(String numeroConta)
	{
		Conta temp = new Conta(numeroConta);
		if(contas.contains(temp))
		{
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			return temp;
		}
		else
			return null;
	}
	
	public void realizarDeposito(String numeroConta,float quantia)
	{
		Conta temp = new Conta(numeroConta);
		if(contas.contains(temp))
		{
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			if(temp.status == true && quantia > 0) {
				temp.saldo = temp.saldo + quantia;
				System.out.println("deposito efetuado");
			}
		}
		else
			System.out.println();
	}
	public void realizarSaque(String numeroConta,float quantia) {
		
		Conta temp = new Conta(numeroConta);
		if(contas.contains(temp))
		{
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			if(temp.status == true && quantia <= temp.saldo) {
				temp.saldo = temp.saldo - quantia;
				System.out.println("saque efetuado");
			}
		}
		else
			System.out.println();
		
		
		
	}
		
	public boolean containsConta(Conta c)
	{
		if(contas.contains(c))
			return true;
		else
			return false;
	}
	

}
