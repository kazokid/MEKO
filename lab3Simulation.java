import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// for testing the simulator, this is only the dummy version
// TODO - implement for real
public class lab3Simulation {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int L = 0, D = 0, LK = 0, DK = 0, V = 0, S = 0;
        String line;

        while (true) {
            if ((line = input.readLine()) != null) {
                if (line.charAt(0) == 'K')
                    break;
                Scanner s = new Scanner(line);
                L = s.nextInt();
                D = s.nextInt();
                LK = s.nextInt();
                DK = s.nextInt();
                V = s.nextInt();
                S = s.nextInt();
            }
            double[] simulatorIn = {L, D, LK, DK, V, S};
            System.out.println(10 + " " + 0);
            System.out.flush();
        }
    }
}