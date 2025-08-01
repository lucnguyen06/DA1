import java.util.ArrayList;
import java.util.List;

public class LoaiSanDAO {
    private static LoaiSanDAO instance;
    private List<LoaiSan> danhSach = new ArrayList<>();

    private LoaiSanDAO() {}

    public static LoaiSanDAO getInstance() {
        if (instance == null) {
            instance = new LoaiSanDAO();
        }
        return instance;
    }

    public List<LoaiSan> getAll() {
        return danhSach;
    }

    public void add(LoaiSan loaiSan) {
        danhSach.add(loaiSan);
    }

    public void update(LoaiSan loaiSan) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSan().equals(loaiSan.getMaSan())) {
                danhSach.set(i, loaiSan);
                return;
            }
        }
    }

    public void delete(String maSan) {
        danhSach.removeIf(ls -> ls.getMaSan().equals(maSan));
    }

    public LoaiSan findById(String maSan) {
        for (LoaiSan ls : danhSach) {
            if (ls.getMaSan().equals(maSan)) {
                return ls;
            }
        }
        return null;
    }
} 