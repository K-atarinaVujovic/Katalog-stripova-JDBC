package service;

import connection.ConnectionUtil_HikariCP;
import dao.CitalacDAO;
import dao.PripadaDAO;
import dao.SerijalDAO;
import dao.StripDAO;
import dao.impl.CitalacDAOImpl;
import dao.impl.PripadaDAOImpl;
import dao.impl.SerijalDAOImpl;
import dao.impl.StripDAOImpl;
import dto.CitalacStatsDTO;
import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;
import model.Serijal;
import model.Strip;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComplexFunctionalityService {
    private static final SerijalDAO serijalDAO = new SerijalDAOImpl();
    private static final CitalacDAO citalacDAO = new CitalacDAOImpl();
    private static final StripDAO stripDAO = new StripDAOImpl();
    private static final PripadaDAO pripadaDAO = new PripadaDAOImpl();

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

    // transaction
    public void createStripWithSerijal(Strip strip) throws Exception{
        try (Connection conn = ConnectionUtil_HikariCP.getConnection()) {

            conn.setAutoCommit(false);

            try {
                Serijal serijal = new Serijal(strip.getNaslov());
                Serijal newSerijal = serijalDAO.save(serijal, conn);
                Strip newStrip = stripDAO.save(strip, conn);
                pripadaDAO.save(newStrip.getId(), newSerijal.getId(), conn);

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}
