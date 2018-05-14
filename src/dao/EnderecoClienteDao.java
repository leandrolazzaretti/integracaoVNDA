/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.ConexaoBanco;
import dto.EnderecoClienteDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author Leandro
 */
public class EnderecoClienteDao {
    private final ConexaoBanco conexao;
    private final Connection connection;
    
    public EnderecoClienteDao(){
        this.conexao = new ConexaoBanco();
        this.connection = conexao.abrirConexao();
}
    
    //INSERE UM ENDEREÇO NA TABELA INTE_150
    
    public void insertEndereco(EnderecoClienteDto entrega) {
        String sql = "insert into inte_150 "
                + "(cd_cli_cgc_cli9,"
                + " cd_cli_cgc_cli4,"
                + " cd_cli_cgc_cli2,"
                + " seq_endereco,"
                + " tipo_endereco,"
                + " end_entr_cobr,"
                + " cgc_entr_cobr9,"
                + " cgc_entr_cobr4,"
                + " cgc_entr_cobr2,"
                + " ie_entr_cobr,"
                + " cep_entr_cobr,"
                + " bairro_entr_cobr,"
                + " cid_entr_cobr,"
                + " fone_entr_cobr,"
                + " gera_nota_entreg,"
                + " cidade_cif,"
                + " numero_imovel,"
                + " complemento_endereco)"
                + "values ("
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?"
                + ")";

        try {
            
            PreparedStatement PS = (PreparedStatement) connection.prepareStatement(sql);

            PS.setInt(1, entrega.getCdCliCgcCli9());
            PS.setInt(2, entrega.getCdCliCgcCli4());
            PS.setInt(3, entrega.getCdCliCgcCli2());
            PS.setInt(4, entrega.getSeqEndereco());
            PS.setInt(5, entrega.getTipoEndereco());
            PS.setString(6, entrega.getEndEntrCobr());
            PS.setInt(7, entrega.getCgcEntrCobr9());
            PS.setInt(8, entrega.getCgcEntrCobr4());
            PS.setInt(9, entrega.getCgcEntrCobr2());
            PS.setString(10, entrega.getIeEntrCobr());
            PS.setInt(11, entrega.getCepEntrCobr());
            PS.setString(12, entrega.getBairroEntrCobr());
            PS.setInt(13, entrega.getCidEntrCobr());
            PS.setInt(14, entrega.getFoneEntrCobr());
            PS.setInt(15, entrega.getGeraNotaEntreg());
            PS.setInt(16, entrega.getCidadeCif());
            PS.setString(17, entrega.getNumeroImovel());
            PS.setString(18, entrega.getComplementoEndereco());
            PS.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
//    /**
//     * lista endereços de entrega e cobrança que foram inseridos de acordo com
//     * IDs da webstorm
//     *
//     * @param conn
//     * @param idWbst
//     * @param idClienteWbst
//     * @return
//     */
//   public static List<EnderecoClienteDto> listEnderecosIntegrados(AppConnection conn,int idWbst, int idClienteWbst) {
//        final String sql = "select wbst.id_wbst, wbst.id_cliente_wbst, inte.* from wbst_051 wbst "
//                + "join inte_150 inte on"
//                + " wbst.cd_cli_cgc_cli9 = inte.cd_cli_cgc_cli9 and"
//                + " wbst.cd_cli_cgc_cli4 = inte.cd_cli_cgc_cli4 and"
//                + " wbst.cd_cli_cgc_cli2 = inte.cd_cli_cgc_cli2 and"
//                + " wbst.seq_endereco = inte.seq_endereco and"
//                + " wbst.id_cliente_wbst = ? and"
//                + " wbst.id_wbst = ?";
//
//        AppConnection connection = new AppConnection(conn, sql, idClienteWbst, idWbst);
//        return Sqls.stream(connection, s -> s.map(EnderecoDao::parserFull).collect(toList()));
//    }
//
//    /**
//     * Parseia endereço com todas as informações
//     *
//     * @param conn
//     * @return
//     */
//   public static EnderecoClienteDto parserFull(AppConnection conn) {
//        EnderecoClienteDto entrega = parser(conn);
//        entrega.tipo = conn.getInt("tipo_endereco");
//        entrega.endereco = conn.getString("end_entr_cobr");
//        entrega.cgc9 = conn.getInt("cgc_entr_cobr9");
//        entrega.cgc4 = conn.getInt("cgc_entr_cobr4");
//        entrega.cgc2 = conn.getInt("cgc_entr_cobr2");
//        entrega.ie_entr_cobr = conn.getString("ie_entr_cobr");
//        entrega.cep = conn.getInt("cep_entr_cobr");
//        entrega.bairro = conn.getString("bairro_entr_cobr");
//        entrega.cid_entr_cobr = conn.getInt("cid_entr_cobr");
//        entrega.fone = conn.getInt("fone_entr_cobr");
//        entrega.geraNotaEntrega = conn.getInt("fone_entr_cobr");
//        entrega.cidade_cif = conn.getInt("cidade_cif");
//        entrega.numeroImovel = conn.getString("numero_imovel");
//        entrega.complemento = conn.getString("complemento_endereco");
//        return entrega;
//    }
//
//      /**
//     * Parseia apenas informações base de identificação do endereço
//     * @param conn
//     * @return
//     */
//   public static EnderecoDto parser(AppConnection conn) {
//        EnderecoDto entrega = new EnderecoDto();
//        entrega.idWebstorm = conn.getInt("id_wbst");
//        entrega.cliente9 = conn.getInt("cd_cli_cgc_cli9");
//        entrega.cliente4 = conn.getInt("cd_cli_cgc_cli4");
//        entrega.cliente2 = conn.getInt("cd_cli_cgc_cli2");
//        entrega.seq = conn.getInt("seq_endereco");
//        return entrega;
//    }
//   
//    public static int updateEndereco(EnderecoClienteDto entrega) {
//        String sql = "update inte_150 set" +
//                " tipo_endereco = ?" +
//                " end_entr_cobr = ?" +
//                " cgc_entr_cobr9 = ?" +
//                " cgc_entr_cobr4 = ?" +
//                " cgc_entr_cobr2 = ?" +
//                " ie_entr_cobr = ?" +
//                " cep_entr_cobr = ?" +
//                " bairro_entr_cobr = ?" +
//                " cid_entr_cobr = ?" +
//                " fone_entr_cobr = ?" +
//                " gera_nota_entreg = ?" +
//                " cidade_cif = ?" +
//                " numero_imovel = ?" +
//                " complemento_endereco = ?" +
//                "where" +
//                " cd_cli_cgc_cli9 = ?" +
//                " cd_cli_cgc_cli9 = ?" +
//                " cd_cli_cgc_cli9 = ?" +
//                " seq_endereco = ?";
//        try {
//            PreparedStatement PS = (PreparedStatement) connection.prepareStatement(sql);
//            
//                PS.setInt(1, entrega.getTipoEndereco()); 
//                PS.setString(2, entrega.getEndEntrCobr()); 
//                PS.setInt(3, entrega.getCgcEntrCobr9());
//                PS.setInt(4, entrega.getCgcEntrCobr4());
//                PS.setInt(5, entrega.getCgcEntrCobr2());
//                PS.setString(6, entrega.getIeEntrCobr()); 
//                PS.setInt(7, entrega.getCepEntrCobr()); 
//                PS.setString(8, entrega.getBairroEntrCobr());
//                PS.setInt(9, entrega.getCidEntrCobr());
//                PS.setInt(10, entrega.getFoneEntrCobr());
//                PS.setInt(11, entrega.getGeraNotaEntreg());
//                PS.setInt(12, entrega.getCidadeCif());
//                PS.setString(13, entrega.getNumeroImovel());
//                PS.setString(14, entrega.getComplementoEndereco());
//                PS.setInt(15, entrega.getCdCliCgcCli9());
//                PS.setInt(16, entrega.getCdCliCgcCli4());
//                PS.setInt(17, entrega.getCdCliCgcCli2());
//                PS.setInt(18, entrega.getSeqEndereco());
//                PS.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        conexao.fecharConexao();                    
//    }
//
//    public static int getNextSequence(AppConnection conn, int cgc9, int cgc4, int cgc2) {
//        final String sql = "select " +
//                "max(seq_endereco) as last_sequence " +
//                "from " +
//                "(SELECT seq_endereco" +
//                " FROM pedi_150 " +
//                "WHERE pedi_150.cd_cli_cgc_cli9 = ?" +
//                " AND   pedi_150.cd_cli_cgc_cli4 = ?" +
//                " AND   pedi_150.cd_cli_cgc_cli2 = ? " +
//                "UNION ALL " +
//                "SELECT seq_endereco " +
//                "FROM inte_150 " +
//                "WHERE inte_150.cd_cli_cgc_cli9 = ? " +
//                "AND   inte_150.cd_cli_cgc_cli4 = ? " +
//                "AND   inte_150.cd_cli_cgc_cli2 = ?)";
//        AppConnection connection = new AppConnection(conn, sql,
//                cgc9, cgc4, cgc2,
//                cgc9, cgc4, cgc2);
//
//        connection.executeAndNext1();
//        int currentSequence = connection.getInt("last_sequence");
//
//        return ++currentSequence;
//
//
//     public static EnderecoDto getEnderecoEntrega(AppConnection conn, int cgc9, int cgc4, int cgc2) {
//        final String sql = "select * from pedi_150 "
//                + "where pedi_150.cd_cli_cgc_cli9 =  ? "
//                + "and pedi_150.cd_cli_cgc_cli4 = ? "
//                + "and pedi_150.cd_cli_cgc_cli2 = ? "
//                + "and tipo_endereco = 1 "
//                + "and seq_endereco = 1 ";
//        AppConnection connection = new AppConnection(conn, sql, cgc9, cgc4, cgc2);
//        if (connection.executeAndNext1()) return parser(connection);
//        return null;
//    }
//    
//}
}
