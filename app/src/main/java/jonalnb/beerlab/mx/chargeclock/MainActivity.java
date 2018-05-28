package jonalnb.beerlab.mx.chargeclock;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iImagen)
    ImageView iImagen;
    @BindView(R.id.vTexto)
    TextView vTexto;
    private CountDownTimer contador;
    private MediaPlayer reproductor;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        contador();
    }
    public void contador(){
        contador = new CountDownTimer(10000,500){
            @Override
            public void onTick(long millisUntilFinished) {
                if(i==18) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        vTexto.setTextColor(getColor(R.color.verde));
                    }
                    iImagen.setImageResource(R.mipmap.seis);
                    vTexto.setText("Carga al: 80%");
                }
                if(i<15){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        vTexto.setTextColor(getColor(R.color.verde));
                    }
                    if(millisUntilFinished%2==0)
                        iImagen.setImageResource(R.mipmap.cinco);
                    else
                        iImagen.setImageResource(R.mipmap.seis);
                    vTexto.setText("Carga al: 60%");
                }
                if(i<10){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        vTexto.setTextColor(getColor(R.color.rojo));
                    }
                    if(millisUntilFinished%2==0)
                        iImagen.setImageResource(R.mipmap.tres);
                    else
                        iImagen.setImageResource(R.mipmap.cuatro);
                    vTexto.setText("Carga al: 30%");
                }
                if(i<5){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        vTexto.setTextColor(getColor(R.color.rojo));
                    }
                    if(millisUntilFinished%2==0)
                        iImagen.setImageResource(R.mipmap.uno);
                    else
                        iImagen.setImageResource(R.mipmap.cero);
                    vTexto.setText("Carga al: 10%");
                }
                i++;
            }
            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    vTexto.setTextColor(getColor(R.color.verde));
                }
                iImagen.setImageResource(R.mipmap.seis);
                vTexto.setText("Carga al: 100%");
            }
        }.start();
    }
}
