/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbookingsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven Aherne
 */
public class trips extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form trips
     */
    private ArrayList<Integer> ids = new ArrayList<>();
    private ArrayList<Integer> fromcityIds = new ArrayList<>();
    private ArrayList<Integer> tocityIds = new ArrayList<>();
    private ArrayList<Integer> planeIds = new ArrayList<>();

    private DefaultTableModel model;

    @SuppressWarnings("unchecked")
	public trips() {
        try {
            initComponents();
            update.setEnabled(false);
            delete.setEnabled(false);
            model = new DefaultTableModel();
            table.setModel(model);
            Object[] column = {"Sr.", "Trip name", "From City", "TO City", "Departure Date", "Departure Time", "Aeroplane Model", "Notes", "Ticket Price"};
            model.setColumnIdentifiers(column);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            loadTable();
            ResultSet rs = databaseConnection.retriveQuery("Select `cityName`,`cityId` from cities;");
            while (rs.next()) {
                this.fromCity.addItem(rs.getString(1));
                this.toCity.addItem(rs.getString(1));
                this.fromcityIds.add(rs.getInt(2));
                this.tocityIds.add(rs.getInt(2));
            }

            rs = databaseConnection.retriveQuery("select `aeroplaneId`,`Model` from aeroPlane");
            while (rs.next()) {
                this.planeIds.add(rs.getInt(1));
                this.planeId.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(aeroPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clear() {
        this.add.setEnabled(true);
        this.update.setEnabled(false);
        this.delete.setEnabled(false);
        this.fromCity.setSelectedIndex(0);
        this.toCity.setSelectedIndex(0);
        this.planeId.setSelectedIndex(0);
        this.notes.setText("");
        this.ticketPrice.setText("");
        this.error.setText("");
        this.id.setText("Auto Generated");
        this.tripName.setText("");
        this.departureDate.setText("");
        this.departureTime.setText("");
    }

    private void loadTable() {
        try {
            ResultSet rs = databaseConnection.retriveQuery("select * from trips;");
            model.setRowCount(0);
            Object[] row = new Object[9];
            int count = 1;
            //Object[] column = {"Sr.", "Trip name", "From City", "TO City", "Departure Date", "Departure Time", "Aeroplane Model", "Notes", "Ticket Price"};
            ids.removeAll(ids);
            while (rs.next()) {
                ids.add(rs.getInt(1));
                row[0] = count++;
                row[1] = rs.getString(2);

                ResultSet rs1 = databaseConnection.retriveQuery("Select `cityName`,`cityId` from cities where `cityId`=" + rs.getString(3) + "; ");
                if (rs1.next()) {
                    row[2] = rs1.getString(1);
                }
                rs1 = databaseConnection.retriveQuery("Select `cityName`,`cityId` from cities where `cityId`=" + rs.getString(4) + "; ");
                if (rs1.next()) {
                    row[3] = rs1.getString(1);
                }

                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                rs1 = databaseConnection.retriveQuery("select `aeroplaneId`,`Model` from aeroPlane where `aeroplaneId`=" + rs.getString(7) + "; ");
                if (rs1.next()) {
                    row[6] = rs1.getString(1);
                }

                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pilot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validData() {
        if (this.ticketPrice.getText().equals("")) {
            error.setText("ticket Price Can't be Null");
            return false;
        } else if (this.notes.getText().equals("")) {
            error.setText("Notes Can't be Null");
            return false;
        } else if (this.tripName.getText().equals("")) {
            error.setText("Trip Name Can't be Null");
            return false;
        } else if (this.departureDate.getText().equals("")) {
            error.setText("Departure Date Can't be Null");
            return false;
        } else if (this.departureTime.getText().equals("")) {
            error.setText("Departure Time Can't be Null");
            return false;
        } else if (this.fromCity.getSelectedIndex() < 0) {
            error.setText("Select From City");
        } else if (this.toCity.getSelectedIndex() < 0) {
            error.setText("Select To City");
        } else if (this.planeId.getSelectedIndex() < 0) {
            error.setText("Select Poilet");
        } else {
            error.setText("");
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("rawtypes")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        notes = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        modellabel = new javax.swing.JLabel();
        ticketPrice = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        id1 = new javax.swing.JLabel();
        fromCity = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        toCity = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        planeId = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        departureTime = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        departureDate = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tripName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Trip Data Modification");

        jLabel4.setText("Notes");

        notes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        error.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setText("Clear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        modellabel.setText("Ticket Price");

        ticketPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketPriceActionPerformed(evt);
            }
        });

        id.setText("ID ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "DOB"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        id1.setText("ID :");

        fromCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromCityActionPerformed(evt);
            }
        });

        jLabel3.setText("From City");

        jLabel5.setText("To city :");

        jLabel6.setText("AeroPlane");

        departureTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("h:mm a"))));
        departureTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        departureTime.setToolTipText("h:mm a");

        jLabel8.setText("Deperture Time");

        departureDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        departureDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        departureDate.setToolTipText("YYYY-MM-DD");

        jLabel9.setText("Departure Date");

        tripName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripNameActionPerformed(evt);
            }
        });

        jLabel7.setText("Trip Name");

        jButton2.setText("Back");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modellabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ticketPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(departureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fromCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(toCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(planeId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(44, 44, 44)
                                .addComponent(tripName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(212, 212, 212))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(delete)
                    .addComponent(update))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tripName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromCity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toCity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planeId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modellabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notesActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
////INSERT INTO `flight_booking_system`.`trips` (`tripName`, `fromCity`, `toCity`, `departureDate`, `departureTIme`, `planeId`, `notes`, `ticketPrice`) VALUES ('Test1', '1', '3', '2019-01-01', '12:12', '1', 'asd', '123');
//(String tripName, String fromCity, String toCity, String departureDate, String departureTime, String PlaneID, String notes, String ticketPrice)
        if (add.isEnabled() == true) {
            if (validData()) {

                if (databaseConnection.addNewTrip(tripName.getText(), this.fromcityIds.get(this.fromCity.getSelectedIndex()) + "", this.tocityIds.get(this.toCity.getSelectedIndex()) + "", this.departureDate.getText(), this.departureTime.getText(), this.planeIds.get(this.planeId.getSelectedIndex()) + "", this.notes.getText(), this.ticketPrice.getText())) {

                    JOptionPane.showMessageDialog(null, "Data Added");
                    loadTable();
                    clear();
                } else {
                    JOptionPane.showConfirmDialog(null, "Error While adding data ");
                }
            }
        }
    }//GEN-LAST:event_addMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        if (this.delete.isEnabled()) {
            if (databaseConnection.update_Delete_Query("DELETE FROM `flight_booking_system`.`trips` WHERE (`tripId` = '" + this.id.getText().trim() + "');")) {
                JOptionPane.showMessageDialog(null, "DataDeleted");
                this.loadTable();
                this.clear();
            } else {
                JOptionPane.showMessageDialog(null, "Error While Deleting Data");
            }
        }
    }//GEN-LAST:event_deleteMouseClicked
