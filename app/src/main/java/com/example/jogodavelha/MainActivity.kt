package com.example.jogodavelha

import  android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogodavelha.ui.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaVelhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    MainContent()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainContent(){
    var jogadorX = Jogador("X")
    jogadorX.ativo = true

    var jogadorO = Jogador("O")
    jogadorO.ativo = false
    val posicaoOcupada = arrayListOf("","","","","","","","","")


    (1..9).forEach{
        posicaoOcupada.add("")
    }

    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )


    }

    ){
       GridButtons(jogadorX, jogadorO)
    }

}
fun verifiicarJogador(jogadorX: Jogador, jogadorO: Jogador, ): String {


    if(jogadorX.ativo == true){
        jogadorX.ativo = false
        jogadorO.ativo = true
        return "X"
    }
    jogadorX.ativo = true
    jogadorO.ativo = false

    return "O"
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GridButtons(jogadorX: Jogador, jogadorO: Jogador, ){

    var contadorPlacar by remember{
        mutableStateOf(false)
    }

    var jogadorAtual by remember {
        mutableStateOf("X" )
    }

    var StringJogador0 by remember {
        mutableStateOf("" )
    }
    var StringJogador1 by remember {
        mutableStateOf("")
    }
    var StringJogador2 by remember {
        mutableStateOf("")
    }
    var StringJogador3 by remember {
        mutableStateOf("")
    }
    var StringJogador4 by remember {
        mutableStateOf("")
    }

    var StringJogador5 by remember {
        mutableStateOf("")
    }
    var StringJogador6 by remember {
        mutableStateOf("")
    }
    var StringJogador7 by remember {
        mutableStateOf("")
    }
    var StringJogador8 by remember {
        mutableStateOf("")
    }

    var vencedor by remember {
        mutableStateOf("")
    }
    var contX by remember {
        mutableStateOf(0)
    }
    var contO by remember {
        mutableStateOf(0)
    }

    var posicaoOcupada by remember {
        mutableStateOf(
             arrayListOf("", "", "", "", "", "", "", "", "")
        )
    }
    var modifierCard = Modifier
        .padding(all = 10.dp)
        .border(
            width = 2.dp,
            color = Color.White,
            shape = RoundedCornerShape(5.dp)
        )
        .height(100.dp)
        .width(100.dp)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
            ){
       // (0..2).forEach{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
            , horizontalArrangement = Arrangement.SpaceAround
        ){

            Text(text = "X : $contX",
                fontSize = 18.sp,
                color = Color.White)
            Text(text = "O : $contO",
                fontSize = 18.sp,
                color = Color.White)



        }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray)
            , horizontalArrangement = Arrangement.SpaceAround
                    ){

            // card 0
                Card(

                    onClick = {
                        //fimDeJogo = verificaVencedor(vencedor)
                        if(vencedor == "" && StringJogador0 == "") {
                            StringJogador0 = selecionaJogador(jogadorX, jogadorO)
                            posicaoOcupada[0] = StringJogador0
                            vencedor = verificarFim(posicaoOcupada)
                            jogadorAtual = StringJogador0


                            if(jogadorAtual == "X"){
                                jogadorAtual ="O"
                            }else{
                                jogadorAtual = "X"
                            }
                        }


                    },
                        modifier = modifierCard
                        , backgroundColor =Color.Black

                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = StringJogador0,
                                fontSize = 24.sp,
                                color = Color.White)
                        }


                    }
                // card 1

                Card(
                    onClick = {

                        //fimDeJogo = verificaVencedor(vencedor)
                        if(vencedor == ""&& StringJogador1 == "") {
                            StringJogador1 = selecionaJogador(jogadorX, jogadorO)
                            posicaoOcupada[1] = StringJogador1
                            vencedor = verificarFim(posicaoOcupada)


                            if(jogadorAtual == "X"){
                                jogadorAtual ="O"
                            }else{
                                jogadorAtual = "X"
                            }
                        }

                    },
                    modifier = modifierCard
                    , backgroundColor =Color.Black

                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = StringJogador1,
                            fontSize = 24.sp,
                            color = Color.White)
                    }

                }

                // card 2

                Card(onClick = {
                    //fimDeJogo = verificaVencedor(vencedor)
                    if(vencedor == ""&& StringJogador2 == ""){
                        StringJogador2= selecionaJogador(jogadorX, jogadorO)
                        posicaoOcupada[2] = StringJogador2
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }

                    }


                },

                    modifier = modifierCard
                    , backgroundColor =Color.Black

                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = StringJogador2,
                            fontSize = 24.sp,
                            color = Color.White)
                    }
                }

                //ActionButton(jogadorX , jogadorO)

            }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
            , horizontalArrangement = Arrangement.SpaceAround
        ){

    // card 3
            Card(
                onClick = {
                    if(vencedor == ""&& StringJogador3 == "") {
                        //fimDeJogo = verificaVencedor(vencedor)
                        StringJogador3 = selecionaJogador(jogadorX, jogadorO)
                        jogadorAtual = StringJogador3
                        posicaoOcupada[3] = StringJogador3
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }

                },

                modifier = modifierCard
                , backgroundColor =Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = StringJogador3,
                        fontSize = 24.sp,
                        color = Color.White)
                }
            }
            // card 4

            Card(
                onClick = {
                    if(vencedor == ""&& StringJogador4 == "") {
                        //fimDeJogo = verificaVencedor(vencedor)
                        StringJogador4 = selecionaJogador(jogadorX, jogadorO)
                        jogadorAtual = StringJogador4
                        posicaoOcupada[4] = StringJogador4
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }

                },
                modifier = modifierCard
                , backgroundColor =Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = StringJogador4,
                        fontSize = 24.sp,
                        color = Color.White)
                }
            }

            // card 5

            Card(
                onClick = {
                    if(vencedor == ""&& StringJogador5 == "") {
                        //fimDeJogo = verificaVencedor(vencedor)
                        StringJogador5 = selecionaJogador(jogadorX, jogadorO)
                        jogadorAtual = StringJogador5
                        posicaoOcupada[5] = StringJogador5
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }

                },

                modifier = modifierCard
                , backgroundColor =Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = StringJogador5,
                        fontSize = 24.sp,
                        color = Color.White)
                }
            }

            //ActionButton(jogadorX , jogadorO)

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
            , horizontalArrangement = Arrangement.SpaceAround
        ) {

            // card 6
            Card(
                onClick = {
                    if(vencedor == ""&& StringJogador6 == "") {
                        //fimDeJogo = verificaVencedor(vencedor)
                        StringJogador6 = selecionaJogador(jogadorX, jogadorO)
                        jogadorAtual = StringJogador6
                        posicaoOcupada[6] = StringJogador6
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }
                },

                modifier = modifierCard, backgroundColor = Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = StringJogador6,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
            // card 7

            Card(
                onClick = {
                    if(vencedor == ""&& StringJogador7 == "") {
                        //fimDeJogo = verificaVencedor(vencedor)
                        StringJogador7 = selecionaJogador(jogadorX, jogadorO)
                        jogadorAtual = StringJogador7
                        posicaoOcupada[7] = StringJogador7
                        vencedor = verificarFim(posicaoOcupada)


                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }

                },
                modifier = modifierCard, backgroundColor = Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = StringJogador7,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }

            // card 8

            Card(
                onClick = {
                    //fimDeJogo = verificaVencedor(vencedor)
                    if(vencedor == ""&& StringJogador8 == "") {
                        StringJogador8 = selecionaJogador(jogadorX, jogadorO)
                        posicaoOcupada[8] = StringJogador8
                        vencedor = verificarFim(posicaoOcupada)

                        if(jogadorAtual == "X"){
                            jogadorAtual ="O"
                        }else{
                            jogadorAtual = "X"
                        }
                    }

                },

                modifier = modifierCard, backgroundColor = Color.Black

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = StringJogador8,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
            , horizontalArrangement = Arrangement.SpaceAround
        ){

            Text(text = "Jogador $jogadorAtual",
                fontSize = 28.sp,
                color = Color.White)

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
            , horizontalArrangement = Arrangement.SpaceAround
        ){
            if(vencedor != ""){

                if(vencedor == "X" && contadorPlacar == false){
                    contadorPlacar =true
                    contX ++
                }else if(vencedor == "O" && contadorPlacar == false){
                    contadorPlacar =true
                    contO ++
                }

                Text(text = "Vencedor = $vencedor",
                    fontSize = 28.sp,
                    color = Color.White)
            }
            }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
            , horizontalArrangement = Arrangement.SpaceAround
        ){
            if(vencedor != ""){
                Button(onClick = {
                    StringJogador0 = ""
                    StringJogador1 = ""
                    StringJogador2 = ""
                    StringJogador3 = ""
                    StringJogador4 = ""
                    StringJogador5 = ""
                    StringJogador6 = ""
                    StringJogador7 = ""
                    StringJogador8 = ""
                    posicaoOcupada.clear()
                    posicaoOcupada =  arrayListOf("", "", "", "", "", "", "", "", "")
                    contadorPlacar = false
                    vencedor = ""
                }) {
                    Text(text = "Jogar Novamente")
                }
                }
            }
        }

    }

