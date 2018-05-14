/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ClienteDto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dal.ConexaoBanco;
import java.sql.Connection;
/**
 *
 * @author Leandro
 */
public class ClienteDao {
    private final ConexaoBanco conexao;
    private final Connection connection;
    
    public ClienteDao(){
        this.conexao = new ConexaoBanco();
        connection = this.conexao.abrirConexao();
    }
    
    // INSERE UM CLIENTE NA TABELA INTE_010
    
    public void insertCliente(ClienteDto cliente) {
        String sql = "insert into inte_010 ( "
                + "tipo_registro, "
                + "cgc_9, "
                + "cgc_4, "
                + "cgc_2, "
                + "nome_cliente, "
                + "fantasia_cliente, "
                + "fisica_juridica, "
                + "endereco_cliente, "
                + "bairro, "
                + "cod_cidade, "
                + "e_mail, "
                + "cep_cliente, "
                + "insc_est_cliente, "
                + "nfe_e_mail, "
                + "celular_cliente, "
                + "sub_regiao, "
                + "cdrepres_cliente, "
                + "tipo_cliente, "
                + "data_cad_cliente, "
                + "portador_cliente,"
                + "situacao_cadastro,"
                + "complemento,"
                + "numero_imovel,"
                + "TRAN_CLI_FORNE9,"
                + "TRAN_CLI_FORNE4,"
                + "TRAN_CLI_FORNE2,"
                + "telefone_cliente"
                + ") values ("
                + "?, " //1 tipo_registro
                + "?, " //2 cgc9
                + "?, " //3 cgc4
                + "?, " //4 cgc2
                + "?, " //5 nome_cliente
                + "?, " //6 fantasia
                + "?, " //7 fisica_juridica
                + "?, " //8 endereco
                + "?, " //9 bairro
                + "?, " //10 cod_cidade
                + "?, " //11 email
                + "?, " //12 cep
                + "?, " //13 inscricaoEstadual
                + "?, " //14 nfe email
                + "?, " //15 celular
                + "?, " //16 subregiao BRASIL
                + "?, " //17 representante
                + "?, " //18 tipo_cliente
                + "sysdate," // data_cadastro
                + "?," //19 portador 
                + "?," //20 situacao cadastro
                + "?," //21 complemento
                + "?," //22 numero imovel
                + "?," //23 Transportadora cgc9
                + "?," //24 Transportadora cgc4
                + "?," //25 Transportadora cgc2
                + "?" //26 telefone_cliente
                + ")";
        
        try {
            PreparedStatement PS = (PreparedStatement) connection.prepareStatement(sql);

            PS.setInt(1, cliente.getTipoRegistro());
            PS.setInt(2, cliente.getCgc9());
            PS.setInt(3, cliente.getCgc4());
            PS.setInt(4, cliente.getCgc2());
            PS.setString(5, cliente.getNomeCliente());
            PS.setString(6, cliente.getFantasiaCliente());
            PS.setString(7, cliente.getFisicaJuridica());
            PS.setString(8, cliente.getEnderecoCliente());
            PS.setString(9, cliente.getBairro());
            PS.setInt(10, cliente.getCodCidade());
            PS.setString(11, cliente.getEmail());
            PS.setInt(12, cliente.getCepCliente());
            PS.setString(13, cliente.getInscEstCliente());
            PS.setString(14, cliente.getNfeEmail());
            PS.setInt(15, cliente.getCelularCliente());
            PS.setInt(16, cliente.getSubRegiao());
            PS.setInt(17, cliente.getCdrepresCliente());
            PS.setInt(18, cliente.getTipoCliente());
            PS.setInt(19, cliente.getPortadorCliente());
            PS.setString(20, cliente.getSituacaoCadastro());
            PS.setString(21, cliente.getComplemento());
            PS.setString(22, cliente.getNumeroImovel());
            PS.setInt(23, cliente.getTranCliForne9());
            PS.setInt(24, cliente.getTranCliForne4());
            PS.setInt(25, cliente.getTranCliForne2());
            PS.setInt(26, cliente.getTelefoneCliente());
            PS.execute();           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao.fecharConexao();
    }

//    public static int updateInte(ClienteDto dto) {
//        final String sql = "update inte_010 set"
//                + " nome_cliente = ?"
//                + " fantasia_cliente = ?"
//                + " endereco_cliente = ?"
//                + " bairro = ?"
//                + " cod_cidade = ?"
//                + " insc_est_cliente = ?"
//                + " e_mail = ?"
//                + " nfe_e_mail = ?"
//                + " celular_cliente = ?"
//                + " tipo_cliente = ?"
//                + " complemento = ?"
//                + " numero_imovel = ?"
//                + " telefone_cliente = ?"
//                + "where"
//                + //" tipo_registro = 1" +
//                " cgc_9 = ? and"
//                + " cgc_4 = ? and"
//                + " cgc_2 = ? and";
//
//        try {
//            PreparedStatement PS = (PreparedStatement) connection.prepareStatement(sql);
//                
//                PS.setString(1, cliente.getNomeCliente());
//                PS.setString(2, cliente.getFantasiaCliente());
//                PS.setString(3, cliente.getEnderecoCliente());
//                PS.setString(4, cliente.getBairro());
//                dto.codCidade,
//                dto.inscricaoEstadual,
//                dto.email,
//                dto.email,
//                dto.celular,
//                dto.tipoCliente,
//                dto.complemento,
//                dto.numeroImovel,
//                dto.fone,
//                dto.cgc9,
//                dto.cgc4,
//                dto.cgc2
//             
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        conexao.fecharConexao();
//    }
    
}
