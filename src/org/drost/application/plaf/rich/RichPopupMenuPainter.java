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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

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
final class RichPopupMenuPainter extends AbstractPainter<Component> 
{
	RichPopupMenuPainter()
	{
		
	}

	@Override
	public void paint( Graphics2D g, Component object, int width, int height )
	{
		RoundRectangle2D rr = new RoundRectangle2D.Float(0, 0, width-1, height-1, 7, 7);

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC);
        g.setComposite(ac);
		
		g.setColor( theme.getMenuBackground( ) );
		g.fill( rr );
		
		g.setColor( theme.getMenuBorder( ) );
		g.draw( rr );
	}
	
}

