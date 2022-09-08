public class Solution {
    public int solution(String[] n){ 
        
        int score = 0;
        int win = 3;
        int draw = 1;

        for(int i = 0; i < n.length; i++){
            int winner = (n[i].charAt(0) - '0') - (n[i].charAt(2) - '0');

            if (winner > 0) score += win;
            else if (winner == 0) score += draw;
        }

        return score;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    // public static void main(String[] args){
    //     Solution s = new Solution();
    //     String[][] test = {{"3:1", "2:2", "1:3"}, {"0:1", "1:2", "1:3"}, {"3:1", "4:2", "2:0"}};
        
    //     for(int i = 0; i < test.length; i++){
    //         System.out.println(s.solution(test[i]));    
    //     }
    // }
}