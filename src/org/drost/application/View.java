package org.drost.application;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Holds the main window of the current application and provides several
 * functionalities related to displayable application content. This class only
 * stores one window instance at the same time.
 * 
 * @author kimschorat
 * @since 1.0
 */
public class View 
{
	private Window window;
	
	private static boolean implicitExit = false;
	
//	protected Window about = null;
	
//	final JDialog defaultAbout = null;
	
	/**
	 * Creates a new view to handle viewable application content.
	 */
	public View()
	{
		window = null;
	}
	
	
	/**
	 * Creates a view and initializes the main window.
	 * 
	 * @param window
	 *            The main window.
	 * 
	 * @see #setMainView(Window)
	 */
	public View(Window window)
	{
		this.setMainView(window);
	}
	
	
	/**
	 * Because swing is not thread safe this method ensures that GUI associated
	 * code is run on the event dispatch thread to avoid any unexpected GUI
	 * behavior.
	 * 
	 * @param runnable
	 *            The runnable to be invoked on the EDT.
	 */
	public void runOnEDT(Runnable runnable)
	{
		if (SwingUtilities.isEventDispatchThread()) 
		{
	        runnable.run();
	    } 
		else 
		{
	        SwingUtilities.invokeLater(runnable);
	    }
	}
	
	
	/**
	 * When closing the last window the application terminates and shuts down.
	 * 
	 * @param implicit
	 *            Whether to exit the currently running application when the
	 *            last window is closed.
	 */
	public void setImplicitExit(boolean implicit)
	{
		implicitExit = implicit;
	}
	
	
	/**
	 * Returns whether the application terminates if the last open window is
	 * closing.
	 * 
	 * @return Whether the application terminates if the last open window is
	 *         closing.
	 */
	public boolean isImplicitExit()
	{
		return implicitExit;
	}
	
	
		
	
//	/**
//	 * Returns the about window of this application view. If it has not been set
//	 * yet a default window is created using some meta information from the
//	 * underlying application instance. Initially the window is {@code null}
//	 * that indicates the default window is returned. While the window is set
//	 * calling {@link #setAbout(JDialog)} it will return the new window object
//	 * the next time this method is called.
//	 * 
//	 * <p>
//	 * To delete and reset to the default window simply set a {@code null}
//	 * object to the about instance by  {@code setAbout(null)}.
//	 * </p>
//	 * 
//	 * @return The about window.
//	 * 
//	 * @see ApplicationMeta
//	 */
//	public Window getAbout() 
//	{
//		if(about == null)
//			return getDefaultAbout();
//		return about;
//	}
//
//
//	/**
//	 * Sets the about window for this application view. While this new instance
//	 * is a {@code null} reference a default generated window is returned by
//	 * {@link #getAbout()}. This way the current window can be reseted.
//	 * 
//	 * @param about The new about window object.
//	 */
//	public void setAbout(Window about) 
//	{
//		this.about = about;
//	}
//	
//	
//	/**
//	 * 
//	 * @return
//	 */
//	protected JDialog getDefaultAbout()
//	{
//		JDialog about = new JDialog();
//		about.setTitle("About");
//		
//		if(Application.isApplication())
//		{
//			ApplicationMeta meta = Application.getApplication().getApplicationMetaData();
//			
//			if(meta != null)
//			{
//				
//			}
//		}
//				
//		return about;
//	}
	
	
	
	
	
	


	/**
	 * Sets the main window for the underlying application. Does not provide any
	 * support for multi-framed applications where all those frames are main
	 * windows.
	 * 
	 * @param window
	 *            The application main window.
	 * @throws IllegalArgumentException
	 *             while the parameter is {@code null} or if this view instance
	 *             already has a window object.
	 */
	public void setMainView(Window window)
	{
		if(hasMainView() && window != null)
			throw new IllegalStateException(ExceptionMessages.MESSAGE_VIEW_HAS_MAIN_VIEW);
		
		this.window = window;
		
	}
	
	
	/**
	 * Returns the main window of the application.
	 * 
	 * @return The main window.
	 */
	public Window getMainView()
	{
		return window;
	}
	
	
	/**
	 * Returns whether the main view has already been set.
	 * 
	 * @return <code>true</code> if the window has already been set.
	 */
	public boolean hasMainView()
	{
		return (window != null);
	}
	
	
	
	
	
//	public static void maximize(Frame frame)
//	{
//		if(frame == null) return;
//		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
//	}
//	
//	
//	public static void minimize(Frame frame)
//	{
//		if(frame == null) return;
//		frame.setState(JFrame.ICONIFIED);
//	}
//
//	
//	
//	
//	public static void alwaysOnTop(Window window, boolean alwaysOnTop)
//	{
//		if(window == null) return;
//		if(window.isAlwaysOnTopSupported())
//			window.setAlwaysOnTop(alwaysOnTop);
//	}
	
	
	
	
	
//	public WindowSnapAdapter getSnapAdapter() 
//	{
//		return snapAdapter;
//	}


//	public ApplicationViewStateManager getViewState() {
//		return viewState;
//	}
//
//
//	public void setViewState(ApplicationViewStateManager viewState) {
//		this.viewState = viewState;
//	}



	
	
	
	/**
	 * <p>
	 * Applies the specified look and feel to this application, meaning all
	 * associated windows will be updated.
	 * </p>
	 * 
	 * @param qualifiedName
	 *            The name of the <code>LookAndFeel</code>.
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 * 
	 * @see UIManager#setLookAndFeel(String)
	 */
	public void setTheme(String qualifiedName)
	{
		try {
			UIManager.setLookAndFeel(qualifiedName);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < JFrame.getWindows().length; i++)
		{
			Window w = JFrame.getWindows()[i];
			SwingUtilities.updateComponentTreeUI(w);
		}
	}
	
	
	/**
	 * <p>
	 * This method simply invokes the homonymous method
	 * {@link #setTheme(String)} passing the class name of the specified class
	 * type.
	 * </p>
	 * 
	 * @param laf
	 *            The <code>LookAndFeel</code> class.
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
	public void setTheme(LookAndFeel laf) 
	{
		setTheme(laf.getClass().getName());
	}
	
	
	
	
	
	/**
	 * Traverse the component tree and whether enables or disables the
	 * component. While a component is the {@code Container} instance it
	 * recursively calls this method on all children components. Performs a
	 * depth first search to traverse the component tree.
	 * 
	 * @param comp
	 *            The component to whether enable or not.
	 * @param enabled
	 *            {@code true} to enable this component and all components
	 *            contained within, otherwise {@code false}.
	 */
	public static void setEnabled(Component comp, boolean enabled) 
	{
		comp.setEnabled(enabled);
		
		if(comp instanceof Container)
		{
			for(int i = 0; i < ((Container) comp).getComponentCount(); i++)
			{
				Component child = ((Container) comp).getComponent(i);
				if(child instanceof Container && ((Container) child).getComponentCount() > 0)
				{
					setEnabled(child, enabled);
				}
				else
				{
					child.setEnabled(enabled);
				}
			}
		}
	}

}