package dao;

import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;
import model.Serijal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SerijalDAO {
    List<SerijalStatsDTO> getSerijalStats() throws SQLException;
    List<SerijalZanrStatsDTO> getSerijalZanrStats() throws SQLException;
    boolean existsById(int id) throws SQLException;
    Serijal save(Serijal serijal, Connection conn) throws SQLException;

}