//UPDATE `flight_booking_system`.`trips` SET `tripName` = 'TESTTT2', `fromCity` = '3', `departureDate` = '2018-01-01', `departureTIme` = '12:11 PM', `planeId` = '2', `notes` = 'TESTTt', `ticketPrice` = '1233' WHERE (`tripId` = '4');

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        if (this.update.isEnabled()) {
            if (this.validData()) {
                if (databaseConnection.update_Delete_Query("UPDATE `flight_booking_system`.`trips` SET `tripName` = '" + this.tripName.getText() + "', `toCity` = '" + this.tocityIds.get(this.toCity.getSelectedIndex()) + "',`fromCity` = '" + this.fromcityIds.get(this.fromCity.getSelectedIndex()) + "', `departureDate` = '" + this.departureDate.getText() + "', `departureTIme` = '" + this.departureTime.getText() + "', `planeId` = '" + this.planeIds.get(this.planeId.getSelectedIndex()) + "', `notes` = '" + this.notes.getText() + "', `ticketPrice` = '" + this.ticketPrice.getText() + "' WHERE (`tripId` = '" + this.id.getText() + "');")) {
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    this.loadTable();
                    this.clear();
                } else {
                    JOptionPane.showMessageDialog(null, "Error While Updating data");
                }
            }
        }
    }//GEN-LAST:event_updateMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        clear();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ticketPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketPriceActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (table.getSelectedRow() >= 0) {
            //Object[] column = {"Sr.", "Trip name", "From City", "TO City", "Departure Date", "Departure Time", "Aeroplane Model", "Notes", "Ticket Price"};
            String data = table.getValueAt(table.getSelectedRow(), 1).toString();

            this.tripName.setText(data);
            data = table.getValueAt(table.getSelectedRow(), 2).toString();
            this.fromCity.setSelectedItem(data.trim());
            data = table.getValueAt(table.getSelectedRow(), 3).toString();
            this.toCity.setSelectedItem(data.trim());
            data = table.getValueAt(table.getSelectedRow(), 4).toString();
            this.departureDate.setText(data);
            data = table.getValueAt(table.getSelectedRow(), 5).toString();
            this.departureTime.setText(data);
            data = table.getValueAt(table.getSelectedRow(), 6).toString();
            this.planeId.setSelectedItem(data.trim());
            data = table.getValueAt(table.getSelectedRow(), 7).toString();
            this.notes.setText(data);
            data = table.getValueAt(table.getSelectedRow(), 8).toString();
            this.ticketPrice.setText(data);

            this.notes.setText(data);
            id.setText("" + this.ids.get(table.getSelectedRow()));

            add.setEnabled(false);
            update.setEnabled(true);
            delete.setEnabled(true);
            //            error.setText("hhh " + data);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void fromCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromCityActionPerformed

    private void tripNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tripNameActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(trips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trips().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JFormattedTextField departureDate;
    private javax.swing.JFormattedTextField departureTime;
    private javax.swing.JLabel error;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox fromCity;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modellabel;
    private javax.swing.JTextField notes;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox planeId;
    private javax.swing.JTable table;
    private javax.swing.JTextField ticketPrice;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox toCity;
    private javax.swing.JTextField tripName;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
