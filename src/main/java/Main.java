import application.domain.CreditCard;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        CreditCard myCard = new CreditCard("Nara", "1234 5678 9012 3456", "Emiliano", "Diaz",LocalDate.of(2025, 12, 1));
        CreditCard anotherCard = new CreditCard("Visa","1234 5678 9012 3456", "Emiliano", "Doaz", LocalDate.of(2025, 12, 31));

        String expiryDateStr = myCard.getExpirationDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate expiryDate = LocalDate.parse(expiryDateStr, formatter);

        System.out.println(myCard.getCardInfo());
        System.out.println("**********************");
        System.out.println("Marca de la tarjeta: " + myCard.getCardByBrand());
        System.out.println("Fecha de vencimiento: " + myCard.getExpirationDate());
        System.out.println("Es Diferente? = " + myCard.isDifferent(anotherCard));
        System.out.println("Es Tarjeta valida? = " + myCard.isCardValidToOperation(myCard));
        System.out.println("Es Operacion Valida? = " + myCard.isValidOperation(myCard, 10));
        System.out.println("Tasa = " + myCard.calculateTax() + " Marca: " + myCard.getCardByBrand());
    }
}
