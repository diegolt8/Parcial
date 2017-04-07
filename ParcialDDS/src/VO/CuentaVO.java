package VO;

public class CuentaVO {
	
	
	private int id;
	private String numeroCuenta;
	private int idCliente;
	private double saldo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumCuenta() {
		return numeroCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numeroCuenta = numCuenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
