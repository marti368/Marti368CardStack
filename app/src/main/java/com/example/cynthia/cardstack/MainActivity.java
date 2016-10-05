package com.example.cynthia.cardstack;

import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Stack<Card> cardStack = new Stack<>();
    TextView textTop;
    TextView textBottom;
    ImageView imageTop;
    ImageView imageMid;
    ImageView imageBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTop = (TextView)findViewById(R.id.textView);
        textBottom = (TextView)findViewById(R.id.textView2);
        imageTop = (ImageView)findViewById(R.id.imageView);
        imageMid = (ImageView)findViewById(R.id.imageView2);
        imageBottom = (ImageView)findViewById(R.id.imageView3);
        GenerateStack();
        Card c = cardStack.pop();
        ChangeCard(c);


    }
    public void GenerateStack(){
        for(int i=1;i<=13;i++){
            for(int j=1;j<=4;j++){
                Card tempCard = new Card(i,j);
                cardStack.push(tempCard);
                Collections.shuffle(cardStack);
            }
        }
    }

    public void OnTouch(View view) {
        if (cardStack.isEmpty() != true){
            Card c = cardStack.pop();
            ChangeCard(c);
        }
        else{
            Toast.makeText(getApplicationContext(), "There are no more cards in the deck",Toast.LENGTH_SHORT).show();
        }
    }
    public void ChangeCard(Card c){
        String typeString = "";
        if (c.cardNum > 1 && c.cardNum < 11 ){
            typeString = Integer.toString(c.cardNum);
        }
        else if(c.cardNum == 1){
            typeString = "A";
        }
        else if(c.cardNum == 11){
            typeString = "J";
        }
        else if(c.cardNum == 12){
            typeString = "Q";
        }
        else if(c.cardNum == 13){
            typeString = "K";
        }
        textTop.setText(typeString);
        textBottom.setText(typeString);
        if (c.suitType == 1){
            textTop.setTextColor(Color.BLACK);
            textBottom.setTextColor(Color.BLACK);
            imageTop.setImageResource(R.drawable.spade);
            imageMid.setImageResource(R.drawable.spade);
            imageBottom.setImageResource(R.drawable.spade);
        }
        else if (c.suitType == 2){
            textTop.setTextColor(Color.RED);
            textBottom.setTextColor(Color.RED);
            imageTop.setImageResource(R.drawable.heart);
            imageMid.setImageResource(R.drawable.heart);
            imageBottom.setImageResource(R.drawable.heart);
        }
        else if (c.suitType == 3){
            textTop.setTextColor(Color.BLACK);
            textBottom.setTextColor(Color.BLACK);
            imageTop.setImageResource(R.drawable.club);
            imageMid.setImageResource(R.drawable.club);
            imageBottom.setImageResource(R.drawable.club);
        }
        else if (c.suitType == 4){
            textTop.setTextColor(Color.RED);
            textBottom.setTextColor(Color.RED);
            imageTop.setImageResource(R.drawable.diamond);
            imageMid.setImageResource(R.drawable.diamond);
            imageBottom.setImageResource(R.drawable.diamond);
        }
    }
}
