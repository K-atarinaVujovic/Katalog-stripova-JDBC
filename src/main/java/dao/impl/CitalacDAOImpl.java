package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.CitalacDAO;
import dto.CitalacStatsDTO;
import dto.SerijalStatsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CitalacDAOImpl implements CitalacDAO{
    public List<CitalacStatsDTO> getCitalacStats(String usrnm) throws SQLException{
        String query = "SELECT\n" +
                "\tcitalac.usrnm,\n" +
                "\tnas_str AS \"Naslov\",\n" +
                "\tCOUNT(je_procitao.deo_id_deo) AS \"Procitanih delova\",\n" +
                "\tstrip_deo_count.total_deo_count AS \"Ukupno delova\"\n" +
                "FROM public.strip strip \n" +
                "LEFT OUTER JOIN public.deo deo\n" +
                "ON strip.sfr_str = deo.strip_sfr_str\n" +
                "LEFT OUTER JOIN (\n" +
                "SELECT\n" +
                "\tdeo.strip_sfr_str AS deo_strip_sfr_str,\n" +
                "\tCOUNT(*) AS total_deo_count\n" +
                "\tFROM deo\n" +
                "\tGROUP BY deo_strip_sfr_str\n" +
                ") AS strip_deo_count\n" +
                "ON strip_deo_count.deo_strip_sfr_str = strip.sfr_str\n" +
                "LEFT OUTER JOIN public.je_procitao je_procitao\n" +
                "ON je_procitao.deo_id_deo = deo.id_deo\n" +
                "JOIN public.citalac citalac\n" +
                "ON citalac.usrnm = je_procitao.citalac_usrnm\n" +
                "GROUP BY nas_str, citalac.usrnm, strip_deo_count.total_deo_count\n" +
                "HAVING citalac.usrnm = ?\n" +
                "ORDER BY COUNT(je_procitao.deo_id_deo) DESC\n";

        List<CitalacStatsDTO> rows = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, usrnm);
            try(ResultSet resultSet = stmt.executeQuery()){
                while (resultSet.next()) {
                    String naslov = resultSet.getString(2);
                    int brojProcitanihDelova = resultSet.getInt(3);
                    int ukupanBrojDelova = resultSet.getInt(4);

                    CitalacStatsDTO citalacStatsDTO = new CitalacStatsDTO(naslov, brojProcitanihDelova, ukupanBrojDelova);

                    rows.add(citalacStatsDTO);
                }
            }

        }

        return rows;
    }

}
