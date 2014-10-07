import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by keks on 28.09.14.
 *
 * String preparation.
 * Wipes string, removes all signs, which are not digits.
 * Extract prams from the string for calculatoins.
 */
public class Preparator {

    public Preparator(){
    }

    /**
     * checks if thhere are any arguments, if no - waits for console input
     * @param args - console arguments
     * @return clean parameters for calculation
     */
    public String[] prepareArgumentsForCalculation(String[] args){
        String[] result;

        // check, if there are no args, wating for keyboard input
        if(args.length == 0) {
            System.out.println("Please point spots' coordinates separated with space. Each spot per line. At the end type \"q\"");
            System.out.println("Or you can point them as the parameters.");
            result = readFomConsole();
            while(result.length % 2 != 0){
                System.out.println("Incorrect! Each spot has two coordinates. Try again please.");
                result = readFomConsole();
            }
        } else {
            // wiping arguments
            for(int i = 0; i < args.length; i++){
                args[i] = args[i].replaceAll("\\D", "");
            }
            result = args;
            // check for params count. Two digits for single spot
            if(result.length > 0 && result.length % 2 != 0){
                System.out.println("Incorrect! Each spot has two coordinates.");
                return null;
            }
        }
        return result;
    }

    /**
     * console reading mechanism
     *
     * @return clean parameters from keyboard
     */
    private String[] readFomConsole() {
        String[] result;
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String inputLine = new String();

        while (!(inputLine.contains("q"))){
            try {
                inputLine = inputLine + in.readLine() + "\n";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputLine = inputLine.replaceAll("\\D", " " );
        inputLine = inputLine.replaceAll("\\s+", " ");
        result = inputLine.split(" ");
        return result;
    }
}
