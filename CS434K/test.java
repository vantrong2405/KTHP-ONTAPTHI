/* 
Hàm assertEquals(expected, actual, delta);
expected: Giá trị mà bạn mong đợi. Đây là giá trị mà bạn muốn so sánh với giá trị thực tế để xác định xem phương thức có hoạt động đúng hay không.
actual: Giá trị thực tế mà phương thức trả về. Đây là giá trị bạn nhận được khi gọi phương thức.
delta: Khoảng sai số tối đa cho phép. cứ để 0.01 or 0 , có or ko có cũng dc nhưng nên có
*/

//1.Dùng junit test case hoặc Nunit Test để test các phương thức của lớp HOCVIEN ( 3 điểm)
public class HOCVIEN {
    private String MaHV;
    private String Hoten;
    private String Ngaysinh;
    private double D1, D2, DT;
    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }
    public String getMaHV() {
        return this.MaHV;
    }
    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }
    public String getHoten() {
        return this.Hoten;
    }
    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    public String getNgaysinh() {
        return this.Ngaysinh;
    }
    public HOCVIEN(String HT, String NS, String Mhv, double d1, double d2, double d3) {
        this.MaHV = Mhv;
        this.Hoten = HT;
        this.Ngaysinh = NS;
        this.D1 = d1;
        this.D2 = d2;
        this.DT = dt;
    }
    public double DTB() {
        return ((this.D1 + this.D2) / 2 + this.DT * 2) / 3;
    }
    public String Xeploai() {
        double dtb = this.DTB();
        if (dtb < 3) return "Kem";
        else if (dtb < 5) return "Yeu";
        else if (dtb <= 6) return "Trungbinh";
        else if (dtb < 8) return "Kha";
        else return "Gioi";
    }
}


// Dùng JUnit
public class HOCVIENTest {

    // Phương thức tạo đối tượng HOCVIEN với các tham số cố định và điểm
    private HOCVIEN createHocVien(double d1, double d2, double dt) {
        return new HOCVIEN("Nguyễn Văn A", "01/01/2000", "HV001", d1, d2, dt); // Khai báo đối tượng HOCVIEN
    }

