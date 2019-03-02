public class BoardSpace {

    Letter letter;

    //letter score multiplier
    int lsm;
    int wsm;

    String rep;

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

    boolean hasLetter(){
        return letter != null;
    }

    @Override
    public String toString() {

        if (hasLetter()){
            return " " + letter.c;
        }

        return "" + (lsm==1 ? "." : lsm) + ""  + "" + (wsm==1 ? "." : wsm);
    }

    public void setLetter(Letter l) {
        letter = l;
    }
}
