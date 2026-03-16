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

    View.OnClickListener sluchaczWyniku = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tekst = ekran.getText().toString();

            //tniemy tekst na czesci
            String[] czesci = tekst.split(" ");

            //sprawdzmy czy mamy komplet
            if(czesci.length == 3) {
                double liczba1 = Double.parseDouble(czesci[0]);
                String znak = czesci[1];
                double liczba2 = Double.parseDouble(czesci[2]);
                double wynik = 0;


                if(znak.equals("+")) wynik = liczba1 + liczba2;
                else if (znak.equals("-")) wynik = liczba1 - liczba2;
                else if (znak.equals("*")) wynik = liczba1 * liczba2;
                else if (znak.equals("/")) {
                    if(liczba2 == 0) {
                        ekran.setText("NIE DZIEL PRZEZ ZERO");
                        return;
                    } else {
                        wynik = liczba1 / liczba2;
                    }
                }

                ekran.setText(String.valueOf(wynik));








            }

        }
    };

    View.OnClickListener sluchaczClear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ekran.setText("0");
        }
    };

    View.OnClickListener sluchaczPlusMinus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tekst = ekran.getText().toString();
            if (tekst.isEmpty()) return; // Zabezpieczenie przed pustym ekranem

            String[] czesci = tekst.split(" ");
            int ostatniIndeks = czesci.length - 1;
            String ostatniaLiczba = czesci[ostatniIndeks];

            // Budujemy wynik:
            String wynik = "";
            for (int i = 0; i < ostatniIndeks; i++) {
                wynik += czesci[i] + " "; // Przepisujemy wszystko przed ostatnią liczbą
            }

            // Na końcu doklejamy minus i tę liczbę
            if(ostatniaLiczba.matches( "^-.*")){
                String nowaLiczba = ostatniaLiczba.substring(1);
              ekran.setText(wynik + nowaLiczba);
            } else {
                ekran.setText(wynik + "-" + ostatniaLiczba);
            }
        }
    };

    View.OnClickListener sluchaczPier = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tekst = ekran.getText().toString();

            String[] czesci = tekst.split(" ");
            int ostatniIndeks = czesci.length - 1;

            String ostatniaLiczba = czesci[ostatniIndeks];

            String wynik = "";
            for (int i = 0; i < ostatniIndeks; i++) {
                wynik += czesci[i] + " ";
            }
            double liczba = Double.parseDouble(ostatniaLiczba);
            double wynikOperacji = 0;
            // 1. Sprawdzamy, co jest napisane na klikniętym przycisku
            Button kliknietyGuzik = (Button) v;
            String nazwaPrzycisku = kliknietyGuzik.getText().toString();
            if (nazwaPrzycisku.equals("sqrt")) {
                wynikOperacji = Math.sqrt(liczba);
            } else if (nazwaPrzycisku.equals("1/x")) {
                wynikOperacji = 1.0/liczba;
            } else if (nazwaPrzycisku.equals("%")) {
                wynikOperacji = liczba/100;

            }
            ekran.setText(wynik + String.valueOf(wynikOperacji));


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

       Button btnPlus = findViewById(R.id.button20);
       Button btnMinus = findViewById(R.id.button16);
       Button btnMno = findViewById(R.id.button12);
       Button btnDzie = findViewById(R.id.button8);

       btnPlus.setOnClickListener(sluchaczOperacji);
       btnMinus.setOnClickListener(sluchaczOperacji);
       btnMno.setOnClickListener(sluchaczOperacji);
       btnDzie.setOnClickListener(sluchaczOperacji);

       Button btnRowne = findViewById(R.id.button24);
       Button btnClear = findViewById(R.id.button3);

// wyywolanie rownania
       btnRowne.setOnClickListener(sluchaczWyniku);


       btnClear.setOnClickListener(sluchaczClear);

       Button btnPlusMinus = findViewById(R.id.button21);
       btnPlusMinus.setOnClickListener(sluchaczPlusMinus);

       Button btnSqrt = findViewById(R.id.button7);
       btnSqrt.setOnClickListener(sluchaczPier);

       Button btnPro = findViewById(R.id.button1);
       btnPro.setOnClickListener(sluchaczPier);

        Button btnula = findViewById(R.id.button5);
        btnPro.setOnClickListener(sluchaczPier);


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