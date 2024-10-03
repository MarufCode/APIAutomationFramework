package org.example.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.fillo.Connection;




public class FillowUtil {

     static String FILE_NAME = "src/test/resources/TestData (2).xlsx";

    public static String fetchDataFromXLSX(String sheetName,String id, String fieldName) throws FilloException {
        String value = null;
        Fillo fillo = new Fillo();
        Connection connection =  fillo.getConnection(FILE_NAME);
        String query = "Select * from " + sheetName + " " + "where ID='" + id + "'";

        Recordset recordset = connection.executeQuery(query);
        while(recordset.next()){
            value = recordset.getField(fieldName);
        }
        recordset.close();
        connection.close();
        return value;


    }

}
