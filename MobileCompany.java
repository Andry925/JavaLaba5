import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MobileCompany {
    private List<Tariff> tariffs;

    public MobileCompany() {
        tariffs = new ArrayList<>();
        tariffs.add(new PrepaidTariff("Basic Tariff Prepaid", 5.0, 100));
        tariffs.add(new PostpaidTariff("Standard Tariff Postpaid", 15.0, 200));
        tariffs.add(new PrepaidTariff("Premium Tariff Prepaid", 18.0, 150));
        tariffs.add(new PostpaidTariff("Ultra Tarriff Postpaid", 50.0, 50));
    }

    public void findTariff(double minCost, double maxCost) {
        List<Tariff> tariffsInRange = tariffs.stream()
                .filter(t -> t.getSubscriptionFee() >= minCost && t.getSubscriptionFee() <= maxCost)
                .collect(Collectors.toList());
        System.out.println("Tariffs in the cost range " + minCost + " to " + maxCost + ":");
        tariffsInRange.forEach(System.out::println);
    }

    public static void main(String[] args) {
        MobileCompany company = new MobileCompany();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter minimum cost:");
        double minCost = scanner.nextDouble();
        System.out.println("Enter maximum cost:");
        double maxCost = scanner.nextDouble();

        company.findTariff(minCost, maxCost);
        scanner.close();
    }
}
