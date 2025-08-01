import java.util.ArrayList;
import java.util.List;

/**
 * Class quản lý dữ liệu thông tin sân bóng
 * @author MSI GTX 4050
 */
public class SanBongData {
    
    // Class đại diện cho thông tin sân bóng
    public static class ThongTinSan {
        private String maSan;
        private String tenSan;
        private String loaiSan;
        private String diaChi;
        private String giaThue;
        private String trangThai;
        private String thoiGian;
        private String moTa;
        
        public ThongTinSan(String maSan, String tenSan, String loaiSan, String diaChi, 
                          String giaThue, String trangThai, String thoiGian, String moTa) {
            this.maSan = maSan;
            this.tenSan = tenSan;
            this.loaiSan = loaiSan;
            this.diaChi = diaChi;
            this.giaThue = giaThue;
            this.trangThai = trangThai;
            this.thoiGian = thoiGian;
            this.moTa = moTa;
        }
        
        // Getters
        public String getMaSan() { return maSan; }
        public String getTenSan() { return tenSan; }
        public String getLoaiSan() { return loaiSan; }
        public String getDiaChi() { return diaChi; }
        public String getGiaThue() { return giaThue; }
        public String getTrangThai() { return trangThai; }
        public String getThoiGian() { return thoiGian; }
        public String getMoTa() { return moTa; }
        
        // Setters
        public void setMaSan(String maSan) { this.maSan = maSan; }
        public void setTenSan(String tenSan) { this.tenSan = tenSan; }
        public void setLoaiSan(String loaiSan) { this.loaiSan = loaiSan; }
        public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
        public void setGiaThue(String giaThue) { this.giaThue = giaThue; }
        public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
        public void setThoiGian(String thoiGian) { this.thoiGian = thoiGian; }
        public void setMoTa(String moTa) { this.moTa = moTa; }
    }
    
    // Danh sách dữ liệu mẫu
    private static List<ThongTinSan> danhSachSan = new ArrayList<>();
    
    static {
        // Khởi tạo dữ liệu mẫu
        danhSachSan.add(new ThongTinSan("SB001", "Sân A1", "Sân 5 người", "123 Đường ABC, Quận 1", 
                                        "200.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo chất lượng cao"));
        
        danhSachSan.add(new ThongTinSan("SB002", "Sân A2", "Sân 7 người", "456 Đường XYZ, Quận 2", 
                                        "300.000 VNĐ/giờ", "Đã đặt", "06:00 - 22:00", "Sân cỏ tự nhiên, có đèn chiếu sáng"));
        
        danhSachSan.add(new ThongTinSan("SB003", "Sân B1", "Sân 5 người", "789 Đường DEF, Quận 3", 
                                        "180.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo, có mái che"));
        
        danhSachSan.add(new ThongTinSan("SB004", "Sân B2", "Sân 11 người", "321 Đường GHI, Quận 4", 
                                        "500.000 VNĐ/giờ", "Bảo trì", "06:00 - 22:00", "Sân cỏ tự nhiên, sân chính"));
        
        danhSachSan.add(new ThongTinSan("SB005", "Sân C1", "Sân 5 người", "654 Đường JKL, Quận 5", 
                                        "220.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo, có quạt mát"));
        
        danhSachSan.add(new ThongTinSan("SB006", "Sân C2", "Sân 7 người", "987 Đường MNO, Quận 6", 
                                        "280.000 VNĐ/giờ", "Đã đặt", "06:00 - 22:00", "Sân cỏ tự nhiên, có ghế ngồi"));
        
        danhSachSan.add(new ThongTinSan("SB007", "Sân D1", "Sân 5 người", "147 Đường PQR, Quận 7", 
                                        "190.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo, có bãi xe"));
        
        danhSachSan.add(new ThongTinSan("SB008", "Sân D2", "Sân 11 người", "258 Đường STU, Quận 8", 
                                        "450.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ tự nhiên, có khán đài"));
        
        danhSachSan.add(new ThongTinSan("SB009", "Sân E1", "Sân 5 người", "369 Đường VWX, Quận 9", 
                                        "210.000 VNĐ/giờ", "Đã đặt", "06:00 - 22:00", "Sân cỏ nhân tạo, có nhà vệ sinh"));
        
        danhSachSan.add(new ThongTinSan("SB010", "Sân E2", "Sân 7 người", "741 Đường YZA, Quận 10", 
                                        "320.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ tự nhiên, có quán ăn"));
    }
    
    /**
     * Lấy tất cả thông tin sân
     */
    public static List<ThongTinSan> getAllSan() {
        return new ArrayList<>(danhSachSan);
    }
    
    /**
     * Tìm sân theo loại
     */
    public static List<ThongTinSan> timTheoLoai(String loaiSan) {
        List<ThongTinSan> ketQua = new ArrayList<>();
        for (ThongTinSan san : danhSachSan) {
            if (san.getLoaiSan().toLowerCase().contains(loaiSan.toLowerCase())) {
                ketQua.add(san);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm sân theo trạng thái
     */
    public static List<ThongTinSan> timTheoTrangThai(String trangThai) {
        List<ThongTinSan> ketQua = new ArrayList<>();
        for (ThongTinSan san : danhSachSan) {
            if (san.getTrangThai().toLowerCase().contains(trangThai.toLowerCase())) {
                ketQua.add(san);
            }
        }
        return ketQua;
    }
    
    /**
     * Tìm sân theo giá thuê
     */
    public static List<ThongTinSan> timTheoGia(String gia) {
        List<ThongTinSan> ketQua = new ArrayList<>();
        for (ThongTinSan san : danhSachSan) {
            if (san.getGiaThue().toLowerCase().contains(gia.toLowerCase())) {
                ketQua.add(san);
            }
        }
        return ketQua;
    }
    
    /**
     * Thêm sân mới
     */
    public static void themSan(ThongTinSan san) {
        danhSachSan.add(san);
    }
    
    /**
     * Cập nhật thông tin sân
     */
    public static void capNhatSan(String maSan, ThongTinSan sanMoi) {
        for (int i = 0; i < danhSachSan.size(); i++) {
            if (danhSachSan.get(i).getMaSan().equals(maSan)) {
                danhSachSan.set(i, sanMoi);
                break;
            }
        }
    }
    
    /**
     * Xóa sân
     */
    public static void xoaSan(String maSan) {
        danhSachSan.removeIf(san -> san.getMaSan().equals(maSan));
    }
    
    /**
     * Lấy thống kê
     */
    public static String getThongKe() {
        int tongSan = danhSachSan.size();
        int sanTrong = 0;
        int sanDat = 0;
        int sanBaoTri = 0;
        
        for (ThongTinSan san : danhSachSan) {
            switch (san.getTrangThai()) {
                case "Còn trống":
                    sanTrong++;
                    break;
                case "Đã đặt":
                    sanDat++;
                    break;
                case "Bảo trì":
                    sanBaoTri++;
                    break;
            }
        }
        
        return String.format("Tổng số sân: %d | Còn trống: %d | Đã đặt: %d | Bảo trì: %d", 
                           tongSan, sanTrong, sanDat, sanBaoTri);
    }
} 