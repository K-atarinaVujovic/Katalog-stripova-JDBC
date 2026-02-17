package dao;

import model.Serijal;

import java.sql.Connection;
import java.sql.SQLException;

public interface PripadaDAO {
    boolean save(int stripId, int serijalId, Connection conn) throws SQLException;
}
