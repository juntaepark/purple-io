import java.util.Arrays;

public class Solution {
    public int solution(int[] n){ 
        
        int[] arr = Arrays.stream(n).distinct().toArray();
        Arrays.sort(arr);
        
        int score = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] != score){
                break;
            }
            score++;
        }

        return score < arr.length ? score : arr.length;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    // public static void main(String[] args){
    //     Solution s = new Solution();
    //     int[][] test = {{0,1,2,4,4},{0,1,2,3,4,5,6},{7,5,7,2,6,1,3,5,0}};
        
    //     for(int i = 0; i < test.length; i++){
    //         System.out.println(s.solution(test[i]));    
    //     }
    // }
}