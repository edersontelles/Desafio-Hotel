/**
 * 
 */
package DesafioOO;

/**
 * @author Ederson
 *
 */
public class Quarto {
	private Integer id;
	private String nome;
	private Boolean fumante, disponive;
	
	public Boolean getDisponive() {
		return disponive;
	}
	public void setDisponive(Boolean disponive) {
		this.disponive = disponive;
	}
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
	public Boolean getFumante() {
		return fumante;
	}
	public void setFumante(Boolean fumanteQuarto) {
		this.fumante = fumanteQuarto;
	}
	@Override
    public String toString() {
        return 	" ID: " + this.id + 
        		" NOME: " + this.nome + 
        		" Fumante: " + this.fumante + 
        		" Disponivel: " + this.disponive + 
        		" ";
    }
	
}
