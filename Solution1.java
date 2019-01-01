import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rachit on 1/1/19.
 */

/*
TestCases 
Input : abcdlxyzmno
Ouput : 

Input : kabp
Ouput : kp


*/
public class Solution1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder st = new StringBuilder(s);
        boolean flag= false;
        while(true){
            flag = false;
            int start = 0;
            int index = 0;
            char[] chars = st.toString().toCharArray();
            boolean found = false;
            for (int i = 0; i<chars.length-1 ;i++){
                if(chars[i+1] - chars[i] == 1){
                    index++;
                    found = true;
                    flag = true;
                }else {
                    start++;
                    found = false;
                }
                if(!found && index != 0){
                    start = start -1;
                    break;
                }
            }
            if(index != 0)
                st.replace(start, start+index+1, "");
            if(flag)
                continue;
            else
                break;
        }
        System.out.println(st.toString());
        br.close();
    }
}
