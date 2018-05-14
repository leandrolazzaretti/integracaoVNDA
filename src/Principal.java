/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dal.ConexaoBanco;
import java.util.Scanner;
import dao.EnderecoClienteDao;
import dto.EnderecoClienteDto;
import java.sql.SQLException;
import java.sql.Date;
import dao.ClienteDao;
import dto.ClienteDto;

/**
 *
 * @author Leandro
 */
public class Principal {

    public static void main(String[] args) {

        System.out.println("Programa MachoAlfa");

        ConexaoBanco conn = new ConexaoBanco();
        Scanner ler = new Scanner(System.in);
        EnderecoClienteDto endereco = new EnderecoClienteDto();
        EnderecoClienteDao enderecoDao = new EnderecoClienteDao();
        ClienteDto cliente = new ClienteDto();
        ClienteDao clienteDao = new ClienteDao();
        Date data = new Date(System.currentTimeMillis());

        conn.abrirConexao();
        int tipoRegistro;
        System.out.println("Informe o tipo do registro");
        tipoRegistro = ler.nextInt();

        cliente.setTipoRegistro(tipoRegistro);
        cliente.setCgc9(1);
        cliente.setCgc4(1);
        cliente.setCgc2(1);
        cliente.setNomeCliente("Malaquias");
        cliente.setFantasiaCliente("Maleq");
        cliente.setFisicaJuridica(null);
        cliente.setEnderecoCliente("as");
        cliente.setBairro("as");
        cliente.setCodCidade(1);
        cliente.setTelefoneCliente(1);
        cliente.setFaxCliente(1);
        cliente.setTelexCliente(1);
        cliente.setEmail("as");
        cliente.setCxpostalCliente("asd");
        cliente.setCepCliente(1);
        cliente.setInscEstCliente("as");
        cliente.setNrSuframaCli("asd");
        cliente.setSubRegiao(1);
        cliente.setPortadorCliente(1);
        cliente.setPercDescDuplic(1);
        cliente.setCdrepresCliente(1);
        cliente.setTranCliForne9(1);
        cliente.setTranCliForne4(1);
        cliente.setTranCliForne2(1);
        cliente.setDataCadCliente(data);
        cliente.setSitImportacao(1);
        cliente.setDataArquivo(data);
        cliente.setDataImportacao(data);
        cliente.setNumeroRegJunta("as");
        cliente.setValorFaturamentoAnual(1);
        cliente.setValorComprasMensal(1);
        cliente.setPredioProprio("S");
        cliente.setSugLimiteMaxPed1(1);
        cliente.setSugLimiteMaxPed2(1);
        cliente.setSugLimiteMaxPed4(1);
        cliente.setSugLimiteMaxPed7(1);
        cliente.setDataFundacao(data);
        cliente.setNumeroFiliais(1);
        cliente.setCapitalAtual(1);
        cliente.setNumeroImovel("as");
        cliente.setComplemento("as");
        cliente.setNfeEmail("asd");
        cliente.setGrupoEconomico(1);
        cliente.setTipoCliente(1);
        cliente.setSegmentoMercado(1);
        cliente.setOrigem(1);
        cliente.setCelularCliente(1);
        cliente.setSituacaoCadastro(null);
        cliente.setBairroEcommerce("as");
        cliente.setComplementoEcommerce("asd");
        cliente.setDddCelularEcommerce(1);
        cliente.setDddFixoEcommerce(1);
        cliente.setTipoEmpresa(1);
        cliente.setDataValidSuframa(data);

        clienteDao.insertCliente(cliente);

        try {
            conn.conexao.commit();;
        } catch (SQLException e) {
            e.printStackTrace();
        }

   

        endereco.setCdCliCgcCli9(1);
        endereco.setCdCliCgcCli4(1);
        endereco.setCdCliCgcCli2(1);
        endereco.setSeqEndereco(1);
        endereco.setTipoEndereco(1);
        endereco.setEndEntrCobr("asd");
        endereco.setCgcEntrCobr9(1);
        endereco.setCgcEntrCobr4(1);
        endereco.setCgcEntrCobr2(1);
        endereco.setIeEntrCobr("asd");
        endereco.setCepEntrCobr(1);
        endereco.setBairroEntrCobr("asd");
        endereco.setCidEntrCobr(1);
        endereco.setFoneEntrCobr(1);
        endereco.setGeraNotaEntreg(1);
        endereco.setCidadeCif(1);
        endereco.setNumeroImovel("asd");
        endereco.setComplementoEndereco("asd");
        
        enderecoDao.insertEndereco(endereco);
        
        try {
            conn.conexao.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.fecharConexao();
    }
}
