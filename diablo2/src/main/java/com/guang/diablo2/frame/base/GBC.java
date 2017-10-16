package com.guang.diablo2.frame.base;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints{

	private static final long serialVersionUID = 2389617360647704473L;

	/**
	 * @param gridx
	 * @param gridy
	 */
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
		anchor = ABOVE_BASELINE_LEADING;
		insets = new Insets(0, 5, 0, 0);
	}

	/**
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 */
	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this(gridx, gridy);
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	
	public GBC(int gridx, int gridy, int gridwidth, int gridheight,int anchor) {
		this(gridx, gridy);
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		this.anchor = anchor;
	}
}
