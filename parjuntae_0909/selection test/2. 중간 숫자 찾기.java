import java.util.Arrays;

public class Solution {
    public int solution(int[] n){

        Arrays.sort(n);

        return n[n.length / 2];
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    //  public static void main(String[] args){
    //      Solution s = new Solution();
    //      int[][] test = {{0,1,2},{5,1,2},{3,2,1},{6,18,55}};

    //      for(int i = 0; i < test.length; i++){
    //          System.out.println(s.solution(test[i]));
    //      }
    //  }
}

