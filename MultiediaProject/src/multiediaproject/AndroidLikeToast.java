/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
 
 
public class AndroidLikeToast extends JDialog {
 
    private String msg;
    private JFrame frame;
    // you can set the time for how long the dialog will be displayed
    public static final int LENGTH_LONG = 5000;
    public static final int LENGTH_SHORT = 2000;
 
    public AndroidLikeToast(JFrame frame, boolean modal, String msg) {
        super(frame, modal);
        this.msg = msg;
        this.frame=frame;
        initComponents();        
    }
 
    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addComponentListener(new ComponentAdapter() {
            // Give the window an rounded rect shape.
 
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        });
        setUndecorated(true);
        setSize(450, 50);
        setLocationRelativeTo(frame);// adding toast to frame or use null
        getContentPane().setBackground(Color.GRAY);
         
        // Determine what the GraphicsDevice can support.
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        final boolean isTranslucencySupported =
                gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);
 
        //If shaped windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT)) {
            System.err.println("Shaped windows are not supported");
        }
 
        //If translucent windows are supported, 
        //create an opaque window.
        // Set the window to 50% translucency, if supported.
        if (isTranslucencySupported) {
            setOpacity(0.5f);
        } else {
            System.out.println("Translucency is not supported.");
        }
 
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setText("<html>" + msg + "</html>");
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);
    }
}
