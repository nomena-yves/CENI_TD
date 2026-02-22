package hei.group.crni_td;

import java.util.Objects;

public class CandidateVoteCount {
    String candidate;
    VoteType voteType =VoteType.VALID;

    public CandidateVoteCount(String candidate) {
        this.candidate = candidate;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CandidateVoteCount that = (CandidateVoteCount) o;
        return Objects.equals(candidate, that.candidate) && voteType == that.voteType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, voteType);
    }

    @Override
    public String toString() {
        return "CandidateVoteCount{" +
                "candidate='" + candidate + '\'' +
                ", voteType=" + voteType +
                '}';
    }
}
