package hei.group.crni_td;

import java.util.Objects;

public class CandidateVoteCount {
    String candidate;
    int validVoteCount ;

    public CandidateVoteCount(String candidate, int validVoteCount) {
        this.candidate = candidate;
        this.validVoteCount = validVoteCount;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public int getValidVoteCount() {
        return validVoteCount;
    }

    public void setValidVoteCount(int validVoteCount) {
        this.validVoteCount = validVoteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CandidateVoteCount that = (CandidateVoteCount) o;
        return validVoteCount == that.validVoteCount && Objects.equals(candidate, that.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, validVoteCount);
    }

    @Override
    public String toString() {
        return "CandidateVoteCount{" +
                "candidate='" + candidate + '\'' +
                ", validVoteCount=" + validVoteCount +
                '}';
    }
}
