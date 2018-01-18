/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nhan-kute
 */
public class ViewImageFrame extends JFrame{
    private Image img;
    private JLabel imgLabel;
    
    public ViewImageFrame(Image imge){
        this.img = imge;
        
        int height = img.getHeight(rootPane);
        int width = img.getWidth(rootPane);
        
        Init(height, width);
    }
    
    private void Init(int height, int width){
        imgLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        
        imgLabel.setBounds(10, 10, width, height);
        imgLabel.setIcon(new ImageIcon(img));
        
        ViewImageFrame.this.add(imgLabel);
        ViewImageFrame.this.setSize(width, height);
        ViewImageFrame.this.setLayout(null);
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt){
        setDefaultCloseOperation(MainFrame.DISPOSE_ON_CLOSE);
    }
}
