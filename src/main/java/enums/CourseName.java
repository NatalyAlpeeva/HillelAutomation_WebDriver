package enums;

public enum CourseName {
    QA_Automation("QA Automation — Java"),
    QA_Manual("QA Manual");

    private String name;

    public String getName() {
        return name;
    }
    CourseName(String s) {
        name=s;
    }
    @Override
    public String toString() {
        return name;
    }
}
