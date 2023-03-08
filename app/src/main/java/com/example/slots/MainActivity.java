package com.example.slots;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1, iv2, iv3;
    TextView tv1, tv2;
    int val1, val2, val3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.txtApuesta);
        tv2 = findViewById(R.id.txtGanado);

        iv1 = findViewById(R.id.imgSlot1);
        iv2 = findViewById(R.id.imgSlot2);
        iv3 = findViewById(R.id.imgSlot3);

    }//

    public int generateRandom() {
        return (int) (Math.random() * (3 - 1+1) + 1);
    }//

    public void spin() {
        val1 = generateRandom();
        val2 = generateRandom();
        val3 = generateRandom();
    }//

    public void setImages() {
        spin();

        if(val1 == 1) {
            iv1.setImageResource(R.drawable.limon);
        } else if(val1 == 2) {
            iv1.setImageResource(R.drawable.fresa);
        } else if (val1 == 3) {
            iv1.setImageResource(R.drawable.cereza);
        }

        if(val2 == 1) {
            iv2.setImageResource(R.drawable.limon);
        } else if(val2 == 2) {
            iv2.setImageResource(R.drawable.fresa);
        } else if (val2 == 3) {
            iv2.setImageResource(R.drawable.cereza);
        }

        if(val3 == 1) {
            iv3.setImageResource(R.drawable.limon);
        } else if(val3 == 2) {
            iv3.setImageResource(R.drawable.fresa);
        } else if (val3 == 3) {
            iv3.setImageResource(R.drawable.cereza);
        }
    }//

    public void jugar(View view) {
        setImages();
        tv2.setText("0");

        int apuesta = Integer.parseInt(tv1.getText().toString());
        int result;

        if (val1 == 1 && (val2 == val1 && val3 == val1)) {
            result = apuesta * 2;
        } else if (val1 == 2 && (val2 == val1 && val3 == val1)) {
            result = apuesta * 3;
        } else if (val1 == 3 && (val2 == val1 && val3 == val1)) {
            result = apuesta * 4;
        } else {
            result = apuesta * 0;
        }

        tv2.setText(String.valueOf(result));
        tv1.setText("");
    }

}