package encryption_decryption;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/13/6:07 PM
 * @Description:
 */
public class _006 {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int j = 0;
        while (j < len) {
            for (int i = 0; i < nRows && j < len; i++) // vertically down
                sb[i].append(c[j++]);
            for (int i = nRows-2; i >= 1 && j < len; i--) // obliquely up
                sb[i].append(c[j++]);
        }
        for (int i = 1; i < sb.length; i++)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }

    public String formatting(String s){
        // 创建一个字符数组来存储处理后的字符
        char[] chars = new char[s.length()];
        int size = 0;
        // 遍历原始字符串，处理非字母数字字符和大写字母
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur)) {
                if (Character.isUpperCase(cur)) {
                    chars[size++] = Character.toLowerCase(cur);
                } else {
                    chars[size++] = cur;
                }
            }
        }
        return new String(chars).trim();
    }
    public String encryption(String s, int nRows, int rep) {
        String format = formatting(s);

        System.out.println("The original String is: " + format);
        for(int i = 1; i <= rep; i ++){
            format = convert(format, nRows);
//            System.out.println("After the " + i + " times repetition: " + format);
        }
        return format;
    }

    public String convertBack(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        char[] result = new char[n];
        int diff = 2 * (numRows - 1);
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            int diagonalDiff = i == 0 || i == numRows - 1 ? diff : diff - 2 * i;
            int j = i;
            boolean isDiagonal = (i != 0 && i != numRows - 1);

            while (j < n) {
                result[index] = s.charAt(j);
                index++;

                if (isDiagonal && j + diagonalDiff < n) {
                    result[index] = s.charAt(j + diagonalDiff);
                    index++;
                }

                j += diff;
            }
        }

        return new String(result, 0, n);
    }




    public static void main(String[] args) {
        _006 test = new _006();
//        String s = "CRYPTOLOGY IS THE PRACTICE AND STUDY OF TECHNIQUES FOR SECURE COMMUNICATION IN THE PRESENCE OF THIRD PARTIES CALLED ADVERSARIES";
////        String s = "PAYPALISHIRING";
//        String result = test.encryption(s, 4, 5);
//        System.out.println("The final result is: " + result);

        String result = test.convertBack("PAIIANPSIYRHLG", 3);
        System.out.println(result);
    }
}
