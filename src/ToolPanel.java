
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
	ButtonGroup button = new ButtonGroup();	// ��ɹ�ư�� �ѱ׷����� ��������� ButtonGroup ��ü
	static JCheckBox sueCheckBox, kyungCheckBox, minCheckBox, hoonCheckBox;		// ���콺 Ŀ�� üũ�ڽ� ����
	static boolean return_mode = false;	// ������ҹ�ư�� ���������� �Ǵ��ϴ� ����
	static boolean fill_mode = false;		// ä����ư�� ���������� �Ǵ��ϴ� ����
	static boolean select_mode = false;	// ���ù�ư�� ���������� �Ǵ��ϴ� ����
	JButton retn;
	int f=0;
	
	JComboBox WidthList;
	JComboBox LineStyle;
	
	private static final int[] strokes={3,5,7,10};	// �������� ���� �����ص� �迭
	private static final int[] strokes2={5,7,10,15};	// ���찳�� ������ ���� �����ص� �迭
	
	private static final int[] style={0,1,2,3};	// ����Ÿ���� ���� �����ص� �迭
	
	public ToolPanel()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 30,5));
        setPreferredSize(new Dimension(100,0));
        setBorder(BorderFactory.createEtchedBorder());
        Dimension size = new Dimension(40, 40);
    	
        /* ��ɹ�ư���� ��ġ������ Tool Panel ���� 
         * �� ��ü�� Layout �� GridLayout */
        
        JPanel Tool = new JPanel();
        
        Tool.setLayout(new GridLayout(7,2));
        Tool.setBorder(BorderFactory.createRaisedBevelBorder());
        Tool.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Tool);
        
        fPen = new JToggleButton(new ImageIcon(((new ImageIcon("image/pen.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH))); 
        fPen.addActionListener(this);
        fPen.setToolTipText("��׸���");
        fPen.setSelectedIcon(new ImageIcon(((new ImageIcon("image/pen2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
        fPen.setPreferredSize(size);
        Tool.add(fPen);
        
        eraser = new JToggleButton(new ImageIcon(((
        							new ImageIcon("image/eraser.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//���찳 ��ư ����
		eraser.addActionListener(this);
		eraser.setToolTipText("���찳");
		eraser.setSelectedIcon(new ImageIcon(((new ImageIcon("image/eraser2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		eraser.setPreferredSize(size);
		Tool.add(eraser );//���찳 ��ư �߰�
		
        
        fLine = new JToggleButton(new ImageIcon(((
        							new ImageIcon("image/line.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//���� �׸��� ��ư ����
        fLine.addActionListener(this);
        fLine.setToolTipText("���׸���");
		fLine.setSelectedIcon(new ImageIcon(((new ImageIcon("image/line2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fLine.setPreferredSize(size);
		Tool.add(fLine);
		
		fDia =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/dia.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//������ ��ư ����
		fDia.addActionListener(this);
		fDia.setToolTipText("������");
		fDia.setSelectedIcon(new ImageIcon(((new ImageIcon("image/dia2.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fDia.setPreferredSize(size);
		Tool.add(fDia);
		
		fRect =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/square.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//���簢�� �׸��� ��ư ����
		fRect.addActionListener(this);
		fRect.setToolTipText("�簢��");
		fRect.setSelectedIcon(new ImageIcon(((new ImageIcon("image/square2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRect.setPreferredSize(size);
		Tool.add(fRect);
		
		fRoundRect = new JToggleButton(new ImageIcon(((
								new ImageIcon("image/rsquare.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//�ձٻ簢�� �׸��� ��ư ����
		fRoundRect.addActionListener(this);
		fRoundRect.setToolTipText("�ձٻ簢��");
		fRoundRect.setSelectedIcon(new ImageIcon(((new ImageIcon("image/rsquare2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRoundRect.setPreferredSize(size);
		Tool.add(fRoundRect);

		
		fRTri =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/tri.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//�����ﰢ�� ��ư ����
		fRTri.addActionListener(this);
		fRTri.setToolTipText("�����ﰢ��");
		fRTri.setSelectedIcon(new ImageIcon(((new ImageIcon("image/tri2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fRTri.setPreferredSize(size);
		Tool.add(fRTri);
		
		fTri =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/ptri.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));// ���ﰢ�� ��ư ����
		fTri.addActionListener(this);
		fTri.setToolTipText("���ﰢ��");
		fTri.setSelectedIcon(new ImageIcon(((new ImageIcon("image/ptri2.jpg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fTri.setPreferredSize(size);
		Tool.add(fTri);
		
		
		fOval =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/round.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//���׸��� ��ư ����
		fOval.addActionListener(this);
		fOval.setToolTipText("��");
		fOval.setSelectedIcon(new ImageIcon(((new ImageIcon("image/round2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fOval.setPreferredSize(size);
		Tool.add(fOval);

		fPenta=new JToggleButton(new ImageIcon(((
								new ImageIcon("image/pen.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//�������׸��� ��ư ����
		fPenta.addActionListener(this);
		fPenta.setToolTipText("������");
		fPenta.setSelectedIcon(new ImageIcon(((new ImageIcon("image/penta2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fPenta.setPreferredSize(size);
		Tool.add(fPenta);
		
		fHex =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/hex.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//�������׸��� ��ư ����
		fHex.addActionListener(this);
		fHex.setToolTipText("������");
		fHex.setSelectedIcon(new ImageIcon(((new ImageIcon("image/hex2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fHex.setPreferredSize(size);
		Tool.add(fHex);
		
		fill =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/fill.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//ä��� ��ư ����
		fill.addActionListener(this);
		fill.setToolTipText("ä���");
		fill.setSelectedIcon(new ImageIcon(((new ImageIcon("image/fill2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		fill.setPreferredSize(size);
		Tool.add(fill);
		
		retn =new JButton(new ImageIcon(((
								new ImageIcon("image/return2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//������� ��ư ����
		retn.addActionListener(this);
		retn.setToolTipText("�ǵ�����");
		retn.setRolloverIcon(new ImageIcon(((new ImageIcon("image/return.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		retn.setPreferredSize(size);
		retn.setMnemonic('z');	// ����Ű ����
		Tool.add(retn);
		
		select =new JToggleButton(new ImageIcon(((
								new ImageIcon("image/select.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		select.addActionListener(this);
		select.setToolTipText("����");
		select.setSelectedIcon(new ImageIcon(((new ImageIcon("image/select2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		select.setPreferredSize(size);
		Tool.add(select);

	/*	���� ��� ��ư���� Group�� ���� �ߺ� ������ �Ұ����ϵ��� �Ѵ�.	*/
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
		
		
		// ���β� ComboBox
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
							GraphicsEdit.painter.stroke=strokes[WidthList.getSelectedIndex()];		//���ǰ��
							GraphicsEdit.painter.stroke2=strokes2[WidthList.getSelectedIndex()];	//���찳�ǰ��
						}
					}
				}
			);
		
		WidthList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(WidthList);
		

		// ����Ÿ��ComboBox
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
		DefinedCursor _mycursor = new DefinedCursor();					//DefinedCursor�� ���� ����
		public void itemStateChanged( ItemEvent event )
		{
			if( sueCheckBox.isSelected() && kyungCheckBox.isSelected() )			//üũ�ڽ��� ���õǾ��� ���
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
	/* ����ư�� ���õǾ����� ������ �۾� ���� */
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
				int i = GraphicsEdit.painter.figure.size();//i�� ��ü�� ����� ������.
				DrawContents drawContent = (DrawContents)GraphicsEdit.painter.figure.elementAt(i - 1);	// ������ ��ü�� ������
				if(drawContent.function == 1)//��ü�Ӽ��� ���� ���
				{
					for(i = GraphicsEdit.painter.figure.size() - 1 ; i >= 0 ; i--)//��ü�� �������� ����(���� ���� ��ü�� �������� �׷����� ������)
					{
						DrawContents drawContents = (DrawContents)GraphicsEdit.painter.figure.elementAt(i);
						if(drawContents.function == 1)
							GraphicsEdit.painter.figure.remove(i);
						else
							break;
					}
				}
				else
					GraphicsEdit.painter.figure.remove(i-1);//���� �ƴҰ�� ��ü �ϳ��� ����
				
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
			GraphicsEdit.painter.repaint();//�ٽ� �׸���
		}
	}
}