import java.util.*;
import java.util.function.Function;

/**
 * Created by dirghayu on 02-07-2017.
 */
public class AWS {
    public static void main(String args[]){
//        int x = totalScore( new String[]{   "Z", "-2", "4", "Z", "X","+"},8);
//        System.out.println("x::"+x);

        String[] x = largestItemAssociation(new String[][]{
                {"ITEM1", "ITEM2"},
                {"ITEM3", "ITEM4"},
                {"ITEM4", "ITEM5"}
        });

        System.out.println("X::"+x);
    }
    public static String[] largestItemAssociation(String[][] itemAssociation)
    {
        Map<String, Set<String>> associations = new HashMap();

        for(String[] items: itemAssociation){

            Set<String> merged = new HashSet<>();
            for(String item: items) {
                if(associations.get(item) !=null)
                merged.addAll(associations.get(item));
                else{
                    merged.add(item);
                }
                associations.put(item, merged);
            }

        }
        Set<String> max = associations.values().stream().max(Comparator.comparing(s -> s.size())).orElse(new HashSet<>());
//        return max.or(new Set<String>());
        // WRITE YOUR CODE HERE
        return null;
    }

    public static int totalScore(String[] blocks, int n){

        class Score{
            int total = 0;
            LinkedList<Integer> previous = new LinkedList<>();

            void addScore(String score){
                int currentScore = 0;
                if(score.equals("X")){
                    if(!previous.isEmpty()) currentScore= previous.peek()*2;
                    else currentScore =0;
                    previous.push(currentScore);
                    total += currentScore;
                } else if(score.equals("+")){
                    int size = previous.size();

                    System.out.println("size -1:::"+previous.get(size -1 ));
                    System.out.println("size -2:::"+previous.get(size -2 ));
                    if(previous.size()==0)
                        currentScore =0 ;
                    else
                        if(previous.size() == 1)
                            currentScore = previous.peek();
                    else
                        currentScore = previous.peek() + previous.get( 1);
                    total += currentScore;
                    previous.push(currentScore);
                }
                else if(score.equals("Z")){
                    System.out.println("previous:"+previous);
                    int removedElement =  0;
                    if(!previous.isEmpty()) removedElement=previous.pop();

                    System.out.println("removedElement:"+removedElement);
                    total -= removedElement;
                }else{
                    currentScore = Integer.parseInt(score);
                    total += currentScore;
                    previous.push(currentScore);
                }

                System.out.println("current:"+currentScore+" total:"+total+ "previous:"+previous);
            }
        }

        Score score = new Score();

        for(String currentThrow: blocks){
            score.addScore(currentThrow);
        }
        return score.total;
    }
}
