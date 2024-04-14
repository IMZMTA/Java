package in.ch102;

public enum Traffic {
    RED(4000),
    YELLOW(2000),
    GREEN(5000);

    //we can create a constant in Enum also working is same as class
    private final int onTimeInMillis;

    public int getOnTimeInMillis() {
        return onTimeInMillis;
    }

    Traffic(int onTimeInMillis) {
        this.onTimeInMillis = onTimeInMillis;
    }
}
