package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresa_cuenta")
public class EmpresaCuenta {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
    @JoinColumn(name="empresa_id", nullable=false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", nullable=false)
	private Cuenta cuenta;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="empresaCuenta")
	private List<Periodo> periodo;
	
	public EmpresaCuenta() {
		// TODO Auto-generated constructor stub
	}

	
	public List<Periodo> getPeriodo() {
		return periodo;
	}

	public void setPeriodo(List<Periodo> periodo) {
		this.periodo = periodo;
	}


	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public int getId() {
		return id;
	}	

}
