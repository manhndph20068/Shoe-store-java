/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.DongSanPham;
import Repository.Iplm.DongSanPhamRepository;
import ViewModels.QuanLyDongSanPham;
import java.util.ArrayList;
import java.util.List;
import Services.IDongSanPhamService;

/**
 *
 * @author admin
 */
public class DongSanPhamImpl implements IDongSanPhamService {

    private DongSanPhamRepository rp = new DongSanPhamRepository();

    @Override
    public List<QuanLyDongSanPham> getAll() {

        List<QuanLyDongSanPham> ds = new ArrayList<>();
        List<DongSanPham> list = rp.getAll();

        for (DongSanPham cv : list) {
            QuanLyDongSanPham vModel = new QuanLyDongSanPham(cv.getId(), cv.getMa(), cv.getTen(), cv.getTrangThai());
            ds.add(vModel);
        }

        return ds;

    }

    @Override
    public String add(QuanLyDongSanPham t) {
        QuanLyDongSanPham qlKhachhang = new QuanLyDongSanPham();
        qlKhachhang = new DongSanPhamImpl().getmakc(t.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {

            DongSanPham kichCo = new DongSanPham("", t.getMa(), t.getTen(), t.getTrangThai());
            boolean add = rp.add(kichCo);
            if (add == true) {
                return "thêm thành công";
            } else {
                return " thêm thất bại ";
            }
        }
    }

    @Override
    public String delete(String id) {
        boolean add = rp.delete(id);
        if (add == true) {
            return "xóa thành công";
        } else {
            return "xóa thất bại ";
        }
    }

    @Override
    public String update(QuanLyDongSanPham cv, String id) {

        DongSanPham kichCo = new DongSanPham("", cv.getMa(), cv.getTen(), cv.getTrangThai());
        QuanLyDongSanPham qlKhachhang = new QuanLyDongSanPham();
        qlKhachhang = new DongSanPhamImpl().getmakc(cv.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {
            boolean add = rp.update(kichCo, id);
            if (add == true) {
                return "sửa thành công";
            } else {
                return "sửa thất bại ";
            }
        }
    }

    @Override
    public String themNhanh(QuanLyDongSanPham qlDsp) {
        DongSanPham dsp = new DongSanPham(qlDsp.getTen());
        boolean themNhanh = rp.themNhanh(dsp);
        if (themNhanh == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public QuanLyDongSanPham getmakc(String ma) {
        DongSanPham cv = rp.getmaKc(ma);
        if (cv != null) {
            QuanLyDongSanPham ql = new QuanLyDongSanPham();
            ql.setId(cv.getId());
            ql.setMa(cv.getMa());
            ql.setTen(cv.getTen());
            ql.setTrangThai(cv.getTrangThai());

            return ql;
        } else {
            return null;
        }
    }

}
