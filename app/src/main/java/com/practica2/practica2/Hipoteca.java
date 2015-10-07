package com.practica2.practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math; //Importamos la clase Math de la biblioteca del API Java


public class Hipoteca extends AppCompatActivity {

    private EditText par1;
    private EditText par2;
    private EditText par3;
    private EditText par4;
    private EditText par5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipoteca);

        par1 = (EditText)findViewById(R.id.preuInmoble);
        par2 = (EditText)findViewById(R.id.estalvis);
        par3 = (EditText)findViewById(R.id.plaç);
        par4 = (EditText)findViewById(R.id.euribor);
        par5 = (EditText)findViewById(R.id.diferencial);

        actualitzaImports();

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                actualitzaImports();

            }
        };
        par1.addTextChangedListener(textWatcher);
        par2.addTextChangedListener(textWatcher);
        par3.addTextChangedListener(textWatcher);
        par4.addTextChangedListener(textWatcher);
        par5.addTextChangedListener(textWatcher);
    }

    private void actualitzaImports() {
        final Calcula calcula = new Calcula().invoke();
        double totalMes = calcula.getTotalMes();
        double total = calcula.getTotal();

        mostrar(totalMes, total);
    }

    private void mostrar(double totalMes, double total) {
        TextView textTotal = (TextView)findViewById(R.id.calcTotal);
        TextView textMes = (TextView)findViewById(R.id.calcMes);
        String totalHipo = String.valueOf(total);
        textTotal.setText(totalHipo);
        String totalHipoMes =String.valueOf(totalMes);
        textMes.setText(totalHipoMes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hipoteca, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onClacular(View view) {
        //DecimalFormat dosdec = new DecimalFormat("#########.00");
/*
        EditText par1 = (EditText)findViewById(R.id.preuInmoble);
        EditText par2 = (EditText)findViewById(R.id.estalvis);
        EditText par3 = (EditText)findViewById(R.id.plaç);
        EditText par4 = (EditText)findViewById(R.id.euribor);
        EditText par5 = (EditText)findViewById(R.id.diferencial);

        double floPar1 = Double.valueOf(par1.getText().toString());
        double floPar2 = Double.valueOf(par2.getText().toString());
        double floPar3 = Double.valueOf(par3.getText().toString());
        double floPar4 = Double.valueOf(par4.getText().toString());
        double floPar5 = Double.valueOf(par5.getText().toString());


        double floInteres = floPar4+floPar5;
        //floInteres=floInteres/12;
        double meses = floPar3*12;
        double capital = floPar1-floPar2;
        double potencia = 1+(floInteres/12)/100;
        double meses2 = meses*(-1);
        //floPar3=floPar3*12;
        //float total = floPar1+floPar2+floPar3+floPar4+floPar5;
        double totalMes = (capital * (floInteres/12))/(100*(1-Math.pow(potencia, meses2)));

        //double total = totalMes;
        double total = totalMes*meses;
        //double totalMes = floPar3+floPar4;
/*
        int intPar1 = Integer.parseInt(par1.getText().toString());
        int intPar2 = Integer.parseInt(par1.getText().toString());
        int intPar3 = Integer.parseInt(par1.getText().toString());
        int intPar4 = Integer.parseInt(par1.getText().toString());
        int intPar5 = Integer.parseInt(par1.getText().toString());

        */
/*
        int total = intPar1+intPar2+intPar3+intPar4+intPar5;
        int totalMes = total/12;
        */



        //Toast.makeText(this,"resultado "+total,Toast.LENGTH_SHORT).show();

  /*      TextView textTotal = (TextView)findViewById(R.id.calcTotal);
        TextView textMes = (TextView)findViewById(R.id.calcMes);
        //int intCalc = Integer.parseInt(textTotal.getText().toString());

        //intCalc = total;

        //TextView textTotal = (TextView)findViewById(R.id.calcTotal);
        //textTotal.setText(total);
        String totalHipo = String.valueOf(total);
        textTotal.setText(totalHipo);
        String totalHipoMes =String.valueOf(totalMes);
        textMes.setText(totalHipoMes);*/

    }

    private class Calcula {
        private double totalMes;
        private double total;

        public double getTotalMes() {
            return totalMes;
        }

        public double getTotal() {
            return total;
        }

        public Calcula invoke() {
            double floPar1 = Double.valueOf(par1.getText().toString());
            double floPar2 = Double.valueOf(par2.getText().toString());
            double floPar3 = Double.valueOf(par3.getText().toString());
            double floPar4 = Double.valueOf(par4.getText().toString());
            double floPar5 = Double.valueOf(par5.getText().toString());

            double floInteres = floPar4+floPar5;
            //floInteres=floInteres/12;
            double meses = floPar3*12;
            double capital = floPar1-floPar2;
            double potencia = 1+(floInteres/12)/100;
            double meses2 = meses*(-1);
            //floPar3=floPar3*12;
            //float total = floPar1+floPar2+floPar3+floPar4+floPar5;
            totalMes = (capital * (floInteres / 12)) / (100 * (1 - Math.pow(potencia, meses2)));

            //double total = totalMes;
            total = totalMes * meses;
            //double totalMes = floPar3+floPar4;
            return this;
        }
    }
}