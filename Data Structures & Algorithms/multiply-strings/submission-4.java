class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m+n];
        //num1 = new StringBuilder(num1).reverse().toString();
        //num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = (num1.charAt(m-i-1) - '0') * (num2.charAt(n-j-1) - '0');
                arr[i+j] += v;
                arr[i+j+1] += arr[i+j]/10;
                arr[i+j] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = arr.length-1;
        while (i >= 0 && arr[i] == 0) --i;
        while (i >= 0) {
            sb.append(arr[i]);
            --i;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
