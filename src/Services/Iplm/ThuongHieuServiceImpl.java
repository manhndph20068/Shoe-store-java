/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.ThuongHieu;
import Repository.Iplm.ThuongHieuRepository;
import Services.IThuongHieuService;
import ViewModels.QuanLyThuongHieu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ThuongHieuServiceImpl implements IThuongHieuService {

    private ThuongHieuRepository rp = new ThuongHieuRepository();

    @Override
    public List<QuanLyThuongHieu> getAll() {

        List<QuanLyThuongHieu> ds = new ArrayList<>();
        List<ThuongHieu> list = rp.getAll();

        for (ThuongHieu cv : list) {
            QuanLyThuongHieu vModel = new QuanLyThuongHieu(cv.getId(), cv.getMa(), cv.getTen(), cv.getTrangThai());
            ds.add(vModel);
        }

        return ds;

    }

    @Override
    public String add(QuanLyThuongHieu t) {
        QuanLyThuongHieu qlKhachhang = new QuanLyThuongHieu();
        qlKhachhang = new ThuongHieuServiceImpl().getmakc(t.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {

            ThuongHieu thuongHieu = new ThuongHieu("", t.getMa(), t.getTen(), t.getTrangThai());
            boolean add = rp.add(thuongHieu);
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
    public String update(QuanLyThuongHieu cv, String id) {

        ThuongHieu thuongHieu = new ThuongHieu("", cv.getMa(), cv.getTen(), cv.getTrangThai());
        QuanLyThuongHieu qlKhachhang = new QuanLyThuongHieu();
        qlKhachhang = new ThuongHieuServiceImpl().getmakc(cv.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {
            boolean add = rp.update(thuongHieu, id);
            if (add == true) {
                return "Sửa thành công";
            } else {
                return " Sửa thất bại ";
            }
        }
    }

    @Override
    public String themNhanh(QuanLyThuongHieu qlTh) {
        ThuongHieu th = new ThuongHieu(qlTh.getTen());
        boolean themNhanh = rp.themNhanh(th);
        if (themNhanh == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public QuanLyThuongHieu getmakc(String ma) {
        ThuongHieu cv = rp.getmaKc(ma);
        if (cv != null) {
            QuanLyThuongHieu ql = new QuanLyThuongHieu();
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
