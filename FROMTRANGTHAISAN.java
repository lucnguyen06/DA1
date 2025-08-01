import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class FROMTRANGTHAISAN extends JFrame {
    private JComboBox<String> comboMaSan;
    private JLabel lblTrangThai;
    private JLabel lblHinhAnh;
    private LoaiSanDAO loaiSanDAO = LoaiSanDAO.getInstance();
    private JButton btnSan1, btnSan2, btnSan3, btnSan4, btnSan5, btnSan6, btnSan7, btnSan8, btnSan9, btnSan10;
    private JButton btnCheckSanTrong;

    public FROMTRANGTHAISAN() {
        setTitle("Trạng Thái Sân");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        loadComboBox();
        addEventHandlers();
    }

    private void initComponents() {
        setLayout(null);
        JLabel lblChonSan = new JLabel("Chọn mã sân:");
        comboMaSan = new JComboBox<>();
        lblTrangThai = new JLabel("Trạng thái: ");
        lblTrangThai.setFont(new Font("Arial", Font.BOLD, 16));
        lblHinhAnh = new JLabel();
        lblHinhAnh.setBounds(150, 140, 200, 150);
        lblHinhAnh.setHorizontalAlignment(JLabel.CENTER);

        btnSan1 = new JButton("Sân 1");
        btnSan2 = new JButton("Sân 2");
        btnSan3 = new JButton("Sân 3");
        btnSan4 = new JButton("Sân 4");
        btnSan5 = new JButton("Sân 5");
        btnSan6 = new JButton("Sân 6");
        btnSan7 = new JButton("Sân 7");
        btnSan8 = new JButton("Sân 8");
        btnSan9 = new JButton("Sân 9");
        btnSan10 = new JButton("Sân 10");
        btnCheckSanTrong = new JButton("Kiểm tra sân trống");

        btnSan1.setBounds(30, 100, 80, 30);
        btnSan2.setBounds(120, 100, 80, 30);
        btnSan3.setBounds(210, 100, 80, 30);
        btnSan4.setBounds(300, 100, 80, 30);
        btnSan5.setBounds(390, 100, 80, 30);
        btnSan6.setBounds(30, 140, 80, 30);
        btnSan7.setBounds(120, 140, 80, 30);
        btnSan8.setBounds(210, 140, 80, 30);
        btnSan9.setBounds(300, 140, 80, 30);
        btnSan10.setBounds(390, 140, 80, 30);
        btnCheckSanTrong.setBounds(150, 320, 200, 30);

        lblChonSan.setBounds(30, 30, 100, 30);
        comboMaSan.setBounds(140, 30, 200, 30);
        lblTrangThai.setBounds(30, 70, 400, 30);

        add(lblChonSan);
        add(comboMaSan);
        add(lblTrangThai);
        add(lblHinhAnh);
        add(btnSan1);
        add(btnSan2);
        add(btnSan3);
        add(btnSan4);
        add(btnSan5);
        add(btnSan6);
        add(btnSan7);
        add(btnSan8);
        add(btnSan9);
        add(btnSan10);
        add(btnCheckSanTrong);
    }

    private void loadComboBox() {
        comboMaSan.removeAllItems();
        List<LoaiSan> ds = loaiSanDAO.getAll();
        // Demo: nếu chưa có dữ liệu, thêm mẫu
        if (ds.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                String ma = String.format("S%03d", i);
                String ten = "Sân " + i;
                String tinhTrang = (i % 2 == 0) ? "Tốt" : "Bình thường";
                String trangThai = (i % 3 == 0) ? "Bảo trì" : "Hoạt động";
                double gia = 200000 + i * 50000;
                String diaChi = "Địa chỉ " + i;
                boolean daDat = (i == 2 || i == 5);
                boolean daCoc = (i == 4 || i == 7);
                loaiSanDAO.add(new LoaiSan(ma, ten, tinhTrang, trangThai, gia, diaChi, daDat, daCoc));
            }
            ds = loaiSanDAO.getAll();
        }
        for (LoaiSan ls : ds) {
            comboMaSan.addItem(ls.getMaSan());
        }
        if (comboMaSan.getItemCount() > 0) {
            comboMaSan.setSelectedIndex(0);
            updateTrangThaiAndImage();
        }
    }

    private void addEventHandlers() {
        comboMaSan.addActionListener(e -> updateTrangThaiAndImage());
        btnSan1.addActionListener(e -> selectSanByMa("S001"));
        btnSan2.addActionListener(e -> selectSanByMa("S002"));
        btnSan3.addActionListener(e -> selectSanByMa("S003"));
        btnSan4.addActionListener(e -> selectSanByMa("S004"));
        btnSan5.addActionListener(e -> selectSanByMa("S005"));
        btnSan6.addActionListener(e -> selectSanByMa("S006"));
        btnSan7.addActionListener(e -> selectSanByMa("S007"));
        btnSan8.addActionListener(e -> selectSanByMa("S008"));
        btnSan9.addActionListener(e -> selectSanByMa("S009"));
        btnSan10.addActionListener(e -> selectSanByMa("S010"));
        btnCheckSanTrong.addActionListener(e -> showSanTrong());
    }

    private void selectSanByMa(String maSan) {
        for (int i = 0; i < comboMaSan.getItemCount(); i++) {
            if (comboMaSan.getItemAt(i).equals(maSan)) {
                comboMaSan.setSelectedIndex(i);
                break;
            }
        }
    }

    private void updateTrangThaiAndImage() {
        String maSan = (String) comboMaSan.getSelectedItem();
        if (maSan == null) return;
        LoaiSan ls = loaiSanDAO.findById(maSan);
        if (ls == null) return;
        if (ls.isDaDuocDatCoc()) {
            lblTrangThai.setText("Trạng thái: Đã được đặt cọc");
            lblTrangThai.setForeground(new Color(255, 140, 0)); // màu cam
        } else if (ls.isDaDuocDat()) {
            lblTrangThai.setText("Trạng thái: Đã được đặt");
            lblTrangThai.setForeground(Color.RED);
        } else {
            lblTrangThai.setText("Trạng thái: Còn trống");
            lblTrangThai.setForeground(new Color(0, 128, 0));
        }
        // Hiển thị hình ảnh
        ImageIcon icon = new ImageIcon("icon/kich-thuoc-san-bong-da.jpg");
        Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        lblHinhAnh.setIcon(new ImageIcon(img));
    }

    private void showSanTrong() {
        List<LoaiSan> ds = loaiSanDAO.getAll();
        StringBuilder sb = new StringBuilder();
        for (LoaiSan ls : ds) {
            if (!ls.isDaDuocDat() && !ls.isDaDuocDatCoc()) {
                sb.append(ls.getMaSan()).append(" - ").append(ls.getLoaiSan()).append("\n");
            }
        }
        if (sb.length() == 0) {
            sb.append("Không có sân nào còn trống!");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Danh sách sân còn trống", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FROMTRANGTHAISAN().setVisible(true));
    }
} 