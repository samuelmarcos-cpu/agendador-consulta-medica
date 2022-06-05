/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marcosssm;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author samu2
 */
public class ConsultaDAO extends Conexao {

    public String cadastrarConsulta(Consulta consulta) {
        try {
            String sentenca = "INSERT INTO CONSULTA(IDMEDICO, IDPACIENTE, CONVENIO) VALUES ("
                    + Integer.toString(consulta.getIdMedico()) + ", "
                    + Integer.toString(consulta.getIdPaciente()) + ", '"
                    + consulta.getConvenio() + "')";
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizarConsulta(Consulta consulta) {
        try {
            String sentenca = "UPDATE CONSULTA SET IDMEDICO = " + Integer.toString(consulta.getIdMedico())
                    + " , IDPACIENTE = " + Integer.toString(consulta.getIdPaciente())
                    + " , CONVENIO = '" + consulta.getConvenio()
                    + "' WHERE IDCONSULTA = " + Integer.toString(consulta.getIdConsulta());
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirConsulta(int idConsulta) {
        try {
            String sentenca = "DELETE FROM CONSULTA WHERE IDCONSULTA = " + Integer.toString(idConsulta);
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList listarConsultas() {
        try {
            ArrayList consultas = new ArrayList();
            String sentenca = "SELECT IDCONSULTA, CONCAT(MED.IDMEDICO, \" - \", MED.NOME) AS MEDICO, CONCAT(PAC.IDPACIENTE, \" - \", PAC.NOME) AS PACIENTE, CONVENIO FROM CONSULTA CON LEFT JOIN MEDICO MED ON MED.IDMEDICO = CON.IDMEDICO LEFT JOIN PACIENTE PAC ON PAC.IDPACIENTE = CON.IDPACIENTE ORDER BY CONVENIO;";
            ResultSet rs = this.getResultSet(sentenca);

            while (rs.next()) {
                ConsultaView consulta = new ConsultaView();
                consulta.setIdConsulta(rs.getInt("IDCONSULTA"));
                consulta.setMedico(rs.getString("MEDICO"));
                consulta.setPaciente(rs.getString("PACIENTE"));
                consulta.setConvenio(rs.getString("CONVENIO"));

                consultas.add(consulta);
            }
            return consultas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
