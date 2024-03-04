import java.util.Arrays;

public class Main {
    //int[] sortedArr;//1,3,4,7,8,10; l=5, u=6; [1;4]
    public static void main(String[] args) {
        int[] sortedArr={1,2,3,4,4,5,6,6,7,7,8,8,9,10};
        int low_bound=1, up_bound=4;
        int[] result=searchInterval(sortedArr, low_bound, up_bound);
        System.out.print(Arrays.toString(result));
    }
    public static int[] searchInterval(int[] toSearch, int low_bound, int up_bound){
        int outer_low=0;
        int len = toSearch.length, outer_up=len-1;
        int inner_low=0, inner_up=0;
        boolean foundAny=false;
        for(;;) {

            int now = (outer_low+outer_up)/2;
            if(toSearch[now]>=low_bound){
                if(toSearch[now]<=up_bound){
                    inner_low=inner_up=now;
                    foundAny=true;
                    break;
                }else{
                    outer_up=now;
                }
            }else{
                outer_low=now;
            }
            if(outer_low==outer_up||outer_low==outer_up-1){
                break;
            }
        }
        if(foundAny){
            if(toSearch[outer_low]>=low_bound){
                inner_low=outer_low;
            }else{
                for(;;){
                    int now=(outer_low+inner_low)/2;
                    if (toSearch[now]>=low_bound){
                        inner_low=now;
                    }else{
                        outer_low=now;
                    }
                    if(inner_low==outer_low+1){
                        break;
                    }
                }
            }
            if(toSearch[outer_up]<=up_bound){
                inner_up=outer_up;
            }else{
                for(;;){
                    int now=(outer_up+inner_up)/2;
                    if (toSearch[now]<=up_bound){
                        inner_up=now;
                    }else{
                        outer_up=now;
                    }
                    if(inner_up==outer_up-1){
                        break;
                    }
                }
            }
            int[] toReturn=new int[2];
            toReturn[0]=inner_low;
            toReturn[1]=inner_up;
            return toReturn;
        }else{
            return new int[]{-1,-1};
        }
    }
}