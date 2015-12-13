
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DefinedCursor extends JFrame
{
	int num;
	public Cursor cursor = null;						//Cursor�� ���� cursor ���� �� �ʱ�ȭ
	Toolkit toolkit = Toolkit.getDefaultToolkit();		//Toolkit�� ���� toolkit ���� �� �ʱ�ȭ 

	public DefinedCursor()					//������
	{
		init(num);							//init�Լ� ����					
	}
	
	public void init(int num)
	{
	       Toolkit toolkit = Toolkit.getDefaultToolkit();
	       MediaTracker tracker = new MediaTracker(this);		//MediaTracker�� ���� tracker ����

	       if( num == 0 )										//init�Լ��� �޾ƿ� ������ 0�ϰ�� = ����
	       {
	    	   Image cursorImage = toolkit.getImage("image/pencil.gif");	//���콺 Ŀ���� �̹�������
	    	   tracker.addImage(cursorImage, 0);							//Ŀ���� �̹��� ���̱�
	    	   
	    	   try { tracker.waitForID(0); }								//���콺 ����
	    	   catch (InterruptedException ie) { ie.printStackTrace(); }
	    	   
	    	   try
	    	   {
	    		   Point hotSpot = new Point(1, 1);  						//Ŀ���� ������ ����
	    		   cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");	//Ŀ�� ����
	    	   }
	    	   catch (IndexOutOfBoundsException e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	       }
	       
	       else if( num == 1 )									//���찳 ���ý�
	       {
		       Image cursorImage = toolkit.getImage("image/eraserc.gif");
		       toolkit.getBestCursorSize(64, 64);				//Ŀ���� ��������� ����
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	      else if( num == 2 )			// Sumin's mode
	       {
		       Image cursorImage = toolkit.getImage("image/sue.jpg");
		       toolkit.getBestCursorSize(64, 64);
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	       
	      else if( num == 3 )							// Minseop's mode
	       {
		       Image cursorImage = toolkit.getImage("image/min.jpg");
		       toolkit.getBestCursorSize(64, 64);
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	       
	      else if( num == 4 )						//Kyungryun's mode
	       {
		       Image cursorImage = toolkit.getImage("image/ryun.jpg");
		       toolkit.getBestCursorSize(64, 64);
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	       
	      else if( num == 5 )						//Sue and Kyungryun's mode
	       {
		       Image cursorImage = toolkit.getImage("image/suekyung.jpg");
		       toolkit.getBestCursorSize(64, 64);
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	      else if( num == 6 )						//hoon's mode
	       {
		       Image cursorImage = toolkit.getImage("image/hoon.png");
		       toolkit.getBestCursorSize(64, 64);
		       tracker.addImage(cursorImage, 0);
		       
		       try { tracker.waitForID(0); }
		       catch (InterruptedException ie) { ie.printStackTrace(); }

		       try
		       {
		           Point hotSpot = new Point(1, 1);  
		           cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");

		       }
		       catch (IndexOutOfBoundsException e)
		       {
		           e.printStackTrace();
		       }
	       }
	}
	public Cursor getinit(int num2)						//Cursor�� �Լ� getinit
	{
		init(num2);										//init�Լ� ȣ��
		return cursor;									//cursor�� �� ��ȯ
	}
}