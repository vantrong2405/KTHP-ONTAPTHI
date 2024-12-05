public class CS420SG_DoanVoVanTrong_QLKS_Room {
    private String soPhong;
    private String loaiPhong;
    private boolean conTrong;
    private double giaTheoGio;
    private double giaTheoNgay;

    public CS420SG_DoanVoVanTrong_QLKS_Room(String soPhong, String loaiPhong, boolean conTrong, double giaTheoGio, double giaTheoNgay) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.conTrong = conTrong;
        this.giaTheoGio = giaTheoGio;
        this.giaTheoNgay = giaTheoNgay;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public boolean isConTrong() {
        return conTrong;
    }

    public double getGiaTheoGio() {
        return giaTheoGio;
    }

    public double getGiaTheoNgay() {
        return giaTheoNgay;
    }
}