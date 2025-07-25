package testdethi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class KHACHHANG extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtMaKH, txtTenKH, txtMaSan, txtLoaiSan, txtMaPhieu;
    private final String FILE_NAME = "khachhang.csv";

    public KHACHHANG() {
        setTitle("Quản lý Khách Hàng");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // === Tab DANH SÁCH ===
        JPanel danhSachPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"Mã KH", "Tên KH", "Mã sân", "Loại sân", "Mã phiếu"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        danhSachPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel danhSachButtons = new JPanel();
        JButton btnChonTatCa = new JButton("Chọn tất cả");
        JButton btnBoChonTatCa = new JButton("Bỏ chọn tất cả");
        JButton btnXoaDaChon = new JButton("Xoá các mục đã chọn");
        danhSachButtons.add(btnChonTatCa);
        danhSachButtons.add(btnBoChonTatCa);
        danhSachButtons.add(btnXoaDaChon);
        danhSachPanel.add(danhSachButtons, BorderLayout.SOUTH);

        // === Tab BIỂU MẪU ===
        JPanel bieuMauPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        txtMaKH = new JTextField();
        txtTenKH = new JTextField();
        txtMaSan = new JTextField();
        txtLoaiSan = new JTextField();
        txtMaPhieu = new JTextField();

        formPanel.add(new JLabel("Mã khách hàng"));
        formPanel.add(txtMaKH);
        formPanel.add(new JLabel("Tên khách hàng"));
        formPanel.add(txtTenKH);
        formPanel.add(new JLabel("Mã sân"));
        formPanel.add(txtMaSan);
        formPanel.add(new JLabel("Loại sân"));
        formPanel.add(txtLoaiSan);
        formPanel.add(new JLabel("Mã phiếu"));
        formPanel.add(txtMaPhieu);

        bieuMauPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnCapNhat = new JButton("Cập nhật");
        JButton btnXoa = new JButton("Xoá");
        JButton btnMoi = new JButton("Mới");
        buttonPanel.add(btnCapNhat);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnMoi);
        bieuMauPanel.add(buttonPanel, BorderLayout.SOUTH);

        // === Sự kiện nút ===
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] row = new String[]{
                    txtMaKH.getText(),
                    txtTenKH.getText(),
                    txtMaSan.getText(),
                    txtLoaiSan.getText(),
                    txtMaPhieu.getText()
                };
                tableModel.addRow(row);
                saveToFile();
                JOptionPane.showMessageDialog(KHACHHANG.this, "Đã thêm khách hàng vào danh sách!");
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                    saveToFile();
                } else {
                    JOptionPane.showMessageDialog(KHACHHANG.this, "Vui lòng chọn dòng cần xoá.");
                }
            }
        });

        btnMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtMaSan.setText("");
                txtLoaiSan.setText("");
                txtMaPhieu.setText("");
            }
        });

        btnChonTatCa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.selectAll();
            }
        });

        btnBoChonTatCa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
            }
        });

        btnXoaDaChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(KHACHHANG.this, "Không có mục nào được chọn.");
                    return;
                }
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    tableModel.removeRow(selectedRows[i]);
                }
                saveToFile();
            }
        });

        tabbedPane.addTab("DANH SÁCH", danhSachPanel);
        tabbedPane.addTab("BIỂU MẪU", bieuMauPanel);

        add(tabbedPane);

        loadFromFile();
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    bw.write(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
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
                if (data.length == 5) {
                    tableModel.addRow(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KHACHHANG().setVisible(true));
    }
}
