import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx {



    public static void main(String args[]){

        List list = Arrays.asList("A beautiful", "Alphabet","CD");
        list.stream();
       try{
           method();

       }catch (Exception e){

       }
        System.out.println("Step");

    }

    private static void method() {
    try{
        throw new IllegalArgumentException();
    }
    catch (RuntimeException r){
        System.out.println("One");

    }
    finally {
        System.out.println("Large");

    }
    }


}
