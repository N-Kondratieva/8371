package data;

public class Research {
    int researchID;
    String researchName;
    String researchDescription;
    String researchDateBegin;
    String researchDateEnd;
    int laboratoryID;
    int researchProgress;

    public Research(int researchID, String researchName, String researchDescription, String researchDateBegin, String researchDateEnd, int anInt, int resultInt) {
        this.researchID = researchID;
        this.researchName = researchName;
        this.researchDescription = researchDescription;
        this.researchDateBegin = researchDateBegin;
        this.researchDateEnd = researchDateEnd;
        this.laboratoryID = laboratoryID;
        this.researchProgress = researchProgress;
    }

    public int getResearchID() {
        return researchID;
    }

    public String getResearchName() {
        return researchName;
    }

    public String getResearchDescription() {
        return researchDescription;
    }

    public String getResearchDateBegin() {
        return researchDateBegin;
    }

    public String getResearchDateEnd() {
        return researchDateEnd;
    }

    public int getLaboratoryID() {
        return laboratoryID;
    }

    public int getResearchProgress() {
        return researchProgress;
    }
}
