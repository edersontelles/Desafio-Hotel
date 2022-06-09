/**
 * 
 */
package DesafioOO;

/**
 * @author Ederson
 *
 */
public class Check {
	
	private Integer idCliente, idQuarto;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Integer idQuarto) {
		this.idQuarto = idQuarto;
	}
	@Override
    public String toString() {
        return 	" ID Cliente: " + this.idCliente + 
        		" ID Quarto: " + this.idQuarto + 
        		" ";
    }
	

}
