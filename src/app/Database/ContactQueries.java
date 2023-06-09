package app.Database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import app.Controllers.JDBC;
import app.Models.Contacts;

import java.sql.*;
import java.util.Objects;

public class ContactQueries {

    private static final Connection conn = JDBC.getConnection();

    /**
     * Gets contacts observable list.
     *
     * @return the contacts observable list
     */
    public static ObservableList<Contacts> getContactsObservableList() {
        ObservableList<Contacts> contactsObservableList = FXCollections.observableArrayList();
        String ps = "SELECT * FROM contacts";
        try {
            JDBC.makePreparedStatement(ps,conn);
            Objects.requireNonNull(JDBC.getPreparedStatement()).execute();
            ResultSet rs = Objects.requireNonNull(JDBC.getPreparedStatement()).getResultSet();
            Contacts contacts;
            while (rs.next()) {
                contacts = new Contacts(
                        rs.getInt("Contact_ID"),
                        rs.getString("Contact_Name"),
                        rs.getString("Email"));
                contactsObservableList.add(contacts);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactsObservableList;
    }


    /**
     * Get contact id by name integer.
     *
     * @param contactName the contact name
     * @return the integer
     */
    public static Integer getContactIdByName(String contactName) {
        String query = "SELECT * FROM contacts WHERE Contact_Name = ?";

        try {
            JDBC.makePreparedStatement(query, conn);
            Objects.requireNonNull(JDBC.getPreparedStatement()).setString(1,contactName);
            JDBC.getPreparedStatement().execute();
            ResultSet rs = JDBC.getPreparedStatement().getResultSet();
            if(rs.next()){
                Contacts contact = new Contacts(rs.getInt("Contact_ID"));
                return contact.getContactId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
