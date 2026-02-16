package dao;

import dto.CitalacStatsDTO;

import java.sql.SQLException;
import java.util.List;

public interface CitalacDAO {
    List<CitalacStatsDTO> getCitalacStats(String usrnm) throws SQLException;
}
