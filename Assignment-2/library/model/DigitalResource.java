package library.model;

import library.util.InputValidator;

public class DigitalResource extends LibraryResource {

    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    protected double getRatePerDay() {
        return 2.0;
    }

    @Override
    public double calculateFine(int overdueDays) {
        if (!InputValidator.validateFineDays(overdueDays)) {
            return 0.0;
        }
        return overdueDays * getRatePerDay();
    }

    @Override
    public void printDetails() {
        System.out.println("Resource Type: Digital Resource");
        System.out.println("Library: " + getLibraryName());
        System.out.println("Resource ID: " + getResourceId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author/Creator: " + getAuthor());
        System.out.println("Fine Rate: Rs. " + getRatePerDay() + "/day");
    }
}