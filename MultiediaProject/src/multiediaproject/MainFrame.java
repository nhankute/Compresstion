/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author nhan-kute
 */
public class MainFrame extends javax.swing.JFrame {
    private Image img;
    private String input_text;
    private String output_text;
    private String IMAGE_VIEW;
    private File[] AfterCompress;
    private File TextFileChooser;
    private String convert = "";
    
    public MainFrame() {
        img =  null;
        input_text = "";
        output_text = "";
        IMAGE_VIEW = "Selec a TEXT or an IMAGE";
        TextFileChooser = null;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btSelecImg = new javax.swing.JButton();
        btCompression = new javax.swing.JButton();
        btSelecText = new javax.swing.JButton();
        btDecompress = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("URW Palladio L", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Compares image compression levels");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        btSelecImg.setText("Selec Image");
        btSelecImg.setAlignmentX(15.0F);
        btSelecImg.setMaximumSize(new java.awt.Dimension(72, 32));
        btSelecImg.setMinimumSize(new java.awt.Dimension(72, 32));
        btSelecImg.setPreferredSize(new java.awt.Dimension(72, 32));
        btSelecImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelecImgMouseClicked(evt);
            }
        });

        btCompression.setText("Compression");
        btCompression.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btCompressionMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCompressionMouseClicked(evt);
            }
        });

        btSelecText.setText("Selec Text File");
        btSelecText.setAlignmentX(15.0F);
        btSelecText.setMaximumSize(new java.awt.Dimension(72, 32));
        btSelecText.setMinimumSize(new java.awt.Dimension(72, 32));
        btSelecText.setPreferredSize(new java.awt.Dimension(72, 32));
        btSelecText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelecTextMouseClicked(evt);
            }
        });

        btDecompress.setText("Decompress");
        btDecompress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDecompressMouseClicked(evt);
            }
        });

        btRefresh.setBackground(new java.awt.Color(242, 241, 240));
        btRefresh.setIcon(new javax.swing.ImageIcon(new ImageIcon(getClass().getResource("/res/ic_refresh.png")).getImage().getScaledInstance(40, 38, java.awt.Image.SCALE_SMOOTH))
        );
        btRefresh.setBorder(null);
        btRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btRefresh.setPreferredSize(new java.awt.Dimension(42, 42));
        btRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btSelecText, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btSelecImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCompression, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btDecompress, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSelecImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCompression, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDecompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbImg.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        lbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImg.setText(this.IMAGE_VIEW);
        lbImg.setToolTipText("");
        lbImg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbImgMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lbImg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelecImgMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg","png");
        chooser.addChoosableFileFilter(filter);
        
        int result = chooser.showOpenDialog(null);
        
        if(result == JFileChooser.OPEN_DIALOG){
            File file_selected = chooser.getSelectedFile();
            String mimetype= new MimetypesFileTypeMap().getContentType(file_selected);
            String type = mimetype.split("/")[0];
            if(type.equals("image")){   
                System.out.println("And you got an image");             
                String path = file_selected.getAbsolutePath();
                this.IMAGE_VIEW = "You have image now";
                ImageIcon myimage = new ImageIcon(path);
                img = myimage.getImage();
                lbImg.setIcon(new ImageIcon(img));
            }
            else {
                System.out.println("It's NOT an image");
                final JDialog dialog = new AndroidLikeToast(MainFrame.this, true, "Please choose an image of type \"*.jpg\" or \"*.png\"");
                Timer timer = new Timer(AndroidLikeToast.LENGTH_SHORT, new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
 
                dialog.setVisible(true);
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file selec");
        }
    }//GEN-LAST:event_btSelecImgMouseClicked

    private void lbImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImgMouseClicked
        if (this.IMAGE_VIEW.substring(0, 14).equals("Ready to compr")){// compress text
                try {//get text from file to String input_text
                    Scanner sc = new Scanner(this.TextFileChooser);
                    boolean loop = sc.hasNextLine();
                    while (loop) {
                      this.input_text += sc.nextLine();
                      if(sc.hasNext()){
                          this.input_text += "\n";
                      }else loop = false;
                    }
                    sc.close();
                  } catch(IOException e) {
                    System.out.println(e);
                  }
                //start compress
                ResultCompressTextFrame Compress = null;
            try {
                Compress = new ResultCompressTextFrame(this.input_text, this.TextFileChooser.getName(), (int) this.TextFileChooser.length());
                this.convert = Compress.GetToConvert();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
                this.lbImg.setText("Done");
                Compress.setVisible(true);//show compress
                this.img = null;
                this.input_text = "";
                this.lbImg.setText(this.IMAGE_VIEW);
        }
        else if (img == null){//choose file
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg","png");
            chooser.addChoosableFileFilter(filter);

            int result = chooser.showOpenDialog(null);

            if(result == JFileChooser.OPEN_DIALOG){
                File file_selected = chooser.getSelectedFile();
                String mimetype= new MimetypesFileTypeMap().getContentType(file_selected);
                String type = mimetype.split("/")[0];
                if(type.equals("image")){   
                    System.out.println("And you got an image");             
                    String path = file_selected.getAbsolutePath();
                    ImageIcon myimage = new ImageIcon(path);
                    img = myimage.getImage();
                    lbImg.setIcon(new ImageIcon(img));
                }
                else if(type.equals("text")){ 
                    System.out.println("And you got a text");
                    String path = file_selected.getAbsolutePath();
                    this.IMAGE_VIEW = "Ready to compress text file: " + file_selected.getName();
                    this.TextFileChooser = file_selected;
                    this.lbImg.setText(this.IMAGE_VIEW);
                    this.img = null;
                }
                else {
                    System.out.println("It's NOT an IMAGE or TEXT");
                    final JDialog dialog = new AndroidLikeToast(MainFrame.this, true, "Please choose a file of type \"*.jpg\", \"*.png\" or \"*.txt\"");
                    Timer timer = new Timer(AndroidLikeToast.LENGTH_SHORT, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.setVisible(false);
                            dialog.dispose();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                    dialog.setVisible(true);
                }
            }
            else if(result == JFileChooser.CANCEL_OPTION) {
                System.out.println("No file selec");
                this.lbImg.setText(this.IMAGE_VIEW);
            }
        }
        else{//show image
            ViewImageFrame imgview = new ViewImageFrame(img);
            imgview.setVisible(true);
        }
    }//GEN-LAST:event_lbImgMouseClicked

    private void btCompressionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCompressionMouseClicked
        if (this.IMAGE_VIEW.substring(0, 14).equals("Ready to compr")){// compress text
                try {//get text from file to String input_text
                    Scanner sc = new Scanner(this.TextFileChooser);
                    boolean loop = sc.hasNextLine();
                    while (loop) {  
                      this.input_text += sc.nextLine();
                      if(sc.hasNext()){
                          this.input_text += "\n";
                      }else loop = false;
                    }
                    sc.close();
                  } catch(IOException e) {
                    System.out.println(e);
                  }
                //start compress
                ResultCompressTextFrame Compress = null;
                try {
                    Compress = new ResultCompressTextFrame(this.input_text, this.TextFileChooser.getName(), (int) this.TextFileChooser.length());
                    this.convert = Compress.GetToConvert();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.lbImg.setText("Done");
                Compress.setVisible(true);//show compress
                this.img = null;
                this.input_text = "";
                this.lbImg.setText(this.IMAGE_VIEW);
        }
        else if (img == null){//choose file
            final JDialog dialog = new AndroidLikeToast(MainFrame.this, true, "Sir, Please choose some image first");
                Timer timer = new Timer(AndroidLikeToast.LENGTH_SHORT, new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
 
                dialog.setVisible(true);
        }
        else{//compress image
            BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.BITMASK);
            Graphics bg = bi.getGraphics();
            bg.drawImage(img, 0, 0, null);
            bg.dispose();
            
            LosslessCompressionAlgorithms firstCompress = new LosslessCompressionAlgorithms(bi);
            //firstCompress.Compress();
            
            try {
                File f = new File("first.png");
                ImageIO.write(firstCompress.Compress(), "PNG", f);
                System.out.println(String.valueOf(f.length()/2048));
                JOptionPane.showMessageDialog(MainFrame.this, String.valueOf(f.length()/2048000) + "Mb", "New Size",JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
    }//GEN-LAST:event_btCompressionMouseClicked

    private void btSelecTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelecTextMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Text", "txt");
        chooser.addChoosableFileFilter(filter);
        
        int result = chooser.showOpenDialog(null);
        
        if(result == JFileChooser.OPEN_DIALOG){
            if(img != null){
                img = null;
                this.lbImg.setIcon(null);
            }
                
            File file_selected = chooser.getSelectedFile();
            String mimetype= new MimetypesFileTypeMap().getContentType(file_selected);
            String type = mimetype.split("/")[0];
            if(type.equals("text")){ 
                System.out.println("And you got a text");
                String path = file_selected.getAbsolutePath();
                this.IMAGE_VIEW = "Ready to compress text file: " + file_selected.getName();
                this.TextFileChooser = file_selected;
                this.lbImg.setText(this.IMAGE_VIEW);
            }
            else {
                System.out.println("It's NOT a text");
                final JDialog dialog = new AndroidLikeToast(MainFrame.this, true, "Please choose a text of type \"*.txt\"");
                Timer timer = new Timer(AndroidLikeToast.LENGTH_SHORT, new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
 
                dialog.setVisible(true);
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file selec");
        }
    }//GEN-LAST:event_btSelecTextMouseClicked

    private void btDecompressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDecompressMouseClicked
        this.lbImg.setText(this.IMAGE_VIEW);
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.bin","txt");
        chooser.addChoosableFileFilter(filter);
        
        int result = chooser.showOpenDialog(null);
        
        if(result == JFileChooser.OPEN_DIALOG){
            File file_selected = chooser.getSelectedFile();
            String mimetype= new MimetypesFileTypeMap().getContentType(file_selected);
            String type = mimetype.split("/")[0];
            
            if(type.equals("text")){//get text file 
                System.out.println("And you got a text");
                String path = file_selected.getAbsolutePath();
                
                //
                /*
                try {
                    FileInputStream inputFile = new FileInputStream(path);
                    int content;
			while ((content = inputFile.read()) != -1) {
				// convert to char and display it
				this.input_text += String.valueOf((char)content);
			}
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } 
                */              
                //
                try {
                    Scanner sc = new Scanner(file_selected);
                    while (sc.hasNextLine()) {
                        this.input_text += sc.nextLine();
                        if(sc.hasNextLine())
                            this.input_text += "\n";
                    }
                    sc.close();
                  } catch(IOException e) {
                    System.out.println(e);
                  }
                
                //strart to decompress
                Decompress decode = new Decompress(this.input_text);
                if(decode.toString() != "Sir, we can't decode this file"){
                    File output;
                    FileOutputStream fos;
                    String NewName = decode.getType() + "_Decode_" + file_selected.getName().substring(0,file_selected.getName().length() - 4) + ".txt";
                    byte[] data = decode.toString().getBytes();
                    System.out.println("\nDecode :" + decode.toString());
                    output = new File(NewName);
                    try {
                        fos = new FileOutputStream(output);
                        fos.write(data);
                        fos.flush();
                        fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    this.IMAGE_VIEW = "Decode " + decode.getType();
                    this.TextFileChooser = file_selected;
                    this.lbImg.setText(this.IMAGE_VIEW + " Success!!");
                }
                else{
                    //this.IMAGE_VIEW = decode.toString();
                    this.lbImg.setText(decode.toString());
                }
            }
            else {//Choo file again
                System.out.println("It's NOT a text");
                final JDialog dialog = new AndroidLikeToast(MainFrame.this, true, "Please choose a text of type \"*.txt\"");
                Timer timer = new Timer(AndroidLikeToast.LENGTH_SHORT, new ActionListener() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
 
                dialog.setVisible(true);
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION) {//Not choose anything
            System.out.println("No file selec");
        }
        this.input_text = "";
        this.img = null;
    }//GEN-LAST:event_btDecompressMouseClicked

    private void btRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRefreshMouseClicked
        IMAGE_VIEW = "Selec a TEXT or an IMAGE";
        this.lbImg.setText(this.IMAGE_VIEW);
        img = null;
        input_text = "";
        TextFileChooser = null;
        this.lbImg.setIcon(null);
    }//GEN-LAST:event_btRefreshMouseClicked

    private void lbImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImgMousePressed
        this.lbImg.setText("Processing !!!");
    }//GEN-LAST:event_lbImgMousePressed

    private void btCompressionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCompressionMousePressed
        this.lbImg.setText("Processing !!!");
    }//GEN-LAST:event_btCompressionMousePressed

    public static boolean hasNonWordCharacter(String s) {
        char[] a = s.toCharArray();
        for (char c : a) {
            if (!Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompression;
    private javax.swing.JButton btDecompress;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btSelecImg;
    private javax.swing.JButton btSelecText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImg;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
