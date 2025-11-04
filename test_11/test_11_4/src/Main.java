public class Main {
    public static String convert(String s, int n) {
        String str = "";
        int d = 2*n-2;
        if(d == 0){
            return s;
        }
        for(int i = 0; i < n;i++){
            int x = i;
            if(i == 0 || i == n-1){
                while(x < s.length()){
                    str += s.charAt(x);
                    x += d;
                }
            }else{
                int y = d - x;
                while(x < s.length() || y < s.length()){
                    str += s.charAt(x);
                    if(y < s.length()){//走到这里x下标一定不会越界，但是y下标可能越界
                        str += s.charAt(y);
                    }
                    x += d;
                    y += d;
                }
            }

        }
        return str;
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String result = convert(s,3);
        System.out.println(result);
    }
}
