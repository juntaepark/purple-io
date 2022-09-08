public class Solution {
    public int solution(int n){ 
        
        int quarter = 3;
        int temp = n / quarter;
        
        return n % quarter != 0 ? temp + 1 : temp;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    // public static void main(String[] args){
    //     Solution s = new Solution();
    //     for(int i = 1; i <= 12; i++){
    //         System.out.println(s.solution(i));    
    //     }
    // }
}