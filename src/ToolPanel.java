
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToolPanel extends JPanel implements ActionListener {
	JToggleButton fPen,eraser,fLine,fRect,fRoundRect,fOval,fRTri,fTri,fDia,fHex,fPenta,fill,select;
	ButtonGroup button = new ButtonGroup();	// 기능버튼을 한그룹으로 만들기위한 ButtonGroup 객체
	static JCheckBox sueCheckBox, kyungCheckBox, minCheckBox, hoonCheckBox;		// 마우스 커서 체크박스 변수
	static boolean return_mode = false;	// 실행취소버튼의 선택유무를 판단하는 변수
	static boolean fill_mode = false;		// 채우기버튼의 선택유무를 판단하는 변수
	static boolean select_mode = false;	// 선택버튼의 선택유무를 판단하는 변수
	JButton retn;
	int f=0;
	
	JComboBox WidthList;
	JComboBox LineStyle;
	
	private static final int[] strokes={3,5,7,10};	// 선굵기의 값을 저장해둔 배열
	private static final int[] strokes2={5,7,10,15};	// 지우개의 굵기의 값을 저장해둔 배열
	
	private static final int[] style={0,1,2,3};	// 선스타일의 값을 저장해둔 배열
	
	public ToolPanel()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 30,5));
        setPreferredSize(new Dimension(100,0));
        setBorder(BorderFactory.createEtchedBorder());
        Dimension size = new Dimension(40, 40);
    	
        /* 기능버튼들을 합치기위한 Tool Panel 생성 
         * 이 객체의 Layout 은 GridLayout */
        
        JPanel Tool = new JPanel();
        
        Tool.setLayout(new GridLayout(7,2));
        Tool.setBorder(BorderFactory.createRaisedBevelBorder());
        Tool.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Tool);
        
        fPen = new JToggleButton(new ImageIcon(((new ImageIcon("image/pen.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
        fPen.addActionListener(this);
        fPen.setToolTipText("펜그리기");
        fPen.setSelectedIcon(new ImageIcon(((new ImageIcon("image/pen2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
        fPen.setPreferredSize(size);
        Tool.add(fPen);
        
        eraser = new JToggleButton(new ImageIcon(((
        							new ImageIcon("image/eraser.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//지우개 버튼 생성
		eraser.addActionListener(this);
		eraser.setToolTipText("지우개");
		eraser.setSelectedIcon(new ImageIcon(((new ImageIcon("image/eraser2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		eraser.setPreferredSize(size);
		Tool.add(eraser );//지우개 버튼 추가
		
        
        fLine = new JToggleButton(new ImageIcon(((
        							new ImageIcon("image/line.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//선을 그리는 버튼 생성
        fLine.addActionListener(this);
        fLine.setToolTipText("선그리기");
		fLine.setSelectedIcon(new ImageIcon(((new ImageIcon("image/line2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fLine.setPreferredSize(size);
		Tool.add(fLine);
		
		fDia =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/dia.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//마름모 버튼 생성
		fDia.addActionListener(this);
		fDia.setToolTipText("마름모");
		fDia.setSelectedIcon(new ImageIcon(((new ImageIcon("image/dia2.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fDia.setPreferredSize(size);
		Tool.add(fDia);
		
		fRect =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/square.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//직사각형 그리는 버튼 생성
		fRect.addActionListener(this);
		fRect.setToolTipText("사각형");
		fRect.setSelectedIcon(new ImageIcon(((new ImageIcon("image/square2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRect.setPreferredSize(size);
		Tool.add(fRect);
		
		fRoundRect = new JToggleButton(new ImageIcon(((
								new ImageIcon("image/rsquare.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//둥근사각형 그리는 버튼 생성
		fRoundRect.addActionListener(this);
		fRoundRect.setToolTipText("둥근사각형");
		fRoundRect.setSelectedIcon(new ImageIcon(((new ImageIcon("image/rsquare2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRoundRect.setPreferredSize(size);
		Tool.add(fRoundRect);

		
		fRTri =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/tri.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//직각삼각형 버튼 생성
		fRTri.addActionListener(this);
		fRTri.setToolTipText("직각삼각형");
		fRTri.setSelectedIcon(new ImageIcon(((new ImageIcon("image/tri2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRTri.setPreferredSize(size);
		Tool.add(fRTri);
		
		fTri =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/ptri.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));// 정삼각형 버튼 생성
		fTri.addActionListener(this);
		fTri.setToolTipText("정삼각형");
		fTri.setSelectedIcon(new ImageIcon(((new ImageIcon("image/ptri2.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fTri.setPreferredSize(size);
		Tool.add(fTri);
		
		
		fOval =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/round.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//원그리는 버튼 생성
		fOval.addActionListener(this);
		fOval.setToolTipText("원");
		fOval.setSelectedIcon(new ImageIcon(((new ImageIcon("image/round2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fOval.setPreferredSize(size);
		Tool.add(fOval);

		fPenta=new JToggleButton(new ImageIcon(((
								new ImageIcon("image/pen.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//오각형그리는 버튼 생성
		fPenta.addActionListener(this);
		fPenta.setToolTipText("오각형");
		fPenta.setSelectedIcon(new ImageIcon(((new ImageIcon("image/penta2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fPenta.setPreferredSize(size);
		Tool.add(fPenta);
		
		fHex =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/hex.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//육각형그리는 버튼 생성
		fHex.addActionListener(this);
		fHex.setToolTipText("육각형");
		fHex.setSelectedIcon(new ImageIcon(((new ImageIcon("image/hex2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fHex.setPreferredSize(size);
		Tool.add(fHex);
		
		fill =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/fill.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//채우기 버튼 생성
		fill.addActionListener(this);
		fill.setToolTipText("채우기");
		fill.setSelectedIcon(new ImageIcon(((new ImageIcon("image/fill2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fill.setPreferredSize(size);
		Tool.add(fill);
		
		retn =new JButton(new ImageIcon(((
								new ImageIcon("image/return2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//실행취소 버튼 생성
		retn.addActionListener(this);
		retn.setToolTipText("되돌리기");
		retn.setRolloverIcon(new ImageIcon(((new ImageIcon("image/return.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		retn.setPreferredSize(size);
		retn.setMnemonic('z');	// 단축키 설정
		Tool.add(retn);
		
		select =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/select.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//선택 버튼 생성
		select.addActionListener(this);
		select.setToolTipText("선택");
		select.setSelectedIcon(new ImageIcon(((new ImageIcon("image/select2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		select.setPreferredSize(size);
		Tool.add(select);

	/*	여러 기능 버튼들을 Group로 묶어 중복 선택이 불가능하도록 한다.	*/
		button.add(fPen);
		button.add(eraser);
		button.add(fLine);
		button.add(fRect);
		button.add(fRoundRect);
		button.add(fOval);
		button.add(fRTri);
		button.add(fTri);
		button.add(fDia);
		button.add(fHex);
		button.add(fPenta);
		button.add(fill);
		button.add(select);
		
		
		// 선두께 ComboBox
		Object[] items=
			{
				new ImageIcon("image/1.png"),
				new ImageIcon("image/3.png"),
				new ImageIcon("image/5.png"),
				new ImageIcon("image/10.png")
			};
		WidthList = new JComboBox(items);
		WidthList.setMaximumRowCount(4);
		WidthList.setPreferredSize(new Dimension(95,30));
		WidthList.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e) {
					 if(e.getStateChange() == ItemEvent.SELECTED)
						{
							GraphicsEdit.painter.stroke=strokes[WidthList.getSelectedIndex()];		//선의경우
							GraphicsEdit.painter.stroke2=strokes2[WidthList.getSelectedIndex()];	//지우개의경우
						}
					}
				}
			);
		
		WidthList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(WidthList);
		

		// 선스타일ComboBox
		Object[] styles=
			{
				new ImageIcon("image/linest.png"),
				new ImageIcon("image/lined.png"),
				new ImageIcon("image/linesp.png"),
				new ImageIcon("image/linedo.png")
			};
		LineStyle = new JComboBox(styles);
		LineStyle.setMaximumRowCount(4);
		LineStyle.setPreferredSize(new Dimension(95,20));
		LineStyle.addItemListener(
				new ItemListener()
				{

					public void itemStateChanged(ItemEvent e) {
					 if(e.getStateChange() == ItemEvent.SELECTED)
						{
							GraphicsEdit.painter.styles=style[LineStyle.getSelectedIndex()];
						}
					}
				}
			);
		LineStyle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(LineStyle);
		
		sueCheckBox = new JCheckBox("Minn's");
	    sueCheckBox.addActionListener(this);
	    kyungCheckBox = new JCheckBox("Ryun's");
	    kyungCheckBox.addActionListener(this);
	    minCheckBox = new JCheckBox("Seop's");
	    minCheckBox.addActionListener(this);
	    hoonCheckBox = new JCheckBox("Hoon's");
	    hoonCheckBox.addActionListener(this);
	    add(sueCheckBox);
	    add(kyungCheckBox);
	    add(minCheckBox);
	    add(hoonCheckBox);
	    
	    CheckBoxHandler handler = new CheckBoxHandler();
	    sueCheckBox.addItemListener( handler );
	    kyungCheckBox.addItemListener( handler );
	    minCheckBox.addItemListener( handler );	
	    hoonCheckBox.addItemListener( handler );	
	}
	
	public class CheckBoxHandler implements ItemListener
	{
		DefinedCursor _mycursor = new DefinedCursor();					//DefinedCursor형 변수 선언
		public void itemStateChanged( ItemEvent event )
		{
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )			//체크박스가 선택되었을 경우
				setCursor(_mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(_mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(_mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(_mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(_mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.HAND_CURSOR));
					
		}
	}
	/* 각버튼이 선택되었을때 실행할 작업 설정 */
	public void actionPerformed(ActionEvent e) {
		DefinedCursor mycursor = new DefinedCursor();
		if(e.getSource() == this.fPen)
		{
			GraphicsEdit.painter.setFunc(0); 
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(mycursor.getinit(0));

			fill_mode = false;
			return_mode = false;
		}
		
		else if(e.getSource() == this.eraser)
		{
			GraphicsEdit.painter.setFunc(1); 
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(mycursor.getinit(1));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fLine)
		{
			GraphicsEdit.painter.setFunc(2);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fRect)
		{
			GraphicsEdit.painter.setFunc(3);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		
		else if(e.getSource() == this.fRoundRect)
		{
			GraphicsEdit.painter.setFunc(4);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fOval)
		{
			GraphicsEdit.painter.setFunc(5);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fRTri)
		{
			GraphicsEdit.painter.setFunc(6);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}

		else if(e.getSource() == this.fTri)
		{
			GraphicsEdit.painter.setFunc(7);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fDia)
		{
			GraphicsEdit.painter.setFunc(8);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fPenta)
		{
			GraphicsEdit.painter.setFunc(9);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			
			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.fHex)
		{
			GraphicsEdit.painter.setFunc(10);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			
			fill_mode = false;
			return_mode = false;
		}
		else if(e.getSource() == this.select)
		{
			GraphicsEdit.painter.setFunc(11);
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			
			select_mode = true;
			return_mode = false;
			fill_mode = false;
		}
		
		else if(e.getSource() == this.fill)
		{
			GraphicsEdit.painter.setFunc(12);
			
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
				setCursor(mycursor.getinit(5));
			else if( sueCheckBox.isSelected())
				setCursor(mycursor.getinit(2));
			else if( kyungCheckBox.isSelected())
				setCursor(mycursor.getinit(4));
			else if( minCheckBox.isSelected())
				setCursor(mycursor.getinit(3));
			else if( hoonCheckBox.isSelected())
				setCursor(mycursor.getinit(6));
			else
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			fill_mode = true;
			select_mode = false;
			return_mode = false;
		}	
		else if(e.getSource() == this.retn)
		{
			if(GraphicsEdit.painter.figure.size() != 0)
			{
				int i = GraphicsEdit.painter.figure.size();//i에 객체의 사이즈를 저장함.
				DrawContents drawContent = (DrawContents)GraphicsEdit.painter.figure.elementAt(i - 1);	// 마지막 객체를 저장함
				if(drawContent.function == 1)//객체속성이 펜일 경우
				{
					for(i = GraphicsEdit.painter.figure.size() - 1 ; i >= 0 ; i--)//객체를 연속으로 삭제(펜은 여러 객체의 모임으로 그려지기 때문에)
					{
						DrawContents drawContents = (DrawContents)GraphicsEdit.painter.figure.elementAt(i);
						if(drawContents.function == 1)
							GraphicsEdit.painter.figure.remove(i);
						else
							break;
					}
				}
				else
					GraphicsEdit.painter.figure.remove(i-1);//펜이 아닐경우 객체 하나만 삭제
				
				if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )
					setCursor(mycursor.getinit(5));
				else if( sueCheckBox.isSelected())
					setCursor(mycursor.getinit(2));
				else if( kyungCheckBox.isSelected())
					setCursor(mycursor.getinit(4));
				else if( minCheckBox.isSelected())
					setCursor(mycursor.getinit(3));
				else if( hoonCheckBox.isSelected())
					setCursor(mycursor.getinit(6));
				else
					setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
			return_mode = true;
			GraphicsEdit.painter.repaint();//다시 그리기
		}
	}
}