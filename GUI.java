import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

public class GUI {
    
    static public String musicpath;
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("MusicX"); 
  
        // creates instance of JButton 
        JButton exit = new JButton("Exit"); 
        JButton browse = new JButton("Browse"); 
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame1.dispose();
            }
        });
        browse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(null);//Points to the default directory
                fc.setDialogTitle("Choose music file");
                fc.setFileFilter(new FileNameExtensionFilter("MP3 and WAV files","mp3","wav"));
                int returnVal = fc.showOpenDialog(frame1);
                if(returnVal==JFileChooser.APPROVE_OPTION)
                {
                    //This means that the file was accepeted. 
                    musicpath=fc.getSelectedFile().toPath().toString();
                    String extension=musicpath.substring(musicpath.length()-3,musicpath.length());
                    System.out.println(extension);
                    if((extension.equals("mp3")||(extension.equals("wav"))))
                    {
                        System.out.println("Correct Sound Format");

                    }
                    else
                    System.out.println("Incorrect Sound Format.Choose again");

                    
                }
                else
                System.out.println("Error while reading file. Make sure it is correct format");
            }
        });
        // x axis, y axis, width, height 
        exit.setBounds(400, 140 ,90, 20); 
        browse.setBounds(300,140,90,20);
        frame1.add(exit);
        frame1.add(browse);
        frame1.setSize(500,200);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //frame1.dispose();
    }
    
}