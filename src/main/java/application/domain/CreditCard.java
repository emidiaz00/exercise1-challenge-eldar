package application.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditCard {
    private String brand;
    private String cardNumber;
    private String name;
    private String lastName;
    private LocalDate expirationDate;


    public CreditCard(String brand, String cardNumber, String name, String lastName, LocalDate expirationDate) {
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.name = name;
        this.lastName = lastName;
        this.expirationDate = expirationDate;
    }

    public String getCardInfo() {
        String info = "Marca: " + brand +
                "\n" + "Numero de Tarjeta: " + cardNumber +
                "\n" + "Nombre Titular: " + name +
                "\n" + "Apellido: " + lastName +
                "\n" + "Fecha de Vencimiento: " + expirationDate;
        return info;
    }

    public String getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = expirationDate.format(formatter);
        return formattedDate;
    }

    public boolean isValidOperation(CreditCard card, int amount) {
        this.cardNumber = String.valueOf(card);
        return amount <= 1000;
    }

    public boolean isCardValidToOperation(CreditCard card) {
        String fechaVencimientoStr = card.getExpirationDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate expirationDate = LocalDate.parse(fechaVencimientoStr, formatter);
        LocalDate currentDate = LocalDate.now();
        return expirationDate.isAfter(currentDate);
    }

    public boolean isDifferent(CreditCard otherCard) {
        // Compare card number and name
        if (!this.cardNumber.equals(otherCard.cardNumber)) {
            return true;
        }
        if (!this.name.equals(otherCard.name)) {
            return true;
        }
        return false;
    }

    public String getCardByBrand() {
        return brand;
    }

    public double calculateTax() {
        switch (brand) {
            case "Visa":
                int year = expirationDate.getYear();
                int mes = expirationDate.getMonthValue();
                return (double) year / mes;
            case "Nara":
                int day = expirationDate.getDayOfMonth();
                return day * 0.5;
            case "Amex":
                int monthAmex = expirationDate.getMonthValue();
                return monthAmex * 0.1;
            default:
                return 0.0;
        }
    }
}