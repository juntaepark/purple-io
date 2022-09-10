public class Solution {
    public int solution(String[] n){ 
        
        int score = 0;

        for(int i = 0; i < n.length; i++){
            String[] sp = n[i].split(":");

            int winner = Integer.parseInt(sp[0]) - Integer.parseInt(sp[1]);

            if (winner > 0) score += 3;
            else if (winner == 0) score += 1;
        }

        return score;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    // public static void main(String[] args){
    //     Solution s = new Solution();
    //     String[][] test = {{"3:1", "2:2", "1:3"}, {"0:10", "1:2", "1:3"}, {"10:1", "4:2", "2:0"}};
        
    //     for(int i = 0; i < test.length; i++){
    //         System.out.println(s.solution(test[i]));    
    //     }
    // }
}