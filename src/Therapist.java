public class Therapist {
    private String name;
    private String specialty;

    public Therapist(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Therapist: " + name + " Specialty: " + specialty + ' ';
    }

    public String toCSV() {
        return name + ", " + specialty;
    }

    public static Therapist fromCSV(String csvLine) {
        String[] parts = csvLine.split(", ");
        if (parts.length == 2) {
            return new Therapist(parts[0], parts[1]);
        } else {
            throw new IllegalArgumentException("Invalid CSV format");
        }
    }
}
