package dao.impl;

import dao.PripadaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PripadaDAOImpl implements PripadaDAO {
    public boolean save(int stripId, int serijalId, Connection conn) throws SQLException{
        String query = "insert into pripada (strip_sfr_str, serijal_sfr_srj) values (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, stripId);
            stmt.setLong(2, serijalId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
