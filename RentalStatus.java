public enum RentalStatus {
    RENTED(1), RETURNED(2);
    private int value;

    public int getValue() {
        return value;
    }

    RentalStatus(int value) {
        this.value = value;
    }
}
