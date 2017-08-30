package com.planner.empresarial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroCargo {
   public void salvar(CadastroCargo c) throws SQLException{
	   StringBuilder sql = new StringBuilder();
	   sql.append("INSERT INTO CÓDIGO ");
	   sql.append("(codigo, descricao, funcionario_codigo) ");
	   sql.append("VALUES (?, ?, ?, ?)" );
	   
	   Connection conexao = ConexaoFactory.conectar();
	   
	   PreparedStatement comando = conexao.prepareStatement(sql.toString());
	   
	   comando.setString(1, c.getDescricao());
	   comando.setDouble(2, c.getCodigo());
	   
	   comando.setLong(4, p.getFuncionario().getCodigo());
	   
	   comando.executeUpdate();
   }
   
   public ArrayList<Código> listar() throws SQLException {
	   StringBuilder sql = new StringBuilder();
	   sql.append("SELECT c.codigo, c.descricao,");
	   sql.append("FROM codigo c ");
	   sql.append("INNER JOIN funcionario f ON f.codigo = c.funcionario_descricao ");
	   
	   
	   
	   PreparedStatement comando = conexao.prepareStatement(sql.toString());
	   
	   ResultSet resultado = comando.executeQuery();
	   
	   ArrayList<CadastroCargo> itens = new ArrayList<CadastroCargo>();
	   
	   while(resultado.next()){
		  Funcionario f = new Funcionario();
		  f.setCodigo(resultado.getLong("f.codigo"));
		  f.setDescricao(resultado.getString("f.descricao"));
		  
		  Cargo c = new Cargo();
		  p.setCodigo(resultado.getLong("c.codigo"));
		  p.setDescricao(resultado.getString("c.descricao"));
		  
		  
		  itens.add(p);
	   }
	   return itens;
   }
   
   public void excluir(Cargo c) throws SQLException{
	   StringBuilder sql = new StringBuilder();
	   sql.append("DELETE FROM cargo ");
	   sql.append("WHERE codigo = ? ");
	   
	   Connection conexao = ConexaoFactory.conectar();
	   
	   PreparedStatement comando = conexao.prepareStatement(sql.toString());
	   comando.setLong(1, f.getCodigo());
	   
	   comando.executeUpdate();
   }
   
   public void editar(Cargo c) throws SQLException {
	   StringBuilder sql = new StringBuilder();
	   sql.append("UPDATE Cargo");
	   sql.append("SET descricao = ?, preco = ?, quantidade = ?, fabricante_codigo = ? ");
	   sql.append("WHERE codigo = ? ");
	   
	   Connection conexao = ConexaoFactory.conectar();
	   
	   PreparedStatement comando = conexao.prepareStatement(sql.toString());
	   
	   comando.setString(1, p.getDescricao());
	   comando.setDouble(2, p.getPreco());
	   comando.setLong(3, p.getQuantidade());
	   comando.setLong(4, p.getFabricante().getCodigo());
	   comando.setLong(5, p.getCodigo());
	   
	   comando.executeUpdate();
   }
}

