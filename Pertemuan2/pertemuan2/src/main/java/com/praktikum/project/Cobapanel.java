package com.praktikum.project;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Cobapanel{
  public static void main(String[] xx){
    //beberapa button untuk demo
	JButton btn1 = new JButton("Tombol 1");
	JButton btn2 = new JButton("#2");
	
	JPanel panel= new JPanel();
	JPanel panel2= new JPanel();
	panel.setLayout(new FlowLayout());
	panel.add(btn1);
	panel2.setLayout(new FlowLayout());
	panel2.add(btn2);
	
	//menginstankan Frame
	JFrame fr = new JFrame("Belajar Layout");
	
	fr.setLayout(new GridLayout(1,2,5,10));
	fr.getContentPane().add(panel);
	fr.getContentPane().add(panel2);
	
	
	//ukuran frame
	fr.setSize(800,400);
	
	
	//mengatur posisi frame agar di tengah
	fr.setLocationRelativeTo(null);
	
	//tampilkan
	fr.setVisible(true);
  }
}
