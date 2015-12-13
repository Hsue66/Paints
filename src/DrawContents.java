
import java.awt.Color;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class DrawContents implements Serializable // ������ ����ȭ
{   
   public int x1, x2, y1, y2, width, height, function;    // int�� ����
   Color color;                                 //Color�� ����
   
   int []xP = new int[GraphicsEdit.painter.point];         // polygon�� x�� y ��ǥ
   int []yP = new int[GraphicsEdit.painter.point];
   int point;                                    // polygon�� ���� ��
   
   public boolean fill; // boolean�� ����
   private int select = 0; // ���ÿ��� �ʱ�ȭ(���þȵ�)
   
   int stroke;                              // ���β��� ���ϴ� stroke
   int stroke2;                              // ���찳 �β��� ���ϴ� stroke
   int styles;                              // �� ��Ÿ�� ����
   
   ImageIcon img;                                    // image ����

   
   public DrawContents(int x1,int y1,int x2,int y2, int w,int h,Color color,
                  int func, boolean fill, int stroke,int stroke2,int styles) // �⺻ ������
   {
      // ���� �ʱ�ȭ
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.height = h;
      this.width = w;
      this.color = color;
      this.function = func;
      this.fill = fill;
      this.stroke = stroke;
      this.stroke2 = stroke2;
      this.styles = styles;
   }
   
   public DrawContents(int x1, int y1, int x2, int y2, int []xP, int[]yP, int w, int h, int point, Color color,int func, 
                                 boolean fill,int stroke,int styles)   // polygon ������
   {
      // ���� �ʱ�ȭ      
      for(int i=0 ; i< point ; i++)
      {
         this.xP[i] = xP[i];
         this.yP[i] = yP[i];
      }
      
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.point = point;
      this.color = color;
      this.function = func;
      this.fill = fill;
      this.stroke = stroke;
      this.styles = styles;
   }
   public DrawContents(ImageIcon img, int x1, int y1, int w,int h,Color color,	// stamp ������
                  int func, boolean fill, int stroke,int stroke2,int styles)
   {
	   this.img = img;
	   this.x1 = x1;
	   this.y1 = y1;
	   this.height = h;
	   this.width = w;
	   this.color = color;
	   this.function = func;
	   this.fill = fill;
	   this.stroke = stroke;
	   this.stroke2 = stroke2;
	   this.styles = styles;	 
   }
   public int getSelect() {
		return select;	// ������ ������ ��ȯ
	}

	public void setSelect(int select) {
		this.select = select;	// � ������ ���������� int������ ����
	}
}