public class Solution {
    public int solution(String n){
        
        int score = 0;
        char[] find = {'a', 'e', 'i', 'o', 'u'};

        score = (int)n.chars().filter(
                c->c == find[0] ||
                   c == find[1] ||
                   c == find[2] ||
                   c == find[3] ||
                   c == find[4]).count();
        
        return score;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    //  public static void main(String[] args){
    //      Solution s = new Solution();
    //      String[] test = {"abracadabra","aeiou","uuu", "bcdfghjklmnpqrstvwxyz"};

    //      for(int i = 0; i < test.length; i++){
    //          System.out.println(s.solution(test[i]));
    //      }
    //  }
}