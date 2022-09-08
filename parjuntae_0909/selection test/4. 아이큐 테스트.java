import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String n){

        String[] arr = n.split("\\s");
        int[] values = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(int i : values){
            if (i % 2 != 0) odd.add(i);
            else even.add(i);
        }

        return odd.size() > even.size() ? even.get(0) : odd.get(0);
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