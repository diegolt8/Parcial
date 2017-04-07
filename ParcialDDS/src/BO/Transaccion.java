package BO;

import VO.CuentaVO;

import javax.swing.JOptionPane;

import DAO.CuentaDAO;
public class Transaccion {
	
	CuentaDAO cuentaDAO;
	
	public void Transaccion(String Cuenta1, String Cuenta2, double monto){
		cuentaDAO = new CuentaDAO();
		CuentaVO cUno = cuentaDAO.consultarCuenta(Cuenta1);
		CuentaVO cDos = cuentaDAO.consultarCuenta(Cuenta2);
		
		if(cUno != null && cDos != null && cDos.getSaldo() >= monto){
			cUno.setSaldo(cUno.getSaldo()+monto);
			cDos.setSaldo(cDos.getSaldo()-monto);
			cuentaDAO.actualizar(cUno);
			cuentaDAO.actualizar(cDos);
			JOptionPane.showMessageDialog(null, "La operaci�n se realizo con exito! ", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "No se pudo realizar la operaci�n");
		}
		
		
	}

}


	


