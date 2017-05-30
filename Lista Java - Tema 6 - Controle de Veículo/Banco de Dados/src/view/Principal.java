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
					chassi = JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					ArrayList<Veiculo> veiculos2dao = vdao.getLista();
					boolean encontrou = false;
					for(Veiculo veiculo2 : veiculos2dao){
						if(veiculo2.getNumerochassi().equalsIgnoreCase(chassi)){
							JOptionPane.showConfirmDialog(null, veiculo2.toString());
							encontrou = true;
						}
					}
					if(encontrou=false){
						JOptionPane.showConfirmDialog(null, "Ve�culo n�o encontrado");
					}
					break;
					
				case "3":
					chassi = JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					ArrayList<Veiculo> veiculos3dao = vdao.getLista();
					for(Veiculo veiculo3 : veiculos3dao){
						if(veiculo3.getNumerochassi().equalsIgnoreCase(chassi)){
							String opc2 = "";
							while(!opc2.equalsIgnoreCase("6")){
							opc2 = JOptionPane.showInputDialog(null,"O que deseja alterar? "+"\n"
									+ "1 - Placa \n"
									+ "2 - Marca \n"
									+ "3 - Modelo \n "
									+ "4 - Ano de Fabrica��o \n "
									+ "5 - Cor \n"
									+ "6 - Sair \n"
									);
							switch(opc2){
							
							case "1":
								placa = JOptionPane.showInputDialog("Digite a placa: ");
								veiculo3.setPlaca(placa);
								vdao.alterar(veiculo3);
								break;
								
							case "2":
								marca = JOptionPane.showInputDialog("Digite a marca: ");
								veiculo3.setMarca(marca);
								vdao.alterar(veiculo3);
								break;
								
							case "3":
								modelo = JOptionPane.showInputDialog("Digite o modelo: ");
								veiculo3.setModelo(modelo);
								vdao.alterar(veiculo3);
								break;
								
							case "4":
								ano =  Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabrica��o: "));
								veiculo3.setAnofabricacao(ano);
								vdao.alterar(veiculo3);
								break;
								
							case "5":
								cor = JOptionPane.showInputDialog("Digite a cor: ");
								veiculo3.setCor(cor);
								vdao.alterar(veiculo3);
								break;
							
							}
							}
						}
					}
					break;
					
				case "4":
					chassi = JOptionPane.showInputDialog("Numera��o do chassi do ve�culo: ");
					ArrayList<Veiculo> veiculos4dao = vdao.getLista();
					for(Veiculo veiculo4 : veiculos4dao){
						if(veiculo4.getNumerochassi().equalsIgnoreCase(chassi)){
							vdao.remover(veiculo4);
						}
					}
					
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
