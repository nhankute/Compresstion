package multiediaproject;

import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.StringJoiner;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ResultCompressTextFrame extends javax.swing.JFrame {
    private static final String DELIMITER = "#";
    private String file_name;
    private String file_size;
    private String input_text;
    
    private String percentage_Shannon = "";
    private String percentage_Huffman = "";
    private String percentage_RLC = "";
    private String percentage_LZW = "0";
    
    private Integer original_size;
    private String shannon_size;
    private String huffman_size;
    private String RLC_size;
    private String LZW_size;
    
    public ResultCompressTextFrame(String input_text, String file_name, int file_size) throws IOException {
        this.input_text = input_text;
        this.file_name = file_name;
        if(file_size < 1000){
            this.file_size = String.valueOf(file_size) + "bytes";
        } else if(file_size >= 1000 && file_size < 1000000){
            this.file_size = String.valueOf((double)file_size/1000.0) + "Kb";
        } else if(file_size >= 1000000){
            this.file_size = String.valueOf((double)file_size/1000000.0) + "Mb";
        }
        this.original_size = file_size;
        Compress(this.input_text, this.file_name);
        initComponents();
        RankColor();
    }
    
    private void RankColor(){
        if(this.percentage_Huffman != "")
        if(Double.parseDouble(this.percentage_Huffman) >= 90){
            this.pgb_Huffman.setForeground(Color.RED);
        }else if(Double.parseDouble(this.percentage_Huffman) > 55 && Double.parseDouble(this.percentage_Huffman) < 90){
            this.pgb_Huffman.setForeground(Color.ORANGE);
        }else{
            this.pgb_Huffman.setForeground(Color.GREEN);
        }
        
        if(this.percentage_LZW != "")
        if(Double.parseDouble(this.percentage_LZW) >= 90){
            this.pgb_LZW.setForeground(Color.RED);
        }else if(Double.parseDouble(this.percentage_LZW) > 55 && Double.parseDouble(this.percentage_LZW) < 90){
            this.pgb_LZW.setForeground(Color.ORANGE);
        }else{
            this.pgb_LZW.setForeground(Color.GREEN);
        }
        
        if(this.percentage_Shannon != "")
        if(Double.parseDouble(this.percentage_Shannon) >= 90){
            this.pgb_Shannon.setForeground(Color.RED);
        }else if(Double.parseDouble(this.percentage_Shannon) > 55 && Double.parseDouble(this.percentage_Shannon) < 90){
            this.pgb_Shannon.setForeground(Color.ORANGE);
        }else{
            this.pgb_Shannon.setForeground(Color.GREEN);
        }
        
        if(this.percentage_RLC != "")
        if(Double.parseDouble(this.percentage_RLC) >= 90){
            this.pgb_RLC.setForeground(Color.RED);
            
        }else if(Double.parseDouble(this.percentage_RLC) > 55 && Double.parseDouble(this.percentage_RLC) < 90){
            this.pgb_RLC.setForeground(Color.ORANGE);
        }else{
            this.pgb_RLC.setForeground(Color.GREEN);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pgb_RLC = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pgb_Shannon = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pgb_Huffman = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pgb_LZW = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(85, 78, 71));
        setPreferredSize(new java.awt.Dimension(836, 306));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(168, 165, 165));

        jPanel4.setBackground(new java.awt.Color(227, 224, 224));
        jPanel4.setForeground(new java.awt.Color(3, 3, 3));

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel2.setText("  " + file_name);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(file_size);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(227, 224, 224));
        jPanel1.setForeground(new java.awt.Color(3, 3, 3));

        jLabel1.setBackground(new java.awt.Color(227, 224, 224));
        jLabel1.setFont(new java.awt.Font("URW Palladio L", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 3, 3));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Result");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(168, 165, 165));
        jPanel2.setForeground(new java.awt.Color(3, 3, 3));

        jPanel5.setBackground(new java.awt.Color(227, 224, 224));
        jPanel5.setForeground(new java.awt.Color(3, 3, 3));

        jLabel4.setText("  Run length coding");

        pgb_RLC.setValue((int) Double.parseDouble(this.percentage_RLC));
        pgb_RLC.setString(this.percentage_RLC + "%");
        pgb_RLC.setStringPainted(true);

        jLabel8.setText(this.RLC_size);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgb_RLC, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgb_RLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(227, 224, 224));
        jPanel6.setForeground(new java.awt.Color(3, 3, 3));

        jLabel5.setText("  Shannon coding");

        pgb_Shannon.setValue((int) Double.parseDouble(this.percentage_Shannon));
        pgb_Shannon.setString(this.percentage_Shannon + "%");
        pgb_Shannon.setStringPainted(true);

        jLabel9.setText(this.shannon_size);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgb_Shannon, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgb_Shannon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(227, 224, 224));
        jPanel7.setForeground(new java.awt.Color(3, 3, 3));

        jLabel6.setText("  Huffman");

        pgb_Huffman.setValue((int) Double.parseDouble(this.percentage_Huffman));
        pgb_Huffman.setString(this.percentage_Huffman + "%");
        pgb_Huffman.setStringPainted(true);

        jLabel10.setText(this.huffman_size);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgb_Huffman, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(pgb_Huffman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(227, 224, 224));
        jPanel8.setForeground(new java.awt.Color(3, 3, 3));

        jLabel7.setText("  LZW");

        pgb_LZW.setBackground(new java.awt.Color(254, 254, 254));
        pgb_LZW.setValue((int) Double.parseDouble(this.percentage_LZW));
        pgb_LZW.setString(this.percentage_LZW + "%");
        pgb_LZW.setStringPainted(true);

        jLabel11.setText(this.LZW_size);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgb_LZW, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgb_LZW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing
    
    private void Compress(String input, String file_name) throws IOException{
        File output;
        FileOutputStream fos;
        String CurrenDirection = new File(".").getAbsolutePath() + "/" + file_name.substring(0,file_name.length()-4);
        byte[] data;
//Shannon fano
        output = new File(CurrenDirection +"_shannon_fano_compressed.txt");
        fos = new FileOutputStream(output);
        ShannonFano sfc = new ShannonFano(input);
        data = sfc.toString().getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
        
        this.shannon_size = String.valueOf(output.length());
        double snsize = Double.parseDouble(this.shannon_size);
        this.percentage_Shannon = String.valueOf(Math.round(((snsize*100.0) / (double)this.original_size) *100) / 100.00);
        if(snsize < 1000.0){
            this.shannon_size += "bytes";
        } else if(snsize >= 1000 && snsize < 1000000){
            this.shannon_size = String.valueOf((double)snsize/1000.0*10/10) + "Kb";
        } else if(snsize >= 1000000){
            this.shannon_size = String.valueOf((double)snsize/1000000.0) + "Mb";
        }
//RLC
        output = new File(CurrenDirection +"_RLC_compressed.txt");
        fos = new FileOutputStream(output);
        
        RLC rlcc = new RLC(input);
        data = rlcc.toString().getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
        
        this.RLC_size = String.valueOf(output.length());
        snsize = Double.parseDouble(this.RLC_size);
        this.percentage_RLC = String.valueOf(Math.round(((snsize*100.0) / (double)this.original_size) *100) / 100.00);
        if(snsize < 1000.0){
            this.RLC_size += "bytes";
        } else if(snsize >= 1000 && snsize < 1000000){
            this.RLC_size = String.valueOf((double)snsize/1000.0*10/10) + "Kb";
        } else if(snsize >= 1000000){
            this.RLC_size = String.valueOf((double)snsize/1000000.0) + "Mb";
        }
//Huffman
        output = new File(CurrenDirection +"_Huffman_compressed.txt");
        fos = new FileOutputStream(output);
        
        Huffman huffman = new Huffman(input);
        data = huffman.toString().getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
        
        this.huffman_size = String.valueOf(output.length());
        snsize = Double.parseDouble(this.huffman_size);
        this.percentage_Huffman = String.valueOf(Math.round(((snsize*100.0) / (double)this.original_size) *100) / 100.00);
        if(snsize < 1000.0){
            this.huffman_size += "bytes";
        } else if(snsize >= 1000 && snsize < 1000000){
            this.huffman_size = String.valueOf((double)snsize/1000.0*10/10) + "Kb";
        } else if(snsize >= 1000000){
            this.huffman_size = String.valueOf((double)snsize/1000000.0) + "Mb";
        }
//LZW
        output = new File(CurrenDirection +"_Huffman_compressed.txt");
        fos = new FileOutputStream(output);
        
        LZW lzw = new LZW(input);
        data = lzw.toString().getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
        
        this.LZW_size = String.valueOf(output.length());
        snsize = Double.parseDouble(this.LZW_size);
        this.percentage_LZW = String.valueOf(Math.round(((snsize*100.0) / (double)this.original_size) *100) / 100.00);
        if(snsize < 1000.0){
            this.LZW_size += "bytes";
        } else if(snsize >= 1000 && snsize < 1000000){
            this.LZW_size = String.valueOf((double)snsize/1000.0*10/10) + "Kb";
        } else if(snsize >= 1000000){
            this.LZW_size = String.valueOf((double)snsize/1000000.0) + "Mb";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar pgb_Huffman;
    private javax.swing.JProgressBar pgb_LZW;
    private javax.swing.JProgressBar pgb_RLC;
    private javax.swing.JProgressBar pgb_Shannon;
    // End of variables declaration//GEN-END:variables



}
