public class SpaTester {
    public static void main(String[] args) {
        // Create a Spa instance
        Spa luxurySpa = new Spa("Iliauni Spa");

        // Create some Therapist instances
        Therapist therapist1 = new Therapist("Alice", "Massage Therapy");
        Therapist therapist2 = new Therapist("Bob", "Aromatherapy");
        Therapist therapist3 = new Therapist("Dimitri", "Rehab");


        // Add therapists
        luxurySpa.addTherapist(therapist1);
        luxurySpa.addTherapist(therapist2);

        // Save the state to file
        luxurySpa.saveState();

        // Print out the spa information
        System.out.println("Original state:");
        System.out.println(luxurySpa);

        // Modify the spa state
        luxurySpa.removeTherapist(therapist1);
        luxurySpa.addTherapist(therapist3);

        // Print out the spa information
        System.out.println("After modification:");
        System.out.println(luxurySpa);

        // Restore the state from file
        luxurySpa.restoreState();

        // Print out the spa information
        System.out.println("After restoring state:");
        System.out.println(luxurySpa);
    }
}
