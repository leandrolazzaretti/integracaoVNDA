/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Leandro
 */
public class ConexaoBanco {

    public Connection conexao;
    private final String url = "jdbc:oracle:thin:@192.168.0.254:1521:xe";
    private final String user = "systextil";
    private final String password = "oracle";
    private final String tpConexao = "oracle.jdbc.driver.OracleDriver";

    public Connection abrirConexao() {

        try {
            Class.forName(this.tpConexao);
            this.conexao = DriverManager.getConnection(this.url, this.user, this.password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.conexao;
    }

    public void fecharConexao() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
