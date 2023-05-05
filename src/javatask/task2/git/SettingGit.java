package javatask.task2.git;

public class SettingGit {
    private Boolean someSettings;
    private Boolean getSomeSettings2;
    private Boolean getSomeSettings3;

    public Boolean getSomeSettings() {
        return someSettings;
    }

    public void setSomeSettings(Boolean someSettings) {
        this.someSettings = someSettings;
    }

    public Boolean getGetSomeSettings2() {
        return getSomeSettings2;
    }

    public void setGetSomeSettings2(Boolean getSomeSettings2) {
        this.getSomeSettings2 = getSomeSettings2;
    }

    public Boolean getGetSomeSettings3() {
        return getSomeSettings3;
    }

    public void setGetSomeSettings3(Boolean getSomeSettings3) {
        this.getSomeSettings3 = getSomeSettings3;
    }

    public SettingGit(Boolean someSettings, Boolean getSomeSettings2, Boolean getSomeSettings3) {
        this.someSettings = someSettings;
        this.getSomeSettings2 = getSomeSettings2;
        this.getSomeSettings3 = getSomeSettings3;



    }
}
