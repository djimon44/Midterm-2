import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Spa {
    private String name;
    private List<Therapist> therapists;

    public Spa(String name) {
        this.name = name;
        this.therapists = new ArrayList<>();
    }

    public void addTherapist(Therapist therapist) {
        if (therapist != null) {
            therapists.add(therapist);
        } else {
            throw new IllegalArgumentException("Therapist cannot be null");
        }
    }

    public void removeTherapist(Therapist therapist) {
        if (therapist != null) {
            therapists.remove(therapist);
        } else {
            throw new IllegalArgumentException("Therapist cannot be null");
        }
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Therapist therapist : therapists) {
                writer.write(therapist.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        therapists.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                therapists.add(Therapist.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Spa: " + name + " Therapists: " + therapists;
    }
}

