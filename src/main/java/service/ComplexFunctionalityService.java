package service;

import dao.CitalacDAO;
import dao.SerijalDAO;
import dao.impl.SerijalDAOImpl;
import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;

import java.sql.SQLException;
import java.util.List;

public class ComplexFunctionalityService {
    private static final SerijalDAO serijalDAO = new SerijalDAOImpl();

    // simple query
    public List<SerijalZanrStatsDTO> getSerijalZanrStats() throws SQLException{
        return serijalDAO.getSerijalZanrStats();
    }

    // complex query 1
    public List<SerijalStatsDTO> getSerijalStats() throws SQLException {
        return serijalDAO.getSerijalStats();
    }
}
