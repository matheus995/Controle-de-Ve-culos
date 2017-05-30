package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.VeiculoDAO;
import entidade.Veiculo;

public class Principal {

	public static void main(String[] args) throws SQLException {
		VeiculoDAO vdao = new VeiculoDAO();
		String chassi;
		
		
		String opc = "";
		
		while(!opc.equalsIgnoreCase("6")){
			
			try {
				opc = JOptionPane.showInputDialog(null," " 
									+ "1 - Cadastrar Ve�culo \n"
									+ "2 - Consultar ve�culo \n"
									+ "3 - Alterar ve�culo \n "
									+ "4 - Excluir ve�culo \n "
									+ "5 - Listar ve�culos \n"
									+ "6 - Encerrar sistema");
				
				switch(opc){
				
				case "1":
					String placa = JOptionPane.showInputDialog("Numera��o da placa: ");
					String marca = JOptionPane.showInputDialog("Marca do ve�culo: ");
					String modelo = JOptionPane.showInputDialog("Modelo do ve�culo: ");
					int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabrica��o do ve�culo: "));
					String cor = JOptionPane.showInputDialog("Cor do ve�culo: ");
					chassi = JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, cor, chassi);
					vdao.adicionar(veiculo);
					break;
					
				case "2":
					JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					break;
					
				case "3":
					JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					break;
					
				case "4":
					chassi = JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					Veiculo veiculo4 = new Veiculo();
					veiculo4.setNumerochassi(chassi);
					vdao.remover(veiculo4);
					break;
					
				case "5":
					ArrayList<Veiculo> veiculos = vdao.getLista();
					JOptionPane.showConfirmDialog(null, veiculos);
					break;
					
				case "6":
					System.exit(0);
					
				}
				
			} catch (Exception e) {
				
			}
		}
		
	}

}
