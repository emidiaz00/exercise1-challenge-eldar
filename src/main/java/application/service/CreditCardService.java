package application.service;

import application.domain.CreditCard;

public interface CreditCardService {
    String getCardByBrand(String brand);
    boolean isValidOperation(CreditCard card, double amount);

    String getExpirationDate();

    boolean isValidCardToOperation(CreditCard card);
    double calculateTaxOperation(CreditCard card, double tax);
}
