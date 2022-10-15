package daily.d202208.dd20220810;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        return x.replace("x", "1");
    }
    public String solveEquation(String equation) {
        String []lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : lr[0].split("(?=\\+)|(?=-)")) {
            if (x.contains("x")) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : lr[1].split("(?=\\+)|(?=-)")) {
            if (x.contains("x")) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            return rhs == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + rhs / lhs;
    }
}
/*"x+5-3+x=6+x-2"
"x=x"
"2x=x"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String equation = stringToString(line);

            String ret = new Solution().solveEquation(equation);

            String out = (ret);

            System.out.print(out);
        }
    }
}
