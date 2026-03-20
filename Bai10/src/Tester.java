class Tester extends Employee {
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return (0.1 * baseSalary) + (bugsFound * 50000);
    }
}