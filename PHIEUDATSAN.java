package testdethi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class PHIEUDATSAN extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel danhSachPanel, bieuMauPanel;
    private JTable tblPhieuDatSan, tblChiTiet;
    private JButton btnChonTatCa, btnBoChonTatCa, btnXoaMucChon;
    private JButton btnTaoMoi, btnCapNhat, btnXoa, btnNhapMoi, btnFirst, btnPrev, btnNext, btnLast;
    private JTextField txtMaPhieu, txtMaSan, txtThoiGianBD, txtThoiGianKT, txtTrangThai, txtNguoiTao;
    private DefaultTableModel chiTietModel;
    private DefaultTableModel danhSachModel;
    private final String FILE_NAME = "phieudatsan.csv";

    public PHIEUDATSAN() {
        setTitle("Quản lý Phiếu Đặt Sân");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 550);
        setLocationRelativeTo(null);
        initComponents();

        // Lưu dữ liệu khi đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveToFile();
            }
        });

        loadFromFile();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        // === DANH SÁCH ===
        danhSachPanel = new JPanel(new BorderLayout(10, 10));
        danhSachPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tblPhieuDatSan = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblPhieuDatSan);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách phiếu đặt sân"));
        danhSachPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        btnChonTatCa = new JButton("Chọn tất cả");
        btnBoChonTatCa = new JButton("Bỏ chọn tất cả");
        btnXoaMucChon = new JButton("Xóa các mục chọn");
        buttonPanel.add(btnChonTatCa);
        buttonPanel.add(btnBoChonTatCa);
        buttonPanel.add(btnXoaMucChon);
        danhSachPanel.add(buttonPanel, BorderLayout.SOUTH);

        // === BIỂU MẪU ===
        bieuMauPanel = new JPanel(new BorderLayout(10, 10));
        bieuMauPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phiếu"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(new JLabel("Mã phiếu"), gbc);
        gbc.gridx = 1;
        txtMaPhieu = new JTextField(15);
        formPanel.add(txtMaPhieu, gbc);

        gbc.gridx = 2;
        formPanel.add(new JLabel("Mã sân"), gbc);
        gbc.gridx = 3;
        txtMaSan = new JTextField(15);
        formPanel.add(txtMaSan, gbc);
        y++;

        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(new JLabel("Thời gian bắt đầu"), gbc);
        gbc.gridx = 1;
        txtThoiGianBD = new JTextField(15);
        formPanel.add(txtThoiGianBD, gbc);

        gbc.gridx = 2;
        formPanel.add(new JLabel("Thời gian kết thúc"), gbc);
        gbc.gridx = 3;
        txtThoiGianKT = new JTextField(15);
        formPanel.add(txtThoiGianKT, gbc);
        y++;

        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(new JLabel("Trạng thái"), gbc);
        gbc.gridx = 1;
        txtTrangThai = new JTextField("invalid", 15);
        txtTrangThai.setForeground(Color.RED);
        formPanel.add(txtTrangThai, gbc);

        gbc.gridx = 2;
        formPanel.add(new JLabel("Người tạo"), gbc);
        gbc.gridx = 3;
        txtNguoiTao = new JTextField(15);
        formPanel.add(txtNguoiTao, gbc);

        // Bảng chi tiết
        String[] columnNames = {"Đồ uống", "Đơn giá", "Giảm giá", "Số lượng", "Thành tiền"};
        chiTietModel = new DefaultTableModel(columnNames, 0);
        tblChiTiet = new JTable(chiTietModel);
        tblChiTiet.setRowHeight(24);
        tblChiTiet.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane chiTietScrollPane = new JScrollPane(tblChiTiet);
        chiTietScrollPane.setBorder(BorderFactory.createTitledBorder("Chi tiết phiếu"));

        // Nút chức năng
        JPanel buttonBottomPanel = new JPanel();
        btnTaoMoi = new JButton("Tạo mới");
        btnCapNhat = new JButton("Cập nhật");
        btnXoa = new JButton("Xóa");
        btnNhapMoi = new JButton("Nhập mới");
        btnFirst = new JButton("|<");
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        btnLast = new JButton("|>");

        buttonBottomPanel.add(btnTaoMoi);
        buttonBottomPanel.add(btnCapNhat);
        buttonBottomPanel.add(btnXoa);
        buttonBottomPanel.add(btnNhapMoi);
        buttonBottomPanel.add(btnFirst);
        buttonBottomPanel.add(btnPrev);
        buttonBottomPanel.add(btnNext);
        buttonBottomPanel.add(btnLast);

        bieuMauPanel.add(formPanel, BorderLayout.NORTH);
        bieuMauPanel.add(chiTietScrollPane, BorderLayout.CENTER);
        bieuMauPanel.add(buttonBottomPanel, BorderLayout.SOUTH);

        // Tabs
        tabbedPane.addTab("DANH SÁCH", danhSachPanel);
        tabbedPane.addTab("BIỂU MẪU", bieuMauPanel);
        add(tabbedPane);

        initTable();
        addEventHandlers();
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < danhSachModel.getRowCount(); i++) {
                for (int j = 0; j < danhSachModel.getColumnCount(); j++) {
                    bw.write(danhSachModel.getValueAt(i, j).toString());
                    if (j < danhSachModel.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    danhSachModel.addRow(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        danhSachModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã phiếu", "Mã sân", "Thời gian bắt đầu", "Thời gian kết thúc", "Trạng thái", "Người tạo"}
        );
        tblPhieuDatSan.setModel(danhSachModel);
        tblPhieuDatSan.setFont(new Font("Arial", Font.PLAIN, 14));
        tblPhieuDatSan.setRowHeight(24);
        JTableHeader header = tblPhieuDatSan.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void addEventHandlers() {
        btnChonTatCa.addActionListener(e -> tblPhieuDatSan.selectAll());

        btnBoChonTatCa.addActionListener(e -> tblPhieuDatSan.clearSelection());

        btnXoaMucChon.addActionListener(e -> {
            int[] rows = tblPhieuDatSan.getSelectedRows();
            if (rows.length == 0) {
                JOptionPane.showMessageDialog(this, "Không có dòng nào được chọn!");
                return;
            }
            for (int i = rows.length - 1; i >= 0; i--) {
                danhSachModel.removeRow(rows[i]);
            }
            saveToFile();
            JOptionPane.showMessageDialog(this, "Đã xóa các dòng được chọn.");
        });

        btnTaoMoi.addActionListener(e -> {
            txtMaPhieu.setText("");
            txtMaSan.setText("");
            txtThoiGianBD.setText("");
            txtThoiGianKT.setText("");
            txtTrangThai.setText("invalid");
            txtTrangThai.setForeground(Color.RED);
            txtNguoiTao.setText("");
            chiTietModel.setRowCount(0);
        });

        btnNhapMoi.addActionListener(e -> chiTietModel.addRow(new Object[]{"", "", "", "", ""}));

        btnXoa.addActionListener(e -> {
            int row = tblChiTiet.getSelectedRow();
            if (row != -1) {
                chiTietModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
            }
        });

        btnCapNhat.addActionListener(e -> {
            String maPhieu = txtMaPhieu.getText().trim();
            String maSan = txtMaSan.getText().trim();
            String thoiGianBD = txtThoiGianBD.getText().trim();
            String thoiGianKT = txtThoiGianKT.getText().trim();
            String trangThai = txtTrangThai.getText().trim();
            String nguoiTao = txtNguoiTao.getText().trim();

            if (maPhieu.isEmpty() || maSan.isEmpty() || thoiGianBD.isEmpty() || thoiGianKT.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin bắt buộc.");
                return;
            }

            danhSachModel.addRow(new Object[]{maPhieu, maSan, thoiGianBD, thoiGianKT, trangThai, nguoiTao});
            saveToFile();
            JOptionPane.showMessageDialog(this, "Đã cập nhật danh sách.");
        });

        btnFirst.addActionListener(e -> JOptionPane.showMessageDialog(this, "Về đầu (giả lập)"));
        btnPrev.addActionListener(e -> JOptionPane.showMessageDialog(this, "Lùi (giả lập)"));
        btnNext.addActionListener(e -> JOptionPane.showMessageDialog(this, "Tiến (giả lập)"));
        btnLast.addActionListener(e -> JOptionPane.showMessageDialog(this, "Về cuối (giả lập)"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PHIEUDATSAN().setVisible(true));
    }
}