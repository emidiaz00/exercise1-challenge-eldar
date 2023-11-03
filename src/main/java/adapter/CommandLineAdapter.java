package adapter;

import application.domain.CreditCard;
import application.service.CreditCardService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommandLineAdapter implements CreditCardService {

    @Override
    public String getCardByBrand(String brand) {
        return brand;
    }

    @Override
    public boolean isValidOperation(CreditCard card, double amount) {
        return false;
    }

    @Override
    public String getExpirationDate() {
        return null;
    }


    @Override
    public boolean isValidCardToOperation(CreditCard card) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = LocalDate.parse(card.getExpirationDate());
        return expirationDate.isAfter(currentDate);
    }

    @Override
    public double calculateTaxOperation(CreditCard card, double tax) {
        return 0;
    }


}
