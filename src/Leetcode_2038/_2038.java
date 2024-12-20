package Leetcode_2038;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/02/2:38 PM
 * @Description:
 */
public class _2038 {
    public boolean winnerOfGame(String colors) {
        int A = 0;
        int B = 0;
        int sizeA = 0;
        int sizeB = 0;
        char last = colors.charAt(0);
        int result = (last == 'A') ? sizeA++ : sizeB++;
        for (int i = 1; i < colors.length(); i++) {
            if(colors.charAt(i) != last){
                last = colors.charAt(i);
                if(sizeA >= 3) A += sizeA - 2;
                if(sizeB >= 3) B += sizeB - 2;
                if(colors.charAt(i) == 'A'){
                    sizeA = 1;
                    sizeB = 0;
                }
                if(colors.charAt(i) == 'B') {
                    sizeB = 1;
                    sizeA = 0;
                }
            }else{
                last = colors.charAt(i);
                if(colors.charAt(i) == 'A') sizeA++;
                if(colors.charAt(i) == 'B') sizeB++;
            }
        }
        if(sizeA >= 3) A += sizeA - 2;
        if(sizeB >= 3) B += sizeB - 2;
        return A > B;
    }
}
