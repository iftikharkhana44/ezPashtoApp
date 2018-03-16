package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ColoursQuiz extends AppCompatActivity {


    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static  final private int QUIZ_COUNT = 9;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            {"Red", "Soor", "Sheen", "Kela", "Shaltalu"},
            {"Green", "Sheen", "Aloo", "malta", "Gopi"},
            {"Blue", "Udee", "Sheen", "Kela", "shaltalu"},
            {"Orange", "Naranji", "Sheen", "Kela", "shaltalu"},
            {"Black", "Toor", "Sheen", "Kela", "shaltalu"},
            {"White", "Spin", "Sheen", "Kela", "shaltalu"},
            {"Yellow", "Zyral", "Sheen", "Kela", "shaltalu"},
            {"brown", "Naswari", "Sheen", "Kela", "shaltalu"},
            {"Balal", "B", "SHE", "HER", "HE"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours_quiz);


        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        // Create quizArray from quizData
        for (int i = 0; i < quizData.length; i++) {
            // Prepare Array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            // Add tmpArray to quizArray
            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    public  void showNextQuiz(){

        //update quizCountLabel
        countLabel.setText("Q" + quizCount);

        // Generate random number between given quizArray
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);


        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    public void checkAnswer (View view){


        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();


        if (btnText.equals(rightAnswer)){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);


        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }


        if (quizCount == QUIZ_COUNT){
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
            startActivity(intent);
            //show result
        }else {
            quizCount++;
            showNextQuiz();

        }
    }
}