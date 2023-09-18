package pro.sky.calculatorsimple;

public interface CalculatorServiceInterface {
    String welcome();

    int sum(int n1, int n2);

    String subtraction(String n1, String n2);

    String multiply(String n1, String n2);

    float divide(int n1, int n2);
}
