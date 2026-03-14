package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView ekran;



    View.OnClickListener sluchaczCyfr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //sorawdzme co kliknęlo
            Button b = (Button) v;
            String dopisanaCyfra = b.getText().toString();

            //pobieramy to co już jest na ekranie
            String obecnytekst = ekran.getText().toString();

            // dopisywanie
            if (obecnytekst.equals(("0"))) {
                ekran.setText(dopisanaCyfra);
            } else {
                ekran.setText( obecnytekst+ dopisanaCyfra);
            }

        }
    };

    View.OnClickListener sluchaczOperacji = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            String znak = b.getText().toString();

            String obecnyText = ekran.getText().toString();
            ekran.setText(obecnyText + " " + znak + " ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // polączenie z xml
         ekran = findViewById(R.id.result_tv);

         Button btn1 = findViewById(R.id.button17);
         Button btn2 = findViewById(R.id.button18);
         Button btn3 = findViewById(R.id.button19);

        Button btn4 = findViewById(R.id.button13);
        Button btn5 = findViewById(R.id.button14);
        Button btn6 = findViewById(R.id.button15);

        Button btn7 = findViewById(R.id.button9);
        Button btn8 = findViewById(R.id.button10);
        Button btn9 = findViewById(R.id.button11);

        Button btn0 = findViewById(R.id.button22);

        btn1.setOnClickListener(sluchaczCyfr);
        btn2.setOnClickListener(sluchaczCyfr);
        btn3.setOnClickListener(sluchaczCyfr);
        btn4.setOnClickListener(sluchaczCyfr);
        btn5.setOnClickListener(sluchaczCyfr);
        btn6.setOnClickListener(sluchaczCyfr);
        btn7.setOnClickListener(sluchaczCyfr);
        btn8.setOnClickListener(sluchaczCyfr);
        btn9.setOnClickListener(sluchaczCyfr);
        btn0.setOnClickListener(sluchaczCyfr);

       Button  btnPlus = findViewById(R.id.button20);
       Button btnMinus = findViewById(R.id.button16);
       Button btnMno = findViewById(R.id.button12);
       Button btnDzie = findViewById(R.id.button8);

       btnPlus.setOnClickListener(sluchaczOperacji);
       btnMinus.setOnClickListener(sluchaczOperacji);
       btnMno.setOnClickListener(sluchaczOperacji);
       btnDzie.setOnClickListener(sluchaczOperacji);


//        Button btn8 = findViewById(R.id.button10);
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ekran.setText("8");
//            }
//        });
//        Button btn7 = findViewById(R.id.button9);
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ekran.setText("7");
//            }
//        });
//
//        Button btn9 = findViewById(R.id.button11);
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ekran.setText("9");
//            }
//        });







    }
}