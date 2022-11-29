/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.editor;

/**
 *
 * @author Saurabh Thakur
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class Editor implements ActionListener{
    JFrame frame;
    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectAll, close;

    JTextArea textArea;
    Editor(){
        //Initialized this frame
        frame = new JFrame();
//initialize menu
        menuBar=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");

        menuBar.add(file);
        menuBar.add(edit);
//init textArea
        textArea=new JTextArea();

        //init menu items
        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open File");
        saveFile=new JMenuItem("Save File");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
//         file.add(newFile);
//         file.add(openFile);
//         file.add(saveFile);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);


        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");
        close=new JMenuItem("Close");

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(scrollPane);

        frame.add(panel);
        frame.setJMenuBar(menuBar);

        frame.setBounds(100, 100, 400 , 400);
        frame.setVisible(true);
        frame.setTitle("Text Editor");

    }
    public static void main(String[] args){
        Editor textEditor = new Editor();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        e.getSource();
        if(e.getSource()==newFile)
        {
            Editor newTextEditor=new Editor();

        }
        if(e.getSource()==saveFile)
        {
            JFileChooser fileChooser= new JFileChooser("C:");
            fileChooser.setApproveButtonText("Save");
            int chooseOption = fileChooser.showSaveDialog(null);
            if(chooseOption == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsoluteFile()+".txt");
                String filePath = file.getPath();
                try{
                    BufferedWriter outfile =null;
                    outfile = new BufferedWriter(new FileWriter(file));
                    textArea.write(outfile);
                    outfile.close();
                } catch(Exception exception)
                {
                    System.out.println(exception);
                }
            }
        }
        if(e.getSource()==openFile)
        {
              JFileChooser fileChooser = new JFileChooser("C:");
              int chooseOption  = fileChooser.showOpenDialog(null);

              if(chooseOption == JFileChooser.APPROVE_OPTION)
              {
                  File file = fileChooser.getSelectedFile();
                  String filePath = file.getPath();
                  try{
                      BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                      String intermediate = "",output="";
                      while((intermediate = bufferedReader.readLine())!=null)
                      {
                          output+=intermediate+"\n";
                      }
                      textArea.setText(output);
                  }catch(Exception exception){
                      System.out.println(exception);
                  }
              }


        }
        if(e.getSource()==cut)
        {
            textArea.cut();

        }
        if(e.getSource()==paste)
        {
            textArea.paste();

        }
        if(e.getSource()==copy)
        {
            textArea.copy();

        }
        if(e.getSource()==selectAll)
        {
            textArea.selectAll();

        }
        if(e.getSource()==close)
        {
            System.exit(0);

        }

    }
}
