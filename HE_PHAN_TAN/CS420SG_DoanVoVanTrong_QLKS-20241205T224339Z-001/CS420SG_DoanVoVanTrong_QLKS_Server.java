import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CS420SG_DoanVoVanTrong_QLKS_Server {
    private static List<CS420SG_DoanVoVanTrong_QLKS_Room> danhSachPhong;

    public static void main(String[] args) {
        danhSachPhong = new ArrayList<>();
        khoiTaoDuLieuPhong(); // Thêm phòng vào danh sách

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server đang chạy...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        String[] parts = inputLine.split(";");
                        String command = parts[0];

                        switch (command) {
                            case "laydanhsachphong":
                                guiDanhSachPhong(out);
                                break;
                            case "trangthai":
                                String soPhong = parts[1];
                                kiemTraTrangThaiPhong(soPhong, out);
                                break;
                            default:
                                out.println("Yêu cầu không hợp lệ");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Lỗi khi xử lý yêu cầu từ client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi khởi động server: " + e.getMessage());
        }
    }

    private static void khoiTaoDuLieuPhong() {
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("001", "thường", true, 100.0, 500.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("002", "VIP", true, 200.0, 1000.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("003", "thường", false, 100.0, 500.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("004", "VIP", false, 200.0, 1000.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("005", "thường", true, 120.0, 550.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("006", "VIP", false, 220.0, 1100.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("007", "thường", true, 110.0, 520.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("008", "VIP", true, 210.0, 1050.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("009", "thường", false, 130.0, 600.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("010", "VIP", false, 230.0, 1150.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("011", "thường", true, 140.0, 650.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("012", "VIP", true, 240.0, 1200.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("013", "thường", false, 120.0, 550.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("014", "VIP", false, 220.0, 1100.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("015", "thường", true, 110.0, 520.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("016", "VIP", true, 210.0, 1050.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("017", "thường", false, 130.0, 600.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("018", "VIP", false, 230.0, 1150.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("019", "thường", true, 150.0, 670.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("020", "VIP", true, 250.0, 1250.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("021", "thường", false, 125.0, 575.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("022", "VIP", false, 225.0, 1125.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("023", "thường", true, 115.0, 530.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("024", "VIP", true, 215.0, 1075.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("025", "thường", false, 135.0, 625.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("026", "VIP", false, 235.0, 1175.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("027", "thường", true, 155.0, 690.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("028", "VIP", true, 255.0, 1275.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("029", "thường", false, 128.0, 580.0));
    	danhSachPhong.add(new CS420SG_DoanVoVanTrong_QLKS_Room("030", "VIP", false, 228.0, 1140.0));
    }

    private static void guiDanhSachPhong(PrintWriter out) {
        StringBuilder response = new StringBuilder();
        for (CS420SG_DoanVoVanTrong_QLKS_Room room : danhSachPhong) {
            response.append(room.getSoPhong()).append(";")
                    .append(room.getLoaiPhong()).append(";")
                    .append(room.isConTrong()).append(";")
                    .append(room.getGiaTheoGio()).append(";")
                    .append(room.getGiaTheoNgay()).append("-");
        }
        out.println(response.toString());
    }

    private static void kiemTraTrangThaiPhong(String soPhong, PrintWriter out) {
        boolean found = false;
        for (CS420SG_DoanVoVanTrong_QLKS_Room room : danhSachPhong) {
            if (String.valueOf(room.getSoPhong()).equals(soPhong)) {
                out.println("Trạng thái phòng " + room.getSoPhong() + ": " + (room.isConTrong() ? "Còn trống" : "Đang có khách"));
                found = true;
                break;
            }
        }
        if (!found) {
            out.println("Không tìm thấy phòng có số " + soPhong);
        }
    }
}
