/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import Admin.AdminProfile;
import DbConnection.DbConnection;
import Employee.EmployeeDetails;
import Employee.EmployeeProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.EmpDetails;

/**
 *
 * @author RD
 */
public class Login extends javax.swing.JFrame
{

    private Object jPasswordField1;

    /**
     * Creates new form Login
     */
    public Login()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Email :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField2)))
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
           String email1=jTextField1.getText();
           String pass1=jPasswordField2.getText();
        
        //String module="";
          // String email1=jTextField1.getText();
        //String pass1=jPasswordField1.getText();
        
        String module="", name="", phoneno="";
        
        try
        {
            //Connection con=dbconnection.DbConnection.getConnect();
             Class.forName("com.mysql.jdbc.Driver");
	    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
            PreparedStatement ps=con.prepareStatement("select * from register where email='"+email1+"' and password='"+pass1+"'");
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                module=rs.getString("module");
                
                name=rs.getString("name");
                phoneno=rs.getString("phoneno");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Email and password didnt matched", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        if(module.equals("admin"))
        {
            AdminProfile ap=new AdminProfile();
            ap.setVisible(true);
            setVisible(false);
        }
        else if(module.equals("employee"))
        {
            
            EmpDetails ed=new EmpDetails();
            ed.setEmail(email1);
            ed.setName(name);
            ed.setPhoneno(phoneno);
            
            EmployeeProfile ep=new EmployeeProfile(ed);
            ep.setVisible(true);
            setVisible(false);
        } 
        
       /* try 
        {
            Class.forName("com.mysql.jdbc.Driver");
	    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
            
           
            
            PreparedStatement ps=con.prepareStatement("select * from register where email='"+email1+"' and password='"+pass1+"'");
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                 String module = rs.getString("module");
                if (module.equals("admin"))
                {
                    AdminProfile ap = new AdminProfile();
                    ap.setVisible(true);
                    setVisible(false);
                }
                else if(module.equals("employee"))
                {
                    String name=rs.getString("name");
                    String email=rs.getString("email");
                    String phoneno=rs.getString("phoneno");
                    EmpDetails ed=new EmpDetails();
                    ed.setName(name);
                    ed.setEmail(email);
                    ed.setPhoneno(phoneno);
                    
                    EmployeeProfile ep=new EmployeeProfile(ed);
                     ep.setVisible(true);
                     setVisible(false);
                }
                
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Email and password didnt matched", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        /*if(module.equals("admin"))
        {
            AdminProfile ap=new AdminProfile();
            ap.setVisible(true);
            setVisible(false);
        }
        else if(module.equals("employee"))
        {
            //EmployeeProfile ep=new EmployeeProfile();
            //ep.setEmail(email1);
            //ed.setName(name);
            //ed.setPhno(phno);
            
            EmployeeProfile ep=new EmployeeProfile();
            ep.setVisible(true);
            setVisible(false);
        }
        
        
        /*String email1=jTextField1.getText();
         char[] pass=jPasswordField2.getPassword();
         String pass1=new String();
         
          try (Connection con = DbConnection.getConnect();
                    PreparedStatement ps = con.prepareStatement("select * from register where email='" + email1 + "' and password='" + pass1 + "'");
                    ResultSet rs = ps.executeQuery();
            )

        {
            if (rs.next())
            {
                String module = rs.getString("module");
                if (module.equals("admin"))
                {
                    AdminProfile ap = new AdminProfile();
                    ap.setVisible(true);
                    setVisible(false);
                }
                else if(module.equals("employee"))
                {
                  EmployeeProfile ep=new EmployeeProfile();
                     ep.setVisible(true);
                     setVisible(false);
                            
                }
                 
                
                
            }
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
         
         
         
        /*String email1 = jTextField1.getText();
        String pass = jPasswordField2.getText();
        String pass1;
       

        try (Connection con = DbConnection.getConnect();
                    PreparedStatement ps = con.prepareStatement("select * from register where email='" + email1 + "' and password='" + pass1 + "'");
                    ResultSet rs = ps.executeQuery();
            )

        {
            if (rs.next())
            {
                String module = rs.getString("module");
                if (module.equals("admin"));
                {
                    AdminProfile ap = new AdminProfile();
                    ap.setVisible(true);
                    setVisible(false);
                }
                else  
                {
               
                     EmployeeProfile ep=new EmployeeProfile();
                     ep.setVisible(true);
                     setVisible(false);
                 }
                
                
            }
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }*/
        
        


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
