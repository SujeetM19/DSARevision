import java.util.ArrayList;

public class mazePath {
    public static void main(String[] args) {
    //     ArrayList<String> ans = mazePath_HVD(0, 0, 3, 3);
    //     System.out.println(ans);

    //     ArrayList<String> ans2 = new ArrayList<>();
    //     mazePath_HVD(0, 0, 3, 3, ans2, "");

        // ArrayList<String> ans = mazePath_HVDJumps(1, 1, 4,4);
        // System.out.println(ans);
        // ArrayList<String> ans4 = new ArrayList<>();
        // mazePath_HVDJumps(1, 1, 4,4, ans4, "");

        // ArrayList<String> ans5 = new ArrayList<>();
        // int [][] dirArr = {{1,0}, {0,1}, {1,1}};
        // String [] dirS = {"H", "V", "D"};

        // int count = mazePath_VectorArray(0, 0, 3, 3, ans5, "", dirArr, dirS);
        // System.out.println(count);

        // ArrayList<String> ans5 = new ArrayList<>();
        // int [][] dirArr = {{1,0}, {1,1}, {0,1}, {-1,1},{-1,0}, {-1,-1}, {0,-1}, {1,-1}};
        // String [] dirS = {"R", "S", "D", "W", "L", "N", "U", "E"};
        // boolean [][] visited = new boolean[4][4];

        // int count = mazePath_VectorArrayVisited(0, 0, 4, 4, visited, ans5, "", dirArr, dirS);
        // System.out.println(count);


        // ArrayList<String> ans6 = new ArrayList<>();
        // int [][] dirArr = {{1,0}, {0,1}, {1,1}};
        // String [] dirS = {"H", "V", "D"};


        // ArrayList<String> ans7 = new ArrayList<>();
        // int [][] dirArr = {{1,0}, {1,1}, {0,1}, {-1,1},{-1,0}, {-1,-1}, {0,-1}, {1,-1}};
        // String [] dirS = {"R", "S", "D", "W", "L", "N", "U", "E"};
        // boolean [][] visited = new boolean[3][3];

        // int count = mazePath_JumpsVectorArray(0, 0, 3, 3, visited, ans7, "", dirArr, dirS);
        // System.out.println(count);


        ArrayList<String> ans7 = new ArrayList<>();
        int [][] dirArr = {{1,0}, {1,1}, {0,1}, {-1,1},{-1,0}, {-1,-1}, {0,-1}, {1,-1}};
        String [] dirS = {"R", "S", "D", "W", "L", "N", "U", "E"};
        boolean [][] visited = new boolean[3][3];

        int count = mazePath_JumpsVectorArray(0, 0, 3, 3, visited, ans7, "", dirArr, dirS);
        System.out.println(count);


    }


    public static ArrayList<String> mazePath_HVD(int sr, int sc, int dr, int dc){
        if(sr > dr || sc > dc) return new ArrayList<>();

        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> asfh = mazePath_HVD(sr+1, sc, dr, dc);
        ArrayList<String> ans = new ArrayList<>();
        for(String elem: asfh){
            ans.add(elem + "h");
        }

        ArrayList<String> asfv = mazePath_HVD(sr, sc+1, dr, dc);
        for(String elem: asfv){
            ans.add(elem + "v");
        }

        ArrayList<String> asfd = mazePath_HVD(sr+1, sc+1, dr, dc);
        for(String elem: asfd){
            ans.add(elem + "d");
        }

        return ans;
    }




    public static void mazePath_HVD(int sr, int sc, int dr, int dc, ArrayList<String> asf, String potAns){
        if(sr>dr || sc> dc) return;

        if(sr == dr && sc == dc){
            System.out.print(potAns + " ");
            asf.add(potAns);
            return;
        }
        
        mazePath_HVD(sr+1, sc, dr, dc, asf, potAns + "h");
        
        mazePath_HVD(sr, sc+1, dr, dc, asf, potAns + "v");

        mazePath_HVD(sr+1, sc+1, dr, dc, asf, potAns + "d");
    }


    public static ArrayList<String> mazePath_HVDJumps(int sr, int sc, int dr, int dc){
        if(sr > dr || sc > dc) return new ArrayList<>();

        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();

        for(int i=1; i<dr; i++){
            ArrayList<String> asfh = mazePath_HVDJumps(sr+i, sc, dr, dc);  
            for(String elem: asfh){
                ans.add(elem + "h" + i);
            }
        }
        
        for(int j=1; j<dc; j++){
            ArrayList<String> asfv = mazePath_HVDJumps(sr, sc+j, dr, dc);
            for(String elem: asfv){
                ans.add(elem + "v" + j);
            }
        }
        
        for(int k=1; k<Math.sqrt(dc*dc + dr*dr); k++){
            ArrayList<String> asfd = mazePath_HVDJumps(sr+k, sc+k, dr, dc);
            for(String elem: asfd){
                ans.add(elem + "d" + k);
            }
        }

        return ans;
    }


