package ie.main.manager;

public class OptionManager {
    private boolean autoCollect = false;

    public void setAutoCollect(boolean autoCollect) {
        this.autoCollect = autoCollect;
    }

    public boolean isAutoCollect() {
        return autoCollect;
    }
}
