package river.vm;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static river.vm.ByteCode.*;

/**
 * File : Testing.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:53
 */
public class Testing {

    static int[] test = {
            IPUSH, 5,
            IPUSH, 10,
            CALL, 9, 2,
            PRINT,
            HALT,

            LOAD, 1,
            LOAD, 0,
            IMUL,
            RET
    };

    public static void main(String args[]) {
        /*RiverVM vm = new RiverVM(test, 0);
        vm.execute(0);*/

        String[] text = readAllText(args[0]).split("\\s+");
        int[] result = new int[text.length];

        for (int y = 0; y < text.length; y++) {
            if (!isNumeric(text[y])) {
                for (int i = 0; i < instructions.length; i++) {
                    if (text[y].toLowerCase().trim().equals(instructions[i].getName())) {
                        result[y] = i;
                        continue;
                    }
                }
            } else {
                result[y] = Integer.parseInt(text[y]);
            }
        }

        /*
        for (int i : result) {
            System.out.println(i);
        }*/

        RiverVM vm = new RiverVM(result, args.length > 2 ? Integer.parseInt(args[2]) : 0);
        vm.execute(args.length > 1 ? Integer.parseInt(args[1]) : 0);
    }

    private static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static String readAllText(String path) {
        BufferedReader br;
        String result = "";
        try {
            br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            result = sb.toString();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
