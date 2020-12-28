package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 38.Count and Say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = i;
            while (index+1 < str.length() && str.charAt(1+index) == ch) index++;
            sb.append(Integer.toString(index - i + 1));
            sb.append(ch);
            i = index;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
