import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    private static double sum = 0.0;

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        ShoppingCart.sum = sum;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Select language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = input.nextInt();
        input.nextLine();    // use line break

        Locale locale;

        switch (choice) {
            case 1:
                locale = new Locale("en", "GB");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            default:
                locale = new Locale("ja", "JP");
        }

        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(rb.getString("cart"));

        String item;

        while (true) {

            System.out.println(rb.getString("enter_item"));
            System.out.println(rb.getString("exit"));
            item = input.nextLine();

            if (item.equals("q") || item.equals("Q")) {
                System.out.println(rb.getString("bye"));
                break;
            }

            if (item.isEmpty()) {
                System.out.println(rb.getString("empty_input"));
                continue;
            }

            System.out.println(rb.getString("enter_price"));
            double price = Double.parseDouble(input.nextLine());

            System.out.println(rb.getString("enter_quantity"));
            double quantity = Double.parseDouble(input.nextLine());

            ShoppingCart.calculateTotalPrice(price, quantity);

            System.out.println(rb.getString("grand_total") + ": " + ShoppingCart.sum);
            System.out.println();
        }

        input.close();
    }

    public static void calculateTotalPrice(double price, double quantity) {
        sum += quantity * price;
    }
}