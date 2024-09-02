/* Multiple two positive integer numbers, input and output are in String
Similar problem is there in Leetcode.
*/

public class stringMultiplier {
    public static void main(String[] args) {
        String a = "45764567";
        String b = "45764567";

        //System.out.println(stringAdd(a,b));
        //System.out.println(a.substring(2, 4));

        System.out.println(stringMultiply(a,b));

    }

    private static String stringMultiply(String a, String b) {

        String result = "";
        int l = 0;

        for (int j=b.length()-1; j>=0; j--) {
            int k = 0;
            int s = 0;

            for (int i=a.length()-1; i>=0; i--) {
                int m = Integer.parseInt(b.substring(j, j+1)) * Integer.parseInt(a.substring(i, i+1)) * (int) Math.pow(10.0,k);
                k++;
                s += m;
            }

            String str = Integer.toString(s);
            for (int m=1; m<=l; m++) {
                str = str + "0";
            }
            l++;

            result = stringAdd(result, str);
        }
        return result;
    }

    private static String stringAdd(String a, String b) {
        String result = "";
        int ldiff = Math.abs(a.length() - b.length());

        if (a.length() < b.length()) {
            for (int i=1; i<=ldiff; i++) {
                a = "0" + a;
            }
        } else if (b.length() < a.length()) {
            for (int i=1; i<=ldiff; i++) {
                b = "0" + b;
            }
        }
        //System.out.println("Normalized a = " + a + " b=" + b );
        int sum = 0;
        int carry = 0;

        for (int i=a.length()-1; i>=0; i--) {
            //System.out.println(Integer.parseInt(b.substring(i,i+1)));
            int s = Integer.parseInt(a.substring(i,i+1)) + Integer.parseInt(b.substring(i,i+1)) + carry;
            carry = s / 10;
            s = s % 10;
            result = s + result;
        }
        return result;
    }
}
