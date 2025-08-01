# DỮ LIỆU THÔNG TIN SÂN BÓNG

## Mô tả
Hệ thống quản lý dữ liệu thông tin sân bóng với 10 sân mẫu và các chức năng tìm kiếm, thống kê.

## Cấu Trúc Dữ Liệu

### Class ThongTinSan
```java
public static class ThongTinSan {
    private String maSan;        // Mã sân (VD: SB001)
    private String tenSan;       // Tên sân (VD: Sân A1)
    private String loaiSan;      // Loại sân (VD: Sân 5 người)
    private String diaChi;       // Địa chỉ sân
    private String giaThue;      // Giá thuê (VD: 200.000 VNĐ/giờ)
    private String trangThai;    // Trạng thái (Còn trống/Đã đặt/Bảo trì)
    private String thoiGian;     // Thời gian hoạt động
    private String moTa;         // Mô tả chi tiết
}
```

## Dữ Liệu Mẫu

### Danh Sách 10 Sân Bóng

| Mã Sân | Tên Sân | Loại Sân | Địa Chỉ | Giá Thuê | Trạng Thái | Thời Gian | Mô Tả |
|--------|---------|----------|---------|----------|------------|-----------|-------|
| SB001 | Sân A1 | Sân 5 người | 123 Đường ABC, Quận 1 | 200.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ nhân tạo chất lượng cao |
| SB002 | Sân A2 | Sân 7 người | 456 Đường XYZ, Quận 2 | 300.000 VNĐ/giờ | Đã đặt | 06:00 - 22:00 | Sân cỏ tự nhiên, có đèn chiếu sáng |
| SB003 | Sân B1 | Sân 5 người | 789 Đường DEF, Quận 3 | 180.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ nhân tạo, có mái che |
| SB004 | Sân B2 | Sân 11 người | 321 Đường GHI, Quận 4 | 500.000 VNĐ/giờ | Bảo trì | 06:00 - 22:00 | Sân cỏ tự nhiên, sân chính |
| SB005 | Sân C1 | Sân 5 người | 654 Đường JKL, Quận 5 | 220.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ nhân tạo, có quạt mát |
| SB006 | Sân C2 | Sân 7 người | 987 Đường MNO, Quận 6 | 280.000 VNĐ/giờ | Đã đặt | 06:00 - 22:00 | Sân cỏ tự nhiên, có ghế ngồi |
| SB007 | Sân D1 | Sân 5 người | 147 Đường PQR, Quận 7 | 190.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ nhân tạo, có bãi xe |
| SB008 | Sân D2 | Sân 11 người | 258 Đường STU, Quận 8 | 450.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ tự nhiên, có khán đài |
| SB009 | Sân E1 | Sân 5 người | 369 Đường VWX, Quận 9 | 210.000 VNĐ/giờ | Đã đặt | 06:00 - 22:00 | Sân cỏ nhân tạo, có nhà vệ sinh |
| SB010 | Sân E2 | Sân 7 người | 741 Đường YZA, Quận 10 | 320.000 VNĐ/giờ | Còn trống | 06:00 - 22:00 | Sân cỏ tự nhiên, có quán ăn |

## Các Chức Năng

### 1. Lấy Tất Cả Sân
```java
import khachhang.SanBongData;
List<SanBongData.ThongTinSan> allSan = SanBongData.getAllSan();
```

### 2. Tìm Kiếm Theo Loại Sân
```java
List<SanBongData.ThongTinSan> san5Nguoi = SanBongData.timTheoLoai("5 người");
List<SanBongData.ThongTinSan> san7Nguoi = SanBongData.timTheoLoai("7 người");
```

### 3. Tìm Kiếm Theo Trạng Thái
```java
List<SanBongData.ThongTinSan> sanTrong = SanBongData.timTheoTrangThai("Còn trống");
List<SanBongData.ThongTinSan> sanDat = SanBongData.timTheoTrangThai("Đã đặt");
List<SanBongData.ThongTinSan> sanBaoTri = SanBongData.timTheoTrangThai("Bảo trì");
```

