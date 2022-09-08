import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(String[] n){
        
        List<String> list = new ArrayList<>();
        int friends = 4;

        for(int i = 0; i < n.length; i++){
            if (n[i].length() == friends){
                list.add(n[i]);
            }
        }

        return list.toString();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    //  public static void main(String[] args){
    //      Solution s = new Solution();
    //      String[][] test = {{"Ryan", "Kieran", "Mark"},
    //                         {"Mune", "juntae", "joung", "Park", "Jack", "Kuas"},
    //                         {"Os", "jobs", "K", "Ryu"}};

    //      for(int i = 0; i < test.length; i++){
    //          System.out.println(s.solution(test[i]));
    //      }
    //  }
}