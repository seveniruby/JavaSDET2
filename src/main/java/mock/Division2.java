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
}
