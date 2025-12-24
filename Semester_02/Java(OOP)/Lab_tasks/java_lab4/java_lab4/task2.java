class task2 {
    public static void main(String[] args){
        int nums[]={1,1,2,2,3,3,4,4};
        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        System.out.print("[");
        for(int k=0; k<=j; k++)
        {
            System.out.print(nums[k]);
            if(k<j)
            {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
