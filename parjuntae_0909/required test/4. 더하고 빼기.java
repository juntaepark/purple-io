public class Solution {
    public String solution(int n){
        
        String[] fruits = {"1-kiwi","2-pear","3-kiwi","4-banana","5-melon","6-banana","7-melon","8-pineapple","9-apple"};

        while(n >= 10){
            int temp = n;
            int sum = 0;

            while(temp > 0){
                sum += temp%10;
                temp /= 10;
            }

            n -= sum;
        }

        // 각 자릿수를 더하면 항상 9
        return fruits[n-1].substring(2);
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    // public static void main(String[] args){
    //     Solution s = new Solution();

    //     for(int i = 10; i < 100; i++){
    //         System.out.println(s.solution(i));
    //     }
    // }
}