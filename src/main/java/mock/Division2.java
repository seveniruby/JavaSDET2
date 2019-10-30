package mock;

public class Division2 {
    public Integer divid2(Integer a, Integer b, Integer c, Division division) {
        Integer x=division.divid(a, b) ;
        if (x>10){
            return 0;
        }else{
            return x/c;
        }
    }

    public Integer divid(Integer a, Integer b) {
        if (b == 0) {
            return null;
        } else if (a > 100) {
            return null;
        } else if (a < b) {
            return 0;
        } else {
            return a / b;
        }
    }


    public Integer divid3(Integer a, Integer b, Integer c) {
        Integer x=divid(a, b) ;
        if (x>10){
            return 0;
        }else{
            return x/c;
        }
    }


}
