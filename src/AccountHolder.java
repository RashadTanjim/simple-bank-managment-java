public abstract class AccountHolder {
    private final int idNumber;

    public AccountHolder(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }
}