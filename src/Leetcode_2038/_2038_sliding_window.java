package Leetcode_2038;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/02/3:41 PM
 * @Description:
 */
public class _2038_sliding_window {
    public boolean winnerOfGame(String colors) {
        int A = 0;
        int B = 0;

        for(int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == 'A' &&
                    colors.charAt(i) == 'A' &&
                    colors.charAt(i + 1) == 'A') A++;
            if (colors.charAt(i - 1) == 'B' &&
                    colors.charAt(i) == 'B' &&
                    colors.charAt(i + 1) == 'B') B++;
        }
        return A > B;
    }
}
