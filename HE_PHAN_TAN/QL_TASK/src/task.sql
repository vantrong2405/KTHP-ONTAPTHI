CREATE DATABASE test_db;
USE test_db;  -- Chọn cơ sở dữ liệu test_db



CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    due_date DATE,
    user_id INT,
    category_id INT,
    status VARCHAR(20) DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO users (username, password, full_name, email)
VALUES 
('nguyen_van_a', 'matkhau123', 'Nguyễn Văn A', 'nguyen.van.a@example.com'),
('le_thi_b', 'matkhau456', 'Lê Thị B', 'le.thi.b@example.com'),
('tran_quang_c', 'matkhau789', 'Trần Quang C', 'tran.quang.c@example.com'),
('pham_thi_d', 'matkhau012', 'Phạm Thị D', 'pham.thi.d@example.com'),
('hoang_van_e', 'matkhau345', 'Hoàng Văn E', 'hoang.van.e@example.com'),
('doan_thi_f', 'matkhau678', 'Đoàn Thị F', 'doan.thi.f@example.com');

INSERT INTO categories (name, description)
VALUES 
('Lập trình', 'Các công việc liên quan đến lập trình phần mềm'),
('Thiết kế', 'Các công việc liên quan đến thiết kế đồ họa, giao diện người dùng'),
('Marketing', 'Các công việc liên quan đến tiếp thị và quảng bá sản phẩm'),
('Nghiên cứu', 'Các công việc liên quan đến nghiên cứu khoa học và phát triển công nghệ'),
('Quản lý dự án', 'Các công việc liên quan đến quản lý dự án và kế hoạch công việc'),
('Kinh doanh', 'Các công việc liên quan đến phát triển và quản lý bán hàng, khách hàng'),
('Hỗ trợ kỹ thuật', 'Các công việc liên quan đến hỗ trợ kỹ thuật và chăm sóc khách hàng');


INSERT INTO tasks (name, description, due_date, user_id, category_id, status)
VALUES 
-- Công việc lập trình
('Phát triển chức năng đăng nhập', 'Công việc liên quan đến việc phát triển chức năng đăng nhập cho hệ thống quản lý công việc', '2024-12-31', 1, 1, 'In Progress'),
('Tạo cơ sở dữ liệu cho ứng dụng', 'Thiết kế và tạo các bảng cơ sở dữ liệu cho ứng dụng quản lý công việc', '2024-12-28', 2, 1, 'Pending'),

-- Công việc thiết kế
('Thiết kế giao diện trang chủ', 'Thiết kế giao diện người dùng cho trang chủ của ứng dụng', '2024-12-25', 3, 2, 'Pending'),
('Thiết kế biểu tượng ứng dụng', 'Thiết kế biểu tượng (icon) cho ứng dụng', '2024-12-27', 4, 2, 'In Progress'),

-- Công việc marketing
('Lập kế hoạch chiến lược SEO', 'Lập kế hoạch chiến lược SEO cho website công ty', '2024-12-20', 5, 3, 'Pending'),
('Chạy quảng cáo trên Facebook', 'Quản lý chiến dịch quảng cáo trên Facebook cho sản phẩm mới', '2024-12-18', 6, 3, 'Completed'),

-- Công việc nghiên cứu
('Nghiên cứu thị trường', 'Phân tích thị trường và đối thủ cạnh tranh trong lĩnh vực công nghệ', '2025-01-10', 1, 4, 'Pending'),
('Nghiên cứu công nghệ AI', 'Nghiên cứu các xu hướng mới trong công nghệ trí tuệ nhân tạo (AI)', '2025-01-15', 2, 4, 'In Progress'),

-- Công việc quản lý dự án
('Lập kế hoạch dự án phát triển ứng dụng', 'Tạo kế hoạch chi tiết và timeline cho dự án phát triển ứng dụng mới', '2024-12-30', 3, 5, 'In Progress'),
('Giám sát tiến độ dự án', 'Theo dõi tiến độ và tình trạng công việc của nhóm phát triển', '2025-01-05', 4, 5, 'Pending'),

-- Công việc kinh doanh
('Phân tích nhu cầu khách hàng', 'Phân tích nhu cầu và yêu cầu từ khách hàng để phát triển sản phẩm', '2025-01-10', 5, 6, 'Completed'),
('Tổ chức sự kiện giới thiệu sản phẩm', 'Lập kế hoạch và tổ chức sự kiện để giới thiệu sản phẩm mới ra thị trường', '2024-12-20', 6, 6, 'Pending'),

-- Công việc hỗ trợ kỹ thuật
('Xử lý sự cố ứng dụng', 'Hỗ trợ người dùng trong việc xử lý sự cố và lỗi trong ứng dụng', '2025-01-05', 1, 7, 'In Progress'),
('Cung cấp tài liệu hướng dẫn sử dụng', 'Tạo tài liệu hướng dẫn sử dụng cho người dùng cuối', '2024-12-25', 2, 7, 'Completed');




-- Xóa all DB 
TRUNCATE TABLE users;

-- Xóa toàn bộ dữ liệu trong bảng categories
TRUNCATE TABLE categories;

-- Xóa toàn bộ dữ liệu trong bảng tasks
TRUNCATE TABLE tasks;


