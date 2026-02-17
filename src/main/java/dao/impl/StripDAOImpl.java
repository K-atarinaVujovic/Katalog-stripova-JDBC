package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.StripDAO;
import model.Serijal;
import model.Strip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StripDAOImpl implements StripDAO {
    public boolean existsById(int id) throws SQLException {
        String query = "SELECT 1 FROM public.strip WHERE sfr_str = ?";
        boolean exists = false;
        try(
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ){
            stmt.setInt(1, id);

            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    exists = true;
                }
            }
        }

        return exists;
    }

    public Strip save(Strip strip, Connection conn) throws SQLException{
        String query = "INSERT INTO public.strip(\n" +
                "\tnas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)\n" +
                "\tVALUES (?, ?, ?, null)";

        try(
//                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, strip.getNaslov());
            stmt.setObject(2, strip.getDatumPocetka());
            stmt.setObject(3, strip.getDatumZavrsetka());

            int rowsAffected = stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    strip.setId(id);
                } else {
                    throw new SQLException("Saving strip failed, no ID obtained.");
                }
            }

            return strip;
        }
    }
}
