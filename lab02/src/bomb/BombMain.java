package bomb;

import common.IntList;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BombMain {


    private static String passwordGenerator(){
        List<Integer> passwordList = new ArrayList<>();
        Random r = new Random(1337);
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();

        while (hs.size() < 100000){
            hs.add(r.nextInt());
        }
        passwordList.addAll(hs);
        int passwordNeeded = passwordList.get(1338);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 1337; i++){
            result.append(passwordList.get(i) + " ");
        }
        result.append("-81201430");
        return result.toString();
    }

    public static void main(String[] args) {

        String phase2Pass = passwordGenerator();

        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct inputs (passwords) to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            b.phase1( IntList.of(0,9,3,0,8)); // Figure this out too
        }
        if (phase >= 2) {
            b.phase2(phase2Pass);
        }
    }
}
