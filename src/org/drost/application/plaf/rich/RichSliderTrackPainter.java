/*
 * This file is part of the application library that simplifies common
 * initialization and helps setting up any java program.
 * 
 * Copyright (C) 2016 Yannick Drost, all rights reserved.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.drost.application.plaf.rich;

import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import javax.swing.Painter;

/**
 * This extends the {@code AbstractPainter<T>} class and implements the
 * {@code paint}-method of the {@link Painter<T>} interface.
 * <p>
 * It is used by the {@link RichLookAndFeel} to render all necessary UI
 * components. This class is responsible for painting the associated component
 * having the same name in the defaults table, accessible by
 * {@code UIManager#getDefaults()}.
 * 
 * @author Yannick Drost
 * 
 * @see AbstractPainter
 * @see Painter
 *
 */
final class RichSliderTrackPainter extends AbstractPainter<Component>
{
	boolean enabled;
	
	RichSliderTrackPainter(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	@Override
	public void paint( Graphics2D g, Component object, int width, int height )
	{		
		if(enabled)
		{
			GradientPaint bg = new GradientPaint(0, height/2-3, theme.getBackgroundDarker2( ), 0, height/2+3, theme.getBackgroundDarker( ) );
			g.setPaint( bg );
			g.fillRoundRect( 2, height/2-3, width-5, 7, 4, 4 );
		}
		else
		{
			
		}
	}

}
