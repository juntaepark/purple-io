import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Solution {
    public int solution(String n){

        int odd = 0;
        int even = 0;

        String[] arr = n.split("\\s");
        HashMap<Integer,Integer> hm = new HashMap<>();

        int i = 0;
        for(String s : arr){
            hm.put(i++, Integer.parseInt(s));
        }

        for(int j = 0; j < 3; j++){

        }

        for(int a : hm.keySet()){
            if (hm.get(a) % 2 != 0) odd++;
            else even++;
        }


        return 1;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
     public static void main(String[] args){
         Solution s = new Solution();
         String[] test = {"2 4 7 8 10", "1 2 1 1"};

         for(int i = 0; i < test.length; i++){
             System.out.println(s.solution(test[i]));
         }
     }
}