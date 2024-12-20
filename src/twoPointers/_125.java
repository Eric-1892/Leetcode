package twoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/13/1:28 PM
 * @Description:
 */
public class _125 {
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!Character.isLetterOrDigit(cur) || cur == ' '){
                s = s.substring(0, i) + s.substring(i+1);
                i--;
            }
            else if(Character.isUpperCase(cur)){
                s = s.substring(0, i) + Character.toLowerCase(cur) +  s.substring(i+1);
            }
        }
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        _125 test = new _125();
        String s = "0P";
        test.isPalindrome(s);
    }
}
