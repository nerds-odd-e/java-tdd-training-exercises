package bleep;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class OSClipboard implements Clipboard {

	@Override
	public String getContent() {
		java.awt.datatransfer.Clipboard cb = Toolkit.getDefaultToolkit()
				 .getSystemClipboard();
		Transferable  t = cb.getContents( null );
		if ( t.isDataFlavorSupported(DataFlavor.stringFlavor) )
        {
            try {
				Object o = t.getTransferData( DataFlavor.stringFlavor );
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String data="";
			try {
				data = (String)t.getTransferData( DataFlavor.stringFlavor );
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return data;
        }
		return "";
	}

	@Override
	public void copy(String contents) {
		
		java.awt.datatransfer.Clipboard cb = Toolkit.getDefaultToolkit()
				 .getSystemClipboard();
		
		StringSelection selection = new StringSelection(contents);
	   
	    cb.setContents(selection, selection);
		
		//System.out.println(contents);
		
	}

}
