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
									+ "1 - Cadastrar Veículo \n"
									+ "2 - Consultar veículo \n"
									+ "3 - Alterar veículo \n "
									+ "4 - Excluir veículo \n "
									+ "5 - Listar veículos \n"
									+ "6 - Encerrar sistema");
				
				switch(opc){
				
				case "1":
					String placa = JOptionPane.showInputDialog("Numeração da placa: ");
					String marca = JOptionPane.showInputDialog("Marca do veículo: ");
					String modelo = JOptionPane.showInputDialog("Modelo do veículo: ");
					int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação do veículo: "));
					String cor = JOptionPane.showInputDialog("Cor do veículo: ");
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, cor, chassi);
					vdao.adicionar(veiculo);
					break;
					
				case "2":
					JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					break;
					
				case "3":
					JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					break;
					
				case "4":
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
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