    public static void mazePath_HVDJumps(int sr, int sc, int dr, int dc, ArrayList<String> asf, String potAns){
        if(sr>dr || sc>dc) return;

        if(sr== dr && sc == dc){
            asf.add(potAns);
            System.out.print(potAns + " ");
        }

        for(int i=1; i<=dr; i++){
            mazePath_HVDJumps(sr+i, sc, dr, dc, asf, potAns + "h" + i); 
        }

        for(int j=1; j<=dc; j++){
            mazePath_HVDJumps(sr, sc+j, dr, dc, asf, potAns + "v" + j); 
        }

        for(int k=1; k<= dc; k++){
            mazePath_HVDJumps(sr+k, sc+k, dr, dc, asf, potAns+ "d" + k); 
        }
          
    }

    public static int mazePath_VectorArray(int sr, int sc, int dr, int dc, ArrayList<String> ans, String psf, int[][] dirArr, String[] dirS){

        if(sr == dr-1 && sc == dc-1){
            ans.add(psf);
            System.out.println(psf);
            return 1;
        }
        int count = 0;

        for(int i=0; i<dirArr.length; i++){
            int x = sr + dirArr[i][0];
            int y = sc + dirArr[i][1];

            if(x<dr && y<dc){
                count += mazePath_VectorArray(x, y, dr, dc, ans, psf + dirS[i] , dirArr, dirS);
            }
        }

        return count;
    }






    public static int mazePath_VectorArrayVisited(int sr, int sc, int dr, int dc, boolean[][] visited, ArrayList<String> ans, String psf, int[][] dirArr, String[] dirS){

        if(sr == dr-1 && sc == dc-1){
            ans.add(psf);
            System.out.println(psf);
            return 1;
        }
        int count = 0;

        visited[sr][sc] = true;

        for(int i=0; i<dirArr.length; i++){
            int x = sr + dirArr[i][0];
            int y = sc + dirArr[i][1];

            if(x>=0 && y>=0 && x<dr && y<dc && visited[x][y]==false){
                count += mazePath_VectorArrayVisited(x, y, dr, dc, visited,  ans, psf + dirS[i] , dirArr, dirS);
            }
        }
        visited[sr][sc] = false;
        return count;
    }


    public static int mazePath_JumpsVectorArray(int sr, int sc, int dr, int dc, boolean[][] visited, ArrayList<String> ans, String psf, int[][] dirArr, String[] dirS){
        if(sr == dr-1 && sc == dc-1){
            ans.add(psf);
            return 1;
        }

        int count = 0;
        visited[sr][sc]  = true;

        for(int i=0; i<dirArr.length; i++){
            for(int rad = 1; rad< Math.max(dr, dc);  rad++){
                int x = sr + rad * dirArr[i][0];
                int y = sc + rad * dirArr[i][1];

                if(x>=0 && y>=0 && x<dr && y<dc){
                    if(!visited[x][y])
                        count += mazePath_JumpsVectorArray(x, y, dr, dc, visited, ans, psf, dirArr, dirS);
                }else{
                    break;
                }
            }
        }

        visited[sr][sc] = false;
        return count;
    }





    //Longest and shortest path 

    public static String mazePath_longestPath(int sr, int sc, int dr, int dc, int count, int maxC, String max, boolean[][] visited, String psf, int[][] dirArr, String[] dirS){
        if(sr == dr-1 && sc == dc-1){
            if(count > maxC){
                max = psf;
                maxC = count;
                return max;
            }
        }


        visited[sr][sc]  = true;

        for(int i=0; i<dirArr.length; i++){
            for(int rad = 1; rad< Math.max(dr, dc);  rad++){
                int x = sr + rad * dirArr[i][0];
                int y = sc + rad * dirArr[i][1];

                if(x>=0 && y>=0 && x<dr && y<dc){
                    if(!visited[x][y])
                        String ans = mazePath_longestPath(x, y, dr, dc, count + 1, maxC, max, visited, psf, dirArr, dirS);
                }else{
                    break;
                }

            }
        }
        

        visited[sr][sc] = false;
        return ans;
    }


}
