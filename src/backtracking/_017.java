package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/04/4:01 PM
 * @Description:
 */
public class _017 {
    public List<String> letterCombinations(String digits) {
        String[] dict = new String[]{"abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"};
        String cur = "";
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        dfs(digits, dict, cur, 0, ans);
        return ans;
    }
    public void dfs(String digits, String[] dict, String cur, int i, List<String> ans){
        if(cur.length() == digits.length()){
            ans.add(new String(cur));
            return;
        }
        String words = dict[Character.getNumericValue(digits.charAt(i)) - 2]; // 'abc'
        for(int k = 0; k < words.length(); k++){
            cur += words.charAt(k);
            dfs(digits, dict, cur, i+1, ans);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        _017 test = new _017();
        List<String> ans = test.letterCombinations("23");
        for (String s: ans) {
            System.out.print(s + " ");
        }
    }
}
