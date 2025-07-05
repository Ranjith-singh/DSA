public class givenSumKpositives{

    public static int kPositiveSums(int[] arr,int k){
        int i=0,j=0,sum=0,len =0;
        while(j<arr.length){
            sum = sum + arr[j];
            while(sum>k && i<=j){
                sum = sum - arr[i];
                i++;
            }
            if(sum == k){
                len = Math.max(len,j-i+1);
            }
            j++;
        }
        if(sum == k){
            len = Math.max(len,j-i+1);
        }
        return len;
    }
    public static void main(String[] args) {
        
    }
}