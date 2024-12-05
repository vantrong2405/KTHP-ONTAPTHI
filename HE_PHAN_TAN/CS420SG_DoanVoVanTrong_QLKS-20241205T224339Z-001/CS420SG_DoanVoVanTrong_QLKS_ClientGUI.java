import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CS420SG_DoanVoVanTrong_QLKS_ClientGUI extends JFrame {
    private JComboBox<String> cbLoaiPhong;
    private JTextField txtSoPhong;
    private JButton btnKiemTra;
    private JButton btnDatLai;
    private JButton btnThoat;
    private JButton btnSapXep; 
    private JTable table;
    private DefaultTableModel model;
    private List<CS420SG_DoanVoVanTrong_QLKS_Room> danhSachPhong;
    private JCheckBox chkPhongTrong;

    private Socket socket;
    private PrintWriter xuat;
    private BufferedReader nhap;

    public CS420SG_DoanVoVanTrong_QLKS_ClientGUI() {
        danhSachPhong = new ArrayList<>();

        setTitle("Quản lý Khách Sạn");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblLoaiPhong = new JLabel("Loại phòng:");
        String[] loaiPhongs = {"Tất cả", "Thường", "VIP"};
        cbLoaiPhong = new JComboBox<>(loaiPhongs);
        cbLoaiPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capNhatBangLoc();
            }
        });
        chkPhongTrong = new JCheckBox("Phòng trống");
        chkPhongTrong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capNhatBangLoc();
            }
        });
        topPanel.add(lblLoaiPhong);
        topPanel.add(cbLoaiPhong);
        topPanel.add(chkPhongTrong);

        JLabel lblSoPhong = new JLabel("Số phòng:");
        txtSoPhong = new JTextField(10);
        btnKiemTra = new JButton("Kiểm tra");
        topPanel.add(lblSoPhong);
        topPanel.add(txtSoPhong);
        topPanel.add(btnKiemTra);

        btnDatLai = new JButton("Đặt lại");
        topPanel.add(btnDatLai);
        btnSapXep = new JButton("Sắp xếp");
        topPanel.add(btnSapXep);
        btnThoat = new JButton("Thoát");
        topPanel.add(btnThoat);

        btnSapXep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepPhong(); 
            }
        });

        panel.add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Số phòng");
        model.addColumn("Loại phòng");
        model.addColumn("Trạng thái");
        model.addColumn("Giá giờ");
        model.addColumn("Giá ngày");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        btnKiemTra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String soPhong = txtSoPhong.getText().trim();
                if (!soPhong.isEmpty()) {
                    guiYeuCau("trangthai;" + soPhong);
                } else {
                    JOptionPane.showMessageDialog(CS420SG_DoanVoVanTrong_QLKS_ClientGUI.this, "Vui lòng nhập số phòng!");
                }
            }
        });

        btnDatLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSoPhong.setText("");
                chkPhongTrong.setSelected(false);
                cbLoaiPhong.setSelectedItem("Tất cả");
                danhSachPhong.clear(); 
                yeuCauLayDuLieuPhongTuServer(); 
                capNhatBangLoc(); 
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);

        setVisible(true);

        ketNoiDenServer();
    }

    private void ketNoiDenServer() {
        try {
            socket = new Socket("localhost", 12345); 
            nhap = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            xuat = new PrintWriter(socket.getOutputStream(), true);

            yeuCauLayDuLieuPhongTuServer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void yeuCauLayDuLieuPhongTuServer() {
        try {
            xuat.println("laydanhsachphong"); 
            String phanHoi = nhap.readLine(); 

            if (phanHoi != null && !phanHoi.isEmpty()) {
                danhSachPhong = phanTichDuLieuPhong(phanHoi);
                
                capNhatBangLoc();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<CS420SG_DoanVoVanTrong_QLKS_Room> phanTichDuLieuPhong(String phanHoi) {
        List<CS420SG_DoanVoVanTrong_QLKS_Room> rooms = new ArrayList<>();
        String[] lines = phanHoi.split("-");
        System.out.println(">>>>"+phanHoi);
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(";");
            String soPhong = parts[0];
            String loaiPhong = parts[1];
            boolean conTrong = Boolean.parseBoolean(parts[2]);
            double giaTheoGio = Double.parseDouble(parts[3]);
            double giaTheoNgay = Double.parseDouble(parts[4]);

            CS420SG_DoanVoVanTrong_QLKS_Room room = new CS420SG_DoanVoVanTrong_QLKS_Room(soPhong, loaiPhong, conTrong, giaTheoGio, giaTheoNgay);
            rooms.add(room);
        }
        return rooms;
    }

    private void guiYeuCau(String yeuCau) {
        if (xuat != null) {
            xuat.println(yeuCau); 
            try {
                String phanHoi = nhap.readLine(); 
                JOptionPane.showMessageDialog(this, phanHoi); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void capNhatBangLoc() {
        xoaDuLieuTrongBang();
        String loaiPhongDuocChon = cbLoaiPhong.getSelectedItem().toString();
        boolean chiHienThiPhongTrong = chkPhongTrong.isSelected();

        for (CS420SG_DoanVoVanTrong_QLKS_Room phong : danhSachPhong) {
            boolean phuHopLoaiPhong = loaiPhongDuocChon.equals("Tất cả") ||
                    (loaiPhongDuocChon.equals("Thường") && phong.getLoaiPhong().equals("thường")) ||
                    (loaiPhongDuocChon.equals("VIP") && phong.getLoaiPhong().equals("VIP"));

            if (phuHopLoaiPhong && (!chiHienThiPhongTrong || phong.isConTrong())) {
                model.addRow(new Object[]{
                    phong.getSoPhong(),
                    phong.getLoaiPhong(),
                    phong.isConTrong() ? "Còn trống" : "Đang có khách",
                    phong.getGiaTheoGio(),
                    phong.getGiaTheoNgay()
                });
            }
        }
    }

    private void xoaDuLieuTrongBang() {
        model.setRowCount(0);
    }

    private void sapXepPhong() {
        Collections.sort(danhSachPhong, new Comparator<CS420SG_DoanVoVanTrong_QLKS_Room>() {
            @Override
            public int compare(CS420SG_DoanVoVanTrong_QLKS_Room p1, CS420SG_DoanVoVanTrong_QLKS_Room p2) {
                if (p1.getLoaiPhong().equalsIgnoreCase("thường") && p2.getLoaiPhong().equalsIgnoreCase("VIP")) {
                    return -1;
                } else if (p1.getLoaiPhong().equalsIgnoreCase("VIP") && p2.getLoaiPhong().equalsIgnoreCase("thường")) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        capNhatBangLoc();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CS420SG_DoanVoVanTrong_QLKS_ClientGUI();
            }
        });
    }
}
