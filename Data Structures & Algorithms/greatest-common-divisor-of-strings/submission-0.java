class Solution {
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int g = gcd(m,n);

        String p = str1.substring(0,g);
        int o = p.length();
        if (p.repeat(m/o).equals(str1) && p.repeat(n/o).equals(str2)) return p;
        else return "";
    }
}