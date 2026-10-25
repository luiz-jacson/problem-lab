import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int findBiggestLine(List<String> listStrings){
        int biggest = 0;
        for(int i = 0; i < listStrings.size(); i++){
            if(listStrings.get(i).length() > biggest)
                biggest = listStrings.get(i).length();
        }

        return biggest;
    }

    public static String addLeftSpaces(String line, int maxLines){
        int numSpaces =  maxLines - line.length();
        String spaces = "";
        String result = "";
        for(int i = 0; i < numSpaces; i++){
            spaces = spaces + " ";
        }

        result = spaces + line;
        
        return result;
    }

    public static String removeExtraSpaces(String line){
        String[] splitted = line.split("\\s");
        String result = "";
        for(int i = 0; i < splitted.length; i++){
            if(!splitted[i].isBlank()){
                result = result + (splitted[i]);
                if(i < splitted.length - 1)
                    result = result + " ";
            }
        }    
        return result;
    }

    public static List<String> justifyListStrings(List<String> listStrings){
        for(int i = 0; i < listStrings.size(); i++){
            listStrings.set(i, listStrings.get(i).strip());
            listStrings.set(i, removeExtraSpaces(listStrings.get(i)));
        }
            
        int maxChar = findBiggestLine(listStrings);

        for(int i = 0; i < listStrings.size(); i++){     
            listStrings.set(i, addLeftSpaces(listStrings.get(i), maxChar));
        }
        return listStrings;
    }
    
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        boolean firstCase = true;

        while (true) {

            int n = scanner.nextInt();
            scanner.nextLine();

            if (n == 0) {
                break;
            }

            List<String> listStrings = new ArrayList<String>();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                listStrings.add(line);
            }

            List<String> justifiedListStrings = justifyListStrings(listStrings);

            if (!firstCase) {
                System.out.println();
            }

            for (int i = 0; i < justifiedListStrings.size(); i++) {
                System.out.println(justifiedListStrings.get(i));
            }

            firstCase = false;
        }

        scanner.close();
    }
 
}