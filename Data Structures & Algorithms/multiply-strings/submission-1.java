class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int m = num1.length(), n = num2.length();

        int[] res = new int[m+n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i+j] += digit;
                res[i+j+1] += res[i+j] / 10;
                res[i+j] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        } 

        while (i >= 0) {
            sb.append(res[i--]);
        }

        return sb.toString();
    }
}

/*
    num1 = "56", num2 = "67", output = "3752"

    -- reverse --
    num1 = "65", num2 = "76"

    i = 0, j = 0:
        digit = 6 * 7 = 42
        res[0+0] += 42
        res[0+0+1] += 42/10 = 4
        res[0+0] = 2

        res = [2, 4]
        ...

        finally merge in reverse
*/
