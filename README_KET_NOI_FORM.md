# HỆ THỐNG KẾT NỐI CÁC FORM

## Mô tả
Đây là hệ thống quản lý sân bóng với giao diện kết nối tất cả các form trong thư mục main/java.

## Các Form Được Kết Nối

### 1. Form Chính (MainApplication)
- **File**: `MainApplication.java` và `MainApplication.form`
- **Chức năng**: Form chính để điều hướng đến tất cả các form khác
- **Giao diện**: 12 nút để truy cập các chức năng khác nhau

### 2. Các Form Được Kết Nối

#### Form Đăng Nhập & Đăng Ký
- **fromlogin.java** - Form đăng nhập hệ thống
- **FROMDANGKY.java** - Form đăng ký tài khoản

#### Form Quản Lý Khách Hàng
- **fromkhachhang.java** - Form quản lý thông tin khách hàng
- **khachhang/KH_DS.java** - Form danh sách khách hàng

#### Form Quản Lý Sân Bóng
- **FROMSANBONG.java** - Form quản lý sân bóng
- **FROMQLSB.java** - Form quản lý sân bóng (QLSB)
- **FROMLOAISAN.java** - Form quản lý loại sân
- **FROMTRANGTHAISAN.java** - Form quản lý trạng thái sân

#### Form Đặt Sân & Lịch
- **DATSAN.java** - Form đặt sân
- **LICHDS.java** - Form lịch đặt sân

#### Form Thông Tin
- **khachhang/TTsan.java** - Form thông tin sân

## Cách Sử Dụng

### 1. Chạy Ứng Dụng
```bash
# Biên dịch và chạy MainApplication
javac MainApplication.java
java MainApplication
```

### 2. Điều Hướng
- Mở file `MainApplication.java` trong NetBeans
- Chạy ứng dụng từ form chính
- Sử dụng các nút để mở các form tương ứng

### 3. Cấu Trúc Kết Nối
Mỗi nút trong form chính sẽ mở một form con tương ứng:

```java
// Ví dụ: Mở form đăng nhập
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    fromlogin loginForm = new fromlogin(this, true);
    loginForm.setVisible(true);
}
```

## Các Form Con

### Form Đăng Nhập (fromlogin)
- Chức năng: Xác thực người dùng
- Các trường: Username, Password
- Nút: Đăng nhập, Đăng ký, Kết thúc

### Form Đăng Ký (FROMDANGKY)
- Chức năng: Tạo tài khoản mới
- Các trường: Thông tin cá nhân
- Nút: Đăng ký, Hủy

### Form Quản Lý Khách Hàng (fromkhachhang)
- Chức năng: CRUD khách hàng
- Các trường: Thông tin khách hàng
- Nút: Thêm, Sửa, Xóa, Tìm kiếm

### Form Quản Lý Sân Bóng (FROMSANBONG)
- Chức năng: Quản lý thông tin sân
- Các trường: Tên sân, loại sân, giá
- Nút: Thêm, Sửa, Xóa, Tìm kiếm

### Form Đặt Sân (DATSAN)
- Chức năng: Đặt lịch sân bóng
- Các trường: Khách hàng, sân, thời gian
- Nút: Đặt sân, Hủy

### Form Lịch Đặt Sân (LICHDS)
- Chức năng: Xem lịch đặt sân
- Hiển thị: Danh sách đặt sân
- Nút: Xem, Sửa, Xóa

## Lưu Ý Kỹ Thuật

### 1. Loại Form
Có hai loại form trong hệ thống:

#### JDialog Forms (Modal Dialog)
Các form này có constructor nhận tham số `(parent, modal)`:
```java
// Mở form con với modal = true
FormName form = new FormName(this, true);
form.setVisible(true);
```

**Danh sách JDialog forms:**
- fromlogin.java
- FROMDANGKY.java
- fromkhachhang.java
- FROMSANBONG.java
- DATSAN.java
- LICHDS.java
- FROMQLSB.java
- khachhang/KH_DS.java
- khachhang/TTsan.java

#### JFrame Forms (Independent Windows)
Các form này có constructor không tham số:
```java
// Mở form con độc lập
FormName form = new FormName();
form.setVisible(true);
```

**Danh sách JFrame forms:**
- FROMLOAISAN.java
- FROMTRANGTHAISAN.java

### 2. Parent Window
Form chính (MainApplication) là parent window cho tất cả form con.

### 3. Event Handling
Mỗi nút có event handler riêng để mở form tương ứng.

### 4. Layout
- Form chính sử dụng GridBagLayout
- Background màu xanh (#3399FF)
- Font Segoe UI cho các nút

## Cấu Trúc Thư Mục
```
main/java/
├── MainApplication.java          # Form chính
├── MainApplication.form         # File form chính
├── fromlogin.java              # Form đăng nhập
├── FROMDANGKY.java             # Form đăng ký
├── fromkhachhang.java          # Form quản lý khách hàng
├── FROMSANBONG.java            # Form quản lý sân bóng
├── FROMLOAISAN.java            # Form quản lý loại sân
├── FROMTRANGTHAISAN.java       # Form quản lý trạng thái sân
├── DATSAN.java                 # Form đặt sân
├── LICHDS.java                 # Form lịch đặt sân
├── FROMQLSB.java               # Form QLSB
├── SanBongData.java            # Class quản lý dữ liệu sân bóng
├── DemoSanBongData.java        # File demo test dữ liệu
├── khachhang/
│   ├── KH_DS.java              # Form danh sách khách hàng
│   ├── TTsan.java              # Form thông tin sân (đã cập nhật với dữ liệu)
│   └── SanBongData.java        # Class dữ liệu sân bóng (package khachhang)
├── README_KET_NOI_FORM.md      # File hướng dẫn kết nối form
└── README_DU_LIEU_SAN_BONG.md # File hướng dẫn dữ liệu sân bóng
```

## Hướng Dẫn Phát Triển

### Thêm Form Mới
1. Tạo form mới trong NetBeans
2. Thêm nút vào MainApplication
3. Tạo event handler cho nút mới
4. Cập nhật file form của MainApplication

### Sửa Đổi Kết Nối
1. Mở MainApplication.java
2. Tìm event handler tương ứng
3. Sửa đổi code mở form
4. Lưu và test lại

## Troubleshooting

### Lỗi Thường Gặp
1. **Form không mở**: Kiểm tra tên class và constructor
2. **Lỗi biên dịch**: Kiểm tra import và package
3. **Form không hiển thị**: Kiểm tra setVisible(true)
4. **Constructor error**: Kiểm tra loại form (JDialog vs JFrame)

### Lỗi Constructor Đã Sửa
**Lỗi:** `constructor FROMLOAISAN in class FROMLOAISAN cannot be applied to given types`

**Nguyên nhân:** Các form JFrame (FROMLOAISAN, FROMTRANGTHAISAN) có constructor không tham số, nhưng code đang cố gắng truyền tham số.

**Giải pháp:** Sửa event handler trong MainApplication.java:
```java
// Trước (sai):
FROMLOAISAN loaiSanForm = new FROMLOAISAN(this, true);

// Sau (đúng):
FROMLOAISAN loaiSanForm = new FROMLOAISAN();
```

### Debug
- Sử dụng System.out.println() để debug
- Kiểm tra console output
- Xem log lỗi trong NetBeans

## Kết Luận
Hệ thống này cung cấp một giao diện thống nhất để truy cập tất cả các chức năng của ứng dụng quản lý sân bóng. Mỗi form được thiết kế độc lập nhưng được kết nối thông qua form chính MainApplication. 