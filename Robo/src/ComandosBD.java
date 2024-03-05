import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ComandosBD {
//    public void criarBD(Connection conn, String DB){
//        try {
//            Statement st = conn.createStatement();
//            String sql = "CREATE DATABASE" + DB;
//            st.executeUpdate(sql);
//            st.close();
//        }catch (SQLException ex){
//            System.out.println(ex);
//        }
//    }
//    public void createTable(Connection conn, String BD,  String table){
//        try {
//            Statement st = conn.createStatement();
//
//            String sql = "CREATE TABLE" + BD + "." + table + "(" +
//                "posx DECIMAL(10) DEFAULT NULL, " +
//                "posy DECIMAL(10) DEFAULT NULL, " +
//                "codigo INT(10) NOT NULL AUTO_INCREMENT," +
//                "PRIMARY KEY('codigo') )" +
//                ") ENGINE = INNODB AUTO_INCREMENT = 1 DEFAUT CHARSET = LATIN1";
//
//        }catch (SQLException ex){
//            System.out.println(ex);
//        }
//    }
    public void inserirPos(Connection conn, Number posX, Number posY){
        try {
            Statement st = conn.createStatement();
            String sql = "INSERT INTO rota (posx, posy)" +
                    "VALUES (" + posX + "," + posY + ")";
            st.executeUpdate(sql);
            st.close();
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
