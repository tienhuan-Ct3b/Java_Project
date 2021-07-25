/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIOCSV;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Objects.HoaDonBanHang;
import Objects.HoaDonNhapHang;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FileIOHoaDon {
    
    private static final String currentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private String StrHoaDonBanHang = currentDir + separator + "data" + separator + "HoaDonBanHang.csv";
    private String StrHoaDonNhapHang = currentDir + separator + "data" + separator + "HoaDonNhapHang.csv";
    public File FileHoaDonBanHang = new File(StrHoaDonBanHang);
    public File FileHoaDonNhapHang = new File(StrHoaDonNhapHang);

    public void BanHangWriteToCSV(File f, HoaDonBanHang hdbh) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            CSVWriter csvWriter = new CSVWriter(fw,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] header = {"Ma Hoa Don", "Ngay Lap", "San Pham", "Giam Gia", "Tong Tien"};
            csvWriter.writeNext(header);
            csvWriter.writeNext(new String[]{
                hdbh.getMaHoaDon(),
                String.valueOf(hdbh.getNgayLap()),
                hdbh.getMaSanPham(),
                String.valueOf(hdbh.getGiamGia()),
                String.valueOf(hdbh.getThanhTien())});
        } catch (IOException ex) {
            Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<HoaDonBanHang> BanHangReadCSV(File f) {
        List<HoaDonBanHang> list = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            CsvToBean<HoaDonBanHang> csvToBean = new CsvToBeanBuilder<HoaDonBanHang>(fr)
                    .withType(HoaDonBanHang.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            list = csvToBean.parse();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public void NhapHangWriteToCSV(HoaDonNhapHang hdnh, File f) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            CSVWriter csvWriter = new CSVWriter(fw,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] header = {"STT", "Ma Hoa Don", "Ngay Lap", "San Pham", "Nha San Xuat", "Tong Tien"};
            csvWriter.writeNext(header);
            
                csvWriter.writeNext(new String[]{
                    hdnh.getMaHoaDon(),
                    String.valueOf(hdnh.getNgayLap()),
                    hdnh.getMaSanPham(),
                    String.valueOf(hdnh.getNhaSanXuat()),
                    String.valueOf(hdnh.getThanhTien())});
            

        } catch (IOException ex) {
            Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<HoaDonNhapHang> NhapHangReadCSV(File f) {
        List<HoaDonNhapHang> list = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            CsvToBean<HoaDonNhapHang> csvToBean = new CsvToBeanBuilder<HoaDonNhapHang>(fr)
                    .withType(HoaDonNhapHang.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            list = csvToBean.parse();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(FileIOHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
