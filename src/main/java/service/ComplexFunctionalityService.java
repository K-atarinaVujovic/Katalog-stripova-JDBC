package service;

import dao.CitalacDAO;
import dao.SerijalDAO;
import dao.impl.CitalacDAOImpl;
import dao.impl.SerijalDAOImpl;
import dto.CitalacStatsDTO;
import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;

import java.sql.SQLException;
import java.util.List;

public class ComplexFunctionalityService {
    private static final SerijalDAO serijalDAO = new SerijalDAOImpl();
    private static final CitalacDAO citalacDAO = new CitalacDAOImpl();

    // simple query
    public List<SerijalZanrStatsDTO> getSerijalZanrStats() throws SQLException{
        return serijalDAO.getSerijalZanrStats();
    }

    // complex query 1
    public List<SerijalStatsDTO> getSerijalStats() throws SQLException {
        return serijalDAO.getSerijalStats();
    }

    // complex query 2
    public List<CitalacStatsDTO> getCitalacStats(String usrnm) throws SQLException {
        return citalacDAO.getCitalacStats(usrnm);
    }
}