    // Kiểm thử phương thức tính điểm trung bình
    @Test
    public void testDTB() {
        HOCVIEN hocVien = createHocVien(6, 8, 7); // Khai báo đối tượng HOCVIEN
        double expectedDTB = ((6 + 8) / 2.0 + 7 * 2) / 3.0; // Giá trị mong đợi
        double actualDTB = hocVien.DTB(); // Giá trị thực tế từ phương thức DTB
        assertEquals(expectedDTB, actualDTB, 0.01); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức xếp loại cho trường hợp xếp loại "Gioi"
    @Test
    public void testXeploai_Gioi() {
        HOCVIEN hocVien = createHocVien(8, 8, 8); // Khai báo đối tượng HOCVIEN
        assertEquals("Gioi", hocVien.Xeploai()); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức xếp loại cho trường hợp xếp loại "Kha"
    @Test
    public void testXeploai_Kha() {
        HOCVIEN hocVien = createHocVien(7, 8, 5); // Khai báo đối tượng HOCVIEN
        assertEquals("Kha", hocVien.Xeploai()); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức xếp loại cho trường hợp xếp loại "Trungbinh"
    @Test
    public void testXeploai_Trungbinh() {
        HOCVIEN hocVien = createHocVien(5, 6, 5); // Khai báo đối tượng HOCVIEN
        assertEquals("Trungbinh", hocVien.Xeploai()); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức xếp loại cho trường hợp xếp loại "Yeu"
    @Test
    public void testXeploai_Yeu() {
        HOCVIEN hocVien = createHocVien(4, 3, 2); // Khai báo đối tượng HOCVIEN
        assertEquals("Yeu", hocVien.Xeploai()); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức xếp loại cho trường hợp xếp loại "Kem"
    @Test
    public void testXeploai_Kem() {
        HOCVIEN hocVien = createHocVien(2, 1, 0); // Khai báo đối tượng HOCVIEN
        assertEquals("Kem", hocVien.Xeploai()); // So sánh giá trị thực tế với giá trị mong đợi
    }
}

//2. Dùng junit test case hoặc Nunit Test để test các phương thức của lớp CHUNHAT( 3 điểm)

public class CHUNHAT {
    public int D, R;
    public CHUNHAT() {
        d = 1;
        r = 1;
    }
    public CHUNHAT(int d, int r) {
        this.D = d;
        this.R = r;
    }

    public int DienTich() {
        return (this.D * this.r);
    }
    public int ChuVi() {
        return ((this.D + this.R) * 2);
    }
}

// Dùng Junit
public class CHUNHATTest {
    CHUNHAT chuNhat = new CHUNHAT(4, 5);
    // Kiểm thử phương thức tính diện tích
    @Test
    public void testDienTich() {
        int expectedArea = 4 * 5; // Giá trị mong đợi
        int actualArea = chuNhat.DienTich(); // Giá trị thực tế từ phương thức DienTich
        assertEquals(expectedArea, actualArea, 0); // So sánh giá trị thực tế với giá trị mong đợi, delta là 0 cho số nguyên
    }

    // Kiểm thử phương thức tính chu vi
    @Test
    public void testChuVi() {
        int expectedPerimeter = (4 + 5) * 2; // Giá trị mong đợi
        int actualPerimeter = chuNhat.ChuVi(); // Giá trị thực tế từ phương thức ChuVi
        assertEquals(expectedPerimeter, actualPerimeter, 0); // So sánh giá trị thực tế với giá trị mong đợi, delta là 0 cho số nguyên
    }
}
//3. Dùng junit test case hoặc Nunit Test để test các phương thức của lớp HINHTRON( 3 điểm)
public class HINHTRON {
    public double R;
    public HINHTRON() {
        this.R = 0;
    }
    public HINHTRON(double r) {
        this.R = r;
    }
    public double Chuvi() {
        return 2 * this.R * Math.PI;
    }
    public double Dientich() {
        return this.R * this.R * Math.PI;
    }
}

public class HINHTRONTest {
     HINHTRON hinhTron = new HINHTRON(5); 
    // Kiểm thử phương thức tính chu vi
    @Test
    public void testChuVi() {
        double expectedCircumference = 2 * 5 * Math.PI; // Giá trị mong đợi
        double actualCircumference = hinhTron.Chuvi(); // Giá trị thực tế từ phương thức Chuvi
        assertEquals(expectedCircumference, actualCircumference, 0.01); // So sánh giá trị thực tế với giá trị mong đợi
    }

    // Kiểm thử phương thức tính diện tích
    @Test
    public void testDienTich() {
        double expectedArea = 5 * 5 * Math.PI; // Giá trị mong đợi
        double actualArea = hinhTron.Dientich(); // Giá trị thực tế từ phương thức Dientich
        assertEquals(expectedArea, actualArea, 0.01); // So sánh giá trị thực tế với giá trị mong đợi
    }
}

//4. Dùng junit test case hoặc Nunit Test để test các phương thức sau ( 3 điểm) 
//Câu 4 đề ko cho class
Public double Sum(int A, int B) {
    Return(A + B);
}


Public double Average(double A, int B){
    Return(A + B) / 2;
}


Public double Multi(double A, int B){
    Return(A * B);
}
Public double Division(int A, double B) {
    Return(A / B);
}


/*
Dùng JUnit    
*/
@Test
public void testSum() {
    double result = Sum(5, 3);
    assertEquals(8, result, 0.01); // Kiểm tra tổng - tham số thứ 3 có thể có or không
}

// Kiểm thử phương thức Average
@Test
public void testAverage() {
    double result = Average(4.5, 3);
    assertEquals(3.75, result, 0.01); // Kiểm tra trung bình
}

// Kiểm thử phương thức Multi
@Test
public void testMulti() {
    double result = Multi(4.0, 2);
    assertEquals(8.0, result, 0.01); // Kiểm tra tích
}

// Kiểm thử phương thức Division
@Test
public void testDivision() {
    double result = Division(10, 2);
    assertEquals(5.0, result, 0.01); // Kiểm tra thương
}