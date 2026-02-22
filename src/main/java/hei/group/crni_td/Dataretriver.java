package hei.group.crni_td;

import hei.group.crni_td.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dataretriver {

    public long countAllVote(){
        long count = 0;
        try{
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn= connection.getConnection();
            String sql = "select count(id,candidate_id,voter_id,vote_type) as count from vote";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                count= rs.getLong("count");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return count;
    }
}
