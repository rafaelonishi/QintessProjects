package com.qintess.Desafio2;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Comandos do SQL
  //Maior numero de compras:select * from (select *,(select count(1) from venda where idcliente = cliente.idcliente group by idcliente) as qtdvendasvendafrom cliente) tab order by qtdvendasvenda desc
  

public class Conection {
	
	public static void main(String [] args) throws SQLException{
		String url = "jdbc:h2:~/Desafio2";
		String user = "sa";
		String password = "";
		
		try {
		Connection conexao = DriverManager.getConnection(url,user, password);
			if (conexao != null) {
				
				//Insert
				String sqlInsert = "INSERT INTO ITENS_DA_VENDA(QTD, SUBTOTAL,IDVENDA,IDLIVRO) VALUES (?,?,?,?)";
				
				PreparedStatement statementInsert = conexao.prepareStatement(sqlInsert);
				statementInsert.setInt(1, 2);
				statementInsert.setInt(2, 60);
				statementInsert.setInt(3, 1);
				statementInsert.setInt(4, 3);
			
				
				int rowsInserted = statementInsert.executeUpdate();
				if (rowsInserted >0) {
					System.out.println("Foi inserido com sucesso");
				}
				
				//Select
				String sqlSelect = "SELECT * FROM ITENS_DA_VENDA";
				
				Statement statement = conexao.createStatement();
				ResultSet result = statement.executeQuery(sqlSelect);
				
				int count = 0;
				
				while(result.next()) {
					int qtd = result.getInt(1);
					int subTo = result.getInt(2);
					int idvenda = result.getInt(3);
					int idcliente = result.getInt(4);
					
					String output = "Informações inseridas #%d: %s - %s - %s - %s";
					System.out.println(String.format(output, ++count, "Quantidade de livros:"+qtd,"Subtotal:"+subTo,"ID da venda:"+idvenda,"ID do cliente:"+ idcliente));
				}
			}
			//String sqlUpdate = "Update ITENS_DA_VENDA SET QTD=?, SUBTOTAL=?";
			
			//PreparedStatement statementUpdate = conexao.prepareStatement(sqlUpdate);
			//statementUpdate.setInt(1, 3435546);
			//statementUpdate.setInt(2, 84983893);
			
			//int Update = statementUpdate.executeUpdate();
			//if(Update > 0) {
				//System.out.println("Sucesso na atualização");
			//}
			
			//String sqlDelete = "DELETE FROM ITENS_DA_VENDA WHERE QTD=?";
			//PreparedStatement statementDelete = conexao.prepareStatement(sqlDelete);
			//statementDelete.setInt(1, 5);
			//int Delete = statementDelete.executeUpdate();
			//if(Delete>0) {
				//System.out.println("O usuario foi deletado com sucesso:");
			//}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
