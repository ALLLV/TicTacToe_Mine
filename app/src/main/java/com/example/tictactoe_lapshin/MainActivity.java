package com.example.tictactoe_lapshin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //resources
    boolean endgame = false;
    int increment = 3;

    public void setHorizontalOrVerticalWinLine(int rc, boolean isRow, Button btns[][]){
        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                btns[col][row].setBackgroundResource(R.drawable.btn_disabled);
                btns[col][row].setEnabled(false);
            }
        }
        if (isRow){
            for (int i = 0; i < 3; i++){
                btns[rc][i].setBackgroundResource(R.drawable.btn_winner);
            }
        }else{
            for (int i = 0; i < 3; i++){
                btns[i][rc].setBackgroundResource(R.drawable.btn_winner);
            }
        }
    }

    public void setDiagonalWinLine(int index, Button btns[][]){
        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                btns[col][row].setBackgroundResource(R.drawable.btn_disabled);
                btns[col][row].setEnabled(false);
            }
        }
        if (index == 1){
            for (int i = 0; i < 3; i++)
            btns[i][i].setBackgroundResource(R.drawable.btn_winner);
        }
        else if (index == -1){
            int decr = 2;
            for (int i = 0; i < 3; i++){
                btns[decr][i].setBackgroundResource(R.drawable.btn_winner);
                decr--;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userHint = (TextView) findViewById(R.id.hint);

        Button startButton = (Button) findViewById(R.id.btnStart);

        Button button11 = (Button) findViewById(R.id.btn11);
        Button button12 = (Button) findViewById(R.id.btn12);
        Button button13 = (Button) findViewById(R.id.btn13);
        Button button21 = (Button) findViewById(R.id.btn21);
        Button button22 = (Button) findViewById(R.id.btn22);
        Button button23 = (Button) findViewById(R.id.btn23);
        Button button31 = (Button) findViewById(R.id.btn31);
        Button button32 = (Button) findViewById(R.id.btn32);
        Button button33 = (Button) findViewById(R.id.btn33);

        Button[][] buttons =
                {
                        {button11, button12, button13},
                        {button21, button22, button23},
                        {button31, button32, button33}
                };

        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                buttons[col][row].setBackgroundResource(R.drawable.btn_disabled);
                buttons[col][row].setEnabled(false);
            }
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                btn.setEnabled(false);
                btn.setBackgroundResource(R.drawable.btn_disabled);
                if (increment % 2 == 1){
                    userHint.setText(R.string.player2_move);
                    btn.setText("x");
                }
                else{
                    userHint.setText(R.string.player1_move);
                    btn.setText("o");
                }

                if(button11.getText().toString() == button12.getText().toString() && button11.getText().toString() == button13.getText().toString() && button11.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(0, true, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button21.getText().toString() == button22.getText().toString() && button21.getText().toString() == button23.getText().toString() && button21.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(1, true, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button31.getText().toString() == button32.getText().toString() && button31.getText().toString() == button33.getText().toString() && button31.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(2, true, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button11.getText().toString() == button21.getText().toString() && button11.getText().toString() == button31.getText().toString() && button11.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(0, false, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button12.getText().toString() == button22.getText().toString() && button12.getText().toString() == button32.getText().toString() && button12.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(1, false, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button13.getText().toString() == button23.getText().toString() && button13.getText().toString() == button33.getText().toString() && button13.getText().toString() != ""){
                    setHorizontalOrVerticalWinLine(2, false, buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button11.getText().toString() == button22.getText().toString() && button11.getText().toString() == button33.getText().toString() && button11.getText().toString() != ""){
                    setDiagonalWinLine(1,buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }
                else if(button13.getText().toString() == button22.getText().toString() && button13.getText().toString() == button31.getText().toString() && button13.getText().toString() != ""){
                    setDiagonalWinLine(-1,buttons);
                    if (increment % 2 == 1)
                        userHint.setText(R.string.player1_win);
                    else
                        userHint.setText(R.string.player2_win);
                }

                increment = increment + 1;
            }
        };

        View.OnClickListener startButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                for (int col = 0; col < 3; col++){
                    for (int row = 0; row < 3; row++){
                        buttons[col][row].setBackgroundResource(R.drawable.btn_enabled);
                        buttons[col][row].setEnabled(true);
                        buttons[col][row].setText("");
                    }
                }
                userHint.setText(R.string.player1_move);
                increment = 3;
            }
        };

        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                buttons[col][row].setOnClickListener(onClickListener);
            }
        }

        startButton.setOnClickListener(startButtonClick);
    }
}