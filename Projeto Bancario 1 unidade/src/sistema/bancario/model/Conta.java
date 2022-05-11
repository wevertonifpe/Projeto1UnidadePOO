package sistema.bancario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import sistema.bancario.persistencia.PersistenciaArquivo;

public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	float saldo;
	Date dataAbertura;
	boolean status;
	
	public Conta(String numeroConta)
	{
		this.numeroConta = numeroConta;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = new Date();
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numeroConta, other.numeroConta);
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura + ", status="
				+ status + "]";
	}
	
}
	

