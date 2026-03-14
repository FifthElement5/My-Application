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

         Button btn1 = findViewById(button9);

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