fun reiniciarJogo(
    StringJogador0: String,
    StringJogador1: String,
    StringJogador2: String,
    StringJogador3: String,
    StringJogador4: String,
    StringJogador5: String,
    StringJogador6: String,
    StringJogador7: String,
    posicaoOcupada: ArrayList<String>
) {

}

fun verificaVencedor(vencedor : String): String {
    if(vencedor != ""){
        return "1"
    }
    return "0"
}

@Composable
fun exibirVencedor(){

}

fun verificarFim(posicaoOcupada : ArrayList<String> ): String {
    // verifica 1 linha
    if(
        posicaoOcupada[0] ==posicaoOcupada[1] && posicaoOcupada[0] == posicaoOcupada[2] && posicaoOcupada[0] == "X"
    ){

        return "X"
    }else if(  posicaoOcupada[0] ==posicaoOcupada[1] && posicaoOcupada[0] == posicaoOcupada[2] && posicaoOcupada[0] == "O"){
        return "O"
    }
     //linha 2
    else if(  posicaoOcupada[3] ==posicaoOcupada[4] && posicaoOcupada[3] == posicaoOcupada[5] && posicaoOcupada[3] == "X"){
        return "X"
    }
    else if(  posicaoOcupada[3] ==posicaoOcupada[4] && posicaoOcupada[3] == posicaoOcupada[5] && posicaoOcupada[3] == "O"){
        return "O"
    }

    else if(  posicaoOcupada[6] ==posicaoOcupada[7] && posicaoOcupada[6] == posicaoOcupada[8] && posicaoOcupada[6] == "X"){
        return "X"
    }
    else if(  posicaoOcupada[6] ==posicaoOcupada[7] && posicaoOcupada[6] == posicaoOcupada[8] && posicaoOcupada[6] == "O"){
        return "O"
    }
    // COLUNA1
    else if(  posicaoOcupada[0] ==posicaoOcupada[3] && posicaoOcupada[6] == posicaoOcupada[0] && posicaoOcupada[6] == "X"){
        return "X"
    }
    else if(   posicaoOcupada[0] ==posicaoOcupada[3] && posicaoOcupada[6] == posicaoOcupada[0] && posicaoOcupada[6] == "O"){
        return "O"
    }
    // COLUNA 2
    else if(  posicaoOcupada[1] ==posicaoOcupada[4] && posicaoOcupada[7] == posicaoOcupada[1] && posicaoOcupada[7] == "X"){
        return "X"
    }
    else if(   posicaoOcupada[1] ==posicaoOcupada[4] && posicaoOcupada[7] == posicaoOcupada[1] && posicaoOcupada[7]  == "O"){
        return "O"
    }
    // Coluna 3
    else if(  posicaoOcupada[2] ==posicaoOcupada[5] && posicaoOcupada[8] == posicaoOcupada[2] && posicaoOcupada[8] == "X"){
        return "X"
    }
    else if(   posicaoOcupada[2] ==posicaoOcupada[5] && posicaoOcupada[8] == posicaoOcupada[2] && posicaoOcupada[8]  == "O"){
        return "O"
    }
    // DIAGONAL
    else if(  posicaoOcupada[0] ==posicaoOcupada[4] && posicaoOcupada[8] == posicaoOcupada[0] && posicaoOcupada[8] == "X"){
        return "X"
    }
    else if(   posicaoOcupada[0] ==posicaoOcupada[4] && posicaoOcupada[8] == posicaoOcupada[0] && posicaoOcupada[8]  == "O"){
        return "O"
    }
    else if(  posicaoOcupada[2] ==posicaoOcupada[4] && posicaoOcupada[6] == posicaoOcupada[2] && posicaoOcupada[6] == "X"){
        return "X"
    }
    else if(  posicaoOcupada[2] ==posicaoOcupada[4] && posicaoOcupada[6] == posicaoOcupada[2] && posicaoOcupada[6]  == "O"){
        return "O"
    }



    return ""
}


fun selecionaJogador(jogadorX: Jogador, jogadorO: Jogador): String {

        if (jogadorX.ativo) {
            jogadorX.ativo = false
            jogadorO.ativo = true
            return "X"

        }
        jogadorX.ativo = true
        jogadorO.ativo = false
        return "O"


}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JogoDaVelhaTheme {
        MainContent()
    }
}