/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import ViewModels.DongSPRResponse;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IDongSPRRepository {
    ArrayList<DongSPRResponse> getAll();
}
