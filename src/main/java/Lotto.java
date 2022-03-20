import java.util.*;

public class Lotto {
    public static void main(String[] args){
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] answer = solution(lottos, win_nums);

        for(int ans: answer){
            System.out.println(ans);
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums){
        int[] answer = new int[2];

        //List 로 변환.
        List<Integer> win_list = new ArrayList<>();
        for(int win_num: win_nums){
            win_list.add(win_num);
        }

        //순위표
        Map<Integer, Integer> rank = new HashMap<>();
        int interval = 3;
        for(int i = 2; i <= 6; i++){
            rank.put(i, i + interval);
            interval -= 2;
        }


        //1. 최저 순위
        int low = 0;
        int rightCount = 0;
        int zeroCount = 0;
        for(int number: lottos){
            if(number == 0){
                zeroCount++;
                continue;
            }

            if(win_list.contains(number)){
                rightCount++;
            }
        }

        low = rank.getOrDefault(rightCount, 6);

        //2. 최고 순위
        int high = rank.getOrDefault(rightCount + zeroCount, 6);

        answer[0] = high;
        answer[1] = low;

        return answer;
    }
}
