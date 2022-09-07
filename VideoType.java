public enum VideoType {
    VHS(1), CD(2), DVD(3);
    private int value;

    public int getValue() {
        return value;
    }

    VideoType(int value) {
        this.value = value;
    }
}