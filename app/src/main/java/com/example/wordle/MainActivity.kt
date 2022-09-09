package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter =0
        val submit = findViewById<Button>(R.id.button)
        val reset = findViewById<Button>(R.id.Reset)
        val geditOne = findViewById<TextView>(R.id.guessOne)
        var s = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
        val fOne = findViewById<TextView>(R.id.fOne)
        val fTwo = findViewById<TextView>(R.id.fTwo)
        val fThree = findViewById<TextView>(R.id.fThree)
        val fFour = findViewById<TextView>(R.id.fFour)
        val sOne = findViewById<TextView>(R.id.sOne)
        val sTwo = findViewById<TextView>(R.id.sTwo)
        val sThree = findViewById<TextView>(R.id.sThree)
        val sFour = findViewById<TextView>(R.id.sFour)
        val tOne = findViewById<TextView>(R.id.tOne)
        val tTwo = findViewById<TextView>(R.id.tTwo)
        val tThree = findViewById<TextView>(R.id.tThree)
        val tFour = findViewById<TextView>(R.id.tFour)

         fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == s[i]) {
                    result += "O"
                }
                else if (guess[i] in s) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }
        fun checkColor(r : Char, findTextView: TextView){
            if(r.equals('X'))
            {
                 findTextView.setBackgroundColor(resources.getColor(R.color.none))
            }
            else if(r.equals('+'))
            {
                findTextView.setBackgroundColor(resources.getColor(R.color.misplaced))
            }
            else{
                findTextView.setBackgroundColor(resources.getColor(R.color.correct))
            }
        }
        fun resetAll(findTextView: TextView)
        {
            findTextView.text= ""
            findTextView.setBackgroundColor(resources.getColor(R.color.b1))
        }
        val shuffledWords = findViewById<TextView>(R.id.ShuffledWords)
        submit.setOnClickListener()
        {
            val enteredWords = findViewById<EditText>(R.id.enteredByUser).text.toString().uppercase()
            counter++
            val r = checkGuess(enteredWords)
            if(counter==1) {
             fOne.text = enteredWords[0].toString()
                checkColor(r[0],fOne)
                fTwo.text = enteredWords[1].toString()
                checkColor(r[1],fTwo)
                fThree.text = enteredWords[2].toString()
                checkColor(r[2],fThree)
                fFour.text = enteredWords[3].toString()
                checkColor(r[3],fFour)
                geditOne.text = "Guess#1 = \t\t\t\t\t" +enteredWords+"\nCheck#1 = \t\t\t\t\t"+ r.toString()
                if(enteredWords.equals(s)) {
                    Toast.makeText(
                        it.context,
                        "Congratulations!! \n You guessed right",
                        Toast.LENGTH_SHORT
                    ).show()
                    submit.visibility = View.GONE
                }
            }
            else if(counter==2)
            {
                sOne.text = enteredWords[0].toString()
                checkColor(r[0],sOne)
                sTwo.text = enteredWords[1].toString()
                checkColor(r[1],sTwo)
                sThree.text = enteredWords[2].toString()
                checkColor(r[2],sThree)
                sFour.text = enteredWords[3].toString()
                checkColor(r[3],sFour)
                findViewById<TextView>(R.id.guessTwo).text = "Guess#2 = \t\t\t\t\t" +enteredWords+"\nCheck #2 = \t\t\t\t\t"+ r.toString()
                if(enteredWords.equals(s)) {
                    Toast.makeText(
                        it.context,
                        "Congratulations!! \n You guessed right",
                        Toast.LENGTH_SHORT
                    ).show()
                    submit.visibility = View.GONE
                }
            }
            else if(counter==3){
                findViewById<TextView>(R.id.guessThree).text = "Guess#3 = \t\t\t\t\t" +enteredWords+"\nCheck#3 = \t\t\t\t\t"+ r.toString()
                tOne.text = enteredWords[0].toString()
                checkColor(r[0],tOne)
                tTwo.text = enteredWords[1].toString()
                checkColor(r[1],tTwo)
                tThree.text = enteredWords[2].toString()
                checkColor(r[2],tThree)
                tFour.text = enteredWords[3].toString()
                checkColor(r[3],tFour)
                if(enteredWords.equals(s)) {
                    Toast.makeText(
                        it.context,
                        "Congratulations!! \n You guessed right",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Toast.makeText(it.context,"You've exceeded your number of guesses.",Toast.LENGTH_SHORT).show()
                    submit.visibility = View.GONE
                reset.visibility = View.VISIBLE
                shuffledWords.text = "Four letter words is \n"+s
                shuffledWords.visibility = View.VISIBLE
            }
        }
        reset.setOnClickListener(){
            counter = 0
            resetAll(fOne)
            resetAll(fTwo)
            resetAll(fThree)
            resetAll(fFour)
            resetAll(sOne)
            resetAll(sTwo)
            resetAll(sThree)
            resetAll(sFour)
            resetAll(tOne)
            resetAll(tTwo)
            resetAll(tThree)
            resetAll(tFour)
            s = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
            submit.visibility = View.VISIBLE
            geditOne.text = "Guess#1"
            findViewById<TextView>(R.id.guessTwo).text = "Guess#2"
            findViewById<TextView>(R.id.guessThree).text = "Guess#3"
            reset.visibility = View.GONE
            shuffledWords.visibility = View.GONE
        }
       }
    }

