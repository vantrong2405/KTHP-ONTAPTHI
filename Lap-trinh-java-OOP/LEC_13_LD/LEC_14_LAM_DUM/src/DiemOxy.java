public class DiemOxy {
    private int ox,oy;
    public DiemOxy() {
    }
    public DiemOxy(int x, int y) {
        ox = x; oy = y;
    }
    public int getOx() {
        return ox;
    }
    public void setOx(int ox) {
        this.ox = ox;
    }
    public int getOy() {
        return oy;
    }
    public void setOy(int oy) {
        this.oy = oy;
    }
    @Override
    public String toString() {
        return "("+ox+ "," + oy +")";
    }
    public double modul(){
        return Math.sqrt(ox*ox + oy*oy);
    }
    public double khoangCach(DiemOxy b){
        return Math.sqrt(Math.pow(this.ox -b.ox,2)+Math.pow(this.oy -b.oy,2));
    }
    public static void main(String[] args) {
        DiemOxy a = new DiemOxy();
    }
 }