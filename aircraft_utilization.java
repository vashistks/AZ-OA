/ "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
                Main main = new Main();
        int[] maxTravelDists = {7000, 10000, 10000};
        int[][][] forwardRouteLists ={ {{1, 2000}, {2, 4000}, {3, 6000}},
                            {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
                                      {{1,3000},{2,5000},{3,7000},{4,10000}}}; 
        int[][][] returnRouteLists ={ {{1, 2000}},
                            {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
                                     {{1,2000},{2,2000},{3,4000},{4,4000}}}; 
        for(int i = 0; i < maxTravelDists.length; ++i){
     System.out.println(main.aircraftUtilization(maxTravelDists[i],forwardRouteLists[i],returnRouteLists[i]));
        }
    }
public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){

    int length1 = forwardRouteList.length;
    int length2 = returnRouteList.length;
    if(length1==0 || length2==0) return new ArrayList<>();
    Arrays.sort(forwardRouteList, (int[] a,int[] b) -> (a[1] - b[1]));
    Arrays.sort(returnRouteList, (int[] a,int[] b) -> (a[1] - b[1]));
    int left = 0;
    int right = length2-1;
    int maxVal = -1;
    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
    while(left < length1 && right >=0) {
        int sum = forwardRouteList[left][1] + returnRouteList[right][1];
        if(sum > maxTravelDist) {
            --right ;
            continue;
        }
        if(sum >= maxVal) {
            int r = right;
            map.putIfAbsent(sum, new ArrayList<>());
            //check for duplicates
            while(r>=0 && returnRouteList[r][1] == returnRouteList[right][1]){
                List<Integer> list = new ArrayList<>();
                list.add(forwardRouteList[left][0]);
                list.add(returnRouteList[r][0]);
                map.get(sum).add(list);
                --r;
            }
            maxVal = sum;
        }
        ++left;
    }
    return map.get(maxVal);
    
}    
}

runtime O(M*N)
