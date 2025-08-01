import khachhang.SanBongData;

/**
 * Demo để test dữ liệu sân bóng
 * @author MSI GTX 4050
 */
public class DemoSanBongData {
    
    public static void main(String[] args) {
        System.out.println("=== DEMO DỮ LIỆU SÂN BÓNG ===\n");
        
        // Hiển thị tất cả sân
        System.out.println("1. TẤT CẢ SÂN BÓNG:");
        System.out.println("=".repeat(80));
        for (SanBongData.ThongTinSan san : SanBongData.getAllSan()) {
            System.out.printf("Mã: %s | Tên: %s | Loại: %s | Giá: %s | Trạng thái: %s\n",
                san.getMaSan(), san.getTenSan(), san.getLoaiSan(), 
                san.getGiaThue(), san.getTrangThai());
        }
        
        // Tìm theo loại sân
        System.out.println("\n2. TÌM SÂN 5 NGƯỜI:");
        System.out.println("=".repeat(80));
        for (SanBongData.ThongTinSan san : SanBongData.timTheoLoai("5 người")) {
            System.out.printf("Mã: %s | Tên: %s | Loại: %s | Giá: %s | Trạng thái: %s\n",
                san.getMaSan(), san.getTenSan(), san.getLoaiSan(), 
                san.getGiaThue(), san.getTrangThai());
        }
        
        // Tìm theo trạng thái
        System.out.println("\n3. SÂN CÒN TRỐNG:");
        System.out.println("=".repeat(80));
        for (SanBongData.ThongTinSan san : SanBongData.timTheoTrangThai("Còn trống")) {
            System.out.printf("Mã: %s | Tên: %s | Loại: %s | Giá: %s | Địa chỉ: %s\n",
                san.getMaSan(), san.getTenSan(), san.getLoaiSan(), 
                san.getGiaThue(), san.getDiaChi());
        }
        
        // Tìm theo giá
        System.out.println("\n4. SÂN CÓ GIÁ 200.000 VNĐ:");
        System.out.println("=".repeat(80));
        for (SanBongData.ThongTinSan san : SanBongData.timTheoGia("200.000")) {
            System.out.printf("Mã: %s | Tên: %s | Loại: %s | Giá: %s | Trạng thái: %s\n",
                san.getMaSan(), san.getTenSan(), san.getLoaiSan(), 
                san.getGiaThue(), san.getTrangThai());
        }
        
        // Thống kê
        System.out.println("\n5. THỐNG KÊ:");
        System.out.println("=".repeat(80));
        System.out.println(SanBongData.getThongKe());
        
        // Thêm sân mới
        System.out.println("\n6. THÊM SÂN MỚI:");
        System.out.println("=".repeat(80));
        SanBongData.ThongTinSan sanMoi = new SanBongData.ThongTinSan(
            "SB011", "Sân F1", "Sân 7 người", "159 Đường ABC, Quận 11",
            "350.000 VNĐ/giờ", "Còn trống", "06:00 - 22:00", "Sân cỏ nhân tạo mới"
        );
        SanBongData.themSan(sanMoi);
        System.out.println("Đã thêm sân mới: " + sanMoi.getTenSan());
        
        // Hiển thị lại thống kê
        System.out.println("\n7. THỐNG KÊ SAU KHI THÊM:");
        System.out.println("=".repeat(80));
        System.out.println(SanBongData.getThongKe());
        
        System.out.println("\n=== KẾT THÚC DEMO ===");
    }
} 