package com.example.flyoutmenuexample.view.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class FlyOutContainer extends LinearLayout {

	// References to groups contained in this view.
	private View menuVG;
	private View contentVG;

	// Constants
	protected static final int menuMargin = 150;

	public enum MenuState {
		CLOSED, OPEN
	};

	// Position information attributes
	protected int currentContentOffset = 0;
	protected MenuState menuCurrentState = MenuState.CLOSED;

	public FlyOutContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FlyOutContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FlyOutContainer(Context context) {
		super(context);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

		this.menuVG = this.getChildAt(0);
		this.contentVG = this.getChildAt(1);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if (changed)
			this.calculateChildDimensions();

		this.menuVG.layout(left, top, left + getMenuWidth(), bottom);

		switch (this.menuCurrentState) {
		case CLOSED:
			this.contentVG.layout(left, top, right, bottom);
			break;
		case OPEN:
			this.contentVG.layout(left + this.currentContentOffset, top, right
					+ this.currentContentOffset, bottom);
			break;
		}
	}

	public void toggleMenu() {
		switch (this.menuCurrentState) {
		case CLOSED:
			this.currentContentOffset = this.getMenuWidth();
			this.contentVG.offsetLeftAndRight(currentContentOffset);
			this.menuCurrentState = MenuState.OPEN;
			break;
		case OPEN:
			this.contentVG.offsetLeftAndRight(-currentContentOffset);
			this.currentContentOffset = 0;
			this.menuCurrentState = MenuState.CLOSED;
			break;
		}

		this.invalidate();
	}

	private int getMenuWidth() {
		return this.menuVG.getLayoutParams().width;
	}

	private void calculateChildDimensions() {
		this.contentVG.getLayoutParams().height = this.getHeight();
		this.contentVG.getLayoutParams().width = this.getWidth();

		this.menuVG.getLayoutParams().width = this.getWidth() - menuMargin;
		this.menuVG.getLayoutParams().height = this.getHeight();
	}

}
