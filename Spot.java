public class Spot {

    private boolean occupied;
    private boolean byBlack;
    private boolean byWhite;
    private String pos;


    public Spot(boolean occupied, boolean byBlack, boolean byWhite, String pos) {
        this.occupied = occupied;
        this.byBlack = byBlack;
        this.byWhite = byWhite;
        this.pos = pos;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isByBlack() {
        return byBlack;
    }

    public void setByBlack(boolean byBlack) {
        this.byBlack = byBlack;
    }

    public boolean isByWhite() {
        return byWhite;
    }

    public void setByWhite(boolean byWhite) {
        this.byWhite = byWhite;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
