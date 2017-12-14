package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Periodo")
public class Periodo 
{
	@Id
	@GeneratedValue
	private int id;
	private String desde;
	private String hasta;
	private int valorCuenta;
	
	@ManyToOne
	@JoinColumn(name="empresa_cuenta_id", nullable=false)
	private EmpresaCuenta empresaCuenta;
	
	public int getValorCuenta() {
		return valorCuenta;
	}
	public void setValorCuenta(int valor) {
		this.valorCuenta = valor;
	}
	
	
	public EmpresaCuenta getCuenta() {
		return empresaCuenta;
	}
	public void setCuenta(EmpresaCuenta cuenta) {
		this.empresaCuenta = cuenta;
	}
	public int getId() {
		return id;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde=desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta=hasta;
	}
}
