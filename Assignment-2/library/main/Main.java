package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = new LibraryResource[5];
        int[] overdueDays = {4, 0, 7, 3, 10};

        int[] ids = {101, 102, 103, 104, 105};
        String[] titles = {
            "Introduction to Algorithms",
            "Clean Code Handbook",
            "IEEE Quantum Computing Transactions",
            "Operating System Concepts",
            "Machine Learning E-Book"
        };
        String[] authors = {
            "Thomas H. Cormen",
            "Robert C. Martin",
            "IEEE CS Press",
            "Silberschatz & Galvin",
            "Andrew Ng"
        };
        boolean[] isDigital = {false, false, true, false, true};

        for (int i = 0; i < resources.length; i++) {
            if (InputValidator.validateResourceId(ids[i])) {
                if (isDigital[i]) {
                    resources[i] = new DigitalResource(ids[i], titles[i], authors[i]);
                } else {
                    resources[i] = new Book(ids[i], titles[i], authors[i]);
                }
            }
        }

        double totalFine = 0.0;

        System.out.println("================ LIBRARY RESOURCE DETAILS ================");
        for (int i = 0; i < resources.length; i++) {
            if (resources[i] != null) {
                resources[i].printDetails();
                double fine = resources[i].calculateFine(overdueDays[i]);
                totalFine += fine;
                System.out.println("Overdue Days: " + overdueDays[i]);
                System.out.printf("Calculated Fine: Rs. %.2f\n", fine);
                System.out.println("----------------------------------------------------------");
            }
        }

        System.out.printf("Total Fine for all overdue resources: Rs. %.2f\n", totalFine);
        LibraryResource.displayTotalResources();
    }
}