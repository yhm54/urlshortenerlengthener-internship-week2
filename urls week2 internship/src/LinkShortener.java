import java.util.*;



public class LinkShortener {
    private Map<String, String> urlMap;

    public LinkShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL();
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "URL not found");
    }

    private String generateShortURL() {
        // Basic implementation for demonstration purposes
        return "http://short.url/" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL: ");
                    scanner.nextLine(); // Consume newline
                    String longURL = scanner.nextLine();
                    String shortURL = linkShortener.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;
                case 2:
                    System.out.print("Enter short URL: ");
                    scanner.nextLine(); // Consume newline
                    String shortInputURL = scanner.nextLine();
                    String expandedURL = linkShortener.expandURL(shortInputURL);
                    System.out.println("Expanded URL: " + expandedURL);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}