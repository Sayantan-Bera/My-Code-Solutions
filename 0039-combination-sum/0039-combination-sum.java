class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         arr=new ArrayList<List<Integer>>();
         Arrays.sort(candidates);
        f(0,target,candidates,new ArrayList<Integer>());
        return arr;
    }
    void f(int i,int t,int[] c,ArrayList<Integer> a){
        if(t<0)return;
        if(t==0){
            if(!arr.contains(a))
            arr.add(new ArrayList<Integer>(a));
            return;
        }

        for(int j=i;j<c.length;j++){
            a.add(c[j]);
            // f(j+1,t-c[j],c,a);
            f(j,t-c[j],c,a);
            a.remove(a.size()-1);
        }
    }
}