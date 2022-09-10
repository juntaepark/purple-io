import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int solution(String n){

        String[] arr = n.split("\\s");
        Map<Integer,Integer> odd = new HashMap<>();
        Map<Integer,Integer> even = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if (Integer.parseInt(arr[i]) % 2 != 0) odd.put(i+1, Integer.parseInt(arr[i]));
            else even.put(i+1, Integer.parseInt(arr[i]));   
        }

        Map.Entry<Integer,Integer> entry = odd.size() > even.size() ? even.entrySet().iterator().next() : odd.entrySet().iterator().next();
        return entry.getKey();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    //  public static void main(String[] args){
    //      Solution s = new Solution();
    //      String[] test = {"2 4 7 8 10", "1 2 1 1"};

    //      for(int i = 0; i < test.length; i++){
    //          System.out.println(s.solution(test[i]));
    //      }
    //  }
}