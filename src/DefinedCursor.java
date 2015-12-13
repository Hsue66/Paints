
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DefinedCursor extends JFrame
{
	int num;
	public Cursor cursor = null;						//Cursor형 변수 cursor 선언 및 초기화
	Toolkit toolkit = Toolkit.getDefaultToolkit();		//Toolkit형 변수 toolkit 선언 및 초기화 

	public DefinedCursor()					//생성자
	{
		init(num);							//init함수 선언					
	}
	
	public void init(int num)
	{
	       Toolkit toolkit = Toolkit.getDefaultToolkit();
	       MediaTracker tracker = new MediaTracker(this);		//MediaTracker형 변수 tracker 선언

	       if( num == 0 )										//init함수가 받아온 정수가 0일경우 = 연필
	       {
	    	   Image cursorImage = toolkit.getImage("image/pencil.gif");	//마우스 커서의 이미지설정
	    	   tracker.addImage(cursorImage, 0);							//커서에 이미지 붙이기
	    	   
	    	   try { tracker.waitForID(0); }								//마우스 설정
	    	   catch (InterruptedException ie) { ie.printStackTrace(); }
	    	   
	    	   try
	    	   {
	    		   Point hotSpot = new Point(1, 1);  						//커서의 시작점 설정
	    		   cursor = toolkit.createCustomCursor(cursorImage, hotSpot, "i_mouse Cursor");	//커서 설정
	    	   }
	    	   catch (IndexOutOfBoundsException e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	       }
	       
	       else if( num == 1 )									//지우개 선택시
	       {
		       Image cursorImage = toolkit.getImage("image/eraserc.gif");
		       toolkit.getBestCursorSize(64, 64);				//커서의 희망사이즈 설정
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
	public Cursor getinit(int num2)						//Cursor형 함수 getinit
	{
		init(num2);										//init함수 호출
		return cursor;									//cursor의 값 반환
	}
}