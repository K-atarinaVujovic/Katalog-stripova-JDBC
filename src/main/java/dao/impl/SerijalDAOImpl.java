package dao.impl;

import connection.ConnectionUtil_HikariCP;
import dao.SerijalDAO;
import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;
import model.Serijal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerijalDAOImpl implements SerijalDAO {
    public List<SerijalStatsDTO> getSerijalStats() throws SQLException{
        String query = "SELECT\n" +
                "\tnas_srj AS \"Naslov\",\n" +
                "\tARRAY_AGG(DISTINCT(prof_ime)) AS \"Glavni autori\",\n" +
                "\tCOUNT(DISTINCT(sfr_str)) AS \"Broj stripova\",\n" +
                "\tROUND(AVG(strip_deo_count.deo_count)) AS \"Prosek delova po stripu\"\n" +
                "FROM public.serijal AS serijal\n" +
                "LEFT OUTER JOIN public.pripada AS pripada\n" +
                "ON serijal.sfr_srj = pripada.serijal_sfr_srj\n" +
                "LEFT OUTER JOIN public.strip AS strip\n" +
                "ON strip.sfr_str = pripada.strip_sfr_str\n" +
                "-- LEFT OUTER JOIN public.deo deo \n" +
                "-- ON deo.strip_sfr_str = strip.sfr_str\n" +
                "LEFT OUTER JOIN (\n" +
                "\tSELECT deo.strip_sfr_str deo_strip_sfr_str, COUNT(*) AS deo_count\n" +
                "\tFROM public.deo deo\n" +
                "\tGROUP BY deo.strip_sfr_str\n" +
                ") AS strip_deo_count\n" +
                "ON strip_deo_count.deo_strip_sfr_str = strip.sfr_str\n" +
                "LEFT OUTER JOIN public.radi_na AS radi_na\n" +
                "ON radi_na.strip_sfr_str = strip.sfr_str\n" +
                "LEFT OUTER JOIN public.autor AS autor\n" +
                "ON autor.usrnm = radi_na.autor_usrnm\n" +
                "LEFT OUTER JOIN public.korisnik AS korisnik\n" +
                "ON autor.usrnm = korisnik.usrnm\n" +
                "GROUP BY serijal.sfr_srj\n" +
                "HAVING COUNT(DISTINCT(sfr_str)) > 1\n" +
                "ORDER BY COUNT(DISTINCT(sfr_str)) DESC";

        List<SerijalStatsDTO> rows = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet resultSet = stmt.executeQuery();
        ) {
            while (resultSet.next()) {
                String naslov = resultSet.getString(1);
                java.sql.Array sqlArray = resultSet.getArray(2);
                String[] autoriArray = (String[]) sqlArray.getArray();
                List<String> glavniAutori = Arrays.asList(autoriArray);
                int brojStripova = resultSet.getInt(3);
                int brojDelovaPoStripu = resultSet.getInt(4);

                SerijalStatsDTO serijalStatsDTO = new SerijalStatsDTO(naslov, glavniAutori, brojStripova, brojDelovaPoStripu);

                rows.add(serijalStatsDTO);
            }
        }

        return rows;
    }

    public List<SerijalZanrStatsDTO> getSerijalZanrStats() throws SQLException {
        String query = "SELECT \n" +
                "\tnas_srj AS \"Naslov\",\n" +
                "\tCOUNT(zanr_id_zanr) AS \"Broj zanrova\"\n" +
                "FROM public.serijal AS serijal\n" +
                "INNER JOIN public.je_zanra AS je_zanra\n" +
                "ON serijal.sfr_srj = je_zanra.serijal_sfr_srj\n" +
                "GROUP BY sfr_srj;";
        List<SerijalZanrStatsDTO> rows = new ArrayList<>();
        try (
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet resultSet = stmt.executeQuery();
        ) {
            while (resultSet.next()) {
                String naslov = resultSet.getString(1);
                int brojZanrova = resultSet.getInt(2);

                SerijalZanrStatsDTO serijalZanrStatsDTO = new SerijalZanrStatsDTO(naslov, brojZanrova);

                rows.add(serijalZanrStatsDTO);
            }
        }

        return rows;
    }

    public boolean existsById(int id) throws SQLException{
        String query = "SELECT 1 FROM public.serijal WHERE sfr_srj = ?";
        boolean exists = false;
        try(
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ){
            stmt.setInt(1, id);

            try(ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    exists = true;
                }
            }
        }

        return exists;
    }

    public boolean save(Serijal serijal) throws SQLException{
        String query = "INSERT INTO public.serijal(nas_srj)\n" +
                "\tVALUES (?)";
        boolean success = false;
        try(
                Connection conn = ConnectionUtil_HikariCP.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ){
            stmt.setString(1, serijal.getNaslov());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }

}
