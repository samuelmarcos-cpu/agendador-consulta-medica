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
public class PacienteDAO extends Conexao {

    public String cadastrarPaciente(Paciente paciente) {
        try {
            String sentenca = "INSERT INTO PACIENTE(NOME, CPF, IDADE) VALUES ('"
                    + paciente.getNome() + "', '"
                    + paciente.getCpf() + "', "
                    + Integer.toString(paciente.getIdade()) + ")";
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizarPaciente(Paciente paciente) {
        try {
            String sentenca = "UPDATE PACIENTE SET NOME = '" + paciente.getNome()
                    + "' , CPF = '" + paciente.getCpf()
                    + "' , IDADE = " + Integer.toString(paciente.getIdade())
                    + " WHERE IDPACIENTE = " + Integer.toString(paciente.getIdPaciente());
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirPaciente(int idPaciente) {
        try {
            String sentenca = "DELETE FROM PACIENTE WHERE IDPACIENTE = " + Integer.toString(idPaciente);
            return this.atualizarBanco(sentenca);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList listarPacientes() {
        try {
            ArrayList pacientes = new ArrayList();
            String sentenca = "SELECT * FROM PACIENTE ORDER BY NOME";
            ResultSet rs = this.getResultSet(sentenca);

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("IDPACIENTE"));
                paciente.setNome(rs.getString("NOME"));
                paciente.setCpf(rs.getString("CPF"));
                paciente.setIdade(rs.getInt("IDADE"));

                pacientes.add(paciente);
            }
            return pacientes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
