package heritage.amcdonald.example15_externaldatabase;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allan on 2015/11/22.
 */
public class Customer {
    private String CustomerID, CompanyName, ContactName, City;

    Customer() {
    }

    Customer(String cid, String coN, String conN, String city) {
        CustomerID = cid;
        CompanyName = coN;
        ContactName = conN;
        City = city;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCustomerID() {return CustomerID;}

    public String getCompanyName() {return CompanyName;}

    public String getContactName() {return ContactName;}

    public String getCity() {return City;}

    public List<Customer> getCustomers() {
        // csdev.cegep-heritage.qc.ca == 206.167.123.5 externally and 192.168.60.2 internally
        String EXTERNAL = "206.167.123.5";
        String INTERNAL = "192.168.60.2";
        String USERNAME = "c50";
        String PASSWORD = "c50";

        Connection conn = null;

        List<Customer> customers = new ArrayList<Customer>();

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver).newInstance();
            String connStr = "jdbc:jtds:sqlserver://" + INTERNAL + ":1433/Northwind;encrypt=false;user=" + USERNAME + ";password=" + PASSWORD + ";";
            conn = DriverManager.getConnection(connStr, USERNAME, PASSWORD);

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select CustomerID, CompanyName, ContactName, City from dbo.Customers");

            while (resultSet.next()) {
                Customer cust = new Customer();
                cust.setCustomerID(resultSet.getString(1));
                cust.setCompanyName(resultSet.getString(2));
                cust.setContactName(resultSet.getString(3));
                cust.setCity(resultSet.getString(4));
                customers.add(cust);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}
