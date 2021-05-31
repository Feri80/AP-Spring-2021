
public enum SettingInfo {
    theme(2),fullScreen(false), userName("user_1232453");

    Object info;

    SettingInfo(Object info)
    {
        this.info = info;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
