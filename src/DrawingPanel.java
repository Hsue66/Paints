
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
	/* ��ü�� ������ ������ ���� ���� */
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	int []xP;
	int []yP;
	int point = 0;
	int width = 0;
	int height = 0;					
	Color color;					// �÷��� ����
	
	Vector figure;	// �������� ����
	
	private int myfunc = 0;

	int stroke = 3; 				// �⺻ ���β�
	int stroke2 = 5;				// �⺻ ���찳�β�
	int styles=0;					// �⺻ ����Ÿ��
	
	boolean fill= false;			// ä��� ��� ���� ������ �Ǵ��ϴ� ����
	
	int selecX;
	int selecY;
	
	// ������ �̹��� ����
	ImageIcon img = new ImageIcon("image/stamp.png");
	ImageIcon img1 = new ImageIcon("image/seopstamp.png");
	ImageIcon img2 = new ImageIcon("image/ryunstamp.png");
	ImageIcon img3 = new ImageIcon("image/minstamp.png");
	ImageIcon img4 = new ImageIcon("image/dostamp.png");
	
	public DrawingPanel()
	{
		color = Color.BLACK;
		figure = new Vector();
		addMouseListener(new MouseListen()); 			// MouseListen�� ���콺�� ��ɿ� ���� ���� ����
		addMouseMotionListener(new MouseMotionListen());  
	}
	
	public void setFunc(int type) 
	{
		this.myfunc = type; 				// ������ �޴��� ����
	}
	public int getMyFunc()
	{
		return myfunc;						// ���ø޴� ��ȯ
	}

	
	public void letsCursor()				//Ŀ�� �̹����� ����Ȳ�� �°� ���̱� ���� �Լ�
	{
		DefinedCursor mycursor = new DefinedCursor();			//DefinedCursor�� ���� ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();			//Toolkit�� ���� ����
		
		if(this.getMyFunc() == 0)								//�����϶�
		{
			if(ToolPanel.sueCheckBox.isSelected() && ToolPanel.kyungCheckBox.isSelected())		//üũ�ڽ��� ������ �Ǿ������
				setCursor(mycursor.getinit(5));
			else if(ToolPanel.sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if(ToolPanel.kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if(ToolPanel.minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( ToolPanel.hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(mycursor.getinit(0));
			
		}
		
		else if(this.getMyFunc() == 1)				//�����϶�
		{
			if(ToolPanel.sueCheckBox.isSelected() && ToolPanel.kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(5));
			else if(ToolPanel.sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if(ToolPanel.kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if(ToolPanel.minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if(ToolPanel.hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(mycursor.getinit(1));
		}
	
		else			//������ �����϶�
		{
			if(ToolPanel.sueCheckBox.isSelected() && ToolPanel.kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(5));
			else if(ToolPanel.sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if(ToolPanel.kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if(ToolPanel.minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if(ToolPanel.hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // stroke�� Graphic2D�� ���ؼ� �ʿ���
		if (GraphicsEdit.tool.return_mode == true) {
			painting(g);
		} else {
			// �� ��Ÿ�Ͽ� ���� ����, ����, �ұյ� ����, ���� ������ ������
			if (styles == 0) {
				g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, 0));
			} else if (styles == 1) {
				float[] dash = new float[] { 10, 10, 10, 10 };
				g2.setStroke(new BasicStroke(stroke, 0, BasicStroke.JOIN_MITER,
						1.0f, dash, 0));
			} else if (styles == 2) {
				float[] dash = new float[] { 10, 5, 5, 5 };
				g2.setStroke(new BasicStroke(stroke, 0, BasicStroke.JOIN_MITER,
						1.0f, dash, 0));
			} else if (styles == 3) {
				float[] dash = new float[] { 0, 10, 0, 10 };
				g2.setStroke(new BasicStroke(stroke, 1, BasicStroke.JOIN_MITER,
						1.0f, dash, 0));
			}

			g.setColor(color); // ������

			// myfunc�� ���� ��ɺз�
			if (myfunc == 0) {
				g.drawLine(x1, y1, x2, y2); // ��׸���
				painting(g);
			} else if (myfunc == 1) {
				g.setColor(Color.WHITE); // ���찳
				g2.setStroke(new BasicStroke(stroke2, BasicStroke.CAP_ROUND, 0));
				g.drawLine(x1, y1, x2, y2);
				painting(g);
			} else if (myfunc == 2) {
				g.drawLine(x1, y1, x2, y2); // ����
				painting(g);
			} else if (myfunc == 3) { // �簢��
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), width, height);
				painting(g);
			} else if (myfunc == 4) { // �ձٻ簢��
				if(fill == false)
				{
					g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), width,
						height, 20, 20);
				}
				else
				{
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), width,
						height, 20, 20);
				}
				
				painting(g);
				
			} else if (myfunc == 5) { // ��
				if(fill == false)	
				{
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
				}
				else	// ä��Ⱑ true ��� ä��� ����
				{
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
				}
				
				painting(g);
			} else if (myfunc == 6) { // �����ﰢ��
				setPoly();
				if(fill == false)
				{
					g.drawPolygon(xP, yP, point);
				}
				else
				{
					g.fillPolygon(xP, yP, point);
				}
				
				painting(g);
			} else if (myfunc == 7) { // ���ﰢ��
				setPoly();
				if(fill == false)
				{
					g.drawPolygon(xP, yP, point);
				}
				else
				{
					g.fillPolygon(xP, yP, point);
				}
				
				painting(g);
			} else if (myfunc == 8) { // ������
				setPoly();
				if(fill == false)
				{
					g.drawPolygon(xP, yP, point);
				}
				else
				{
					g.fillPolygon(xP, yP, point);
				}
				
				painting(g);
			}

			else if (myfunc == 9) { // ������
				setPoly();
				if(fill == false)
				{
					g.drawPolygon(xP, yP, point);
				}
				else
				{
					g.fillPolygon(xP, yP, point);
				}
				
				painting(g);
			}

			else if (myfunc == 10) { // ������
				setPoly();
				if(fill == false)
				{
					g.drawPolygon(xP, yP, point);
				}
				else
				{
					g.fillPolygon(xP, yP, point);
				}
				
				painting(g);
			}
			else if (myfunc == 11) { // �����ϱ�
				painting(g);
			}
			else if (myfunc == 12){  // �� ä���
				painting(g);
			}
			else if (myfunc == 15) // stamp
			{
				g.drawImage(img.getImage(), x1 - 70, y1 - 70, this);
				painting(g);
			} else if (myfunc == 16) // seopstamp
			{
				g.drawImage(img1.getImage(), x1 - 50, y1 - 60, this);
				painting(g);
			} else if (myfunc == 17) // ryunstamp
			{
				g.drawImage(img2.getImage(), x1 - 50, y1 - 60, this);
				painting(g);
			} else if (myfunc == 18) // minstamp
			{
				g.drawImage(img3.getImage(), x1 - 50, y1 - 60, this);
				painting(g);
			} else if (myfunc == 19) // minstamp
			{
				g.drawImage(img4.getImage(), x1 - 50, y1 - 60, this);
				painting(g);
			}
		}
	}
	
	// Polygon ����
	/* myfunc ����  6�϶� : �����ﰢ��
	 * 			  7�϶� : ���ﰢ��
	 * 			  8�϶� : ������
	 * 			  9�϶� : ������
	 * 			 10�϶� : ������  */
	public void setPoly(){
		if(myfunc == 6)
		{
			point = 3;
			xP = new int[]{x1,x1,x2};
			yP = new int[]{y1,y2,y2};
		}
		else if(myfunc == 7)
		{
			point = 3;
			xP = new int[]{(x1+x2)/2,x1,x2};
			yP = new int[]{y1,y2,y2};
		}
		else if(myfunc == 8)
		{
			point = 4;
			xP = new int[]{(x1+x2)/2, x1, (x1+x2)/2, x2};
			yP = new int[]{y1, (y1+y2)/2, y2, (y1+y2)/2};
		}
		
		else if(myfunc == 9)
		{
			point = 5;
			xP = new int[]{(x1+x2)/2, x1,(((x1+x2)/2)+x1)/2 ,(((x1+x2)/2)+x2)/2, x2};
			yP = new int[]{y1,(y1+y2)/2, y2,y2,(y1+y2)/2};
		}
		
		else if(myfunc == 10)
		{
			point = 6;
			xP = new int[]{(x1+x2)/2, x1, x1, (x1+x2)/2, x2, x2};
			yP = new int[]{y1, (int)(y1 + ((int)(y2-y1)*(1/(2+Math.sqrt(2))))),
								(int)(y2 - ((int)(y2-y1)*(1/(2+Math.sqrt(2))))),
								y2, (int)(y2 - ((int)(y2-y1)*(1/(2+Math.sqrt(2))))), 
									(int)(y1 + ((int)(y2-y1)*(1/(2+Math.sqrt(2)))))};
		}
	}

	

	public void painting(Graphics g){
		for(int i =0; i <figure.size(); i++)
		{
			DrawContents shape = (DrawContents) figure.elementAt(i);
			g.setColor(shape.color);
			Graphics2D g2 = (Graphics2D) g;
			
			// �� ��Ÿ�Ͽ� ���� ����, ����, �ұյ� ����, ���� ������ ������
			if(shape.styles==0)
			{
				g2.setStroke(new BasicStroke(shape.stroke,  BasicStroke.CAP_ROUND,0));
			}
			else if(shape.styles==1)
			{
				float[] dash =new float[]{10,10,10,10};
				g2.setStroke(new BasicStroke(shape.stroke,0,BasicStroke.JOIN_MITER,1.0f,dash,0));
			}
			else if(shape.styles==2)
			{
				float[] dash =new float[]{10,5,5,5};
				g2.setStroke(new BasicStroke(shape.stroke,0,BasicStroke.JOIN_MITER,1.0f,dash,0));
			}
			else if(shape.styles==3)
			{
				float[] dash =new float[]{0,10,0,10};
				g2.setStroke(new BasicStroke(shape.stroke,1,BasicStroke.JOIN_MITER,1.0f,dash,0));
			}
			
			
			if(shape.function == 0)													// ��׸���
			{
				g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
			}
			else if(shape.function == 1)											// ���찳
			{
				g.setColor(Color.white);
				g2.setStroke(new BasicStroke(shape.stroke2,  BasicStroke.CAP_ROUND,0));
				g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
			}
			else if(shape.function == 2) 											//����
			{
				g.drawLine(shape.x1,shape.y1,shape.x2,shape.y2);
				// ���ø���϶� selectMark Method() ȣ��
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			
			else if(shape.function == 3) 											//�簢��
			{
				if(shape.fill == false) // ä��� ��ư �������������� ����
				{
					g.drawRect(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height);
				}
				else
				{
					g.fillRect(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height);
				}
				
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			else if(shape.function == 4) 											//�ձٻ簢��
			{
				if(shape.fill == false)
				{
					g.drawRoundRect(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height,20,20);
				}
				else
				{
					g.fillRoundRect(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height,20,20);
				}
				
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			else if(shape.function == 5)											 //��
			{
				if(shape.fill == false)
				{
					g.drawOval(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height);
				}
				else
				{
					g.fillOval(Math.min(shape.x1, shape.x2), Math.min(shape.y1, shape.y2), shape.width, shape.height);
				}
				
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			
			else if(shape.function == 6)											// �����ﰢ��
			{	
				shape.xP = new int[]{shape.x1,shape.x1,shape.x2};
				shape.yP = new int[]{shape.y1,shape.y2,shape.y2};
				if(shape.fill == false)
				{
					g.drawPolygon(shape.xP, shape.yP, shape.point);
				}
				else
				{
					g.fillPolygon(shape.xP, shape.yP, shape.point);
				}

				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			else if(shape.function == 7)											// ���ﰢ��
			{	
				
				shape.xP = new int[]{(shape.x1+shape.x2)/2,shape.x1,shape.x2};
				shape.yP = new int[]{shape.y1,shape.y2,shape.y2};
				if(shape.fill == false)
				{
					g.drawPolygon(shape.xP, shape.yP, shape.point);
				}
				else
				{
					g.fillPolygon(shape.xP, shape.yP, shape.point);
				}
				
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}	
			else if(shape.function == 8)											// ������
			{	
				
				shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1, (shape.x1+shape.x2)/2, shape.x2};
				shape.yP = new int[]{shape.y1, (shape.y1+shape.y2)/2, shape.y2, (shape.y1+shape.y2)/2};
				if(shape.fill == false)
				{
					g.drawPolygon(shape.xP, shape.yP, shape.point);
				}
				else
				{
					g.fillPolygon(shape.xP, shape.yP, shape.point);
				}

				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			
			else if(shape.function == 9)											// ������
			{	
				
				shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1,(((shape.x1+shape.x2)/2)+shape.x1)/2 
									,(((shape.x1+shape.x2)/2)+shape.x2)/2, shape.x2};
				shape.yP = new int[]{shape.y1,(shape.y1+shape.y2)/2, shape.y2,shape.y2,(shape.y1+shape.y2)/2};
				if(shape.fill == false)
				{
					g.drawPolygon(shape.xP, shape.yP, shape.point);
				}
				else
				{
					g.fillPolygon(shape.xP, shape.yP, shape.point);
				}

				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}	
			else if(shape.function == 10)											// ������
			{	
				
				shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1, shape.x1, (shape.x1+shape.x2)/2, shape.x2, shape.x2};
				shape.yP = new int[]{shape.y1, (int)(shape.y1 + ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))),
									(int)(shape.y2 - ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))),
									shape.y2, (int)(shape.y2 - ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))), 
										(int)(shape.y1 + ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2)))))};
				if(shape.fill == false)
				{
					g.drawPolygon(shape.xP, shape.yP, shape.point);
				}
				else
				{
					g.fillPolygon(shape.xP, shape.yP, shape.point);
				}

				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}		
	
			else if(shape.function ==15) 											//stamp
			{
				g.drawImage(shape.img.getImage(), shape.x1-70, shape.y1-70, this); 	//���콺Ŀ���� �������� �߾ӿ� ������
			}
			else if(shape.function ==16)  											//seopstamp
			{
				g.drawImage(img1.getImage(), shape.x1-50, shape.y1-60, this); 
			}
			else if(shape.function ==17)  											//ryunstamp
			{
				g.drawImage(img2.getImage(), shape.x1-50, shape.y1-60, this); 
			}
			else if(shape.function ==18)  											//minstamp
			{
				g.drawImage(img3.getImage(), shape.x1-50, shape.y1-60, this); 
			}
			else if(shape.function ==19)  											//dostamp
			{
				g.drawImage(img4.getImage(), shape.x1-50, shape.y1-60, this); 
			}
		}
	}
	
	public void selectMark(DrawContents shape,Graphics g) {
		if(shape.getSelect()==1||shape.getSelect()==2||shape.getSelect()==3) { 
			// i��° ������ ���õǾ��ٸ�(1:��������� ����, 2:������ ��ȯ�� ���� ����, 3:�̵��� ���� ����)
			g.setColor(Color.black);
			g.fillRect(shape.x1-3, shape.y1-3, 6, 6); // i��° ������ �� ������, ������ �߽ɿ� �׸����� �׸� 
			g.fillRect(shape.x1-3, shape.y2-3, 6, 6);
			g.fillRect(shape.x2-3, shape.y1-3, 6, 6);
			g.fillRect(shape.x2-3, shape.y2-3, 6, 6);
			g.fillRect(Math.abs(shape.x2 + shape.x1) / 2, shape.y1 - 3 , 6, 6);
			g.fillRect(Math.abs(shape.x2 + shape.x1) / 2, shape.y2 - 3,  6, 6);
			g.fillRect(shape.x1-3, Math.abs(shape.y1 + shape.y2) / 2,  6, 6);
			g.fillRect(shape.x2-3, Math.abs(shape.y1 + shape.y2) / 2,  6, 6);
		}
	}
	
	class MouseListen extends MouseAdapter 
	{
		public void mousePressed(MouseEvent e) 			// ���콺�� ������ ��
		{	
			x1=e.getX(); // x��ǥ�� x1�� �Ҵ�
			y1=e.getY(); // y��ǥ�� y1�� �Ҵ�
			
			if(myfunc== 15 || myfunc==16 || myfunc==17 || myfunc==18 || myfunc==19)		//������ ���� figure�� �߰�
			{	
				DrawContents drawContents = new DrawContents(img,x1, y1 , 0,0, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
		}
		
		public void mouseReleased(MouseEvent e) 		//���콺�� �� ��
		{	
			x2=e.getX(); // x��ǥ�� x2�� �Ҵ�
			y2=e.getY(); // y��ǥ�� y2�� �Ҵ�
			width=Math.max(x1, x2)-Math.min(x1, x2); 	// �ʺ� ����
			height=Math.max(y1, y2)-Math.min(y1, y2); 	// ���̸� ����

			setPoly();
			if(myfunc == 3 || myfunc == 4 || myfunc == 5 )						// �簢��, �ձٻ簢��, �� �� ���
			{
				// ���� ������ ���� ������ ��üȭ
				DrawContents drawContents = new DrawContents(Math.min(x1,x2), Math.min(y1, y2),Math.max(x1, x2),
											Math.max(y1, y2), width, height, color,myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents); // ���Ϳ� �� ������ ����
			}
			else if(myfunc== 2)													// ���찳�� ���
			{
				DrawContents drawContents = new DrawContents(x1, y1, x2, y2, width, height, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
			else if(myfunc== 1)													// ���� ���
			{
				DrawContents drawContents = new DrawContents(x1, y1, x2, y2, width, height, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
			else if(myfunc == 6 || myfunc == 7 || myfunc == 8 || myfunc ==9 || myfunc ==10 )	// �����ﰢ��,���ﰢ��,������,�������� ���
			{
				DrawContents drawContents=new DrawContents(x1, y1, x2, y2, xP, yP ,width, height, point,  color,myfunc,  fill,stroke,styles);
				figure.add(drawContents);
			}
			repaint();
			
		}
		
		public void mouseClicked(MouseEvent e)				//���콺�� Ŭ������ ��
		{ 	
			selecX=e.getX(); // x��ǥ�� selecX�� �Ҵ�
			selecY=e.getY(); // y��ǥ�� selecY�� �Ҵ�

			width=Math.max(x1, x2)-Math.min(x1, x2);
			height=Math.max(y1, y2)-Math.min(y1, y2);
			
			if(myfunc== 15 || myfunc==16 || myfunc==17 || myfunc==18|| myfunc==19)			//�������� ���
			{	
				DrawContents drawContents = new DrawContents(img , x1, y1 , width, height, color, myfunc, fill, stroke, stroke2, styles);
				figure.add(drawContents);
			}
			if(GraphicsEdit.tool.fill_mode == true)		//ä����尡 true�� ���
			{
				for(int i = figure.size() - 1; i >= 0 ;i--) 
				{
					DrawContents shape=(DrawContents)figure.elementAt(i);

					if(selecX > shape.x1 && selecX < shape.x2 && selecY > shape.y1 && selecY < shape.y2)	// Ŭ���� ������ ���� ������ ���
					{
						shape.color = color;//���� �ֱٿ� �׷��� ��ü�� ������ ����.
						shape.fill = true;
						break;
					}
					repaint();
				}
			}
			
			for(int i=figure.size() - 1 ; i >= 0 ;i--) {
				DrawContents shape=(DrawContents)figure.elementAt(i);
				if(selecX > shape.x1 && selecX < shape.x2 && selecY > shape.y1 && selecY < shape.y2)//Ŭ���� ������ ���� ������ ���
				{
					for(i=figure.size() - 1 ; i >= 0 ; i--)
					{
						DrawContents shapes=(DrawContents)figure.elementAt(i);
						shapes.setSelect(0);
					}
					if( GraphicsEdit.tool.select_mode == true)
					{
						shape.setSelect(3);
					}
					break;
				}
				else if((Math.abs(selecX - shape.x1) < 10 || Math.abs(selecX - shape.x2) < 10 
						|| Math.abs(selecY - shape.y1) < 10 || Math.abs(selecY - shape.y2) < 10))
				{	//��踦 �������� ��� ������ ��ȯ�� �� �� �ִ� �غ� ����.
					for(i=figure.size() - 1 ; i >= 0 ;i--)
					{
						DrawContents shapes=(DrawContents)figure.elementAt(i);
						shapes.setSelect(0);
					}
					shape.setSelect(2);
					break;
				}
				else 
				{
					shape.setSelect(0); // ���õ��� ����
				}
			}
			repaint();
		}
	}	

	class MouseMotionListen extends MouseMotionAdapter 
	{
		public void mouseDragged(MouseEvent e)			 // ���콺�� �巡�� �� ���� ����
		{	
			
			//last_index = 0;
			x2=e.getX(); // x��ǥ�� x2�� �Ҵ�
			y2=e.getY(); // y��ǥ�� y2�� �Ҵ�
			setPoly();
			width=Math.max(x1, x2)-Math.min(x1, x2);
			height=Math.max(y1, y2)-Math.min(y1, y2);
			
			if(myfunc == 0)														// ���� ���
			{
				DrawContents drawContents2=new DrawContents(x1, y1, x2, y2, width, height, color,myfunc,  fill,stroke,stroke2,styles);
				//���� ������ ������ ��üȭ
				figure.add(drawContents2); // ���Ϳ� ���� ���� ����.
				x1=x2; // �巡�� �Ҷ��� x2��ǥ�� x1�� �Ҵ�(�� ������ ������ �濪���� �� �� ����)
				y1=y2; // �巡�� �Ҷ��� y2��ǥ�� y1�� �Ҵ�
			}
			if(myfunc == 1)					    								// ���찳�� ���
			{
				DrawContents drawContents2=new DrawContents(x1, y1, x2, y2, width, height, color,myfunc,  fill,stroke,stroke2,styles);
				//���� ������ ������ ��üȭ
				figure.add(drawContents2); // ���Ϳ� ���� ���� ����.
				x1=x2; // �巡�� �Ҷ��� x2��ǥ�� x1�� �Ҵ�(�� ������ ������ ���찳������ �� �� ����)
				y1=y2; // �巡�� �Ҷ��� y2��ǥ�� y1�� �Ҵ�
			}
			
			for(int i=0;i<figure.size();i++) {
				DrawContents shape=(DrawContents)figure.elementAt(i);
				if(myfunc == 11)
				{	// ����
					if(shape.getSelect()==2) {	// i��° ������ ũ�⺯ȯ�� ���� ���� �ƴٸ�
						shape.x2=x2; // �巡���� x2��ǥ���� i��° ������ x2��ǥ�� �Ҵ�
						shape.y2=y2; // �巡���� y2��ǥ���� i��° ������ y2��ǥ�� �Ҵ�
						if(x2>=shape.x1) // �巡�� �� x2���� ������ ���� x1������ ũ�ų� ���ٸ�
							shape.width=x2-shape.x1; // ������ ���α��̴� x2���� ���� ������ x1�� �� ���� �Ҵ�
						else //  �巡�� �� x2���� ������ ���� x1������ �۴ٸ�
							shape.width=shape.x1-x2; // ������ ���α��̴� ���� �ݴ�
						if(y2>=shape.y1) //  �巡�� �� y2���� ������ ���� y1������ ũ�ų� ���ٸ� 
							shape.height=y2-shape.y1; // ������ ���̴� y2���� ���� ������ y1�� �� ���� �Ҵ�
						else // //  �巡�� �� y2���� ������ ���� y1������ �۴ٸ�
							shape.height=shape.y1-y2; // ������ ���̴� ���� �ݴ�
						
					}
					if(shape.getSelect()==3) { 	// i��° ������ �̵��� ���� ���� �ƴٸ�
						shape.x1=x2-shape.width/2;
						shape.y1=y2-shape.height/2;
						shape.x2=x2+shape.width/2; 
						shape.y2=y2+shape.height/2;
						// ������ �� �������� �巡�� ���� ��ǥ ���� �߽����� �̵�
						// Polygon Method ������ �ʱ�ȭ
						if(shape.function == 6)
						{
							shape.xP = new int[]{shape.x1,shape.x1,shape.x2};
							shape.yP = new int[]{shape.y1,shape.y2,shape.y2};
						}
						else if(shape.function == 7)
						{
							shape.xP = new int[]{(shape.x1+shape.x2)/2,shape.x1,shape.x2};
							shape.yP = new int[]{shape.y1,shape.y2,shape.y2};
						}
						else if(shape.function == 8)
						{
							shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1, (shape.x1+shape.x2)/2, shape.x2};
							shape.yP = new int[]{shape.y1, (shape.y1+shape.y2)/2, shape.y2, (shape.y1+shape.y2)/2};
						}
						else if(shape.function == 9)
						{
							shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1,(((shape.x1+shape.x2)/2)+shape.x1)/2 ,
									(((shape.x1+shape.x2)/2)+shape.x2)/2, shape.x2};
							shape.yP = new int[]{shape.y1,(shape.y1+shape.y2)/2, shape.y2,shape.y2,(shape.y1+shape.y2)/2};
						}
						else if(shape.function == 10)
						{
							shape.xP = new int[]{(shape.x1+shape.x2)/2, shape.x1, shape.x1, (shape.x1+shape.x2)/2, shape.x2, shape.x2};
							shape.yP = new int[]{shape.y1, (int)(shape.y1 + ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))),
											(int)(shape.y2 - ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))),
											shape.y2, (int)(shape.y2 - ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2))))), 
												(int)(shape.y1 + ((int)(shape.y2-shape.y1)*(1/(2+Math.sqrt(2)))))};
						}
					}
				}
			}
			
			repaint();
		}
		
		public void mouseMoved(MouseEvent e)	 // ���콺�� ������ ���� ����
		{
			letsCursor();	// Ŀ�� ����
		}

	}
}