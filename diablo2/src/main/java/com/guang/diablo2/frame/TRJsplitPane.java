package com.guang.diablo2.frame;

import java.awt.Component;

import javax.swing.JSplitPane;

public class TRJsplitPane extends JSplitPane{

	private static final long serialVersionUID = -6984198029126671860L;

	/**
	 * @param newOrientation
	 * @param newLeftComponent
	 * @param newRightComponent
	 */
	public TRJsplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent) {
		super(newOrientation, newLeftComponent, newRightComponent);
		setDividerSize(1);
	}

}
