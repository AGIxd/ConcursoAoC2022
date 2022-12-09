import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainA {
    static char[] StringToArray(String line){
        char[] array = new char[line.length()];
        for (int i = 0; i < array.length; i++){
            array[i] = line.charAt(i);
        }
        return array;
    }
    public static void main(String[] args) {
        String mitadPrimera, mitadSegunda;
        int priority = 0, total = 0;
        int lineNumber = 1;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : allLines) {
                char[] lineChar = StringToArray(line);
                priority = comparar(lineChar);
                total += priority;
                priority = 0;
                lineNumber++;
            }
            System.out.print("The sum of all priorities is: " +total);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int comparar(char[] a){
        char answer = 'a';
        int priority = 0;
        boolean check = false;
        for(int i = 0; i < a.length/2 && !check; i++){
            for(int j = a.length-1; j >= a.length/2  && !check; j--){
                if (a[i] == a[j]) {
                    answer = a[i];
                    check = true;
                    System.out.print(answer + "\n");
                    }
                }
            }
        //if (check == false) System.out.println("No hay caracter en comun");
        //Ajustar la respuesta al valor dado
        if('a' <= answer && answer <= 'z') //Between 'a' and 'z'
            priority = answer - 'a'+ 1;
        else if('A' <= answer && answer <= 'Z') //Between 'A' and 'Z'
            priority = answer - 'A' + 27;
        return priority;
    }
}