### 4. Tìm Kiếm Theo Giá Thuê
```java
List<SanBongData.ThongTinSan> san200k = SanBongData.timTheoGia("200.000");
List<SanBongData.ThongTinSan> san300k = SanBongData.timTheoGia("300.000");
```

### 5. Thêm Sân Mới
```java
SanBongData.ThongTinSan sanMoi = new SanBongData.ThongTinSan(
    "SB011", "Sân F1", "Sân 7 người", "159 Đường ABC, Quận 11",
    "350.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo mới"
);
SanBongData.themSan(sanMoi);
```

### 6. Cập Nhật Sân
```java
SanBongData.ThongTinSan sanCapNhat = new SanBongData.ThongTinSan(
    "SB001", "Sân A1", "Sân 5 người", "123 Đường ABC, Quận 1",
    "250.000 VNĐ/giờ", "Đã đặt", "06:00 - 22:00", "Sân cỏ nhân tạo chất lượng cao"
);
SanBongData.capNhatSan("SB001", sanCapNhat);
```

### 7. Xóa Sân
```java
SanBongData.xoaSan("SB001");
```

### 8. Thống Kê
```java
String thongKe = SanBongData.getThongKe();
// Kết quả: "Tổng số sân: 10 | Còn trống: 6 | Đã đặt: 3 | Bảo trì: 1"
```

## Sử Dụng Trong Form

### Form TTsan (Thông Tin Sân)
Form này đã được cập nhật để sử dụng dữ liệu thực tế:

1. **Load dữ liệu**: Tự động load tất cả sân khi mở form
2. **Tìm theo loại sân**: Nhập loại sân cần tìm
3. **Tìm theo thời gian**: Nhập thời gian cần tìm
4. **Tìm theo giá thuê**: Nhập giá cần tìm
5. **Tìm theo trạng thái**: Nhập trạng thái cần tìm
6. **Làm mới**: Load lại tất cả dữ liệu

### Cách Sử Dụng Form
1. Mở `MainApplication.java`
2. Click nút "THÔNG TIN SÂN"
3. Form sẽ hiển thị bảng với dữ liệu thực tế
4. Sử dụng các nút để tìm kiếm theo tiêu chí khác nhau

## Demo

### Chạy Demo
```bash
javac DemoSanBongData.java
java DemoSanBongData
```

### Kết Quả Demo
Demo sẽ hiển thị:
1. Tất cả sân bóng
2. Sân 5 người
3. Sân còn trống
4. Sân có giá 200.000 VNĐ
5. Thống kê tổng quan
6. Thêm sân mới
7. Thống kê sau khi thêm

## Thống Kê Dữ Liệu

### Phân Bố Theo Loại Sân
- **Sân 5 người**: 5 sân
- **Sân 7 người**: 3 sân  
- **Sân 11 người**: 2 sân

### Phân Bố Theo Trạng Thái
- **Còn trống**: 6 sân
- **Đã đặt**: 3 sân
- **Bảo trì**: 1 sân

### Phân Bố Theo Giá
- **180.000 - 200.000 VNĐ**: 3 sân
- **210.000 - 300.000 VNĐ**: 4 sân
- **320.000 - 500.000 VNĐ**: 3 sân

## Lưu Ý Kỹ Thuật

### 1. Dữ Liệu Tĩnh
- Dữ liệu được lưu trong memory (ArrayList)
- Không persistent (mất khi tắt ứng dụng)
- Có thể mở rộng để lưu vào database

### 2. Tìm Kiếm
- Tìm kiếm không phân biệt hoa thường
- Sử dụng contains() để tìm kiếm linh hoạt
- Có thể mở rộng thêm các tiêu chí tìm kiếm

### 3. Mở Rộng
- Thêm validation cho dữ liệu
- Kết nối database
- Thêm chức năng export/import
- Thêm chức năng backup/restore

## Kết Luận
Hệ thống dữ liệu sân bóng cung cấp 10 sân mẫu với đầy đủ thông tin và các chức năng tìm kiếm, thống kê cơ bản. Dữ liệu được tích hợp vào form TTsan để hiển thị và tương tác với người dùng. 