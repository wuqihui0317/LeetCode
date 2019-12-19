package Sixty_OneToEighty;
/**
 * @author wub
 * LeetCode
 * 67.Add Binary
 * 两个二进制数字求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 && j >= 0){
            char n = (char)(a.charAt(i--) + b.charAt(j--) - '0' + carry);
            if (n == '3' || n == '2'){
                carry = 1;
                result.insert(0,n-'2');
            }
            else {
                carry = 0;
                result.insert(0,n);
            }
        }
        while (i >= 0){
            char n = (char)(a.charAt(i--) + carry);
            if (n == '2'){
                carry = 1;
                result.insert(0,'0');
            }
            else {
                carry = 0;
                result.insert(0,n);
                result.insert(0,a.substring(0,i+1));
                break;
            }
        }
        while (j >= 0){
            char n = (char)(b.charAt(j--) + carry);
            if (n == '2'){
                carry = 1;
                result.insert(0,'0');
            }
            else {
                carry = 0;
                result.insert(0,n);
                result.insert(0,b.substring(0,j+1));
                break;
            }
        }
        if (carry == 1)
            result.insert(0,'1');
        return result.toString();
    }
}
