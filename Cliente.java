/**
 * 
 */
package DesafioOO;

/**
 * @author Ederson
 *
 */
public class Cliente {
	
	private String nome, dataNs, email, cidade, uf;
	private Boolean fumanteCliente, checkInFeito;
	
	public Boolean getCheckInFeito() {
		return checkInFeito;
	}
	public void setCheckInFeito(Boolean checkInFeito) {
		this.checkInFeito = checkInFeito;
	}
	private Integer telefone, id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNs() {
		return dataNs;
	}
	public void setDataNs(String dataNs) {
		this.dataNs = dataNs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Boolean getFumante() {
		return fumanteCliente;
	}
	public void setFumante(Boolean fumante) {
		this.fumanteCliente = fumante;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	@Override
    public String toString() {
        return 	" ID: " + this.id + 
        		" NOME: " + this.nome + 
        		" Fumante: " + this.fumanteCliente +  
        		" DN: " + this.dataNs +  
        		" Email: " + this.email +  
        		" Cidade: " + this.cidade + 
        		" UF: " + this.uf + 
        		" Telefone: " + this.telefone + 
        		" ";
    }
	
}
