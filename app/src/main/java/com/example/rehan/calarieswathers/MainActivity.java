package com.example.rehan.calarieswathers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rehan.calarieswathers.Convertor.ConvertingUnits;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2,e1Area,e2Area,e1Temp,e2Temp,e1Weight,e2Weight;
    private Spinner s1,s2,s1Area,s2Area,s1Temp,s2Temp,s1Weight,s2Weight;
    private int count1 = 0;
    private ConvertingUnits.Length caLength;
    private ConvertingUnits.Area caArea;
    private ConvertingUnits.Temperature caTemp;
    private ConvertingUnits.Weight caWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }
//////////////////////onclick start
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.equallength:
                int item1  = s1.getSelectedItemPosition();
                int item2   = s2.getSelectedItemPosition();
                double value1 = Double.parseDouble(e1.getText().toString());
                double resultLength = evaluateLength(item1,item2,value1);
                e2.setText(resultLength+"");
                break;
            case R.id.equalArea:
                int item1Area  = s1Area.getSelectedItemPosition();
                int item2Area  = s2Area.getSelectedItemPosition();
                double value1Area  = Double.parseDouble(e1Area.getText().toString());
                double resultArea  = evaluateArea(item1Area,item2Area,value1Area);
                e2Area.setText(resultArea+"");
                break;
            case R.id.equaltemp:
                int item1Temp = s1Temp.getSelectedItemPosition();
                int item2Temp = s2Temp.getSelectedItemPosition();
                double value1Temp = Double.parseDouble(e1Temp.getText().toString());
                double resultTemp = evaluateTemp(item1Temp,item2Temp,value1Temp);
                e2Temp.setText(resultTemp+"");
                break;
            case R.id.equalWeight:
                int item1weight = s1Weight.getSelectedItemPosition();
                int item2Weight = s2Weight.getSelectedItemPosition();
                double value1Weight = Double.parseDouble(e1Weight.getText().toString());
                double resultWeight  = evaluateWeight(item1weight,item2Weight,value1Weight);
                e2Weight.setText(resultWeight+"");
                break;
        }
    }
    /////////////////////////onclick end
    public void initialize(){
        e1 = (EditText)findViewById(R.id.item1);
        e2 = (EditText)findViewById(R.id.item2);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);

        caLength = new ConvertingUnits.Length();
        ///////////////////Area start
        e1Area = (EditText)findViewById(R.id.item1Area);
        e2Area = (EditText)findViewById(R.id.item2Area);
        s1Area = (Spinner)findViewById(R.id.spinner1Area);
        s2Area = (Spinner)findViewById(R.id.spinner2Area);
        caArea = new ConvertingUnits.Area();
        ///////////////////Area end
        ////////////////start Temperature
        e1Temp = (EditText)findViewById(R.id.item1tem);
        e2Temp = (EditText)findViewById(R.id.item2temp);
        s1Temp = (Spinner) findViewById(R.id.spinner1temp);
        s2Temp = (Spinner)findViewById(R.id.spinner2temp);
        caTemp = new ConvertingUnits.Temperature();
        ///////////////end temperature
        ////////////////start Weight
        e1Weight = (EditText)findViewById(R.id.item1weight);
        e2Weight = (EditText)findViewById(R.id.item2weight);
        s1Weight = (Spinner) findViewById(R.id.spinner1weight);
        s2Weight = (Spinner)findViewById(R.id.spinner2weight);
        caWeight = new ConvertingUnits.Weight();
        ///////////////end Weight
    }


    public double evaluateLength(int item1,int item2,double value)
    {
        double temp = 0.0;
        if(item1 == item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp = caLength.NanoToMeter(value);
                    break;
                case 1:
                    temp = caLength.MilliToMeter(value);
                    break;
                case 2:
                    temp = caLength.CentiToMeter(value);
                    break;
                case 3:
                    temp = value;
                    break;
                case 4:
                    temp = caLength.KiloToMeter(value);
                    break;
                case 5:
                    temp = caLength.InchToMeter(value);
                    break;
                case 6:
                    temp = caLength.FootToMeter(value);
                    break;
                case 7:
                    temp = caLength.YardToMeter(value);
                    break;
                case 8:
                    temp = caLength.MileToMeter(value);
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp = caLength.MeterToNano(temp);
                    break;
                case 1:
                    temp = caLength.MeterToMilli(temp);
                    break;
                case 2:
                    temp = caLength.MeterToCenti(temp);
                    break;
                case 4:
                    temp = caLength.MeterToKilo(temp);
                    break;
                case 5:
                    temp = caLength.MeterToInch(temp);
                    break;
                case 6:
                    temp = caLength.MeterToFoot(temp);
                    break;
                case 7:
                    temp = caLength.MeterToYard(temp);
                    break;
                case 8:
                    temp = caLength.MeterToMile(temp);
                    break;
            }
            return temp;
        }
    }
