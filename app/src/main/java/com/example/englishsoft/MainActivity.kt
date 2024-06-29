package com.example.englishsoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import bottombar.about
import bottombar.history
import circlefirstrow.adjectivescreen
import circlefirstrow.nounscreen
import circlefirstrow.tensescreen
import circlesecondrow.Ielts
import circlesecondrow.school
import circlesecondrow.toefel
import com.example.englishsoft.ui.theme.EnglishsoftTheme
import main.mainscreen
import rowlist.cartoon
import rowlist.englishsong
import rowlist.extra
import rowlist.grammer
import rowlist.kidssong
import rowlist.proverb
import rowlist.terms

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnglishsoftTheme {
                val imageslide = listOf(
                    R.drawable.eng8,
                    R.drawable.eng7,
                    R.drawable.eng5

                )
                val imageid = arrayOf(
                    R.drawable.kidssong,
                    R.drawable.englishsong,
                    R.drawable.proverb,
                    R.drawable.terms,
                    R.drawable.grammer,
                    R.drawable.kidsvideo,
                    R.drawable.extra,
                )
                val circleimage = arrayOf(
                    R.drawable.tenses,
                    R.drawable.adjective,
                    R.drawable.nouns,
                )
                val textcircle = arrayOf(
                    "زمان ها" ,
                    "صفت ها",
                    "اسم ها"
                )
                val circleimage2 = arrayOf(
                    R.drawable.englishclass,
                    R.drawable.toefel,
                    R.drawable.ielts,
                )
                val textcircle2 = arrayOf(
                    "منابع دروس مدرسه " ,
                    "      منابع تافل      ",
                    "      منابع آیلتس        "
                )
                val navcontroler = rememberNavController()
                NavHost(navController = navcontroler, startDestination = "mainscreen"){
                    composable("mainscreen"){
                        mainscreen(imageid , circleimage2 , textcircle2 , imageslide , circleimage , textcircle , navcontroler)
                    }
                    composable("toefelscreen"){
                        toefel()
                    }
                    composable("ieltsscreen") {
                        Ielts()
                    }
                    composable("schoolscreen"){
                        school()
                    }
                    composable("kidssongscreen"){
                        kidssong()
                    }
                    composable("englishsongscreen"){
                        englishsong()
                    }
                    composable("proverbscreen"){
                        proverb()
                    }
                    composable("termsscreen"){
                        terms()
                    }
                    composable("grammerscreen"){
                        grammer()
                    }
                    composable("cartoonscreen"){
                        cartoon()
                    }
                    composable("extrascreen"){
                        extra()
                    }
                    composable("tensescreen"){
                        tensescreen()
                    }
                    composable("adjectivescreen"){
                        adjectivescreen()
                    }
                    composable("nounscreen"){
                        nounscreen()
                    }
                    composable("aboutscreen"){
                        about()
                    }
                    composable("historyscreen"){
                        history()
                    }

                }

            }
        }
    }
}
