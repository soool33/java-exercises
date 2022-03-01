package com.afpa.travailCalculator.controller;

public class CalculatorController {
    private static int nbOperations;
    private String typeOperation;
    private double nb1;
    private double nb2;

    private String errorMessage = "";
    private double result;

    public CalculatorController() {
        nbOperations++;
    }

    public CalculatorController(String typeOperation, double nb1, double nb2) {
        this.typeOperation = typeOperation;
        this.nb1 = nb1;
        this.nb2 = nb2;

        // tester si les nombres entrés sont valides

        nbOperations++;

        switch (typeOperation) {
            case ("+"):
                this.result = add(nb1, nb2);
                break;

            case ("-"):
                this.result = substract(nb1, nb2);
                break;

            case ("*"):
                this.result = multiply(nb1, nb2);
                break;

            case ("/"):
                if (nb2 == 0) {
                    errorMessage = "Division par 0 impossible";
                    break;
                }
                this.result = divide(nb1, nb2);
                break;

            default:
                errorMessage = " Cette opération n'est pas prise en charge";
        }
    }

    private double add(double nb1, double nb2) {
        return nb1 + nb2;
    }

    private double substract(double nb1, double nb2) {
        return nb1 - nb2;
    }

    private double multiply(double nb1, double nb2) {
        return nb1 * nb2;
    }

    private double divide(double nb1, double nb2) {
        return nb1 / nb2;
    }

    // Getter
    public double getResult() {
        return result;
    }

    public static int getNbOperations() {
        return nbOperations;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
