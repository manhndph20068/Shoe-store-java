/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Iplm;

import DomainModel.MauSac;
import Repository.Iplm.mauSacRespository;
import Services.IMauSacService;
import ViewModels.QuanLyMauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class MauSacServiceIplm implements IMauSacService {

    mauSacRespository msr = new mauSacRespository();

    @Override
    public List<QuanLyMauSac> getAll() {

        List<MauSac> lst = msr.getAll();
        List<QuanLyMauSac> lstQl = new ArrayList<>();

        for (MauSac ql : lst) {
            QuanLyMauSac qlms = new QuanLyMauSac(ql.getId(), ql.getMa(), ql.getTen(), ql.getTrangThai());
            lstQl.add(qlms);
        }

        return lstQl;
    }

    @Override
    public String add(QuanLyMauSac qlms) {
        QuanLyMauSac qlKhachhang = new QuanLyMauSac();
        qlKhachhang = new MauSacServiceIplm().getmakc(qlms.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {
            MauSac ms = new MauSac(null, qlms.getMa(), qlms.getTen(), qlms.getTrangThai());
            boolean add = msr.add(ms);
            if (add == true) {
                return "Thêm thành công";
            } else {
                return "Thêm thất bại";
            }
        }
    }

    @Override
    public String update(QuanLyMauSac qlms, String id) {

        MauSac ms = new MauSac(null, qlms.getMa(), qlms.getTen(), qlms.getTrangThai());
        QuanLyMauSac qlKhachhang = new QuanLyMauSac();
        qlKhachhang = new MauSacServiceIplm().getmakc(qlms.getMa());
        if (qlKhachhang != null) {
            return "Mã trùng yêu cầu nhập lại";
        } else {
            boolean update = msr.update(ms, id);
            if (update == true) {
                return "Sửa thành công";
            } else {
                return "Sửa thất bại";
            }
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = msr.delete(id);
        if (delete == true) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String themNhanh(QuanLyMauSac qlMs) {
        MauSac ms = new MauSac(qlMs.getTen());
        boolean themNhanh = msr.themNhanh(ms);
        if (themNhanh == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public QuanLyMauSac getmakc(String ma) {
        MauSac cv = msr.getmaKc(ma);
        if (cv != null) {
            QuanLyMauSac ql = new QuanLyMauSac();
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
