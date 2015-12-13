
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
	/* 객체의 정보를 저장할 변수 선언 */
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	int []xP;
	int []yP;
	int point = 0;
	int width = 0;
	int height = 0;					
	Color color;					// 컬러형 변수
	
	Vector figure;	// 벡터형의 변수
	
	private int myfunc = 0;

	int stroke = 3; 				// 기본 선두께
	int stroke2 = 5;				// 기본 지우개두께
	int styles=0;					// 기본 선스타일
	
	boolean fill= false;			// 채우기 기능 선택 유무를 판단하는 변수
	
	int selecX;
	int selecY;
	
	// 스탬프 이미지 설정
	ImageIcon img = new ImageIcon("image/stamp.png");
	ImageIcon img1 = new ImageIcon("image/seopstamp.png");
	ImageIcon img2 = new ImageIcon("image/ryunstamp.png");
	ImageIcon img3 = new ImageIcon("image/minstamp.png");
	ImageIcon img4 = new ImageIcon("image/dostamp.png");
	
	public DrawingPanel()
	{
		color = Color.BLACK;
		figure = new Vector();
		addMouseListener(new MouseListen()); 			// MouseListen에 마우스의 기능에 대한 실행 설정
		addMouseMotionListener(new MouseMotionListen());  
	}
	
	public void setFunc(int type) 
	{
		this.myfunc = type; 				// 선택한 메뉴를 지정
	}
	public int getMyFunc()
	{
		return myfunc;						// 선택메뉴 반환
	}

	
	public void letsCursor()				//커서 이미지를 각상황에 맞게 붙이기 위한 함수
	{
		DefinedCursor mycursor = new DefinedCursor();			//DefinedCursor형 변수 선언
		Toolkit toolkit = Toolkit.getDefaultToolkit();			//Toolkit형 변수 선언
		
		if(this.getMyFunc() == 0)								//연필일때
		{
			if(ToolPanel.sueCheckBox.isSelected() && ToolPanel.kyungCheckBox.isSelected())		//체크박스에 선택이 되었을경우
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
		
		else if(this.getMyFunc() == 1)				//연필일때
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
	
		else			//나머지 도형일때
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
		Graphics2D g2 = (Graphics2D) g; // stroke는 Graphic2D에 속해서 필요함
		if (GraphicsEdit.tool.return_mode == true) {
			painting(g);
		} else {
			// 선 스타일에 따라 직선, 점선, 불균등 점선, 원형 점선이 결정됨
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

			g.setColor(color); // 색설정

			// myfunc에 따라 기능분류
			if (myfunc == 0) {
				g.drawLine(x1, y1, x2, y2); // 펜그리기
				painting(g);
			} else if (myfunc == 1) {
				g.setColor(Color.WHITE); // 지우개
				g2.setStroke(new BasicStroke(stroke2, BasicStroke.CAP_ROUND, 0));
				g.drawLine(x1, y1, x2, y2);
				painting(g);
			} else if (myfunc == 2) {
				g.drawLine(x1, y1, x2, y2); // 직선
				painting(g);
			} else if (myfunc == 3) { // 사각형
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), width, height);
				painting(g);
			} else if (myfunc == 4) { // 둥근사각형
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
				
			} else if (myfunc == 5) { // 원
				if(fill == false)	
				{
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
				}
				else	// 채우기가 true 라면 채우기 도형
				{
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
				}
				
				painting(g);
			} else if (myfunc == 6) { // 직각삼각형
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
			} else if (myfunc == 7) { // 정삼각형
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
			} else if (myfunc == 8) { // 마름모
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

			else if (myfunc == 9) { // 오각형
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

			else if (myfunc == 10) { // 육각형
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
			else if (myfunc == 11) { // 선택하기
				painting(g);
			}
			else if (myfunc == 12){  // 색 채우기
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
	
	// Polygon 설정
	/* myfunc 값이  6일때 : 직각삼각형
	 * 			  7일때 : 정삼각형
	 * 			  8일때 : 마름모
	 * 			  9일때 : 오각형
	 * 			 10일때 : 육각형  */
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
			
			// 선 스타일에 따라 직선, 점선, 불균등 점선, 원형 점선이 결정됨
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
			
			
			if(shape.function == 0)													// 펜그리기
			{
				g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
			}
			else if(shape.function == 1)											// 지우개
			{
				g.setColor(Color.white);
				g2.setStroke(new BasicStroke(shape.stroke2,  BasicStroke.CAP_ROUND,0));
				g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
			}
			else if(shape.function == 2) 											//직선
			{
				g.drawLine(shape.x1,shape.y1,shape.x2,shape.y2);
				// 선택모드일때 selectMark Method() 호출
				if(myfunc ==11 && GraphicsEdit.tool.fill_mode == false)
					selectMark(shape,g);
			}
			
			else if(shape.function == 3) 											//사각형
			{
				if(shape.fill == false) // 채우기 버튼 선택유무에따라 결정
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
			else if(shape.function == 4) 											//둥근사각형
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
			else if(shape.function == 5)											 //원
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
			
			else if(shape.function == 6)											// 직각삼각형
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
			else if(shape.function == 7)											// 정삼각형
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
			else if(shape.function == 8)											// 마름모
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
			
			else if(shape.function == 9)											// 오각형
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
			else if(shape.function == 10)											// 육각형
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
				g.drawImage(shape.img.getImage(), shape.x1-70, shape.y1-70, this); 	//마우스커서가 스탬프에 중앙에 오도록
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
			// i번째 도형이 선택되었다면(1:지우기위한 선택, 2:사이즈 변환을 위한 선택, 3:이동을 위한 선택)
			g.setColor(Color.black);
			g.fillRect(shape.x1-3, shape.y1-3, 6, 6); // i번째 도형의 각 꼭지점, 각변의 중심에 네모점을 그림 
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
		public void mousePressed(MouseEvent e) 			// 마우스를 눌렀을 때
		{	
			x1=e.getX(); // x좌표가 x1로 할당
			y1=e.getY(); // y좌표가 y1로 할당
			
			if(myfunc== 15 || myfunc==16 || myfunc==17 || myfunc==18 || myfunc==19)		//스탬프 점을 figure에 추가
			{	
				DrawContents drawContents = new DrawContents(img,x1, y1 , 0,0, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
		}
		
		public void mouseReleased(MouseEvent e) 		//마우스를 땔 때
		{	
			x2=e.getX(); // x좌표가 x2로 할당
			y2=e.getY(); // y좌표가 y2로 할당
			width=Math.max(x1, x2)-Math.min(x1, x2); 	// 너비를 구함
			height=Math.max(y1, y2)-Math.min(y1, y2); 	// 높이를 구함

			setPoly();
			if(myfunc == 3 || myfunc == 4 || myfunc == 5 )						// 사각형, 둥근사각형, 원 인 경우
			{
				// 현재 도형에 대한 정보를 객체화
				DrawContents drawContents = new DrawContents(Math.min(x1,x2), Math.min(y1, y2),Math.max(x1, x2),
											Math.max(y1, y2), width, height, color,myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents); // 백터에 위 정보를 더함
			}
			else if(myfunc== 2)													// 지우개일 경우
			{
				DrawContents drawContents = new DrawContents(x1, y1, x2, y2, width, height, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
			else if(myfunc== 1)													// 선일 경우
			{
				DrawContents drawContents = new DrawContents(x1, y1, x2, y2, width, height, color, myfunc, fill,stroke,stroke2,styles);
				figure.add(drawContents);
			}
			else if(myfunc == 6 || myfunc == 7 || myfunc == 8 || myfunc ==9 || myfunc ==10 )	// 직각삼각형,정삼각형,마름모,육각형일 경우
			{
				DrawContents drawContents=new DrawContents(x1, y1, x2, y2, xP, yP ,width, height, point,  color,myfunc,  fill,stroke,styles);
				figure.add(drawContents);
			}
			repaint();
			
		}
		
		public void mouseClicked(MouseEvent e)				//마우스를 클릭했을 때
		{ 	
			selecX=e.getX(); // x좌표가 selecX에 할당
			selecY=e.getY(); // y좌표가 selecY에 할당

			width=Math.max(x1, x2)-Math.min(x1, x2);
			height=Math.max(y1, y2)-Math.min(y1, y2);
			
			if(myfunc== 15 || myfunc==16 || myfunc==17 || myfunc==18|| myfunc==19)			//스탬프일 경우
			{	
				DrawContents drawContents = new DrawContents(img , x1, y1 , width, height, color, myfunc, fill, stroke, stroke2, styles);
				figure.add(drawContents);
			}
			if(GraphicsEdit.tool.fill_mode == true)		//채우기모드가 true일 경우
			{
				for(int i = figure.size() - 1; i >= 0 ;i--) 
				{
					DrawContents shape=(DrawContents)figure.elementAt(i);

					if(selecX > shape.x1 && selecX < shape.x2 && selecY > shape.y1 && selecY < shape.y2)	// 클릭한 영역이 도형 내부일 경우
					{
						shape.color = color;//가장 최근에 그려진 객체의 색깔을 설정.
						shape.fill = true;
						break;
					}
					repaint();
				}
			}
			
			for(int i=figure.size() - 1 ; i >= 0 ;i--) {
				DrawContents shape=(DrawContents)figure.elementAt(i);
				if(selecX > shape.x1 && selecX < shape.x2 && selecY > shape.y1 && selecY < shape.y2)//클릭한 영역이 도형 내부일 경우
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
				{	//경계를 선택했을 경우 사이즈 변환을 할 수 있는 준비를 해줌.
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
					shape.setSelect(0); // 선택되지 않음
				}
			}
			repaint();
		}
	}	

	class MouseMotionListen extends MouseMotionAdapter 
	{
		public void mouseDragged(MouseEvent e)			 // 마우스를 드래그 할 때의 상태
		{	
			
			//last_index = 0;
			x2=e.getX(); // x좌표가 x2로 할당
			y2=e.getY(); // y좌표가 y2로 할당
			setPoly();
			width=Math.max(x1, x2)-Math.min(x1, x2);
			height=Math.max(y1, y2)-Math.min(y1, y2);
			
			if(myfunc == 0)														// 펜인 경우
			{
				DrawContents drawContents2=new DrawContents(x1, y1, x2, y2, width, height, color,myfunc,  fill,stroke,stroke2,styles);
				//현재 도형의 정보를 객체화
				figure.add(drawContents2); // 백터에 위의 값을 더함.
				x1=x2; // 드래그 할때의 x2좌표를 x1에 할당(이 때문에 직선이 펜역할을 할 수 있음)
				y1=y2; // 드래그 할때의 y2좌표를 y1에 할당
			}
			if(myfunc == 1)					    								// 지우개인 경우
			{
				DrawContents drawContents2=new DrawContents(x1, y1, x2, y2, width, height, color,myfunc,  fill,stroke,stroke2,styles);
				//현재 도형의 정보를 객체화
				figure.add(drawContents2); // 백터에 위의 값을 더함.
				x1=x2; // 드래그 할때의 x2좌표를 x1에 할당(이 때문에 직선이 지우개역할을 할 수 있음)
				y1=y2; // 드래그 할때의 y2좌표를 y1에 할당
			}
			
			for(int i=0;i<figure.size();i++) {
				DrawContents shape=(DrawContents)figure.elementAt(i);
				if(myfunc == 11)
				{	// 선택
					if(shape.getSelect()==2) {	// i번째 도형이 크기변환을 위해 선택 됐다면
						shape.x2=x2; // 드래그한 x2좌표값을 i번째 도형의 x2좌표로 할당
						shape.y2=y2; // 드래그한 y2좌표값을 i번째 도형의 y2좌표로 할당
						if(x2>=shape.x1) // 드래그 한 x2값이 도형의 원래 x1값보다 크거나 같다면
							shape.width=x2-shape.x1; // 도형의 가로길이는 x2에서 원래 도형의 x1를 뺀 값을 할당
						else //  드래그 한 x2값이 도형의 원래 x1값보다 작다면
							shape.width=shape.x1-x2; // 도형의 가로길이는 위와 반대
						if(y2>=shape.y1) //  드래그 한 y2값이 도형의 원래 y1값보다 크거나 같다면 
							shape.height=y2-shape.y1; // 도형의 높이는 y2에서 원래 도형의 y1를 뺀 값을 할당
						else // //  드래그 한 y2값이 도형의 원래 y1값보다 작다면
							shape.height=shape.y1-y2; // 도형의 높이는 위와 반대
						
					}
					if(shape.getSelect()==3) { 	// i번째 도형이 이동을 위해 선택 됐다면
						shape.x1=x2-shape.width/2;
						shape.y1=y2-shape.height/2;
						shape.x2=x2+shape.width/2; 
						shape.y2=y2+shape.height/2;
						// 도형의 각 꼭지점은 드래그 중인 좌표 값을 중심으로 이동
						// Polygon Method 변수값 초기화
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
		
		public void mouseMoved(MouseEvent e)	 // 마우스를 움직일 때의 상태
		{
			letsCursor();	// 커서 설정
		}

	}
}