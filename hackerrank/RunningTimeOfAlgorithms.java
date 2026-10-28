import java.util.ArrayList;
import java.util.List;

public class RunningTimeOfAlgorithms{
    public static int runningTime(List<Integer> arrv) {
        int aux = 0;
        List<Integer> arr = arrv;
        for(int i = 1; i < arr.size(); i++){
            int j = i - 1;
            while(j >= 0 && arr.get(j) > arr.get(i)){
                if(arr.get(i) < arr.get(j)){
                    aux = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, aux);
                }
            }
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }

        return 0;
    }
    public static void main(String[] args){
        
        List<Integer> arr = new ArrayList<Integer>(List.of(4, 4 ,3 ,4));  
        System.out.println(runningTime(arr));

    }

}