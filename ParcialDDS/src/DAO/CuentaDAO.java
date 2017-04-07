package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import DbConnection.DbConnection;
import VO.CuentaVO;
import connection.*;


public class CuentaDAO {
	
	public CuentaVO consultarCuenta(String id) {
		CuentaVO cuenta = new CuentaVO();
		DbConnection dbConnection = new DbConnection();

		try {
			PreparedStatement c = dbConnection.getConnection().prepareStatement("SELECT * FROM cuenta where num_Cuenta = ? ");
			c.setString(1, id);
			ResultSet res = c.executeQuery();

			if (res.next()) {				
				cuenta.setId(Integer.parseInt(res.getString("id")));
				cuenta.setNumCuenta(res.getString("num_Cuenta"));
				cuenta.setIdCliente(Integer.parseInt(res.getString("idCliente")));
				cuenta.setSaldo(Double.parseDouble(res.getString("saldo")));
			}
			res.close();
			c.close();
			dbConnection.getConnection().close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la cuenta" + e);
		}
		return cuenta;
	}
	
	public void actualizar(CuentaVO c){
		DbConnection dbConnection = new DbConnection();		
		try{
			Statement senten = dbConnection.getConnection().createStatement();
			senten.executeUpdate("UPDATE cuenta set saldo ="+c.getSaldo()+" where "
			        +"num_Cuenta='"+c.getNumCuenta()+"';");			
			senten.close();
			dbConnection.getConnection().close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se actualizo!");
		}
		
	}

}
