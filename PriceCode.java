public enum PriceCode {
    REGULAR(1), NEW_RELEASE(2);
    private int value;

    public int getValue() {
        return value;
    }

    PriceCode(int value) {
        this.value = value;
    }
}