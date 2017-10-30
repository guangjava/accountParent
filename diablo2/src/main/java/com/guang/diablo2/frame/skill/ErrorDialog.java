package com.guang.diablo2.frame.skill;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialog implements ActionListener{
	
	private JDialog dialog;
	public ErrorDialog(Frame owner, String title,String context, boolean modal) {
		dialog = new JDialog(owner, title, modal);
		dialog.setSize(200, 200);
		dialog.setLocation(400, 350);
		JPanel panel = new JPanel();
		dialog.setContentPane(panel);
		JLabel label = new JLabel(context);
		
		dialog.add(label);
		JButton ok = new JButton("确定");
		ok.addActionListener(this);
		dialog.add(ok);
		dialog.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("确定")) {
			SkillTree.getInstance().setBaseSkillLevelVerify(false);
			dialog.dispose();
		}
		
	}

}
