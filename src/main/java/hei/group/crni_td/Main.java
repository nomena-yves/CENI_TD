package hei.group.crni_td;

import hei.group.crni_td.DatabaseConnection.DatabaseConnection;

public class Main {
   DatabaseConnection databaseConnection=new DatabaseConnection();
    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new DatabaseConnection();
        Dataretriver dataretriver=new Dataretriver();
        try{
            //System.out.println(dataretriver.getCountVotesByType());
            //System.out.println(dataretriver.computeVoteSummary());
            System.out.println(dataretriver.countValidVotesByCandidate());
        }catch(Exception e){
            e.getMessage();
        }
    }
}
