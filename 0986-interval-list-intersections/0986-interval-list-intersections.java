import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int[]> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i<firstList.length && j<secondList.length){

            int s1 = firstList[i][0];
            int e1 = firstList[i][1];

            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            int s = Math.max(s1,s2);
            int e = Math.min(e1,e2);

            if(s<=e){
                ans.add(new int[]{s,e});
            }

            if(e1<e2){
                i++;
            }else{
                j++;
            }

        }


        return ans.toArray(new int[ans.size()][]);

    }
}