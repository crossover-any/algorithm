package sort;

/**
 * xxx
 *
 * @author tengxq
 */
public class KMP {

    public static void main(String[] args) {
        String str = "ababcabcdabcde";
        int[] next = new int[str.length()+1];
        getNext(next, str);
        System.out.println(next);
    }

    public static void getNext(int[] next,String sub){
        next[0] = -1;
        next[1] = 0;

        int i = 2;
        int k = 0;

        //由于我们设定好了next数组前两位的值
        //所以我们使用我们上面所讲到的逻辑就可以很好的完成我们的填充
        while(i < next.length){
            if (k ==- 1 || sub.charAt(k) == sub.charAt(i-1)){
                next[i] = k+1;
                i++;
                k++;
            } else {
                k = next[k];
            }
        }
    }
}
