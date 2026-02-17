package dao;

import model.Serijal;
import model.Strip;

import java.sql.Connection;
import java.sql.SQLException;

public interface StripDAO {
    Strip save(Strip strip, Connection conn) throws SQLException;
    boolean existsById(int id) throws SQLException;
}
