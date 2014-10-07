public class Main {

    public static void main(String[] args) {
        Preparator preparator = new Preparator();

        String[] inputParams = preparator.prepareArgumentsForCalculation(args);
        if(inputParams != null) {
            System.out.println(Calculator.clculate(inputParams));
        }
    }
}
