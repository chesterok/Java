import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import java.util.HashSet;
 
public class Frame extends JFrame {
	private JTextField textField;
	private JProgressBar pBar;
	private Table temp;
 
	public Frame() {
		super("Open Data");
		createUI();
	}

	public JTextField getTextField() {
		return textField;
	}

	public JProgressBar getPBar() {
		return pBar;
	}

	public Table getTemp() {
		return temp;
	}
 
	public void createUI() { 
		textField = new JTextField();
		JPanel panel = new JPanel();
		JButton button = new JButton("Open");
		ActionListener actionListener = new TestActionListener();
	    
		pBar = new JProgressBar(0, 100);
	    pBar.setStringPainted(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    textField.setColumns(30);
	    panel.add(pBar);
		panel.setLayout(new FlowLayout());
		panel.add(button);
		panel.add(textField);           
		button.addActionListener(actionListener);
		getContentPane().add(panel);
		setPreferredSize(new Dimension(400, 100));
	}

	public void setProgressBar() {
		Thread runner = new Thread() {
	          public void run() {
	            for ( int i = 0; i <= 100; i++ ) {
	            	final int parcent = i;
		             
		            Runnable runme = new Runnable() {
		                public void run() { pBar.setValue(parcent); }
					};

	              	SwingUtilities.invokeLater(runme);
		            try {
		            	Thread.sleep(50);
		            } catch (Exception ex) {

		            }
		        }
		        temp.createAndShowUI();
		    }
	    };
	    runner.start();
	}

	public class TestActionListener implements ActionListener  {
	    public void actionPerformed(ActionEvent e) {
	        String url = textField.getText();
	        Object[] array = Table.getCounter().toArray();

	        for( int i = 0; i < array.length; i++ ) {
	            Table userUrl = (Table)array[i];

	            if ( userUrl.getProfileUrl().equals(url) ) {
	                temp = userUrl;
	                setProgressBar();
	            }
	        }
	    }
	}
}
