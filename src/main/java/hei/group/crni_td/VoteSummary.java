package hei.group.crni_td;

import java.util.Objects;

public class VoteSummary {
   int validCount;
   int blankCount;
   int nullCount;

    public VoteSummary(int validCount, int blankCount, int nullCount) {
        this.validCount = validCount;
        this.blankCount = blankCount;
        this.nullCount = nullCount;
    }

    public int getValidCount() {
        return validCount;
    }

    public void setValidCount(int validCount) {
        this.validCount = validCount;
    }

    public int getBlankCount() {
        return blankCount;
    }

    public void setBlankCount(int blankCount) {
        this.blankCount = blankCount;
    }

    public int getNullCount() {
        return nullCount;
    }

    public void setNullCount(int nullCount) {
        this.nullCount = nullCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VoteSummary that = (VoteSummary) o;
        return validCount == that.validCount && blankCount == that.blankCount && nullCount == that.nullCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(validCount, blankCount, nullCount);
    }

    @Override
    public String toString() {
        return "VoteSummary{" +
                "validCount=" + validCount +
                ", blankCount=" + blankCount +
                ", nullCount=" + nullCount +
                '}';
    }
}
