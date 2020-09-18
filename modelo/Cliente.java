package modelo;

public class Cliente {
	private int codigoCliente;
	private String nome;
	private String cpf;
	private String endereco;
	private String cidade;
	private String estado;
	private String telefone;
	
	public Cliente() {
		
	}
	
	public Cliente(int codigoCliente, String nome, String cpf, String endereco, String cidade, String estado, String telefone) {
		this.codigoCliente = codigoCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}
	

	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Codigo Cliente: " + codigoCliente + " Nome: " + nome + " CPF: " + cpf + " Endereco: " + endereco + " Cidade: " + cidade + " Estado: " + estado + " Telefone: " + telefone + "\n";
	}
	
}
