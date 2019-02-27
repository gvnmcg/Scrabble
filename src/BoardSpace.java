public class BoardSpace {

    String rep;

    //letter score multiplier
    int lsm;
    int wsm;

    BoardSpace(String rep){
        this.rep = rep;

        if ( rep.charAt(0) == '.'){
            lsm = 1;
        } else {
            lsm = Integer.parseInt(Character.toString(rep.charAt(0)));
        }

        if ( rep.charAt(1) == '.'){
            wsm = 1;
        } else {
            wsm = Integer.parseInt(Character.toString(rep.charAt(1)));
        }
    }

    @Override
    public String toString() {
        return "" + lsm + "/" + wsm;
    }
}
