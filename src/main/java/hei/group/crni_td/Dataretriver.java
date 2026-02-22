package hei.group.crni_td;

import hei.group.crni_td.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql="select vote_type, count(vote_type) as acount from vote group by vote_type;";
        VoteTypeCount voteTypeCount=null;
        List<VoteTypeCount> voteTypeCountList=new ArrayList<>();
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
    String sql="select count(v.vote_type) as acount,c.name from vote v right join candidate c on v.candidate_id=c.id and vote_type='VALID' group by c.name";
        List<CandidateVoteCount> candidateVoteCounts=new ArrayList<CandidateVoteCount>();
        CandidateVoteCount candidateVoteCount=null;
    try{
        DatabaseConnection connection = new DatabaseConnection();
        Connection conn= connection.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            candidateVoteCount=new CandidateVoteCount(
                    rs.getString("name"),
                    rs.getInt("acount")
            );
            candidateVoteCounts.add(candidateVoteCount);
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return candidateVoteCounts;
    }

    public  VoteSummary computeVoteSummary(){
        VoteSummary voteSummary=null;
        try{
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn= connection.getConnection();
            String sql ="SELECT COUNT(*) FILTER (WHERE vote_type = 'VALID') AS valid_count, COUNT(*) FILTER (WHERE vote_type = 'BLANK') AS blank_count, COUNT(*) FILTER (WHERE vote_type IS NULL) AS null_count FROM vote";
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                voteSummary=new VoteSummary(
                        rs.getInt("valid_count"),
                        rs.getInt("blank_count"),
                        rs.getInt("null_count")
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return voteSummary;
    }
}
