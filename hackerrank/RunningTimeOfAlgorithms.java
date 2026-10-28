import java.util.ArrayList;
import java.util.List;

public class RunningTimeOfAlgorithms{
    public static int runningTime(List<Integer> arrv) {
        int count = 0;
        List<Integer> arr = arrv;
        for(int i = 1; i < arr.size(); i++){
            int currentVal = arr.get(i);
            int j = i - 1;
            while(j >= 0 && arr.get(j) > currentVal){
                arr.set(j + 1, arr.get(j));
                j--;
                count++;
            }

            arr.set(j + 1, currentVal);
        }

        return count;
    }
    public static void main(String[] args){
        
        List<Integer> arr = new ArrayList<Integer>(List.of(4, 4 ,3 ,4));  
        System.out.println(runningTime(arr));

    }

}