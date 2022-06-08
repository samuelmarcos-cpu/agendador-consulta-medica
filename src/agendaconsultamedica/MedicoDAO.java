/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaconsultamedica;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author samu2
 */
public class MedicoDAO extends Conexao {

    public String cadastrarMedico(Medico medico) {
        try {
            String sentenca = "INSERT INTO MEDICO(NOME, ESPECIALIDADE, CRM, CPF) VALUES ('"
                    + medico.getNome() + "', "
                    + Integer.toString(medico.getEspecialidade()) + ", "
                    + Integer.toString(medico.getCrm()) + ", '"
                    + medico.getCpf() + "')";
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizarMedico(Medico medico) {
        try {
            String sentenca = "UPDATE MEDICO SET NOME = '" + medico.getNome()
                    + "' , ESPECIALIDADE = " + Integer.toString(medico.getEspecialidade())
                    + " , CRM = " + Integer.toString(medico.getCrm())
                    + " , CPF = '" + medico.getCpf()
                    + "' WHERE IDMEDICO = " + Integer.toString(medico.getIdMedico());
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirMedico(int idMedico) {
        try {
            String sentenca = "DELETE FROM MEDICO WHERE IDMEDICO = " + Integer.toString(idMedico);
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList listarMedicos() {
        try {
            ArrayList medicos = new ArrayList();
            String sentenca = "SELECT * FROM MEDICO ORDER BY NOME";
            ResultSet rs = this.getResultSet(sentenca);

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setIdMedico(rs.getInt("IDMEDICO"));
                medico.setNome(rs.getString("NOME"));
                medico.setEspecialidade(rs.getInt("ESPECIALIDADE"));
                medico.setCrm(rs.getInt("CRM"));
                medico.setCpf(rs.getString("CPF"));

                medicos.add(medico);
            }
            return medicos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
