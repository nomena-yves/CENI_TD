package hei.group.crni_td;

import java.util.Objects;

public class ElectionResult {
    private String andidateName;
    private int validVoteCount;

    public ElectionResult(String andidateName, int validVoteCount) {
        this.andidateName = andidateName;
        this.validVoteCount = validVoteCount;
    }

    public String getAndidateName() {
        return andidateName;
    }

    public void setAndidateName(String andidateName) {
        this.andidateName = andidateName;
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
        ElectionResult that = (ElectionResult) o;
        return validVoteCount == that.validVoteCount && Objects.equals(andidateName, that.andidateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(andidateName, validVoteCount);
    }

    @Override
    public String toString() {
        return "ElectionResult{" +
                "andidateName='" + andidateName + '\'' +
                ", validVoteCount=" + validVoteCount +
                '}';
    }
}