///////////////////////////////Area \
public double evaluateArea(int item1,int item2,double value)
{
    double temp = 0.0;
    if(item1 == item2)
        return value;
    else
    {
        switch (item1)
        {
            case 0:
                temp = caArea.sqMilliToMeter(value);
                break;
            case 1:
                temp = caArea.sqCentiToMeter(value);
                break;
            case 2:
                temp = value;
                break;
            case 3:
                temp = caArea.sqKiloToMeter(value);
                break;
            case 4:
                temp = caArea.AcreToMeter(value);
                break;
            case 5:
                temp = caArea.HectareToMeter(value);
                break;
        }

        switch (item2)
        {
            case 0:
                temp = caArea.sqMeterToMilli(temp);
                break;
            case 1:
                temp = caArea.sqMeterToCenti(temp);
                break;
            case 3:
                temp = caArea.sqMeterToKilo(temp);
                break;
            case 4:
                temp = caArea.sqMeterToAcre(temp);
                break;
            case 5:
                temp = caArea.sqMeterToHectare(temp);
                break;
        }
        return temp;
    }
}
    ///////////////////////////////ARea end


   ///////////////////////// Start tempterature
   public double evaluateTemp(int item1,int item2,double value)
   {
       double temp = 0.0;
       if(item1 == item2)
           return value;
       else
       {
           switch (item1)
           {
               case 0:
                   temp = caTemp.CelsiTokelvin(value);
                   break;
               case 1:
                   temp = caTemp.FerToKelvin(value);
                   break;
               case 2:
                   temp = value;
                   break;
           }

           switch (item2)
           {
               case 0:
                   temp = caTemp.KelvinToCelsi(temp);
                   break;
               case 1:
                   temp = caTemp.KelvinToFer(temp);
                   break;
           }
           return temp;
       }
   }
    ////////////////////////End tempterature
    //////////////////////////////Start Weight
    public double evaluateWeight(int item1,int item2,double value)
    {
        double temp = 0.0;
        if(item1 == item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp = caWeight.MilliToKilo(value);
                    break;
                case 1:
                    temp = caWeight.CentiToKilo(value);
                    break;
                case 2:
                    temp = caWeight.DeciToKilo(value);
                    break;
                case 3:
                    temp = caWeight.GramToKilo(value);
                    break;
                case 4:
                    temp = value;
                    break;
                case 5:
                    temp = caWeight.MetricTonnesToKilo(value);
                    break;
                case 6:
                    temp = caWeight.PoundsToKilo(value);
                    break;
                case 7:
                    temp = caWeight.OuncesToKilo(value);
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp = caWeight.KiloToMilli(temp);
                    break;
                case 1:
                    temp = caWeight.KiloToCenti(temp);
                    break;
                case 2:
                    temp = caWeight.KiloToDeci(temp);
                    break;
                case 3:
                    temp = caWeight.KiloToGram(temp);
                    break;
                case 5:
                    temp = caWeight.KiloToMetricTonnes(temp);
                    break;
                case 6:
                    temp = caWeight.KiloToPounds(temp);
                    break;
                case 7:
                    temp = caWeight.KiloToOunces(temp);
                    break;
            }
            return temp;
        }
    }
    ////////////////////////////End Weight
}
