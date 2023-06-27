/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Iplm;

import DomainModel.DongSanPham;
import Repository.IDongSanPham;
import Utilities.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DongSanPhamRepository implements IDongSanPham {

    @Override
    public List<DongSanPham> getAll() {

        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[DongSP]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<DongSanPham> listChiTietSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSanPham qlCt = new DongSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listChiTietSP.add(qlCt);
            }
            return listChiTietSP;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    @Override
    public boolean add(DongSanPham t) {
        String query = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, t.getMa());
            ps.setObject(2, t.getTen());
            ps.setObject(3, t.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[DongSP]\n"
                + "      WHERE id = ? ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(DongSanPham cv, String id) {
        String query = "UPDATE [dbo].[DongSP]\n"
                + "     SET [Ma] = ?   "
                + "       ,[Ten] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.setObject(3, cv.getTrangThai());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    @Override
    public boolean themNhanh(DongSanPham dsp) {
        String query = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([Ten])\n"
                + "     VALUES(?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, dsp.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public DongSanPham getmaKc(String ma) {
         String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[DongSP] where Ma = ? ";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSanPham qlCt = new DongSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return qlCt;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
