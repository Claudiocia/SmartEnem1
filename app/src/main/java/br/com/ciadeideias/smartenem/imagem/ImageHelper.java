package br.com.ciadeideias.smartenem.imagem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageHelper {
    public static Bitmap getRoundedCornerBitmap(Context context, Bitmap input, int pixels, int w, int h,
                                                boolean squareTL, boolean squareTR, boolean squareBL,
                                                boolean squareBR){

        Bitmap output = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        final int color     = 0xff424242;
        final Paint paint   = new Paint();
        final Rect rect     = new Rect(0, 0, w, h);
        final RectF rectF   = new RectF(rect);

        //certifique-se de que nosso canto arredondado é dimensionado adequadamente
        final float roundPx = pixels*densityMultiplier;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        //desenhe retângulos nos cantos que queremos ser quadrados
        if (squareTL){
            canvas.drawRect(0, 0, w/2, h/2, paint);
        }
        if (squareTR){
            canvas.drawRect(w/2, 0, w, h/2, paint);
        }
        if (squareBL){
            canvas.drawRect(0, h/2, w/2, h, paint);
        }
        if (squareBR){
            canvas.drawRect(w/2, h/2, w, h, paint);
        }

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(input, 0, 0, paint);

        return output;
    }
}
