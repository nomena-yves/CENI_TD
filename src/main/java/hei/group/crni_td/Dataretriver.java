package hei.group.crni_td;

import hei.group.crni_td.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<VoteTypeCount> getCountVotesByType() {
        String sql="select vote_type, count(vote_type) as acount from vote group by vote_type";
        VoteTypeCount voteTypeCount=null;
        List<VoteTypeCount> voteTypeCountList=new ArrayList<VoteTypeCount>();
        try {
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn= connection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                voteTypeCount=new VoteTypeCount(
                        VoteType.valueOf(rs.getString("vote_type")),
                        rs.getInt("acount")
                );
                voteTypeCountList.add(voteTypeCount);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return voteTypeCountList;
    }

    List<CandidateVoteCount> countValidVotesByCandidate(){

    }

}
