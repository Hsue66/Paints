
import java.awt.Color;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class DrawContents implements Serializable // 변수의 직렬화
{   
   public int x1, x2, y1, y2, width, height, function;    // int형 변수
   Color color;                                 //Color형 변수
   
   int []xP = new int[GraphicsEdit.painter.point];         // polygon의 x와 y 좌표
   int []yP = new int[GraphicsEdit.painter.point];
   int point;                                    // polygon의 점의 수
   
   public boolean fill; // boolean형 변수
   private int select = 0; // 선택여부 초기화(선택안됨)
   
   int stroke;                              // 선두께를 정하는 stroke
   int stroke2;                              // 지우개 두께를 정하는 stroke
   int styles;                              // 선 스타일 변수
   
   ImageIcon img;                                    // image 변수

   
   public DrawContents(int x1,int y1,int x2,int y2, int w,int h,Color color,
                  int func, boolean fill, int stroke,int stroke2,int styles) // 기본 성성자
   {
      // 변수 초기화
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
                                 boolean fill,int stroke,int styles)   // polygon 생성자
   {
      // 변수 초기화      
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
   public DrawContents(ImageIcon img, int x1, int y1, int w,int h,Color color,	// stamp 생성자
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
		return select;	// 선택의 종류를 반환
	}

	public void setSelect(int select) {
		this.select = select;	// 어떤 형태의 선택인지를 int형으로 지정
	}
}