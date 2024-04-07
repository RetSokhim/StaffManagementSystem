public class Volunteer extends StaffMember{
    private double salary;

    public Volunteer( int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    public double pay() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "  salary=" + salary + '\'' +
                ", pay='" + pay() + '\'' +
                '}';
    }

    public String name() {
        return name;
    }
    public int getVolunteerID(){
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
