package dao;

import model.Serijal;

import java.sql.SQLException;

public interface StripDAO {
    boolean save(Serijal serijal) throws SQLException;
    boolean existsById(int id) throws SQLException;
}
