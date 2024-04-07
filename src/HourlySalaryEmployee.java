public class HourlySalaryEmployee extends StaffMember{
    private int hourWorked;
    private double rate;

    public HourlySalaryEmployee(int id, String name, String address, int hourWorked, double rate) {
        super(id, name, address);
        this.hourWorked = hourWorked;
        this.rate = rate;
    }
    @Override
    public double pay() {
        return hourWorked * rate;
    }
    public int getHourWorked() {
        return hourWorked;
    }
    public double getRate() {
        return rate;
    }
    public int getHourlySalaryEmployeeID() {
        return id;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
}