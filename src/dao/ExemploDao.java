///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
///**
// *
// * @author Leandro
// */
//public class ExemploDao {
//
//    public void inserirCapa(PedidoDto pedido) {
//        String sql = "insert into inte_100 (codigo_registro,"
//                + "pedido_venda, tecido_peca, data_entrega,"
//                + "cliente9, cliente4, cliente2, nat_oper, nat_est_oper, tipo_registro, sit_importacao, data_importacao)"
//                + " values (?,?,?,?)";
//
//        try {
//
//            PreparedStatement PS = (PreparedStatement) connection.prepareStatement(sql);
//
//            PS.setInt(1, pedido.getCodigoRegistro());
//            PS.setInt(2, pedido.getPedidoVenda());
//            PS.setString(3, pedido.getTecidoPeca());
//            PS.setDate(4, pedido.getDataEntrega());
//            PS.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        conexao.fecharConexao();
//    }
//}
//
//}
