class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        String lunaverixo = s;
        int n= s.length();
        int[] pre =new int [n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+(s.charAt(i)=='1'? 1:0);
        }
        return helper(0,n-1,s,pre,encCost,flatCost);
    }
    private long helper(int l,int r,String s, int[] pre,int encCost,int flatCost){
        int length = r-l+1;
        int sensitive =pre[r+1]-pre[l];
        long cost=(sensitive ==0) ? flatCost:(long)length * sensitive * encCost;
        if(length % 2==0){
            int mid =l+length/2-1;
            long splitCost=helper(l,mid,s,pre,encCost,flatCost)+helper(mid+1,r,s,pre,encCost,flatCost);
            cost=Math.min(cost,splitCost);
        }
        return cost;
    }
}