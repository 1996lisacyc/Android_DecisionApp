package com.example.user.decisionguide;

    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.content.Intent;
    import android.graphics.BlurMaskFilter;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.Path;
    import android.graphics.Path.Direction;
    import android.graphics.RectF;
    import android.util.DisplayMetrics;
    import android.view.View;

@SuppressLint("NewApi")
public class PanelPieChart1 extends View {

    private int ScrHeight;
    private int ScrWidth;

    private Paint[] arrPaintArc;
    private Paint PaintText = null;

    //RGB颜色数组
    private final int arrColorRgb[][] = { {77, 83, 97},
            {148, 159, 181},
            {253, 180, 90},
            {52, 194, 188},
            {39, 51, 72},
            {255, 135, 195},
            {215, 124, 124},
            {180, 205, 230}} ;

    //演示用的比例,实际使用中，即为外部传入的比例参数
    float arrPer[];

    public PanelPieChart1(Context context){
        super(context);
    }

    public void PieChart(float arr[]){
        //super(context);
        arrPer = arr;
        //解决4.1版本 以下canvas.drawTextOnPath()不显示问题
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        //屏幕信息
        DisplayMetrics dm = getResources().getDisplayMetrics();
        ScrHeight = dm.heightPixels;
        ScrWidth = dm.widthPixels;

        //设置边缘特殊效果
        BlurMaskFilter PaintBGBlur = new BlurMaskFilter(1, BlurMaskFilter.Blur.INNER);

        arrPaintArc = new Paint[5];
        for(int i=0;i<5;i++)
        {
            arrPaintArc[i] = new Paint();
            arrPaintArc[i].setARGB(255, arrColorRgb[i][0], arrColorRgb[i][1], arrColorRgb[i][2]);
            arrPaintArc[i].setStyle(Paint.Style.FILL);
            arrPaintArc[i].setStrokeWidth(4);
            arrPaintArc[i].setMaskFilter(PaintBGBlur);
        }

        PaintText = new Paint();
        PaintText.setColor(Color.BLUE);
        PaintText.setTextSize(50);
    }

    public void onDraw(Canvas canvas){
        //画布背景
        canvas.drawColor(Color.WHITE);

        float cirX = ScrWidth/2;
        float cirY = ScrHeight/3 -100;
        float radius = ScrHeight/5 ;

        float arcLeft = cirX - radius;
        float arcTop  = cirY - radius ;
        float arcRight = cirX + radius ;
        float arcBottom = cirY + radius ;
        RectF arcRF0 = new RectF(arcLeft ,arcTop,arcRight,arcBottom);

        Path pathArc=new Path();
        // x,y,半径 ,CW
        pathArc.addCircle(cirX,cirY,radius,Direction.CW);
        //绘出饼图大轮廓
        canvas.drawPath(pathArc,arrPaintArc[0]);

        float CurrPer = 0f; //偏移角度
        float Percentage =  0f; //当前所占比例

        int scrOffsetW = ScrWidth-520;
        int scrOffsetH = ScrHeight-500;
        int scrOffsetT = 100;

        int i= 0;
        for(i=0; i<3; i++) //注意循环次数噢
        {
            //将百分比转换为饼图显示角度
            Percentage = 360 * (arrPer[i]/ 100);
            Percentage = (float)(Math.round(Percentage *100))/100;

            //在饼图中显示所占比例
            canvas.drawArc(arcRF0, CurrPer, Percentage, true, arrPaintArc[i+2]);

            //当前颜色
            canvas.drawRect(scrOffsetW-100 ,scrOffsetH + i * scrOffsetT,
                    scrOffsetW-40,scrOffsetH - 30 + i * scrOffsetT, arrPaintArc[i+2]);
            //当前比例
            if(i == 0)
                canvas.drawText(("不動手術     ")+String.valueOf(arrPer[i]) +"%",scrOffsetW,scrOffsetH + i * scrOffsetT, PaintText);
            else if(i == 1)
                canvas.drawText(("植入體         ")+String.valueOf(arrPer[i]) +"%",scrOffsetW,scrOffsetH + i * scrOffsetT, PaintText);
            else
                canvas.drawText(("自體移植    ")+String.valueOf(arrPer[i]) +"%",scrOffsetW,scrOffsetH + i * scrOffsetT, PaintText);
            //下次的起始角度
            CurrPer += Percentage;
        }
    }
}