public class LoaiSan {
    private String maSan;
    private String loaiSan;
    private String tinhTrang;
    private String trangThai;
    private double giaThanh;
    private String diaChi;
    private boolean daDuocDat;
    private boolean daDuocDatCoc;

    public LoaiSan() {
    }

    public LoaiSan(String maSan, String loaiSan, String tinhTrang, String trangThai, double giaThanh, String diaChi, boolean daDuocDat, boolean daDuocDatCoc) {
        this.maSan = maSan;
        this.loaiSan = loaiSan;
        this.tinhTrang = tinhTrang;
        this.trangThai = trangThai;
        this.giaThanh = giaThanh;
        this.diaChi = diaChi;
        this.daDuocDat = daDuocDat;
        this.daDuocDatCoc = daDuocDatCoc;
    }

    public String getMaSan() {
        return maSan;
    }

    public void setMaSan(String maSan) {
        this.maSan = maSan;
    }

    public String getLoaiSan() {
        return loaiSan;
    }

    public void setLoaiSan(String loaiSan) {
        this.loaiSan = loaiSan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isDaDuocDat() {
        return daDuocDat;
    }

    public void setDaDuocDat(boolean daDuocDat) {
        this.daDuocDat = daDuocDat;
    }

    public boolean isDaDuocDatCoc() {
        return daDuocDatCoc;
    }

    public void setDaDuocDatCoc(boolean daDuocDatCoc) {
        this.daDuocDatCoc = daDuocDatCoc;
    }

    @Override
    public String toString() {
        return "LoaiSan{" +
                "maSan='" + maSan + '\'' +
                ", loaiSan='" + loaiSan + '\'' +
                ", tinhTrang='" + tinhTrang + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", giaThanh=" + giaThanh +
                ", diaChi='" + diaChi + '\'' +
                ", daDuocDat=" + daDuocDat +
                ", daDuocDatCoc=" + daDuocDatCoc +
                '}';
    }
} 