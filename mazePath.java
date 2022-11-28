import java.util.ArrayList;

public class mazePath {
    public static void main(String[] args) {
        // ArrayList<String> ans = mazePath_HVD(0, 0, 3, 3);
        // System.out.println(ans);

        // ArrayList<String> ans2 = new ArrayList<>();
        // mazePath_HVD(0, 0, 3, 3, ans2, "");

        // ArrayList<String> ans = mazePath_HVDJumps(1, 1, 4,4);
        // System.out.println(ans);
        ArrayList<String> ans4 = new ArrayList<>();
        mazePath_HVDJumps(1, 1, 4,4, ans4, "");
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
}
