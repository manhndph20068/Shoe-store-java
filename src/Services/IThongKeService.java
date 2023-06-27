/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QuanLyThongKe;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IThongKeService {

    List<QuanLyThongKe> getAll();

    List<QuanLyThongKe> getHangHuy();

    List<QuanLyThongKe> getTongTien();

    List<QuanLyThongKe> getDanhMuc(String ten);

    List<QuanLyThongKe> getNgayTaoHoaDon(String ngayBatDau, String ngayKetThuc);
}
