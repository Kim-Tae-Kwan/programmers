import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class report {
    public static void main(String[] args){

        String[] report = {"b a","a b","c b"};
        String[] id_list = {"a","b","c"};
        int k = 2;

        solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k){

        //1. 신고 받은 사람
        Map<String, List<String>> reportedIds = new HashMap<>();
        for(String rep: report){
            String[] reportSplit = rep.split(" ");
            if(!reportedIds.containsKey(reportSplit[1])){
                List<String> reporters = new ArrayList<>();
                reporters.add(reportSplit[0]);
                reportedIds.put(reportSplit[1], reporters);
            }else{
                List<String> reporters = reportedIds.get(reportSplit[1]);
                if(!reporters.contains(reportSplit[0])){
                    reporters.add(reportSplit[0]);
                }
            }
        }

        //2. 신고한 사용자가 받을 이메일 수.
        Map<String, Integer> reporterHash = new HashMap<>();
        for(List<String> reporters: reportedIds.values()){
            if(reporters.size() >= k){
                for(String reporter: reporters){
                    if(!reporterHash.containsKey(reporter)){
                        reporterHash.put(reporter, 1);
                    }else{
                        Integer emailNumber = reporterHash.get(reporter) + 1;
                        reporterHash.put(reporter, emailNumber);
                    }
                }
            }
        }

        //3. 메일 받은 수의 배열.
        int[] answer = new int[id_list.length];
        for (int i = 0; i< id_list.length; i++){
            if(reporterHash.get(id_list[i]) == null){
                answer[i] = 0;
            }else{
                answer[i] = reporterHash.get(id_list[i]);
            }
        }

        for (int i = 0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }
}
