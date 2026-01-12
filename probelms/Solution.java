class Solution {
    static int count(int a[],int low,int mid,int high){
        int c=0;
        int j=mid+1;
        System.out.println(j);
        for(int i=low;i<=mid;i++){
            while((j<=high) && (a[i]>2*a[j])){
                j++;
            }
            c=c+(j-(mid+1));
        }
        return c;
    }
    static int merge(int a[],int low,int mid,int high){
        int c=count(a,low,mid,high);
        int i=low,j=mid+1,k=0;
        int temp[] = new int[high-low+1];
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }
            else{
                temp[k++]=a[j++];
            }
        }
        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=high){
            temp[k++]=a[j++];
        }
        for(int b=0;b<k;b++,low++){
            a[low]=temp[b];
        }
        return c;
    }
    static int mergesort(int a[],int low,int high){
        int c =0; 
        if(low>=high){
            return c;
        }
        int mid = (low+high)/2;
        c= c+mergesort(a,low,mid);
        c= c+mergesort(a,mid+1,high);
        c= c+merge(a,low,mid,high);
        return c;
    }
    public static int countRevPairs(int N, int arr[]) {
        // Code here
        return mergesort(arr,0,N-1);
    }
    public static void main(String args[]){
        int a[]={2, 4, 3, 5, 1};
        countRevPairs(a.length,a);
    }
}