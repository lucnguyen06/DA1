import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class FROMLOAISAN extends JFrame {
    private JTextField maSanField, loaiSanField, tinhTrangField, giaThanhField, diaChiField;
    private JLabel trangThaiLabel;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JButton btnCheckSan;
    private JTable tableLoaiSan;
    private DefaultTableModel tableModel;
    private LoaiSanDAO loaiSanDAO = LoaiSanDAO.getInstance();

    public FROMLOAISAN() {
        setTitle("Quản lý Loại Sân");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        loadTable();
        addEventHandlers();
    }

    private void initComponents() {
        setLayout(null);
        JLabel lblMaSan = new JLabel("Mã sân:");
        JLabel lblLoaiSan = new JLabel("Loại sân:");
        JLabel lblTinhTrang = new JLabel("Tình trạng:");
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        JLabel lblGiaThanh = new JLabel("Giá thành:");
        JLabel lblDiaChi = new JLabel("Địa chỉ:");

        maSanField = new JTextField();
        loaiSanField = new JTextField();
        tinhTrangField = new JTextField();
        trangThaiLabel = new JLabel();
        giaThanhField = new JTextField();
        diaChiField = new JTextField();

        // btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        btnCheckSan = new JButton("Check sân");

        tableModel = new DefaultTableModel(new Object[]{"Mã sân", "Loại sân", "Tình trạng", "Trạng thái", "Giá thành", "Địa chỉ"}, 0);
        tableLoaiSan = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableLoaiSan);

        // Vị trí các thành phần
        lblMaSan.setBounds(20, 20, 80, 25);
        maSanField.setBounds(100, 20, 200, 25);
        lblLoaiSan.setBounds(20, 60, 80, 25);
        loaiSanField.setBounds(100, 60, 200, 25);
        lblTinhTrang.setBounds(20, 100, 80, 25);
        tinhTrangField.setBounds(100, 100, 200, 25);
        lblTrangThai.setBounds(350, 20, 80, 25);
        trangThaiLabel.setBounds(430, 20, 200, 25);
        lblGiaThanh.setBounds(350, 60, 80, 25);
        giaThanhField.setBounds(430, 60, 200, 25);
        lblDiaChi.setBounds(350, 100, 80, 25);
        diaChiField.setBounds(430, 100, 200, 25);

        btnCheckSan.setBounds(660, 20, 100, 30);
        btnSua.setBounds(660, 60, 100, 30);
        btnXoa.setBounds(660, 100, 100, 30);
        btnLamMoi.setBounds(660, 140, 100, 30);
        // btnCheckSan.setBounds(660, 180, 100, 30);

        scrollPane.setBounds(20, 180, 740, 260);

        add(lblMaSan); add(maSanField);
        add(lblLoaiSan); add(loaiSanField);
        add(lblTinhTrang); add(tinhTrangField);
        add(lblTrangThai); add(trangThaiLabel);
        add(lblGiaThanh); add(giaThanhField);
        add(lblDiaChi); add(diaChiField);
        add(btnCheckSan); add(btnSua); add(btnXoa); add(btnLamMoi);
        add(scrollPane);
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<LoaiSan> ds = loaiSanDAO.getAll();
        for (LoaiSan ls : ds) {
            tableModel.addRow(new Object[]{
                ls.getMaSan(), ls.getLoaiSan(), ls.getTinhTrang(), ls.getTrangThai(), ls.getGiaThanh(), ls.getDiaChi()
            });
        }
    }

    private void addEventHandlers() {
        // btnThem.addActionListener(e -> themLoaiSan());
        btnSua.addActionListener(e -> suaLoaiSan());
        btnXoa.addActionListener(e -> xoaLoaiSan());
        btnLamMoi.addActionListener(e -> clearForm());
        tableLoaiSan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableLoaiSan.getSelectedRow();
                if (row >= 0) {
                    maSanField.setText(tableModel.getValueAt(row, 0).toString());
                    loaiSanField.setText(tableModel.getValueAt(row, 1).toString());
                    tinhTrangField.setText(tableModel.getValueAt(row, 2).toString());
                    trangThaiLabel.setText(tableModel.getValueAt(row, 3).toString());
                    giaThanhField.setText(tableModel.getValueAt(row, 4).toString());
                    diaChiField.setText(tableModel.getValueAt(row, 5).toString());
                }
            }
        });
        btnCheckSan.addActionListener(e -> checkSan());
    }

    private void suaLoaiSan() {
        try {
            String maSan = maSanField.getText();
            String loaiSan = loaiSanField.getText();
            String tinhTrang = tinhTrangField.getText();
            String trangThai = trangThaiLabel.getText();
            double giaThanh = Double.parseDouble(giaThanhField.getText());
            String diaChi = diaChiField.getText();
            if (maSan.isEmpty() || loaiSan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }
            if (loaiSanDAO.findById(maSan) == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sân để sửa!");
                return;
            }
            LoaiSan ls = new LoaiSan(maSan, loaiSan, tinhTrang, trangThai, giaThanh, diaChi, false, false);
            loaiSanDAO.update(ls);
            loadTable();
            clearForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: " + ex.getMessage());
        }
    }

    private void xoaLoaiSan() {
        String maSan = maSanField.getText();
        if (maSan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sân để xóa!");
            return;
        }
        if (loaiSanDAO.findById(maSan) == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã sân để xóa!");
            return;
        }
        loaiSanDAO.delete(maSan);
        loadTable();
        clearForm();
    }

    private void clearForm() {
        maSanField.setText("");
        loaiSanField.setText("");
        tinhTrangField.setText("");
        trangThaiLabel.setText("");
        giaThanhField.setText("");
        diaChiField.setText("");
        tableLoaiSan.clearSelection();
    }

    private void checkSan() {
        String maSan = maSanField.getText();
        if (maSan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sân để kiểm tra!");
            return;
        }
        LoaiSan ls = loaiSanDAO.findById(maSan);
        if (ls == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã sân!");
            trangThaiLabel.setText("");
        } else {
            trangThaiLabel.setText(ls.getTrangThai());
            JOptionPane.showMessageDialog(this, "Trạng thái sân: " + ls.getTrangThai());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FROMLOAISAN().setVisible(true));
    }
} 